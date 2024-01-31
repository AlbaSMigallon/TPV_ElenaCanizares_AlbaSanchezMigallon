package modelo;

import java.util.HashMap;

public class Pedido {
	private boolean esOcupada;
	private boolean tienePedidoExistente;
	private HashMap<String, Integer> bebidasPedido;

	public Pedido() {
		this.bebidasPedido = new HashMap<>();
		this.tienePedidoExistente = false;
	}

	public void agregarBebida(String nombreBebida, int cantidad) {
		if (!esOcupada) {
			esOcupada = true;
		}
		bebidasPedido.put(nombreBebida, cantidad);
		tienePedidoExistente = true;
	}

	public boolean tienePedidoExistente() {
		return tienePedidoExistente;
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

	public boolean esOcupada() {
		return esOcupada;
	}

	public void setEsOcupada(boolean esOcupada) {
		this.esOcupada = esOcupada;
	}
}
