package modelo;

import java.util.HashMap;

import modelo.Ingrediente.InfoIngrediente;

public class Vino {
	private HashMap<String, InfoVino> vinos;
	private HashMap<String, Integer> cantidadesOriginales;

	public Vino() {
		this.vinos = new HashMap<>();
		vinos.put("Vino Tinto", new InfoVino("Vino Tinto", 15, 25));
		vinos.put("Vino Blanco", new InfoVino("Vino Blanco", 16, 30));
		vinos.put("Vino Rosado", new InfoVino("Vino Rosado", 15, 28));
		vinos.put("Vino Verdejo", new InfoVino("Vino Verdejo", 16, 32));
		guardarCantidadesOriginales();
	}

	public HashMap<String, InfoVino> getVinos() {
		return vinos;
	}

	public void actualizarCantidad(String nombreVino, int nuevaCantidad) {
		if (vinos.containsKey(nombreVino)) {
			InfoVino detalle = vinos.get(nombreVino);
			detalle.setCantidad(nuevaCantidad);
		}
	}

	private void guardarCantidadesOriginales() {
		cantidadesOriginales = new HashMap<>();
		for (InfoVino infoVino : vinos.values()) {
			cantidadesOriginales.put(infoVino.getNombre(), infoVino.getCantidad());
		}
	}

	public void restaurarCantidadesOriginales() {
		for (InfoVino infoVino : vinos.values()) {
			String nombreVino = infoVino.getNombre();
			int cantidadOriginal = cantidadesOriginales.get(nombreVino);
			infoVino.setCantidad(cantidadOriginal);
		}
	}

	// Clase interna para representar la información completa de un vino
	public static class InfoVino {
		private String nombre;
		private int cantidad;
		private double precio;

		public InfoVino(String nombre, int cantidad, double precio) {
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
	}// FIN INFOVINO
}// FIN CLASS
