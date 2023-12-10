package model;

import java.util.ArrayList;

public class PerfilUsuario extends Persona {
	private ArrayList<Contacto> contactos;
	public PerfilUsuario(String nombre, String apellido, String correoElectronico, String numeroTelefono) {
		super(nombre, apellido, correoElectronico, numeroTelefono);
		this.contactos = new ArrayList<Contacto>();
	}


	public PerfilUsuario() {
		this.contactos = new ArrayList<Contacto>();
    }


    public ArrayList<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContacto(Contacto contacto) {
		if (existeContacto(contacto)) {
			editarContacto(contacto, contacto.getNumeroTelefono());
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

	public void eliminarContacto(String numero) {
		for (Contacto c : this.contactos) {
			if (c.getNumeroTelefono().equals(numero)) {
				this.contactos.remove(c);
				return;
			}
		}
	}

	private boolean existeContacto(Contacto contacto) {
		if (this.contactos.isEmpty() || this.contactos == null) {
			return false;
		}
		for (Contacto c : this.contactos) {
			if (c.getNumeroTelefono().equals(contacto.getNumeroTelefono())) {
				return true;
			}
		}
		return false;
	}

	public void editarContacto(Contacto contacto, String numero) {
		for (Contacto c : this.contactos) {
			if (c.getNumeroTelefono().equals(numero)) {
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

	public Contacto obtenerContactoPorNumero(String numero) {
		for (Contacto c : this.contactos) {
			if (c.getNumeroTelefono().equals(numero)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		// verificar si los atributos son null, si lo son, devolver un string vacío
		String nombre = (this.getNombre() == null) ? "" : this.getNombre();
		String apellido = (this.getApellido() == null) ? "" : this.getApellido();
		String correoElectronico = (this.getCorreoElectronico() == null) ? "" : this.getCorreoElectronico();
		String numeroTelefono = (this.getNumeroTelefono() == null) ? "" : this.getNumeroTelefono();
		return nombre + "," + apellido + "," + correoElectronico + "," + numeroTelefono;
	}
}