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
    static boolean primeiraJogada = true;

    public String resetarJogo() {
        tabuleiro = new Tabuleiro();
        tabuleiro.resetarTabuleiro();
        tabuleiro.jogadas = 0;
        vez = 1;
        comecou = true;
        primeiraJogada = true;
        return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                + "<br><br>" + tabuleiro.mostrarTabuleiro();
    }

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

    public String verificarEstado() {
        if (tabuleiro.verificarVencedor(tabuleiro.jogadas, tabuleiro.tabuleiro) != null) {
            return tabuleiro.verificarVencedor(tabuleiro.jogadas, tabuleiro.tabuleiro) +
                    tabuleiro.mostrarTabuleiro();
        }
        return "<h1><center>::::Jogo da Velha::::</center></h1>"
                + "<h2><center><br>Nenhum ganhador! Continue jogando:</h2></center>"
                + "<h1><center>" + tabuleiro.mostrarTabuleiro() + "</center></h1>";
    }

    public String mostrarTabuleiroAtualizado(String jogada) {
        if (tabuleiro.verificarVencedor(tabuleiro.jogadas, tabuleiro.tabuleiro) == null) {

            if (tabuleiro.verificarJogada(jogada, tabuleiro.tabuleiro) == false) {
                return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                        + "<h2><center>" + tabuleiro.mostrarTabuleiro() + "Jogada incorreta! Por favor, jogue novamente: </center></h2><br></br>";
            } else {
                mudarJogador();
                tabuleiro.fazerJogada(jogada, tabuleiro.peca, tabuleiro.tabuleiro);

            }
        }
        return "<h1><center>::::Jogo da Velha::::</center></h1><br>"
                + "<br><h1><center>" + tabuleiro.mostrarTabuleiro() + "</center></h1>";
    }

    public String jogar(String jogada) {

        if (primeiraJogada) {
            primeiraJogada = false;
            return mostrarTabuleiroAtualizado(jogada);
        }

        if (tabuleiro.verificarVencedor(tabuleiro.jogadas, tabuleiro.tabuleiro) == null) {

            return mostrarTabuleiroAtualizado(jogada);
        }
        
        return tabuleiro.mostrarTabuleiro() + 
                "<h1><center>O jogo acabou! Reinicie para jogar novamente: </center></h1>";
    }
}
