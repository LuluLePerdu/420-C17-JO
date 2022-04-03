package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int nb1 = 7;
        int nb2 = 4;
        double nb4 = 4.0;

        System.out.println("La valeur de nb1 est" + " " + nb1);
        System.out.println("La valeur de nb2 est" + " " + nb2);
        System.out.println("La valeur de nb4 est" + " " + nb4);

        System.out.println("-------------------------------------");

        System.out.println(nb1 + " " + "+" + " " + nb2 + " " + "=" + " " + (nb1 + nb2));
        System.out.println(nb1 + " " + "-" + " " + nb2 + " " + "=" + " " + (nb1 - nb2));
        System.out.println(nb1 + " " + "*" + " " + nb2 + " " + "=" + " " + (nb1 * nb2));
        System.out.println(nb1 + " " + "/" + " " + nb2 + " " + "=" + " " + (nb1 / nb2));
        System.out.println(nb1 + " " + "/" + " " + nb4 + " " + "=" + " " + (nb1 / nb4));
        System.out.println(nb1 + " " + "%" + " " + nb2 + " " + "=" + " " + (nb1 % nb2));
        System.out.println(nb1 + " " + "%" + " " + nb4 + " " + "=" + " " + (nb1 % nb4));

        System.out.println("-------------------------------------");

        System.out.println("nb2" + " " + "==" + " " + "nb4" + " " + ":" + " " + nb2 + " " + "==" + " " + nb4 + " " + ":" + " " + (nb2 == nb4));




    }
}
