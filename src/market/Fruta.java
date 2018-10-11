/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.Random;


/**
 *
 * @author Eduardo
 */
public class Fruta {
    private String name;
    
    //Every time a new fruit is created, it has a random name;
    Fruta() {
        this.name = randomFruit();
    }
    
    private synchronized String randomFruit() {
        Random r = new Random();
        int rd = r.nextInt((3 - 0) + 1) + 0;
        
        String resultado= " ";
        switch (rd) {
                case 0:
                    resultado = "Apple";
                    break;
                case 1:
                    resultado = "Orange";
                    break;
                case 2:
                    resultado = "Grape";
                    break;
                case 3:
                    resultado = "Watermelon";
                    break;
             
        }
        return resultado;
    }
    
    public String getName() {
        return this.name;
    }

   
    
}
