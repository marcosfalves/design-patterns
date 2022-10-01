package com.algaworks.strategy.model;

import com.algaworks.strategy.calculadora.CalculadoraPremioSeguro;
import com.algaworks.strategy.calculadora.CalculadoraPremioSeguroParaCarro;
import com.algaworks.strategy.calculadora.CalculadoraPremioSeguroParaMoto;

public enum TipoVeiculo {
    CARRO{
        @Override
        public CalculadoraPremioSeguro getCalculadora() {
            return new CalculadoraPremioSeguroParaCarro();
        }
    },
    MOTO {
        @Override
        public CalculadoraPremioSeguro getCalculadora() {
            return new CalculadoraPremioSeguroParaMoto();
        }
    };

    public abstract CalculadoraPremioSeguro getCalculadora();
}
