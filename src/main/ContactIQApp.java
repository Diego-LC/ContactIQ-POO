package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ContactIQApp {
	private ArrayList<Contacto> contacto = new ArrayList<Contacto>();
	private Configuracion configuracion = new Configuracion();
	private ContactosManager contactosManager = new ContactosManager();
	private Menu menu = new Menu();

	public static void main (String[] args) {
		ContactIQApp contactIQApp = new ContactIQApp();
		contactIQApp.mostrarMenu();
	}

	public void mostrarMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("\n** Menú Principal **");
			this.menu.mostrarMenuPrincipal();
			opcion = this.menu.leerOpcion(scanner);
			switch (opcion) {
				case 1:
					this.contactosManager.verListaContactos();
					verListaContactosSubmenu(scanner);
					break;
				case 2:
					this.agregarContacto(scanner);
					break;
				case 3:
					this.verFavoritos();
					break;
				case 4:
					this.menuConfiguracion();
					break;
				case 5:
					this.menu.mostrarMenuAyuda();
					break;
				case 6:
					System.out.println("Saliendo de la aplicación...");
					break;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 6);

		scanner.close();
	}

	void verListaContactosSubmenu(Scanner scanner){
		int opcion = 0;
		do {
			this.menu.listaContactosSubMenu();
			opcion = this.menu.leerOpcion(scanner);
			switch (opcion) {
				case 1:
					seleccionarContacto(scanner);
					break;
				case 2:
					System.out.print("Ingrese el nombre del contacto a buscar: ");
					String frase = scanner.nextLine().toLowerCase();
					this.menu.mostrarListaContactosEncontrados(this.contactosManager.buscarNombreContacto(frase));
					break;
				case 3:
					return;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);
	}

	void seleccionarContacto(Scanner scanner) {
		System.out.print("Ingrese el número de contacto para seleccionarlo: ");
		int opcion = this.menu.leerOpcion(scanner) - 1;
		if (opcion >= 0 && opcion < this.contactosManager.getContactos().size()) {
			Contacto contacto = this.contactosManager.getContactos().get(opcion);
			this.contactosManager.mostrarContacto(contacto);
			seleccionarContactoSubMenuEditar(opcion, scanner);
		} else {
			if (this.contactosManager.getContactos().isEmpty()){
				System.out.println("---No hay contactos en la lista---");
			}else{
				System.out.println("Número de contacto no válido.");
			}
		}
	}

	void seleccionarContactoSubMenuEditar(int opcion, Scanner scanner) {
		do {
			System.out.println("\nSubmenú:");
			System.out.println("1. Editar Contacto");
			System.out.println("2. Volver al Menú Principal");
			System.out.print("Seleccione una opción: ");
			opcion = this.menu.leerOpcion(scanner);
			switch (opcion) {
				case 1:
					Contacto contacto = this.contactosManager.getContactos().get(opcion);
					editarContacto(contacto, scanner);
					break;
				case 2:
					return;
				default:
					System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 2);
	}

	public void editarContacto(Contacto contacto, Scanner scanner) {

		System.out.print("Nuevo nombre del contacto: ");
		String nuevoNombre = scanner.nextLine();
		System.out.print("Nuevo número del contacto: ");
		String nuevoNumero = scanner.nextLine();
		System.out.print("Nuevo correo del contacto: ");
		String nuevoCorreo = scanner.nextLine();
		boolean esFavorito = this.menu.mostrarEsOpcionFavorito(scanner);

		this.contactosManager.editarContacto(contacto, nuevoNombre, nuevoNumero, nuevoCorreo, esFavorito);
		System.out.println("Contacto actualizado.");
	}


	public void agregarContacto(Scanner scanner) {
		throw new UnsupportedOperationException();
	}

	public void verFavoritos() {
		throw new UnsupportedOperationException();
	}

	public void menuConfiguracion() {
		throw new UnsupportedOperationException();
	}

	public void editarPerfil(Scanner scanner) {
		throw new UnsupportedOperationException();
	}

	public void mostrarAyuda() {
		throw new UnsupportedOperationException();
	}
}