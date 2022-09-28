package com.algaworks.observer.repository;

import com.algaworks.observer.model.Pedido;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PedidoXMLRepositoryTest {

    private PedidoRepository pedidoRepository;

    @Before
    public void setUp() {
        pedidoRepository = new PedidoXMLRepository();
    }

    @Test
    public void buscarNovosPedidos() {
        List<Pedido> pedidos = pedidoRepository.buscarNovosPedidos();

        assertEquals(pedidos.size(), 3);
    }
}