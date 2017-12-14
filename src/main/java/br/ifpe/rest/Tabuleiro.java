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

    static String peca;
    static int jogadas = 0;
    static String[][] tabuleiro = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    public String resetarTabuleiro(){
        String tabuleiroResetado="";
        
        tabuleiro[0][0]="1";
        tabuleiro[0][1]="2";
        tabuleiro[0][2]="3";
        tabuleiro[1][0]="4";
        tabuleiro[1][1]="5";
        tabuleiro[1][2]="6";
        tabuleiro[2][0]="7";
        tabuleiro[2][1]="8";
        tabuleiro[2][2]="9";
        
        tabuleiroResetado+=tabuleiro;
        return tabuleiroResetado;
    }
    
    public boolean verificarJogada(String jogada, String[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if (tabuleiro[i][j].equals(jogada)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public String mostrarTabuleiro() {
        String mostrar = "";
        mostrar += "<table align=\"center\" border=\"6\" style=\"width: 300px; height: 300px\">";
        for (int i = 0; i < tabuleiro.length; i++) {
            mostrar += "<tr>";
            for (int j = 0; j < tabuleiro.length; j++) {
                mostrar += "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">" + tabuleiro[i][j] + "</h1></td>";
            }
            mostrar = mostrar + "</tr>";
        }
        return mostrar;
    }

    public void fazerJogada(String jogada, String peca, String[][] tabuleiro) {
        if (jogada.equals("1")) {
            tabuleiro[0][0] = peca;
        } else if (jogada.equals("2")) {
            tabuleiro[0][1] = peca;
        } else if (jogada.equals("3")) {
            tabuleiro[0][2] = peca;
        } else if (jogada.equals("4")) {
            tabuleiro[1][0] = peca;
        } else if (jogada.equals("5")) {
            tabuleiro[1][1] = peca;
        } else if (jogada.equals("6")) {
            tabuleiro[1][2] = peca;
        } else if (jogada.equals("7")) {
            tabuleiro[2][0] = peca;
        } else if (jogada.equals("8")) {
            tabuleiro[2][1] = peca;
        } else if (jogada.equals("9")) {
            tabuleiro[2][2] = peca;
        }
        jogadas++;
    }

    public String verificarVencedor(int jogadas, String[][] tabuleiro) {
        String[] vitoria = new String[8];

        String vencedor = null;

        if (jogadas == 9) {
            vencedor = "<h1><center>DEU VELHA!</center></h1>";
        }

        vitoria[0] = tabuleiro[0][0] + tabuleiro[0][1] + tabuleiro[0][2];
        vitoria[1] = tabuleiro[1][0] + tabuleiro[1][1] + tabuleiro[1][2];
        vitoria[2] = tabuleiro[2][0] + tabuleiro[2][1] + tabuleiro[2][2];

        vitoria[3] = tabuleiro[0][0] + tabuleiro[1][0] + tabuleiro[2][0];
        vitoria[4] = tabuleiro[0][1] + tabuleiro[1][1] + tabuleiro[2][1];
        vitoria[5] = tabuleiro[0][2] + tabuleiro[1][2] + tabuleiro[2][2];

        vitoria[6] = tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2];
        vitoria[7] = tabuleiro[2][0] + tabuleiro[1][1] + tabuleiro[0][2];

        for (int i = 0; i < vitoria.length; i++) {
            if (vitoria[i].equals("XXX")) {
                vencedor = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";
                break;
            } else if (vitoria[i].equals("OOO")) {
                vencedor = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
                break;
            }
        }
        return vencedor;
    }
}
