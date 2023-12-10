package gui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaAgregarContacto extends Ventana {
    private JLabel textoEncabezado, textoNombre, textoApodo, textoNumero, textoCorreo, textoFavorito;
    private JTextField campoNombre, campoApodo, campoNumero, campoCorreo;
    private JButton botonAgregar, botonCancelar;
    private JComboBox listaFavorito;
    private ContactIQApp contactIQApp;
    private void generarEncabezado() {
        String textoCabecera = "Registro de Contactos";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    public VentanaAgregarContacto(ContactIQApp contactIQApp){
        super("Registro de Contactos", 500, 520);
        this.contactIQApp = contactIQApp;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarListaFavorito();
        generarCampoNombre();
        generarCampoApodo();
        generarCampoNumero();
        generarCampoCorreo();
        generarBotonAgregar();
        generarBotonCancelar();
    }

    private void generarCampoNombre(){
        String textoNombre= "Nombre Contacto: ";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }

    private void generarListaFavorito(){
        super.generarJLabel(this.textoFavorito,"¿Favorito?:",20,100,100,20);
        String [] listaDesplegable = new String[]{"No","Si"};
        this.listaFavorito=super.generarListaDesplegable(listaDesplegable,120,100, 100, 20);
        this.add(this.listaFavorito);
    }

    private void generarCampoApodo() {
        super.generarJLabel(this.textoApodo, "Apodo:", 20, 150, 200, 20);
        this.campoApodo = super.generarJTextField(200, 150, 250, 20);
        this.add(this.campoApodo);
    }

    private void generarCampoNumero() {
        super.generarJLabel(this.textoNumero, "Numero:", 20, 200, 200, 20);
        this.campoNumero = super.generarJTextField(200, 200, 250, 20);
        this.add(this.campoNumero);
    }

    private void generarCampoCorreo() {
        super.generarJLabel(this.textoCorreo, "Correo:", 20, 250, 200, 20);
        this.campoCorreo = super.generarJTextField(200, 250, 250, 20);
        this.add(this.campoCorreo);
    }

    private void generarBotonAgregar() {
        String textoBoton= "Agregar Contacto";
        this.botonAgregar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonAgregar);
        this.botonAgregar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }

    private boolean agregarContacto() {
        if (this.campoNombre.getText().isEmpty() || this.campoApodo.getText().isEmpty() ||
                this.campoNumero.getText().isEmpty() || this.campoCorreo.getText().isEmpty() || this.listaFavorito.getSelectedItem() == null) {
            return false;
        } else {
            try {
                String nombre = this.campoNombre.getText();
                String apodo = this.campoApodo.getText();
                String numero = this.campoNumero.getText();
                String editorial = this.campoCorreo.getText();

                String favoritoSeleccionado = (String) this.listaFavorito.getSelectedItem();

                Favorito favorito = Favorito.valueOf(favoritoSeleccionado.replace(" ", "_").toUpperCase());

                contactIQApp.agregarContacto(nombre, apodo, Integer.parseInt(numero), editorial, favorito);
                return true;
            } catch (IllegalArgumentException e) {
                // Manejo de excepciones si la conversión falla (por ejemplo, si el String no coincide con ningún valor del enum)
                return false;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonAgregar){
            if(agregarContacto()){
                Favorito favorito = Favorito.valueOf(((String) this.listaFavorito.getSelectedItem()).replace(" ", "_").toUpperCase());
                JOptionPane.showMessageDialog(this,"Contacto agregado correctamente","Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(contactIQApp);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(contactIQApp);
            this.dispose();
        }

    }
}