package ventanas;

import controlador.Controlador;
import model.Contacto;
import model.PerfilUsuario;

import javax.swing.JTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAnadirEditarContacto extends VentanaGeneral implements ActionListener {
    private Controlador controlador;
    private Contacto contacto;
    private PerfilUsuario perfilUsuario;
    private boolean esPerfilUsuario;
    private JFrame ventanaAnterior;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldCorreoElectronico;
    private JTextField textFieldNumeroTelefono;
    private JComboBox<String> comboBoxContactoFavorito;
    private JButton botonAgregarActualizarContacto;
    private JButton botonVolver;

    protected VentanaAnadirEditarContacto(String tituloVentana, String numeroContacto, Controlador controlador, JFrame ventanaAnterior, boolean esPerfiUsuario) {
        super(tituloVentana);
        super.setSize(500, 580);
        this.controlador = controlador;
        this.ventanaAnterior = ventanaAnterior;
        this.esPerfilUsuario = esPerfiUsuario;
        this.validarTipoVentana(numeroContacto, esPerfiUsuario);
        this.setVisible(true);
    }

    private void validarTipoVentana(String numeroContacto, boolean esPerfiUsuario) {
        if (esPerfiUsuario) {
            this.perfilUsuario = this.controlador.getPerfilUsuario();
            this.generarElementos("Editar perfil", "Actualizar perfil");
        } else {
            if (numeroContacto != null) {
                this.contacto = this.controlador.getPerfilUsuario().obtenerContactoPorNumero(numeroContacto);
                this.generarElementos("Editar contacto", "Actualizar contacto");
            } else {
                this.generarElementos("Añadir contacto", "Agregar contacto");
            }
        }
    }

    public void setVisible(boolean b) {
        super.setVisible(b);
        this.textFieldNombre.requestFocus();
    }

    private void generarElementos(String textoEncabezado, String textoBoton) {
        super.generarJLabelEncabezado(this, textoEncabezado, 100, 20, 300, 30);
        this.add(super.generarJLabel(null, "Ingrese el nombre", 100, 60, 300, 30));
        this.generarInputTextFieldNombre();
        this.add(super.generarJLabel(null, "Ingrese el apellido", 100, 120, 300, 30));
        this.generarInputTextFieldApellido();
        this.add(super.generarJLabel(null, "Ingrese el correo electrónico", 100, 180, 300, 30));
        this.generarInputTextFieldCorreoE();
        this.add(super.generarJLabel(null, "ingrese el número telefónico", 100, 240, 300, 30));
        this.generarInputNumeroTelefono();
        if (!esPerfilUsuario) {// Si es el perfil de usuario no se muestra la opción de favorito
            super.generarJLabel(null, "¿Marcar como favorito?", 100, 300, 300, 30);
            this.generarListaDesplegableContactoFavorito();
        }
        this.generarBotonAgregarActualizar(textoBoton);
        this.generarBotonVolver();
    }

    private void generarInputTextFieldNombre() {
        this.textFieldNombre = super.generarJTextField(100, 90, 300, 30);
        if (esPerfilUsuario) {
            this.textFieldNombre.setText((this.perfilUsuario.getNombre()==null) ? "" : this.perfilUsuario.getNombre());
        } else {
            this.textFieldNombre.setText((this.contacto) == null ? "" : this.contacto.getNombre() );
        }
        this.add(this.textFieldNombre);
    }

    private void generarInputTextFieldApellido() {
        this.textFieldApellido = super.generarJTextField(100, 150, 300, 30);
        if (esPerfilUsuario) {
            this.textFieldApellido.setText((this.perfilUsuario.getApellido()==null) ? "" : this.perfilUsuario.getApellido());
        } else {
            this.textFieldApellido.setText((this.contacto) == null ? "" : this.contacto.getApellido() );
        }
        this.add(this.textFieldApellido);
    }

    private void generarInputTextFieldCorreoE() {
        this.textFieldCorreoElectronico = super.generarJTextField(100, 210, 300, 30);
        if (esPerfilUsuario) {
            this.textFieldCorreoElectronico.setText((this.perfilUsuario.getCorreoElectronico()==null) ? "" : this.perfilUsuario.getCorreoElectronico());
        } else {
            this.textFieldCorreoElectronico.setText((this.contacto) == null ? "" : this.contacto.getCorreoElectronico() );
        }
        this.add(this.textFieldCorreoElectronico);
    }

    private void generarInputNumeroTelefono() {
        this.textFieldNumeroTelefono = super.generarJTextField(100, 270, 300, 30);
        if (esPerfilUsuario) {
            this.textFieldNumeroTelefono.setText((this.perfilUsuario.getNumeroTelefono()==null) ? "" : this.perfilUsuario.getNumeroTelefono());
        } else {
            this.textFieldNumeroTelefono.setText((this.contacto) == null ? "" : this.contacto.getNumeroTelefono() );
        }
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

    private void generarBotonAgregarActualizar(String textoBoton) {
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
            if (this.textFieldNombre.getText().isEmpty() || this.textFieldApellido.getText().isEmpty() || this.textFieldCorreoElectronico.getText().isEmpty() || this.textFieldNumeroTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese todos los datos", "Datos incompletos", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (esPerfilUsuario){
                this.actualizarPerfilUsuario();
            }
            else{
                this.agregarContacto();
            }
            this.dispose();
            this.ventanaAnterior.setVisible(true);
            this.actualizarTabla();
        }

        if (e.getSource() == this.botonVolver) {
            // Hace visible la ventana principal
            this.ventanaAnterior.setVisible(true);
            // Hace invisible la ventana actual
            setVisible(false);
        }
    }



    private void actualizarPerfilUsuario() {
        try {
            String nombre = textFieldNombre.getText();
            String apellido = textFieldApellido.getText();
            String correoElectronico = textFieldCorreoElectronico.getText();
            String numeroTelefono = textFieldNumeroTelefono.getText().toString();

            this.perfilUsuario.setNombre(nombre);
            this.perfilUsuario.setApellido(apellido);
            this.perfilUsuario.setCorreoElectronico(correoElectronico);
            this.perfilUsuario.setNumeroTelefono(numeroTelefono);
            JOptionPane.showMessageDialog(this, "Perfil actualizado con éxito", "Perfil actualizado", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void agregarContacto() {
        try {
                String nombre = textFieldNombre.getText();
                String apellido = textFieldApellido.getText();
                String correoElectronico = textFieldCorreoElectronico.getText();
                String numeroTelefono = textFieldNumeroTelefono.getText().toString();
                String esContactoFavorito = comboBoxContactoFavorito.getSelectedItem().toString();


                Contacto contacto = new Contacto(nombre, apellido, correoElectronico, numeroTelefono, (esContactoFavorito.equals("Sí")) ? true : false);
                if (this.contacto != null) {
                    this.controlador.getPerfilUsuario().editarContacto(contacto, this.contacto.getNumeroTelefono());
                } else {
                    this.controlador.getPerfilUsuario().setContacto(contacto);
                }
                JOptionPane.showMessageDialog(this, "Contacto agregado con éxito", "Contacto agregado", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception ex){
                System.out.println("Error: " + ex.getMessage());
            }
    }

        private void actualizarTabla() {
        if (this.ventanaAnterior instanceof VentanaListaContactos) {
                ((VentanaListaContactos) this.ventanaAnterior).actualizarTabla();
            }
    }
}
