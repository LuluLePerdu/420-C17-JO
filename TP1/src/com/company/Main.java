package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Ludwig-Emmanuel Dufour
 * 2031990
 * Session A2021
 * Un jeu de nombre mystère consiste à trouver un nombre entre 1 et 99, sélectionné au hasard,
 * selon un nombre d’essais limités à cinq.
 */

public class Main {

    public static void main(String[] args) {

        Random r = new Random();
        Scanner scan = new Scanner(System.in);

        int borneInferieur = 0;                 // Limite inférieur où se trouve la nombre mystere.
        int borneSuperieur = 100;               // Limite supérieur où se trouve la nombre mystere.
        int nbTentatives = 1;                   // Nombre de tentatives pour trouver le nombre mystère.
        int nbMystere = r.nextInt(100);   // Nombre mystère généré aléatoirement.
        int essai = 0;                          // Essai indiqué par le joueur pour trouver le nombre mystere.
        int menu = 0;                           // Entrée au clavier du choix de l'utilisateur pour la section menu.
        String AsciiArtErreur = dessinErreur(); // Affiche une surprise lors d'une mauvaise entrée est effectué.
        String AsciiArtMenu = dessinMenu();     // Dessin du menu prinicpal.

        System.out.println(AsciiArtMenu);

        menu = menu(menu);

        switch (menu) {
            case 1 -> {
                System.out.println("nb Mystère pour correction :" + nbMystere);
                System.out.println("\n>Vous avez cinq essaies pour trouver un nombre généré entre 1 et 99 ");

                do {
                    System.out.print("\n\t>(" + nbTentatives + "/5) " + borneInferieur + " < ? < "
                            + borneSuperieur + " : ");

                    try {
                        essai = scan.nextInt();
                    } catch (InputMismatchException e) {

                        System.out.println(AsciiArtErreur);
                        scan.next();
                        nbTentatives--;
                    }
                    if (essai > 1 && essai < 100) {
                        nbTentatives++;
                        borneSuperieur = limiteBorneSup(essai, nbMystere, borneSuperieur);
                        borneInferieur = limiteBorneInf(essai, nbMystere, borneInferieur);

                    } else
                        System.out.println("\n\t>Votre entier n'est pas dans l'intervalle du jeu.");
                }
                while (essai != nbMystere && nbTentatives <= 5);

                if (essai == nbMystere) {

                    System.out.println("""
                                       -----------------
                            \t (ﾉ｡･ω･)ﾉ Félicitation ヽ(･ω･｡ヽ)\s
                            ---------------------------------------""");
                } else
                    System.out.println("\n(*╯-╰)ノ >Malheureusement ce n'est pas le bon nombre, le nombre mystère était"
                            + " " + nbMystere);
                scan.close();
            }
            case 2 -> System.out.println("Fermeture du programme...");
        }

    }

    /**
     * Menu de presentation du jeu de nombre mystere
     *
     * @param menu Differente entree possible dans le menu, qui vont permettre de lancer le programme ou de l'arreter.
     * @return retourne le choix de l'utilisateur du menu pour lancer ou arreter le programme.
     */
    public static int menu(int menu) {

        Scanner scan = new Scanner(System.in);

        while (menu != 1 && menu != 2) {

            try {
                System.out.println("Votre choix : ");
                menu = scan.nextInt();

            } catch (InputMismatchException e) {
                scan.next();
            }

            if (menu == 1) {
                System.out.println("Création d'un nombre mystère...");
            } else if (menu == 2) {
                System.out.println("Au revoir!");

            } else {
                System.out.println("""
                        Votre choix est incorrect merci d'entrez une valeur du menu\s
                        \t>1: Créer une nouvelle partie.\s
                        \t>2: Quitter""");
            }
        }
        return menu;
    }

