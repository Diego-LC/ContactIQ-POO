package ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controlador.Controlador;
import model.PerfilUsuario;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConfirmacionBorrado extends JFrame implements ActionListener {
    private Controlador controlador;
    private String numero;

    public VentanaConfirmacionBorrado(String numero, Controlador controlador, JFrame ventanaAnterior) {
        super("Confirmar borrado");
        this.controlador = controlador;
        this.numero = numero;
        
        JLabel label = new JLabel("¿Estás seguro de que quieres borrar este contacto?");
        this.add(label);
        
        JButton botonConfirmar = new JButton("Confirmar");
        botonConfirmar.addActionListener(this);
        this.add(botonConfirmar);
        
        this.pack();
        this.setMinimumSize(new Dimension(200,200));
        super.setLocationRelativeTo(ventanaAnterior);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PerfilUsuario perfilUsuario = this.controlador.getPerfilUsuario();
        perfilUsuario.eliminarContacto(numero);
        controlador.exportarContactos(perfilUsuario);
        JOptionPane.showMessageDialog(this, "Contacto borrado");
        this.dispose();
    }
}