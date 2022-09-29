package com.algaworks.dependencyinjection.service;

import com.algaworks.dependencyinjection.model.Filme;
import com.algaworks.dependencyinjection.model.TipoFilme;
import com.algaworks.dependencyinjection.repository.FilmeRepository;

import javax.inject.Inject;
import java.time.LocalDate;

public class FilmeService {

    @Inject
    private FilmeRepository filmeRepository;

    public void salvar(Filme filme) {
        this.definirTipoFilme(filme);
        filmeRepository.salvar(filme);
    }

    private void definirTipoFilme(Filme filme){
        LocalDate dataAntigo = LocalDate.now().minusMonths(3);
        if (filme.getDataLancamento().isBefore(dataAntigo)){
            filme.setTipoFilme(TipoFilme.ANTIGO);
        } else {
            filme.setTipoFilme(TipoFilme.NOVO);
        }
    }
}
