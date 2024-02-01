package modelo;

import java.util.HashMap;
import java.util.Collections;
import java.util.List;

public class Local {
	private HashMap<Integer, Mesa> mesas;
	private int idMesaActivo;
	// private List<Pedido> pedidos;

	private static Object object = new Object();
	private static Local instance = null;

	public Local() {

		this.mesas = new HashMap<>();
		
		// this.pedidos = new ArrayList<>();

	}// FIN LOCAL

	private synchronized static void createInstance() {
		if (null == instance) {
			instance = new Local();
		}
	}// FIN CREATE INSTANCE

	public static Local getInstance() {
		if (null == instance) {
			createInstance();
		}
		return instance;
	}// FIN GET INSTANCE

	/*
	 * public void registrarPedido(Pedido pedido) { synchronized (object) {
	 * pedidos.add(pedido); } }// FIN AGREGAR PEDIDO
	 */
	
	public Mesa cogerMesaId(Integer idMesa) {

		return mesas.get(idMesa);
	}

	public Mesa devolverMesa() {
		
		return cogerMesaId(idMesaActivo);
	}
	public int getIdMesaActivo() {
		return idMesaActivo;
	}

	public void setIdMesaActivo(int idMesaActivo) {
		this.idMesaActivo = idMesaActivo;
	}

	public HashMap<Integer, Mesa> getMesas() {
		if (mesas.isEmpty()) {
			for (int i = 0; i <= 6; i++) {
				mesas.put(i, new Mesa(i));
			}
		}
		return mesas;
	}


	
	public void setMesas(HashMap<Integer, Mesa> mesas) {
		this.mesas = mesas;
	}
	
	/*
	 * public List<Pedido> getPedidos() { if (pedidos.isEmpty()) { for (int i = 0; i
	 * <= 6; i++) { pedidos.add(new Pedido(i)); }
	 * 
	 * } return pedidos; }
	 * 
	 * public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
	 */

}// FIN CLASS
