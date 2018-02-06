package com.sphereon.tools.commands.ms;

import java.io.File;

public interface Command {
    void generate();

    void execute(File globalSettings, File commandSettings) throws Exception;
}
