package com.algaworks.factorymethod.filelog;

import com.algaworks.factorymethod.lib.LogPrinter;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileLogPrinter implements LogPrinter {
    private static String PATH_FILE_LOG = "./src/main/java/com/algaworks/factorymethod/filelog/";
    private final PrintStream writer;

    public FileLogPrinter(String fileName)  {
        try {
            writer = new PrintStream(PATH_FILE_LOG + fileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found." + fileName + e.getMessage());
        }
    }

    @Override
    public void print(String message) {
        writer.println(message);
    }
}
