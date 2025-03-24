package cineapp;

public class Espectador {
    private String nombre;
    private double dinero;
    private int edad;

    public Espectador(String nombre, double dinero, int edad) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public double getDinero() { return dinero; }
    public int getEdad() { return edad; }

    public void pagarEntrada(double precio) { this.dinero -= precio; }
}
