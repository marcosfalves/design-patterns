package com.algaworks.strategy.service;

import com.algaworks.strategy.calculadora.CalculadoraPremioSeguro;
import com.algaworks.strategy.model.Cliente;

public class PropostaSeguroService {
    private CalculadoraPremioSeguro calculadora;

    public void setCalculadora(CalculadoraPremioSeguro calculadoraPremioSeguro){
        this.calculadora = calculadoraPremioSeguro;
    }

    public void gerar(Cliente cliente, double valorVeiculo){
        double valorPremio = this.calculadora.calcular(cliente, valorVeiculo);

        System.out.println("_______________________________________________________________");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Idade  : " + cliente.getIdade());
        System.out.println("Sexo   : " + cliente.getSexo());
        System.out.println("Valor calculado do prêmio: " + valorPremio);
        System.out.println("_______________________________________________________________");
    }
}