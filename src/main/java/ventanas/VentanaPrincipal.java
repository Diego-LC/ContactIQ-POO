package ventanas;

import controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends VentanaGeneral implements ActionListener {
    private Controlador controlador;
    private JButton botonMostrarContactos;
    private JButton botonConfiguracion;
    private JButton botonMostrarAyuda;
    private JButton botonSalir;

    public VentanaPrincipal(Controlador controlador) {
        super("Ventana Principal");
        super.setSize(500, 500);
        this.controlador = controlador;
        this.generarElementos();
    }


    private void generarElementos() {
        super.generarJLabelEncabezado(this, "Bienvenido a Contact-IQ", 100, 20, 300, 30);
        this.generarBotonMostrarContactos();
        this.generarBotonMostrarConfiguracion();
        this.generarBotonMostrarAyuda();
        this.generarBotonSalir();
    }

    private void generarBotonMostrarContactos() {
        this.botonMostrarContactos = super.generarBoton("Mostrar lista de contactos", 100, 70, 300, 50);
        this.add(this.botonMostrarContactos);
        this.botonMostrarContactos.addActionListener(this);
    }

    private void generarBotonMostrarConfiguracion() {
        this.botonConfiguracion = super.generarBoton("Configuración", 100, 130, 300, 50);
        this.add(this.botonConfiguracion);
        this.botonConfiguracion.addActionListener(this);
    }

    private void generarBotonMostrarAyuda() {
        this.botonMostrarAyuda = super.generarBoton("Ayuda", 100, 190, 300, 50);
        this.add(botonMostrarAyuda);
        this.botonMostrarAyuda.addActionListener(this);
    }

    private void generarBotonSalir() {
        this.botonSalir = super.generarBoton("Salir", 100, 370, 300, 50);
        this.add(botonSalir);
        this.botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonMostrarContactos) {
            // Abre una nueva ventana para mostrar los contactos
            new VentanaListaContactos(this.controlador, this);
            this.setVisible(false);
        }

        if (e.getSource() == this.botonConfiguracion) {
            // Crear una nueva instancia de VentanaAgregarCafe y mostrarla
            //VentanaAgregarCafe ventanaAgregarCafe = new VentanaAgregarCafe(VentanaPrincipal.this, this.controlador);
            //ventanaAgregarCafe.setVisible(true);
            // Opcional: ocultar la ventana principal
            //setVisible(false);
        }

        if (e.getSource() == this.botonMostrarAyuda) {
            // Crear una nueva instancia de VentanaBuscarCafe y mostrarla
            //VentanaBuscarCafe ventanaBuscarCafe = new VentanaBuscarCafe(controlador, VentanaPrincipal.this);
            //ventanaBuscarCafe.setVisible(true);
            // Opcional: ocultar la ventana principal
           // setVisible(false);
        }

        if (e.getSource() == this.botonSalir){
            // Cierra la ventana
            System.exit(0);
            //controlador.guardarDatos();
        }
    }
}