package com.algaworks.dependencyinjection;

import com.algaworks.dependencyinjection.model.Filme;
import com.algaworks.dependencyinjection.service.FilmeService;
import com.algaworks.dependencyinjection.util.cdi.WeldContext;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Using {
    public static void main(String[] args) {
        FilmeService filmeService = WeldContext.INSTANCE.getBean(FilmeService.class);

        String nomeFilme = JOptionPane.showInputDialog("Informe o nome do filme:");
        String dataLancamento = JOptionPane.showInputDialog("Informe a data de lançamento (DD/MM/AAAA):");

        Filme filme = new Filme(nomeFilme, LocalDate.parse(dataLancamento, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        filmeService.salvar(filme);
    }
}
