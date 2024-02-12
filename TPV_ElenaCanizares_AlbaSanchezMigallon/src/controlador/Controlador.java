package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Aperitivo;
import modelo.Botella;
import modelo.Caja;
import modelo.Cerveza;
import modelo.Coctel;
import modelo.Ingrediente;
import modelo.Inventario;
import modelo.Local;
import modelo.Mesa;
import modelo.Musica;
import modelo.Pedido;
import modelo.Refresco;
import modelo.Vino;
import vista.Vista;

public class Controlador implements ActionListener, ListSelectionListener, ChangeListener {
	Vista vista = new Vista();
	Local local = Local.getInstance();
	Musica musica = new Musica();
	Inventario inventario = Inventario.getInstance();
	private JList ultimaSeleccionLista;
	private Mesa mesaActiva;
	Caja caja;

	public Controlador(Vista vista) {
		this.vista = vista;
		this.musica = musica;

		this.vista.btnCaja.addActionListener(this);
		this.vista.btnInventario.addActionListener(this);
		this.vista.btnMusica.addActionListener(this);
		this.vista.btnMesa1.addActionListener(this);
		this.vista.btnMesa2.addActionListener(this);
		this.vista.btnMesa3.addActionListener(this);
		this.vista.btnMesa4.addActionListener(this);
		this.vista.btnMesa5.addActionListener(this);
		this.vista.btnMesa6.addActionListener(this);
		this.vista.btnMesa7.addActionListener(this);
		this.vista.btnAceptarCambios.addActionListener(this);
		this.vista.btnRevertirCambios.addActionListener(this);
		this.vista.btnRefrescos.addActionListener(this);
		this.vista.btnAgregar.addActionListener(this);
		this.vista.btnQuitar.addActionListener(this);
		this.vista.btnAnadirAlPedido.addActionListener(this);
		this.vista.btnVolverInicio.addActionListener(this);
		this.vista.btnVolverInicio2.addActionListener(this);
		this.vista.btnCervezas.addActionListener(this);
		this.vista.btnVino.addActionListener(this);
		this.vista.btnAperitivos.addActionListener(this);
		this.vista.btnCocktels.addActionListener(this);
		this.vista.comboBoxMusica.addActionListener(this);
		this.vista.listRefrescos.addListSelectionListener(this);
		this.vista.listCerveza.addListSelectionListener(this);
		this.vista.listAperitivos.addListSelectionListener(this);
		this.vista.listBotellas.addListSelectionListener(this);
		this.vista.listIngredientes.addListSelectionListener(this);
		this.vista.listVinos.addListSelectionListener(this);
		this.vista.btnCierreCaja.addActionListener(this);
		this.vista.btnPagarPedido.addActionListener(this);
		this.vista.btnArqueo.addActionListener(this);
		this.vista.btnAceptarContrasenia.addActionListener(this);
		this.vista.btnVolverContrasenia.addActionListener(this);
		this.vista.btnVolverCaja.addActionListener(this);

		this.vista.listRefrescospanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listCervezaspanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listAperitivospanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listBotellaspanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listCocktelspanelPedidoNuevo.addListSelectionListener(this);
		this.vista.listVinopanelPedidoNuevo.addListSelectionListener(this);

		this.vista.listPedidoMesa.addListSelectionListener(this);
		
		this.vista.spinnerCantidadAperitivos.addChangeListener(this);
		this.vista.spinnerCantidadBotellas.addChangeListener(this);
		this.vista.spinnerCantidadCerveza.addChangeListener(this);
		this.vista.spinnerCantidadIngredientes.addChangeListener(this);
		this.vista.spinnerCantidadRefrescos.addChangeListener(this);
		this.vista.spinnerCantidadVinos.addChangeListener(this);
		
		caja = Caja.getInstance();

	}// FIN CONSTRUCTOR

