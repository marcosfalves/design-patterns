package com.algaworks.observer.job;

import com.algaworks.observer.model.Pedido;
import com.algaworks.observer.notifier.Notifier;
import com.algaworks.observer.repository.PedidoRepository;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

public class NovosPedidosJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        PedidoRepository pedidoRepository = (PedidoRepository) jobDataMap.get("pedidoRepository");
        Notifier notifier = (Notifier) jobDataMap.get("notifier");

        List<Pedido> novosPedidos = pedidoRepository.buscarNovosPedidos();
        notifier.novosPedidos(novosPedidos);
    }
}
