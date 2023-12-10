package model;

public class Contacto extends Persona {
	private boolean esContactoFavorito;

	public boolean getEsContactoFavorito() {
		return this.esContactoFavorito;
	}

	public void setEsContactoFavorito(boolean esContactoFavorito) {
		this.esContactoFavorito = esContactoFavorito;
	}

	public Contacto(String nombre, String apellido, String correoElectronico, String numeroTelefono,
			boolean esContactoFavorito) {
		super(nombre, apellido, correoElectronico, numeroTelefono);
		this.esContactoFavorito = esContactoFavorito;
	}

	public Contacto(String nombre, String apellido, String correoElectronico, String numeroTelefono) {
		super(nombre, apellido, correoElectronico, numeroTelefono);
		this.esContactoFavorito = false;
	}

	@Override
	public String toString(){
		return this.getNombre() + "," + this.getApellido() + "," + this.getCorreoElectronico() + "," + this.getNumeroTelefono() + "," + this.getEsContactoFavorito();
	}
}