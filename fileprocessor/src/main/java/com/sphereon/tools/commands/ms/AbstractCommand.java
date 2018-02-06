package com.sphereon.tools.commands.ms;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractCommand implements Command {

    protected static final XLogger logger = XLoggerFactory.getXLogger(AbstractCommand.class);

    private ObjectMapper objectMapper = new ObjectMapper();
    private Configuration configuration;
    private List<File> inputFiles;
    private Iterator<File> inputFileIterator;
    private int fileCounter = 0;

    protected void generateGlobalConfiguration() throws JsonProcessingException {
        generateGlobalConfiguration("", "");
    }

    protected void generateGlobalConfiguration(String subDirectory, String prefix) throws JsonProcessingException {
        logger.info("** Begin of global configuration");
        Configuration configuration = new Configuration();
        configuration.setApiKey("enter Sphereon store api key");
        configuration.setImportDirectory("c:/fileprocessor/import");
        configuration.setExportDirectory("c:/fileprocessor/export");
        configuration.setSubdirectory(subDirectory);
        configuration.setPrefix(prefix);
        String json = getObjectMapper().writeValueAsString(configuration);
        logger.info("Content : " + json);
        logger.info("** end of global configuration");
        logger.info("Copy/paste json text after 'Content :' to a file");
        logger.info("");
    }

    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    protected Configuration applyConfiguration(File configurationFile) throws Exception {
        if (configuration == null) {
            this.configuration = getObjectMapper().readValue(configurationFile, Configuration.class);
            this.inputFiles = readDirectory();
            this.inputFileIterator = inputFiles.iterator();
        }
        return this.configuration;
    }

    private List<File> readDirectory() throws Exception {
        String importDirectoryLocation = configuration.getImportDirectory();
        File importDirectory = new File(importDirectoryLocation);

        if (importDirectory.isDirectory()) {
            List<File> files = Arrays.asList(importDirectory.listFiles());
            logger.info(String.format("Processing #%d files found in directory %s", files.size(), importDirectoryLocation));
            return files;
        } else {
            throw new Exception(String.format("Import location %s is not a directory or does not exist", importDirectoryLocation));
        }
    }


    protected boolean hasFile() {
        return inputFileIterator.hasNext();
    }

    protected File nextFile() {
        File nextFile = inputFileIterator.next();
        logger.info(String.format("Processing file #%d %s", ++fileCounter, nextFile.getAbsolutePath()));
        return nextFile;
    }

    protected void writeToOutputDirectory(String outputFileName, byte[] content) throws IOException {
        Path outputPath = Paths.get(configuration.getExportDirectory(), configuration.getSubdirectory());
        FileUtils.forceMkdir(outputPath.toFile());

        Path outputFile = Paths.get(outputPath.toString(), configuration.getPrefix() + outputFileName);
        FileUtils.writeByteArrayToFile(outputFile.toFile(), content);
    }
}
