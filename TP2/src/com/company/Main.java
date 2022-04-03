package com.company;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Ludwig-Emmanuel Dufour
 * 2031990
 * Session A2021
 * Un jeu de multiplication qui permet au joueur de choisir une table de 2 à 12 (2 et 12 sont inclus) et de
 * tenter de trouver la réponse aux dix expressions générées aléatoirement par le programme. Le jeu
 * calcule des statistiques à la fin d’une partie. Le joueur peut jouer autant de parties qu’il le désire. Les
 * partie sont toujours de dix essais chacune.
 */

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";   // Remet la couleur de l'écriture par default
    public static final String ANSI_RED = "\u001B[31m";   // Écriture en rouge
    public static final String ANSI_BLUE = "\u001B[34m"; // Écriture en bleu

    public static void main(String[] args) {

        Random r = new Random();
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        boolean rejouer;                       // Choix de l'utilisateur pour rejouer une partie ou non.
        boolean erreurRep;                    // Variable permettant de gérer les erreurs possibles de produitScan.
        int produitScan = 0;                   // Produit de la multiplication entré au clavier.
        int nbGenere;                         // Permet de générer aléatoirement la seconde opérande de la multiplication.
        int table;                           // Table de multiplication choisie par l'utilisateur.
        int nbEssais;                       // Nombre d'essais total de l'utilisateur durant sa partie.
        int nbErreurs;                     // Nombre d'erreurs total réalisé par l'utilisateur.
        int nbPartieG = 0;                // Nombre total de partie gagné.
        int nbPartieP = 0;               // Nombre total de partie perdues.
        int nbPartieJ = 0;              // Nombre total de partie joué.
        int resultat;                  // Conserve les résultats de chaque partie jouée.
        int[] tabPartie = new int[0]; // Tableau des résultats de la partie du joueur.
        char borneMin = 2;         // Borne minimum pour la seconde opérande. Utilisation pour nbGenere
        char borneMax = 13;       // Borne maximale pour la seconde opérande. Utilisation pour nbGenere
        double moyenneGP;      // Moyenne des parties gagnées et perdues.

        // -Section jeu de multiplication

        menu();

        do {
            table = choisirTable();
            nbEssais = 1;
            nbErreurs = 0;
            nbPartieJ++;

            while (nbEssais <= 10) {

                nbGenere = r.nextInt(borneMax - borneMin) + borneMin;

                do {

                    erreurRep = false;

                    System.out.print("(Essais: " + nbEssais + "/10) " + table + " * " + nbGenere + " =");

                    try {
                        produitScan = scan.nextInt();
                    } catch (InputMismatchException e) {
                        scan.next();
                        erreurRep = true;
                    }

                } while (erreurRep);

                if (produitScan != table * nbGenere) {
                    System.out.println(ANSI_RED +
                            table + " * " + nbGenere + " = " +
                            (table * nbGenere) +
                            ANSI_RESET);
                    nbErreurs++;
                }
                nbEssais++;
            }

            // -Section résultat et statistique

            resultat = 10 - nbErreurs;

            if (nbErreurs < 2) {
                System.out.println(ANSI_BLUE +
                        "-> Bravo vous avez gagné! " + resultat + "/10" +
                        ANSI_RESET);
                nbPartieG++;
            } else {
                System.out.println(ANSI_BLUE +
                        "-> Vous avez perdu! " + resultat + "/10" +
                        ANSI_RESET);
                nbPartieP++;
            }

            tabPartie = addElemTab(tabPartie, resultat);
            moyenneGP = moyenneTableau(tabPartie);

            System.out.print(ANSI_BLUE +
                    "\nNombre de parties jouées: " + nbPartieJ +
                    "\nNombre de parties gagnées: " + nbPartieG +
                    "\nNombre de parties perdues: " + nbPartieP +
                    "\nRésultat de toutes les parties jouées:  ");

            for (int elem : tabPartie)
                System.out.print(elem + "/10  ");

            System.out.print("\n\nMoyenne des résultats: " + df.format(moyenneGP) + "%" +
                    ANSI_RESET);

            rejouer = validerRejouer();
        } while (rejouer);

        finProgramme(moyenneGP);
    }

    /**
     * Methode qui permet a l'utilisateur de choisir une table de multiplication entre 2 et 12, ces derniers inclus.
     *
     * @return Retourne la table de multiplication choisi par l'utilisateur.
     */
    public static int choisirTable() {

        Scanner scan = new Scanner(System.in);

        int table = 0; // Table de multiplication choisie par l'utilisateur.

        do {

            System.out.print("\n-> Choisir une table (2 à 12): ");

            try {
                table = scan.nextInt();
            } catch (InputMismatchException e) {
                scan.next();
            }

        } while (table < 2 || table > 12);
        return table;
    }

    /**
     * Methode qui permet de faire une validation du joueur s'il veut rejouer ou non une partie, avec une entree
     * au clavier (o/n).
     *
     * @return Retourne la valeur True/False en fonction du choix de l'utilisateur s'il choisi de rejouer ou non.
     */
    public static boolean validerRejouer() {

        Scanner scan = new Scanner(System.in);

        char decision;           // Decision de l'utilisateur de rejouer ou non le jeu.
        boolean ouiNon = false; // Variable qui applique le choix oui/non de l'utilisateur pour relancer une partie.

        do {
            System.out.println("\nVoulez vous rejouer (o/n) ?\n");
            decision = scan.next().toLowerCase().charAt(0);

        } while (decision != 'o' && decision != 'n');

        if (decision == 'o')
            ouiNon = true;

        return ouiNon;
    }

    /**
     * @param tabPartie Tableau des resultats de la partie du joueur.
     * @return Retourne la moyenne des resultats de la partie du joueur.
     */
    public static double moyenneTableau(int[] tabPartie) {

        double moyenne; // Moyenne du tableau
        int somme = 0; // Somme du tableau

        for (int elem : tabPartie) {
            somme += elem;
        }
        moyenne = ((double) somme / tabPartie.length) * 10;

        return moyenne;
    }

    /**
     * Permet de copier un tableau et de le renvoyer.
     * @param tabPartie Tableau des resultats de la partie du joueur.
     * @param nouveauTab Nouveau tableau des resultat qui possede une plus grande longueur.
     */
    public static void copieTab(int[] tabPartie, int[] nouveauTab) {

        for (int i = 0; i < tabPartie.length; i++) {
            nouveauTab[i] = tabPartie[i];
        }
    }

    /**
     * Permet d'ajouter un element dans un tableau tout en agrandissant ce dernier grace a copieTab.
     *
     * @param tabPartie Tableau des resultats de la partie du joueur.
     * @param resultat  Resultat en entier des parties du joueur.
     * @return Retourne un nouveau tableau avec les derniers resultat du joueur a l'interieur.
     */
    public static int[] addElemTab(int[] tabPartie, int resultat) {

        int[] nouveauTab = new int[tabPartie.length + 1]; // Nouveau tableau qui possède une longueur +1 de tabPartie.

        copieTab(tabPartie, nouveauTab);

        nouveauTab[nouveauTab.length - 1] = resultat;

        return nouveauTab;
    }

    /**
     * Dessin de fermeture de programme incluant la moyenne de la partie!
     * @param moyenneGP Moyenne total des parties gagnées et perdues.
     */
    public static void finProgramme(double moyenneGP) {
        DecimalFormat df = new DecimalFormat("0.00");

        String dessin;
        dessin =
                """
                                                                          \\,`/ /\s
                                                                         _)..  `_
                                                                        ( __  -\\
                                                                            '`.                 \s
                                                                           ( \\>_-_,\040
                        `                 __-----_.                        ________
                        """ +
                        "                /  \\      \\           o  O  O _(           )__\n" +
                        "                /    |  |   \\_---_   o._.    _(              )_\n" +
                        "                |     |            \\   | |" + "\"" + " (_     " + df.format(moyenneGP) + "%     _)\n" +
                        "                |     |             |@ | |   (_              _) \n" +
                        "                 \\___/   ___       /   | |     (__        __)\n" +
                        "                   \\____(____\\___/     | |       (________)\n" + """
                                           |__|                | |          |
                                           /   \\-_             | |         |'
                                         /      \\_ "__ _       !_!--v---v--"
                                        /         "|  |>)      |""\"""\"""|
                                       |          _|  | ._--""||        |
                                       _\\_____________|_|_____||________|_
                                      /                                   \\
                                     /_____________________________________\\
                                     /                                     \\
                                    /_______________________________________\\
                                    /                                       \\
                                   /_________________________________________\\
                                        {                               }
                                        <_______________________________|
                                        |                               >
                                        {_______________________________|               ________
                                        <                               }              / SNOOPY \\
                                        |_______________________________|             /__________\\
                                \\|/       \\\\/             \\||//           |//                       \\|/    |/
                                
                        """;
        System.out.println(dessin);
    }

    /**
     * Titre graphique du jeu de multiplication
     */
    public static void menu() {

        String dessin;
                dessin= """

                ███╗░░░███╗██╗░░░██╗██╗░░░░░████████╗██╗██████╗░██╗░░░░░██╗░█████╗░░█████╗░████████╗██╗░█████╗░███╗░░██╗
                ████╗░████║██║░░░██║██║░░░░░╚══██╔══╝██║██╔══██╗██║░░░░░██║██╔══██╗██╔══██╗╚══██╔══╝██║██╔══██╗████╗░██║
                ██╔████╔██║██║░░░██║██║░░░░░░░░██║░░░██║██████╔╝██║░░░░░██║██║░░╚═╝███████║░░░██║░░░██║██║░░██║██╔██╗██║
                ██║╚██╔╝██║██║░░░██║██║░░░░░░░░██║░░░██║██╔═══╝░██║░░░░░██║██║░░██╗██╔══██║░░░██║░░░██║██║░░██║██║╚████║
                ██║░╚═╝░██║╚██████╔╝███████╗░░░██║░░░██║██║░░░░░███████╗██║╚█████╔╝██║░░██║░░░██║░░░██║╚█████╔╝██║░╚███║
                ╚═╝░░░░░╚═╝░╚═════╝░╚══════╝░░░╚═╝░░░╚═╝╚═╝░░░░░╚══════╝╚═╝░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░╚════╝░╚═╝░░╚══╝

                    ░██████╗░░█████╗░███╗░░░███╗███████╗
                    ██╔════╝░██╔══██╗████╗░████║██╔════╝
                    ██║░░██╗░███████║██╔████╔██║█████╗░░
                    ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░                      O_      __)(
                    ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗                    ,'  `.   (_".`.
                    ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝                   :      :    /|`
                                                                           |      |   ((|_  ,-.
                                                                           ; -   /:  ,'  `:(( -\\
                                                                         /    -'  `: ____ \\\\\\-:
                                                                        _\\__   ____|___  \\____|_
                                                                       ;    |:|        '-`      :
                                                                      :_____|:|__________________:
                                                                      ;     |:|                  :
                                                                     :      |:|                   :
                                                                     ;______ `'___________________:
                                                                    :                              :
                                                                    |______________________________|
                                                                    `---.--------------------.---'
                                                                        |____________________|
                                                                        |                    |
                                                                        |____________________|
                                                                        |                    |
                                                                      _\\|_\\|_\\/(__\\__)\\__\\//_|(_

                """;
        System.out.println(dessin);
    }
}
