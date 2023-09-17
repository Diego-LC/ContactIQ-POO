import main.ContactIQApp;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ContactIQTest {

    @Test
    public void testLeerOpcionConNumeroValido() {
        // Simulamos la entrada del usuario
        String input = "3\n";
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        int opcion = ContactIQApp.leerOpcion(scanner);

        // Comprobamos que la opción leída sea igual a 3
        assertEquals(3, opcion);
    }

    @Test
    public void testLeerOpcionConNumeroInvalido() {
        // Simulamos la entrada del usuario con un valor no numérico
        String input = "abc\n";
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        int opcion = ContactIQApp.leerOpcion(scanner);

        // Comprobamos que la opción leída sea igual a -1 (valor inválido)
        assertEquals(-1, opcion);
    }

    @Test
    public void testEditarContacto() {
        ContactIQApp app = new ContactIQApp();
        ArrayList<String> contactos = new ArrayList<>();
        contactos.add("Contacto1");
        contactos.add("Contacto2");
        app.setContactos(contactos);

        // Simulamos la entrada del usuario
        String input = "NuevoNombre\n";
        java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        app.editarContacto(1, scanner);

        // Comprobamos que el contacto en la posición 1 se haya actualizado
        assertEquals("NuevoNombre", app.getContactos().get(1));
    }
}
