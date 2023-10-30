package main;

public class Configuracion {
	private String nombreConfiguracion;
	private String correoConfiguracion;
	private ContactIQAppOld contactIQApp;

	public String getNombreConfiguracion() {
		return this.nombreConfiguracion;
	}

	public void setNombreConfiguracion(String nombreConfiguracion) {
		this.nombreConfiguracion = nombreConfiguracion;
	}

	public String getCorreoConfiguracion() {
		return this.correoConfiguracion;
	}

	public void setCorreoConfiguracion(String correoConfiguracion) {
		this.correoConfiguracion = correoConfiguracion;
	}
}