package com.algaworks.builder.builder;

import com.algaworks.builder.model.NotaFiscal;
import com.algaworks.builder.model.Produto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NotaFiscalBuilder {
    private NotaFiscal instancia;

    public NotaFiscalBuilder() {
        this.instancia = new NotaFiscal();
    }

    public NotaFiscalBuilder comNumero(Long numero){
        this.instancia.setNumero(numero);
        return this;
    }

    public NotaFiscalBuilder comData(String dataEmissao){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.instancia.setDataEmissao(sdf.parse(dataEmissao));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data incorreto: " + dataEmissao + " " + e.getMessage());
        }
        return this;
    }

    public NotaFiscalBuilder comItem(String nome, Integer quantidade, String valor){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setValorUnitario(new BigDecimal(valor));

        if (instancia.getItens() == null) {
            instancia.setItens(new ArrayList<>());
        }
        instancia.getItens().add(produto);

        return this;
    }

    public NotaFiscal builder(){
        return this.instancia;
    }
}
