package main;

import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;

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
            if (contacto.getNombreContacto().contains(nombreContacto)) {
                contactosEncontrados.add(contacto);
            }
        }

        return contactosEncontrados;
    }

	public ArrayList<Contacto> buscarNumeroContacto(String numeroContacto) {

		ArrayList<Contacto> contactosEncontrados = new ArrayList<Contacto>();

		for (Contacto contacto : this.contactos) {
			if (contacto.getNumeroContacto().contains(numeroContacto)) {
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

    public void guardarContactos() {
        //Guarda los contactos a un json en el almacenamiento del dispositivo
        Gson gson = new Gson();
        String json = gson.toJson(this.contactos);
        try {
            FileWriter archivo = new FileWriter("contactos.json");
            archivo.write(json);
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void importarContactos() {
    Gson gson = new Gson();
    try {
        FileReader archivo = new FileReader("contactos.json");
        Type tipoListaContactos = new TypeToken<ArrayList<Contacto>>(){}.getType();
        ArrayList<Contacto> nuevosContactos = gson.fromJson(archivo, tipoListaContactos);
        archivo.close();

        for (Contacto nuevoContacto : nuevosContactos) {
            boolean existe = false;
            for (Contacto contactoExistente : contactos) {
                if (contactoExistente.getNombreContacto().equals(nuevoContacto.getNombreContacto()) &&
                    contactoExistente.getNumeroContacto().equals(nuevoContacto.getNumeroContacto()) &&
                    contactoExistente.getCorreoContacto().equals(nuevoContacto.getCorreoContacto())) {
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                contactos.add(nuevoContacto);
            }
        }
    } catch (IOException e) {
        System.out.println("Error al importar los contactos: " + e.getMessage());
    }
}
}