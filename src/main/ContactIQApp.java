package main;
import java.util.Scanner;

public class ContactIQApp {
	private final PerfilUsuario perfilUsuario = new PerfilUsuario();
	private final ContactosManager contactosManager = new ContactosManager();
	private final Menu menu = new Menu();

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
					this.contactosManager.mostrarListaContactos();
					verListaContactosSubmenu(scanner);
					break;
				case 2:
					this.agregarContacto(scanner);
					break;
				case 3:
					this.verFavoritos();
					break;
				case 4:
					this.menuConfiguracion(scanner);
					break;
				case 5:
					this.menu.mostrarMenuAyuda();
					break;
				case 6:
					System.out.println("Saliendo de la aplicación...");
					break;
				default:
					this.menu.mostrarMensajeError();
			}
		} while (opcion != 6);

		scanner.close();
	}

	void verListaContactosSubmenu(Scanner scanner){
		int opcion = 0;
		do {
			this.menu.mostarSubMenulistaContactos();
			opcion = this.menu.leerOpcion(scanner);
			switch (opcion) {
				case 1:
					seleccionarContacto(scanner);
					break;
				case 2:
					System.out.print("Ingrese el nombre del contacto a buscar: ");
					String frase = scanner.nextLine().toLowerCase();
					this.contactosManager.mostrarListaContactosEncontrados(this.contactosManager.buscarNombreContacto(frase));
					break;
				case 3:
					return;
				default:
					this.menu.mostrarMensajeError();
			}
		} while (opcion != 3);
	}

	void seleccionarContacto(Scanner scanner) {
		System.out.print("Ingrese el número de selección: ");
		int opcion = this.menu.leerOpcion(scanner) - 1;
		if (opcion >= 0 && opcion < this.contactosManager.getContactos().size()) {
			Contacto contacto = this.contactosManager.getContactos().get(opcion);
			this.contactosManager.mostrarDetalleContacto(contacto);
			seleccionarContactoSubMenu(opcion, scanner);
		} else {
			if (this.contactosManager.getContactos().isEmpty()){
				System.out.println("---No hay contactos en la lista---");
			}else{
				System.out.println("Número de selección no válido.");
			}
		}
	}

	void seleccionarContactoSubMenu(int opcion, Scanner scanner) {
		do {
			System.out.println("\nSubmenú:");
			System.out.println("1. Editar Contacto");
			System.out.println("2. Eliminar Contacto");
			System.out.println("3. Volver al Menú Principal");
			System.out.print("Seleccione una opción: ");
			opcion = this.menu.leerOpcion(scanner);
			Contacto contacto = this.contactosManager.getContactos().get(opcion);
			switch (opcion) {
				case 1:
					editarContacto(contacto, scanner);
					break;
				case 2:
					this.contactosManager.eliminarContacto(contacto);
				case 3:
					return;
				default:
					this.menu.mostrarMensajeError();
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
		boolean esFavorito = this.menu.mostrarEsFavoritoOpcion(scanner);

		this.contactosManager.editarContacto(contacto, nuevoNombre, nuevoNumero, nuevoCorreo, esFavorito);
		System.out.println("Contacto actualizado.");
	}

	public void agregarContacto(Scanner scanner) {
		System.out.println("\n** Agregar nuevo contacto **");
		Contacto contacto = new Contacto();
		System.out.print("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Número: ");
		String numero = scanner.nextLine();
		System.out.print("Correo: ");
		String correo = scanner.nextLine();
		String nuevoCorreo = scanner.nextLine();
		boolean esFavorito = this.menu.mostrarEsFavoritoOpcion(scanner);

		this.contactosManager.editarContacto(contacto, nombre, numero, correo, esFavorito);
		System.out.println("Nuevo contacto creado.");
	}

	public void verFavoritos() {
		this.contactosManager.mostrarListaContactosEncontrados(this.contactosManager.getContactosFavoritos());
	}

	public void menuConfiguracion(Scanner sc) {
		this.menu.mostrarMenuConfiguracion();
		int opcion = this.menu.leerOpcion(sc);
		do {
			if (opcion == 1){
				editarPerfil(sc);
			}else {
				return;
			}
		} while (true);
	}

	public void editarPerfil(Scanner scanner) {
		System.out.println("\n** Editar Perfil **");
		System.out.print("Nuevo nombre: ");
		this.perfilUsuario.setNombreUsuario(scanner.nextLine());
		System.out.print("Nuevo correo: ");
		this.perfilUsuario.setCorreoUsuario(scanner.nextLine());
		System.out.println("Perfil actualizado.");
	}
}