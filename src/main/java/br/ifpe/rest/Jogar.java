/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpe.rest;

import java.util.Scanner;

/**
 *
 * @author Ester
 */
public class Jogar {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Tabuleiro t = new Tabuleiro();

        String jogada;
        int verificar = 0;
        int jogadas = 0;

        while (true) {
            System.out.println(":::::Tic Tac Toe:::::");
            t.mostrarTabuleiro();

            do {
                System.out.println("Jogador 1, faça uma jogada: ");
                jogada = s.next();

                while (!t.verificarJogada(jogada)) {
                    System.out.println("Jogada inválida! Faça outra jogada: ");
                    jogada = s.next();
                    verificar = 0;
                }
                t.fazerJogada(jogada, "x");
                verificar = 1;

            } while (verificar == 0);
            jogadas++;
            verificar = 0;
            
            t.mostrarTabuleiro();
            
            if(t.verificarVencedor(jogadas)!= null){
                System.out.println(t.verificarVencedor(jogadas));
                break;
            }

            do {
                System.out.println("Jogador 2, faça a jogada: ");
                jogada = s.next();

                while (!t.verificarJogada(jogada)) {
                    System.out.println("Jogada inválida! Faça outra jogada: ");
                    jogada = s.next();
                    verificar = 0;
                }
                t.fazerJogada(jogada, "o");
                verificar = 1;

            } while (verificar == 0);
            jogadas++;
            verificar = 0;
            
            t.mostrarTabuleiro();
            if(t.verificarVencedor(jogadas)!= null){
                System.out.println(t.verificarVencedor(jogadas));
                break;
            }
        }
    }
}
