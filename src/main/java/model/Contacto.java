package model;

public class Contacto {
    private String nombre;
    private String apodo;
    private int numero;
    private String correo;
    private Favorito favorito;

    // Constructor
    public Contacto(String nombre, String apodo, int numero, String correo, Favorito favorito) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.numero = numero;
        this.correo = correo;
        this.favorito = favorito;
    }

    public Contacto(){
        this.nombre = "Sin datos";
        this.apodo = "Sin datos";
        this.numero = 0;
        this.correo = "Sin datos";
        this.favorito = null;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public int getNumero() {
        return numero;
    }

    public String getCorreo() {
        return correo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Favorito getFavorito() {
        return favorito;
    }

    @Override
    public String toString(){
        return this.nombre + "," + this.apodo + "," + this.numero + "," + this.correo + "," + this.favorito;
    }
}
