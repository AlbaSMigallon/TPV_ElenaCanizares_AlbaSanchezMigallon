package modelo;

import java.util.HashMap;

public class Ingrediente {
	private HashMap<String, InfoIngrediente> ingredientes;

	public Ingrediente() {
		this.ingredientes = new HashMap<>();
		ingredientes.put("Hierba buena", new InfoIngrediente("Hierba buena", 30, 2));
		ingredientes.put("Limon", new InfoIngrediente("Limon", 30, 1.5));
		ingredientes.put("Naranja", new InfoIngrediente("Naranja", 30, 2));
		ingredientes.put("Tabasco", new InfoIngrediente("Tabasco", 30, 3));
		ingredientes.put("Menta", new InfoIngrediente("Menta", 30, 2.5));
		ingredientes.put("Fresas", new InfoIngrediente("Fresas", 30, 4));
		ingredientes.put("Lima", new InfoIngrediente("Lima", 30, 1.5));
		ingredientes.put("Azucar", new InfoIngrediente("Azucar", 30, 1));
		ingredientes.put("Tomate", new InfoIngrediente("Tomate", 30, 2));
		ingredientes.put("Coco", new InfoIngrediente("Coco", 30, 3.5));
		ingredientes.put("Eucalipto", new InfoIngrediente("Eucalipto", 30, 2));
	}

	public HashMap<String, InfoIngrediente> getIngredientes() {
		return ingredientes;
	}

	// Clase interna para representar la información completa de un ingrediente
	public static class InfoIngrediente {
		private String nombre;
		private int cantidad;
		private double precio;

		public InfoIngrediente(String nombre, int cantidad, double precio) {
			this.nombre = nombre;
			this.cantidad = cantidad;
			this.precio = precio;
		}

		public String getNombre() {
			return nombre;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}

		public double getPrecio() {
			return precio;
		}
	}//FIN INFOINGREDIENTE
}// FIN CLASS
