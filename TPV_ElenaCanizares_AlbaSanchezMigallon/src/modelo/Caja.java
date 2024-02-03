package modelo;

import java.util.ArrayList;

public class Caja {
	private ArrayList<Pedido> pedidosActivos;
	private ArrayList<Pedido> pedidosPagados;
	// Seccion critica
	private static Object object = new Object();

	// Patron Singleton
	private static Caja instance;

	public Caja() {
		this.pedidosActivos = new ArrayList<>();
		this.pedidosPagados = new ArrayList<>();
	}

	private synchronized static void createInstance() {
		if (null == instance) {
			instance = new Caja();
		}
	}

	public static Caja getInstance() {
		if (null == instance) {
			createInstance();
		}
		return instance;
	}

	public ArrayList<Pedido> getPedidosActivos() {
		return pedidosActivos;
	}

	public void setPedidosActivos(ArrayList<Pedido> pedidosActivos) {
		this.pedidosActivos = pedidosActivos;
	}

	public ArrayList<Pedido> getPedidosPagados() {
		return pedidosPagados;
	}

	public void setPedidosPagados(ArrayList<Pedido> pedidosPagados) {
		this.pedidosPagados = pedidosPagados;
	}

	public void pagarPedido(int idPedido) {
		synchronized (object) {
			try {
				for (int i = 0; i < this.pedidosActivos.size(); i++) {
					if (this.pedidosActivos.get(i).getIdPedido() == idPedido) {
						this.pedidosPagados.add(this.pedidosActivos.get(i));
						this.pedidosActivos.remove(i);
						i = this.pedidosActivos.size();// salir del for
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}
	}

	public void calcularArqueo() {// calcula el total de los pedidos pagados
		synchronized (object) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	private void cerrarCaja() {// calcula el total de los pedidos pagados y resetea la lista de pedidos pagados
		synchronized (object) {
			try {
				calcularArqueo();
				this.pedidosPagados.removeAll(pedidosActivos);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public boolean entrarEnCierreCaja(String contrasenia) { // para cerrar caja tienes que logearte
		boolean esCerrada=false;
		synchronized (object) {
			
			try {
				if(contrasenia.equals("1234")) {
					cerrarCaja();
					esCerrada= true;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return esCerrada;
		
	}

}
