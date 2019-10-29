/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rna_perceptron;

import java.util.Scanner;

/**
 *
 * @author Suporte
 */
public class Rede {

    private int qtdAtributos;
    private int qtdPadroes;
    private Neuronio mcp;

    //Entrada: Um conjunto de n exemplos de treinamento com saídas desejadas
    private int[][] padroes;
    private int[] saidaDesejada;

    private Scanner entrada;

    public Rede() {
        this.entrada = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("----- REDE NEURAL PERCEPTRON -----");
        System.out.println("---------------------------------");
        System.out.println("1-  INFORME A QUANTIDADE DE PADROES: ");

        this.qtdPadroes = entrada.nextInt();
        System.out.println("2-  INFORME A QUANTIDADE DE ATRIBUTOS: ");
        this.qtdAtributos = entrada.nextInt();
        this.saidaDesejada = new int[qtdPadroes];
        this.padroes = new int[qtdPadroes][qtdAtributos];

        System.out.println("3 - MONTANDO O BANCO DE DADOS: ");
        for (int i = 0; i < this.qtdPadroes; i++) {
            System.out.println("----- " + i + " PADRAO -----");
            for (int j = 0; j < qtdAtributos; j++) {
                System.out.println("Atributo " + j + ": ");
                this.padroes[i][j] = entrada.nextInt();
            }
            System.out.println("Atributo Alvo: ");
            this.saidaDesejada[i] = entrada.nextInt();
            System.out.println("---------------------------------");

        }
        System.out.println("----- BASE COMPLETA -----");
        printBase();
    }

    public void printBase() {
          System.out.println("---------------------------------");
          System.out.println(" Exemplo | atributo1 | atributo2 | atributo alvo");
        for (int i = 0; i < this.padroes[0].length; i++) {
            System.out.print("     "+i+"  ");
            for (int j = 0; j < this.padroes[1].length; j++) {
                System.out.print("       "+this.padroes[i][j]);     
            }
            System.out.print("             "+this.saidaDesejada[i]);
            System.out.println("");
        }
          System.out.println("---------------------------------");
    }

    public void iniciarRede() {
        System.out.println("--------------------------------");
        System.out.println("INICIANDO REDE NEURAL PERCEPTRON");
        System.out.println("--------------------------------");
        this.qtdPadroes = this.padroes.length;
        this.qtdAtributos = this.padroes[0].length;
        this.mcp = new Neuronio(this.qtdAtributos);
    }

    public void treinarRede() {
        int iteracao = 1;
        System.out.println("--------------------------------");
        System.out.println("TREINANDO REDE NEURAL PERCEPTRON");
        System.out.println("--------------------------------");

        double erro;
        do {
            System.out.println("ITERACAO " + iteracao++);
            erro = 0.0D;

            for (int i = 0; i < this.qtdPadroes; ++i) {
                for (int j = 0; j < this.qtdAtributos; ++j) {
                    this.mcp.setEntrada(j, this.padroes[i][j]);
                }

                this.mcp.setSaidaDesejada(this.saidaDesejada[i]);
                this.mcp.calcSaidaNeuronio();
                this.mcp.setErro();
                erro += Math.abs(this.mcp.getErro());
            }
        } while (erro > 0.0D);

        System.out.println("--------------------------------");
    }

    public void executarRede() {
        do {
            System.out.println("--------------------------------");
            System.out.println("EXECUTANDO REDE NEURAL PERCEPTRON");
            System.out.println("--------------------------------");
            System.out.println("ENTRE COM OS ATRIBUTOS DO PADRAO ");

            for (int j = 0; j < this.qtdAtributos; ++j) {
                this.mcp.setEntrada(j, this.entrada.nextInt());
            }

            this.mcp.calcSaidaNeuronio();
            System.out.println("PADRAO PERTENCE A CLASSE: " + this.mcp.getSaida());
            System.out.println("DIGITE 9 PARA CONTINUAR");
        } while (this.entrada.nextInt() == 9);

        System.out.println("--------------------------------");
    }

}
