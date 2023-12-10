package ventanas;

import controlador.Controlador;
import model.Contacto;

import javax.swing.JTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAnadirEditarContacto extends VentanaGeneral implements ActionListener {
    private Controlador controlador;
    private Contacto contacto;
    private JFrame ventanaPrincipal;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreoElectronico;
    private JTextField textFieldNumeroTelefono;
    private JComboBox<String> comboBoxContactoFavorito;
    private JButton botonAgregarActualizarContacto;
    private JButton botonVolver;

    protected VentanaAnadirEditarContacto(String numero, Controlador controlador, JFrame ventanaPrincipal) {
        super("Ventana Café");
        super.setSize(500, 580);
        this.controlador = controlador;
        this.ventanaPrincipal = ventanaPrincipal;
        this.setAlwaysOnTop(true);
        if (numero != null) {
            this.contacto = this.controlador.importarContactos().obtenerContactoPorNumero(numero);
            this.generarElementos("Editar contacto", "Actualizar contacto");
        } else {
            this.generarElementos("Agregar contacto", "Agregar contacto");
        }
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
        this.textFieldNombre.requestFocus();
    }

    private void generarElementos(String textoEncabezado, String textoBoton) {
        super.generarJLabelEncabezado(this, textoEncabezado, 100, 20, 300, 30);
        super.generarJLabel(null, "Ingrese el nombre", 100, 60, 300, 30);
        this.generarInputTextFieldNombre();
        super.generarJLabel(null, "Ingrese el apellido", 100, 120, 300, 30);
        this.generarInputTextFieldApellido();
        super.generarJLabel(null, "Ingrese el correo electrónico", 100, 180, 300, 30);
        this.generarInputTextFieldCorreoE();
        super.generarJLabel(null, "ingrese el número telefónico", 100, 240, 300, 30);
        this.generarInputNumeroTelefono();
        super.generarJLabel(null, "¿Marcar como favorito?", 100, 300, 300, 30);
        this.generarListaDesplegableContactoFavorito();
        this.generarBotonAgregarCafe(textoBoton);
        this.generarBotonVolver();
    }

    private void generarInputTextFieldNombre() {
        this.textFieldNombre = super.generarJTextField(100, 90, 300, 30);
        this.textFieldNombre.setText((this.contacto) == null ? "" : this.contacto.getNombre() );
        this.add(this.textFieldNombre);
    }

    private void generarInputTextFieldApellido() {
        this.textFieldApellido = super.generarJTextField(100, 150, 300, 30);
        this.textFieldApellido.setText((this.contacto) == null ? "" : this.contacto.getApellido() );
        this.add(this.textFieldApellido);
    }

    private void generarInputTextFieldCorreoE() {
        this.textFieldCorreoElectronico = super.generarJTextField(100, 210, 300, 30);
        this.textFieldCorreoElectronico.setText((this.contacto) == null ? "" : this.contacto.getCorreoElectronico() );
        this.add(this.textFieldCorreoElectronico);
    }

    private void generarInputNumeroTelefono() {
        this.textFieldNumeroTelefono = super.generarJTextField(100, 270, 300, 30);
        this.textFieldNumeroTelefono.setText((this.contacto) == null ? "" : this.contacto.getNumeroTelefono() );
        this.add(this.textFieldNumeroTelefono);
        this.textFieldNumeroTelefono.addActionListener(this);
    }

    private void generarListaDesplegableContactoFavorito() {
        this.comboBoxContactoFavorito = super.generarListaDesplegable(100, 330, 300, 30);
        this.add(this.comboBoxContactoFavorito);
        this.comboBoxContactoFavorito.addItem("Sí");
        this.comboBoxContactoFavorito.addItem("No");
        this.comboBoxContactoFavorito.setSelectedItem((this.contacto == null) ? "No" : (this.contacto.getEsContactoFavorito()) ? "Sí" : "No");
        this.comboBoxContactoFavorito.addActionListener(this);
    }

    private void generarBotonAgregarCafe(String textoBoton) {
        this.botonAgregarActualizarContacto = super.generarBoton(textoBoton, 100, 390, 300, 50);
        this.add(this.botonAgregarActualizarContacto);
        this.botonAgregarActualizarContacto.addActionListener(this);
    }

    private void generarBotonVolver() {
        JButton volver = super.generarBoton("Volver", 100, 450, 300, 50);
        this.botonVolver = volver;
        this.add(volver);
        this.botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.botonAgregarActualizarContacto == e.getSource()) {
            try {
                String nombre = textFieldNombre.getText();
                String apellido = textFieldApellido.getText();
                String correoElectronico = textFieldCorreoElectronico.getText();
                String numeroTelefono = textFieldNumeroTelefono.getText().toString();
                String esContactoFavorito = comboBoxContactoFavorito.getSelectedItem().toString();


                Contacto contacto = new Contacto(nombre, apellido, correoElectronico, numeroTelefono, (esContactoFavorito.equals("Sí")) ? true : false);
                if (this.contacto != null) {
                    this.controlador.importarContactos().editarContacto(contacto, this.contacto.getNumeroTelefono());
                } else {
                    this.controlador.importarContactos().setContacto(contacto);
                }
                JOptionPane.showMessageDialog(this, "Contacto agregado con éxito", "Contacto agregado", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
            //controlador.guardarDatos();
            //ventanaPrincipal.setVisible(true);
            //setVisible(false);
        }

        if (e.getSource() == this.botonVolver) {
            // Hace visible la ventana principal
            this.ventanaPrincipal.setVisible(true);
            // Hace invisible la ventana actual
            setVisible(false);
        }
    }
}
