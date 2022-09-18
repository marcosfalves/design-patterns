package com.algaworks.builderwithfactory.builder;

import com.algaworks.builderwithfactory.model.NotaFiscal;
import com.algaworks.builderwithfactory.model.Item;
import com.algaworks.builderwithfactory.model.NotaFiscalPessoaFisica;
import com.algaworks.builderwithfactory.model.NotaFiscalPessoaJuridica;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NotaFiscalBuilder {
    private NotaFiscal instancia;

    public NotaFiscalBuilder criarNotaFiscalPessoaFisica(){
        this.instancia = new NotaFiscalPessoaFisica();
        return this;
    }

    public NotaFiscalBuilder criarNotaFiscalPessoaJuridica(){
        this.instancia = new NotaFiscalPessoaJuridica();
        return this;
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
        this.adicionaritem(nome, quantidade, new BigDecimal(valor));
        return this;
    }

    public NotaFiscalBuilder comItem(String nome, Integer quantidade, double valor){
        this.adicionaritem(nome, quantidade, new BigDecimal(valor).setScale(2, BigDecimal.ROUND_DOWN));
        return this;
    }

    private void adicionaritem(String nome, Integer quantidade, BigDecimal valor){
        Item item = new Item();
        item.setNome(nome);
        item.setQuantidade(quantidade);
        item.setValorUnitario(valor);

        if (instancia.getItens() == null) {
            instancia.setItens(new ArrayList<>());
        }
        instancia.getItens().add(item);
    }

    public NotaFiscal builder(){
        return this.instancia;
    }
}
