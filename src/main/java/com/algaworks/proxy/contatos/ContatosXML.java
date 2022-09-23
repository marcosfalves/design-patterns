package com.algaworks.proxy.contatos;

import com.algaworks.proxy.model.Contato;
import com.algaworks.proxy.repository.Contatos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.List;

public class ContatosXML implements Contatos {

    private XStream xstream;

    public ContatosXML() {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);
    }

    private List<Contato> lerArquivoXML(String nomeArquivo){
        System.out.println("Carregando arquivo: " + nomeArquivo);
        return (List<Contato>) xstream.fromXML(this.getClass().getResource("/" + nomeArquivo));
    }

    @Override
    public List<Contato> buscarTodosContatos() {
        String nomeArquivo = "contatos.xml";
        return lerArquivoXML(nomeArquivo);
    }

    @Override
    public List<Contato> buscarContatosBlackList() {
        String nomeArquivo = "black-list.xml";
        return lerArquivoXML(nomeArquivo);
    }
}
