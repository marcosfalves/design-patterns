package com.algaworks.abstractfactory.produto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Produto {
    private String descricao;
    private Integer quantidade;
    private BigDecimal valorUnitario;

    public Produto() {
    }

    public Produto(String descricao, Integer quantidade, BigDecimal valorUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal(){
        return new BigDecimal(quantidade).multiply(valorUnitario).setScale(2, RoundingMode.HALF_DOWN);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(descricao, produto.descricao) && Objects.equals(quantidade, produto.quantidade) && Objects.equals(valorUnitario, produto.valorUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, quantidade, valorUnitario);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
