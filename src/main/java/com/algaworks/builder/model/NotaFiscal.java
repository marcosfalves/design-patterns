package com.algaworks.builder.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NotaFiscal {
    Long numero;
    Date dataEmissao;
    List<Produto> itens;

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

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
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
