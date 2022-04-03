import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] tabInt = {5,4,2,1,3};
        triBubbleSUp(tabInt);
        System.out.println(Arrays.toString(tabInt));
    }

    public static void triBubbleSUp(int[] tableau) {

        for (int i = 0; i < tableau.length - 1; i++)
            for (int j = i + 1; j < tableau.length; j++)
                if (tableau[j] < tableau[i])
                    permute(tableau, j, i);

    }
    public static void permute(int[] tab, int ind1, int ind2){

        int transit = tab[ind1];
        tab[ind1] = tab[ind2];
        tab[ind2] = transit;

    }
}
