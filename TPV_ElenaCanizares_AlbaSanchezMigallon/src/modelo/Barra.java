package modelo;

import java.util.ArrayList;

public class Barra {
	/*
	 * La clase barra gestiona uns lista de pedidos de la barra
	 */
	private ArrayList<Pedido> pedidos;

	public Barra() {
		this.pedidos= new ArrayList<>();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Pedido getPedido(int posicionPedido) {
		return this.pedidos.get(posicionPedido);
		
	}
	
	public void aniadirPedidoBarra() {
		Pedido pedidoNuevo= new Pedido();
		this.pedidos.add(pedidoNuevo);
	}
	
	public void borrarPedidoBarra(int posicionPedido) {// le pasamos la posicion del pedido en la lista para que lo borre
		this.pedidos.remove(posicionPedido);
	}
	
}// FIN CLASS
