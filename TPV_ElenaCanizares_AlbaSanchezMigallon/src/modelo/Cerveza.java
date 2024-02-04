package modelo;

public class Cerveza extends Producto {
	/*
	 * Clase que extiende de producto
	 */

	public Cerveza(double precio, String nombre) {
		super(precio, nombre);

	}

	/*
	 * public HashMap<String, InfoCerveza> getCervezas() { return cervezas; }
	 * 
	 * 
	 * 
	 * public void actualizarCantidad(String nombreRefresco, int nuevaCantidad) { if
	 * (cervezas.containsKey(nombreRefresco)) { InfoCerveza detalle =
	 * cervezas.get(nombreRefresco); detalle.setCantidad(nuevaCantidad); } }
	 * 
	 * private void guardarCantidadesOriginales() { cantidadesOriginales = new
	 * HashMap<>(); for (InfoCerveza infoCerveza : cervezas.values()) {
	 * cantidadesOriginales.put(infoCerveza.getNombre(), infoCerveza.getCantidad());
	 * } }
	 * 
	 * public void restaurarCantidadesOriginales() { for (InfoCerveza infoCerveza :
	 * cervezas.values()) { String nombreCerveza = infoCerveza.getNombre(); int
	 * cantidadOriginal = cantidadesOriginales.get(nombreCerveza);
	 * infoCerveza.setCantidad(cantidadOriginal); } }
	 * 
	 * // Clase interna para representar la información completa de una cerveza
	 * public static class InfoCerveza { private String nombre; private int
	 * cantidad; private int precio;
	 * 
	 * public InfoCerveza(String nombre, int cantidad, int precio) { this.nombre =
	 * nombre; this.cantidad = cantidad; this.precio = precio; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public int getCantidad() { return cantidad; }
	 * 
	 * public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	 * 
	 * public int getPrecio() { return precio; } }
	 */
}// FIN CLASS
