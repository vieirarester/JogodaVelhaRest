package br.ifpe.rest.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.ifpe.rest.Tabuleiro;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ester
 */
public class TabuleiroTeste {

    private Tabuleiro t;
    private String[][] tabuleiro = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};

    public TabuleiroTeste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        t = new Tabuleiro();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void resetarTabuleiro() {
        String [][] tab = t.getTabuleiro();
        String mostrar="";
        mostrar+=tab;
        
        String resultado = t.resetarTabuleiro();
        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarJogadaValida() {
        String jogada = "1";

        boolean resultado = t.verificarJogada(jogada, tabuleiro);

        Assert.assertTrue(resultado);
    }

    @Test
    public void verificarJogadaInvalidaComNumeros() {
        String jogada = "10";
        boolean resultado = t.verificarJogada(jogada, tabuleiro);

        Assert.assertFalse(resultado);
    }

    @Test
    public void verificarJogadaInvalidaComLetras() {
        String jogada = "X";
        boolean resultado = t.verificarJogada(jogada, tabuleiro);

        Assert.assertFalse(resultado);
    }

    @Test
    public void mostrarTabuleiro() {
        String mostrar = "<table align=\"center\" border=\"6\" style=\"width: 300px; "
                + "height: 300px\"><tr><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">1</h1></td><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">2</h1></td><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">3</h1></td></tr><tr><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">4</h1></td><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">5</h1></td><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">6</h1></td></tr><tr><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">7</h1></td><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">8</h1></td><td style=\"width: 93px\"><h1 id=\"1\" "
                + "align=\"center\">9</h1></td></tr>";

        String resultado = t.mostrarTabuleiro();

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void fazerJogada() {
        String jogada = "1";
        String peca = "X";
        t.fazerJogada(jogada, peca, t.getTabuleiro());
        String resultado = t.mostrarTabuleiro();

        String mostrar = "<table align=\"center\" border=\"6\" style=\"width: 300px; height: 300px\">"
                + "<tr><td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">X</h1></td>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">2</h1></td>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">3</h1></td></tr>"
                + "<tr><td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">4</h1></td>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">5</h1></td>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">6</h1></td></tr><tr>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">7</h1></td>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">8</h1></td>"
                + "<td style=\"width: 93px\"><h1 id=\"1\" align=\"center\">9</h1></td></tr>";

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXLinha1() {

        int jogadas = 5;

        tabuleiro[0][0] = "X";
        tabuleiro[0][1] = "X";
        tabuleiro[0][2] = "X";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXLinha2() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "X";
        tabuleiro[1][1] = "X";
        tabuleiro[1][2] = "X";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXLinha3() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "X";
        tabuleiro[2][1] = "X";
        tabuleiro[2][2] = "X";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXColuna1() {
        int jogadas = 5;

        tabuleiro[0][0] = "X";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "X";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "X";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXColuna2() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "X";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "X";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "X";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXColuna3() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "X";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "X";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "X";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXDiagonalPrincipal() {
        int jogadas = 5;

        tabuleiro[0][0] = "X";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "X";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "X";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorXDiagonalSecundaria() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "X";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "X";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "X";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (X) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorOLinha1() {

        int jogadas = 5;

        tabuleiro[0][0] = "O";
        tabuleiro[0][1] = "O";
        tabuleiro[0][2] = "O";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorOLinha2() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "O";
        tabuleiro[1][1] = "O";
        tabuleiro[1][2] = "O";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";

        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorOLinha3() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "O";
        tabuleiro[2][1] = "O";
        tabuleiro[2][2] = "O";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorOColuna1() {
        int jogadas = 5;

        tabuleiro[0][0] = "O";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "O";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "O";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorOColuna2() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "O";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "O";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "O";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorOColuna3() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "O";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "5";
        tabuleiro[1][2] = "O";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "O";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorODiagonalPrincipal() {
        int jogadas = 5;

        tabuleiro[0][0] = "O";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "3";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "O";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "7";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "O";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }

    @Test
    public void verificarVencedorODiagonalSecundaria() {
        int jogadas = 5;

        tabuleiro[0][0] = "1";
        tabuleiro[0][1] = "2";
        tabuleiro[0][2] = "O";
        tabuleiro[1][0] = "4";
        tabuleiro[1][1] = "O";
        tabuleiro[1][2] = "6";
        tabuleiro[2][0] = "O";
        tabuleiro[2][1] = "8";
        tabuleiro[2][2] = "9";

        String mostrar = "<h1><center>JOGADOR (O) VENCEU!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);

        Assert.assertEquals(mostrar, resultado);
    }
    
    @Test
    public void verificarVencedorVelha(){
        int jogadas = 9;
        
        String mostrar = "<h1><center>DEU VELHA!</center></h1>";
        String resultado = t.verificarVencedor(jogadas, tabuleiro);
        
        Assert.assertEquals(mostrar, resultado);
    }

}
