package com.company;

import javax.xml.transform.SourceLocator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char caractere; // caractère entré au clavier

        System.out.println("Entrez un caractère");
        caractere = scan.next().charAt(0);

       if (estLettre(caractere))
           System.out.println(caractere + " est une lettre");
       else
           System.out.println(caractere + " n'est pas une lettre");

       scan.close();

    }

    /**
     * Permet de determiner si un caractere est une lettre ou non, les minuscules et majuscules sont inclus
     * sans accent.
     * @param caractere caractere qui est a analyser
     * @return retourne en boolean vrai si le caractere est une lettre
     */
    public static boolean estLettre(char caractere){

        return caractere >= 'a' && caractere <= 'z' || caractere >= 'A' && caractere <= 'Z';

    }

    }


