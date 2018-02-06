package com.sphereon.tools.commands.ms.pdf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sphereon.sdk.pdf.api.Conversion2PDFApi;
import com.sphereon.sdk.pdf.handler.ApiException;
import com.sphereon.sdk.pdf.model.*;
import com.sphereon.tools.commands.ms.AbstractCommand;
import com.sphereon.tools.commands.ms.Configuration;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class PDFMSCommand extends AbstractCommand {

    @Override
    public void generate() {
        try {
            logger.info("Generation of default configurations");
            generateGlobalConfiguration();


            logger.info("** Begin of pdf settings");
            String json = getJson(ConversionSettings.VersionEnum._1_7);
            logger.info("Content : " + json);
            logger.info("** end of pdf settings");
            logger.info("Copy/paste json text after 'Content :' to a file");
            logger.info("");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void generateAll() throws JsonProcessingException {
        Path tempPath = getTempPath();

        for (ConversionSettings.VersionEnum versionEnum : ConversionSettings.VersionEnum.values()) {
            String pdfSettingsJson = getJson(versionEnum);

        }

    }

    @Override
    public void execute(File configurationFile, File pdfSettingsFile, int timeout) throws Exception {
        Configuration configuration = applyConfiguration(configurationFile);

        ConversionSettings pdfConfiguration = getPDFConfiguration(pdfSettingsFile);

        while (hasFile()) {
            File inputfile = nextFile();
            byte[] content = convertToPDF(configuration, pdfConfiguration, inputfile, timeout);
            String extension = "pdf";
            ResultSettings result = pdfConfiguration.getResult();
            if (result != null && result.getFileFormat() != null) {
                extension = result.getFileFormat().toString().toLowerCase();
            }

            String outputFileName = FilenameUtils.getBaseName(inputfile.getAbsolutePath()) + "." + extension;
            writeToOutputDirectory(outputFileName, content);
        }
    }


    private byte[] convertToPDF(Configuration configuration, ConversionSettings pdfConfiguration, File inputfile, int timeout) throws ApiException, IOException, InterruptedException {
        logger.info("Create job");
        Conversion2PDFApi conversion2PDFApi = new Conversion2PDFApi();
        conversion2PDFApi.getApiClient().setAccessToken(configuration.getApiKey());

        ConversionJobResponse conversionJobResponse = conversion2PDFApi.createJob(pdfConfiguration);
        String jobId = conversionJobResponse.getJobId();
        ConversionJob job = conversionJobResponse.getJob();
        logger.info(String.format("Job created with id %s", jobId));


        logger.info(String.format("Add input file %s", inputfile.getAbsolutePath()));
        conversionJobResponse = conversion2PDFApi.addInputFile(jobId, inputfile, FilenameUtils.getBaseName(inputfile.getAbsolutePath()));
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));

        logger.info(String.format("Input file %s added", inputfile.getAbsolutePath()));

        logger.info(String.format("Submit job with id %s", jobId));
        conversionJobResponse = conversion2PDFApi.submitJob(jobId, job);
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));
        logger.info(String.format("Job submitted with id %s", jobId));


        int retry = timeout;
        do {
            conversionJobResponse = conversion2PDFApi.getJob(jobId);
            if (!done(conversionJobResponse)) {
                logger.info(String.format("Waiting for completion of job submitted with id %s, status : %s, retry : %d", jobId, conversionJobResponse.getStatus(), retry));
                Thread.sleep(1000);
            }
            retry--;
        } while (!done(conversionJobResponse) && retry > 0);

        logger.info(String.format("Job submitted with id %s is %s", jobId, conversionJobResponse.getStatus()));

        logger.info(String.format("Get result of job with id %s", jobId));
        byte[] stream = conversion2PDFApi.getStream(jobId);

        logger.info(String.format("Delete job with id %s", jobId));
        try {
            conversionJobResponse = conversion2PDFApi.deleteJob(jobId);
            logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));
            logger.info(String.format("Job deleted with id %s", jobId));
        } catch (ApiException e) {
            // do nothing
        }

        return stream;
    }

    private boolean done(ConversionJobResponse conversionJobResponse) {
        return ConversionJobResponse.StatusEnum.DONE.equals(conversionJobResponse.getStatus()) || ConversionJobResponse.StatusEnum.ERROR.equals(conversionJobResponse.getStatus());
    }

    protected ConversionSettings getPDFConfiguration(File pdfSettingsFile) throws IOException {
        return getObjectMapper().readValue(pdfSettingsFile, ConversionSettings.class);
    }

    private String getJson(ConversionSettings.VersionEnum version) throws JsonProcessingException {
        ConversionSettings conversionSettings = new ConversionSettings();
        conversionSettings.setContainerConversion(ConversionSettings.ContainerConversionEnum.ALL);
        conversionSettings.setEngine(ConversionSettings.EngineEnum.PREMIUM);
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
        resultSettings.setFileFormat(ResultSettings.FileFormatEnum.PDF);
        conversionSettings.setResult(resultSettings);
        return getObjectMapper().writeValueAsString(conversionSettings);
    }

}