	private void configurarMusicaComboBox() {

		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(
				musica.getOpcionesMusica().toArray(new String[0]));
		vista.comboBoxMusica.setModel(comboBoxModel);

		vista.comboBoxMusica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int indiceSeleccionado = vista.comboBoxMusica.getSelectedIndex();

				new Thread(new Runnable() {
					@Override
					public void run() {
						musica.lanzar(indiceSeleccionado);
					}
				}).start();
			}
		});
	}// FIN CONFIGURARMUSICACOMBOBOX

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnCaja) {
			vista.panelInicio.setVisible(false);
			vista.panelCaja.setVisible(true);
			
			DefaultListModel<String> model = new DefaultListModel<>();
			model.clear();
			vista.listPedidos.setModel(model);
			
			listarPedidos();
		} // PANEL CAJA

		if(e.getSource()== vista.btnVolverCaja) {
			ocultarPaneles();
			vista.panelInicio.setVisible(true);
			vista.lblPagado.setVisible(false);
			
			
		}
		if(e.getSource() == vista.btnPagarPedido) {
			pagarPedido();
		}
		
		if(e.getSource()== vista.btnCaja) {
			vista.panelInicio.setVisible(false);
			vista.panelCaja.setVisible(true);
		}
		
		// panel cierre caja
		if(e.getSource()== vista.btnCierreCaja) {
			vista.panelUsuarioCaja.setVisible(true);
			vista.panelCaja.setVisible(false);
		}
		if (e.getSource() == vista.btnAceptarContrasenia) {
			
			// envia la contrasenia del passwordField y retorna si es correcta	
			boolean esCorrecta =caja.comprobarContrasenia(vista.passwordField.getPassword());
			
			if (esCorrecta) {
				double total = caja.cerrarCaja();
				vista.labelRetroalimentacionContrasenia
						.setText("Contrasenia correcta. Se ha cerrado la caja caja.\nTOTAL: " + total);
				vista.passwordField.setText("");
			}else {
				vista.labelRetroalimentacionContrasenia
				.setText("Contrasenia incorrecta.");
				vista.passwordField.setVisible(true);
				vista.labelRetroalimentacionContrasenia
				.setText("Vuelva a introducir la contrasenia para cerrar caja:");
				vista.passwordField.setText("");
			}

		}//Fin aceptar contraseña
		
		if(e.getSource()== vista.btnVolverContrasenia) {
			// boton para bolver de panel de caontrasenia en caja a caja
			vista.panelCaja.setVisible(true);
			vista.panelUsuarioCaja.setVisible(false);
			vista.lblPagado.setVisible(false);
			vista.labelRetroalimentacionContrasenia
			.setText("Introduzca la contrasenia para hacer cierre de caja:");
		}// panel pagar pedido
		
		
		
		
		if(e.getSource()== vista.btnArqueo) {
			// boton para bolver de panel de caontrasenia en caja a caja
			vista.lblPagado.setText("Se ha recaudado "+caja.calcularArqueo());
			vista.lblPagado.setVisible(true);
		}// arqueo
		

		// FIN PANEL CAJA

		if (e.getSource() == vista.btnInventario) {
			vista.panelInicio.setVisible(false);
			vista.panelInventario.setVisible(true);

			listarRefrescos();
			listarCervezas();
			listarAperitivos();
			listarBotellas();
			listarIngredientes();
			listarVinos();

		} // PANEL INVENTARIO
		if (e.getSource() == vista.btnMusica) {
			vista.panelInicio.setVisible(false);
			vista.panelMusica.setVisible(true);

			configurarMusicaComboBox();
		} // FIN BTNMUSICA
		if (e.getSource() == vista.comboBoxMusica) {
			int indiceSeleccionado = vista.comboBoxMusica.getSelectedIndex();

			new Thread(new Runnable() {
				@Override
				public void run() {
					musica.lanzar(indiceSeleccionado);
				}
			}).start();
		} // FIN COMBOBOXMUSICA

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
			ocultarPaneles();
			vista.panelInicio.setVisible(true);
		} // ELIMINAR CAMBIOS

		if (e.getSource() == vista.btnMesa1) {
			mesaActiva = local.getMesas().get(0);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(0));

		}
		if (e.getSource() == vista.btnMesa2) {
			mesaActiva = local.getMesas().get(1);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(1));

		}
		if (e.getSource() == vista.btnMesa3) {
			mesaActiva = local.getMesas().get(2);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(2));

		}
		if (e.getSource() == vista.btnMesa4) {
			mesaActiva = local.getMesas().get(3);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(3));

		}
		if (e.getSource() == vista.btnMesa5) {
			mesaActiva = local.getMesas().get(4);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(4));

		}
		if (e.getSource() == vista.btnMesa6) {
			mesaActiva = local.getMesas().get(5);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(5));

		}
		if (e.getSource() == vista.btnMesa7) {
			mesaActiva = local.getMesas().get(6);
			if(!mesaActiva.isEsOcupada()) {
				mesaActiva.getPedido().getproductos().clear();
			}
			clicMesa(local.getMesas().get(6));

		} // FIN BOTONES MESA

		// Agregamos el listener al boton de refrescos
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
		if (e.getSource() == vista.btnAgregar) {
			agregarElementoRefrescoAlPedido();
			agregarElementoCervezaAlPedido();
			agregarElementoAperativoAlPedido();
			agregarElementoCoctelAlPedido();
			agregarElementoVinoAlPedido();
			// mostrarPedido();

		}
		// FIN BTN AGREGAR AL PEDIDO
		if (e.getSource() == vista.btnQuitar) {
			quitarElementosDelPedido();

		}
		// FIN BTN QUITAR AL PEDIDO
		if (e.getSource() == vista.btnAnadirAlPedido) {
			anadirPedido();
		} // FIN BTN ANADIR AL PEDIDO
		if (e.getSource() == vista.btnVolverInicio) {
			ocultarPaneles();
			vista.panelInicio.setVisible(true);
		}//Fin boton volver inicio
		if (e.getSource() == vista.btnVolverInicio2) {
			ocultarPaneles();
			vista.panelInicio.setVisible(true);
		}//Fin boton volver inicio 2

	}// FIN actionPerformed

	public void ocultarPaneles() {
		// Oculta el panel de pedido
		vista.panelInventario.setVisible(false);
		// Oculta el panel de pedido
		vista.panelCaja.setVisible(false);
		// Oculta el panel de pedido
		vista.panelMusica.setVisible(false);
		vista.panelPedidoNuevo.setVisible(false);

	}//Fin ocultar paneles

	// Metodo para indicar el clic en un boton/mesa
	private void clicMesa(Mesa mesa) {
		vista.panelInicio.setVisible(false);
		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();
		
		vista.listAperitivospanelPedidoNuevo.setModel(model);
		vista.listRefrescospanelPedidoNuevo.setModel(model);
		vista.listCervezaspanelPedidoNuevo.setModel(model);
		vista.listCocktelspanelPedidoNuevo.setModel(model);
		vista.listVinopanelPedidoNuevo.setModel(model);
		vista.lblPedidoDisponible.setVisible(false);

		// Verificamos si la mesa esta ocupada
		if (mesa.isEsOcupada()) {
			System.out.println("Mesa ocupada. Mostrando pedido...");
			vista.panelPedidoNuevo.setVisible(true);
			mostrarPedido(mesa);
		} else {
			System.out.println("Mesa no ocupada. Redirigiendo a nuevo pedido...");
			vista.panelPedidoNuevo.setVisible(true);
			
			DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
			modelPedidoMesa.clear();

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

	/*--------------------------------Metodos de agregar en paneles nuevos por clase-------------------------------------------*/

	private void agregarElementoRefrescoAlPedido() {
		Object elementoSeleccionadoObject = vista.listRefrescospanelPedidoNuevo.getSelectedValue();
		agregarElemento(elementoSeleccionadoObject, "Refresco");
	}// FIN AGREGAR ELEMENTO REFRESCO AL PEDIDO

	// Metodo para agregar el elemento seleccionado de cerveza al pedido
	private void agregarElementoCervezaAlPedido() {
		Object elementoSeleccionadoObject = vista.listCervezaspanelPedidoNuevo.getSelectedValue();
		agregarElemento(elementoSeleccionadoObject, "Cerveza");
	}// FIN AGREGAR ELEMENTO CERVEZA AL PEDIDO

	// Metodo para agregar el elemento seleccionado de aperitivo al pedido
	private void agregarElementoAperativoAlPedido() {
		Object elementoSeleccionadoObject = vista.listAperitivospanelPedidoNuevo.getSelectedValue();
		agregarElemento(elementoSeleccionadoObject, "Aperitivo");
	}// FIN AGREGAR ELEMENTO APERITIVO AL PEDIDO

	// Metodo para agregar el elemento seleccionado de cocktels al pedido
	private void agregarElementoCoctelAlPedido() {
		Object elementoSeleccionadoObject = vista.listCocktelspanelPedidoNuevo.getSelectedValue();
		agregarElemento(elementoSeleccionadoObject, "Coctel");
	}// FIN AGREGAR ELEMENTO COCKTEL AL PEDIDO

	// Metodo para agregar el elemento seleccionado de vino al pedido
	private void agregarElementoVinoAlPedido() {
		Object elementoSeleccionadoObject = vista.listVinopanelPedidoNuevo.getSelectedValue();
		agregarElemento(elementoSeleccionadoObject, "Vino");
	}// FIN AGREGAR ELEMENTO VINO AL PEDIDO

	
	// Agregar elemento al pedido
	private void agregarElemento(Object elementoSeleccionadoObject, String producto) {

		if (elementoSeleccionadoObject instanceof String) {
			String elementoSeleccionado = (String) elementoSeleccionadoObject;
			String[] partes = elementoSeleccionado.split(" - Precio: ");

			if (partes.length == 2) {
				String nombre = partes[0];
				String precio = partes[1];
				Pedido pedidoMesa = mesaActiva.getPedido();

				DefaultListModel<String> modelPedidoMesa = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				modelPedidoMesa.addElement(nombre + " - Cantidad: 1 - Precio: " + precio);
				switch (producto) {
				case "Aperitivo":
					Aperitivo aperitivo = new Aperitivo(Double.parseDouble(precio.split("€")[0]), nombre, false);
					pedidoMesa.getproductos().add(aperitivo);
					break;
				case "Cerveza":
					Cerveza cerveza = new Cerveza(Double.parseDouble(precio.split("€")[0]), nombre, false);
					pedidoMesa.getproductos().add(cerveza);
					break;
				case "Refresco":
					Refresco refresco = new Refresco(Double.parseDouble(precio.split("€")[0]), nombre, false);
					pedidoMesa.getproductos().add(refresco);
					break;
				case "Vino":
					Vino vino = new Vino(Double.parseDouble(precio.split("€")[0]), nombre, false);
					pedidoMesa.getproductos().add(vino);
					break;
				case "Coctel":
					Coctel coctel = new Coctel(Double.parseDouble(precio.split("€")[0]), nombre, false);
					pedidoMesa.getproductos().add(coctel);
					break;
				}
				mesaActiva.setPedido(pedidoMesa);
				vista.listPedidoMesa.setModel(modelPedidoMesa);
				vista.lblPedidoDisponible.setVisible(false);
			}
		}
	}//Fin agregar elemento

	// Anadimos el pedido a la mesa activa
	private void anadirPedido() {
		// restar del inventario
		boolean pedidoPosible = true;
		for (int i = 0; i < mesaActiva.getPedido().getproductos().size(); i++) {
			pedidoPosible = mesaActiva.getPedido().pedirProducto(mesaActiva.getPedido().getproductos().get(i));
		}
		
		if(!pedidoPosible) {
			vista.lblPedidoDisponible.setText("Pedido no posible");
			vista.lblPedidoDisponible.setVisible(true);
			
		}else {
			for (int i = 0; i < local.getMesas().size(); i++) {
				if (mesaActiva.getNumeroMesa() == local.getMesas().get(i).getNumeroMesa()) {
					if(mesaActiva.getPedido().getproductos().size()> 0) {
						local.getMesas().get(i).setPedido(mesaActiva.getPedido());
						local.getMesas().get(i).setEsOcupada(true);
						
						for (int j = 0; j < local.getMesas().get(i).getPedido().getproductos().size(); j++) {
							local.getMesas().get(i).getPedido().getproductos().get(j).setPedido(true);
						}
					}


				}
			}
			if(mesaActiva.getPedido().getproductos().size()> 0) {
				ocultarPaneles();
				vista.panelInicio.setVisible(true);
			}

		}


	}//Fin anadir pedido
	
	/*--------------------------------Fin metodos de agregar en paneles nuevos por clase-------------------------------------------*/
	
	/*----------------------------------Metodos para quitar cosas al pedido-------------------------------------------------*/
	
	private void quitarElementosDelPedido() {
		int indice = vista.listPedidoMesa.getSelectedIndex();
		
		if (indice >= 0) {
			
			for (int i = 0; i < local.getMesas().size(); i++) {
				if (mesaActiva.getNumeroMesa() == local.getMesas().get(i).getNumeroMesa()) {
					if(mesaActiva.getPedido().getproductos().size()> 0) {
						mesaActiva.setPedido(local.getMesas().get(i).getPedido());
						
					}
				}
			}
			if(!mesaActiva.getPedido().getproductos().get(indice).isPedido()) {
				mesaActiva.getPedido().getproductos().remove(indice);
				
				DefaultListModel<String> model = (DefaultListModel<String>) vista.listPedidoMesa.getModel();
				model.remove(indice);
				
				vista.listPedidoMesa.setModel(model);
			} else {
				vista.lblPedidoDisponible.setText("No se puede quitar el producto");
				vista.lblPedidoDisponible.setVisible(true);
				System.out.println("No se puede quitar el producto");
			}

		}

	}//Fin quitar elementos del pedido

	/*--------------------------------Metodos de listar en paneles nuevos por clase-------------------------------------------*/

	private void listarCervezasPanelPedidoNuevo() {

		HashMap<Cerveza, Integer> listaCervezas = inventario.getCervezas();

		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();

		for (HashMap.Entry<Cerveza, Integer> entry : listaCervezas.entrySet()) {
			if(entry.getValue() != 0) {
				model.addElement(entry.getKey().getNombre() + " - Precio: " + entry.getKey().getPrecio() + "€");
			}

		}
		vista.listCervezaspanelPedidoNuevo.setModel(model);
	}// FIN LISTAR CERVEZAS PANEL PEDIDO NUEVO

	private void listarRefrescosPanelPedidoNuevo() {
	
		HashMap<Refresco, Integer> listaRefrescos = inventario.getRefrescos();

		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();

		for (HashMap.Entry<Refresco, Integer> entry : listaRefrescos.entrySet()) {
			if(entry.getValue() != 0) {
				model.addElement(entry.getKey().getNombre() + " - Precio: " + entry.getKey().getPrecio() + "€");
			}
			
		}
		
		vista.listRefrescospanelPedidoNuevo.setModel(model);
	}// FIN LISTAR REFRESCOS PANEL PEDIDO NUEVO

	private void listarAperitivosPanelPedidoNuevo() {

		HashMap<Aperitivo, Integer> listaAperitivos = inventario.getAperitivos();

		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();

		for (HashMap.Entry<Aperitivo, Integer> entry : listaAperitivos.entrySet()) {
			if(entry.getValue() != 0) {
				model.addElement(entry.getKey().getNombre() + " - Precio: " + entry.getKey().getPrecio() + "€");
			}
			
		}
		vista.listAperitivospanelPedidoNuevo.setModel(model);
	}// FIN LISTAR APERITIVOS PEDIDO NUEVO

	private void listarCocktelsPanelPedidoNuevo() {

		HashMap<Coctel, Integer> listaCoctels = inventario.getCocteles();

		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();

		for (HashMap.Entry<Coctel, Integer> entry : listaCoctels.entrySet()) {
			model.addElement(entry.getKey().getNombre() + " - Precio: " + entry.getKey().getPrecio() + "€");
		}
		vista.listCocktelspanelPedidoNuevo.setModel(model);
	}// FIN LISTAR COCKTELS PEDIDO NUEVO

	private void listarVinosPanelPedidoNuevo() {

		HashMap<Vino, Integer> listaVinos = inventario.getVinos();

		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();

		for (HashMap.Entry<Vino, Integer> entry : listaVinos.entrySet()) {
			if(entry.getValue() != 0) {
				model.addElement(entry.getKey().getNombre() + " - Precio: " + entry.getKey().getPrecio() + "€");
			}
			
		}
		vista.listVinopanelPedidoNuevo.setModel(model);
	}// FIN LISTAR VINOS PEDIDO NUEVO
	
	/*--------------------------------Fin metodos de listar en paneles nuevos por clase-------------------------------------------*/
	

	// Metodo que muestra el pedido de la mesa en panelPedidoNuevo
	private void mostrarPedido(Mesa mesa) {
		if (mesa.isEsOcupada()) {
			
			DefaultListModel<String> modelPedido = new DefaultListModel<>();
			modelPedido.clear();
			
			for (int i = 0; i < mesa.getPedido().getproductos().size(); i++) {
				String producto = mesa.getPedido().getproductos().get(i).getNombre() + " - Cantidad: 1 - Precio: "
						+ mesa.getPedido().getproductos().get(i).getPrecio();
				modelPedido.addElement(producto);
			}

			vista.listPedidoMesa.setModel(modelPedido);
		}
	}// FIN MOSTRAR PEDIDO
	
	/*--------------------------------Metodos de listar de pedidos y pagar-------------------------------------------*/
	
	private void listarPedidos () {
		
		HashMap <Integer, Pedido> mesaPedido = new HashMap();
	
		DefaultListModel<String> model = new DefaultListModel<>();
		model.clear();
		for (int i = 0; i< local.getMesas().size(); i++) {
			if(local.getMesas().get(i).isEsOcupada()) {
				mesaPedido.put(local.getMesas().get(i).getNumeroMesa(), local.getMesas().get(i).getPedido());
			}
		}
		
		for (HashMap.Entry<Integer, Pedido> entry : mesaPedido.entrySet()) {
			model.addElement("Mesa "+entry.getKey()+ "- Total: " + entry.getValue().calcularTotalPedido()+ "€");
		}
		
		vista.listPedidos.setModel(model);
	}//Fin listar pedidos
	
	private void pagarPedido() {
		Object elementoSeleccionadoObject = vista.listPedidos.getSelectedValue();
		
		if (elementoSeleccionadoObject instanceof String) {
			
			String elementoSeleccionado = (String) elementoSeleccionadoObject;
			String[] partes = elementoSeleccionado.split("- ");

			if (partes.length == 2) {
				int numMesa = Integer.parseInt(partes[0].split(" ")[1]);
				
				for (int i = 0; i< local.getMesas().size(); i++) {
					if(numMesa == local.getMesas().get(i).getNumeroMesa()) {
						caja.pagarPedidoCaja(local.getMesas().get(i).getPedido());
						local.getMesas().get(i).setEsOcupada(false);
					}
				}
			}

			listarPedidos();
		}
	}//Fin pagar pedido
	
	/*--------------------------------Metodos de listar en inventario por clase-------------------------------------------*/

	private void listarRefrescos() {
		
		HashMap<Refresco, Integer> listaRefrescos = inventario.getRefrescos();

		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listRefrescos.setModel(model);

		for (HashMap.Entry<Refresco, Integer> entry : listaRefrescos.entrySet()) {
			model.addElement(entry.getKey().getNombre() + "- Cantidad: " + entry.getValue() + "- Precio: "
					+ entry.getKey().getPrecio() + "€");
		}

		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadRefrescos, "#");
		vista.spinnerCantidadRefrescos.setEditor(editor);
	}// FIN LISTAR REFRESCOS

	private void listarAperitivos() {

		HashMap<Aperitivo, Integer> listaAperitivos = inventario.getAperitivos();

		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listAperitivos.setModel(model);

		for (HashMap.Entry<Aperitivo, Integer> entry : listaAperitivos.entrySet()) {
			model.addElement(entry.getKey().getNombre() + "- Cantidad: " + entry.getValue() + "- Precio: "
					+ entry.getKey().getPrecio() + "€");
		}

		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadAperitivos, "#");
		vista.spinnerCantidadAperitivos.setEditor(editor);
	}// FIN LISTAR APERITIVOS

	private void listarBotellas() {
		
		HashMap<Botella, Integer> listaBotellas = inventario.getBotellas();

		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listBotellas.setModel(model);

		for (HashMap.Entry<Botella, Integer> entry : listaBotellas.entrySet()) {
			model.addElement(entry.getKey().getNombre() + "- Cantidad: " + entry.getValue() + "- Precio: "
					+ entry.getKey().getPrecio() + "€");
		}

		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadBotellas, "#");
		vista.spinnerCantidadBotellas.setEditor(editor);
	}// FIN LISTAR BOTELLAS

	private void listarIngredientes() {

		HashMap<Ingrediente, Integer> listaIngredientes = inventario.getIngredientes();

		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listIngredientes.setModel(model);

		for (HashMap.Entry<Ingrediente, Integer> entry : listaIngredientes.entrySet()) {
			model.addElement(entry.getKey().getNombre() + "- Cantidad: " + entry.getValue() + "- Precio: "
					+ entry.getKey().getPrecio() + "€");
		}

		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadIngredientes, "#");
		vista.spinnerCantidadIngredientes.setEditor(editor);
	}// FIN LISTAR INGREDIENTES

	private void listarVinos() {

		HashMap<Vino, Integer> listaVinos = inventario.getVinos();

		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listVinos.setModel(model);

		for (HashMap.Entry<Vino, Integer> entry : listaVinos.entrySet()) {
			model.addElement(entry.getKey().getNombre() + "- Cantidad: " + entry.getValue() + "- Precio: "
					+ entry.getKey().getPrecio() + "€");
		}

		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(vista.spinnerCantidadVinos, "#");
		vista.spinnerCantidadVinos.setEditor(editor);
	}// FIN LISTAR VINOS

	private void listarCervezas() {
		
		HashMap<Cerveza, Integer> listaCervezas = inventario.getCervezas();
	
		DefaultListModel<String> model = new DefaultListModel<>();
		vista.listCerveza.setModel(model);
		
		for (HashMap.Entry<Cerveza, Integer> entry : listaCervezas.entrySet()) {
			model.addElement(entry.getKey().getNombre() + "- Cantidad: " + entry.getValue() + "- Precio: "
					+ entry.getKey().getPrecio() + "€");
		}

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
			String parteuno = elementoSeleccionado.split("Cantidad: ")[1];
			String precio = parteuno.split("-")[1];

			// Obtenemos el valor del spinnerCantidad
			int nuevaCantidad = (int) spinnerCantidad.getValue();

			// Obtenemos el nombre del producto
			String nombreProducto = elementoSeleccionado.split("- Cantidad: ")[0];

			// Actualizamos la cantidad en la instancia correspondiente de cada clase
			// (Refresco, Cerveza, Aperitivo)
			if ("Refresco".equals(tipoProducto)) {
				inventario.actualizarCantidadRefrescos(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);
				vista.listRefrescos.setModel(model);

			} else if ("Cerveza".equals(tipoProducto)) {
				inventario.actualizarCantidadCerveza(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);
				vista.listCerveza.setModel(model);

			} else if ("Aperitivo".equals(tipoProducto)) {
				inventario.actualizarCantidadAperitivos(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);
				vista.listAperitivos.setModel(model);

			} else if ("Botella".equals(tipoProducto)) {
				inventario.actualizarCantidadBotellas(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);
				vista.listBotellas.setModel(model);

			} else if ("Cocktel".equals(tipoProducto)) {
				inventario.actualizarCantidadCocteles(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);

			} else if ("Ingrediente".equals(tipoProducto)) {
				inventario.actualizarCantidadIngredientes(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);
				vista.listIngredientes.setModel(model);

			} else if ("Vino".equals(tipoProducto)) {
				inventario.actualizarCantidadVinos(nombreProducto, nuevaCantidad);
				elementoSeleccionado = tipoProducto + "- Cantidad: " + nuevaCantidad + "-" + precio;
				model.setElementAt(elementoSeleccionado, selectedIndex);
				vista.listVinos.setModel(model);

			}// Actualizamos el modelo del JList
			
			if ("Refresco".equals(tipoProducto)) {
				listarRefrescos();
			} else if ("Cerveza".equals(tipoProducto)) {
				listarCervezas();
			} else if ("Aperitivo".equals(tipoProducto)) {
				listarAperitivos();
			} else if ("Botella".equals(tipoProducto)) {
				listarBotellas();
			} else if ("Ingrediente".equals(tipoProducto)) {
				listarIngredientes();
			} else if ("Vino".equals(tipoProducto)) {
				listarVinos();
			}
		}
	}// FIN actualizarCantidadSeleccionada

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
				if (vista.listRefrescos.getSelectedIndex() != -1) {
					vista.spinnerCantidadRefrescos.setVisible(true);
					String producto = (String) vista.listRefrescos.getSelectedValue();
					producto = producto.split("-")[0];
					for (HashMap.Entry<Refresco, Integer> entry : inventario.getRefrescos().entrySet()) {
						if (entry.getKey().getNombre().equals(producto)) {
							vista.spinnerCantidadRefrescos.setValue(entry.getValue());
						}
					}

				} else {
					vista.spinnerCantidadRefrescos.setVisible(false);
				}
				break;
			case 2:
				handleListSelection(vista.listCerveza, vista.spinnerCantidadCerveza);
				if (vista.listCerveza.getSelectedIndex() != -1) {
					vista.spinnerCantidadCerveza.setVisible(true);
					String producto = (String) vista.listCerveza.getSelectedValue();
					producto = producto.split("-")[0];
					for (HashMap.Entry<Cerveza, Integer> entry : inventario.getCervezas().entrySet()) {
						if (entry.getKey().getNombre().equals(producto)) {
							vista.spinnerCantidadCerveza.setValue(entry.getValue());
						}
					}
				} else {
					vista.spinnerCantidadCerveza.setVisible(false);
				}
				break;
			case 3:
				handleListSelection(vista.listAperitivos, vista.spinnerCantidadAperitivos);
				if (vista.listAperitivos.getSelectedIndex() != -1) {
					vista.spinnerCantidadAperitivos.setVisible(true);
					String producto = (String) vista.listAperitivos.getSelectedValue();
					producto = producto.split("-")[0];
					for (HashMap.Entry<Aperitivo, Integer> entry : inventario.getAperitivos().entrySet()) {
						if (entry.getKey().getNombre().equals(producto)) {
							vista.spinnerCantidadAperitivos.setValue(entry.getValue());
						}
					}
				} else {
					vista.spinnerCantidadAperitivos.setVisible(false);
				}
				break;
			case 4:
				handleListSelection(vista.listBotellas, vista.spinnerCantidadBotellas);
				if (vista.listBotellas.getSelectedIndex() != -1) {
					vista.spinnerCantidadBotellas.setVisible(true);
					String producto = (String) vista.listBotellas.getSelectedValue();
					producto = producto.split("-")[0];
					for (HashMap.Entry<Botella, Integer> entry : inventario.getBotellas().entrySet()) {
						if (entry.getKey().getNombre().equals(producto)) {
							vista.spinnerCantidadBotellas.setValue(entry.getValue());
						}
					}
				} else {
					vista.spinnerCantidadBotellas.setVisible(false);
				}
				break;
			case 6:
				handleListSelection(vista.listIngredientes, vista.spinnerCantidadIngredientes);
				if (vista.listIngredientes.getSelectedIndex() != -1) {
					vista.spinnerCantidadIngredientes.setVisible(true);
					String producto = (String) vista.listIngredientes.getSelectedValue();
					producto = producto.split("-")[0];
					for (HashMap.Entry<Ingrediente, Integer> entry : inventario.getIngredientes().entrySet()) {
						if (entry.getKey().getNombre().equals(producto)) {
							vista.spinnerCantidadIngredientes.setValue(entry.getValue());
						}
					}
				} else {
					vista.spinnerCantidadIngredientes.setVisible(false);
				}
				break;
			case 7:
				handleListSelection(vista.listVinos, vista.spinnerCantidadVinos);
				if (vista.listVinos.getSelectedIndex() != -1) {
					vista.spinnerCantidadVinos.setVisible(true);
					String producto = (String) vista.listVinos.getSelectedValue();
					producto = producto.split("-")[0];
					for (HashMap.Entry<Vino, Integer> entry : inventario.getVinos().entrySet()) {
						if (entry.getKey().getNombre().equals(producto)) {
							vista.spinnerCantidadVinos.setValue(entry.getValue());
						}
					}
				} else {
					vista.spinnerCantidadVinos.setVisible(false);
				}
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
			case 13:
				handleListSelection(vista.listVinopanelPedidoNuevo, vista.spinnerCantidadVinos);
				break;
			case 14:
				int numeroMesa = vista.listPedidoMesa.getSelectedIndex() + 1;
				
				break;
			default:
				
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
		if (list.getSelectedIndex() != -1) {
			// Show the spinnerCantidad if an item is selected
			spinner.setVisible(true);
		} else {
			// Hide the spinnerCantidad if no item is selected
			spinner.setVisible(false);
		}
	}// FIN HANDLELISTSELECTION
	
	/*-------------------------------- Fin metodos para manejar los ListSelectionEvents-------------------------------------------*/
	
	// Metodo para actualizar la lista de pedidos de cada mesa
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource() == vista.spinnerCantidadAperitivos) {
			fijarMinimoValor(vista.spinnerCantidadAperitivos);
		}
		
		if (e.getSource() == vista.spinnerCantidadBotellas) {
			fijarMinimoValor(vista.spinnerCantidadBotellas);
		}
		
		if (e.getSource() == vista.spinnerCantidadCerveza) {
			fijarMinimoValor(vista.spinnerCantidadCerveza);
		}
		
		if (e.getSource() == vista.spinnerCantidadIngredientes) {
			fijarMinimoValor(vista.spinnerCantidadIngredientes);
		}
		
		if (e.getSource() == vista.spinnerCantidadRefrescos) {
			fijarMinimoValor(vista.spinnerCantidadRefrescos);
		}
		
		if (e.getSource() == vista.spinnerCantidadVinos) {
			fijarMinimoValor(vista.spinnerCantidadVinos);
		}
		
	}//Fin state changed
	
	private void fijarMinimoValor (JSpinner spinner) {
		
		int valor = (int) spinner.getValue();
		int valorMinimo = 0; //Limite de valor
		
		if (valor < valorMinimo) {
			spinner.setValue(valorMinimo);
		}
	}//Fin fijar minimo valor

}// FIN CLASS
