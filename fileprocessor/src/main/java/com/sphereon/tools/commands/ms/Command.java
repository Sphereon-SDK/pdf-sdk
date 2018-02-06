package com.sphereon.tools.commands.ms;

import java.io.File;

public interface Command {

    void generate();

    void generateAll();

    void execute(File globalSettings, File commandSettings, int timeout) throws Exception;
}
