package com.algaworks.observer.repository;

import com.algaworks.observer.model.Pedido;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import java.util.List;

public class PedidoXMLRepository implements PedidoRepository{
    private final XStream xstream;

    public PedidoXMLRepository() {
        xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        xstream.alias("pedidos", List.class);
        xstream.alias("pedido", Pedido.class);
    }

    @Override
    public List<Pedido> buscarNovosPedidos() {
        return (List<Pedido>) xstream.fromXML(this.getClass().getResource("/pedidos.xml"));
    }
}
