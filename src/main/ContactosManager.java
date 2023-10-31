package main;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ContactosManager {
    private final ArrayList<Contacto> contactos = new ArrayList<Contacto>();

    public void agregarContacto(Contacto contacto) {
        this.contactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto) {
        this.contactos.remove(contacto);
		System.out.println("Contacto Eliminado");
    }

    public ArrayList<Contacto> getContactos() {
        return this.contactos;
    }

    public void mostrarDetalleContacto(@NotNull Contacto contacto){
        System.out.println("\nDetalle de Contacto:");
        System.out.println("Nombre: " + contacto.getNombreContacto());
        System.out.println("Número: " + contacto.getNumeroContacto());
        System.out.println("Correo: " + contacto.getCorreoContacto());
        System.out.println("Favorito: " + contacto.getEsContactoFavorito());
    }

    public void mostrarListaContactos() {
        System.out.println("\n** Lista de Contactos **");
        int i = 0;
        if (!contactos.isEmpty()){
            while (i < contactos.size()) {
                System.out.println((i + 1) + ". " + contactos.get(i).getNombreContacto());
                i++;
            }
        }
        else{
            System.out.println("---No hay contactos agregados---");
        }

    }

    public ArrayList<Contacto> buscarNombreContacto(String nombreContacto) {

        ArrayList<Contacto> contactosEncontrados = new ArrayList<Contacto>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getNombreContacto().equals(nombreContacto)) {
                contactosEncontrados.add(contacto);
            }
        }

        return contactosEncontrados;
    }

	public ArrayList<Contacto> buscarNumeroContacto(String numeroContacto) {

		ArrayList<Contacto> contactosEncontrados = new ArrayList<Contacto>();

		for (Contacto contacto : this.contactos) {
			if (contacto.getNumeroContacto().equals(numeroContacto)) {
				contactosEncontrados.add(contacto);
			}
		}

		return contactosEncontrados;
	}

	void mostrarListaContactosEncontrados(ArrayList<Contacto> contactos){
		System.out.println("\n** Contactos Encontrados **");
		int i = 0;
		while (i < contactos.size()) {
			System.out.println((i + 1) + ". " + contactos.get(i).getNombreContacto());
			i++;
		}
	}
    public void editarContacto(Contacto contacto,String nuevoNombre,String nuevoNumero, String nuevoCorreo, boolean esFavorito){
        contacto.setNombreContacto(nuevoNombre);
        contacto.setCorreoContacto(nuevoCorreo);
        contacto.setNumeroContacto(nuevoNumero);
        contacto.setEsContactoFavorito(esFavorito);
		if (!existeContacto(contacto)){
            agregarContacto(contacto);
        }
    }

    public ArrayList<Contacto> getContactosFavoritos() {

        ArrayList<Contacto> contactosFavoritos = new ArrayList<Contacto>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getEsContactoFavorito()) {
                contactosFavoritos.add(contacto);
            }
        }

        return contactosFavoritos;
    }

    boolean existeContacto(Contacto contacto) {
        return this.contactos.contains(contacto);
    }
}