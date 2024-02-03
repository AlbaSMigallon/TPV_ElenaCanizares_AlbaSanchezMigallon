package modelo;



public class Vino extends Producto {
	public Vino(double precio, String nombre) {
		super(precio, nombre);
		
	}
	
	
	
	/*
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
		private int precio;

		public InfoVino(String nombre, int cantidad, int precio) {
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
	}// FIN INFOVINO
	
	*/
}// FIN CLASS
