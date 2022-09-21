package com.algaworks.abstractfactory.nfe;

import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public interface NFe {
    BigDecimal gerar(Produto produto);
}
