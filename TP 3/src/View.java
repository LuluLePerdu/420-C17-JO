import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ludwig-Emmanuel Dufour
 * 2031990
 * Session A2021
 * Analyser le texte d’un JTextArea, en extraire les mots et les nombres, effectuer des recherches et des tris.
 */

public class View extends JFrame {

    JFrame frame;

    JPanel panInferieur;
    JPanel panSuperieur;
    JPanel panCentre;
    JPanel panDroite;

    //-----------JCheckBox---------//
    JCheckBox chbPermettreDoublons;

    //--------JRadioButton--------//
    JRadioButton radTrierCroissant;
    JRadioButton radTrierDecroissant;

    //---------JTexteArea---------//
    JTextArea txaRechercher;
    JTextArea txaTexte;
    JTextArea txaMots;
    JTextArea txaNombres;

    //---------JScrollPane--------//
    JScrollPane scrRechercher;
    JScrollPane scrTexte;
    JScrollPane scrMots;
    JScrollPane scrNombres;

    //-----------JLabel-----------//
    JLabel labFouille;
    JLabel labMots;
    JLabel labNombres;

    //-----------JButton-----------//
    JButton btnRecherche;
    JButton btnExtraireMots;
    JButton btnViderMots;
    JButton btnExtraireNombres;
    JButton btnViderNombres;
    JButton btnTrierMots;
    JButton btnTrierNombres;
    JButton btnInfoMots;
    JButton btnInfoNombre;
    JButton btnQuitter;
    JButton btnDessin;

    Dimension dimTxa = new Dimension(400, 470);
    Dimension dimRech = new Dimension(150, 24);
    Dimension dimMax = new Dimension(1000, 500);
    Dimension dimMin = new Dimension(700, 700);
    Dimension dimBtn = new Dimension(200,30);

