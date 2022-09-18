package com.algaworks.builderwithfactory.model;

public class NotaFiscalPessoaFisica extends NotaFiscal {
    @Override
    protected CalculadoraImposto criarCalculadoraImposto() {
        return new CalculadoraPessoaFisica();
    }
}
