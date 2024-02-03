package modelo;

import java.util.HashMap;

import modelo.Botella.InfoBotella;

public class Coctel extends Producto {
	private HashMap<String, InfoCoctel> cocteles;
	private HashMap<String, Integer> cantidadesOriginales;

	public Coctel() {
		this.cocteles = new HashMap<>();
		cocteles.put("Cosmopolitan", new InfoCoctel("Cosmopolitan", 15, 8));
		cocteles.put("Tequila Sunrise", new InfoCoctel("Tequila Sunrise", 16, 9));
		cocteles.put("Daiquiri", new InfoCoctel("Daiquiri", 15, 7));
		cocteles.put("Bloody Mary", new InfoCoctel("Bloody Mary", 16, 9));
		cocteles.put("Mojito", new InfoCoctel("Mojito", 15, 8));
		cocteles.put("Margarita", new InfoCoctel("Margarita", 16, 9));
		cocteles.put("Pina Colada", new InfoCoctel("Pina Colada", 15, 8));
		cocteles.put("Martini", new InfoCoctel("Martini", 16, 9));
		guardarCantidadesOriginales();
	}

	public HashMap<String, InfoCoctel> getCocteles() {
		return cocteles;
	}

	public void actualizarCantidad(String nombreCocktel, int nuevaCantidad) {
		if (cocteles.containsKey(nombreCocktel)) {
			InfoCoctel detalle = cocteles.get(nombreCocktel);
			detalle.setCantidad(nuevaCantidad);
		}
	}

	private void guardarCantidadesOriginales() {
		cantidadesOriginales = new HashMap<>();
		for (InfoCoctel infoCocktel : cocteles.values()) {
			cantidadesOriginales.put(infoCocktel.getNombre(), infoCocktel.getCantidad());
		}
	}

	public void restaurarCantidadesOriginales() {
		for (InfoCoctel infoCocktel : cocteles.values()) {
			String nombreCocktel = infoCocktel.getNombre();
			int cantidadOriginal = cantidadesOriginales.get(nombreCocktel);
			infoCocktel.setCantidad(cantidadOriginal);
		}
	}

	// Clase interna para representar la información completa de un coctel
	public static class InfoCoctel {
		private String nombre;
		private int cantidad;
		private int precio;

		public InfoCoctel(String nombre, int cantidad, int precio) {
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

		public int getPrecio() {
			return precio;
		}
	}// FIN INFOCOCTEL
}// FIN CLASS
