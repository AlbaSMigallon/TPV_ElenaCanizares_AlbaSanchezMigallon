package modelo;

public class Botella extends Producto {
	/*
	 * Clase que extiende de producto
	 */

	public Botella(double precio, String nombre) {
		super(precio, nombre);

	}
	/*
	 * public HashMap<String, InfoBotella> getBotellas() { return botellas; } public
	 * void actualizarCantidad(String nombreBotella, int nuevaCantidad) { if
	 * (botellas.containsKey(nombreBotella)) { InfoBotella detalle =
	 * botellas.get(nombreBotella); detalle.setCantidad(nuevaCantidad); } }
	 * 
	 * private void guardarCantidadesOriginales() { cantidadesOriginales = new
	 * HashMap<>(); for (InfoBotella infoBotella : botellas.values()) {
	 * cantidadesOriginales.put(infoBotella.getNombre(), infoBotella.getCantidad());
	 * } }
	 * 
	 * public void restaurarCantidadesOriginales() { for (InfoBotella infoBotella :
	 * botellas.values()) { String nombreBotella = infoBotella.getNombre(); int
	 * cantidadOriginal = cantidadesOriginales.get(nombreBotella);
	 * infoBotella.setCantidad(cantidadOriginal); } } // Clase interna para
	 * representar la información completa de una botella public static class
	 * InfoBotella { private String nombre; private int cantidad; private int
	 * precio;
	 * 
	 * public InfoBotella(String nombre, int cantidad, int precio) { this.nombre =
	 * nombre; this.cantidad = cantidad; this.precio = precio; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public int getCantidad() { return cantidad; }
	 * 
	 * public void setCantidad(int cantidad) { this.cantidad = cantidad; }
	 * 
	 * public int getPrecio() { return precio; } }//FIN INFO BOTELLA
	 */
}// FIN CLASS
