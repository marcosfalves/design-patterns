package com.algaworks.decorator.repository.xml;

import com.algaworks.decorator.model.Contato;
import com.algaworks.decorator.repository.AgendaRepository;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLAgendaRepository implements AgendaRepository {

    private static final String NOME_ARQUIVO = "./src/main/resources/agenda.xml";
    private final XStream xstream;

    public XMLAgendaRepository() {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);
    }

    @Override
    public void inserir(Contato contato) {
        try {
            List<Contato> contatos = this.buscarTodos();
            contatos.add(contato);

            OutputStream out = new FileOutputStream(NOME_ARQUIVO);
            xstream.toXML(contatos, out);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro salvando arquivo", e);
        }
    }

    @Override
    public Contato buscar(Integer codigo) {
        return this.buscarTodos().stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Contato> buscarTodos() {
        try {
            System.out.println("Lendo o arquivo...");
            InputStream in = new FileInputStream(NOME_ARQUIVO);
            return (List<Contato>) xstream.fromXML(in);
        } catch (FileNotFoundException f) {
            return new ArrayList<>();
        }
    }
}
