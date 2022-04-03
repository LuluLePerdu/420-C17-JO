package com.company;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Ludwig-E.Dufour
 * 2031990
 * Session 2021
 * Chapitre 2, atelier 1
 */

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // scan lecture console
        DecimalFormat df = new DecimalFormat("0.00");
        
        /*
                System.out.println("----- cas#1 -----");

        final double TAXE = 0.15;
        double prix; // prix avant taxe
        double prixFinal; // prix après taxe

        System.out.println("Entrez le prix: ");
        prix = scan.nextDouble();
        prixFinal = prix + (prix * TAXE);

        System.out.println("Le prix après taxe est de " + df.format(prixFinal) + "$"); */ // Cas #1

        /*   System.out.println("----- Cas#2 -----");

        int nb1; //premier nombre
        int nb2; //second nombre
        double moyenne; //moyenne du tout

        System.out.println("Entrez les valeurs pour effectuer la moyenne: ");
        nb1 = scan.nextInt();
        nb2 = scan.nextInt();
        moyenne = (nb1 + nb2) / 2.0;

        System.out.println("La moyenne de vos valeurs est de: " + df.format(moyenne));
      */ // Cas #2

          /*System.out.println("----- Cas#3 -----");

        System.out.println("entrez les valeurs nb1 (7), nb2(4) et nb3(4)");

        int nb1 = scan.nextInt();
        int nb2 = scan.nextInt();
        double nb4 = scan.nextDouble();

        System.out.println("La valeur de nb1 est " + nb1);
        System.out.println("La valeur de nb2 est " + nb2);
        System.out.println("La valeur de nb4 est " + nb4);
        System.out.println("-------------------------------------");
        System.out.println(nb1 + " + " + nb2 + " = " + (nb1 + nb2));
        System.out.println(nb1 + " - " + nb2 + " = " + (nb1 - nb2));
        System.out.println(nb1 + " * " + nb2 + " = " + nb1 * nb2);
        System.out.println(nb1 + " / " + nb2 + " = " + nb1 / nb2);
        System.out.println(nb1 + " / " + nb4 + " = " + (double)nb1 / nb4);
        System.out.println(nb1 + " % " + nb2 + " = " + nb1 % nb2);
        System.out.println(nb1 + " % " + nb4 + " = " + (double)nb1 % nb4);
        System.out.println("-------------------------------------");
        System.out.println("nb2 == nb4 : " + nb2 + " == " + nb4 + " : " + ((double)nb2 == nb4)); // Cas #3
*/ // Cas #3

        /*  System.out.println("----- Cas#4 -----");

        double salNet; // salaire net
        double salBrut; // salaire brut
        double deductions; // déduction

        System.out.println("Merci d'entrez ici votre salaire brut: ");
        salBrut = scan.nextDouble();
        System.out.println("Merci d'entrez les déductions: ");
        deductions = scan.nextDouble();
        salNet = salBrut - deductions;

        System.out.println("Votre salaire net est de: " + df.format(salNet) + "$");*/ // Cas #4

        /*System.out.println("----- Cas#5 -----");

        DecimalFormat cas5 = new DecimalFormat("0.000000000000000");

        double nbKm; // nombre km parcourus
        double litre; // nombre de litre utilisé
        double kmL; // kilométrage au litre

        System.out.println("Merci d'entrez le nombre de km parcourus: ");
        nbKm = scan.nextInt();
        System.out.println("Merci d'entrez le nombre de litre utulisé: ");
        litre = scan.nextInt();
        kmL = nbKm / litre;

        System.out.println("Le kilométrage au litre est de: " + cas5.format(kmL));*/ // Cas #5

          /*System.out.println("----- Cas#6 ------");

        final double TAUXHORAIRE;

        double salaireBrut;
        int nbHeure;

        System.out.println("Merci d'entrez le nombre d'heure travaillé: ");
        nbHeure = scan.nextInt();
        TAUXHORAIRE = 15.67;
        salaireBrut = nbHeure * TAUXHORAIRE;

        System.out.println("Votre salaire brut est de: " + df.format(salaireBrut)); /*/ //Cas #6

        /*System.out.println("----- Cas#7 -----");

        int nbHeures;
        double tauxHoraire;
        double salaireB;

        System.out.printf("Merci d'entrez le nombre d'heures travaillé ainsi" +
                "que le taux horaire");
        nbHeures = scan.nextInt();
        tauxHoraire = scan.nextDouble();
        salaireB = nbHeures * tauxHoraire;

        System.out.println("Avec " + nbHeures + " heures au taux horaire de " +
                tauxHoraire + " $ " + "Votre salaire brut est de " + salaireB);*/ // Cas #7

        scan.close();

    }
}
