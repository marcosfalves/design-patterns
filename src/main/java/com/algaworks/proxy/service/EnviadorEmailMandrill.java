package com.algaworks.proxy.service;

import java.util.List;

public class EnviadorEmailMandrill implements EnviadorEmail {
    private List<String> emails;

    public EnviadorEmailMandrill(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void enviar(String mensagem) {
        emails.forEach(e -> System.out.println("Enviando e-mail para: " + e + ", com a mensagem: " + mensagem));
    }
}
