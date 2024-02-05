package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {

	private ArrayList<Producto> productos;

	public Pedido() {
		this.productos = new ArrayList<>();

	}

	/*
	 * public Pedido(int idPedido) { this.productos = new HashMap<>(); this.idPedido
	 * = idPedido;
	 * 
	 * }
	 * 
	 * public void agregarBebida(String nombreBebida, int cantidad) {
	 * 
	 * productos.put(nombreBebida, cantidad);
	 * 
	 * }
	 * 
	 * public void eliminarBebida(String nombreBebida, int cantidad) {
	 * productos.computeIfPresent(nombreBebida, (bebida, actualCantidad) ->
	 * actualCantidad - cantidad); productos.remove(nombreBebida, 0); // Elimina si
	 * la cantidad es cero o negativa }
	 * 
	 * public void actualizarCantidadBebida(String nombreBebida, int nuevaCantidad)
	 * { // Actualizamos la cantidad de la bebida si ya existe en el pedido
	 * productos.put(nombreBebida, nuevaCantidad); }
	 */
	public ArrayList<Producto> getproductos() {
		return productos;
	}

	public void setproductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public double calcularTotalPedido() {
		double total = 0;

		for (int i = 0; i < this.productos.size(); i++) {
			total += this.productos.get(i).getPrecio();
		}
		return total;
	}

	public void pagarPedido() {
		Caja caja = Caja.getInstance();
		caja.getPedidosPagados().add(this);
		this.productos.removeAll(productos);
	}

	public boolean pedirProducto(Producto producto) {// le pasamos el producto, retorna boolean si deja pedirlo
		boolean esPedido = false;
		Inventario inventario = Inventario.getInstance();

		if (producto.getClass() == Aperitivo.class) {
			esPedido = inventario.restarStockAperitivos(1, producto.getNombre());
		} else if (producto.getClass() == Cerveza.class) {
			esPedido = inventario.restarStockCervezas(1, producto.getNombre());
		} else if (producto.getClass() == Refresco.class) {
			esPedido = inventario.restarStockRefresco(1, producto.getNombre());
		} else if (producto.getClass() == Vino.class) {
			esPedido = inventario.restarStockVinos(1, producto.getNombre());
		} else if (producto.getClass() == Coctel.class) {// controlar ingredientes por coctel
			if (producto.getNombre().equalsIgnoreCase("Cosmopolitan")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockIngredientes(1, "Vodka");
				boolean ingrediente2 = inventario.restarStockIngredientes(1, "Lima");
				if (ingrediente1 && ingrediente2) {// se puede pedir el coctel
					esPedido = true;
				}
			} else if (producto.getNombre().equalsIgnoreCase("Tequila Sunrise")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockIngredientes(1, "Tequila");
				boolean ingrediente2 = inventario.restarStockIngredientes(1, "Naranja");
				if (ingrediente1 && ingrediente2) {// se puede pedir el coctel
					esPedido = true;
				}
			} else if (producto.getNombre().equalsIgnoreCase("Daiquiri")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockBotellas(1, "Ron");
				boolean ingrediente2 = inventario.restarStockIngredientes(1, "Azucar");
				boolean ingrediente3 = inventario.restarStockIngredientes(1, "Limon");
				if (ingrediente1 && ingrediente2 && ingrediente3) {// se puede pedir el coctel
					esPedido = true;
				}
			} else if (producto.getNombre().equalsIgnoreCase("Bloody Mary")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockBotellas(1, "Vodka");
				boolean ingrediente2 = inventario.restarStockIngredientes(1, "Tomate");
				boolean ingrediente3 = inventario.restarStockIngredientes(1, "Tabasco");
				if (ingrediente1 && ingrediente2 && ingrediente3) {// se puede pedir el coctel
					esPedido = true;
				}
			} else if (producto.getNombre().equalsIgnoreCase("Mojito")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockBotellas(1, "Ron");
				boolean ingrediente2 = inventario.restarStockIngredientes(1, "Azucar");
				boolean ingrediente3 = inventario.restarStockIngredientes(1, "Menta");
				if (ingrediente1 && ingrediente2 && ingrediente3) {// se puede pedir el coctel
					esPedido = true;
				}
			} else if (producto.getNombre().equalsIgnoreCase("Pinia colada")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockBotellas(1, "Ron");
				boolean ingrediente2 = inventario.restarStockIngredientes(1, "Azucar");
				if (ingrediente1 && ingrediente2) {// se puede pedir el coctel
					esPedido = true;
				}
			} else if (producto.getNombre().equalsIgnoreCase("Martini")) {
				// intentar restar stock de ingredientes
				boolean ingrediente1 = inventario.restarStockBotellas(1, "Ginebra");
				boolean ingrediente2 = inventario.restarStockBotellas(1, "Vermut");
				if (ingrediente1 && ingrediente2) {// se puede pedir el coctel
					esPedido = true;
				}
			}

		}
		return esPedido;
	}

}
