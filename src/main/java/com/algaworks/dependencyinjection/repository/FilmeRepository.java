package com.algaworks.dependencyinjection.repository;

import com.algaworks.dependencyinjection.model.Filme;

import java.util.List;

public interface FilmeRepository {
    void salvar(Filme filme);
    List<Filme> buscarTodos();
}
