package modelo;

public class Mesa {
	private int numeroMesa;
	private Pedido pedido;

	public Mesa() {

	}

	public Mesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public Pedido getPedido() {
		if (pedido == null) {
			pedido = new Pedido();
		}
		return pedido;
	}
}
