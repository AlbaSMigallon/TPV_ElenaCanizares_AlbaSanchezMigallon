package controlador;

import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import vista.Vista;
import modelo.Barra;
import modelo.Botella;
import modelo.Cerveza;
import modelo.Coctel;
import modelo.Ingrediente;
import modelo.Inventario;
import modelo.Mesa;
import modelo.Musica;
import modelo.Pedido;
import modelo.Refresco;
import modelo.Vino;
import persistencias.Resta;
import persistencias.Suma;

public class Controlador implements ActionListener {
	Vista vista = new Vista();
	Barra barra = new Barra();
	Botella botella = new Botella();
	Cerveza cerveza = new Cerveza();
	Coctel coctel = new Coctel();
	Ingrediente ingrediente = new Ingrediente();
	Inventario inventario = new Inventario();
	Mesa mesa = new Mesa();
	Musica musica = new Musica();
	Pedido pedido = new Pedido();
	Refresco refresco = new Refresco();
	Vino vino = new Vino();

	public Controlador(Vista vista) {
		this.vista = vista;
		this.barra = barra;
		this.botella = botella;
		this.cerveza = cerveza;
		this.coctel = coctel;
		this.ingrediente = ingrediente;
		this.inventario = inventario;
		this.mesa = mesa;
		this.musica = musica;
		this.pedido = pedido;
		this.refresco = refresco;
		this.vino = vino;
	}// FIN CONSTRUCTOR

	@Override
	public void actionPerformed(ActionEvent e) {
		// SUMA LAS CANTIDADES DE BEBIDAS DEL PEDIDO
		HashMap<String, Integer> cantidadesTotalesSumarEjemplo = Suma.sumarCantidades(pedido.getBebidasPedido());
		// RESTA LAS CANTIDADES DE BEBIDAS DEL PEDIDO
		HashMap<String, Integer> cantidadesTotalesRestarEjemplo = Resta.restarCantidades(pedido.getBebidasPedido());

		// EJEMPLO DE COMO DEBERIAMOS OBTENER EL INDICE SELECCIONADO EN LA VISTA POR EL
		// USUARIO Y LANZAR LA CANCION QUE LE CORRESPONDA
		/*
		 * int selectedIndex = comboBox.getSelectedIndex();
		 * musica.lanzar(selectedIndex);
		 */

	}// FIN ACTION PERFORMED
	/*
	 * Controlador.vista.getList().addListSelectionListener(new
	 * ListSelectionListener() {
	 * 
	 * @Override public void valueChanged(ListSelectionEvent e) { if
	 * (!e.getValueIsAdjusting()) { // Obtenemos el índice del elemento clicado int
	 * indice = vista.getList().getSelectedIndex(); if (indice != -1) {
	 * vista.getComboBoxComensales().setSelectedIndex(0);
	 * vista.getPanelPedidos().setVisible(true);
	 * vista.getTextAreaMesas().setVisible(true); if (mesasSeleccionado) {
	 * if(!mesas.get(indice).isServido()) {
	 * vista.getBtnCrearComanda().setText("Crear comanda");
	 * vista.getTextAreaMesas().setText(mesas.get(indice).getId() +
	 * " sin clientes"); }else { vista.getBtnCrearComanda().setText("Añadir");
	 * vista.getTextAreaMesas().setText(mesas.get(indice).toString()); } } else if
	 * (barraSeleccionado) { if(!barras.get(indice).isServido()) {
	 * vista.getBtnCrearComanda().setText("Crear comanda");
	 * vista.getTextAreaMesas().setText(barras.get(indice).getId() +
	 * " sin clientes"); }else { vista.getBtnCrearComanda().setText("Añadir");
	 * vista.getTextAreaMesas().setText(barras.get(indice).toString()); } } } else {
	 * vista.getTextAreaMesas().setText(""); } } } });
	 */
}
