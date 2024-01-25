package modelo;

import java.util.HashMap;

public class Refresco {
	private HashMap<String, InfoRefresco> refrescos;
	private HashMap<String, Integer> cantidadesOriginales;

	public Refresco() {
		this.refrescos = new HashMap<>();
		refrescos.put("Coca Cola", new InfoRefresco("Coca Cola", 3, 2));
		refrescos.put("Fanta de Limon", new InfoRefresco("Fanta de Limon", 2, 1));
		refrescos.put("Fanta de Naranja", new InfoRefresco("Fanta de Naranja", 2, 1));
		refrescos.put("Nestea", new InfoRefresco("Nestea", 3, 2));
		refrescos.put("Agua", new InfoRefresco("Agua", 1, 1));
		refrescos.put("Agua con gas", new InfoRefresco("Agua con gas", 1, 1));
		refrescos.put("Zumo de limon", new InfoRefresco("Zumo de limon", 3, 2));
		refrescos.put("Zumo de pina", new InfoRefresco("Zumo de pina", 3, 2));
		guardarCantidadesOriginales();
	}

	public HashMap<String, InfoRefresco> getRefrescos() {
		return refrescos;
	}

	public void actualizarCantidad(String nombreRefresco, int nuevaCantidad) {
		if (refrescos.containsKey(nombreRefresco)) {
			InfoRefresco detalle = refrescos.get(nombreRefresco);
			detalle.setCantidad(nuevaCantidad);
		}
	}

	private void guardarCantidadesOriginales() {
		cantidadesOriginales = new HashMap<>();
		for (InfoRefresco infoRefresco : refrescos.values()) {
			cantidadesOriginales.put(infoRefresco.getNombre(), infoRefresco.getCantidad());
		}
	}

	public void restaurarCantidadesOriginales() {
		for (InfoRefresco infoRefresco : refrescos.values()) {
			String nombreRefresco = infoRefresco.getNombre();
			int cantidadOriginal = cantidadesOriginales.get(nombreRefresco);
			infoRefresco.setCantidad(cantidadOriginal);
		}
	}

	// Clase interna para representar la información completa de un refresco
	public static class InfoRefresco {
		private String nombre;
		private int cantidad;
		private int precio;

		public InfoRefresco(String nombre, int cantidad, int precio) {
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
	}// FIN INFOREFRESCO
}// FIN CLASS