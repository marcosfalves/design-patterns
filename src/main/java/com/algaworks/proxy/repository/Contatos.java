package com.algaworks.proxy.repository;

import com.algaworks.proxy.model.Contato;

import java.util.List;

public interface Contatos {
    List<Contato> buscarTodosContatos();
    List<Contato> buscarContatosBlackList();
}