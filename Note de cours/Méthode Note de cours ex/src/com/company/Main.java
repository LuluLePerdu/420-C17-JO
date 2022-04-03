package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int multiplication;
        int a;
        int b;

        System.out.println("a et b ");
        a = scan.nextInt();
        b = scan.nextInt();

        multiplication = multInt(a, b);
        
        System.out.println(multiplication);

    }

    public static  int multInt(int n1, int n2){
        int resultat;
        resultat = n1 * n2;
        return  resultat;
    }

}

