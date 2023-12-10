package model;

import java.util.ArrayList;
import java.util.List;

public class ContactIQApp {
    private Contacto contacto;
    private ArrayList<Contacto> contactos;

    public ContactIQApp() {
        this.contactos = new ArrayList<>();
    }

    public Contacto agregarContacto(String nombre, String apodo, int numero, String correo, Favorito favorito) {
        Contacto contacto = new Contacto(nombre, apodo, numero, correo, favorito);
        this.contactos.add(contacto);

        return contacto;
    }

    public List<Contacto> obtenerContactoPorNombre(String nombreContacto) {
        List<Contacto> contactosEncontrados = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getNombre().equals(nombreContacto)) {
                contactosEncontrados.add(contacto);
            }
        }

        return contactosEncontrados;
    }

    public List<Contacto> obtenerContactoPorFavorito(Favorito favorito) {
        List<Contacto> contactos = new ArrayList<Contacto>();
        for (Contacto contacto : this.contactos) {
            if (contacto.getFavorito().equals(favorito)) {
                contactos.add(contacto);
            }
        }
        return contactos;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
}

