package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import modelo.Cliente;
import modelo.Producto;


public class GeneradorDatos {
    private static final String[] NOMBRES_PRODUCTOS = {
        "Leche", "Pan", "Arroz", "Huevos", "Jabón", "Carne", "Queso", "Cereal", "Jugo", "Frutas"
    };
    private static final Random random = new Random();

   
    public static List<Cliente> generarClientes(int cantidadClientes) {
        List<Cliente> clientes = new ArrayList<>();
        for (int i = 1; i <= cantidadClientes; i++) {
            Cliente cliente = new Cliente("Cliente-" + i);
            int productosEnCarrito = random.nextInt(3) + 2; // Entre 2 y 4 productos
            for (int j = 0; j < productosEnCarrito; j++) {
                cliente.agregarProducto(generarProductoAleatorio());
            }
            clientes.add(cliente);
        }
        return clientes;
    }

    
    public static Producto generarProductoAleatorio() {
        String nombre = NOMBRES_PRODUCTOS[random.nextInt(NOMBRES_PRODUCTOS.length)];
        double precio = 1 + (20 - 1) * random.nextDouble(); // Precio entre $1 y $20
        long tiempo = 500 + random.nextInt(1000); // Entre 500ms y 1500ms
        return new Producto(nombre, Math.round(precio * 100.0) / 100.0, tiempo);
    }
}

