package com.algaworks.builderwithfactory.model;

public class NotaFiscalPessoaJuridica extends NotaFiscal{
    @Override
    protected CalculadoraImposto criarCalculadoraImposto() {
        return new CalculadoraPessoaJuridica();
    }
}
