package controller;

import data.GestorDatos;
import model.Favorito;
import model.*;


import java.util.List;

public class ContactosController {

    public static ContactIQApp cargaMasivaDatos(ContactIQApp contactIQApp){
        GestorDatos.leerArchivoContactos(contactIQApp, "contactos.txt");

        return contactIQApp;
    }

    public static List buscarContacto(ContactIQApp contactIQApp, String nombre){
        return contactIQApp.obtenerContactoPorNombre(nombre);
    }
    public static Contacto agregarContacto(ContactIQApp contactIQApp, String nombre, String apodo, int numero, String correo, Favorito favorito){
        return contactIQApp.agregarContacto(nombre, apodo, numero, correo, favorito);
    }

    public static void almacenarDatos(ContactIQApp contactIQApp){
        GestorDatos.registrarDatos(contactIQApp.getContactos(),"contactos.txt");
    }
}