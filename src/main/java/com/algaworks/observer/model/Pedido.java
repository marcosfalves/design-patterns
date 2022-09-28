package com.algaworks.observer.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Pedido {
    private String descricao;
    private BigDecimal valor;

    public Pedido(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(descricao, pedido.descricao) && Objects.equals(valor, pedido.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, valor);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
