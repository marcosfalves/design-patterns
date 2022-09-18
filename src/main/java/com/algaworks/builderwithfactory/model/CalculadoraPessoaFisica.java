package com.algaworks.builderwithfactory.model;

import java.math.BigDecimal;

public class CalculadoraPessoaFisica implements CalculadoraImposto {
    @Override
    public BigDecimal calcularImposto(BigDecimal valorTotal) {
        return valorTotal.multiply(new BigDecimal("0.07")).setScale(2, BigDecimal.ROUND_DOWN);
    }
}
