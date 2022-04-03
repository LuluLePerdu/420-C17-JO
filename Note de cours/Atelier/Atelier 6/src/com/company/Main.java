package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int nb1;
        int nb2;
        int somme;

        nb1 = scan.nextInt();
        nb2 = scan.nextInt();

        somme = sommeInt(nb1, nb2);

        System.out.println("nb1 + nb2: " + somme);


    }


public static int sommeInt(int nombre1, int nombre2){

        int somme = nombre1 + nombre2;

        return somme;
    }
}
