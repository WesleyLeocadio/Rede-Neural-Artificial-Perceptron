/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rna_perceptron;

/**
 *
 * @author Suporte
 */
public class Neuronio {

    private int[] entradas;
    private double[] pesos;
    private double saida;
    private double saidaDesejada;
    private double erro;
    private double taxa_de_aprendizagem;

    public Neuronio(int quantEntrada) {
        this.entradas = new int[quantEntrada];
        this.pesos = new double[quantEntrada];
        this.taxa_de_aprendizagem = 0.1D;
        this.inicializaPesos();
    }

    private void inicializaPesos() {
        for (int i = 0; i < this.pesos.length; ++i) {
            this.pesos[i] = 0.0D;
        }

    }

    public void setEntrada(int indice, int valor) {
        this.entradas[indice] = valor;
    }

    public void setSaidaDesejada(int valor) {
        this.saidaDesejada = (double) valor;
    }

    public void calcSaidaNeuronio() {
        double u = 0.0D;

        for (int i = 0; i < this.pesos.length; ++i) {
            u += (double) this.entradas[i] * this.pesos[i];
        }

        System.out.println("Somatório = " + u);
        if (u >= 0.0D) {
            this.saida = 1.0D;
        } else {
            this.saida = 0.0D;
        }

        System.out.println("Saída = " + this.saida);
    }

    public void setErro() {
        this.erro = this.saidaDesejada - this.saida;
        if (this.erro != 0.0D) {
            this.atualizaPeso();
        }

        System.out.println("erro = " + this.erro);
    }

    private void atualizaPeso() {
        for (int i = 0; i < this.pesos.length; ++i) {
            this.pesos[i] += this.taxa_de_aprendizagem * this.erro * (double) this.entradas[i];
            System.out.println("pesos[" + i + "] = " + this.pesos[i]);
        }

    }

    public double getErro() {
        return this.erro;
    }

    public double getSaida() {
        return this.saida;
    }

}
