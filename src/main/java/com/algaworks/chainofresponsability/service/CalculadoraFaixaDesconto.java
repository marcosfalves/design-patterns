package com.algaworks.chainofresponsability.service;

public abstract class CalculadoraFaixaDesconto {

    private final CalculadoraFaixaDesconto proximo;

    public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto proximo) {
        this.proximo = proximo;
    }

    public double desconto(double valorTotal){
        double desconto = this.calcular(valorTotal);

        if (desconto == -1)
            return proximo.desconto(valorTotal);

        return desconto;
    }

    protected abstract double calcular(double valorTotal);
}
