/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Eduardo
 */
public class Market {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        FruitBuffer apples = new FruitBuffer(4);
        FruitBuffer oranges = new FruitBuffer(4);
        FruitBuffer grapes = new FruitBuffer(4);
        FruitBuffer watermelons = new FruitBuffer(4);
        
        //apples.add();
        Producer p1 = new Producer(apples, oranges, grapes, watermelons);
        Consumer c1 = new Consumer("Pedro",0,apples);
        p1.run();
        c1.run();*/
        /*
        
        Fruit test = new Fruit(5);
        Fruit test2 = new Fruit(5);
        Fruit test3 = new Fruit(5);
        Fruit test4 = new Fruit(5);
        
        int rp1,rp2, rp3, rp4 = 0;
        String[] arr = {"apple", "orange", "grape","watermelon"};
        
        
        while (true){
            rp1 = randomInt(0,3);
            rp2 = randomInt(0,3);
            rp3 = randomInt(0,3);
            rp4 = randomInt(0,3);
                   
            test.farmer(arr[rp1]);            
            test2.farmer(arr[rp2]); 
            test3.farmer(arr[rp2]);
            test4.farmer(arr[rp2]);
            
            System.out.println(test.consumer()+" was consumed");
            System.out.println(test2.consumer()+" was consumed");
            System.out.println(test3.consumer()+" was consumed");
            System.out.println(test4.consumer()+" was consumed");
            
                    
           */
        
        FruitBuffer queue = new FruitBuffer(8);
        int rp1,rp2, rp3, rp4 = 0;
        String[] arr = {"Apple", "Orange", "Grape","Watermelon"};
        while (true) {
            rp1 = randomInt(0,3);
            rp2 = randomInt(0,3);
            rp3 = randomInt(0,3);
            rp4 = randomInt(0,3);
            new Producer(queue, 1).start();
            new Producer(queue, 2).start();
            new Producer(queue, 3).start();
            new Consumer(queue, arr[rp1], 1).start();
            new Consumer(queue, arr[rp2], 2).start();
            new Consumer(queue, arr[rp3], 3).start();
            new Consumer(queue, arr[rp4], 4).start();
        }
        
            
        }
        
        
        
         
        
        
        
        
        
   	

    public static int randomInt(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }
    
}