    public View() {

        frame = new JFrame("Ludwig-Emmanuel Dufour 2031990");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMaximumSize(dimMax);
        frame.setMinimumSize(dimMin);
        frame.setSize(1080, 580);
        frame.setLocationRelativeTo(null);

        //-------------Text Area-------------//
        txaMots = new JTextArea();
        txaMots.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        txaMots.setEditable(false);
        txaMots.setLineWrap(false);
        txaMots.setWrapStyleWord(true);

        txaNombres = new JTextArea();
        txaNombres.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        txaNombres.setEditable(false);
        txaNombres.setLineWrap(false);
        txaNombres.setWrapStyleWord(true);

        txaRechercher = new JTextArea();
        txaRechercher.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        txaRechercher.setPreferredSize(dimRech);
        txaRechercher.setEditable(true);
        txaRechercher.setLineWrap(false);
        txaRechercher.setWrapStyleWord(true);

        txaTexte = new JTextArea();
        txaTexte.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        txaTexte.setEditable(true);
        txaTexte.setLineWrap(false);
        txaTexte.setWrapStyleWord(false);

        //-------------Scroll Pane-------------//
        scrMots = new JScrollPane(txaMots);
        scrMots.setPreferredSize(dimTxa);

        scrNombres = new JScrollPane(txaNombres);
        scrNombres.setPreferredSize(dimTxa);

        scrRechercher = new JScrollPane(txaRechercher);

        scrTexte = new JScrollPane(txaTexte);
        scrTexte.setPreferredSize(dimTxa);

        //-------------Label-------------//
        labFouille = new JLabel("Lab Fouille");
        labMots = new JLabel("Mots");
        labMots.setText("Mots : 0");
        labNombres = new JLabel("Nombre");
        labNombres.setText("Nombres : 0");

        //-------------Buttons-------------//
        btnDessin = new JButton("Surprise");
        btnDessin.addActionListener(e -> btnDessinAction());
        btnDessin.setMaximumSize(dimBtn);

        btnExtraireMots = new JButton("Extraire mots");
        btnExtraireMots.setMaximumSize(dimBtn);
        btnExtraireMots.addActionListener(e -> btnExtraireMotsAction());
        btnExtraireNombres = new JButton("Extraire Nombre");
        btnExtraireMots.setMaximumSize(dimBtn);
        btnExtraireNombres.addActionListener(e -> btnExtraireNombresAction());
        btnExtraireNombres.setMaximumSize(dimBtn);

        btnInfoMots = new JButton("Info Mots");
        btnInfoMots.setMaximumSize(dimBtn);
        btnInfoMots.addActionListener(e -> btnInfoMotsAction());
        btnInfoNombre = new JButton("Info Nombre");
        btnInfoNombre.setMaximumSize(dimBtn);
        btnInfoNombre.addActionListener(e -> btnInfoNombreAction());

        btnTrierMots = new JButton("Trier Mots");
        btnTrierMots.addActionListener(e -> btnTrierMotsAction());
        btnTrierMots.setMaximumSize(dimBtn);
        btnTrierNombres = new JButton("Trier Nombres");
        btnTrierNombres.addActionListener(e -> btnTrierNombresAction());
        btnTrierNombres.setMaximumSize(dimBtn);

        btnViderMots = new JButton("Vider Mots");
        btnViderMots.addActionListener(e -> btnViderMotsAction());
        btnViderMots.setMaximumSize(dimBtn);
        btnViderNombres = new JButton("Vider Nombres");
        btnViderNombres.addActionListener(e -> btnViderNombresAction());
        btnViderNombres.setMaximumSize(dimBtn);

        btnRecherche = new JButton("Recherche");
        btnRecherche.addActionListener(e -> btnRechercheAction());


        btnQuitter = new JButton("Quitter");
        btnQuitter.addActionListener(e -> btnQuitterAction());
        btnQuitter.setMaximumSize(dimBtn);

        //-----------Check Box-----------//
        chbPermettreDoublons = new JCheckBox("Permettre Doublons");
        chbPermettreDoublons.setSelected(true);

        //-----------Radio Button-----------//
        ButtonGroup radGroup;
        radGroup = new ButtonGroup();
        radTrierCroissant = new JRadioButton("Trier Croissant");
        radTrierDecroissant = new JRadioButton("Trier Décroissant");
        radTrierCroissant.setSelected(true);
        radGroup.add(radTrierCroissant);
        radGroup.add(radTrierDecroissant);

        //-----------Centre-----------//
        panCentre = new JPanel(new GridLayout(0, 3, 0, 0));
        panCentre.add(scrTexte);
        panCentre.add(scrMots);
        panCentre.add(scrNombres);

        //-----------Haut-----------//
        panSuperieur = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panSuperieur.add(Box.createRigidArea(new Dimension(40, 0)));
        panSuperieur.add(scrRechercher);
        panSuperieur.add(btnRecherche);
        panSuperieur.add(labFouille);

        //-----------Bas-----------//
        panInferieur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panInferieur.add(labMots);
        panInferieur.add(Box.createRigidArea(new Dimension(200, 25)));
        panInferieur.add(labNombres);
        panInferieur.add(Box.createRigidArea(new Dimension(200, 25)));
        panInferieur.add(btnQuitter);


        //-----------Droite-----------//
        panDroite = new JPanel();
        panDroite.setLayout(new BoxLayout(panDroite, BoxLayout.Y_AXIS));
        panDroite.add((Box.createRigidArea(new Dimension(0, 50))));
        panDroite.add(chbPermettreDoublons);
        panDroite.add((Box.createRigidArea(new Dimension(0, 5))));
        panDroite.add(btnExtraireMots);
        panDroite.add((Box.createRigidArea(new Dimension(0, 5))));
        panDroite.add(btnViderMots);
        panDroite.add(Box.createRigidArea(new Dimension(0, 40)));
        panDroite.add(btnExtraireNombres);
        panDroite.add((Box.createRigidArea(new Dimension(0, 5))));
        panDroite.add(btnViderNombres);

        panDroite.add(Box.createRigidArea(new Dimension(0, 40)));
        panDroite.add(radTrierCroissant);
        panDroite.add(radTrierDecroissant);
        panDroite.add(btnTrierMots);
        panDroite.add((Box.createRigidArea(new Dimension(0, 5))));
        panDroite.add(btnTrierNombres);

        panDroite.add(Box.createRigidArea(new Dimension(0, 40)));
        panDroite.add(btnInfoMots);
        panDroite.add((Box.createRigidArea(new Dimension(0, 5))));
        panDroite.add(btnInfoNombre);

        panDroite.add((Box.createRigidArea(new Dimension(0, 50))));
        panDroite.add(btnDessin);
        panDroite.add((Box.createRigidArea(new Dimension(0, 5))));
        panDroite.add(btnQuitter);

        //-----------Ajout frame-----------//
        frame.add(panSuperieur, BorderLayout.NORTH);
        frame.add(panCentre, BorderLayout.CENTER);
        frame.add(panInferieur, BorderLayout.SOUTH);
        frame.add(panDroite, BorderLayout.EAST);
        frame.setVisible(true);
    }

