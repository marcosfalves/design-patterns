package com.algaworks.observer.notifier;

import com.algaworks.observer.listener.Listener;
import com.algaworks.observer.model.Pedido;

import java.util.List;

public interface Notifier {
    void registrarListener(Listener listener);
    void removerListener(Listener listener);
    void notificarListeners();

    void novosPedidos(List<Pedido> pedidos);
    List<Pedido> getNovosPedidos();
}
