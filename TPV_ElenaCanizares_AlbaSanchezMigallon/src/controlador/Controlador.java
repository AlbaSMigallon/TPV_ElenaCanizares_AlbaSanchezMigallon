package controlador;

import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JSpinner;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Vista;
import modelo.Barra;
import modelo.Botella;
import modelo.Cerveza;
import modelo.Cerveza.InfoCerveza;
import modelo.Coctel;
import modelo.Ingrediente;
import modelo.Inventario;
import modelo.Mesa;
import modelo.Musica;
import modelo.Pedido;
import modelo.Refresco;
import modelo.Refresco.InfoRefresco;
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

	Mesa mesa = new Mesa();
	Musica musica = new Musica();
	Pedido pedido = new Pedido();
	Refresco refresco = new Refresco();
	Vino vino = new Vino();
	Inventario inventario;

	public Controlador(Vista vista) {
		this.vista = vista;
		this.barra = barra;
		this.botella = botella;
		this.cerveza = cerveza;
		this.coctel = coctel;
		this.ingrediente = ingrediente;
		this.inventario = new Inventario(this.refresco);
		this.mesa = mesa;
		this.musica = musica;
		this.pedido = pedido;
		this.refresco = refresco;
		this.vino = vino;

		this.vista.btnCaja.addActionListener(this);
		this.vista.btnPedido.addActionListener(this);
		this.vista.btnInventario.addActionListener(this);
		this.vista.btnMusica.addActionListener(this);
		this.vista.btnMesa1.addActionListener(this);
		this.vista.btnMesa2.addActionListener(this);
		this.vista.btnMesa3.addActionListener(this);
		this.vista.btnMesa4.addActionListener(this);
		this.vista.btnMesa5.addActionListener(this);
		this.vista.btnMesa6.addActionListener(this);
		this.vista.btnMesa7.addActionListener(this);
		this.vista.btnBarra.addActionListener(this);
		this.vista.btnAceptarCambios.addActionListener(this);
		this.vista.btnRevertirCambios.addActionListener(this);

	}// FIN CONSTRUCTOR

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnCaja) {
			vista.panelInicio.setVisible(false);
			vista.panelCaja.setVisible(true);
		} // PANEL CAJA
		if (e.getSource() == vista.btnPedido) {
			vista.panelInicio.setVisible(false);
			vista.panelPedido.setVisible(true);
		} // PANEL PEDIDO
		if (e.getSource() == vista.btnInventario) {
			vista.panelInicio.setVisible(false);
			vista.panelInventario.setVisible(true);

			// Llenar el JList del panelRefrescos al mostrarlo
			listarRefrescos();
			listarCervezas();

		} // PANEL INVENTARIO
		if (e.getSource() == vista.btnMusica) {
			vista.panelInicio.setVisible(false);
			vista.panelMusica.setVisible(true);
		} // PANEL MUSICA

		if (e.getSource() == vista.btnAceptarCambios) {
			actualizarCantidadSeleccionada("Refresco");
			actualizarCantidadSeleccionada("Cerveza");
		} // ACTUALIZAR CAMBIOS

		if (e.getSource() == vista.btnRevertirCambios) {
			eliminarCambios();
		} // ELIMINAR CAMBIOS

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

	}// FIN actionPerformed

	private void listarRefrescos() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		HashMap<String, InfoRefresco> listaRefrescos = refresco.getRefrescos();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listRefrescos.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoRefresco> entry : listaRefrescos.entrySet()) {
			InfoRefresco info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Agregamos un ListSelectionListener al JList
		vista.listRefrescos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					// Verificar si hay algun elemento seleccionado
					if (vista.listRefrescos.getSelectedIndex() != -1) {
						// Mostramos el spinnerCantidadRefrescos si hay un elemento seleccionado
						vista.spinnerCantidadRefrescos.setVisible(true);
					} else {
						// Ocultamos el spinnerCantidadRefrescos si no hay un elemento seleccionado
						vista.spinnerCantidadRefrescos.setVisible(false);
					}
				}
			}
		});

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadRefrescos, "#");
		vista.spinnerCantidadRefrescos.setEditor(editor);
	}// FIN llenarJListRefrescos

	private void listarCervezas() {
// Obtenemos el HashMap de cervezas y las cantidades desde la instancia de la clase
		HashMap<String, InfoCerveza> listaCervezas = cerveza.getCervezas();

		// Limpiamos el modelo del JList antes de agregar los nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listCerveza.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoCerveza> entry : listaCervezas.entrySet()) {
			InfoCerveza info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Agregamos un ListSelectionListener al JList
		vista.listCerveza.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					// Verificamo si hay algun elemento seleccionado
					if (vista.listCerveza.getSelectedIndex() != -1) {
						// Mostramos el spinnerCantidadCerveza si hay un elemento seleccionado
						vista.spinnerCantidadCerveza.setVisible(true);
					} else {
						// Ocultamos el spinnerCantidadCerveza si no hay un elemento seleccionado
						vista.spinnerCantidadCerveza.setVisible(false);
					}
				}
			}
		});

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadCerveza, "#");
		vista.spinnerCantidadCerveza.setEditor(editor);
	}// FIN listarCervezas

	private void actualizarCantidadSeleccionada(String tipoProducto) {
		DefaultListModel<String> model;
		JSpinner spinnerCantidad;

		if ("Refresco".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listRefrescos.getModel();
			spinnerCantidad = vista.spinnerCantidadRefrescos;
		} else if ("Cerveza".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listCerveza.getModel();
			spinnerCantidad = vista.spinnerCantidadCerveza;
		} else {
			// Aqui anadire el resto
			return;
		}

		// Obtenemos el elemento seleccionado del JList
		int selectedIndex = vista.listCerveza.getSelectedIndex();
		if ("Refresco".equals(tipoProducto)) {
			selectedIndex = vista.listRefrescos.getSelectedIndex();
		}

		// Verificamos si hay un elemento seleccionado
		if (selectedIndex != -1) {
			// Obtenemos la cantidad actual del elemento
			String elementoSeleccionado = model.getElementAt(selectedIndex);
			int cantidadActual = Integer
					.parseInt(elementoSeleccionado.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);

			// Obtenemos el valor del spinnerCantidad
			int valorSpinner = (int) spinnerCantidad.getValue();

			// Calculamos la nueva cantidad sumando el valor del spinner
			int nuevaCantidad = cantidadActual + valorSpinner;

			// Obtenemos el nombre del producto
			String nombreProducto = elementoSeleccionado.split(" - Cantidad: ")[0];

			// Actualizamos la cantidad en la instancia correspondiente de cada
			// clase,Refresco,Cerveza....
			if ("Refresco".equals(tipoProducto)) {
				refresco.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Cerveza".equals(tipoProducto)) {
				cerveza.actualizarCantidad(nombreProducto, nuevaCantidad);
			}

			// Actualizamos el modelo del JList
			if ("Refresco".equals(tipoProducto)) {
				listarRefrescos();
			} else if ("Cerveza".equals(tipoProducto)) {
				listarCervezas();
			}
		}
	}
// FIN actualizarCantidadSeleccionada

	public void eliminarCambios() {
		// Restauramos las cantidades originales de los refrescos
		refresco.restaurarCantidadesOriginales();

		// Restauramos las cantidades originales de las cervezas
		cerveza.restaurarCantidadesOriginales();

		// Actualizamos el modelo de JList para refrescos y cervezas
		listarRefrescos();
		listarCervezas();

	}// FIN eliminarCambios
}// FIN CLASS
