package com.algaworks.observer;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import com.algaworks.observer.job.NovosPedidosJob;
import com.algaworks.observer.listener.SistemaEntregaListener;
import com.algaworks.observer.listener.SistemaFaturamentoListener;
import com.algaworks.observer.notifier.Notifier;
import com.algaworks.observer.notifier.NotifierNovoPedido;
import com.algaworks.observer.repository.PedidoRepository;
import com.algaworks.observer.repository.PedidoXMLRepository;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class Using {
    public static void main(String[] args) throws Exception {
        Notifier notifier = new NotifierNovoPedido();
        PedidoRepository pedidoRepository = new PedidoXMLRepository();

        new SistemaEntregaListener(notifier);
        new SistemaFaturamentoListener(notifier);

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("pedidoRepository", pedidoRepository);
        jobDataMap.put("notifier", notifier);

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail job = newJob(NovosPedidosJob.class)
                .setJobData(jobDataMap)
                .withIdentity("novosPedidosJob", "pedidosGroup")
                .build();

        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0 * * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.sleep(220000);

        scheduler.shutdown(true);
    }
}
