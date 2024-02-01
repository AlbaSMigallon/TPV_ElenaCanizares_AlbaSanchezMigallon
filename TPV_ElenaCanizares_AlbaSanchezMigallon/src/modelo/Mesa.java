package modelo;

public class Mesa {
	private int numeroMesa;
	private Pedido pedido;
	private Local local;
	public Mesa() {

	}

	public Mesa(int numeroMesa) {
	    this.numeroMesa = numeroMesa;
	    this.local = Local.getInstance();
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
	 public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void agregarBebida(String nombreBebida, int cantidad) {
	        getPedido().agregarBebida(nombreBebida, cantidad);
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
