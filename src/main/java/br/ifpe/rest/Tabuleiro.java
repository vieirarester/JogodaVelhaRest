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

    private final String[][] t = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    public String mostrarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("   " + t[i][j]);
            }
            System.out.println("\n");
        }
        return null;
    }

    public boolean verificarJogada(String jogada) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (t[i][j].equals(jogada)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void fazerJogada(String jogada, String peca) {
        if (jogada.equals("1")) {
            t[0][0] = peca;
        } else if (jogada.equals("2")) {
            t[0][1] = peca;
        } else if (jogada.equals("3")) {
            t[0][2] = peca;
        } else if (jogada.equals("4")) {
            t[1][0] = peca;
        } else if (jogada.equals("5")) {
            t[1][1] = peca;
        } else if (jogada.equals("6")) {
            t[1][2] = peca;
        } else if (jogada.equals("7")) {
            t[2][0] = peca;
        } else if (jogada.equals("8")) {
            t[2][1] = peca;
        } else if (jogada.equals("9")) {
            t[2][2] = peca;
        }
    }

    public String verificarVencedor(int jogadas) {
        String[] vitoria = new String[8];

        String vencedor = null;

        if (jogadas == 9) {
            vencedor = "DEU VELHA!";
        }

        vitoria[0] = t[0][0] + t[0][1] + t[0][2];
        vitoria[1] = t[1][0] + t[1][1] + t[1][2];
        vitoria[2] = t[2][0] + t[2][1] + t[2][2];

        vitoria[3] = t[0][0] + t[1][0] + t[2][0];
        vitoria[4] = t[0][1] + t[1][1] + t[2][1];
        vitoria[5] = t[0][2] + t[1][2] + t[2][2];

        vitoria[6] = t[0][0] + t[1][1] + t[2][2];
        vitoria[7] = t[2][0] + t[1][1] + t[0][2];

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
