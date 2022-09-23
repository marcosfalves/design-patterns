package com.algaworks.proxy.service;

import com.algaworks.proxy.model.Contato;
import com.algaworks.proxy.repository.Contatos;

import java.util.List;
import java.util.stream.Collectors;

public class EnviadorEmailProxy implements EnviadorEmail{

    private Contatos contatos;
    private EnviadorEmailMandrill enviadorEmailMandrill;

    public EnviadorEmailProxy(Contatos contatos) {
        this.contatos = contatos;
    }

    @Override
    public void enviar(String mensagem) {
        List<Contato> blacklist = contatos.buscarContatosBlackList();
        List<Contato> destinatarios = contatos.buscarTodosContatos();

        destinatarios.removeAll(blacklist);

        List<String> emails = destinatarios.stream()
                .map(Contato::getEmail)
                .collect(Collectors.toList());

        enviadorEmailMandrill = new EnviadorEmailMandrill(emails);
        enviadorEmailMandrill.enviar(mensagem);
    }
}
