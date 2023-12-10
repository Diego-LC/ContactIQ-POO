package principal;

import controller.ContactosController;
import model.ContactIQApp;
import gui.*;

public class Main {
    public static void main(String[] args) {
        try {
            ContactIQApp contactIQApp = new ContactIQApp();
            contactIQApp = ContactosController.cargaMasivaDatos(contactIQApp);
            VentanaMenuBienvenida ventana = new VentanaMenuBienvenida(contactIQApp);
        } catch (Exception e) {
            // Manejo de excepciones (puedes mostrar un mensaje de error, registrar el error, etc.)
            e.printStackTrace();
        }
    }

}
