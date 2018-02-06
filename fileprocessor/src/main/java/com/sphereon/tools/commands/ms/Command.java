package com.sphereon.tools.commands.ms;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;

public interface Command {

    void generate();

    void generateAll() throws JsonProcessingException;

    void execute(File globalSettings, File commandSettings, int timeout) throws Exception;
}
