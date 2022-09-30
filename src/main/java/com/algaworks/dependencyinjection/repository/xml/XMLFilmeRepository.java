package com.algaworks.dependencyinjection.repository.xml;

import com.algaworks.dependencyinjection.model.Filme;
import com.algaworks.dependencyinjection.repository.FilmeRepository;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLFilmeRepository implements FilmeRepository {

    private static final String NOME_ARQUIVO = "./src/main/resources/filmes.xml";

    private final XStream xstream;

    public XMLFilmeRepository() {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("filmes", List.class);
        xstream.alias("filme", Filme.class);
    }

    @Override
    public void salvar(Filme filme) {
        List<Filme> filmes = buscarTodos();
        filmes.add(filme);
        try {
            OutputStream out = new FileOutputStream(NOME_ARQUIVO);
            xstream.toXML(filmes, out);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro salvando arquivo", e);
        }
    }

    @Override
    public List<Filme> buscarTodos() {
        try {
            InputStream in = new FileInputStream(NOME_ARQUIVO);
            return (List<Filme>) xstream.fromXML(in);
        } catch (FileNotFoundException f) {
            return new ArrayList<>();
        }
    }
}
