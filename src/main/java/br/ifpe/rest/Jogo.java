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
public class Jogo {

    static Tabuleiro tabuleiro = new Tabuleiro();
    static int vez = 1;
    static boolean comecou = true;

    public String mudarJogador() {
        if (vez == 1) {
            tabuleiro.peca = "X";
            vez++;
        } else {
            tabuleiro.peca = "O";
            vez = 1;
        }
        return tabuleiro.peca;
    }

    public String jogar(String jogada) {

        if (comecou == true) {
            comecou = false;
            return resetarJogo();
        }

        if (tabuleiro.verificarJogada(jogada, tabuleiro.tabuleiro) == false) {
            return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                    + "<h2><center>" + tabuleiro.mostrarTabuleiro() + "Jogada incorreta! Por favor, jogue novamente: </center></h2><br></br>";
        } else {
            mudarJogador();
            tabuleiro.fazerJogada(jogada, tabuleiro.peca, tabuleiro.tabuleiro);

        }

        return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                + "<br><h1><center>" + tabuleiro.mostrarTabuleiro() + "</center></h1>";
    }

    public String verificarEstado() {
        if (tabuleiro.verificarVencedor(tabuleiro.jogadas, tabuleiro.tabuleiro) != null) {
            return tabuleiro.verificarVencedor(tabuleiro.jogadas, tabuleiro.tabuleiro) + "<br>"
                    + "<br>" + resetarJogo();
        }
        return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                + "<h2><center>Nenhum ganhador! Continue jogando:</h2></center>"
                + "<h1><center>" + tabuleiro.mostrarTabuleiro() + "</center></h1>";
    }
    
    public String resetarJogo() {
        tabuleiro = new Tabuleiro();
        tabuleiro.resetarTabuleiro();
        return "<h1><center>::::Jogo da Velha::::</center></h1><br>"+
                tabuleiro.mostrarTabuleiro();
    }
}
