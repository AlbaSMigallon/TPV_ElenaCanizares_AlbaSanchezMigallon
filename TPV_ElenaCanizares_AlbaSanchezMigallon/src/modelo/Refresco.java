package modelo;

public class Refresco extends Producto {
	/*
	 * Clase que extiende de producto
	 */
	public Refresco(double precio, String nombre) {
		super(precio, nombre);

	}

	/*
	 * public HashMap<String, InfoRefresco> getRefrescos() { return refrescos; }
	 * 
	 * public void actualizarCantidad(String nombreRefresco, int nuevaCantidad) { if
	 * (refrescos.containsKey(nombreRefresco)) { InfoRefresco detalle =
	 * refrescos.get(nombreRefresco); detalle.setCantidad(nuevaCantidad); } }
	 * 
	 * private void guardarCantidadesOriginales() { cantidadesOriginales = new
	 * HashMap<>(); for (InfoRefresco infoRefresco : refrescos.values()) {
	 * cantidadesOriginales.put(infoRefresco.getNombre(),
	 * infoRefresco.getCantidad()); } }
	 * 
	 * public void restaurarCantidadesOriginales() { for (InfoRefresco infoRefresco
	 * : refrescos.values()) { String nombreRefresco = infoRefresco.getNombre(); int
	 * cantidadOriginal = cantidadesOriginales.get(nombreRefresco);
	 * infoRefresco.setCantidad(cantidadOriginal); } }
	 * 
	 * // Clase interna para representar la información completa de un refresco
	 * public static class InfoRefresco { private String nombre; private int
	 * cantidad; private int precio;
	 * 
	 * public InfoRefresco(String nombre, int cantidad, int precio) { this.nombre =
	 * nombre; this.cantidad = cantidad; this.precio = precio; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public int getCantidad() { return cantidad; }
	 * 
	 * public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	 * 
	 * public int getPrecio() { return precio; } }// FIN INFOREFRESCO
	 */
}// FIN CLASS