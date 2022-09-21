package com.algaworks.abstractfactory;

import com.algaworks.abstractfactory.loja.LojaFactory;
import com.algaworks.abstractfactory.loja.Venda;
import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public class Using {
    public static void main(String[] args) {
        Produto produto = new Produto("NoteBook DELL", 1, new BigDecimal("1999.00"));
        Venda venda = new Venda(new LojaFactory());
        venda.realizar(produto);
    }
}
