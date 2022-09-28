package com.algaworks.observer.listener;

import com.algaworks.observer.model.Pedido;
import com.algaworks.observer.notifier.Notifier;

import java.util.List;

public class SistemaEntregaListener implements Listener {
    private final Notifier notifier;

    public SistemaEntregaListener(Notifier notifier) {
        this.notifier = notifier;
        this.notifier.registrarListener(this);
    }

    @Override
    public void update() {
        List<Pedido> novosPedidos = this.notifier.getNovosPedidos();

        System.out.println("-----------------------------------------------------------");
        System.out.println("Realizando reserva do caminhão para entrega do(s) pedido(s):");
        novosPedidos.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");
    }
}
