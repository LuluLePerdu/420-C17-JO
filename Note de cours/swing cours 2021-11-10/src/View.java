import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class View extends JFrame{
    JFrame frame;
    JTextArea txa1, txa2, txa3; //txa_NOM
    JScrollPane scrTxa1, scrTxa2, scrTxa3; //scollPane sert pour le text area
    JButton btnGO;

    Dimension dimTxa = new Dimension(100,100);

    String sGeek = "Un geek ne vieillit pas, il se met à jour";

    public View(){
        frame = new JFrame("JTextArea demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //ferme l'execution
        frame.setSize(600,300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        txa1 = new JTextArea(sGeek);

        scrTxa1 = new JScrollPane(txa1); //on mets entre parenthese l'objet qu'on veux
        scrTxa1.setPreferredSize(dimTxa);

        txa2 = new JTextArea(sGeek);
        txa2.setLineWrap(true); //coupe le mot au lieu d'une barre de défilement

        scrTxa2 = new JScrollPane(txa2);
        scrTxa2.setPreferredSize(dimTxa);

        txa3 = new JTextArea(sGeek);
        txa3.setLineWrap(true);
        txa3.setWrapStyleWord(true); //ne coupe pas le mots, mais renvoie le mot complet à la prochaine ligne

        txa3.setText("un\ndeux\ntrois\nquatre");

       /* //ajouter "CINQ" à la fin
        txa3.append("\ncinq");

        //insérer "zéro" au début
        txa3.insert("zéro\n",0);

        //insérer "un1" aprés zéro
        txa3.insert("un1\n",5); //indice 5 (le \n compte en indice)

        txa3.setText("J'aime les math et la prog");
        //remplacer math par "bonbons"
        //txa3.replaceRange("bonbons", 11,15);
        //remplacer la prog par "les bonbons" (prendre l'indice de début du mots et +1 pour l'indice de fin)
        txa3.replaceRange("les bonbons", 19,26);*/ //remplacer du texte



        scrTxa3 = new JScrollPane(txa3);
        scrTxa3.setPreferredSize(dimTxa);

        btnGO = new JButton("GO");
        btnGO.addActionListener(e -> btnGOAction());


        frame.add(scrTxa1);
        frame.add(scrTxa2);
        frame.add(scrTxa3);
        frame.add(btnGO);

        frame.setVisible(true);
    }

    private void btnGOAction() {
        //récupérer le texte du txa3 dans une chaine et l'afficher en console
        String texte = txa3.getText();
        System.out.println(texte);

        //faire un tableau de String avec les lignes du txa3
        String[] tab = txa3.getText().split("\n");
        System.out.println(Arrays.toString(tab));

        System.out.println(tab.length);
        System.out.println(txa3.getLineCount()); //nombre de ligne physique dans le txa3

        System.out.println(txa2.getLineCount());// (sans \n, nbLigne = 1)

        //garnir txa3 à partir d'un tableau de String
        String[] tab2 = {"Allo", "Bonjour", "Salut", "Adieu"};

        txa3.setText("");
        for (String elem: tab2)
            txa3.append(elem + "\n");

    }

    public static void main(String[] args) {
        View v = new View();

    }
}
