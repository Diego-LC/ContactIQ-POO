package model;

import java.util.ArrayList;

public class PerfilUsuario extends Persona {
	private ArrayList<Contacto> contactos;
	public PerfilUsuario(String nombre, String apellido, String correoElectronico, String numeroTelefono) {
		super(nombre, apellido, correoElectronico, numeroTelefono);
		this.contactos = new ArrayList<Contacto>();
	}


	public ArrayList<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContacto(Contacto contacto) {
		if (existeContacto(contacto)) {
			editarContacto(contacto);
		} else {
			this.contactos.add(contacto);
		}
	}

	public void marcarComoFavorito(Contacto contacto) {
		contacto.setEsContactoFavorito(true);
	}

	public void eliminarContacto(Contacto contacto) {
		if (existeContacto(contacto)) {
			this.contactos.remove(contacto);
		}
	}

	private boolean existeContacto(Contacto contacto) {
		if (this.contactos.isEmpty() || this.contactos == null) {
			return false;
		}
		for (Contacto c : this.contactos) {
			System.out.println(c);
			if (c.getNumeroTelefono().equals(contacto.getNumeroTelefono())) {
				return true;
			}
		}
		return false;
	}

	private void editarContacto(Contacto contacto) {
		for (Contacto c : this.contactos) {
			if (c.getNumeroTelefono().equals(contacto.getNumeroTelefono())) {
				c.setNombre(contacto.getNombre());
				c.setApellido(contacto.getApellido());
				c.setCorreoElectronico(contacto.getCorreoElectronico());
				c.setNumeroTelefono(contacto.getNumeroTelefono());
				c.setEsContactoFavorito(contacto.getEsContactoFavorito());
			}
		}
	}

	public ArrayList<Contacto> obtenerContactosPorNombre(String nombre) {
		ArrayList<Contacto> contactosPorNombre = new ArrayList<Contacto>();
		for (Contacto c : this.contactos) {
			if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
				contactosPorNombre.add(c);
			}
		}
		return contactosPorNombre;
	}

	public ArrayList<Contacto> obtenerContactosPorNumero(String numero) {
		ArrayList<Contacto> contactosPorNumero = new ArrayList<Contacto>();
		for (Contacto c : this.contactos) {
			if (c.getNumeroTelefono().contains(numero)) {
				contactosPorNumero.add(c);
			}
		}
		return contactosPorNumero;
	}


    public ArrayList<Contacto> obtenerContactosPorApellido(String texto) {
		ArrayList<Contacto> contactosPorApellido = new ArrayList<Contacto>();
		for (Contacto c : this.contactos) {
			if (c.getApellido().toLowerCase().contains(texto.toLowerCase())) {
				contactosPorApellido.add(c);
			}
		}
		return contactosPorApellido;
    }

	@Override
	public String toString() {
		return this.getNombre() + "," + this.getApellido() + "," + this.getCorreoElectronico() + "," + this.getNumeroTelefono();
	}
}