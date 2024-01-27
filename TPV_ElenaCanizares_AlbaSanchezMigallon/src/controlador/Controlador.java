package controlador;

import vista.Vista;

import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vista.Vista;
import modelo.Aperitivo;
import modelo.Aperitivo.InfoAperitivo;
import modelo.Barra;
import modelo.Botella;
import modelo.Botella.InfoBotella;
import modelo.Cerveza;
import modelo.Cerveza.InfoCerveza;
import modelo.Coctel;
import modelo.Coctel.InfoCoctel;
import modelo.Ingrediente;
import modelo.Ingrediente.InfoIngrediente;
import modelo.Inventario;
import modelo.Mesa;
import modelo.Musica;
import modelo.Pedido;
import modelo.Refresco;
import modelo.Refresco.InfoRefresco;
import modelo.Vino;
import modelo.Vino.InfoVino;
import modelo.GestorDePedidos;
import persistencias.Resta;
import persistencias.Suma;

public class Controlador implements ActionListener, ListSelectionListener {
	Vista vista = new Vista();
	Barra barra = new Barra();
	Botella botella = new Botella();
	Cerveza cerveza = new Cerveza();
	Coctel coctel = new Coctel();
	Ingrediente ingrediente = new Ingrediente();
	Aperitivo aperitivo = new Aperitivo();
	Mesa mesa = new Mesa();
	Musica musica = new Musica();
	Pedido pedido = new Pedido();
	GestorDePedidos gestorDePedidos = new GestorDePedidos();
	Refresco refresco = new Refresco();
	Vino vino = new Vino();
	Inventario inventario;
	private String mesaSeleccionada = "";
	private JList ultimaSeleccionLista;

