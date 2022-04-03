package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int[] tabInt = {1, -2, 240, 22, -3, 23, 10, 1, 99, 125};
        //triBSUp(tabInt); Bubble sort
        triSSSUp(tabInt);
        System.out.println(Arrays.toString(tabInt));

         String test = "piano";
    int index = indexDeChar(test, 'a');
        System.out.println(index);
        System.out.println(indexDeChar(test, 'z')); //fouille

    }

    public static void  triSSSUp(int[] tableau){
        int imin; //indice du plu spetit

        for (int i=0; i<tableau.length-1; i++){
            imin = i;

            for (int j=i; j< tableau.length; j++){
                if (tableau[j] < tableau[imin])
                    imin = j;
            }

            if (imin != i)
                permute(tableau, i, imin);
        }
    }

    public static void permute(int[] tab, int ind1, int ind2){
        int transit = tab[ind1];
        tab[ind1] = tab[ind2];
        tab[ind2] = transit;
    }

 /*   public static void triBSUp(int[] tableau){

        for (int i = 0; i<tableau.length-1; i++)
            for (int j =i+1; j<tableau.length; j++)
                if (tableau[j] < tableau[i])
                    permute(tableau, j, i);*/

    /**
     * Retourne l'index du caractère cherché dans le texte
     * @param texte chaîne a parcourir
     * @param carChercher caractère recherché
     * @return retourne l'index du caractère cherché, sinon retourne -1
     */
    public static int indexDeChar(String texte, char carChercher){
        int i = 0; //indice de texte
        boolean trouve = false; //indicater de recherche

        while (!trouve && i < texte.length()){
            if (texte.charAt(i) == carChercher)
                 trouve = true;
            else
                i++;
        }

        if (trouve)
            return i;
        else
            return -1;

    }

}
