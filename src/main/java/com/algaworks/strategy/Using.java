package com.algaworks.strategy;

import com.algaworks.strategy.model.Cliente;
import com.algaworks.strategy.model.Sexo;
import com.algaworks.strategy.model.TipoVeiculo;
import com.algaworks.strategy.service.PropostaSeguroService;

import java.util.Scanner;

public class Using {
    public static void main(String[] args) {
        PropostaSeguroService propostaSeguroService = new PropostaSeguroService();

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.print("Informe o nome: ");
            String nome = entrada.nextLine();

            System.out.print("Sexo do cliente (1) Masculino, (2) Feminino: ");
            int opcaoSexo = entrada.nextInt();
            Sexo sexo = Sexo.values()[opcaoSexo -1];

            System.out.print("Qual a idade do cliente: ");
            int idade = entrada.nextInt();

            Cliente cliente = new Cliente(nome, idade, sexo);

            while(true){
                System.out.print("Informe o tipo do veículo (1) Carro, (2) Moto ou (9) para sair: ");
                int opcaoTipoVeiculo = entrada.nextInt();

                if (opcaoTipoVeiculo != 1 && opcaoTipoVeiculo != 2){
                    break;
                }

                System.out.print("Informe o valor do veículo: ");
                double valorVeiculo = entrada.nextDouble();

                TipoVeiculo tipoVeiculo = TipoVeiculo.values()[opcaoTipoVeiculo - 1];
                propostaSeguroService.setCalculadora(tipoVeiculo.getCalculadora());
                propostaSeguroService.gerar(cliente, valorVeiculo);
            }
        }
    }
}
