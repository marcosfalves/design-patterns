package com.algaworks.abstractfactory.boleta;

import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public interface Boleta {
    void emitir(Produto produto, BigDecimal valor);
}
