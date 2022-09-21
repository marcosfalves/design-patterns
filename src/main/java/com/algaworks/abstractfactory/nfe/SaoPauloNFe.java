package com.algaworks.abstractfactory.nfe;

import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public class SaoPauloNFe implements NFe{
    @Override
    public BigDecimal gerar(Produto produto) {
        System.out.println("_______________________________________");
        System.out.println("Emitindo NFe para o estado de São Paulo");
        System.out.println("             Imposto de 17%            ");
        System.out.println("_______________________________________");
        return produto.getValorTotal().multiply(new BigDecimal("0.17"));
    }
}
