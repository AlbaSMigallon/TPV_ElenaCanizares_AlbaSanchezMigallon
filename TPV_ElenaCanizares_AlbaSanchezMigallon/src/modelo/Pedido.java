package modelo;

import java.util.HashMap;

public class Pedido {
	private long idMesa;
	private boolean esOcupada;
	private HashMap<String, Integer> pedido;

	public Pedido() {
		this.pedido = new HashMap<>();
	}

	public void agregarBebida(String nombreBebida, int cantidad) {
		pedido.put(nombreBebida, cantidad);
	}

	public void eliminarBebida(String nombreBebida, int cantidad) {
		pedido.remove(nombreBebida, cantidad);
	}

	public HashMap<String, Integer> getBebidasPedido() {
		return pedido;
	}

	public boolean esOcupada() {
		return esOcupada;
	}

	public void setEsOcupada(boolean esOcupada) {
		this.esOcupada = esOcupada;
	}


}// FIN CLASS
