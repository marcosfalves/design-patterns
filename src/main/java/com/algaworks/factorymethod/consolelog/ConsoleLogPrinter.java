package com.algaworks.factorymethod.consolelog;

import com.algaworks.factorymethod.lib.LogPrinter;

public class ConsoleLogPrinter implements LogPrinter {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
