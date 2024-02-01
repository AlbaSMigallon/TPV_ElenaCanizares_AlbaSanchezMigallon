package modelo;

public class Mesa {
	private int numeroMesa;
	private int pedidoActivo;
	private Pedido pedido;
	private Local local;

	public Mesa() {
	}

	public Mesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
		this.pedido = new Pedido(numeroMesa);
		this.local = Local.getInstance();
        //this.pedidoActivo = this.pedido.getIdPedido(); // Actualizar pedidoActivo
	}

	public int getNumeroMesa() {
		return numeroMesa;
	}

	public int getPedidoActivo() {
		return pedidoActivo;
	}

	public void setPedidoActivo(int pedidoActivo) {
		this.pedidoActivo = pedidoActivo;
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

	@Override
	public String toString() {
		return "Mesa " + numeroMesa;
	}
}
