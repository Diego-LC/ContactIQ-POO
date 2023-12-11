package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PerfilUsuarioTest {

    private PerfilUsuario perfilUsuario;

    @BeforeEach
    public void setUp() {
        perfilUsuario = new PerfilUsuario();
    }

    @Test
    public void testSetContacto() {
        Contacto contacto = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        perfilUsuario.setContacto(contacto);

        ArrayList<Contacto> contactos = perfilUsuario.getContactos();
        assertTrue(contactos.contains(contacto));
    }

    @Test
    public void testMarcarComoFavorito() {
        Contacto contacto = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        perfilUsuario.setContacto(contacto);

        perfilUsuario.marcarComoFavorito(contacto);

        assertTrue(contacto.getEsContactoFavorito());
    }

    @Test
    public void testEliminarContacto() {
        Contacto contacto = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        perfilUsuario.setContacto(contacto);

        perfilUsuario.eliminarContacto(contacto);

        ArrayList<Contacto> contactos = perfilUsuario.getContactos();
        assertFalse(contactos.contains(contacto));
    }

    @Test
    public void testEliminarContactoPorNumero() {
        Contacto contacto1 = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        Contacto contacto2 = new Contacto("Jane", "Smith", "janesmith@example.com", "9876543210");
        perfilUsuario.setContacto(contacto1);
        perfilUsuario.setContacto(contacto2);

        perfilUsuario.eliminarContacto("1234567890");

        ArrayList<Contacto> contactos = perfilUsuario.getContactos();
        assertFalse(contactos.contains(contacto1));
        assertTrue(contactos.contains(contacto2));
    }

    @Test
    public void testEditarContacto() {
        Contacto contacto = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        perfilUsuario.setContacto(contacto);

        Contacto nuevoContacto = new Contacto("Jane", "Smith", "janesmith@example.com", "9876543210");
        perfilUsuario.editarContacto(nuevoContacto, "1234567890");

        ArrayList<Contacto> contactos = perfilUsuario.getContactos();
        assertTrue(contactos.contains(contacto));
        assertFalse(contactos.contains(nuevoContacto));
    }

    @Test
    public void testObtenerContactosPorNombre() {
        Contacto contacto1 = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        Contacto contacto2 = new Contacto("Jane", "Smith", "janesmith@example.com", "9876543210");
        perfilUsuario.setContacto(contacto1);
        perfilUsuario.setContacto(contacto2);

        ArrayList<Contacto> contactosPorNombre = perfilUsuario.obtenerContactosPorNombre("John");

        assertEquals(1, contactosPorNombre.size());
        assertTrue(contactosPorNombre.contains(contacto1));
    }

    @Test
    public void testObtenerContactosPorNumero() {
        Contacto contacto1 = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        Contacto contacto2 = new Contacto("Jane", "Smith", "janesmith@example.com", "9876543210");
        perfilUsuario.setContacto(contacto1);
        perfilUsuario.setContacto(contacto2);

        ArrayList<Contacto> contactosPorNumero = perfilUsuario.obtenerContactosPorNumero("987");

        assertEquals(1, contactosPorNumero.size());
        assertTrue(contactosPorNumero.contains(contacto2));
    }

    @Test
    public void testObtenerContactosPorApellido() {
        Contacto contacto1 = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        Contacto contacto2 = new Contacto("Jane", "Smith", "janesmith@example.com", "9876543210");
        perfilUsuario.setContacto(contacto1);
        perfilUsuario.setContacto(contacto2);

        ArrayList<Contacto> contactosPorApellido = perfilUsuario.obtenerContactosPorApellido("Smith");

        assertEquals(1, contactosPorApellido.size());
        assertTrue(contactosPorApellido.contains(contacto2));
    }

    @Test
    public void testObtenerContactoPorNumero() {
        Contacto contacto1 = new Contacto("John", "Doe", "johndoe@example.com", "1234567890");
        Contacto contacto2 = new Contacto("Jane", "Smith", "janesmith@example.com", "9876543210");
        perfilUsuario.setContacto(contacto1);
        perfilUsuario.setContacto(contacto2);

        Contacto contactoEncontrado = perfilUsuario.obtenerContactoPorNumero("9876543210");

        assertNotNull(contactoEncontrado);
        assertEquals(contacto2, contactoEncontrado);
    }

    @Test
    public void testToString() {
        perfilUsuario.setNombre("John");
        perfilUsuario.setApellido("Doe");
        perfilUsuario.setCorreoElectronico("johndoe@example.com");
        perfilUsuario.setNumeroTelefono("1234567890");

        String expected = "John,Doe,johndoe@example.com,1234567890";
        assertEquals(expected, perfilUsuario.toString());
    }
}