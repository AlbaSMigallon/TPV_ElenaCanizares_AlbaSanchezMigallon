package modelo;

public class Mesa {
	private int numeroMesa;
	private Pedido pedido;

	public Mesa() {

	}

	public Mesa(int numeroMesa) {
	    this.numeroMesa = numeroMesa;
	    this.pedido = new Pedido(); 
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
	 @Override
	    public String toString() {
	        return "Mesa " + numeroMesa;
	    }
	 @Override
	 public boolean equals(Object obj) {
	     if (this == obj) {
	         return true;
	     }
	     if (obj == null || getClass() != obj.getClass()) {
	         return false;
	     }
	     Mesa otherMesa = (Mesa) obj;
	     return numeroMesa == otherMesa.numeroMesa;
	 }
}
