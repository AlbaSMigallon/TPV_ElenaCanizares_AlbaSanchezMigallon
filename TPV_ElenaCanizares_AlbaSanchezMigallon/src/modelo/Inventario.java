package modelo;

import java.util.HashMap;

public class Inventario {
	private Refresco refresco; // Agregamos una instancia de refresco para prueba
	private Cerveza cerveza;
	private Aperitivo aperitivo;
	private Botella botella;
	private Coctel cocktel;
	private Ingrediente ingrediente;
	private Vino vino;
	private HashMap<String, Integer> inventario;

	public Inventario(Refresco refresco, Cerveza cerveza, Aperitivo aperitivo, Botella botella, Coctel cocktel,
			Ingrediente ingrediente, Vino vino, HashMap<String, Integer> inventario) {
		this.refresco = refresco;
		this.cerveza = cerveza;
		this.aperitivo = aperitivo;
		this.botella = botella;
		this.cocktel = cocktel;
		this.ingrediente = ingrediente;
		this.vino = vino;
		this.inventario = inventario;
		this.inventario = new HashMap<>();
	}

	public Inventario() {

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
		}

	}
}
