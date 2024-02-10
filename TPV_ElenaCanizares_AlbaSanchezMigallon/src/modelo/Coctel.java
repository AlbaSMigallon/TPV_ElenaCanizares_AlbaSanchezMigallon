package modelo;

public class Coctel extends Producto {
	/*
	 * Clase que extiende de producto
	 */
	public Coctel(double precio, String nombre, boolean pedido) {
		super(precio, nombre, pedido);

	}

	/*
	 * public HashMap<String, InfoCoctel> getCocteles() { return cocteles; }
	 * 
	 * public void actualizarCantidad(String nombreCocktel, int nuevaCantidad) { if
	 * (cocteles.containsKey(nombreCocktel)) { InfoCoctel detalle =
	 * cocteles.get(nombreCocktel); detalle.setCantidad(nuevaCantidad); } }
	 * 
	 * private void guardarCantidadesOriginales() { cantidadesOriginales = new
	 * HashMap<>(); for (InfoCoctel infoCocktel : cocteles.values()) {
	 * cantidadesOriginales.put(infoCocktel.getNombre(), infoCocktel.getCantidad());
	 * } }
	 * 
	 * public void restaurarCantidadesOriginales() { for (InfoCoctel infoCocktel :
	 * cocteles.values()) { String nombreCocktel = infoCocktel.getNombre(); int
	 * cantidadOriginal = cantidadesOriginales.get(nombreCocktel);
	 * infoCocktel.setCantidad(cantidadOriginal); } }
	 * 
	 * // Clase interna para representar la información completa de un coctel public
	 * static class InfoCoctel { private String nombre; private int cantidad;
	 * private int precio;
	 * 
	 * public InfoCoctel(String nombre, int cantidad, int precio) { this.nombre =
	 * nombre; this.cantidad = cantidad; this.precio = precio; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public int getCantidad() { return cantidad; }
	 * 
	 * public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	 * 
	 * public int getPrecio() { return precio; } }// FIN INFOCOCTEL
	 */
}// FIN CLASS
