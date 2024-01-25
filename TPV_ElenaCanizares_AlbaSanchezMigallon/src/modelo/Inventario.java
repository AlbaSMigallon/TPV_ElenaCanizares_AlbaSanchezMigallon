package modelo;

import java.util.HashMap;

public class Inventario {
	private Refresco refresco; // Agregamos una instancia de refresco para prueba

	private HashMap<String, Integer> inventario;

	public Inventario(Refresco refresco) {
		this.refresco = refresco;
		this.inventario = new HashMap<>();
	}

	public void agregarProducto(String nombreBebida, int cantidad) {
		inventario.put(nombreBebida, cantidad);
	}

	public void eliminarProducto(String nombreBebida, int cantidad) {
		inventario.remove(nombreBebida, cantidad);
	}

	public HashMap<String, Integer> getInventario() {
		return inventario;
	}

	public void actualizarCantidad(String nombreProducto, int nuevaCantidad) {
		// Actualizamos la cantidad en el HashMap del Inventario
		if (inventario.containsKey(nombreProducto)) {
			inventario.put(nombreProducto, nuevaCantidad);
		} else {
			// Controlamos por si acaso si el producto no existe en el inventario
			System.out.println("El producto no existe en el inventario.");
		}

		// Actualizar la cantidad , aunque en refresco tbn lo hare
		if (refresco != null) {
			refresco.actualizarCantidad(nombreProducto, nuevaCantidad);
		}
	}
}
