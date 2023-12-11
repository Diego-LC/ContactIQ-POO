package datos;

import model.PerfilUsuario;
import datos.GestorDeDatos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorDeDatosTest {

    @Test
    public void testImportarDatos() {
        GestorDeDatos gestor = new GestorDeDatos();
        PerfilUsuario perfil = gestor.importarDatosPerfilUsuario("perfilUsuario.csv");

        // Comprueba que el perfil de usuario se haya importado correctamente
        assertNotNull(perfil);
        assertEquals("Nombre", perfil.getNombre());
        assertEquals("Apellido", perfil.getApellido());
        assertEquals("correo@example.com", perfil.getCorreoElectronico());
        assertEquals("123456789", perfil.getNumeroTelefono());
        assertEquals(1, perfil.getContactos().size());
        assertEquals("Contacto1", perfil.getContactos().get(0).getNombre());
        assertEquals("ApellidoContacto1", perfil.getContactos().get(0).getApellido());
        assertEquals("contacto1@example.com", perfil.getContactos().get(0).getCorreoElectronico());
        assertEquals("987654321", perfil.getContactos().get(0).getNumeroTelefono());
    }

    @Test
    public void testExportarDato() {
        GestorDeDatos gestor = new GestorDeDatos();
        PerfilUsuario perfil = new PerfilUsuario();
        perfil.setNombre("Nombre");
        perfil.setApellido("Apellido");
        perfil.setCorreoElectronico("correo@example.com");
        perfil.setNumeroTelefono("123456789");

        boolean resultado = gestor.exportarDato(perfil, "ruta/al/archivo.csv");

        // Comprueba que el dato se haya exportado correctamente
        assertTrue(resultado);
        // Aquí puedes agregar más aserciones para verificar el contenido del archivo exportado
    }

    @Test
    public void testBorrarDatosArchivo() {
        GestorDeDatos gestor = new GestorDeDatos();

        gestor.borrarDatosArchivo("ruta/al/archivo.csv");

        // Aquí puedes agregar aserciones para verificar que el archivo esté vacío después de borrar los datos
    }
}