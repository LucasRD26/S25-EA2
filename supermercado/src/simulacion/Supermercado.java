package simulacion;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import modelo.Cajera;
import modelo.Cliente;
import util.GeneradorDatos;

/**
 * Clase principal que simula el proceso de cobro en el supermercado.
 */
public class Supermercado {
    public static void main(String[] args) {
        int cantidadClientes = 8; // Puedes ajustar la cantidad
        int cantidadCajeras = 2;  // Puedes ajustar la cantidad

        // Generar clientes con productos aleatorios
        List<Cliente> clientes = GeneradorDatos.generarClientes(cantidadClientes);

        // Crear un pool de hilos para las cajeras
        ExecutorService executor = Executors.newFixedThreadPool(cantidadCajeras);

        System.out.println("----- INICIO DE LA SIMULACIÓN DE COBRO -----");
        long tiempoInicio = System.currentTimeMillis();

        // Asignar cada cliente a una cajera (hilo)
        for (int i = 0; i < clientes.size(); i++) {
            String nombreCajera = "Cajera-" + ((i % cantidadCajeras) + 1);
            executor.execute(new Cajera(nombreCajera, clientes.get(i)));
        }

        // Cerrar el pool y esperar a que terminen todos los procesos
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        long tiempoFin = System.currentTimeMillis();
        System.out.println("----- FIN DE LA SIMULACIÓN DE COBRO -----");
        System.out.println("Tiempo total de cobro para todos los clientes: " + (tiempoFin - tiempoInicio) + " ms");
    }
}


