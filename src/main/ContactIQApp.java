package main;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactIQApp {
    private String nombre;
    private String correo;
    private ArrayList<String> contactos = new ArrayList<>();
    private ArrayList<String> favoritos = new ArrayList<>();
    public ArrayList<String> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<String> contactos) {
        this.contactos = contactos;
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
            mostrarOpciones();
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
                    app.editarPerfil(scanner);
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

    private static void mostrarOpciones() {
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
            System.out.println((i + 1) + ". " + contactos.get(i));
        }
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
        int numero = leerOpcion(scanner) - 1;
        if (numero >= 0 && numero < contactos.size()) {
            String contacto = contactos.get(numero);
            System.out.println("\nDetalle de Contacto:");
            System.out.println("Nombre: " + contacto);
            int opcion = 0;
            do {
                System.out.println("\nSubmenú:");
                System.out.println("1. Editar Contacto");
                System.out.println("2. Volver al Menú Principal");
                System.out.print("Seleccione una opción: ");
                opcion = leerOpcion(scanner);
                switch (opcion) {
                    case 1:
                        editarContacto(numero, scanner);
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                }
            } while (opcion != 2);
        } else {
            System.out.println("Número de contacto no válido.");
        }
    }

    public void editarContacto(int numero, Scanner scanner) {
        System.out.print("Nuevo nombre del contacto: ");
        String nuevoNombre = scanner.nextLine();
        contactos.set(numero, nuevoNombre);
        System.out.println("Contacto actualizado.");
    }

    private void buscarContacto(Scanner scanner) {
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;
        for (String contacto : contactos) {
            if (contacto.equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado: " + contacto);
                encontrado = true;
                break;
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
        contactos.add(nombre);
        System.out.println("Contacto agregado con éxito.");
    }

    private void verFavoritos() {
        System.out.println("\n** Contactos Favoritos **");
        for (String favorito : favoritos) {
            System.out.println(favorito);
        }
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