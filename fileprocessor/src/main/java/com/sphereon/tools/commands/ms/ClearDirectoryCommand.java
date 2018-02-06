package com.sphereon.tools.commands.ms;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;

public class ClearDirectoryCommand extends AbstractCommand {

    @Override
    public void generate() {
        throw new NotImplementedException();
    }

    @Override
    public void execute(File globalSettings, File commandSettings) throws Exception {
        Configuration configuration = applyConfiguration(globalSettings);
        while (hasFile()) {
            File inputFile = nextFile();
            if (inputFile.exists()) {
                logger.info(String.format("Deleting file %s", inputFile.getAbsolutePath()));
                inputFile.delete();
            }
        }
    }
}
