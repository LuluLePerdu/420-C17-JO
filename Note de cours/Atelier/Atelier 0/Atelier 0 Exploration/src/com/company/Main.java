package com.company;

/**
 * Auteur Ludwig-Emmanuel Dufour
 * DA 2031990
 * Cours 420-C17-JO
 * Chapitre 1
 * Activité 0
 */

public class Main {

    public static void main(String[] args) {

//Exercices avec int

        int a;
        a = -18;

        int b;
        b = 123;

        int c;
        c = 3,442;
        //Not a statement

        int d;
        d = 3.442;
        //Required type: int, provided: double

        int e;
        e = 3 442;
        //Not a statement

        int f;
        f = 3_442;

//Exercices avec double

        double d1;
        d1 = 3_442;

        double d2;
        d2 = -10.0;

        double d3;
        d3 = 3.012;

        double d4;
        d4 = .5;

        double d5;
        d5 = 0.123;

        double d6;
        d6 = 2;

        double d7;
        d7 = 1.23E-24;

        double d8;
        d8 = 3.;

        double d9;
        d9 = 3,442;
        //Not a statement

//Exercices avec boolean

        boolean b1;
        b1 = vrai;
        //Cannot resolve "vrai"

        boolean b2;
        b2 = true;

        boolean b3;
        b3 = 0;
        //Required type: boolean, provided : int

        boolean b4;
        b4 = false;

        boolean b5;
        b5 = 1;
        //Required type: boolean, provided : int

//Exercices avec char

        char c1;
        c1 = 'A';

        char c2;
        c2 = ' ';

        char c3;
        c3 = '..';
        //Too many characters in character literal

        char c4;
        c4 = '''';
        //Empty character literal

        char C5;
        C5= '\'';

        char c6;
        c6 = '$';

        char c7;
        c7 = "Allo";
        //Required type : char. Provided : string

//Exercices avec String

        String ch1;
        ch1 = 'A';
        //Required String. Provided : char

        String ch2;
        ch2 = "'";

        String ch3;
        ch3 = "il fait "CHAUD"";
        //Cannot resolve symbole CHAUD and not a statement
        ch3 = "il fait \"CHAUD\"";

    }
}
