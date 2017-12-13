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

    private String[][] board = {{"1", "2", "3"}, 
                                {"4", "5", "6"}, 
                                {"7", "8", "9"}};

    @GET
    @Path("boasVindas")
    public String boasVindas() {
        String nome = "Ester";
        return "<h1>Ola, " + nome + "</h1>";
    }
    
    public String showBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("   " + board[i][j]);
            }
            System.out.println("\n");
        }
        return null;
    }

    @GET
    @Path("mostrar")
    public String mostrarTabuleiro() {
        return showBoard();
    }
    
    @GET
    @Path("jogar")
    public String fazerJogada(@QueryParam("jogada") String jogada){
        return jogada;
    }

    @GET
    @Path("somar")
    public String somar(@QueryParam("n1") int numero1, @QueryParam("n2") int numero2) {
        int resultado = numero1 + numero2;
        return Integer.toString(resultado);
    }
}
