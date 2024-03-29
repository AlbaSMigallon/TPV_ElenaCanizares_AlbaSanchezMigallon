package modelo;

public class Mesa {
	/*
	 * Clase mesa con numero de la mesa, el pedido que contiene productos, y un boolean de si esta ocuapada
	 */
	private int numeroMesa;
	private Pedido pedido;
	private boolean esOcupada;
	


	public Mesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
		this.pedido = new Pedido();
		this.esOcupada=false;
	}
	
	

	public boolean isEsOcupada() {
		return esOcupada;
	}



	public void setEsOcupada(boolean esOcupada) {
		this.esOcupada = esOcupada;
	}



	public int getNumeroMesa() {
		return numeroMesa;
	}


	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void borrarPedidoMesa() {
		this.pedido= new Pedido();
	}
}
