package data;

import model.Favorito;
import model.*;

import java.io.*;
import java.util.List;

public class GestorDatos {
    public static ContactIQApp leerArchivoContactos(ContactIQApp contactIQApp, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Lee cada línea del archivo hasta que la línea sea nula
            while ((textoArchivo = br.readLine()) != null) {
                System.out.println("Encontre el archivo: " + direccionArchivo);
                String[] data = textoArchivo.split(",");
                contactIQApp.getContactos().add(new Contacto(data[0], data[1], Integer.parseInt(data[2]), data[3], Favorito.valueOf(data[4].toUpperCase())));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("contactos.txt no disponible, favor contactar con administrador");
        }
        return contactIQApp;
    }

    public static boolean registrarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Si el documento no es nuevo y tiene registrados datos, se debe
            if (lineaVacia == false) {
                bw.newLine();
            }
            bw.write(objeto.toString());

            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador");
            return false;
        }
    }

    public static boolean registrarDatos(List objetos, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);

            // Elimina el archivo existente, si es posible
            if (file.exists() && file.delete()) {
                System.out.println("El fichero " + direccionArchivo +  " ha sido borrado satisfactoriamente");
            } else {
                System.out.println("El fichero " + direccionArchivo + " no puede ser borrado");
            }

            // Crea un nuevo archivo
            if (file.createNewFile()) {
                System.out.println("Se ha creado un nuevo archivo " + direccionArchivo);
            } else {
                System.out.println("No se pudo crear el nuevo archivo " + direccionArchivo);
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribe los datos en el nuevo archivo
            for (Object objeto : objetos) {
                bw.write(objeto.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar datos, favor contactar con administrador");
            return false;
        }
    }
}