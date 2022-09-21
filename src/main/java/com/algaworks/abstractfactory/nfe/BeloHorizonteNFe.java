package com.algaworks.abstractfactory.nfe;

import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public class BeloHorizonteNFe implements NFe{
    @Override
    public BigDecimal gerar(Produto produto) {
        System.out.println("____________________________________________");
        System.out.println("Emitindo NFe para o estado de Belo Horizonte");
        System.out.println("               Imposto de 20%               ");
        System.out.println("____________________________________________");
        return produto.getValorTotal().multiply(new BigDecimal("0.20"));
    }
}
