package com.algaworks.abstractfactory.loja;

import com.algaworks.abstractfactory.boleta.Boleta;
import com.algaworks.abstractfactory.nfe.NFe;
import com.algaworks.abstractfactory.produto.Produto;

import java.math.BigDecimal;

public class Venda {
    private NFe nfe;
    private Boleta boleta;

    public Venda(ModuloVendaFactory moduloVendaFactory) {
        this.nfe = moduloVendaFactory.criarNFe();
        this.boleta = moduloVendaFactory.criarBoleta();
    }

    public void realizar(Produto produto){
        BigDecimal imposto = nfe.gerar(produto);
        boleta.emitir(produto, imposto);
    }
}
