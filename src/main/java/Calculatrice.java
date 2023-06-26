import javax.swing.*;
import java.awt.*;

public class Calculatrice {
    public static void main(String... args) {
        JFrame application = createGUI();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
    private static JFrame createGUI(){
        //JTextField input = new JTextField();
        //input.setPreferredSize(new Dimension(300,40));
        JButton[] numeroButton = new JButton[10];
        //= new JButton[];
        for (int i = 0; i <10; i++) {
            numeroButton[i] = new JButton(String.valueOf(i));
        }
        JLabel output = new JLabel();
        output.setPreferredSize(new Dimension(300,40));

        JFrame gui = new JFrame("Calculatrice");
        int index =0;
        for (JButton numero : numeroButton
        ) {
            int finalIndex = index;
            numero.addActionListener(event -> {
                output.setText(Chiffre.ConvertToTitleCase(finalIndex));
            });

            gui.add(numero);
            index++;
            // numero.addActionListener();

        }

        gui.setLayout(new FlowLayout());
        //gui.add(input);

        gui.add(output);
        gui.pack();
        //gui.
        gui.setLocationRelativeTo(null); //pour centrer l'écran
        return gui;
    }
}
