package com.company;

/**
 * Ludwig-E.Dufour
 * Session A2021
 * 2031990
 */

public class Main {
// METTRE PUBLIC SI EN DEHORS DE MAIN
    public enum  Prof {
        FRANCE, JF, PATRICK, MICHEL, CHARLES, PHIL, YOUCEF
    }
    public static void main(String[] args) {

        Prof vieuxProf;
        Prof jeuneProf;

        //Prof = Prof.JF; Ce n'est pas une variable, mais un type, donc on ne peux pas afecté une valeur

        vieuxProf = Prof.FRANCE;
        jeuneProf = Prof.PHIL;

        jeuneProf = vieuxProf;

    // Exemple 2

        // Type énuméré
        enum Niveau {
            HAUT, BAS, MOYEN,
        }

        Niveau nomVariable1;
        nomVariable1 = Niveau.BAS;

        Niveau nomvariable2;
        nomvariable2 =  Niveau.HAUT;

        nomVariable1 = nomvariable2;

        System.out.println(nomVariable1);


    }
}
