package com.algaworks.observer.repository;

import com.algaworks.observer.model.Pedido;

import java.util.List;

public interface PedidoRepository {
    List<Pedido> buscarNovosPedidos();
}