    /**
     * Permet de determiner la nouvelle limite de la borne superieur, sans toutefois la changer si une valeur est
     * plus grande que celle presente.
     *
     * @param essai          Essai indique par le joueur pour trouver le nombre mystere.
     * @param nbMystere      Nombre mystere genere aleatoirement.
     * @param borneSuperieur Limite superieur ou se trouve la nombre mystere.
     * @return Retourne la nouvelle borne superieur.
     */
    public static int limiteBorneSup(int essai, int nbMystere, int borneSuperieur) {

        if (essai > nbMystere && essai < borneSuperieur)
            borneSuperieur = essai;

        return borneSuperieur;
    }

    /**
     * Permet de determiner la nouvelle limite de la borne inferieur, sans toutefois la changer si une valeur est
     * plus petite que celle presente.
     *
     * @param essai          essai indique par le joueur pour trouver le nombre mystere.
     * @param nbMystere      nombre mystere genere aleatoirement.
     * @param borneInferieur limite inferieur ou se trouve la nombre mystere.
     * @return retourne la nouvelle borne inferieur.
     */
    public static int limiteBorneInf(int essai, int nbMystere, int borneInferieur) {

        if (essai < nbMystere && essai > borneInferieur)
            borneInferieur = essai;

        return borneInferieur;
    }

    /**
     * Dessin en ASCII du menu principal.
     *
     * @return retourne une chaine de caractere representant le menu principal.
     */
    public static String dessinMenu() {

        String dessin;

        dessin = """

                ------------------------------------------\t
                \tBIENVENUE AU JEU DU NOMBRE MYSTÈRE
                \t\t----------- Menu -----------        ┌───────────────────────────────┐\s
                                                            │  1. Créer une nouvelle partie │\s
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                            │    2. Quitter⠀   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀│⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀.⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀        └───────────────────────────────┘   \s
                ⠀                  ⣠⡶⣇⠀                        \s
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠋⢹⣿⠀⠀⠀⠀⠀⠀⣠⡄            ⠀    \s
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⠄⡀⠀⠀⠀⢐⣣⣿⢠⡾⠿⢇⠀⠀⣀⣰⣾⡛⠁           ⠀  ⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠔⣌⠋⠉⠉⠁⠑⠊⢑⠇⠀⠀⡁⢀⣿⠛⠿⠿⢷⣴⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣀⡀⣀⣼⠏⠀⠀⣠⣿⡟⠀⠀⠀⠀⠙⣯⠓⠃⠀⠀⠀⠀⠀⠀⠀      \s
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣠⣤⣄⣀⣀⣤⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⣿⡿⠟⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⢿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡃⠘⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠻⢿⣦⣿⣿⣿⣿⣿⣄⠀⣿⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⢮⣿⣿⣿⣿⣿⣿⣷⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣾⣟⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠙⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⠛⠈⢻⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠠⠡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡈⢀⠌⠅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⢁⠜⠀⠄⠄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠒⠄⣀⣀⠀⠠⠐⠊⠂⢀⠀⠀⠀⠀⠀⠉⠀⠨⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀           ⠀⠀⠀⠀⠁⠢⠀⡠⠐⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\s""";
        return dessin;
    }

    /**
     * Methode qui permet d'ajouter un dessin dans le code en cas d'erreur.
     *
     * @return retourne une chaine de caractere representant un message d'erreur.
     */
    public static String dessinErreur() {

        String dessin; //chaine de caracteres de l'ASCII Art :)

        dessin = ("""
                              ___
                          _.-'   \\
                         /        \\
                        /          \\
                       /            `.___
                      ( .--.)\\/(,.--.    `-.
                      ,',-. \\   / ,-.`.     )             . @@. .. ..@.. .. .@@ .  \s
                     ( /   \\     /      \\ )   / \\        . @ .                    . @ \s
                      || .-|     |-. ||---'|  \\      @ .                         . @.
                     _|| | |     | | ||_   |   \\       Vous devez entrez un entier.\s
                    /. \\ |_|.---.|_| / ,\\  | .^.\\    @ .                           @.\s
                    `.\\ `--"     "--' /,'  |/          @ .                     . @  \s
                      `>  _________ <'                     &. @@ .. ..@..  .@@ .   \s
                    ,-' ,---.---.---. `-.               @.                        \s
                    `--'\\    \\j/    /`--'           .                          \s
                       `.\\         /,'
                         \\\\_______//
                """);

        return dessin;
    }
}