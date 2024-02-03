package modelo;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Local {
	/*
	 * clase que gestiona el local. las localizaciones con sus pedidos asociados
	 */
	private ArrayList<Mesa> mesas;
	private Barra barra;
// patron singleton
	private static Object object = new Object();
	private static Local instance = null;

	public Local() {

		this.mesas = new ArrayList<>();

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

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Barra getBarra() {
		return barra;
	}

	public void setBarra(Barra barra) {
		this.barra = barra;
	}
	
	private void inicializarMesas() {
		for(int i=0; i<7; i++) {
			Mesa mesa= new Mesa(i+1);//crear mesas y asignar numero
		}
	}

	/*
	 * public void registrarPedido(Pedido pedido) { synchronized (object) {
	 * pedidos.add(pedido); } }// FIN AGREGAR PEDIDO
	 */





	/*
	 * public List<Pedido> getPedidos() { if (pedidos.isEmpty()) { for (int i = 0; i
	 * <= 6; i++) { pedidos.add(new Pedido(i)); }
	 * 
	 * } return pedidos; }
	 * 
	 * public void setPedidos(List<Pedido> pedidos) { this.pedidos = pedidos; }
	 */

}// FIN CLASS
