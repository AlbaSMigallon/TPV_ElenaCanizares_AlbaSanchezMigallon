package modelo;

public class Aperitivo extends Producto {
	/*
	 * Clase que extiende de producto
	 */

	public Aperitivo(double precio, String nombre) {
		super(precio, nombre);

	}

	/*
	 * 
	 * 
	 * void guardarCantidadesOriginales() { cantidadesOriginales = new HashMap<>();
	 * for (InfoAperitivo infoAperitivo : aperitivos.values()) {
	 * cantidadesOriginales.put(infoAperitivo.getNombre(),
	 * infoAperitivo.getCantidad()); } }
	 * 
	 * public void restaurarCantidadesOriginales() { for (InfoAperitivo
	 * infoAperitivo : aperitivos.values()) { String nombreAperitivo =
	 * infoAperitivo.getNombre(); int cantidadOriginal =
	 * cantidadesOriginales.get(nombreAperitivo);
	 * infoAperitivo.setCantidad(cantidadOriginal); } }
	 * 
	 * // Clase interna para representar la información completa de un aperitivo
	 * public static class InfoAperitivo { private String nombre; private int
	 * cantidad; private int precio;
	 * 
	 * public InfoAperitivo(String nombre, int cantidad, int precio) { this.nombre =
	 * nombre; this.cantidad = cantidad; this.precio = precio; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public int getCantidad() { return cantidad; }
	 * 
	 * public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	 * 
	 * public int getPrecio() { return precio; }
	 * 
	 * public void setPrecio(int precio) { this.precio = precio; }
	 * 
	 * public void setNombre(String nombre) { this.nombre = nombre; }
	 * 
	 * }// FIN INFOAPERITIVOS
	 */
}// FIN CLASS