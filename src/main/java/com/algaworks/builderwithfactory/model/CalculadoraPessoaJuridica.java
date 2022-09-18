package com.algaworks.builderwithfactory.model;

import java.math.BigDecimal;

public class CalculadoraPessoaJuridica implements CalculadoraImposto {
    @Override
    public BigDecimal calcularImposto(BigDecimal valorTotal) {
        return valorTotal.multiply(new BigDecimal("0.04")).setScale(2, BigDecimal.ROUND_DOWN);
    }
}
