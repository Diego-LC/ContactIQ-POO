package main;

import java.util.ArrayList;

public class Contacto {
	private String nombreContacto;
	private String correoContacto;
	private String numeroContacto;
	private boolean esContactoFavorito;

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getCorreoContacto() {
		return this.correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public String getNumeroContacto() {
		return this.numeroContacto;
	}

	public void setNumeroContacto(String numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public boolean getEsContactoFavorito() {
		return this.esContactoFavorito;
	}

	public void setEsContactoFavorito(boolean esContactoFavorito) {
		this.esContactoFavorito = esContactoFavorito;
	}
}