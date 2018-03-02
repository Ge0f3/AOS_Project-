package com.company;

import java.util.*;
import java.lang.*;



public class Main {

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




    }
}
