package modelo;

import java.util.List;

public class Local {
	private List<Mesa> mesas;
	private List<Pedido> pedidos;

	private static Object object = new Object();
	private static Local instance = null;

	public Local() {
		this.mesas = mesas;
		this.pedidos = pedidos;

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

public void agregarPedido() {
	synchronized(object) {
		pedidos.add()
	}
}
}// FIN CLASS
