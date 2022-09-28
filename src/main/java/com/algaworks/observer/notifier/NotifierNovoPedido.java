package com.algaworks.observer.notifier;

import com.algaworks.observer.listener.Listener;
import com.algaworks.observer.model.Pedido;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotifierNovoPedido implements Notifier{
    private Set<Listener> listeners;
    private List<Pedido> pedidos;

    public NotifierNovoPedido() {
        this.listeners = new HashSet<>();
    }

    @Override
    public void registrarListener(Listener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removerListener(Listener listener) {
        this.listeners.remove(listener);
    }

    @Override
    public void notificarListeners() {
        listeners.forEach(Listener::update);
    }

    @Override
    public void novosPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
        this.notificarListeners();
    }

    @Override
    public List<Pedido> getNovosPedidos() {
        return this.pedidos;
    }
}
