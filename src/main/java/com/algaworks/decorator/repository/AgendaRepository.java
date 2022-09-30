package com.algaworks.decorator.repository;

import com.algaworks.decorator.model.Contato;

import java.util.List;

public interface AgendaRepository {
    void inserir(Contato contato);
    Contato buscar(Integer codigo);
    List<Contato> buscarTodos();
}
