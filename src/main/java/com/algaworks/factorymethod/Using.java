package com.algaworks.factorymethod;

import com.algaworks.factorymethod.consolelog.ConsoleLogCreator;
import com.algaworks.factorymethod.filelog.FileLogCreator;

public class Using {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator(new ConsoleLogCreator());
        taxCalculator.calculate(1_000);

        taxCalculator = new TaxCalculator(new FileLogCreator("log_tax.txt"));
        taxCalculator.calculate(2_000);
    }
}
