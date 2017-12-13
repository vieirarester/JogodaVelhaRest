/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpe.rest;

/**
 *
 * @author Ester
 */
public class Tabuleiro {

    
    public boolean verificarJogada(String jogada, Jogo tabuleiro) {
        for (int i = 0; i < tabuleiro.tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.tabuleiro.length; j++) {
                if (tabuleiro.tabuleiro[i][j].equals(jogada)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void fazerJogada(String jogada, String peca, Jogo tabuleiro) {
        if (jogada.equals("1")) {
            tabuleiro.tabuleiro[0][0] = peca;
        } else if (jogada.equals("2")) {
            tabuleiro.tabuleiro[0][1] = peca;
        } else if (jogada.equals("3")) {
            tabuleiro.tabuleiro[0][2] = peca;
        } else if (jogada.equals("4")) {
            tabuleiro.tabuleiro[1][0] = peca;
        } else if (jogada.equals("5")) {
            tabuleiro.tabuleiro[1][1] = peca;
        } else if (jogada.equals("6")) {
            tabuleiro.tabuleiro[1][2] = peca;
        } else if (jogada.equals("7")) {
            tabuleiro.tabuleiro[2][0] = peca;
        } else if (jogada.equals("8")) {
            tabuleiro.tabuleiro[2][1] = peca;
        } else if (jogada.equals("9")) {
            tabuleiro.tabuleiro[2][2] = peca;
        }
    }

    public String verificarVencedor(int jogadas, Jogo tabuleiro) {
        String[] vitoria = new String[8];

        String vencedor = null;

        if (jogadas == 9) {
            vencedor = "DEU VELHA!";
        }

        vitoria[0] = tabuleiro.tabuleiro[0][0] + tabuleiro.tabuleiro[0][1] + tabuleiro.tabuleiro[0][2];
        vitoria[1] = tabuleiro.tabuleiro[1][0] + tabuleiro.tabuleiro[1][1] + tabuleiro.tabuleiro[1][2];
        vitoria[2] = tabuleiro.tabuleiro[2][0] + tabuleiro.tabuleiro[2][1] + tabuleiro.tabuleiro[2][2];

        vitoria[3] = tabuleiro.tabuleiro[0][0] + tabuleiro.tabuleiro[1][0] + tabuleiro.tabuleiro[2][0];
        vitoria[4] = tabuleiro.tabuleiro[0][1] + tabuleiro.tabuleiro[1][1] + tabuleiro.tabuleiro[2][1];
        vitoria[5] = tabuleiro.tabuleiro[0][2] + tabuleiro.tabuleiro[1][2] + tabuleiro.tabuleiro[2][2];

        vitoria[6] = tabuleiro.tabuleiro[0][0] + tabuleiro.tabuleiro[1][1] + tabuleiro.tabuleiro[2][2];
        vitoria[7] = tabuleiro.tabuleiro[2][0] + tabuleiro.tabuleiro[1][1] + tabuleiro.tabuleiro[0][2];

        for (int i = 0; i < vitoria.length; i++) {
            if (vitoria[i].equals("xxx")) {
                vencedor = "JOGADOR 1 VENCEU!";
            } else if (vitoria[i].equals("ooo")) {
                vencedor = "JOGADOR 2 VENCEU!";
            }
        }
        return vencedor;
    }
}
