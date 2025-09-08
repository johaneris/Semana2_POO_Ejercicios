package models;

public class Libros {
    String titulo;
    String autor;
    int anio;

    public Libros(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    // Metodo para acceder u obtener información del atributo titulo
    public String getTitulo() {
        return titulo;
    }

    // Metodo para acceder al atributo año
    public int getAnio() {
        return anio;
    }

}
