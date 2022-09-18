package com.algaworks.builderwithfactory;

import com.algaworks.builderwithfactory.builder.NotaFiscalBuilder;
import com.algaworks.builderwithfactory.model.NotaFiscal;

import java.math.BigDecimal;

public class Using {
    public static void main(String[] args) {
        NotaFiscal notaFiscalPF = new NotaFiscalBuilder().criarNotaFiscalPessoaFisica()
                .comData("15/09/2022")
                .comNumero(45699L)
                .comItem("Calculadora", 1, "5.99")
                .comItem("Caneta Azul", 2, "1.99")
                .builder();

        NotaFiscal notaFiscalPJ = new NotaFiscalBuilder().criarNotaFiscalPessoaJuridica()
                .comData("15/09/2022")
                .comNumero(45699L)
                .comItem("Calculadora", 1, 5.99)
                .comItem("Caneta Azul", 2, "1.99")
                .builder();

        BigDecimal valorTotalPF = notaFiscalPF.calcularValorTotal();
        BigDecimal valorTotalPJ = notaFiscalPJ.calcularValorTotal();

        System.out.println("Valor total pessoa física: " + valorTotalPF);
        System.out.println("Valor total pessoa jurídica: " + valorTotalPJ);


    }
}
