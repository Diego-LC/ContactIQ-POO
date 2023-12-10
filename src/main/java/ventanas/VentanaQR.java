package ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaQR extends JFrame {
    public VentanaQR(String titulo) {
        super(titulo);
        setLayout(new FlowLayout());
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("qr.png");
        JLabel label = new JLabel();
        label.setIcon(imageIcon);

        add(label);
        setVisible(true);
    }
}
