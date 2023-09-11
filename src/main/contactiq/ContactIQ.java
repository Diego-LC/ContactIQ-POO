package main.contactiq;
import java.io.Scanner;
import java.util.ArrayList;

public class ContactIQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contacto> contactos = new ArrayList<>();
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Salir");
            System.out.println("Ingrese su opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre: ");
                    String nombre = sc.next();
                    System.out.println("Ingrese el correo electrónico: ");
                    String correo = sc.next();
                    System.out.println("Ingrese el teléfono: ");
                    String telefono = sc.next();
                    Contacto contacto = new Contacto(nombre, correo, telefono);
                    contactos.add(contacto);
                    break;
                case 2:
                    for (Contacto c : contactos) {
                        System.out.println(c);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre a buscar: ");
                    String nombreBuscado = sc.next();
                    for (Contacto c : contactos) {
                        if (c.getNombre().equals(nombreBuscado)) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el nombre a eliminar: ");
                    String nombreEliminar = sc.next();
                    for (Contacto c : contactos) {
                        if (c.getNombre().equals(nombreEliminar)) {
                            contactos.remove(c);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar ContactIQ");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}