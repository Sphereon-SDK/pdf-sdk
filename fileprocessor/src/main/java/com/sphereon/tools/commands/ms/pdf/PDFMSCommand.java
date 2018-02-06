package com.sphereon.tools.commands.ms.pdf;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sphereon.sdk.pdf.api.ConversionPDFApi;
import com.sphereon.sdk.pdf.handler.ApiException;
import com.sphereon.sdk.pdf.model.*;
import com.sphereon.tools.commands.ms.AbstractCommand;
import com.sphereon.tools.commands.ms.Configuration;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

public class PDFMSCommand extends AbstractCommand {

    @Override
    public void generate() {
        try {
            logger.info("Generation of default configurations");
            generateGlobalConfiguration();


            logger.info("** Begin of pdf settings");
            ConversionSettings conversionSettings = new ConversionSettings();
            conversionSettings.setContainerConversion(ConversionSettings.ContainerConversionEnum.ALL);
            conversionSettings.setEngine(ConversionSettings.EngineEnum.PREMIUM);
            CSVSettings csvSettings = new CSVSettings();
            csvSettings.setSeparatorCharacter(CSVSettings.SeparatorCharacterEnum.COMMA);
            conversionSettings.setCsv(csvSettings);
            conversionSettings.setOcrMode(ConversionSettings.OcrModeEnum.AUTO);
            conversionSettings.setQualityFactor(100);
            conversionSettings.setVersion(ConversionSettings.VersionEnum._1_7);
            ResultSettings resultSettings = new ResultSettings();
            Compression compression = new Compression();
            compression.setLevel(100);
            compression.setType(Compression.TypeEnum.ADVANCED);
            resultSettings.setCompression(compression);
            resultSettings.setFileFormat(ResultSettings.FileFormatEnum.PDF);
            conversionSettings.setResult(resultSettings);
            String json = getObjectMapper().writeValueAsString(conversionSettings);
            logger.info("Content : " + json);
            logger.info("** end of pdf settings");
            logger.info("Copy/paste json text after 'Content :' to a file");
            logger.info("");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute(File configurationFile, File pdfSettingsFile) throws Exception {
        Configuration configuration = applyConfiguration(configurationFile);

        ConversionSettings pdfConfiguration = getPDFConfiguration(pdfSettingsFile);

        while (hasFile()) {
            File inputfile = nextFile();
            byte[] content = convertToPDF(configuration, pdfConfiguration, inputfile);
            String extension = "pdf";
            ResultSettings result = pdfConfiguration.getResult();
            if (result != null && result.getFileFormat() != null) {
                extension = result.getFileFormat().toString().toLowerCase();
            }

            String outputFileName = FilenameUtils.getBaseName(inputfile.getAbsolutePath()) + "." + extension;
            writeToOutputDirectory(outputFileName, content);
        }
    }


    private byte[] convertToPDF(Configuration configuration, ConversionSettings pdfConfiguration, File inputfile) throws ApiException, IOException {
        logger.info("Create job");
        ConversionPDFApi conversionPDFApi = new ConversionPDFApi();
        conversionPDFApi.getApiClient().setAccessToken(configuration.getApiKey());

        ConversionJobResponse conversionJobResponse = conversionPDFApi.createJob(pdfConfiguration);
        String jobId = conversionJobResponse.getJobId();
        ConversionJob job = conversionJobResponse.getJob();
        logger.info(String.format("Job created with id %s", jobId));


        logger.info(String.format("Add input file %s", inputfile.getAbsolutePath()));
        conversionJobResponse = conversionPDFApi.addInputFile(jobId, inputfile);
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));

        logger.info(String.format("Input file %s added", inputfile.getAbsolutePath()));

        logger.info(String.format("Submit job with id %s", jobId));
        conversionJobResponse = conversionPDFApi.submitJob(jobId, job);
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));
        logger.info(String.format("Job submitted with id %s", jobId));

        logger.info(String.format("Get result of job with id %s", jobId));
        byte[] stream = conversionPDFApi.getStream(jobId);

        logger.info(String.format("Delete job with id %s", jobId));
        conversionJobResponse = conversionPDFApi.deleteJob(jobId);
        logger.info(String.format("Status=%s", conversionJobResponse.getStatus()));
        logger.info(String.format("Job deleted with id %s", jobId));


        return stream;


    }

    protected ConversionSettings getPDFConfiguration(File pdfSettingsFile) throws IOException {
        return getObjectMapper().readValue(pdfSettingsFile, ConversionSettings.class);
    }


}
