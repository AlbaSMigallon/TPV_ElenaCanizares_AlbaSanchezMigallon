package modelo;

import java.util.ArrayList;

public class Caja {
	/*
	 * Clase para la gestion de la caja. Recurso compartido con patron singleton
	 */

	private ArrayList<Pedido> pedidosPagados;
	// Seccion critica
	private static Object object = new Object();

	// Patron Singleton
	private static Caja instance;

	public Caja() {

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

	public ArrayList<Pedido> getPedidosPagados() {
		return pedidosPagados;
	}

	public void setPedidosPagados(ArrayList<Pedido> pedidosPagados) {
		this.pedidosPagados = pedidosPagados;
	}

	public void pagarPedidoCaja(Pedido pedido) {// le pasamos desde local el pedido y lo aniade aepdidos pagados
		synchronized (object) {

			this.pedidosPagados.add(pedido);

		}
	}

	public double calcularArqueo() {// calcula el total de los pedidos pagados
		double total = 0;
		synchronized (object) {

			try {
				for (int i = 0; i < this.pedidosPagados.size(); i++) {// recorremos pedidos pagados
					for (int j = 0; j < this.pedidosPagados.get(i).getproductos().size(); j++) {// recorremos lista de
																								// productos del pedido
						total += this.pedidosPagados.get(i).getproductos().get(j).getPrecio();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return total;
	}

	public double cerrarCaja() {// calcula el total de los pedidos pagados y resetea la lista de pedidos pagados
		double total = 0;
		synchronized (object) {
			try {
				total = calcularArqueo();
				this.pedidosPagados.removeAll(pedidosPagados);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return total;
	}

	public boolean comprobarContrasenia(char[] contraseniaIntroducida) { // para cerrar caja tienes que logearte
		boolean esCorrecta = true;
		char[] contraseniaDefinida = {'1', '2', '3', '4'};
		int lengthContraseniaDefinida = contraseniaDefinida.length;
		int lengthContraseniaIntroducida = contraseniaIntroducida.length;

		synchronized (object) {

			try {
				if (lengthContraseniaDefinida == lengthContraseniaIntroducida) {
	                for (int i = 0; i < contraseniaDefinida.length; i++) {
	                    if (contraseniaDefinida[i] != contraseniaIntroducida[i]) { 
	                        esCorrecta = false;
	                        i=contraseniaDefinida.length;// para salir del for
	                    }
	                }
	            } else {
	                esCorrecta = false;
	            }

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return esCorrecta;

	}

}//FIN CLASS
