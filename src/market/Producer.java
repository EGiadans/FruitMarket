/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;


/**
 *
 * @author Eduardo
 */
public class Producer extends Thread{
    private static int Apples = 0;
    private static int Oranges = 0;
    private static int Grapes = 0;
    private static int Watermelons = 0;
    
    private int num;
    private boolean p1, p2, p3;
    private FruitBuffer queue = null;
    
    public Producer(FruitBuffer queue, int pNum) {
        this.queue = queue;
        this.num = pNum;

        //Set process active
        switch (pNum) {
            case 1:
                p1 = true;
                break;
            case 2:
                p2 = true;
                break;
            case 3:
                p3 = true;
                break;
        }
    }
    
    @Override
    public void run() {
        /*
        for (int i = 0; i < 10; i++) {
            queue.add(generate());
        }
        */
        while(this.queue.isEmpty()) {
            queue.add(generate());
        }
        /*
        System.out.println("Producer stopped production");
        setState(num);*/
    }
    
    private synchronized Fruta generate() {
        Fruta fruit = new Fruta();
        switch (fruit.getName()) {
            case "Apple":
                Apples++;
                System.out.println("Fruta: " + fruit.getName()+ " # " + Apples + " agregada a queue");
                break;
            case "Orange":
                Oranges++;
                System.out.println("Fruta " + fruit.getName() + " # " + Oranges + "  agregada a queue");
                break;
            case "Grape":
                Grapes++;
                System.out.println("Fruta " + fruit.getName() + " # " + Grapes + "  agregada a queue");
                break;
            case "Pear":
                Watermelons++;
                System.out.println("Fruta " + fruit.getName()+ " # " + Watermelons + "  agregada a queue");
                break;
        }
        return fruit;
    }
    
    private synchronized void setState(int num) {
        switch(num) {
            case 1:
                p1 = false;
                break;
            case 2:
                p2 = false;
                break;
            case 3:
                p3 = false;
                break;
        }
        
        if (!(p1 && p2 && p3)) {
            System.out.println("Mercado cerrando");
            System.exit(0);
        }
    }


    
    
}
