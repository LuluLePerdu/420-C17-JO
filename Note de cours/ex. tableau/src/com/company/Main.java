package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here


    /*
            Création de tableaux vide

        int[] tabInt = new int [5];
        char[] tabChar = new char[3];
        double[] tabDouble = new double[4];
        boolean[] tabBoolean = new boolean[2];
        String[] tabString = new String[4];

        System.out.println(Arrays.toString(tabInt));*/


      /*  int[] tabInt = {1, 2, 3, 4, 5, 6};
        char[] tabChar = {'a', 'H', '$', ' '};
        double[] tabDouble = {10.2, -5.3, 0.0, 333.22};
        boolean[] tabBoolean = {true, false, true};
        String[] tabString = {"toto", "Alice", "allo"};*//*

        System.out.println(Arrays.toString(tabInt));*/


        /*        int[] tab = new int[3];
        tab [0] = 1;
        tab [1] = 4;
        tab [2] = tab[0] + tab[1]; //1+4

        // quel type est tab[0] ? int et vaut 1

        System.out.println(tab[0]);
        System.out.println(tab[6 / 3]); // 5
        System.out.println(tab[5 % 2]); // 4
        //System.out.println(tab[6.2/3]); // donne une erreur
        System.out.println(tab[tab[0]]); // équivalent a de tab[1], va donner 4

        //System.out.println(tab[3]); // erreur Index out of bounds, l'index est en dehors du tableau

        int nbElem = tab.length; // 3, donne le nb d'élement dans un tableau
        int premierElem = tab[0]; // Permet d'afficher le premier élément
        int dernierElem = tab[tab.length-1]; // Pemet d'afficher le dernier elem. */

        //For et tableaux

        //initialiser un tableau des éléments de 1 à 100

        /*int[] tab = new int[100];
        int somme = 0; // Somme des entiers

        for (int i=0; i< tab.length; i++)
            tab[i] = i + 1;*/

       /* //aire la somme de tous les entiers du tableau
        for (int i = 0; i< tab.length; i++);
        somme = somme + tab[i];*/

        //afficher le tableau for
        for (int i= 0; 1< tab.length; i++)
            System.out.println(tab[i]);

        // Afficher un tableau avec for each
        for (int elem: tab)
            System.out.println(elem);
        System.out.println("Fin");*/

        //Créer un tableau des lettres de l'alphabet de 'a' a 'z' (minuscules)

//

        //Version 2 'a' code 97 'z' code 122 : 122-97=25+1
        char[] tabLettre = new char[(int)'z' - (int)'a'+ 1];

        for (int i=0; i< tabLettres2.length; i++)
            tabLettres2[i] = (char) (i + (int)'a');

        System.out.println(Arrays.toString(tabLettres));

    }
}
