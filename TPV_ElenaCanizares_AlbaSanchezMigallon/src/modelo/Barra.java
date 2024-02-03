package modelo;

import java.util.ArrayList;

public class Barra {
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
	
}// FIN CLASS
