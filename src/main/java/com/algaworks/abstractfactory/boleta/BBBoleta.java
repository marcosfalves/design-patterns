package com.algaworks.abstractfactory.boleta;

import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public class BBBoleta implements Boleta{
    @Override
    public void emitir(Produto produto, BigDecimal valor) {
        System.out.println("----------------------------------");
        System.out.println("Emitindo Boleta no Banco do Brasil");
        System.out.println("Produto: " + produto.getDescricao());
        System.out.println("Valor..: " + valor);
        System.out.println("----------------------------------");
    }
}
