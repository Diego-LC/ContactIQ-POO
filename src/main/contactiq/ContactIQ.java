import java.util.Scanner;
import java.util.ArrayList;

public class ContactIQ {
    public static <Contacto> void main(String[] args) {
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
                    System.out.println(telefono);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Ingrese el nombre a buscar: ");
                    String nombreBuscado = sc.next();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre a eliminar: ");
                    String nombreEliminar = sc.next();
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