package com.company;

import java.util.*;
import java.lang.*;

class Arith {

    public void Arithm(String threadName,int num1,int num2){
        System.out.println("Calculating "+threadName);
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Thread Interrupted");
        }
        String choice = new String("Addition");
        String choice1= new String ("Multiplication");
        if(threadName.equals(choice)){
            System.out.printf("The addition of %s and %s = %s \n",num1,num2,(num1+num2));

        }
        else if(threadName.equals(choice1)){
            System.out.printf("The Mutliplication of %s and %s = %s \n",num1,num2,(num1*num2));

        }
        else{
            System.out.printf("The Divition of %s and %s = %s \n",num1,num2,(num1/num2));
        }
    }
}

class Arithmectic extends Thread{

    private Thread t;
    private String threadName;
    private int num1,num2;
    Arith opr;

    Arithmectic(String name,int num1,int num2,Arith opr ){
        opr = opr;
        this.threadName = name;
        this.num1 = num1;
        this.num2 = num2;
        this.opr = opr;
        System.out.println("created thread "+threadName);
    }
    public void run(){
        System.out.println("Running "+threadName);
        synchronized (opr){
            opr.Arithm(threadName,num1,num2);
        }

        System.out.println("Thread " +  threadName + " exiting.");

    }

}

public class sync {

    public static int add(int num1,int num2){
        return (num1+num2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String Name = sc.nextLine();
        System.out.printf("Hello %s !! \n",Name);
        System.out.println("Enter a num1 : ");
        int num1 = sc.nextInt();
        System.out.println("Enter a num2 : ");
        int num2= sc.nextInt();
        sc.close();
        System.out.printf("The addition of %s and %s is %s",num1,num2,add(num1,num2));
        Arith ari = new Arith();
        String add = new String("Addition");
        String mul = new String("Multiplication");
        String Div = new String ("divition");
        Arithmectic a1= new Arithmectic(add,num1,num2,ari);
        Arithmectic m1 = new Arithmectic(mul,num1,num2,ari);
        Arithmectic d1 = new Arithmectic(Div,num1,num2,ari);

        a1.start();
        m1.start();
        d1.start();

        try{
            a1.join();
            m1.join();
            d1.join();
        }
        catch (Exception e){
            System.out.print("Thread interrupted");
        }




    }
}
