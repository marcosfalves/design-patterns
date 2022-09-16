package com.algaworks.factorymethod.lib;

import java.time.LocalDateTime;

public abstract class Logger {
    protected abstract LogPrinter createLogger();

    public void log(String message){
        createLogger().print(LocalDateTime.now() + " - " + message);
    }
}
