/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpe.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Ester
 */
@Path("jogo")
public class Jogo {

    static String[][] tabuleiro = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    static Jogo tabuleiroJogo = new Jogo();
    static boolean comecou = true;
    static String peca;
    static int jogadas = 0;
    static int vez = 1;

    public String mostrarTabuleiro() {
        String mostrarTabuleiro = "";
        mostrarTabuleiro+="<table align=\"center\" border=\"6\" style=\"width: 300px; height: 300px\">";
        for (int i = 0; i < tabuleiro.length; i++) {
            mostrarTabuleiro+="<tr>";
            for (int j = 0; j < tabuleiro.length; j++) {
                mostrarTabuleiro += "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">"+tabuleiro[i][j]+"</h1></td>";
            }
            mostrarTabuleiro = mostrarTabuleiro + "</tr>";
        }
        return mostrarTabuleiro;
    }

    public String mudarJogador() {
        if (vez == 1) {
            peca = "X";
            vez++;
        } else {
            peca = "O";
            vez = 1;
        }
        return peca;
    }

    @GET
    @Path("jogar")
    public String jogar(@QueryParam("j") String jogada) {
        if (comecou == true) {
            comecou = false;
            return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                    + "<h1><center>" + Jogo.this.mostrarTabuleiro() + "</center></h1>";
        }

        Tabuleiro t = new Tabuleiro();

        if (!(t.verificarJogada(jogada, tabuleiroJogo))) {
            return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                    + "<h1><center>" + tabuleiroJogo.mostrarTabuleiro()+ "Jogada incorreta! Por favor, jogue novamente: </center></h1></br>";
        } else {
            mudarJogador();
            t.fazerJogada(jogada, peca, tabuleiroJogo);
            jogadas++;
        }

        if (t.verificarVencedor(jogadas, tabuleiroJogo) != null) {
            comecou = true;
            return t.verificarVencedor(jogadas, tabuleiroJogo);
        }
        return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                + "<h1><center>" + Jogo.this.mostrarTabuleiro() + "</center></h1>";
    }
}
