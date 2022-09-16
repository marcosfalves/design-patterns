package com.algaworks.factorymethod.consolelog;

import com.algaworks.factorymethod.lib.LogPrinter;
import com.algaworks.factorymethod.lib.Logger;

public class ConsoleLogCreator extends Logger {
    @Override
    protected LogPrinter createLogger() {
        return new ConsoleLogPrinter();
    }
}
