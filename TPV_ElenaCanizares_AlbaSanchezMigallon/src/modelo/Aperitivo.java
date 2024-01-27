package modelo;

import java.util.HashMap;

import modelo.Refresco.InfoRefresco;

public class Aperitivo {
	private HashMap<String, InfoAperitivo> aperitivos;
	private HashMap<String, Integer> cantidadesOriginales;

	public Aperitivo() {
		this.aperitivos = new HashMap<>();
		aperitivos.put("Gominolas", new InfoAperitivo("Gominolas", 30, 1));
		aperitivos.put("Patatas fritas supreme", new InfoAperitivo("Patatas fritas supreme", 30, 1));
		aperitivos.put("Cocktel de secos", new InfoAperitivo("Cocktel de secos", 30, 1));
		aperitivos.put("Aceitunas rellenas", new InfoAperitivo("Aceitunas rellenas", 30, 1));
		aperitivos.put("Table de quesos", new InfoAperitivo("Table de quesos", 30, 1));
		guardarCantidadesOriginales();
	}

	public HashMap<String, InfoAperitivo> getAperitivos() {
		return aperitivos;
	}

	public void actualizarCantidad(String nombreRefresco, int nuevaCantidad) {
		if (aperitivos.containsKey(nombreRefresco)) {
			InfoAperitivo detalle = aperitivos.get(nombreRefresco);
			detalle.setCantidad(nuevaCantidad);
		}
	}

	private void guardarCantidadesOriginales() {
		cantidadesOriginales = new HashMap<>();
		for (InfoAperitivo infoAperitivo : aperitivos.values()) {
			cantidadesOriginales.put(infoAperitivo.getNombre(), infoAperitivo.getCantidad());
		}
	}

	public void restaurarCantidadesOriginales() {
		for (InfoAperitivo infoAperitivo : aperitivos.values()) {
			String nombreRefresco = infoAperitivo.getNombre();
			int cantidadOriginal = cantidadesOriginales.get(nombreRefresco);
			infoAperitivo.setCantidad(cantidadOriginal);
		}
	}

	// Clase interna para representar la información completa de un aperitivo
	public static class InfoAperitivo {
		private String nombre;
		private int cantidad;
		private int precio;

		public InfoAperitivo(String nombre, int cantidad, int precio) {
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

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

	}// FIN INFOAPERITIVOS
}// FIN CLASS