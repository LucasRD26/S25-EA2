package modelo;


public class Cajera implements Runnable {
    private String nombre;
    private Cliente cliente;

   
    public Cajera(String nombre, Cliente cliente) {
        this.nombre = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        System.out.println("Cajera " + nombre + " comienza a atender a " + cliente.getNombre());
        long tiempoInicio = System.currentTimeMillis();
        double total = 0;

        for (Producto producto : cliente.getCarrito()) {
            try {
                Thread.sleep(producto.getTiempoProcesamiento());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            total += producto.getPrecio();
            System.out.println("Cajera " + nombre + " procesó el producto: " + producto.getNombre() +
                               " | Precio: $" + producto.getPrecio() +
                               " | Tiempo: " + producto.getTiempoProcesamiento() + "ms");
        }

        long tiempoFin = System.currentTimeMillis();
        System.out.println("Cajera " + nombre + " terminó de atender a " + cliente.getNombre() +
                           " | Total a pagar: $" + total +
                           " | Tiempo total: " + (tiempoFin - tiempoInicio) + "ms");
    }
}
