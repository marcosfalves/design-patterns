package com.algaworks.abstractfactory.loja;

import com.algaworks.abstractfactory.boleta.Boleta;
import com.algaworks.abstractfactory.nfe.NFe;

import java.io.IOException;
import java.util.Properties;

public class LojaFactory implements ModuloVendaFactory{
    private Properties prop;

    public LojaFactory() {
        this.prop = new Properties();
        try {
            this.prop.load(this.getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public NFe criarNFe()  {
        String classeNFe = this.prop.getProperty("nfe");
        NFe nfe = null;
        try {
            nfe = (NFe) Class.forName(classeNFe).newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível carregar a Classe para emitir NF-e");
        }
        return nfe;
    }

    @Override
    public Boleta criarBoleta() {
        String classeBoleta = this.prop.getProperty("boleta");
        Boleta boleta = null;
        try {
            boleta = (Boleta) Class.forName(classeBoleta).newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Não foi possível carregar a Classe para emitir Boleta");
        }
        return boleta;
    }
}
