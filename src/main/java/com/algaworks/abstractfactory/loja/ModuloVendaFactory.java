package com.algaworks.abstractfactory.loja;

import com.algaworks.abstractfactory.boleta.Boleta;
import com.algaworks.abstractfactory.nfe.NFe;

public interface ModuloVendaFactory {
    NFe criarNFe();
    Boleta criarBoleta();
}
