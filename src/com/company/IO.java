package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO {

    public static void main(String[] args) throws IOException {
        Scan scan=new Scan();
        Buff buf=new Buff();
        System.out.println("Using Scanner class for I/O");
        scan.Run();
        System.out.println("Using Buffer class for I/O");
        try {
            buf.Run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Scan {
    public void Run(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String b =sc.nextLine();
        System.out.println("Enter an Integer: ");
        int a =sc.nextInt();

        System.out.println("You have entered: "+a +" "+"and name as "+b + "\n");

    }
}
class Buff{
    public void Run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter an integer: ");
        int a = Integer.parseInt(br.readLine());
        System.out.println("Enter a string: ");
        String b = br.readLine();
        System.out.printf("You have entered %d and a name as %s",a,b);

    }
}
