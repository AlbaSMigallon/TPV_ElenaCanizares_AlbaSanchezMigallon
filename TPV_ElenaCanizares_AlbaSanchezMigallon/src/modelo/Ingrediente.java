package modelo;

public class Ingrediente extends Producto {
	/*
	 * Clase que extiende de producto
	 */

	public Ingrediente(double precio, String nombre, boolean pedido) {
		super(precio, nombre, pedido);

	}
	/*
	 * 
	 * public HashMap<String, InfoIngrediente> getIngredientes() { return
	 * ingredientes; }
	 * 
	 * public void actualizarCantidad(String nombreIngrediente, int nuevaCantidad) {
	 * if (ingredientes.containsKey(nombreIngrediente)) { InfoIngrediente detalle =
	 * ingredientes.get(nombreIngrediente); detalle.setCantidad(nuevaCantidad); } }
	 * 
	 * private void guardarCantidadesOriginales() { cantidadesOriginales = new
	 * HashMap<>(); for (InfoIngrediente infoIngrediente : ingredientes.values()) {
	 * cantidadesOriginales.put(infoIngrediente.getNombre(),
	 * infoIngrediente.getCantidad()); } }
	 * 
	 * public void restaurarCantidadesOriginales() { for (InfoIngrediente
	 * infoIngrediente : ingredientes.values()) { String nombreIngrediente =
	 * infoIngrediente.getNombre(); int cantidadOriginal =
	 * cantidadesOriginales.get(nombreIngrediente);
	 * infoIngrediente.setCantidad(cantidadOriginal); } }
	 * 
	 * // Clase interna para representar la información completa de un ingrediente
	 * public static class InfoIngrediente { private String nombre; private int
	 * cantidad; private double precio;
	 * 
	 * public InfoIngrediente(String nombre, int cantidad, double precio) {
	 * this.nombre = nombre; this.cantidad = cantidad; this.precio = precio; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public int getCantidad() { return cantidad; }
	 * 
	 * public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	 * 
	 * public double getPrecio() { return precio; } }// FIN INFOINGREDIENTE
	 * 
	 */
}// FIN CLASS
