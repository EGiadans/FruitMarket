/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class FruitBuffer {
    private int size;
    private List<Fruta> frutas = new ArrayList<>();
    
    //Cada buffer tendra sus metodos para poner y quitar
    //En main creamos 4 buffers y multiples instancias de productor y consumidor
    
    public FruitBuffer (int size) {
        this.size = size;
    }
    
    public synchronized boolean isEmpty() {
        return frutas.isEmpty();
    }
    
    public synchronized boolean isFull() {
        return frutas.size() == this.size;
    }
    
    public synchronized void add(Fruta fr) {
        while (isFull()) {
                System.out.println("We can not accept more fruits ");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("Interruption");
                }
        }
        frutas.add(fr);
        notifyAll();
        System.out.println("Fruta de tipo "+fr.getName() +" was produced");
    }
    
    public synchronized String quit(String fruitNo, int cName) {
        String fruta = "";
        
        while (isEmpty() || !fruitNo.equals(frutas.get(0).getName())) {
            if ( isEmpty() ) {
                System.out.println("We do not have any fruits on existence");
            } else  {
                System.out.println("Requested fruit is not available for "
                        + "consumer "+cName);
            }
            
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interruption Occured");
            }
        }
        fruta = frutas.remove(0).getName();
        System.out.println("Fruta de tipo "+ fruitNo+ " was consumed");
        notifyAll();
        return fruta;
    }
    
    public synchronized int getSize(){
        return this.size;
    }
}
