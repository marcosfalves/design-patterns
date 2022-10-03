package com.algaworks.chainofresponsability;

import com.algaworks.chainofresponsability.service.*;

public class Using {
    public static void main(String[] args) {
        CalculadoraFaixaDesconto calculadoraDesconto = new CalculadoraDescontoTerceiraFaixa(
                new CalculadoraDescontoSegundaFaixa(
                        new CalculadoraDescontoPrimeiraFaixa(
                                new SemDesconto(null)
                        )
                )
        );

        double desconto;

        desconto = calculadoraDesconto.desconto(2_000.00);
        System.out.println("Desconto Terceira faixa: " + desconto);

        desconto = calculadoraDesconto.desconto(900.00);
        System.out.println("Desconto Segunda faixa: " + desconto);

        desconto = calculadoraDesconto.desconto(400.00);
        System.out.println("Desconto Primeira faixa: " + desconto);

        desconto = calculadoraDesconto.desconto(200.00);
        System.out.println("Sem Desconto: " + desconto);
    }
}
