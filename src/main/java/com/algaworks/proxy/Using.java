package com.algaworks.proxy;

import com.algaworks.proxy.contatos.ContatosXML;
import com.algaworks.proxy.service.EnviadorEmailProxy;

public class Using {
    public static void main(String[] args) {
        EnviadorEmailProxy enviadorEmailProxy = new EnviadorEmailProxy(new ContatosXML());
        enviadorEmailProxy.enviar("Teste design pattern Proxy");
    }
}
