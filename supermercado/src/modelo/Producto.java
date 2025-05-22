package modelo;

public class Producto {
    private String nombre;
    private double precio;
    private long tiempoProcesamiento; // en milisegundos


    public Producto(String nombre, double precio, long tiempoProcesamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProcesamiento = tiempoProcesamiento;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public long getTiempoProcesamiento() {
        return tiempoProcesamiento;
    }
}
