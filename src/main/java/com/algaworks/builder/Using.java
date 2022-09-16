package com.algaworks.builder;

import com.algaworks.builder.builder.NotaFiscalBuilder;
import com.algaworks.builder.model.NotaFiscal;

public class Using {
    public static void main(String[] args) {
        NotaFiscal notaFiscal = new NotaFiscalBuilder()
                .comData("15/09/2022")
                .comNumero(15999L)
                .comItem("Calculadora", 1, "5.99")
                .comItem("Caneta Azul", 2, "1.99")
                .builder();

        System.out.println(notaFiscal);
    }
}
