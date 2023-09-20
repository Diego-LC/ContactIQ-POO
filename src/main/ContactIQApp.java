package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ContactIQApp {
    private String nombre;
    private String correo;
    private List<List<String>> contactos = new ArrayList<>();
    public List<List<String>> getContactos() {
        return contactos;
    }


    public static void main(String[] args) {
        mostrarMenu();
    }
    private static void mostrarMenu(){
        ContactIQApp app = new ContactIQApp();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n** Menú Principal **");
            mostrarOpcionesMenuPrincipal();
            opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                    app.verListaContactos(scanner);
                    break;
                case 2:
                    app.agregarContacto(scanner);
                    break;
                case 3:
                    app.verFavoritos();
                    break;
                case 4:
                    app.menuConfiguracion();
                    break;
                case 5:
                    app.mostrarAyuda();
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

    private static void mostrarOpcionesMenuPrincipal() {
        System.out.println("1. Ver Lista de Contactos");
        System.out.println("2. Añadir Contacto");
        System.out.println("3. Contactos Favoritos");
        System.out.println("4. Configuración");
        System.out.println("5. Ayuda");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return -1; // Valor inválido para repetir el bucle
        }
    }

    private void verListaContactos(Scanner scanner) {
        System.out.println("\n** Lista de Contactos **");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i).get(0));
        }
        verListaContactosSubmenu(scanner);
    }

    public void verListaContactosSubmenu(Scanner scanner){
        int opcion = 0;
        do {
            System.out.println("\nSubmenú:");
            System.out.println("1. Seleccionar Contacto");
            System.out.println("2. Buscar Contacto");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                    seleccionarContacto(scanner);
                    break;
                case 2:
                    buscarContacto(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }

    private void seleccionarContacto(Scanner scanner) {
        System.out.print("Ingrese el número de contacto: ");
        int opcion = leerOpcion(scanner) - 1;
        if (opcion >= 0 && opcion < contactos.size()) {
            List<String> contacto = contactos.get(opcion);
            System.out.println("\nDetalle de Contacto:");
            System.out.println("Nombre: " + contacto.get(0));
            System.out.println("Número: " + contacto.get(1));
            System.out.println("Correo: " + contacto.get(2));
            System.out.println("Favorito: " + contacto.get(3));
            seleccionarContactoSubMenuEditar(opcion, scanner);
        } else {
            System.out.println("Número de contacto no válido.");
        }
    }

    public void seleccionarContactoSubMenuEditar(int opcion, Scanner scanner){
        do {
            System.out.println("\nSubmenú:");
            System.out.println("1. Editar Contacto");
            System.out.println("2. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leerOpcion(scanner);
            switch (opcion) {
                case 1:
                    editarContacto(opcion, scanner);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 2);
    }

    public void editarContacto(int numero, Scanner scanner) {
        System.out.print("Nuevo nombre del contacto: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Nuevo número del contacto: ");
        String nuevoNumero = scanner.nextLine();
        System.out.print("Nuevo correo del contacto: ");
        String nuevoCorreo = scanner.nextLine();
        System.out.print("¿Añadir a favoritos? ('s' para sí, cualquier otra tecla para no): ");

        List<String> contacto = new ArrayList<>();
        setContactos(scanner, contacto, nuevoNombre, nuevoNumero, nuevoCorreo);
        contactos.set(numero-1, contacto);
        System.out.println("Contacto actualizado.");
    }

    private void buscarContacto(Scanner scanner) {
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String frase = scanner.nextLine().toLowerCase();
        boolean encontrado = false;
        for (List<String> contacto : contactos) {
            String nombreContacto = contacto.get(0).toLowerCase();
            if (nombreContacto.contains(frase)) {
                System.out.println("Contacto encontrado: " + contacto.get(0));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contacto no encontrado.");
        }
    }

    private void agregarContacto(Scanner scanner) {
        System.out.println("\n** Agregar Contacto **");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("¿Marcar como favorito? ('s' para sí, cualquier otra tecla para no): ");

        List<String> nuevoContacto = new ArrayList<>();
        setContactos(scanner, nuevoContacto, nombre, numero, correo);
        contactos.add(nuevoContacto);
        System.out.println("Contacto agregado con éxito.");
    }

    private void setContactos(Scanner scanner, List<String> contacto, String nombre, String numero, String correo) {
        String esFavorito = scanner.nextLine();
        contacto.add(nombre);
        contacto.add(numero);
        contacto.add(correo);
        if (Objects.equals(esFavorito, "s")){
            contacto.add("Sí");
        } else {
            contacto.add("No");
            System.out.println("No añadido a favoritos");
        }
        return;
    }

    private void verFavoritos() {
        System.out.println("\n** Contactos Favoritos **");
        for (List<String> favorito : contactos) {
            if (favorito.get(3).equals("Sí")) {
                System.out.println(favorito.get(0));
            }
        }
    }

    public void menuConfiguracion(){
        System.out.println("\n** Seleccione una opción: **");
        System.out.println("1. Editar perfil");
        System.out.println("2. Volver al menú principal");
        Scanner sc = new Scanner(System.in);
        int opcion = leerOpcion(sc);
        do {
            if (opcion == 1){
                editarPerfil(sc);
            }else {
                return;
            }
        } while (true);
    }

    private void editarPerfil(Scanner scanner) {
        System.out.println("\n** Editar Perfil **");
        System.out.print("Nuevo nombre: ");
        this.nombre = scanner.nextLine();
        System.out.print("Nuevo correo: ");
        this.correo = scanner.nextLine();
        System.out.println("Perfil actualizado.");
    }

    private void mostrarAyuda() {
        System.out.println("\n** Ayuda **");
        // Proporciona información y asistencia sobre el uso de la aplicación.
    }
}