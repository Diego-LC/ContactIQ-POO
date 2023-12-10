package ventanas;

import controlador.Controlador;
import model.Contacto;
import model.PerfilUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaListaContactos extends VentanaGeneral implements ActionListener {
    private final VentanaPrincipal VentanaPrincipal;
    private final Controlador controlador;
    private boolean contFavoritos;
    private JFormattedTextField inputBuscar;
    private JComboBox listaDesplegableBuscarPor;
    private JButton botonBuscar;
    private JTable tabla;
    private JButton botonVolver;
    private JButton botonAnadir;

    public VentanaListaContactos(Controlador controlador, VentanaPrincipal ventanaPrincipal, boolean favoritos) {
        super("Lista de contactos");
        this.VentanaPrincipal = ventanaPrincipal;
        this.controlador = controlador;
        this.contFavoritos = favoritos;
        this.setLayout(new BorderLayout());
        this.generarElementos();
        //this.setSize(500,400);
        this.pack();
        this.setMinimumSize(new Dimension(700, 400));
    }

    private void contFavoritos(boolean favoritos) {
    }

    private void generarElementos() {
        JLabel encabezado = super.generarJLabelEncabezado(this, "Lista de contactos", 50, 20, 110, 30);
        this.add(encabezado, BorderLayout.NORTH); // Agrega el encabezado al norte
    
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        this.generarPanelBusqueda(panelCentral);
        this.generarDatosEnTabla(panelCentral);
        this.generarBotonesInferiores(panelCentral);
    
        this.add(panelCentral, BorderLayout.CENTER); // Agrega el panel central al centro
    }

    private void generarPanelBusqueda(JPanel panelCentral) {
        JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.generarLabelBuscar(panelBusqueda);
        this.generarInputBuscar(panelBusqueda);
        this.generarListaDesplegableBuscarPor(panelBusqueda);
        this.generarBotonBuscar(panelBusqueda);
        panelCentral.add(panelBusqueda);
    }

    private void generarLabelBuscar(JPanel panel) {
        JLabel label = super.generarJLabel(null, "Buscar:", 100, 70, 100, 30);
        panel.add(label);
    }

    private void generarInputBuscar(JPanel panel) {
        this.inputBuscar = super.generarJFormattedTextField(null, 200, 70, 200, 30);
        this.inputBuscar.setPreferredSize(new Dimension(200, 30)); // Establece el tamaño preferido
        panel.add(inputBuscar);
    }

    private void generarListaDesplegableBuscarPor(JPanel panel) {
        String[] opciones = {"Nombre", "Apellido", "Número de teléfono"};
        this.listaDesplegableBuscarPor = new JComboBox(opciones);
        listaDesplegableBuscarPor.setBounds(100, 120, 300, 30);
        panel.add(listaDesplegableBuscarPor);
    }

    private void generarBotonBuscar(JPanel panel) {
        this.botonBuscar = super.generarBoton("Buscar", 100, 170, 300, 30);
        panel.add(botonBuscar);
        this.botonBuscar.addActionListener(this);
    }

    private void generarDatosEnTabla(JPanel panelCentral) {
        Object[] items = super.generarTabla();
        this.tabla = (JTable) items[0];
        JPanel panel = (JPanel) items[1];
        tabla.setModel(this.generarModeloTabla());

        ButtonEditor buttonEditor = new ButtonEditor(tabla, controlador, this);
        tabla.getColumn("Editar").setCellRenderer(buttonEditor);
        tabla.getColumn("Editar").setCellEditor(buttonEditor);
        tabla.getColumn("Borrar").setCellRenderer(buttonEditor);
        tabla.getColumn("Borrar").setCellEditor(buttonEditor);
    
        panelCentral.add(panel);
    }

    private DefaultTableModel generarModeloTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Correo electrónico");
        modelo.addColumn("Número de teléfono");
        modelo.addColumn("Editar");
        modelo.addColumn("Borrar");
        this.añadirFilas(modelo);
        return modelo;
    }

    private void añadirFilas(DefaultTableModel modelo) {
        ArrayList<Contacto> contactos = this.controlador.getPerfilUsuario().getContactos();
        if (this.contFavoritos) {
            contactos = filtrarContactosFavoritos(contactos);
        }
        //System.out.println(contactos.toString());
        try{
            for (Contacto contacto : contactos) {
                if (contacto != null) {
                    Object[] fila = new Object[5];
                    fila[0] = contacto.getNombre();
                    fila[1] = contacto.getApellido();
                    fila[2] = contacto.getCorreoElectronico();
                    fila[3] = contacto.getNumeroTelefono();
                    fila[4] = "Editar";
                    modelo.addRow(fila);
                }
            }
        }catch (Exception e){
            System.err.println("Error l129: " + e.getMessage() + " : " + e.getStackTrace());
        }
    }

    private ArrayList<Contacto> filtrarContactosFavoritos(ArrayList<Contacto> contactos) {
        ArrayList<Contacto> contactosFavoritos = new ArrayList<>();
        for (Contacto contacto : contactos) {
            if (contacto.getEsContactoFavorito()) {
                contactosFavoritos.add(contacto);
            }
        }
        return contactosFavoritos;
    }

    private void generarBotonesInferiores(JPanel panelCentral) {
        this.botonVolver = super.generarBoton("Volver", 100, 20, 100, 30);
        this.botonAnadir = new JButton("Añadir contacto"); // Crea el nuevo botón
        this.botonAnadir.addActionListener(this); // Añade un ActionListener al nuevo botón
    
        Box box = Box.createHorizontalBox();
        box.add(Box.createHorizontalGlue());
        box.add(botonVolver);
        box.add(Box.createRigidArea(new Dimension(100, 0))); // Añade un espacio entre los botones
        box.add(this.botonAnadir); // Añade el nuevo botón a la caja
        box.add(Box.createHorizontalGlue());
    
        panelCentral.add(Box.createVerticalGlue());
        panelCentral.add(box);
        panelCentral.add(Box.createVerticalGlue());
    
        this.botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscar) {
            String texto = this.inputBuscar.getText();
            this.buscarContacto(texto);
        }
        if (e.getSource() == this.botonAnadir) {
            JFrame ventanaAnadir = new VentanaAnadirEditarContacto("Añadir nuevo contacto", null, controlador, this, false);
            ventanaAnadir.setVisible(true);
            ventanaAnadir.setLocationRelativeTo(this);
        }
        if (e.getSource() == this.botonVolver) {
            this.setVisible(false);
            this.VentanaPrincipal.setVisible(true);
        }
    }

    private void buscarContacto(String texto) {
        //Limpiar tabla actual
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        modelo.setRowCount(0);

        //Agregar filas
        ArrayList<Contacto> contactos = this.obtenerContactosSegunCampo(texto);
        try{
            for (Contacto contacto : contactos) {
                if (contacto != null) {
                    Object[] fila = new Object[5];
                    fila[0] = contacto.getNombre();
                    fila[1] = contacto.getApellido();
                    fila[2] = contacto.getCorreoElectronico();
                    fila[3] = contacto.getNumeroTelefono();
                    fila[4] = "Editar";
                    modelo.addRow(fila);
                }
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    private ArrayList<Contacto> obtenerContactosSegunCampo(String texto){
        ArrayList<Contacto> contactos = new ArrayList<>();
        PerfilUsuario usuario = this.controlador.getPerfilUsuario();
        switch (this.listaDesplegableBuscarPor.getSelectedIndex()){
            case 0:
                contactos = usuario.obtenerContactosPorNombre(texto);
                break;
            case 1:
                contactos = usuario.obtenerContactosPorApellido(texto);
                break;
            case 2:
                contactos = usuario.obtenerContactosPorNumero(texto);
                break;
        }
        return contactos;
    }

    public void actualizarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.tabla.getModel();
        modelo.setRowCount(0);
        this.añadirFilas(modelo);
        this.controlador.exportarContactos(this.controlador.getPerfilUsuario());
    }
}
