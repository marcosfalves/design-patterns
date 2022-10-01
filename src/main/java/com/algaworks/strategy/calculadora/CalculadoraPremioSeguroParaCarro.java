package com.algaworks.strategy.calculadora;

import com.algaworks.strategy.model.Cliente;
import com.algaworks.strategy.model.Sexo;

public class CalculadoraPremioSeguroParaCarro implements CalculadoraPremioSeguro {
    @Override
    public double calcular(Cliente cliente, double valorVeiculo) {
        if (cliente.getIdade() > 60) {
            return 0.05;
        }

        if (cliente.getSexo().equals(Sexo.MASCULINO)){
            return valorVeiculo * 0.15;
        } else {
            return valorVeiculo * 0.10;
        }
    }
}