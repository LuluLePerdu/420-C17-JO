import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.util.Arrays;

public class View {

    JFrame frame;
    JTextArea txa1;
    JScrollPane scrTxa1;
    JButton btnTrierTxa;
    //JButton btnFouiller;
    //JButton btnQuitter;

    Dimension dimTxa = new Dimension(100,100);

    public View(){
        frame = new JFrame("First frame");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        txa1 = new JTextArea();
        txa1.setPreferredSize(dimTxa);

        scrTxa1 = new JScrollPane(txa1);
        scrTxa1.setPreferredSize(dimTxa);

        btnTrierTxa = new JButton("Trier txa");
        btnTrierTxa.addActionListener(e -> btnTrierTxaAction());


        frame.add(txa1);
        frame.add(btnTrierTxa);
        //frame.add(btnFouiller);
        //frame.add(btnQuitter);

        frame.setVisible(true);

    }

    private void btnTrierTxaAction() {

        String[] tab = txa1.getText().split("\n");

    }

    public static void main(String[] args) {
        View v = new View();

    }

}