    /**
     * Affiche un dialogue de confirmation pour valider le choix de l'utilisateur s'il désire quitter on non le programme.
     */
    private void btnQuitterAction() {
        int rep; //Réponse de l'utilisateur pour fermer ou non le programme

        rep = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?",
                "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (rep == 0) {
            System.exit(0);
        }
    }

    /**
     * Retourne l'index des mots cherché dans le texte
     *
     * @param tab   chaîne à parcourir
     * @param texte Mot recherché
     * @param i     Index permettant de parcourir le tableau en entier
     * @return Retourne l'index du caractère cherché, sinon retourne -1
     */
    public static int nextIndexOf(String[] tab, String texte, int i) {

        boolean trouve = false; //indicateur de recherche

        while (i < tab.length && !trouve) {
            if (tab[i].equals(texte)) {
                trouve = true;
            } else
                i++;
        }
        if (trouve)
            return i;
        else {
            return -1;
        }
    }

    /**
     * Permet de copier un tableau et de le renvoyer.
     *
     * @param tab        Tableau comportant un nombre x d'éléments.
     * @param nouveauTab Nouveau tableau de "tab" qui possède une longueur supérieure de 1.
     */
    public static void copieTab(int[] tab, int[] nouveauTab) {

        for (int i = 0; i < tab.length; i++) {
            nouveauTab[i] = tab[i];
        }
    }

    /**
     * Rajoute un indice dans un tableau de int
     * @param tabIndex tableau d'indice de la méthode IndexOf
     * @param nouveauIndice indice à rajouter dans le tableau
     * @return Retourne un nouveau tableau avec les derniers indices actualisé de la recherche
     */
    public static int[] ajoutIndex(int[] tabIndex, int nouveauIndice) {

        int[] nouveauTab = new int[tabIndex.length + 1]; //Nouveau tableau qui possede une longueur +1.
        copieTab(tabIndex, nouveauTab);
        nouveauTab[nouveauTab.length - 1] = nouveauIndice;

        return nouveauTab;
    }

    /**
     * Recherche dans txaMots la chaîne du JTextField. Affiche dans labFouille le nombre
     * d’occurrences trouvées et affiche aussi l’indice de toutes les occurrences trouvées
     */
    private void btnRechercheAction() {

        int indice = 0; //indice de fouille
        int[] tabR = new int[0]; //Tableau des index des mots trouvés

        if (!txaRechercher.getText().isEmpty()) {
            if (chbPermettreDoublons.isSelected()) {
                indice = nextIndexOf(txaMots.getText().split("\n"), txaRechercher.getText(), indice);

                if (indice == -1)
                    labFouille.setText("Aucun mot trouvé");

                while (indice >= 0) {
                    tabR = ajoutIndex(tabR, indice);
                    //System.out.println(indice);
                    labFouille.setText(tabR.length + " mots trouvés aux indices " + Arrays.toString(tabR).
                            replace("[", "").replace("]", "").trim());

                    indice = nextIndexOf(txaMots.getText().split("\n"), txaRechercher.getText(), indice + 1);
                }
            } else {
                    indice = nextIndexOf(txaMots.getText().split("\n"), txaRechercher.getText(), indice);

                     if (indice == -1) {
                         labFouille.setText("Aucun mot trouvé");
                     }else
                            labFouille.setText("Mot trouvé a l'indice " + indice);

            }
        } else {
            indice = nextIndexOf(txaMots.getText().split("\n"), txaRechercher.getText(), indice);
                if (indice == -1)
                    labFouille.setText("Aucun mot trouvé");
        }
    }

    /**
     * Vide txaNombres et ajuste le JLabel "Nombres: ".
     */
    private void btnViderNombresAction() {

        txaNombres.setText("");
        labNombres.setText("Nombres : 0");
    }

    /**
     * Vide txaMots et ajuste le JLabel "Mots: ".
     */
    private void btnViderMotsAction() {

        txaMots.setText("");
        labMots.setText("Mots : 0");
    }

    /**
     * Tri SSS txaNombres selon l’ordre sélectionné (croissant/décroissant).
     */
    private void btnTrierNombresAction() {

        String resultat; //String contenant les résultats de la méthode
        int[] transit = conversionTab(txaNombres); //tableau transit entre toutes les méthodes

        if (radTrierCroissant.isSelected()) {
            triSSSUpInt(transit);

        } else {
            triSSSDownInt(transit);
        }
        resultat = Arrays.toString(transit).replace("[", "").replace("]", "").replace
                (",", "").trim().replaceAll(" ", "\n");
        txaNombres.setText(resultat);
    }

    /**
     * Méthode permettant de permuter les indices/arguments du tableau
     * @param tab // Tableau de Nombre
     * @param ind1 //  premier indice
     * @param ind2 // second indice
     */
    public static void permuteInt(int[] tab, int ind1, int ind2) {
        int transit = tab[ind1]; //permet de faire la transition entre les tableaux
        tab[ind1] = tab[ind2];
        tab[ind2] = transit;
    }

    /**
     *Méthode permettant de permuter les indices/arguments du tableau
     * @param ind1 //premier indice
     * @param ind2 // Second indice
     * @param tabMot //Tableau contenant mes mots/texte
     */
    public static void permuteMots(int ind1, int ind2, String[] tabMot) {
        String transit = tabMot[ind1]; //String transit entre les tableaux
        tabMot[ind1] = tabMot[ind2];
        tabMot[ind2] = transit;
    }

    /**
     * Permet de trier en ordre décroissant les entiers reçus dans le text Area "txaNombre"
     * @param tableau tableau du tu text Area "txaNombre"
     */
    public static void triSSSDownInt(int[] tableau) {

        int imin; //indice du plus petit

        for (int i = 0; i < tableau.length - 1; i++) {
            imin = i;

            for (int j = i; j < tableau.length; j++) {
                if (tableau[j] > tableau[imin])
                    imin = j;
            }

            if (imin != i)
                permuteInt(tableau, i, imin);
        }
    }

    /**
     * Permet de trier en ordre croissant les entiers reçus dans le text Area "txaNombre"
     * @param tableau tableau du tu text Area "txaNombre"
     */
    public static void triSSSUpInt(int[] tableau) {

        int imin; //indice du plus petit

        for (int i = 0; i < tableau.length - 1; i++) {
            imin = i;

            for (int j = i; j < tableau.length; j++) {
                if (tableau[j] < tableau[imin])
                    imin = j;
            }

            if (imin != i)
                permuteInt(tableau, i, imin);
        }
    }

    /**
     * Méthode permettant de convertir le text Area "txaNombre"
     * @param txaNombres text Area contenant les entiers reçus du text Area "txaTexte"
     * @return Retourne un tableau d'int avec le contenu du text Area "txaNombre"
     */
    public static int[] conversionTab(JTextArea txaNombres) {

        String[] transit; //tableau de String transit pour passer de String à int

        transit = txaNombres.getText().split("\\r?\\n");

        int longueur = transit.length;
        int[] tableau = new int[longueur]; //Tablea de int possédant la longueur de ma variable transit
        for (int i = 0; i < longueur; i++) {
            tableau[i] = Integer.parseInt(transit[i]);
        }
        return tableau;
    }

    /**
     * Tri SSS txaMots selon l’ordre sélectionné (croissant/décroissant) ASCII.
     */
    private void btnTrierMotsAction() {

        String[] mots = txaMots.getText().split("\n"); //Tableau contenant le texte de txaMot
        txaMots.setText("");
        if (radTrierCroissant.isSelected()) {

            triSSSUpString(mots);
            for (int k = 0; k < mots.length; k++)
                txaMots.append(mots[k] + "\n");
        } else {
            trisSSDownString(mots);
            for (int k = 0; k < mots.length; k++)
                txaMots.append(mots[k] + "\n");
        }
    }

    /**
     * Utilise la méthode tris selection SSS en décroissant
     * @param tabMot tableau du text Area "txaMot"
     */
    public static void triSSSUpString(String[] tabMot) {

        int imin; //Indice minimum

        for (int i = 0; i < tabMot.length - 1; i++){

            imin = i;

            for (int j = i + 1; j < tabMot.length; j++)
            if (tabMot[j].compareTo(tabMot[imin]) < 0)
            imin = j;

            if (imin != i)
                permuteMots(i,imin,tabMot);
        }
    }

    /**
     * Utilise la méthode tris selection SSS en décroissant
     * @param tabMot tableau du text Area "txaMot"
     */
    public static void trisSSDownString(String[] tabMot) {

        int imin; //indice minimum

        for (int i = 0; i < tabMot.length - 1; i++){

            imin = i;

            for (int j = i+1; j < tabMot.length; j++)
                if (tabMot[j].compareTo(tabMot[imin]) > 0)
                    imin = j;

            if (imin != i)
                permuteMots(i,imin,tabMot);
        }
    }

    /**
     * Permet de trouver l'entier le plus grand dans un text Area
     * @param txaNombres text Area contenant les entiers à analyser
     * @return Retourne l'entier le plus gros
     */
    public static int max(JTextArea txaNombres) {

        String strNombre = txaNombres.getText(); //String contenant le text du text Area "txaNombre"
        int maxNum = 0; // Valeur maximum des entiers
        int num; //Entiers identifiés par le regex

        //Regex pour ne prendre que les entiers positifs
        Pattern ptrn = Pattern.compile("\\d+");
        Matcher match = ptrn.matcher(strNombre);

        while (match.find()) {
            num = Integer.parseInt(match.group());
            if (num > maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    /**
     * Permet de trouver l'entier le plus petit dans un text Area
     * @param txaNombres text Area contenant les entiers à analyser
     * @return Retourne l'entier le plus petit
     */
    public static int min(JTextArea txaNombres) {
        String strTxa = txaNombres.getText(); //String contenant le text du text Area "txaNombre"
        int maxNum = 0; //Valeur maximum des entiers
        int num; //Entiers identifiés par le regex

        //Regex pour ne prendre que les entiers positifs et négatifs
        Pattern regex = Pattern.compile("-\\d+|\\d+");
        Matcher match = regex.matcher(strTxa);

        while (match.find()) {
            num = Integer.parseInt(match.group());
            if (num < maxNum) {
                maxNum = num;
            }
        }
        return maxNum;
    }

    /**
     * Affiche dans une boîte de message le nombre le plus petit et le plus grand de
     * txaNombres.
     */
    private void btnInfoNombreAction() {
        JOptionPane.showMessageDialog(frame, "Plus gros nombre : " + max(txaNombres)
                + "\n Plus petit nombre : " + min(txaNombres));
    }

    /**
     * Retourne la première chaîne la plus courte d’un tableau de chaînes.
     *
     * @param txaMots String/texte du Text Area Mots.
     * @return Retourne la première chaîne la plus courte d’un tableau de chaînes.
     */
    public static String sShorter(JTextArea txaMots) {

        String[] tabMot = txaMots.getText().split("\\r?\\n"); //Tableau du text Area "txaMot"
        String petitMot = ""; //Plus petit mot du text Area "txaMot"
        int i = txaMots.getText().length(); //Est la longueur du text Area "TxaMot"

        for (String mot : tabMot) {
            if (mot.length() < i) {
                i = mot.length();
                petitMot = mot;
            }
        }
        return petitMot;
    }

    /**
     * Retourne la première chaîne la plus longue d’un tableau de chaînes.
     * @param txaMots String/texte du Text Area Mots.
     * @return Retourne la première chaîne la plus longue d’un tableau de chaînes.
     */
    public static String sLonger(JTextArea txaMots) {

        String longMot = ""; //Contient le plus long mot du text Area
        int i = 0; //Indice pour comparer la longueur de tableau
        String[] tabMot; // tableau contenant le texte de txaMot

        tabMot = txaMots.getText().split("\\r?\\n");
        for (String mot : tabMot) { //
            if (i < mot.length()) {
                i = mot.length();
                longMot = mot;
            }
        }
        return longMot;
    }

    /**
     * Affiche dans une boîte de message le mot le plus court et le plus long de txaMots.
     */
    private void btnInfoMotsAction() {
        JOptionPane.showMessageDialog(frame, "Le plus petit mot est : " + sShorter(txaMots) + "\n Le plus grand" +
                " mot est : " + sLonger(txaMots));
    }

    /**
     * Extrait les nombres entiers de txaTexte. Met à jour le JLabel "Nombres: ".
     */
    private void btnExtraireNombresAction() {

        String strTxa; //String transit entre txaTexte vers txaNombre
        int comptNombres = 0; // Compteur de ligne du text area, pour identifier le nombre de mots
        int numberException; //Contient les entiers identifiés par le regex

        strTxa = txaTexte.getText();
        txaNombres.setText("");

        //Regex pour ne prendre que les entiers positifs et négatifs
        Pattern regex = Pattern.compile("-\\d+|\\d+");

        Matcher match = regex.matcher(strTxa);

        while (match.find()) {
            try {
                numberException = Integer.parseInt(match.group());
                txaNombres.append(numberException + "\n");
                comptNombres = txaNombres.getLineCount() - 1;
            } catch (NumberFormatException ignored) {
            }
            labNombres.setText("Nombres : " + comptNombres);
        }
    }

    /**
     * Extrait tous les mots de txaTexte avec ou sans doublons selon l’état de la case à cocher
     * "Permettre doublons". Met à jour le JLabel "Mots: ".
     */
    private void btnExtraireMotsAction() {

        String strMots; //Contient le texte brut du text Area txTexte
        int comptMots; // Compteur de mots

        if (chbPermettreDoublons.isSelected()) {

            strMots = txaTexte.getText();
            txaMots.setText("");

            //Regex qui ne prend que des lettres et certaine exception de ponctuation telle que '
            Pattern regex = Pattern.compile("(([a-zA-Z]+-[a-zA-Z]+)|([a-zA-Z]{1,2}+')|\\p{L}+'[a-zA-Z]+|\\p{L}+)");

            Matcher match = regex.matcher(strMots);

            while (match.find()) {
                txaMots.append(match.group() + "\n");
            }

            comptMots = txaMots.getLineCount() - 1;
            labMots.setText("Mots : " + comptMots);

        }

        if (!chbPermettreDoublons.isSelected()) {

            String unique = null;          //Contient le texte unique sans doublons du text Area "txaMots"
            strMots = txaTexte.getText(); //Contient le texte brut du text Area "txaTexte"

            txaMots.setText("");

            //Regex qui ne prend que des lettres et certaine exception de ponctuation telle que '
            Pattern regex = Pattern.compile("(([a-zA-Z]+-[a-zA-Z]+)|([a-zA-Z]{1,2}+')|\\p{L}+'[a-zA-Z]+|\\p{L}+)");

            Matcher match = regex.matcher(strMots);

            while (match.find()) {
                txaMots.append(match.group() + "\n");
            }

            unique = permettreDoublons(txaMots, unique);
            txaMots.setText(unique);

            comptMots = txaMots.getLineCount();
            labMots.setText("Mots : " + comptMots);
        }
    }

    /**
     * Si la case permettre doublons est décoché, cette méthode va enlever les mots en double du texte.
     * @param txaMots text Area "txaMot"
     * @param unique contient le texte sans doublons de txaMot
     * @return retourne le texte sans doublons et sans ligne vide dans le texte Area
     */
    public static String permettreDoublons(JTextArea txaMots, String unique) {

        String[] tabTxaMots = txaMots.getText().split("\n"); //Tableau contenant le texte du text Area "txaMot"

        for (int i = 0; i < tabTxaMots.length; i++) {
            for (int j = i + 1; j < tabTxaMots.length; j++) {
                if (tabTxaMots[i].equals(tabTxaMots[j])) {
                    tabTxaMots[i] = ("");
                    unique = Arrays.toString(tabTxaMots).replaceAll("\\s", "\n").
                            replace(",", "").replace("]", "").
                            replace("[", "").replaceAll("(?m)^[ \t]*\r?\n", "");
                }
            }
        }
        return unique;
    }

    public static void main(String[] args) {

        View v = new View();

    }

    /**
     * Petit retour sur la belle guitare du TP2 :)
     */
    private void btnDessinAction() {

        JOptionPane.showMessageDialog(frame,
                """
                        ___________$$$$$$___________\s
                        ___________$$$$$$___________\s
                        ____________$$$$____________\s
                        ____________$$$$____________\s
                        ____________$$$$____________\s
                        ____________$$$$____________\s
                        ____________$$$$____________\s
                        ____________$$$$____________\s
                        ___________$$$$$$___________\s
                        ___________$$$$$$___________\s
                        ___________$$$$$$___________\s
                        __________$$$$$$$$__________\s
                        __________$$$$$$$$__________\s
                        _____$$$$$$$$$$$$$$$$$$_____\s
                        ____$_____$$$$$$$$_____$____\s
                        ___$______$$$$$$$$______$___\s
                        ___$____________________$___\s
                        ____$__________________$____\s
                        _____$______$$$$______$_____\s
                        _____$____$$____$$____$_____\s
                        ____$_____$$____$$_____$____\s
                        ___$________$$$$________$___\s
                        __$______________________$__\s
                        _$________________________$_\s
                        _$________________________$_\s
                        _$______$$$$$$$$$$$$______$_\s
                        __$______________________$__\s
                        ___$____________________$___\s
                        ____$$$$____________$$$$____\s
                        ________$$$$$$$$$$$$________
                        """);
    }
}

//TEST
/*
C'était mieux aujourd'hui
  789
qu'autrefois?
Alice.

 80 au 03
56

pays 0004 des merveilles.
-04 -00000005
  -23

    111 Alice, une jeune fille
90   12345567892135678532430

curieuse, déurée, fonceuse et
intelligente.
        Sous-Sol*/
