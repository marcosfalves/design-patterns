package com.algaworks.factorymethod;

import com.algaworks.factorymethod.lib.Logger;

public class TaxCalculator {
    private Logger logger;

    public TaxCalculator(Logger logger) {
        this.logger = logger;
    }

    public void calculate(double value){
        //calculation logic would be here

        //the end, log the value calculated
        logger.log("Tax calculate for the value R$ " + value);
    }
}
