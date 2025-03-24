package cineapp;

public class Pelicula {
	private String titulo;
    private int duracion;
    private int edadMinima;
    private Genero genero;

    public Pelicula(String titulo, int duracion, int edadMinima, Genero genero) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.genero = genero;
    }

    public int getEdadMinima() { return edadMinima; }
    public String getTitulo() { return titulo; }
}
