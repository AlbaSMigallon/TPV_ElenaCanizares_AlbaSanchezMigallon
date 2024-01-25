package modelo;

import java.util.HashMap;

public class Aperitivo {
	private HashMap<String, InfoAperitivo> aperitivos;

	public Aperitivo() {
		this.aperitivos = new HashMap<>();
		aperitivos.put("Gominolas", new InfoAperitivo("Gominolas", 30));
		aperitivos.put("Patatas fritas supreme", new InfoAperitivo("Patatas fritas supreme", 30));
		aperitivos.put("Cocktel de secos", new InfoAperitivo("Cocktel de secos", 30));
		aperitivos.put("Aceitunas rellenas", new InfoAperitivo("Aceitunas rellenas", 30));
		aperitivos.put("Table de quesos", new InfoAperitivo("Table de quesos", 30));
	}

	public HashMap<String, InfoAperitivo> getAperitivos() {
		return aperitivos;
	}

	// Clase interna para representar la información completa de un aperitivo
	public static class InfoAperitivo {
		private String nombre;
		private int cantidad;

		public InfoAperitivo(String nombre, int cantidad) {
			this.nombre = nombre;
			this.cantidad = cantidad;
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
	}// FIN INFOAPERITIVOS
}// FIN CLASS