	public Controlador(Vista vista) {
		this.vista = vista;
		this.barra = barra;
		this.aperitivo = aperitivo;
		this.botella = botella;
		this.cerveza = cerveza;
		this.coctel = coctel;
		this.ingrediente = ingrediente;
		this.inventario = new Inventario(this.refresco, cerveza, aperitivo, botella, coctel, ingrediente, vino, null);
		this.mesa = mesa;
		this.musica = musica;
		this.pedido = pedido;
		this.refresco = refresco;
		this.vino = vino;
		this.gestorDePedidos = gestorDePedidos;

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
		this.vista.btnRefrescos.addActionListener(this);
		this.vista.btnAnadirAlPedido.addActionListener(this);
		this.vista.btnVolverInicio.addActionListener(this);
		this.vista.btnCervezas.addActionListener(this);
		this.vista.btnVino.addActionListener(this);
		this.vista.btnAperitivos.addActionListener(this);
		this.vista.btnBotellas.addActionListener(this);
		this.vista.btnCocktels.addActionListener(this);

		this.vista.listRefrescos.addListSelectionListener(this);
		this.vista.listCerveza.addListSelectionListener(this);
		this.vista.listAperitivos.addListSelectionListener(this);
		this.vista.listBotellas.addListSelectionListener(this);
		this.vista.listCocktels.addListSelectionListener(this);
		this.vista.listIngredientes.addListSelectionListener(this);
		this.vista.listVinos.addListSelectionListener(this);

		this.vista.listRefrescospanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listCervezaspanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listAperitivospanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listBotellaspanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listCocktelspanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listVinopanelPedidoNuevo.addListSelectionListener(this);

		this.vista.listPedidoMesa.addListSelectionListener(this);

	}// FIN CONSTRUCTOR

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnCaja) {
			vista.panelInicio.setVisible(false);
			vista.panelCaja.setVisible(true);
		} // PANEL CAJA
		if (e.getSource() == vista.btnPedido) {
			mostrarTodosLosPedidosPorMesa();
			System.out.println("Modelo del JList después de actualizar: " + vista.listPedido.getModel());
			vista.panelInicio.setVisible(false);
			vista.panelPedido.setVisible(true);

			// Llama al nuevo método para mostrar todos los pedidos por mesa

		} // PANEL PEDIDO

		if (e.getSource() == vista.btnInventario) {
			vista.panelInicio.setVisible(false);
			vista.panelInventario.setVisible(true);

			// Llenar el JList del panelRefrescos al mostrarlo
			listarRefrescos();
			listarCervezas();
			listarAperitivos();
			listarBotellas();
			listarCocktels();
			listarIngredientes();
			listarVinos();

		} // PANEL INVENTARIO
		if (e.getSource() == vista.btnMusica) {
			vista.panelInicio.setVisible(false);
			vista.panelMusica.setVisible(true);
		} // PANEL MUSICA

		if (e.getSource() == vista.btnAceptarCambios) {
			actualizarCantidadSeleccionada("Refresco");
			actualizarCantidadSeleccionada("Cerveza");
			actualizarCantidadSeleccionada("Aperitivo");
			actualizarCantidadSeleccionada("Botella");
			actualizarCantidadSeleccionada("Cocktel");
			actualizarCantidadSeleccionada("Ingrediente");
			actualizarCantidadSeleccionada("Vino");
		} // ACTUALIZAR CAMBIOS

		if (e.getSource() == vista.btnRevertirCambios) {
			eliminarCambios();
		} // ELIMINAR CAMBIOS

		if (e.getSource() == vista.btnMesa1) {
			ClicMesa(1);
		} else if (e.getSource() == vista.btnMesa2) {
			ClicMesa(2);
		} else if (e.getSource() == vista.btnMesa3) {
			ClicMesa(3);
		} else if (e.getSource() == vista.btnMesa4) {
			ClicMesa(4);
		} else if (e.getSource() == vista.btnMesa5) {
			ClicMesa(5);
		} else if (e.getSource() == vista.btnMesa6) {
			ClicMesa(6);
		} else if (e.getSource() == vista.btnMesa7) {
			ClicMesa(7);
		} // FIN BOTONES MESA

		// Agregamos el listener al botón de refrescos
		if (e.getSource() == vista.btnRefrescos) {
			ocultarOtrasListas();
			vista.listRefrescospanelPedidoNuevo.setVisible(true);
			vista.scrollPaneRefrescospanelPedidoNuevo.setVisible(true);

			listarRefrescosPanelPedidoNuevo();

		} // FIN BTNREFRESCOS
		if (e.getSource() == vista.btnCervezas) {
			ocultarOtrasListas();
			vista.listCervezaspanelPedidoNuevo.setVisible(true);
			vista.scrollPanelCervezaspanelPedidoNuevo.setVisible(true);

			listarCervezasPanelPedidoNuevo();

		} // FIN BTNCERVEZAS

		if (e.getSource() == vista.btnAperitivos) {
			ocultarOtrasListas();
			vista.listAperitivospanelPedidoNuevo.setVisible(true);
			vista.scrollPaneAperitivospanelPedidoNuevo.setVisible(true);

			listarAperitivosPanelPedidoNuevo();

		} // FIN BTNAPERITIVOS
		if (e.getSource() == vista.btnBotellas) {
			ocultarOtrasListas();
			vista.listBotellaspanelPedidoNuevo.setVisible(true);
			vista.scrollPaneBotellaspanelPedidoNuevo.setVisible(true);

			listarBotellasPanelPedidoNuevo();

		} // FIN BTNBOTELLAS

		if (e.getSource() == vista.btnCocktels) {
			ocultarOtrasListas();
			vista.listCocktelspanelPedidoNuevo.setVisible(true);
			vista.scrollPaneCocktelspanelPedidoNuevo.setVisible(true);

			listarCocktelsPanelPedidoNuevo();

		} // FIN BTNCOCKTELS
		if (e.getSource() == vista.btnVino) {
			ocultarOtrasListas();
			vista.listVinopanelPedidoNuevo.setVisible(true);
			vista.scrollPaneVinopanelPedidoNuevo.setVisible(true);

			listarVinosPanelPedidoNuevo();

		} // FIN BTNVINOS
		if (e.getSource() == vista.btnAnadirAlPedido) {
			agregarElementoRefrescoAlPedido();
			agregarElementoCervezaAlPedido();
			agregarElementoAperitivoAlPedido();
			agregarElementoBotellaAlPedido();
			agregarElementoCocktelAlPedido();
			agregarElementoVinoAlPedido();
			mostrarPedido();

		} // FIN BTN ANADIR AL PEDIDO
		if (e.getSource() == vista.btnVolverInicio) {
			// Limpia todos los componentes en vista.panelInicio

			// Configura y agrega los nuevos componentes que deseas en vista.panelInicio
			// ...

			// Actualiza la interfaz gráfica
			vista.panelInicio.revalidate();
			vista.panelInicio.repaint();

			// Muestra el panel de inicio
			vista.panelInicio.setVisible(true);

			// Oculta el panel de pedido
			vista.panelPedido.setVisible(false);
			// Oculta el panel de pedido
			vista.panelInventario.setVisible(false);
			// Oculta el panel de pedido
			vista.panelCaja.setVisible(false);
			// Oculta el panel de pedido
			vista.panelMusica.setVisible(false);
		}
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

	// Metodo para indicar el clic en un botón/mesa
	private void ClicMesa(int numeroMesa) {
		// Obtenemos el pedido asociado a la mesa seleccionada
		Pedido pedidoMesa = mesa.getPedido();

		// Verificamos si la mesa está ocupada
		if (pedidoMesa != null && pedidoMesa.esOcupada()) {
			System.out.println("Mesa ocupada. Mostrando pedido...");
			vista.panelInicio.setVisible(false);
			vista.panelPedido.setVisible(true);

			// Actualizamos la variable mesaSeleccionada para que coincida con la mesa
			// actual
			mesaSeleccionada = "Mesa " + numeroMesa;

			// Mostramos el pedido de la mesa actual
			mostrarPedido();
		} else {
			System.out.println("Mesa no ocupada. Redirigiendo a nuevo pedido...");
			vista.panelInicio.setVisible(false);
			vista.panelPedidoNuevo.setVisible(true);

			// Actualizamos la variable mesaSeleccionada para que coincida con la mesa
			// actual
			mesaSeleccionada = "Mesa " + numeroMesa;
		}
	}// FIN METODO CLICK MESA

	// Método para ocultar las otras listas
	private void ocultarOtrasListas() {
		vista.listRefrescospanelPedidoNuevo.setVisible(false);
		vista.scrollPaneRefrescospanelPedidoNuevo.setVisible(false);

		vista.listCervezaspanelPedidoNuevo.setVisible(false);
		vista.scrollPanelCervezaspanelPedidoNuevo.setVisible(false);

		vista.listAperitivospanelPedidoNuevo.setVisible(false);
		vista.scrollPaneAperitivospanelPedidoNuevo.setVisible(false);

		vista.listBotellaspanelPedidoNuevo.setVisible(false);
		vista.scrollPaneBotellaspanelPedidoNuevo.setVisible(false);

		vista.listCocktelspanelPedidoNuevo.setVisible(false);
		vista.scrollPaneCocktelspanelPedidoNuevo.setVisible(false);

		vista.listVinopanelPedidoNuevo.setVisible(false);
		vista.scrollPaneVinopanelPedidoNuevo.setVisible(false);

	}// FIN OCULTAR OTRAS LISTAS

	// Método para mostrar todos los pedidos en panelPedido
	private void mostrarTodosLosPedidosPorMesa() {
		// Obtemos la información de todos los pedidos de las mesas
		List<Mesa> mesas = gestorDePedidos.getMesas();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> modelPedido = new DefaultListModel<>();
		vista.listPedido.setModel(modelPedido);

		// Recorremos todas las mesas y agregamos sus pedidos al modelo del JList
		for (Mesa mesa : mesas) {
			Pedido pedidoMesa = mesa.getPedido();
			if (pedidoMesa != null && pedidoMesa.esOcupada()) {
				for (Map.Entry<String, Integer> entry : pedidoMesa.getBebidasPedido().entrySet()) {
					String bebida = entry.getKey();
					int cantidad = entry.getValue();
					modelPedido
							.addElement("Mesa " + mesa.getNumeroMesa() + " - " + bebida + " - Cantidad: " + cantidad);
				}
			}
		}
	}// FIN MOSTRAR TODOS LOS PEDIDOS POR MESA
	/*--------------------------------Metodos de agregar en paneles nuevos por clase-------------------------------------------*/

	// Método para agregar el elemento seleccionado de refresco al pedido
	private void agregarElementoRefrescoAlPedido() {
		// Obtenemos el elemento seleccionado del JList de refrescos
		Object elementoSeleccionadoObject = vista.listRefrescospanelPedidoNuevo.getSelectedValue();

		// Verificamos si hay un elemento seleccionado y lo castreamos a String
		if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;

			// Obtener el nombre del refresco y el precio desde la cadena seleccionada
			String nombreRefresco = elementoSeleccionado.split(" - Precio: ")[0];
			int precioRefresco = Integer.parseInt(elementoSeleccionado.split(" - Precio: ")[1]);

			// Asumiendo que el pedido es un HashMap<String, InfoRefresco>
			Pedido pedidoMesa = mesa.getPedido();

			// Verificar si el refresco ya está en el pedido
			if (pedidoMesa != null && pedidoMesa.getBebidasPedido().containsKey(nombreRefresco)) {
				// Si está en el pedido, actualizar la cantidad y el precio
				int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreRefresco);
				pedidoMesa.agregarBebida(nombreRefresco, cantidadActual + 1);

				// Actualizar el modelo del JList de pedidoMesa
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				// Buscar el índice de la línea que contiene el refresco y actualizarla
				for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
					String lineaPedido = modelPedidoMesa.getElementAt(i);
					if (lineaPedido.startsWith(nombreRefresco)) {
						// Extraer cantidad y precio de la línea actual
						int cantidadExistente = Integer
								.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
						int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

						// Calcular la nueva cantidad y precio
						int nuevaCantidad = cantidadExistente + 1;
						int nuevoPrecio = precioExistente + precioRefresco;

						// Actualizar la línea en el modelo del JList
						modelPedidoMesa.set(i,
								nombreRefresco + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
						break;
					}
				}
			} else {
				// Si no está en el pedido, agregarlo con cantidad 1
				pedidoMesa.agregarBebida(nombreRefresco, 1);

				// Actualizar el modelo del JList de pedidoMesa con una nueva línea
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				modelPedidoMesa.addElement(nombreRefresco + " - Cantidad: 1 - Precio: " + precioRefresco);
			}

		}
	}// FIN AGREGAR ELEMENTO REFRESCO AL PEDIDO

	// Método para agregar el elemento seleccionado de cerveza al pedido
	private void agregarElementoCervezaAlPedido() {
		// Obtenemos el elemento seleccionado del JList de cervezas
		Object elementoSeleccionadoObject = vista.listCervezaspanelPedidoNuevo.getSelectedValue();

		// Verificamos si hay un elemento seleccionado y lo castreamos a String
		if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;

			// Obtener el nombre de la cerveza y la información desde la cadena seleccionada
			String nombreCerveza = elementoSeleccionado.split(" - Precio: ")[0];
			// Asumiendo que el precio está en el formato correcto y puede ser parseado
			// directamente
			int precioCerveza = Integer.parseInt(elementoSeleccionado.split(" - Precio: ")[1]);

			// Utilizamos el HashMap de cervezas para obtener la información
			Cerveza.InfoCerveza infoCerveza = cerveza.getCervezas().get(nombreCerveza);

			if (infoCerveza != null) {
				// Obtenemos la cantidad de la cerveza
				int cantidadCerveza = infoCerveza.getCantidad();

				// Asumiendo que el pedido es un HashMap<String, Integer>
				Pedido pedidoMesa = mesa.getPedido();
				if (pedidoMesa != null) {
					// Verificar si la cerveza ya está en el pedido
					if (pedidoMesa.getBebidasPedido().containsKey(nombreCerveza)) {
						// Si está en el pedido, actualizar la cantidad y el precio
						int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreCerveza);
						pedidoMesa.agregarBebida(nombreCerveza, cantidadActual + 1);

						// Actualizar el modelo del JList de pedidoMesa
						DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa
								.getModel();
						// Buscar el índice de la línea que contiene la cerveza y actualizarla
						for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
							String lineaPedido = modelPedidoMesa.getElementAt(i);
							if (lineaPedido.startsWith(nombreCerveza)) {
								// Extraer cantidad y precio de la línea actual
								int cantidadExistente = Integer
										.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
								int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

								// Calcular la nueva cantidad y precio
								int nuevaCantidad = cantidadExistente + 1;
								int nuevoPrecio = precioExistente + precioCerveza;

								// Actualizar la línea en el modelo del JList
								modelPedidoMesa.set(i,
										nombreCerveza + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
								break;
							}
						}
					} else {
						// Si no está en el pedido, agregarlo con cantidad 1
						pedidoMesa.agregarBebida(nombreCerveza, 1);

						// Actualizar el modelo del JList de pedidoMesa con una nueva línea
						DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa
								.getModel();
						modelPedidoMesa.addElement(nombreCerveza + " - Cantidad: 1 - Precio: " + precioCerveza);
					}
				}
			}
		}
	}// FIN AGREGAR ELEMENTO CERVEZA AL PEDIDO

	// Método para agregar el elemento seleccionado de aperitivo al pedido
	private void agregarElementoAperitivoAlPedido() {
		// Obtenemos el elemento seleccionado del JList de aperitivos
		Object elementoSeleccionadoObject = vista.listAperitivospanelPedidoNuevo.getSelectedValue();

		// Verificamos si hay un elemento seleccionado y lo castreamos a String
		if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;

			// Obtener el nombre del aperitivo y el precio desde la cadena seleccionada
			String nombreAperitivo = elementoSeleccionado.split(" - Precio: ")[0];
			int precioAperitivo = Integer.parseInt(elementoSeleccionado.split(" - Precio: ")[1]);

			// Asumiendo que el pedido es un HashMap<String, InfoAperitivo>
			Pedido pedidoMesa = mesa.getPedido();

			// Verificar si el aperitivo ya está en el pedido
			if (pedidoMesa != null && pedidoMesa.getBebidasPedido().containsKey(nombreAperitivo)) {
				// Si está en el pedido, actualizar la cantidad y el precio
				int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreAperitivo);
				pedidoMesa.agregarBebida(nombreAperitivo, cantidadActual);

				// Actualizar el modelo del JList de pedidoMesa
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				// Buscar el índice de la línea que contiene el aperitivo y actualizarla
				for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
					String lineaPedido = modelPedidoMesa.getElementAt(i);
					if (lineaPedido.startsWith(nombreAperitivo)) {
						// Extraer cantidad y precio de la línea actual
						int cantidadExistente = Integer
								.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
						int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

						// Calcular la nueva cantidad y precio
						int nuevaCantidad = cantidadExistente + 1;
						int nuevoPrecio = precioExistente + precioAperitivo;

						// Actualizar la línea en el modelo del JList
						modelPedidoMesa.set(i,
								nombreAperitivo + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
						break;
					}
				}
			} else {
				// Si no está en el pedido, agregarlo con cantidad 1
				pedidoMesa.agregarBebida(nombreAperitivo, 1);

				// Actualizar el modelo del JList de pedidoMesa con una nueva línea
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				modelPedidoMesa.addElement(nombreAperitivo + " - Cantidad: 1 - Precio: " + precioAperitivo);
			}

		}
	}// FIN AGREGAR ELEMENTO APERITIVO AL PEDIDO

	// Método para agregar el elemento seleccionado de botella al pedido
	private void agregarElementoBotellaAlPedido() {
		// Obtenemos el elemento seleccionado del JList de refrescos
		Object elementoSeleccionadoObject = vista.listBotellaspanelPedidoNuevo.getSelectedValue();

		// Verificamos si hay un elemento seleccionado y lo castreamos a String
		if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;

			// Obtener el nombre del refresco y el precio desde la cadena seleccionada
			String nombreBotella = elementoSeleccionado.split(" - Precio: ")[0];
			int precioBotella = Integer.parseInt(elementoSeleccionado.split(" - Precio: ")[1]);

			// Asumiendo que el pedido es un HashMap<String, InfoRefresco>
			Pedido pedidoMesa = mesa.getPedido();

			// Verificar si el refresco ya está en el pedido
			if (pedidoMesa != null && pedidoMesa.getBebidasPedido().containsKey(nombreBotella)) {
				// Si está en el pedido, actualizar la cantidad y el precio
				int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreBotella);
				pedidoMesa.agregarBebida(nombreBotella, cantidadActual + 1);

				// Actualizar el modelo del JList de pedidoMesa
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				// Buscar el índice de la línea que contiene el refresco y actualizarla
				for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
					String lineaPedido = modelPedidoMesa.getElementAt(i);
					if (lineaPedido.startsWith(nombreBotella)) {
						// Extraer cantidad y precio de la línea actual
						int cantidadExistente = Integer
								.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
						int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

						// Calcular la nueva cantidad y precio
						int nuevaCantidad = cantidadExistente + 1;
						int nuevoPrecio = precioExistente + precioBotella;

						// Actualizar la línea en el modelo del JList
						modelPedidoMesa.set(i,
								nombreBotella + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
						break;
					}
				}
			} else {
				// Si no está en el pedido, agregarlo con cantidad 1
				pedidoMesa.agregarBebida(nombreBotella, 1);

				// Actualizar el modelo del JList de pedidoMesa con una nueva línea
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				modelPedidoMesa.addElement(nombreBotella + " - Cantidad: 1 - Precio: " + precioBotella);
			}

		}
	}// FIN AGREGAR ELEMENTO BOTELLA AL PEDIDO

	// Método para agregar el elemento seleccionado de cocktels al pedido
	private void agregarElementoCocktelAlPedido() {
		// Obtenemos el elemento seleccionado del JList de refrescos
		Object elementoSeleccionadoObject = vista.listCocktelspanelPedidoNuevo.getSelectedValue();

		// Verificamos si hay un elemento seleccionado y lo castreamos a String
		if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;

			// Obtener el nombre del refresco y el precio desde la cadena seleccionada
			String nombreCocktel = elementoSeleccionado.split(" - Precio: ")[0];
			int precioCocktel = Integer.parseInt(elementoSeleccionado.split(" - Precio: ")[1]);

			// Asumiendo que el pedido es un HashMap<String, InfoRefresco>
			Pedido pedidoMesa = mesa.getPedido();

			// Verificar si el refresco ya está en el pedido
			if (pedidoMesa != null && pedidoMesa.getBebidasPedido().containsKey(nombreCocktel)) {
				// Si está en el pedido, actualizar la cantidad y el precio
				int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreCocktel);
				pedidoMesa.agregarBebida(nombreCocktel, cantidadActual + 1);

				// Actualizar el modelo del JList de pedidoMesa
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				// Buscar el índice de la línea que contiene el refresco y actualizarla
				for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
					String lineaPedido = modelPedidoMesa.getElementAt(i);
					if (lineaPedido.startsWith(nombreCocktel)) {
						// Extraer cantidad y precio de la línea actual
						int cantidadExistente = Integer
								.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
						int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

						// Calcular la nueva cantidad y precio
						int nuevaCantidad = cantidadExistente + 1;
						int nuevoPrecio = precioExistente + precioCocktel;

						// Actualizar la línea en el modelo del JList
						modelPedidoMesa.set(i,
								nombreCocktel + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
						break;
					}
				}
			} else {
				// Si no está en el pedido, agregarlo con cantidad 1
				pedidoMesa.agregarBebida(nombreCocktel, 1);

				// Actualizar el modelo del JList de pedidoMesa con una nueva línea
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				modelPedidoMesa.addElement(nombreCocktel + " - Cantidad: 1 - Precio: " + precioCocktel);
			}

		}
	}// FIN AGREGAR ELEMENTO COCKTEL AL PEDIDO

	// Método para agregar el elemento seleccionado de vino al pedido
	private void agregarElementoVinoAlPedido() {
		// Obtenemos el elemento seleccionado del JList de refrescos
		Object elementoSeleccionadoObject = vista.listVinopanelPedidoNuevo.getSelectedValue();

		// Verificamos si hay un elemento seleccionado y lo castreamos a String
		if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;

			// Obtener el nombre del refresco y el precio desde la cadena seleccionada
			String nombreVino = elementoSeleccionado.split(" - Precio: ")[0];
			int precioVino = Integer.parseInt(elementoSeleccionado.split(" - Precio: ")[1]);

			// Asumiendo que el pedido es un HashMap<String, InfoRefresco>
			Pedido pedidoMesa = mesa.getPedido();

			// Verificar si el refresco ya está en el pedido
			if (pedidoMesa != null && pedidoMesa.getBebidasPedido().containsKey(nombreVino)) {
				// Si está en el pedido, actualizar la cantidad y el precio
				int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreVino);
				pedidoMesa.agregarBebida(nombreVino, cantidadActual + 1);

				// Actualizar el modelo del JList de pedidoMesa
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				// Buscar el índice de la línea que contiene el refresco y actualizarla
				for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
					String lineaPedido = modelPedidoMesa.getElementAt(i);
					if (lineaPedido.startsWith(nombreVino)) {
						// Extraer cantidad y precio de la línea actual
						int cantidadExistente = Integer
								.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
						int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

						// Calcular la nueva cantidad y precio
						int nuevaCantidad = cantidadExistente + 1;
						int nuevoPrecio = precioExistente + precioVino;

						// Actualizar la línea en el modelo del JList
						modelPedidoMesa.set(i,
								nombreVino + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
						break;
					}
				}
			} else {
				// Si no está en el pedido, agregarlo con cantidad 1
				pedidoMesa.agregarBebida(nombreVino, 1);

				// Actualizar el modelo del JList de pedidoMesa con una nueva línea
				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				modelPedidoMesa.addElement(nombreVino + " - Cantidad: 1 - Precio: " + precioVino);
			}

		}
	}// FIN AGREGAR ELEMENTO VINO AL PEDIDO
	/*--------------------------------Fin metodos de agregar en paneles nuevos por clase-------------------------------------------*/

	/*--------------------------------Metodos de listar en paneles nuevos por clase-------------------------------------------*/

	private void listarCervezasPanelPedidoNuevo() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		// Refresco
		HashMap<String, InfoCerveza> listaCervezas = cerveza.getCervezas();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listCervezaspanelPedidoNuevo.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoCerveza> entry : listaCervezas.entrySet()) {
			InfoCerveza info = entry.getValue();
			model.addElement(info.getNombre() + " - Precio: " + info.getPrecio());
		}
	}// FIN LISTAR CERVEZAS PANEL PEDIDO NUEVO

	private void listarRefrescosPanelPedidoNuevo() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		// Refresco
		HashMap<String, InfoRefresco> listaRefrescos = refresco.getRefrescos();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listRefrescospanelPedidoNuevo.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoRefresco> entry : listaRefrescos.entrySet()) {
			InfoRefresco info = entry.getValue();
			model.addElement(info.getNombre() + " - Precio: " + info.getPrecio());
		}
	}// FIN LISTAR REFRESCOS PANEL PEDIDO NUEVO

	private void listarAperitivosPanelPedidoNuevo() {
		// Obtenemos el HashMap de aperitivos y cantidades desde la instancia de la
		// clase Aperitivo
		HashMap<String, InfoAperitivo> listaAperitivos = aperitivo.getAperitivos();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listAperitivospanelPedidoNuevo.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoAperitivo> entry : listaAperitivos.entrySet()) {
			InfoAperitivo info = entry.getValue();
			model.addElement(info.getNombre() + " - Precio: " + info.getPrecio());
		}
	}// FIN LISTAR APERITIVOS PEDIDO NUEVO

	private void listarBotellasPanelPedidoNuevo() {
		// Obtenemos el HashMap de aperitivos y cantidades desde la instancia de la
		// clase Aperitivo
		HashMap<String, InfoBotella> listaBotellas = botella.getBotellas();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listBotellaspanelPedidoNuevo.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoBotella> entry : listaBotellas.entrySet()) {
			InfoBotella info = entry.getValue();
			model.addElement(info.getNombre() + " - Precio: " + info.getPrecio());
		}
	}// FIN LISTAR BOTELLAS PEDIDO NUEVO

	private void listarCocktelsPanelPedidoNuevo() {
		// Obtenemos el HashMap de aperitivos y cantidades desde la instancia de la
		// clase Aperitivo
		HashMap<String, InfoCoctel> listaCoctels = coctel.getCocteles();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listCocktelspanelPedidoNuevo.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoCoctel> entry : listaCoctels.entrySet()) {
			InfoCoctel info = entry.getValue();
			model.addElement(info.getNombre() + " - Precio: " + info.getPrecio());
		}
	}// FIN LISTAR COCKTELS PEDIDO NUEVO

	private void listarVinosPanelPedidoNuevo() {
		// Obtenemos el HashMap de aperitivos y cantidades desde la instancia de la
		// clase Aperitivo
		HashMap<String, InfoVino> listaVinos = vino.getVinos();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listVinopanelPedidoNuevo.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoVino> entry : listaVinos.entrySet()) {
			InfoVino info = entry.getValue();
			model.addElement(info.getNombre() + " - Precio: " + info.getPrecio());
		}
	}// FIN LISTAR VINOS PEDIDO NUEVO
	/*--------------------------------Fin metodos de listar en paneles nuevos por clase-------------------------------------------*/

	// Metodo que muestra el pedido de la mesa en panelPedidoNuevo
	private void mostrarPedido() {
		// Obtenemos la información del pedido asociado a la mesa seleccionada
		Pedido pedidoMesa = mesa.getPedido();

		// Verificamos si la mesa está ocupada
		boolean mesaOcupada = pedidoMesa != null && pedidoMesa.esOcupada();

		if (mesaOcupada) {
			// La mesa está ocupada, mostramos el panel de pedido con la información
			vista.panelInicio.setVisible(false);
			vista.panelPedido.setVisible(true);

			// Limpiamos el modelo del JList antes de agregar nuevos elementos
			DefaultListModel<String> modelPedido = new DefaultListModel<>();
			vista.listPedido.setModel(modelPedido);

			// Asumiendo que el pedido es un HashMap<String, Integer>
			HashMap<String, Integer> bebidasPedido = pedidoMesa.getBebidasPedido();

			// Llenamos el modelo del JListPedido con los elementos del pedido
			for (HashMap.Entry<String, Integer> entry : bebidasPedido.entrySet()) {
				String bebida = entry.getKey();
				int cantidad = entry.getValue();
				modelPedido.addElement(bebida + " - Cantidad: " + cantidad);
			}

			// Actualizamos el modelo del JListPedidoMesa
			DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
			modelPedidoMesa.clear();

			for (HashMap.Entry<String, Integer> entry : bebidasPedido.entrySet()) {
				String bebida = entry.getKey();
				int cantidad = entry.getValue();
				modelPedidoMesa.addElement(bebida + " - Cantidad: " + cantidad);
			}
		} else {
			// La mesa no está ocupada, mostramos el panelNuevoPedido
			vista.panelInicio.setVisible(false);
			vista.panelPedidoNuevo.setVisible(true);
		}
	}// FIN MOSTRAR PEDIDO
	/*--------------------------------Metodos de listar en inventario por clase-------------------------------------------*/

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

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadRefrescos, "#");
		vista.spinnerCantidadRefrescos.setEditor(editor);
	}// FIN LISTAR REFRESCOS

	private void listarAperitivos() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		HashMap<String, InfoAperitivo> listaAperitivos = aperitivo.getAperitivos();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listAperitivos.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoAperitivo> entry : listaAperitivos.entrySet()) {
			InfoAperitivo info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadAperitivos, "#");
		vista.spinnerCantidadAperitivos.setEditor(editor);
	}// FIN LISTAR APERITIVOS

	private void listarBotellas() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		HashMap<String, InfoBotella> listaBotellas = botella.getBotellas();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listBotellas.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoBotella> entry : listaBotellas.entrySet()) {
			InfoBotella info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadBotellas, "#");
		vista.spinnerCantidadBotellas.setEditor(editor);
	}// FIN LISTAR BOTELLAS

	private void listarCocktels() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		HashMap<String, InfoCoctel> listaCocktels = coctel.getCocteles();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listCocktels.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoCoctel> entry : listaCocktels.entrySet()) {
			InfoCoctel info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadCocktels, "#");
		vista.spinnerCantidadCocktels.setEditor(editor);
	}// FIN LISTAR COCKTELS

	private void listarIngredientes() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		HashMap<String, InfoIngrediente> listaIngredientes = ingrediente.getIngredientes();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listIngredientes.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoIngrediente> entry : listaIngredientes.entrySet()) {
			InfoIngrediente info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadIngredientes, "#");
		vista.spinnerCantidadIngredientes.setEditor(editor);
	}// FIN LISTAR INGREDIENTES

	private void listarVinos() {
		// Obtenemos el HashMap de refrescos y cantidades desde la instancia de la clase
		HashMap<String, InfoVino> listaVinos = vino.getVinos();

		// Limpiamos el modelo del JList antes de agregar nuevos elementos
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listVinos.setModel(model);

		// Llenamos el modelo del JList con los elementos del HashMap
		for (HashMap.Entry<String, InfoVino> entry : listaVinos.entrySet()) {
			InfoVino info = entry.getValue();
			model.addElement(
					info.getNombre() + " - Cantidad: " + info.getCantidad() + " - Precio: " + info.getPrecio());
		}

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadVinos, "#");
		vista.spinnerCantidadVinos.setEditor(editor);
	}// FIN LISTAR VINOS

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

		// Configuramos el spinnerCantidad para que solo nos permita modificar la
		// cantidad, no el precio
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadCerveza, "#");
		vista.spinnerCantidadCerveza.setEditor(editor);
	}// FIN LISTAR CERVEZAS
	/*--------------------------------Fin metodos de listar en inventario por clase-------------------------------------------*/
	// Metodo para actualizar la cantidad en inventario/btnAgregarCambios

	private void actualizarCantidadSeleccionada(String tipoProducto) {
		DefaultListModel<String> model;
		JSpinner spinnerCantidad;

		if ("Refresco".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listRefrescos.getModel();
			spinnerCantidad = vista.spinnerCantidadRefrescos;
		} else if ("Cerveza".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listCerveza.getModel();
			spinnerCantidad = vista.spinnerCantidadCerveza;
		} else if ("Aperitivo".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listAperitivos.getModel();
			spinnerCantidad = vista.spinnerCantidadAperitivos;
		} else if ("Botella".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listBotellas.getModel();
			spinnerCantidad = vista.spinnerCantidadBotellas;
		} else if ("Cocktel".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listCocktels.getModel();
			spinnerCantidad = vista.spinnerCantidadCocktels;
		} else if ("Ingrediente".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listIngredientes.getModel();
			spinnerCantidad = vista.spinnerCantidadIngredientes;
		} else if ("Vino".equals(tipoProducto)) {
			model = (DefaultListModel<String>) vista.listVinos.getModel();
			spinnerCantidad = vista.spinnerCantidadVinos;
		} else {
			return;
		}

		// Obtenemos el elemento seleccionado del JList
		int selectedIndex = vista.listCerveza.getSelectedIndex();
		if ("Refresco".equals(tipoProducto)) {
			selectedIndex = vista.listRefrescos.getSelectedIndex();
		} else if ("Cerveza".equals(tipoProducto)) {
			selectedIndex = vista.listCerveza.getSelectedIndex();
		} else if ("Aperitivo".equals(tipoProducto)) {
			selectedIndex = vista.listAperitivos.getSelectedIndex();
		} else if ("Botella".equals(tipoProducto)) {
			selectedIndex = vista.listBotellas.getSelectedIndex();
		} else if ("Cocktel".equals(tipoProducto)) {
			selectedIndex = vista.listCocktels.getSelectedIndex();
		} else if ("Ingrediente".equals(tipoProducto)) {
			selectedIndex = vista.listIngredientes.getSelectedIndex();
		} else if ("Vino".equals(tipoProducto)) {
			selectedIndex = vista.listVinos.getSelectedIndex();
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

			// Actualizamos la cantidad en la instancia correspondiente de cada clase
			// (Refresco, Cerveza, Aperitivo)
			if ("Refresco".equals(tipoProducto)) {
				refresco.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Cerveza".equals(tipoProducto)) {
				cerveza.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Aperitivo".equals(tipoProducto)) {
				aperitivo.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Botella".equals(tipoProducto)) {
				botella.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Cocktel".equals(tipoProducto)) {
				coctel.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Ingrediente".equals(tipoProducto)) {
				ingrediente.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			} else if ("Vino".equals(tipoProducto)) {
				vino.actualizarCantidad(nombreProducto, nuevaCantidad);
				inventario.actualizarCantidad(nombreProducto, nuevaCantidad);
			}
			// Actualizamos el modelo del JList
			if ("Refresco".equals(tipoProducto)) {
				listarRefrescos();
			} else if ("Cerveza".equals(tipoProducto)) {
				listarCervezas();
			} else if ("Aperitivo".equals(tipoProducto)) {
				listarAperitivos();
			} else if ("Botella".equals(tipoProducto)) {
				listarBotellas();
			} else if ("Cocktel".equals(tipoProducto)) {
				listarCocktels();
			} else if ("Ingrediente".equals(tipoProducto)) {
				listarIngredientes();
			} else if ("Vino".equals(tipoProducto)) {
				listarVinos();
			}
		}
	}// FIN actualizarCantidadSeleccionada
		
	// Metodo para eliminar cambios en inventario/btnEliminarCambios
	public void eliminarCambios() {

		// Restauramos las cantidades originales de los refrescos
		refresco.restaurarCantidadesOriginales();

		// Restauramos las cantidades originales de las cervezas
		cerveza.restaurarCantidadesOriginales();

		// Restauramos las cantidades originales de los aperitivos
		aperitivo.restaurarCantidadesOriginales();

		// Restauramos las cantidades originales de las botellas
		botella.restaurarCantidadesOriginales();
		// Restauramos las cantidades originales de los cocktels
		coctel.restaurarCantidadesOriginales();
		// Restauramos las cantidades originales de los ingredientes
		ingrediente.restaurarCantidadesOriginales();
		// Restauramos las cantidades originales de los vinos
		vino.restaurarCantidadesOriginales();
		// Actualizamos el modelo de JList para refrescos y cervezas
		listarRefrescos();
		listarCervezas();
		listarAperitivos();
		listarBotellas();
		listarCocktels();
		listarIngredientes();
		listarVinos();
	}// FIN eliminarCambios
		// Metodo que recoge los ListSelectionEvents
	/*-------------------------------- Metodos para manejar los ListSelectionEvents-------------------------------------------*/

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			Object source = e.getSource();

			int listIdentifier = 0;

			if (source == vista.listRefrescos) {
				listIdentifier = 1;
			} else if (source == vista.listCerveza) {
				listIdentifier = 2;
			} else if (source == vista.listAperitivos) {
				listIdentifier = 3;
			} else if (source == vista.listBotellas) {
				listIdentifier = 4;
			} else if (source == vista.listCocktels) {
				listIdentifier = 5;
			} else if (source == vista.listIngredientes) {
				listIdentifier = 6;
			} else if (source == vista.listVinos) {
				listIdentifier = 7;
			} else if (source == vista.listRefrescospanelPedidoNuevo) {
				listIdentifier = 8;
				updateUltimaSeleccionLista(vista.listRefrescospanelPedidoNuevo);
			} else if (source == vista.listCervezaspanelPedidoNuevo) {
				listIdentifier = 9;
				updateUltimaSeleccionLista(vista.listCervezaspanelPedidoNuevo);

			} else if (source == vista.listAperitivospanelPedidoNuevo) {
				listIdentifier = 10;
				updateUltimaSeleccionLista(vista.listAperitivospanelPedidoNuevo);

			} else if (source == vista.listBotellaspanelPedidoNuevo) {
				listIdentifier = 11;
				updateUltimaSeleccionLista(vista.listBotellaspanelPedidoNuevo);

			} else if (source == vista.listCocktelspanelPedidoNuevo) {
				listIdentifier = 12;
				updateUltimaSeleccionLista(vista.listCocktelspanelPedidoNuevo);

			} else if (source == vista.listVinopanelPedidoNuevo) {
				listIdentifier = 13;
				updateUltimaSeleccionLista(vista.listVinopanelPedidoNuevo);

			} else if (source == vista.listPedidoMesa) {
				listIdentifier = 14;
			}

			switch (listIdentifier) {
			case 1:
				handleListSelection(vista.listRefrescos, vista.spinnerCantidadRefrescos);
				break;
			case 2:
				handleListSelection(vista.listCerveza, vista.spinnerCantidadCerveza);
				break;
			case 3:
				handleListSelection(vista.listAperitivos, vista.spinnerCantidadAperitivos);
				break;
			case 4:
				handleListSelection(vista.listBotellas, vista.spinnerCantidadBotellas);
				break;
			case 5:
				handleListSelection(vista.listCocktels, vista.spinnerCantidadCocktels);
				break;
			case 6:
				handleListSelection(vista.listIngredientes, vista.spinnerCantidadIngredientes);
				break;
			case 7:
				handleListSelection(vista.listVinos, vista.spinnerCantidadVinos);
				break;
			case 8:
				handleListSelection(vista.listRefrescospanelPedidoNuevo, vista.spinnerCantidadRefrescos);
				break;
			case 9:
				handleListSelection(vista.listCervezaspanelPedidoNuevo, vista.spinnerCantidadCerveza);
				break;
			case 10:
				handleListSelection(vista.listAperitivospanelPedidoNuevo, vista.spinnerCantidadAperitivos);
				break;
			case 11:
				handleListSelection(vista.listBotellaspanelPedidoNuevo, vista.spinnerCantidadBotellas);
				break;
			case 12:
				handleListSelection(vista.listCocktelspanelPedidoNuevo, vista.spinnerCantidadCocktels);
				break;
			case 13:
				handleListSelection(vista.listVinopanelPedidoNuevo, vista.spinnerCantidadVinos);
				break;
			case 14:
				int numeroMesa = vista.listPedidoMesa.getSelectedIndex() + 1;
				actualizarListaPedidosMesa(numeroMesa);
				break;
			default:
				// Manejo de excepcion si hace falta
			}
		}
	}// FIN VALUECHANGED
		
	// Metodo para actualizar la seleccion de las listas para no superoner valores
	private void updateUltimaSeleccionLista(JList<?> currentList) {
		if (ultimaSeleccionLista != currentList) {
			if (ultimaSeleccionLista != null) {
				ultimaSeleccionLista.clearSelection();
			}
			ultimaSeleccionLista = currentList;
		}
	}// FIN UPDATE ULTIMA SELECCION

	private void handleListSelection(JList<String> list, JSpinner spinner) {
		// Verify if there is an item selected
		if (list.getSelectedIndex() != -1) {
			// Show the spinnerCantidad if an item is selected
			spinner.setVisible(true);
		} else {
			// Hide the spinnerCantidad if no item is selected
			spinner.setVisible(false);
		}
	}// FIN HANDLELISTSELECTION
	/*-------------------------------- Fin metodos para manejar los ListSelectionEvents-------------------------------------------*/
	//Metodo para actualizar la lista de pedidos de cada mesa
	private void actualizarListaPedidosMesa(int numeroMesa) {
		// Obtén la mesa correspondiente desde el gestor de pedidos
		Mesa mesa = gestorDePedidos.getMesas().get(numeroMesa - 1);

		// Obtén el modelo de lista del JList y limpia los elementos actuales
		DefaultListModel<String> modelPedidosMesa = new DefaultListModel<>();
		vista.listPedido.setModel(modelPedidosMesa);

		// Obtén el pedido de la mesa y agrégalo al modelo
		HashMap<String, Integer> pedidoMesa = mesa.getPedido().getBebidasPedido();
		for (Map.Entry<String, Integer> entry : pedidoMesa.entrySet()) {
			String bebida = entry.getKey();
			int cantidad = entry.getValue();
			modelPedidosMesa.addElement(bebida + " - Cantidad: " + cantidad);
		}
	}//FIN ACTUALIZAR LISTA DE PEDIDOS MESA
}// FIN CLASS
