package com.algaworks.builderwithfactory.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private String nome;
    private Integer quantidade;
    private BigDecimal valorUnitario;

    public BigDecimal getValorTotal(){
        return valorUnitario.multiply(new BigDecimal(quantidade));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        Item item = (Item) o;
        return Objects.equals(nome, item.nome) && Objects.equals(quantidade, item.quantidade) && Objects.equals(valorUnitario, item.valorUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, quantidade, valorUnitario);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                '}';
    }
}
