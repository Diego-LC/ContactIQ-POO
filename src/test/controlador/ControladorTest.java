package controlador;

import datos.GestorDeDatos;
import model.Contacto;
import model.PerfilUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ControladorTest {

    private Controlador controlador;

    @BeforeEach
    public void setUp() {
        controlador = new Controlador();
    }

    @Test
    public void testGetPerfilUsuario() {
        PerfilUsuario perfilUsuario = controlador.getPerfilUsuario();
        assertNotNull(perfilUsuario);
    }

    @Test
    public void testMostrarMenuPrincipal() {
        // Arrange
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        controlador = new Controlador();

        // Act
        controlador.mostrarMenuPrincipal();

        // Assert
        // TODO: Add assertions to verify that the menu is displayed correctly
    }

    @Test
    public void testImportarDatos() {
        // Arrange
        PerfilUsuario perfilUsuario = controlador.importarDatos();

        // Assert
        assertNotNull(perfilUsuario);
        // TODO: Add more assertions to verify that the data is imported correctly
    }

    @Test
    public void testExportarDatosCSV() {
        // Arrange
        PerfilUsuario perfilUsuario = new PerfilUsuario();
        controlador = new Controlador();

        // Act
        controlador.exportarDatosCSV(perfilUsuario);

        // Assert
        // TODO: Add assertions to verify that the data is exported correctly to CSV files
    }

    @Test
    public void testBorrarArchivoContactos() {
        // Arrange
        GestorDeDatos gestor = new GestorDeDatos();

        // Act
        boolean result = controlador.borrarArchivoContactos(gestor);

        // Assert
        // TODO: Add assertions to verify that the contact files are deleted correctly
        assertTrue(result);
    }

    @Test
    public void testGenerarQr() {
        // Arrange
        GestorDeDatos gestor = new GestorDeDatos();

        // Act
        controlador.generarQr();

        // Assert
        // TODO: Add assertions to verify that the QR code is generated correctly
    }

    @Test
    public void testExportarContactosAExcel() {
        // Arrange
        GestorDeDatos gestor = new GestorDeDatos();

        // Act
        controlador.exportarContactosAExcel();

        // Assert
        // TODO: Add assertions to verify that the contacts are exported correctly to an Excel file
    }

    @Test
    public void testImportarContactosDesdeExcel() {
        // Arrange
        // TODO: Implement test to verify that contacts are imported correctly from an Excel file
    }
}