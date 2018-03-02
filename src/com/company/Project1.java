package com.company;

import com.sun.jdi.InternalException;

import java.util.LinkedList;

public class Project1 {

    public static void main(String[] args) throws InterruptedException {
            System.out.println("X--------------------------- Producer Consumer Problem ---------------------------X");
            final ProdCons PC=new ProdCons();

            //creating producer thread
            Thread p1=new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        PC.produce();
                        PC.produce();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });
            //creating consumer thread
            Thread c1=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        PC.consumer();

                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            });

            //starting producer and consumer thread
            p1.start();
            c1.start();

            //
            p1.join();
            c1.join();

        }

    }

class ProdCons{

    LinkedList<Integer> list = new LinkedList<>();
    int capacity =8;

    public void produce() throws InterruptedException {
        int value= 0;
        boolean limit=true;
        while(value<=8){
            synchronized (this){
                //when the producer thread is full wait()
                while(list.size()==capacity){
                    wait();
                }
                System.out.println("Producer Produced "+value);

                //inserting the value into the list
                list.add(value++);

                //notifies the consumer thread to consumer the value added to the list
                notify();
                //make the producer thread sleep
                Thread.sleep(1000);

            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true){
            synchronized (this){
                //consumer waits when the list is empty

                while(list.size()==0){
                    wait();
                }
                //else when the list is with some item
                //retrieve the item from the list
                int val= list.removeFirst();

                System.out.println("Consumer thread consumed "+val);

                //wake up the producer thread
                notify();

                //make the consumer thread sleep
                Thread.sleep(1000);
            }
        }
    }

}
