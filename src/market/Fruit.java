/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package market;

import java.util.ArrayList;

/**
 *
 * @author Eduardo
 */
public class Fruit {
    private ArrayList<String> fruits = new ArrayList<>();
    
    private int fruitsNumber;

	// make a constructor to get set the fruit number on initializing the market
	public Fruit(int fruitsNumber) {
            if (fruitsNumber > 0) {
                    this.fruitsNumber = fruitsNumber;
            } else {
                    throw new IllegalArgumentException("This argument is not valid");
            }
	} // end of the constructor

	// check if their is no place or its full //
	private synchronized boolean isFull() {
            return fruits.size() == this.fruitsNumber;
	}

	private synchronized boolean isEmpty() {
            return fruits.isEmpty();
	}

	// consumer and producer methods // the main program //
	public synchronized void farmer(String fruit) {
            if (isFull()) {
                System.out.println("Can´t store more fruits at the moment");
                try {
                        wait();
                } catch (InterruptedException e) {
                        System.out.println("Interruption");
                }
            }
            fruits.add(fruit);
            System.out.printf("Fruit: "+fruit+" was added");
	}

	public synchronized String consumer() {
            if (isEmpty()) {
                System.out.println("Don't have any fruits");
                try {
                        wait();
                } catch (InterruptedException e) {
                        System.out.println("Interruption occured");
                }
            }
            String currentFruitRecusted = fruits.remove(0);
            notifyAll();
            return currentFruitRecusted;
	}
        
        /*
        public synchronized String consumer(String str) {

		if (isEmpty()) {
			System.out.println("we don't have any goods yet");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("interruption occure !!!");
			}
		}
		int index = fruits.indexOf(str);
		String currentFruitRecusted = fruits.remove(index);
		notifyAll();
		return currentFruitRecusted;
	}
        */
        
        public int getSize() {
            return this.fruits.size();
        }

}
