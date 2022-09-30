package com.algaworks.decorator.model;

import java.util.Objects;

public class Contato {
    private Integer codigo;
    private String nome;
    private String telefone;

    public Contato(Integer codigo, String nome, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(codigo, contato.codigo) && Objects.equals(nome, contato.nome) && Objects.equals(telefone, contato.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, telefone);
    }

    @Override
    public String toString() {
        return "Contato{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
