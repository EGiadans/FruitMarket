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
public class Consumer extends Thread {
    int num;
    String fruitNo; //Desired fruit
    FruitBuffer queue = null;
    
    public Consumer(FruitBuffer queue,String fruitNo,int name) {
        this.num = name;
        this.fruitNo = fruitNo;
        this.queue = queue;
    }
    
    @Override
    public void run(){
        /*
        for (int i = 0; i < 10; i++) {
            queue.quit(fruitNo,num);
        }
        */
        while(!this.queue.isEmpty()){
            queue.quit(fruitNo, num);
        }
    }
    
    //Depending on the desired fruit que consumer will modify the corresponding
    //buffer

    
}
