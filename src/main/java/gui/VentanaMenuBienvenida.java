package gui;

import controller.ContactosController;
import model.ContactIQApp;

import javax.swing.*;
import java.awt.event.*;

public class VentanaMenuBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonAgregarContacto;
    private JButton botonBuscarContacto;
    private JButton botonSalida;
    protected ContactIQApp contactIQApp;

    public VentanaMenuBienvenida(ContactIQApp contactIQApp) {
        super("Agenda contactos", 500, 520);
        this.contactIQApp = contactIQApp;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonAgregarContacto();
        generarBotonBuscarContacto();
        // generarBotonVenderVehiculo();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de Biblioteca";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonAgregarContacto() {
        String textoBoton = "Agregar Contacto";
        this.botonAgregarContacto = super.generarBoton(textoBoton, 175, 100, 150, 40);
        this.add(this.botonAgregarContacto);
        this.botonAgregarContacto.addActionListener(this);
    }

    private void generarBotonBuscarContacto(){
        String textoBoton = "Buscar Contacto";
        this.botonBuscarContacto=super.generarBoton(textoBoton, 175, 260, 150, 40);
        this.add(this.botonBuscarContacto);
        this.botonBuscarContacto.addActionListener(this);
    }

    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonAgregarContacto) {
            VentanaAgregarContacto ventanaAgregarContacto = new VentanaAgregarContacto(contactIQApp);
            // Cierra la ventana actual
            this.dispose();
        }


        if (e.getSource() == this.botonBuscarContacto) {
            VentanaBuscarContacto ventanaBuscarContacto = new VentanaBuscarContacto(contactIQApp);
            this.dispose();
        }

        if (e.getSource() == this.botonSalida) {
            ContactosController.almacenarDatos(this.contactIQApp);
            this.dispose();
            System.exit(0);
        }
    }
}