package main;
import java.util.ArrayList;
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
	void listaContactosSubMenu(){
		System.out.println("\nSubmenú:");
		System.out.println("1. Seleccionar Contacto");
		System.out.println("2. Buscar Contacto");
		System.out.println("3. Volver al Menú Principal");
		System.out.print("Seleccione una opción: ");
	}

	void mostrarListaContactosEncontrados(ArrayList<Contacto> contactos){
		System.out.println("\n** Contactos Encontrados **");
		int i = 0;
		while (i < contactos.size()) {
			System.out.println((i + 1) + ". " + contactos.get(i).getNombreContacto());
			i++;
		}
	}

	public void mostrarMenuContacto() {
	}

	public void mostrarMenuConfiguracion() {
	}

	public void mostrarMenuAyuda() {
	}

	int leerOpcion(Scanner scanner) {
		try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return -1; // Valor inválido para repetir el bucle
        }
	}

	public boolean mostrarEsOpcionFavorito(Scanner scanner){
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

	public void mostrarMensajeError(String mensaje) {
	}

}