package cineapp;

import java.util.Random;

public class Cine {
	private Pelicula pelicula;
    private double precio;
    private int filas, columnas;
    private Espectador[][] asientos;
    private int numEspectadores;

    public Cine(int filas, int columnas, Pelicula pelicula, double precio) {
        this.filas = filas;
        this.columnas = columnas;
        this.pelicula = pelicula;
        this.precio = precio;
        this.asientos = new Espectador[filas][columnas];
        this.numEspectadores = 0;
    }

    public String venderAsiento(Espectador e) {
        if (e.getEdad() < pelicula.getEdadMinima()) {
            return " No cumple la edad mínima.";
        }
        if (e.getDinero() < precio) {
            return " No tiene suficiente dinero.";
        }
        Random rand = new Random();
        for (int i = 0; i < filas * columnas; i++) {
            int fila = rand.nextInt(filas);
            int col = rand.nextInt(columnas);
            if (asientos[fila][col] == null) {
                asientos[fila][col] = e;
                e.pagarEntrada(precio);
                numEspectadores++;
                return " Fila " + (filas - fila) + " asiento " + (char) ('A' + col);
            }
        }
        return " No hay asientos disponibles.";
    }

    public int recaudacion() {
        return (int) (numEspectadores * precio);
    }

    public void informeSala() {
        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("N.º de espectadores: " + numEspectadores);
        System.out.println("N.º de plazas: " + (filas * columnas));
        System.out.println("Ocupación: " + (numEspectadores * 100 / (filas * columnas)) + "%");
        System.out.println("Recaudación: " + recaudacion() + " Euros");
    }

    public void listadoEspectadores() {
        System.out.println("Lista de espectadores");
        System.out.println("------------------------");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (asientos[i][j] != null) {
                    System.out.println(asientos[i][j].getNombre() + "\tFila " + (filas - i) + " Asiento " + (char) ('A' + j));
                }
            }
        }
    }

    public void listadoAsientos() {
        System.out.println(" A B C D E F G H I");
        for (int i = 0; i < filas; i++) {
            System.out.print((filas - i) + " ");
            for (int j = 0; j < columnas; j++) {
                System.out.print((asientos[i][j] == null ? " " : "X") + " ");
            }
            System.out.println();
        }
    }
}
