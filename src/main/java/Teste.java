
import com.google.gson.Gson;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ester
 */
public class Teste {
    
    public static void main(String[] args) {
        Princesa princesa = new Princesa();
        princesa.setNome("Ester");
        
        Gson gson = new Gson();
        String json = gson.toJson(princesa);
        System.out.println(json);
        
        String outroJson = "{\"nome\":\"Ester\"}";
        Princesa p = gson.fromJson(outroJson, Princesa.class);
        System.out.println();
    }
    
}
