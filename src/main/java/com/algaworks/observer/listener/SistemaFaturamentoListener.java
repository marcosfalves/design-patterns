package com.algaworks.observer.listener;

import com.algaworks.observer.model.Pedido;
import com.algaworks.observer.notifier.Notifier;

import java.math.BigDecimal;
import java.util.List;

public class SistemaFaturamentoListener implements Listener{
    private final Notifier notifier;

    public SistemaFaturamentoListener(Notifier notifier) {
        this.notifier = notifier;
        this.notifier.registrarListener(this);
    }

    @Override
    public void update() {
        List<Pedido> novosPedidos = this.notifier.getNovosPedidos();
        BigDecimal valorTotal = novosPedidos.stream().map(Pedido::getValor).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);

        System.out.println("---------------------------------------------------------");
        System.out.println("Novas vendas realizadas:");
        novosPedidos.forEach(System.out::println);
        System.out.println("Valor Total: " + valorTotal);
        System.out.println("---------------------------------------------------------");
    }
}
