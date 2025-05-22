package simulacion;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import modelo.Cajera;
import modelo.Cliente;
import util.GeneradorDatos;

public class Supermercado {
    public static void main(String[] args) {
        int cantidadClientes = 8; // Puedes ajustar la cantidad
        int cantidadCajeras = 2;  // Puedes ajustar la cantidad

        List<Cliente> clientes = GeneradorDatos.generarClientes(cantidadClientes);

        ExecutorService executor = Executors.newFixedThreadPool(cantidadCajeras);

        System.out.println("----- INICIO DE LA SIMULACIÓN DE COBRO -----");
        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < clientes.size(); i++) {
            String nombreCajera = "Cajera-" + ((i % cantidadCajeras) + 1);
            executor.execute(new Cajera(nombreCajera, clientes.get(i)));
        }

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


