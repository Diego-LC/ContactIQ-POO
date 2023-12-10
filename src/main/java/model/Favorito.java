package model;

public enum Favorito {
    SI("Sí"),
    NO("No");

    private String favorito;

    private Favorito(String favorito) {
        this.favorito = favorito;
    }

    public String getFavorito() {
        return favorito;
    }
}
