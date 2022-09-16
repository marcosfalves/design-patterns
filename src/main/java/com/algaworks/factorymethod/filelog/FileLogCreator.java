package com.algaworks.factorymethod.filelog;

import com.algaworks.factorymethod.lib.LogPrinter;
import com.algaworks.factorymethod.lib.Logger;

public class FileLogCreator extends Logger {
    private String fileName;

    public FileLogCreator(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected LogPrinter createLogger() {
        return new FileLogPrinter(fileName);
    }
}
