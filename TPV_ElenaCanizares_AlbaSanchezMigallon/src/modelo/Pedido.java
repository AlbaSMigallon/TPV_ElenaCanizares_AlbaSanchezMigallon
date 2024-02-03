package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Pedido {
	private boolean esPagado;
	private ArrayList<Producto> productos;
	
	

	public Pedido() {
		this.productos= new ArrayList<>();
		this.esPagado= false;
	}

	/*
	public Pedido(int idPedido) {
		this.productos = new HashMap<>();
		this.idPedido = idPedido;
		
	}

	public void agregarBebida(String nombreBebida, int cantidad) {

		productos.put(nombreBebida, cantidad);

	}

	public void eliminarBebida(String nombreBebida, int cantidad) {
		productos.computeIfPresent(nombreBebida, (bebida, actualCantidad) -> actualCantidad - cantidad);
		productos.remove(nombreBebida, 0); // Elimina si la cantidad es cero o negativa
	}

	public void actualizarCantidadBebida(String nombreBebida, int nuevaCantidad) {
		// Actualizamos la cantidad de la bebida si ya existe en el pedido
		productos.put(nombreBebida, nuevaCantidad);
	}
*/
	public ArrayList<Producto> getproductos() {
		return productos;
	}

	public boolean esPagado() {
		return esPagado;
	}

	public void setEsPagado(boolean esPagado) {
		this.esPagado = esPagado;
	}

	public void marcarComoPagado() {
		this.esPagado = true;
	}

	
	public boolean isEsPagado() {
		return esPagado;
	}

	public void setproductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	

}
