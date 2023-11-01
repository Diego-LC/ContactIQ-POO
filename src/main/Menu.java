package main;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
	private ContactIQApp contactIQApp;

	void mostrarMenuPrincipal() {
		System.out.println("1. Ver Lista de Contactos");
        System.out.println("2. Añadir Contacto");
        System.out.println("3. Contactos Favoritos");
        System.out.println("4. Configuración");
        System.out.println("5. Ayuda");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
	}
	void mostarSubMenulistaContactos(){
		System.out.println("\nSubmenú:");
		System.out.println("1. Seleccionar Contacto");
		System.out.println("2. Buscar Contacto");
		System.out.println("3. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}

	void mostrarMenuConfiguracion() {
		System.out.println("\n** Seleccione una opción: **");
		System.out.println("1. Editar perfil");
		System.out.println("2. Guardar contactos");
		System.out.println("3. Importar contactos");
		System.out.println("4. Volver al menú principal");
	}

	int leerOpcion(Scanner scanner) {
		try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return -1; // Valor inválido para repetir el bucle
        }
	}

	boolean mostrarEsFavoritoOpcion(Scanner scanner){
		System.out.print("¿Añadir a favoritos? ('s' para sí, cualquier otra tecla para no): ");
		String esFavorito = scanner.nextLine();
		if (Objects.equals(esFavorito, "s")){
			return true;
		}
		else {
			System.out.println("No añadido a favoritos");
			return false;
		}
	}

	void mostrarMensajeError() {
		System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
	}

	void mostrarMenuAyuda() {
		System.out.println("\n** Ayuda **");
		// Proporciona información y asistencia sobre el uso de la aplicación.
	}
}