package com.algaworks.builderwithfactory.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class NotaFiscal {
    private Long numero;
    private Date dataEmissao;
    private List<Item> itens;

    protected abstract CalculadoraImposto criarCalculadoraImposto();

    public BigDecimal calcularValorTotal(){
        BigDecimal totalNotaFiscal = itens.stream().map(Item::getValorTotal).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
        BigDecimal valorImposto = criarCalculadoraImposto().calcularImposto(totalNotaFiscal);
        return totalNotaFiscal.subtract(valorImposto);
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaFiscal that = (NotaFiscal) o;
        return Objects.equals(numero, that.numero) && Objects.equals(dataEmissao, that.dataEmissao) && Objects.equals(itens, that.itens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, dataEmissao, itens);
    }

    @Override
    public String toString() {
        return "NotaFiscal{" +
                "numero=" + numero +
                ", dataEmissao=" + dataEmissao +
                ", itens=" + itens +
                '}';
    }
}
