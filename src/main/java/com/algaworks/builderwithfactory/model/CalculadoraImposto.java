package com.algaworks.builderwithfactory.model;

import java.math.BigDecimal;

public interface CalculadoraImposto {
    BigDecimal calcularImposto(BigDecimal valorTotal);
}
