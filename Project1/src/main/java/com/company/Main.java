package com.company;


import java.util.LinkedList;
import java.io.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        LinkedList<Integer> list = new LinkedList<>();
        BufferedReader br = new BufferedReader(new
                InputStreamReader(System.in));
        System.out.println("X--------------------------- Producer Consumer Problem ---------------------------X \n\n");

        System.out.println("Enter the Number of Producer & Consumer Choice \n 1). 1 Producer 1 Consumer\n 2). 2 Producer 2 Consumer\n 3). 3 Producer 3 Consumer\n 4). 4 Producer 4 Consumer \n\nEnter Your choice: ");
        int choice = Integer.parseInt(br.readLine());
        //int N;
        if (choice == 1) {

            Thread p1 = new Thread(new Producer("producer 1", list));
            Thread c1 = new Thread(new Consumer("Consumer 1", list));

            //starting producer and consumer thread
            p1.start();
            c1.start();
            System.out.println("Entered the if file ");

            p1.join();
            c1.join();

        } else if (choice == 2) {
            Thread c1;
            Thread p1;
            p1 = new Thread(new Producer("producer 1", list));
            Thread p2 = new Thread(new Producer("producer2", list));


            c1 = new Thread(new Consumer("Consumer 1", list));
            Thread c2 = new Thread(new Consumer("Consumer 2", list));

            //starting producer and consumer thread

            p1.start();
            c1.start();
            p2.start();
            c2.start();

            p1.join();
            p2.join();
            c1.join();
            c2.join();

        } else if (choice == 3) {
            Thread c1;
            Thread p1;
            Thread p2;
            Thread c2;
            p1 = new Thread(new Producer("producer 1", list));
            p2 = new Thread(new Producer("producer 2", list));
            Thread p3 = new Thread(new Producer("producer3", list));


            c1 = new Thread(new Consumer("Consumer 1", list));
            c2 = new Thread(new Consumer("Consumer 2", list));
            Thread c3 = new Thread(new Consumer("Consumer 3", list));

            //starting producer and consumer thread
            p1.start();
            c1.start();
            p2.start();
            c2.start();
            p3.start();
            c3.start();

            p1.join();
            p2.join();
            c1.join();
            c2.join();
            p1.join();
            c3.join();

        } else if (choice == 4) {
            Thread c1;
            Thread p3;
            Thread p1;
            Thread p2;
            Thread c2;
            Thread c3;
            p1 = new Thread(new Producer("producer 1", list));
            p2 = new Thread(new Producer("producer 2", list));
            p3 = new Thread(new Producer("producer 3", list));
            Thread p4 = new Thread(new Producer("producer4", list));


            c1 = new Thread(new Consumer("Consumer 1", list));
            c2 = new Thread(new Consumer("Consumer 2", list));
            c3 = new Thread(new Consumer("Consumer 3", list));
            Thread c4 = new Thread(new Consumer("Consumer 4", list));

            //starting producer and consumer thread
            p1.start();
            c1.start();
            p2.start();
            c2.start();
            p3.start();
            c3.start();
            p4.start();
            c4.start();

            p1.join();
            p2.join();
            c1.join();
            c2.join();
            p3.join();
            c3.join();
            p4.join();
            c4.join();

        } else {
            Thread c1;
            Thread p1;
            p1 = new Thread(new Producer("producer 1 ", list));
            c1 = new Thread(new Consumer("Consumer 1", list));
            //starting producer and consumer thread
            p1.start();
            c1.start();

            p1.join();
            c1.join();

        }








    }

}

class Producer implements Runnable{
    LinkedList<Integer> list;
    int capacity;
    String name;
    private int value =0;
    int N;

    public Producer(String producer, LinkedList<Integer> list) {
        this.list = list;
        this.capacity = capacity;
        this.name=producer;
    }

    @Override
    public void run() {
        try{
            produce();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void produce() throws InterruptedException {
        while (value<=64)
        {
            synchronized (list)
            {
                // producer thread waits while list
                // is full
                while (list.size()==8){
                    list.wait();
                    System.out.printf("%s found the List full and is waiting for the Consumer to Consumer \n\n",name);
                }



                System.out.printf("%s produced- %d \n",name,value);

                // to insert the jobs in the list
                list.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                list.notify();

                // makes the working of program easier
                // to understand
                Thread.sleep(10);
            }
        }
    }



}
class Consumer implements Runnable{
    LinkedList<Integer> list;
    String name;
    private int consumed =0 ;

    public Consumer(String s, LinkedList<Integer> list) {
        this.list = list;
        this.name = s;
    }


    @Override
    public void run() {
        try {
            consume();

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void consume() throws InterruptedException {

        while (consumed<=64)
        {
            synchronized (list)
            {

                // consumer thread waits while list
                // is empty
                while (list.size()==0 && consumed<=64){
                    System.out.printf("%s found the List Empty , Waiting for the producer to Produce \n\n",name);
                    list.wait();

                }



                //to retrive the ifrst job in the list
                int val = list.removeFirst();
                consumed++;



                System.out.printf("%s consumed- %d \n",name,val);


                // Wake up producer thread
                list.notify();

                // and sleep
                Thread.sleep(10);
            }
        }
    }
}
