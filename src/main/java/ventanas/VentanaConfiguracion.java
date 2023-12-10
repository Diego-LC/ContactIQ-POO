package ventanas;

import controlador.Controlador;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class VentanaConfiguracion extends VentanaGeneral {

    private Controlador controlador;
    private VentanaPrincipal ventanaPrincipal;
    private JButton botonEditarPerfil;
    private JButton botonExportarAExcel;
    private JButton botonImportarDesdeExcel;
    private JButton botonCompartirContactoQR;
    private JButton botonVolver;

    public VentanaConfiguracion(Controlador controlador, VentanaPrincipal ventanaPrincipal) {
        super("Configuración");
        this.controlador = controlador;
        this.ventanaPrincipal = ventanaPrincipal;
        super.setSize(500, 500);
        this.generarElementos();
    }

    private void generarElementos() {
        super.generarJLabelEncabezado(this, "Configuración", 100, 20, 300, 30);
        this.generarBotonEditarPerfil();
        this.generarBotonExportarAExcel();
        this.generarBotonImportarDesdeExcel();
        this.generarBotonCompartirContactoQR();
        this.generarBotonVolver();
    }

    private void generarBotonEditarPerfil() {
        this.botonEditarPerfil = super.generarBoton("Editar perfil", 100, 70, 300, 50);
        this.add(this.botonEditarPerfil);
        this.botonEditarPerfil.addActionListener(this);
    }

    private void generarBotonExportarAExcel() {
        this.botonExportarAExcel = super.generarBoton("Exportar a Excel", 100, 130, 300, 50);
        this.add(this.botonExportarAExcel);
        this.botonExportarAExcel.addActionListener(this);
    }

    private void generarBotonImportarDesdeExcel() {
        this.botonImportarDesdeExcel = super.generarBoton("Importar desde Excel", 100, 190, 300, 50);
        this.add(this.botonImportarDesdeExcel);
        this.botonImportarDesdeExcel.addActionListener(this);
    }

    private void generarBotonCompartirContactoQR() {
        this.botonCompartirContactoQR = super.generarBoton("Compartir contacto QR", 100, 250, 300, 50);
        this.add(this.botonCompartirContactoQR);
        this.botonCompartirContactoQR.addActionListener(this);
    }

    private void generarBotonVolver() {
        this.botonVolver = super.generarBoton("Volver", 100, 370, 300, 50);
        this.add(this.botonVolver);
        this.botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonEditarPerfil) {
            VentanaAnadirEditarContacto ventanaEditarPerfil = new VentanaAnadirEditarContacto("Editar perfil",null, this.controlador, this, true);
            ventanaEditarPerfil.setVisible(true);
            this.dispose();
        }if (e.getSource() == this.botonExportarAExcel) {
            this.controlador.exportarContactosAExcel();

        }if (e.getSource() == this.botonImportarDesdeExcel) {
            this.controlador.importarContactosDesdeExcel();

        }if (e.getSource() == this.botonCompartirContactoQR) {
            this.controlador.generarQr();
            new VentanaQR("Codigo QR");
        }
        if (e.getSource() == this.botonVolver) {
            this.ventanaPrincipal.setVisible(true);
            this.dispose();
        }
    }
    
}