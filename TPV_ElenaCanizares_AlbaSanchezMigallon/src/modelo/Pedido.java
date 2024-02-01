package modelo;

import java.util.HashMap;

public class Pedido {
	private boolean esPagado;
	private HashMap<String, Integer> bebidasPedido;
	// private Local local;
	private int idPedido;

	public Pedido() {

	}

	public Pedido(int idPedido) {
		this.bebidasPedido = new HashMap<>();
		this.idPedido = idPedido;
		// this.local = Local.getInstance();
	}

	public void agregarBebida(String nombreBebida, int cantidad) {

		bebidasPedido.put(nombreBebida, cantidad);

	}

	public void eliminarBebida(String nombreBebida, int cantidad) {
		bebidasPedido.computeIfPresent(nombreBebida, (bebida, actualCantidad) -> actualCantidad - cantidad);
		bebidasPedido.remove(nombreBebida, 0); // Elimina si la cantidad es cero o negativa
	}

	public void actualizarCantidadBebida(String nombreBebida, int nuevaCantidad) {
		// Actualizamos la cantidad de la bebida si ya existe en el pedido
		bebidasPedido.put(nombreBebida, nuevaCantidad);
	}

	public HashMap<String, Integer> getBebidasPedido() {
		return bebidasPedido;
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

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public boolean isEsPagado() {
		return esPagado;
	}

	public void setBebidasPedido(HashMap<String, Integer> bebidasPedido) {
		this.bebidasPedido = bebidasPedido;
	}

}
