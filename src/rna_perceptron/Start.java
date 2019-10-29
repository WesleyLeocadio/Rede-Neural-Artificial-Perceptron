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
public class Start {
    public static void main(String[] args) {
        Rede perceptron = new Rede();
        perceptron.iniciarRede();
        perceptron.treinarRede();
        perceptron.executarRede();
    }

    
}
