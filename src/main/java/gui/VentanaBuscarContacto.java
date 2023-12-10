package gui;

import model.ContactIQApp;
import model.Favorito;
import model.Contacto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBuscarContacto extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoNombre, textoEspecialidad;
    private JComboBox listaFavorito;
    private JTextField campoNombre;
    private ContactIQApp contactIQApp;

    public VentanaBuscarContacto(ContactIQApp contactIQApp) {
        super("Búsqueda de Contactos", 500, 520);
        this.contactIQApp = contactIQApp;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarCampoNombre();
        generarBotonBuscarContacto();
        generarBotonCancelar();
        generarListaFavoritoContacto();
    }

    private void generarCampoNombre() {
        String textoNombre = "Nombre Contacto:";
        super.generarJLabel(this.textoNombre, textoNombre, 20, 50, 150, 20);
        this.campoNombre = super.generarJTextField(200, 50, 250, 20);
        this.add(this.campoNombre);
    }

    private void generarBotonBuscarContacto() {
        String textoBoton = "Buscar Contacto";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }

    private void generarBotonCancelar() {
        String textoBotonRegresar = "Volver";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }

    private void generarListaFavoritoContacto(){
        super.generarJLabel(this.textoEspecialidad,"Favoritos:",20,100,100,20);
        this.listaFavorito=super.generarListaDesplegable(Favorito.values(),120,100, 100, 20);
        this.add(this.listaFavorito);
    }

    private String[][] buscarContactoPorNombre(String nombreContacto) {
        List<Contacto> contactos = new ArrayList<>();
        String[][] datosLibros;

        if (this.campoNombre.getText().length() == 0) {
            System.out.println(this.listaFavorito.getSelectedItem());
            contactos = contactIQApp.obtenerContactoPorFavorito((Favorito) this.listaFavorito.getSelectedItem());
        }
        else {
            contactos = contactIQApp.obtenerContactoPorNombre(this.campoNombre.getText());
        }
        System.out.println(contactos.size());
        datosLibros = new String[contactos.size()][6];
        for (int i = 0; i < contactos.size(); i++){
            datosLibros[i][0] = contactos.get(i).getNombre();
            datosLibros[i][1] = contactos.get(i).getApodo();
            datosLibros[i][2] = Integer.toString(contactos.get(i).getNumero());
            datosLibros[i][3] = contactos.get(i).getCorreo();
            datosLibros[i][4] = contactos.get(i).getFavorito().getFavorito();
        }
        return datosLibros;
    }

    private String[][] registrarContactos() {
        String nombreBuscado = this.campoNombre.getText();

        if (nombreBuscado.isEmpty()) {
            return new String[0][];
        }

        return buscarContactoPorNombre(nombreBuscado);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscar) {
            String[] nombreColumnas = {"Nombre", "Apodo", "Numero", "Correo", "Favorito"};
            VentanaTabla ventanaTabla = new VentanaTabla(registrarContactos(), nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar) {
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(contactIQApp);
            this.dispose();
        }
    }
}
