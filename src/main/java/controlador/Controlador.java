package controlador;

import datos.GestorDeDatos;
import model.Contacto;
import model.PerfilUsuario;
import ventanas.VentanaPrincipal;

public class Controlador {

	private PerfilUsuario usuario;

	public Controlador() {
		this.usuario = this.importarDatos();
	}
	public PerfilUsuario getPerfilUsuario() {
		return this.usuario;
	}

	public void mostrarMenuPrincipal() {
		new VentanaPrincipal(this);
		this.exportarDatosCSV(usuario);
	}

	public PerfilUsuario importarDatos() {
		GestorDeDatos gestor = new GestorDeDatos();
		PerfilUsuario usuario = gestor.importarDatosPerfilUsuario("perfilUsuario.csv");
		gestor.importarDatosContactos("contactos.csv", usuario);
		return usuario;
	}

	public void exportarDatosCSV(PerfilUsuario usuario) {
		GestorDeDatos gestor = new GestorDeDatos();
		this.borrarArchivoContactos(gestor);
		gestor.exportarDato("Nombre,Apellido,Correo,Numero teléfono", "perfilUsuario.csv");
		gestor.exportarDato(usuario, "perfilUsuario.csv");
		gestor.exportarDato("Nombre,Apellido,Correo,Numero teléfono,Es contacto favorito", "contactos.csv");
		for (Contacto contacto : usuario.getContactos()) {
			gestor.exportarDato(contacto, "contactos.csv");
		}
	}

	private boolean borrarArchivoContactos(GestorDeDatos gestor) {
		return gestor.borrarDatosArchivo("contactos.csv") && gestor.borrarDatosArchivo("perfilUsuario.csv");
	}

	public void generarQr() {
		GestorDeDatos gestor = new GestorDeDatos();
		gestor.generarQr(this.usuario.toString(), "qr.png");
	}
	public void exportarContactosAExcel() {
		GestorDeDatos gestor = new GestorDeDatos();
		gestor.exportarContactosAExcel("contactos.csv","contactos.xls");
	}
    public void importarContactosDesdeExcel() {
		//TODO: implementar a futuro
    }

}