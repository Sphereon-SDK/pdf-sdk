package com.sphereon.tools.commands.ms;

import java.io.File;
import java.io.IOException;

public interface Command {

    void generate();

    void generateAll(String apiKey) throws IOException;

    void execute(File globalSettings, File commandSettings, int timeout) throws Exception;
}
