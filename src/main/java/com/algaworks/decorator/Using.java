package com.algaworks.decorator;

import com.algaworks.decorator.model.Contato;
import com.algaworks.decorator.repository.AgendaRepository;
import com.algaworks.decorator.repository.AgendaCacheDecorator;
import com.algaworks.decorator.repository.xml.XMLAgendaRepository;

public class Using {
    public static void main(String[] args) {
        Contato contato = new Contato(1, "Marcos", "9999-9999");
        Contato contato2 = new Contato(2, "Juliana", "9988-9988");

        AgendaRepository agendaRepository = new AgendaCacheDecorator(new XMLAgendaRepository());
        agendaRepository.inserir(contato);
        agendaRepository.inserir(contato2);

        System.out.println("Buscando contato 1...");
        Contato contatoBusca = agendaRepository.buscar(1);
        System.out.println("Contato retornado: " + contatoBusca);

        System.out.println("Buscando contato 2...");
        Contato contatoBusca2 = agendaRepository.buscar(2);
        System.out.println("Contato retornado: " + contatoBusca2);
    }
}
