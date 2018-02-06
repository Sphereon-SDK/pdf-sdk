package com.sphereon.tools;

import com.sphereon.tools.commands.ms.ClearDirectoryCommand;
import com.sphereon.tools.commands.ms.pdf.PDFMSCommand;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import static java.util.Arrays.asList;

public class FileProcessor {
    protected static final XLogger logger = XLoggerFactory.getXLogger(FileProcessor.class);

    public static void main(String[] args) throws Exception {
        OptionParser parser = new OptionParser() {
            {
                acceptsAll(asList("h", "?", "help"), "show help (this screen)").forHelp();
                acceptsAll(asList("job-timeout"), "Number of seconds to wait for job completion").withRequiredArg().ofType(Integer.class);
                acceptsAll(asList("c", "conf", "configuration"), "Location of the global configuration").withRequiredArg().ofType(File.class).describedAs("File path to global configuration file");
                acceptsAll(asList("clear-input-folder"), "Clear input folder afterwards");
                acceptsAll(asList("generate-pdf-settings"), "Generate pdf settings");
                acceptsAll(asList("pdf"), "Perform pdf conversion");
                acceptsAll(asList("pdf-settings"), "PDF Settings").requiredIf("pdf").withRequiredArg().ofType(File.class);
            }
        };
        OptionSet options = null;
        try {
            options = parser.parse(args);

            if (!options.hasOptions()) {
                throw new Exception("No options");
            }
        } catch (Exception e) {
            printUsage(parser, "", 1);
        }

        if (options.has("generate-pdf-settings")) {
            PDFMSCommand PDFMSCommand = new PDFMSCommand();
            PDFMSCommand.generate();
        }

        int timeout = 90;
        if (options.has("job-timeout")) {
            timeout = (int) options.valueOf("job-timeout");
        }

        if (options.has("configuration") && options.has("pdf") && options.has("pdf-settings")) {
            File configuration = (File) options.valueOf("configuration");
            File pdfSettings = (File) options.valueOf("pdf-settings");
            PDFMSCommand PDFMSCommand = new PDFMSCommand();
            PDFMSCommand.execute(configuration, pdfSettings, timeout);
        }

        if (options.has("configuration") && options.has("clear-input-folder")) {
            File configuration = (File) options.valueOf("configuration");
            ClearDirectoryCommand clearDirectoryCommand = new ClearDirectoryCommand();
            clearDirectoryCommand.execute(configuration, null, timeout);
        }
    }

    private static void printHeader() {
        logger.info("Sphereon File Processor");
        logger.info("Sphereon B.V.");
        logger.info("");
    }

    private static void printUsage(OptionParser parser, String message, Integer exitCode) throws IOException {
        try {
            printHeader();
            if (message != null) {
                logger.error(message);
            }
            StringWriter sink = new StringWriter();
            parser.printHelpOn(sink);
            logger.info("\nUsage\n" + sink.toString());
        } finally {
            if (exitCode != null) {
                System.exit(exitCode);
            }
        }
    }

}
