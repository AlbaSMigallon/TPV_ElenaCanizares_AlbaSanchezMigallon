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

	Mesa mesa = new Mesa();
	Musica musica = new Musica();
	Pedido pedido = new Pedido();
	GestorDePedidos gestorDePedidos = new GestorDePedidos();
	Refresco refresco = new Refresco();
	Vino vino = new Vino();
	Inventario inventario;
	private String mesaSeleccionada = "";

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
		if (e.getSource() == vista.btnMesa1) {
			int numeroMesa = 1; // Cambia esto según la mesa que corresponda al botón

			// Obtener el pedido asociado a la mesa seleccionada
			Pedido pedidoMesa = mesa.getPedido();

			// Verificar si la mesa está ocupada
			if (pedidoMesa != null && pedidoMesa.esOcupada()) {
				System.out.println("Mesa ocupada. Mostrando pedido...");
				vista.panelInicio.setVisible(false);
				vista.panelPedido.setVisible(true);

				// Actualizar la variable mesaSeleccionada para que coincida con la mesa actual
				mesaSeleccionada = "Mesa " + numeroMesa;

				// Mostrar el pedido de la mesa actual
				mostrarPedido();
			} else {
				System.out.println("Mesa no ocupada. Redirigiendo a nuevo pedido...");
				vista.panelInicio.setVisible(false);
				vista.panelPedidoNuevo.setVisible(true);

				// Actualizar la variable mesaSeleccionada para que coincida con la mesa actual
				mesaSeleccionada = "Mesa " + numeroMesa;
			}
		} // FIN BTNMESA1

		// Agregamos el listener al botón de refrescos
		// Agregamos el listener al botón de refrescos
		if (e.getSource() == vista.btnRefrescos) {
			// Verificar si hay una mesa seleccionada antes de listar los refrescos
			if (!mesaSeleccionada.isEmpty()) {
				listarRefrescosPanelPedidoNuevo();
			} else {
				JOptionPane.showMessageDialog(vista, "Seleccione una mesa antes de añadir bebidas al pedido.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} // FIN BTNREFRESCOS
		if (e.getSource() == vista.btnCervezas) {
			// Verificar si hay una mesa seleccionada antes de listar los refrescos
			if (!mesaSeleccionada.isEmpty()) {
				listarCervezasPanelPedidoNuevo();
			} else {
				JOptionPane.showMessageDialog(vista, "Seleccione una mesa antes de añadir bebidas al pedido.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} // FIN BTNCERVEZAS

		if (e.getSource() == vista.btnAnadirAlPedido) {
			agregarElementoRefrescoAlPedido();
			agregarElementoCervezaAlPedido();
			mostrarPedido();

		} // FIN BTNREFRESCOS
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
		// Método para llenar el JList del panelPedidoNuevo con la información de
		// refrescos

	private void mostrarTodosLosPedidosPorMesa() {
		// Obtén la información de todos los pedidos de las mesas
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
	}

	// Método para agregar el elemento seleccionado al pedido
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
			if (pedidoMesa != null) {
				// Verificar si el refresco ya está en el pedido
				if (pedidoMesa.getBebidasPedido().containsKey(nombreRefresco)) {
					// Si está en el pedido, actualizar la cantidad y el precio
					int cantidadActual = pedidoMesa.getBebidasPedido().get(nombreRefresco);
					pedidoMesa.agregarBebida(nombreRefresco, cantidadActual + 1);

					// Actualizar el modelo del JList de pedidoMesa
					DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa
							.getModel();
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
					DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa
							.getModel();
					modelPedidoMesa.addElement(nombreRefresco + " - Cantidad: 1 - Precio: " + precioRefresco);
				}
			}
		}
	}
	// Método para agregar el elemento seleccionado de cerveza al pedido
	private void agregarElementoCervezaAlPedido() {
	    // Obtenemos el elemento seleccionado del JList de cervezas
	    Object elementoSeleccionadoObject = vista.listCervezaspanelPedidoNuevo.getSelectedValue();

	    // Verificamos si hay un elemento seleccionado y lo castreamos a String
	    if (elementoSeleccionadoObject != null && elementoSeleccionadoObject instanceof String) {
	        String elementoSeleccionado = (String) elementoSeleccionadoObject;

	        // Obtener el nombre de la cerveza y la información desde la cadena seleccionada
	        String nombreCerveza = elementoSeleccionado.split(" - Precio: ")[0];
	        // Asumiendo que el precio está en el formato correcto y puede ser parseado directamente
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
	                    DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
	                    // Buscar el índice de la línea que contiene la cerveza y actualizarla
	                    for (int i = 0; i < modelPedidoMesa.getSize(); i++) {
	                        String lineaPedido = modelPedidoMesa.getElementAt(i);
	                        if (lineaPedido.startsWith(nombreCerveza)) {
	                            // Extraer cantidad y precio de la línea actual
	                            int cantidadExistente = Integer.parseInt(lineaPedido.split(" - Cantidad: ")[1].split(" - Precio: ")[0]);
	                            int precioExistente = Integer.parseInt(lineaPedido.split(" - Precio: ")[1]);

	                            // Calcular la nueva cantidad y precio
	                            int nuevaCantidad = cantidadExistente + 1;
	                            int nuevoPrecio = precioExistente + precioCerveza;

	                            // Actualizar la línea en el modelo del JList
	                            modelPedidoMesa.set(i, nombreCerveza + " - Cantidad: " + nuevaCantidad + " - Precio: " + nuevoPrecio);
	                            break;
	                        }
	                    }
	                } else {
	                    // Si no está en el pedido, agregarlo con cantidad 1
	                    pedidoMesa.agregarBebida(nombreCerveza, 1);

	                    // Actualizar el modelo del JList de pedidoMesa con una nueva línea
	                    DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
	                    modelPedidoMesa.addElement(nombreCerveza + " - Cantidad: 1 - Precio: " + precioCerveza);
	                }
	            }
	        }
	    }
	}

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
	}

	private Pedido obtenerPedidoPorNumeroMesa(int numeroMesa) {

		// Ejemplo ficticio para prueba de a que panel lleva dependiendo del booleano
		if (numeroMesa == 1) {
			/*
			 * Pedido pedido = new Pedido(); pedido.agregarBebida("Cerveza", 2);
			 * pedido.setEsOcupada(true);
			 */
			return pedido;
		} else {
			return null;
		}
	}

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

	@Override
	public void valueChanged(ListSelectionEvent e) {
	    if (!e.getValueIsAdjusting()) {
	        // Check if the source of the event is the listRefrescos
	        if (e.getSource() == vista.listRefrescos) {
	            handleListSelection(vista.listRefrescos, vista.spinnerCantidadRefrescos);
	        }
	        // Check if the source of the event is the listCerveza
	        else if (e.getSource() == vista.listCerveza) {
	            // Remove the handleListSelection call for listCerveza
	            // handleListSelection(vista.listCerveza, vista.spinnerCantidadCerveza);
	        }
	        // Check if the source of the event is the listRefrescospanelPedidoNuevo
	        else if (e.getSource() == vista.listRefrescospanelPedidoNuevo) {
	            // Verify if there is a mesa selected before allowing changes
	            if (!mesaSeleccionada.isEmpty()) {
	                handleListSelection(vista.listRefrescospanelPedidoNuevo, vista.spinnerCantidadRefrescos);
	            } else {
	                // Show an error message indicating that a mesa must be selected
	                JOptionPane.showMessageDialog(vista, "Seleccione una mesa antes de añadir bebidas al pedido.",
	                        "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        // Check if the source of the event is the listPedidoMesa
	        if (e.getSource() == vista.listPedidoMesa && !e.getValueIsAdjusting()) {
	            // Obtén la mesa seleccionada
	            int numeroMesa = vista.listPedidoMesa.getSelectedIndex() + 1;

	            // Actualiza la lista de pedidos para la mesa seleccionada
	            actualizarListaPedidosMesa(numeroMesa);
	        }
	    }
	}


	private void handleListSelection(JList<String> list, JSpinner spinner) {
		// Verify if there is an item selected
		if (list.getSelectedIndex() != -1) {
			// Show the spinnerCantidad if an item is selected
			spinner.setVisible(true);
		} else {
			// Hide the spinnerCantidad if no item is selected
			spinner.setVisible(false);
		}
	}

	private void inicializarListas() {
		// Configura las listas iniciales, si es necesario
	}

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
	}
}// FIN CLASS
