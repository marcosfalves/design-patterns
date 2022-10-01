package com.algaworks.strategy.calculadora;

import com.algaworks.strategy.model.Cliente;

public interface CalculadoraPremioSeguro {
    double calcular(Cliente cliente, double valorVeiculo);
}
