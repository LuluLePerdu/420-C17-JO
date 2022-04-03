import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    JFrame frame;
    JRadioButton rad1;
    JRadioButton rad2;
    JRadioButton rad3;
    ButtonGroup grpA;
    JTextField txfNom;
    JCheckBox chbReadOnly;
    JCheckBox chbAcces;

    public View(){
        frame = new JFrame("Démo lundi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(350,300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        rad1 = new JRadioButton("Radio 1", true);
        rad1.addActionListener(e -> rad1Action());
        rad2 = new JRadioButton("Radio 2");
        rad3 = new JRadioButton("Radio 3");

        grpA = new ButtonGroup();
        grpA.add(rad1);
        grpA.add(rad2);
        grpA.add(rad3);

        txfNom = new JTextField();
        txfNom.setPreferredSize(new Dimension(100,30));

        chbReadOnly = new JCheckBox("Lecture seule");
        chbReadOnly.addActionListener(e -> chbReadOnlyAction());

        chbAcces = new JCheckBox("Accessibilité", true);
        chbAcces.addActionListener(e -> chbAccesAction());

        frame.add(rad1);
        frame.add(rad2);
        frame.add(rad3);
        frame.add(txfNom);
        frame.add(chbReadOnly);
        frame.add(chbAcces);

        frame.setVisible(true);
    }

    private void chbAccesAction() {
        txfNom.setEnabled(chbAcces.isSelected());
        chbReadOnly.setEnabled(chbAcces.isSelected());
    }

    private void chbReadOnlyAction() {

        /*if (chbReadOnly.isSelected())
            txfNom.setEditable(false);
        else
            txfNom.setEditable(true);*/

        txfNom.setEditable(!chbReadOnly.isSelected());
    }

    private void rad1Action() {
        System.out.println("Clic radio 1");
    }

    public static void main(String[] args) {
        View v = new View();

    }
}
