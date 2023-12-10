package controlador;

import model.Contacto;
import model.PerfilUsuario;
import ventanas.VentanaPrincipal;

public class Controlador {

	private PerfilUsuario usuario;

	public void mostrarMenuPrincipal() {
		new VentanaPrincipal(this);
	}

	public void exportarContactos() {
		throw new UnsupportedOperationException();
	}

	public PerfilUsuario importarContactos() {
		PerfilUsuario usuario = new PerfilUsuario("nombre", "apellido", "email", "+569 12345678");
		Contacto contacto = new Contacto("nombre", "apellido", "email", "+569 12345678");
		Contacto contacto2 = new Contacto("nombre2", "apellido2", "email2", "+569 23456789");
		usuario.setContacto(contacto);
		usuario.setContacto(contacto2);
		this.usuario = usuario;
		return usuario;
	}

	private boolean borrarArchivoContactos() {
		throw new UnsupportedOperationException();
	}

	private void generarQr() {
		throw new UnsupportedOperationException();
	}

}