package com.algaworks.decorator.repository;

import com.algaworks.decorator.model.Contato;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgendaCacheDecorator implements AgendaRepository {

    private final AgendaRepository agendaRepository;
    private Map<Integer, Contato> cacheContatos;

    public AgendaCacheDecorator(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
        this.cacheContatos = new HashMap<>();
    }

    @Override
    public void inserir(Contato contato) {
        agendaRepository.inserir(contato);
        cacheContatos.put(contato.getCodigo(), contato);
    }

    @Override
    public Contato buscar(Integer codigo) {
        Contato contato = cacheContatos.get(codigo);
        if (contato == null){
            contato = agendaRepository.buscar(codigo);
            cacheContatos.put(contato.getCodigo(), contato);
        }
        return contato;
    }

    @Override
    public List<Contato> buscarTodos() {
        return agendaRepository.buscarTodos();
    }
}
