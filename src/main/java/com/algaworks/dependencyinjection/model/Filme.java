package com.algaworks.dependencyinjection.model;

import java.time.LocalDate;
import java.util.Objects;

public class Filme {
    private String nome;
    private LocalDate dataLancamento;
    private TipoFilme tipoFilme;

    public Filme(String nome, LocalDate dataLancamento) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public TipoFilme getTipoFilme() {
        return tipoFilme;
    }

    public void setTipoFilme(TipoFilme tipoFilme) {
        this.tipoFilme = tipoFilme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(nome, filme.nome) && Objects.equals(dataLancamento, filme.dataLancamento) && tipoFilme == filme.tipoFilme;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataLancamento, tipoFilme);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", dataLancamento=" + dataLancamento +
                ", tipoFilme=" + tipoFilme +
                '}';
    }
}
