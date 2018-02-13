package com.sphereon.tools.commands.ms.pdf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sphereon.sdk.pdf.api.Conversion2PDFApi;
import com.sphereon.sdk.pdf.handler.ApiException;
import com.sphereon.sdk.pdf.model.*;
import com.sphereon.tools.commands.ms.AbstractCommand;
import com.sphereon.tools.commands.ms.Configuration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PDFMSCommand extends AbstractCommand {

    @Override
    public void generate() {
        try {
            logger.info("Generation of default configurations");
            generateGlobalConfiguration();


            logger.info("** Begin of pdf settings");
            String json = getJson(ConversionSettings.VersionEnum._1_7, ResultSettings.FileFormatEnum.PDF, ConversionSettings.EngineEnum.ADVANCED);
            logger.info("Content : " + json);
            logger.info("** end of pdf settings");
            logger.info("Copy/paste json text after 'Content :' to a file");
            logger.info("");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void generateAll(String apiKey) throws IOException {
        Path tempPath = getTempPath();

        Path settingsPath = Paths.get(tempPath.toString(), "settings");

        StringBuffer sb = new StringBuffer();

        for (ConversionSettings.EngineEnum engineEnum : ConversionSettings.EngineEnum.values()) {

            for (ConversionSettings.VersionEnum versionEnum : ConversionSettings.VersionEnum.values()) {
                String pdfSettingsJson = getJson(versionEnum, ResultSettings.FileFormatEnum.PDF, engineEnum);
                String prefix = versionEnum.toString().toLowerCase();
                sb = createOutput(engineEnum, apiKey, settingsPath, sb, prefix, pdfSettingsJson, engineEnum.toString().toLowerCase() + "_pdf");
            }

            String pdfSettingsJson = getJson(null, ResultSettings.FileFormatEnum.DOCX, engineEnum);
            sb = createOutput(engineEnum, apiKey, settingsPath, sb, "docx", pdfSettingsJson, engineEnum.toString().toLowerCase() + "_docx");

            pdfSettingsJson = getJson(null, ResultSettings.FileFormatEnum.TIFF, engineEnum);
            sb = createOutput(engineEnum, apiKey, settingsPath, sb, "tiff", pdfSettingsJson, engineEnum.toString().toLowerCase() + "_tiff");

            pdfSettingsJson = getJson(null, ResultSettings.FileFormatEnum.XLSX, engineEnum);
            sb = createOutput(engineEnum, apiKey, settingsPath, sb, "xlsx", pdfSettingsJson, engineEnum.toString().toLowerCase() + "_xlsx");
        }
        Path commandFilePath = Paths.get(tempPath.toString(), "ExecuteConfigs.cmd");
        logger.info(String.format("Create command file %s", commandFilePath.toString()));
        FileUtils.writeStringToFile(commandFilePath.toFile(), sb.toString(), Charset.defaultCharset());
    }

    private StringBuffer createOutput(ConversionSettings.EngineEnum engineEnum, String apiKey, Path settingsPath, StringBuffer sb, String prefix, String pdfSettingsJson, String subDirectory) throws IOException {
        ;
        Path pdfSetting = Paths.get(settingsPath.toString(), engineEnum.toString().toLowerCase() + "_pdfSetting" + prefix + ".json");
        logger.info(String.format("Create pdf setting file %s", pdfSetting.toString()));
        FileUtils.writeStringToFile(pdfSetting.toFile(), pdfSettingsJson, Charset.defaultCharset());

        String globalJson = getGlobalJson(subDirectory, prefix, apiKey);
        Path globalSetting = Paths.get(settingsPath.toString(), engineEnum.toString().toLowerCase() + "_globalSetting" + prefix + ".json");
        logger.info(String.format("Create global setting file %s", globalSetting.toString()));
        FileUtils.writeStringToFile(globalSetting.toFile(), globalJson, Charset.defaultCharset());

        sb.append(String.format("call FileProcessor.cmd --configuration settings/%s --pdf --pdf-settings settings/%s --job-timeout 1000\n", globalSetting.getFileName().toString(), pdfSetting.getFileName().toString()));
        return sb;
    }

    @Override
    public void execute(File configurationFile, File pdfSettingsFile, int timeout) throws Exception {
        Configuration configuration = applyConfiguration(configurationFile);

        ConversionSettings pdfConfiguration = getPDFConfiguration(pdfSettingsFile);

        logger.info(String.format("Using global configuration %s and pdf configuration %s", configurationFile.getName(), pdfSettingsFile.getName()));
        while (hasFile()) {
            File inputfile = nextFile();
            Result result = convertToPDF(configuration, pdfConfiguration, inputfile, timeout);
            String extension = "pdf";
            ResultSettings resultSettings = pdfConfiguration.getResult();
            if (resultSettings != null && resultSettings.getFileFormat() != null) {
                extension = resultSettings.getFileFormat().toString().toLowerCase();
            }

            String outputFileName = FilenameUtils.getBaseName(inputfile.getAbsolutePath()) + "." + extension;
            writeToOutputDirectory(inputfile, outputFileName, result);
        }
    }


    private Result convertToPDF(Configuration configuration, ConversionSettings pdfConfiguration, File inputfile, int timeout) throws ApiException, IOException, InterruptedException {
        logger.info("Create job");
        Conversion2PDFApi conversion2PDFApi = new Conversion2PDFApi();
        conversion2PDFApi.getApiClient().setAccessToken(configuration.getApiKey());

        ConversionJobResponse conversionJobResponse = conversion2PDFApi.createJob(pdfConfiguration);
        String jobId = conversionJobResponse.getJobId();
        ConversionJob job = conversionJobResponse.getJob();
        logger.info(String.format("Job created with id %s", jobId));


        logger.info(String.format("Add input file %s", inputfile.getAbsolutePath()));
        String filename = FilenameUtils.getBaseName(inputfile.getAbsolutePath()) + "." + FilenameUtils.getExtension(inputfile.getAbsolutePath());
        conversionJobResponse = conversion2PDFApi.addInputFile(jobId, inputfile, filename);
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));

        logger.info(String.format("Input file %s added", inputfile.getAbsolutePath()));

        logger.info(String.format("Submit job with id %s", jobId));
        conversionJobResponse = conversion2PDFApi.submitJob(jobId, job);
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));
        logger.info(String.format("Job submitted with id %s", jobId));


        int countdownn = timeout;
        do {
            conversionJobResponse = conversion2PDFApi.getJob(jobId);
            if (!done(conversionJobResponse)) {
                logger.info(String.format("Waiting for completion of job submitted with id %s, status : %s, countdown : %d", jobId, conversionJobResponse.getStatus(), countdownn));
                Thread.sleep(1000);
            }
            countdownn--;
        } while (!done(conversionJobResponse) && countdownn > 0);

        logger.info(String.format("Job submitted with id %s is %s", jobId, conversionJobResponse.getStatus()));

        Result result = new Result();
        result.setStatus(conversionJobResponse.getStatus());
        result.setMessage(conversionJobResponse.getStatusMessage());

        if (ConversionJobResponse.StatusEnum.DONE.equals(result.getStatus())) {
            logger.info(String.format("Get result of job with id %s", jobId));
            byte[] stream = conversion2PDFApi.getStream(jobId);

            result.setStream(stream);
        } else {
            logger.error("Error occurred : " + result.getStatusMessage());
        }

        logger.info(String.format("Delete job with id %s", jobId));
        try {
            conversionJobResponse = conversion2PDFApi.deleteJob(jobId);
            logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));
            logger.info(String.format("Job deleted with id %s", jobId));
        } catch (ApiException e) {
            // do nothing
        }

        return result;
    }

    private boolean done(ConversionJobResponse conversionJobResponse) {
        return ConversionJobResponse.StatusEnum.DONE.equals(conversionJobResponse.getStatus()) || ConversionJobResponse.StatusEnum.ERROR.equals(conversionJobResponse.getStatus());
    }

    protected ConversionSettings getPDFConfiguration(File pdfSettingsFile) throws IOException {
        return getObjectMapper().readValue(pdfSettingsFile, ConversionSettings.class);
    }

    private String getJson(ConversionSettings.VersionEnum version, ResultSettings.FileFormatEnum fileFormat, ConversionSettings.EngineEnum engine) throws JsonProcessingException {
        ConversionSettings conversionSettings = new ConversionSettings();
        conversionSettings.setContainerConversion(ConversionSettings.ContainerConversionEnum.ALL);
        conversionSettings.setEngine(engine);
        CSVSettings csvSettings = new CSVSettings();
        csvSettings.setSeparatorCharacter(CSVSettings.SeparatorCharacterEnum.COMMA);
        conversionSettings.setCsv(csvSettings);
        conversionSettings.setOcrMode(ConversionSettings.OcrModeEnum.AUTO);
        conversionSettings.setQualityFactor(100);
        conversionSettings.setVersion(version);
        ResultSettings resultSettings = new ResultSettings();
        Compression compression = new Compression();
        compression.setLevel(100);
        compression.setType(Compression.TypeEnum.ADVANCED);
        resultSettings.setCompression(compression);
        resultSettings.setFileFormat(fileFormat);
        conversionSettings.setResult(resultSettings);
        return getObjectMapper().writeValueAsString(conversionSettings);
    }

}
