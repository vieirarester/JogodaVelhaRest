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
public class JogoRest {

    static Jogo jogo = new Jogo();

    @GET
    @Path("jogar")
    public String jogar(@QueryParam("j") String jogada) {
        return jogo.jogar(jogada);
    }

    @GET
    @Path("verificar")
    public String verificar() {
        return jogo.verificarEstado();
    }

    @GET
    @Path("resetar")
    public String resetar() {
        return jogo.resetarJogo();
    }
}
