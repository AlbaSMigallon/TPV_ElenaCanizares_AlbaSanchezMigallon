package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventario {
	// contiene las litas de productos
	private ArrayList<Vino> stockVinos;
	private ArrayList<Cerveza> stockCervezas;
	private ArrayList<Refresco> stockRefrescos;
	private ArrayList<Ingrediente> stockIngredientes;

	private HashMap<String, Integer> inventario;

	public Inventario() {
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
}
