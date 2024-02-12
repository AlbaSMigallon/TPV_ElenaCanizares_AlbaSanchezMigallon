package vista;

import javax.swing.DefaultListModel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Vista extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane, panelInicio, panelCocteleria, panelCaja, panelPedido, panelInventario, panelMusica,
			panelPedidoNuevo, panelPagarPedido, panelUsuarioCaja;
	public JLabel lblInicio, lblRefrescosInventario, lblCervezasInventario, lblBotellasInventario,
			labelRetroalimentacionContrasenia, lblCocktelsInventario, lblVinosInventario, lblAperitivosInventario,
			lblIngredientesInventario, lblFondoTPV, lblPagado, lblPedidoDisponible;
	public JList listRefrescos, listCerveza, listBotellas, listCocktels, listVinos, listAperitivos, listIngredientes,
			listPedido, listRefrescospanelPedidoNuevo, listCervezaspanelPedidoNuevo, listAperitivospanelPedidoNuevo,
			listBotellaspanelPedidoNuevo, listCocktelspanelPedidoNuevo, listVinopanelPedidoNuevo, listPedidos;
	public JButton btnCaja, btnPedido, btnInventario, btnMusica, btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5,
			btnMesa6, btnMesa7, btnAceptarCambios, btnRevertirCambios, btnRefrescos, btnAnadirAlPedido, btnCervezas,
			btnAperitivos, btnVino, btnCocktels, btnVolverInicio, btnVolverInicio2, btnCierreCaja, btnArqueo,
			btnPagarPedido, btnVolverCaja, btnQuitar;
	public JSpinner spinnerCantidadRefrescos, spinnerCantidadCerveza, spinnerCantidadBotellas, spinnerCantidadVinos,
			spinnerCantidadAperitivos, spinnerCantidadIngredientes;
	public JList<String> listPedidoMesa;
	public JScrollBar verticalScrollBarRefrescospanelPedidoNuevo, verticalScrollBarIngredientes,
			verticalScrollBarAperitivos, verticalScrollBarCocktels, verticalScrollBarBotellas,
			verticalScrollBarPedidoMesa, verticalScrollBarCervezaspanelPedidoNuevo, verticalScrollBarPedido,
			verticalScrollBarAperitivospanelPedidoNuevo, verticalScrollBarVinos, verticalScrollBarInventario,
			verticalScrollBarBotellaspanelPedidoNuevo, verticalScrollBarCocktelspanelPedidoNuevo,
			verticalScrollBarVinopanelPedidoNuevo, verticalScrollBarRefrescos;
	public JScrollPane scrollPaneRefrescospanelPedidoNuevo, scrollPaneIngredientes, scrollPaneAperitivos,
			scrollPaneVinos, scrollPaneCocktels, scrollPanePedidoMesa, scrollPanelCervezaspanelPedidoNuevo,
			scrollPanePedido, scrollPaneAperitivospanelPedidoNuevo, scrollPaneBotellaspanelPedidoNuevo,
			scrollPaneCocktelspanelPedidoNuevo, scrollPaneInventario, scrollPaneBotellas,
			scrollPaneVinopanelPedidoNuevo, scrollPaneRefrescos, scrollPanePedidos;
	public JComboBox comboBoxMesa, comboBoxMusica;
	public JButton btnVolverACaja;
	public JButton btnVolver;
	public JButton btnAgregar;
	public JPasswordField passwordField;
	public JButton btnAceptarContrasenia;
	public JButton btnVolverContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
					Controlador controlador = new Controlador(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*---------------------------------PANEL INICIO---------------------------------------------------*/
		
		panelUsuarioCaja = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				Image image = new ImageIcon(
						"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo_efapolitan2.jpg")
						.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelUsuarioCaja.setBounds(0, 0, 1684, 861);
		contentPane.add(panelUsuarioCaja);
		panelUsuarioCaja.setOpaque(false);
		panelUsuarioCaja.setLayout(null);
		panelUsuarioCaja.setVisible(false);
		
		
		panelInicio = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				Image image = new ImageIcon(
						"resources/fondo_efapolitan_.jpg")
						.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelInicio.setBounds(0, 0, 1684, 861);
		contentPane.add(panelInicio);
		panelInicio.setOpaque(false);
		panelInicio.setLayout(null);

		btnCaja = new JButton("CAJA");
		btnCaja.setBounds(1225, 199, 317, 129);
		btnCaja.setForeground(new Color(193, 154, 71));
		btnCaja.setFont(new Font("Arial", Font.BOLD, 18));
		btnCaja.setFocusPainted(false);
		btnCaja.setOpaque(false);
		btnCaja.setContentAreaFilled(false);
		btnCaja.setBorderPainted(true);
		panelInicio.add(btnCaja);

		btnInventario = new JButton("INVENTARIO");
		btnInventario.setBounds(1225, 416, 317, 129);
		btnInventario.setForeground(new Color(193, 154, 71));
		btnInventario.setFont(new Font("Arial", Font.BOLD, 18));
		btnInventario.setFocusPainted(false);
		btnInventario.setOpaque(false);
		btnInventario.setContentAreaFilled(false);
		btnInventario.setBorderPainted(true);
		panelInicio.add(btnInventario);

		btnMusica = new JButton("MUSICA");
		btnMusica.setBounds(1225, 641, 317, 129);
		btnMusica.setForeground(new Color(193, 154, 71));
		btnMusica.setFont(new Font("Arial", Font.BOLD, 18));
		btnMusica.setFocusPainted(false);
		btnMusica.setOpaque(false);
		btnMusica.setContentAreaFilled(false);
		btnMusica.setBorderPainted(true);
		panelInicio.add(btnMusica);
		panelCocteleria = new JPanel();
		panelCocteleria.setBounds(135, 135, 1031, 597);
		panelInicio.add(panelCocteleria);
		panelCocteleria.setLayout(null);
		panelCocteleria.setOpaque(false);
		panelInicio.add(panelCocteleria);

		btnMesa4 = new JButton();
		btnMesa4.setBounds(708, 396, 136, 117);
		panelCocteleria.add(btnMesa4);
		btnMesa4.setBackground(new Color(255, 255, 255));
		btnMesa4.setIcon(new ImageIcon(
				"resources/mesaAlba.png"));
		btnMesa4.setOpaque(false);
		btnMesa4.setContentAreaFilled(false);
		btnMesa4.setBorderPainted(true);
		panelCocteleria.add(btnMesa4);

		btnMesa5 = new JButton();
		btnMesa5.setBounds(455, 396, 136, 117);
		panelCocteleria.add(btnMesa5);
		btnMesa5.setBackground(new Color(255, 255, 255));
		btnMesa5.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\mesaAlba.png"));
		btnMesa5.setOpaque(false);
		btnMesa5.setContentAreaFilled(false);
		btnMesa5.setBorderPainted(true);
		panelCocteleria.add(btnMesa5);

		btnMesa6 = new JButton();
		btnMesa6.setBounds(195, 396, 136, 117);
		panelCocteleria.add(btnMesa6);
		btnMesa6.setBackground(new Color(255, 255, 255));
		btnMesa6.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\mesaAlba.png"));
		btnMesa6.setOpaque(false);
		btnMesa6.setContentAreaFilled(false);
		btnMesa6.setBorderPainted(true);
		panelCocteleria.add(btnMesa6);

		btnMesa3 = new JButton();
		btnMesa3.setBounds(814, 117, 136, 117);
		panelCocteleria.add(btnMesa3);
		btnMesa3.setBackground(new Color(255, 255, 255));
		btnMesa3.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\mesaAlba.png"));
		btnMesa3.setOpaque(false);
		btnMesa3.setContentAreaFilled(false);
		btnMesa3.setBorderPainted(true);
		panelCocteleria.add(btnMesa3);

		btnMesa2 = new JButton();
		btnMesa2.setBounds(575, 117, 136, 117);
		panelCocteleria.add(btnMesa2);
		btnMesa2.setBackground(new Color(255, 255, 255));
		btnMesa2.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\mesaAlba.png"));
		btnMesa2.setOpaque(false);
		btnMesa2.setContentAreaFilled(false);
		btnMesa2.setBorderPainted(true);
		panelCocteleria.add(btnMesa2);

		btnMesa1 = new JButton();
		btnMesa1.setBounds(315, 117, 136, 117);
		panelCocteleria.add(btnMesa1);
		btnMesa1.setBackground(new Color(255, 255, 255));
		btnMesa1.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\mesaAlba.png"));
		btnMesa1.setOpaque(false);
		btnMesa1.setContentAreaFilled(false);
		btnMesa1.setBorderPainted(true);
		panelCocteleria.add(btnMesa1);

		btnMesa7 = new JButton();
		btnMesa7.setBounds(60, 117, 136, 117);
		panelCocteleria.add(btnMesa7);
		btnMesa7.setBackground(new Color(255, 255, 255));
		btnMesa7.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\mesaAlba.png"));
		// btnMesa7.setOpaque(false);
		btnMesa7.setContentAreaFilled(false);
		btnMesa7.setBorderPainted(true);
		panelCocteleria.add(btnMesa7);
		// ----------------------------------FIN DEFINICION DE ELEMENTOS DE PANEL
		// INVENTARIO------------------

		// ---------------------------------PANEL
		// CAJA---------------------------------------------------

		panelCaja = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				Image image = new ImageIcon(
						"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo_efapolitan2.jpg")
						.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelCaja.setBounds(0, 0, 1684, 861);
		contentPane.add(panelCaja);
		panelCaja.setOpaque(false);
		panelCaja.setLayout(null);
		panelCaja.setVisible(false);

		btnVolverCaja = new JButton("VOLVER");
		btnVolverCaja.setBounds(57, 34, 208, 91);
		btnVolverCaja.setFont(new Font("Arial", Font.BOLD, 18));
		btnVolverCaja.setFocusPainted(false);
		btnVolverCaja.setOpaque(false);
		btnVolverCaja.setContentAreaFilled(false);
		btnVolverCaja.setBorderPainted(true);
		btnVolverCaja.setForeground(new Color(193, 154, 71));
		panelCaja.add(btnVolverCaja);

		btnPagarPedido = new JButton("PAGAR PEDIDO");
		btnPagarPedido.setBounds(1246, 399, 225, 103);
		btnPagarPedido.setFont(new Font("Arial", Font.BOLD, 18));
		btnPagarPedido.setFocusPainted(false);
		btnPagarPedido.setOpaque(false);
		btnPagarPedido.setContentAreaFilled(false);
		btnPagarPedido.setBorderPainted(true);
		btnPagarPedido.setForeground(new Color(193, 154, 71));
		panelCaja.add(btnPagarPedido);

		lblPagado = new JLabel("");
		lblPagado.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblPagado.setBounds(944, 236, 225, 42);
		lblPagado.setVisible(false);
		panelCaja.add(lblPagado);

		btnArqueo = new JButton("ARQUEO");
		btnArqueo.setBounds(1246, 150, 225, 103);
		btnArqueo.setFont(new Font("Arial", Font.BOLD, 18));
		btnArqueo.setFocusPainted(false);
		btnArqueo.setOpaque(false);
		btnArqueo.setContentAreaFilled(false);
		btnArqueo.setBorderPainted(true);
		btnArqueo.setForeground(new Color(193, 154, 71));
		panelCaja.add(btnArqueo);

		btnCierreCaja = new JButton("CIERRE CAJA");
		btnCierreCaja.setBounds(1246, 648, 225, 103);
		btnCierreCaja.setFont(new Font("Arial", Font.BOLD, 18));
		btnCierreCaja.setFocusPainted(false);
		btnCierreCaja.setOpaque(false);
		btnCierreCaja.setContentAreaFilled(false);
		btnCierreCaja.setBorderPainted(true);
		btnCierreCaja.setForeground(new Color(193, 154, 71));
		panelCaja.add(btnCierreCaja);

		listPedidos = new JList();
		listPedidos.setBounds(71, 49, 261, 72);

		scrollPanePedidos = new JScrollPane(listPedidos);
		scrollPanePedidos.setBounds(614, 256, 490, 387);
		panelCaja.add(scrollPanePedidos);
		contentPane.add(panelUsuarioCaja);
		panelUsuarioCaja.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setBounds(659, 364, 238, 47);
		panelUsuarioCaja.add(passwordField);

		labelRetroalimentacionContrasenia = new JLabel();
		labelRetroalimentacionContrasenia.setBounds(659, 274, 459, 25);
		labelRetroalimentacionContrasenia.setText("Introduzca la contrasenia para hacer cierre de caja:");
		labelRetroalimentacionContrasenia.setFont(new Font("Arial", Font.BOLD, 18));
		labelRetroalimentacionContrasenia.setOpaque(false);
		labelRetroalimentacionContrasenia.setForeground(new Color(193, 154, 71));
		panelUsuarioCaja.add(labelRetroalimentacionContrasenia);

		btnAceptarContrasenia = new JButton("ACEPTAR");
		btnAceptarContrasenia.setBounds(940, 362, 155, 47);
		btnAceptarContrasenia.setFont(new Font("Arial", Font.BOLD, 18));
		btnAceptarContrasenia.setFocusPainted(false);
		btnAceptarContrasenia.setOpaque(false);
		btnAceptarContrasenia.setContentAreaFilled(false);
		btnAceptarContrasenia.setBorderPainted(true);
		btnAceptarContrasenia.setForeground(new Color(193, 154, 71));
		panelUsuarioCaja.add(btnAceptarContrasenia);
		
		btnVolverContrasenia = new JButton("VOLVER");
		// btnVolverACaja.setBounds(125, 65, 189, 62);
		btnVolverContrasenia.setBounds(57, 34, 208, 91);
		btnVolverContrasenia.setFont(new Font("Arial", Font.BOLD, 18));
		btnVolverContrasenia.setFocusPainted(false);
		btnVolverContrasenia.setOpaque(false);
		btnVolverContrasenia.setContentAreaFilled(false);
		btnVolverContrasenia.setBorderPainted(true);
		btnVolverContrasenia.setForeground(new Color(193, 154, 71));
		panelUsuarioCaja.add(btnVolverContrasenia);

		/*
		 * lblFondoTPV = new JLabel(""); lblFondoTPV.setBounds(0, 0, 1684, 861);
		 * lblFondoTPV.setIcon(new ImageIcon(
		 * "C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo_efapolitan_.jpg"
		 * )); panelInicio.add(lblFondoTPV);
		 */
		/*---------------------------------DEFINICION ELEMENTOS PANEL INICIO---------------------------------------------------*/

		/*
		 * lblInicio = new JLabel("INICIO"); lblInicio.setFont(new Font("Garamond",
		 * Font.ITALIC, 54)); lblInicio.setBounds(431, 36, 169, 55);
		 * panelInicio.add(lblInicio);
		 */

		/*
		 * metemos los pedidos en caja, aqui no hacen falta btnPedido = new
		 * JButton("PEDIDO"); btnPedido.setBounds(1270, 286, 317, 129);
		 * btnPedido.setForeground(new Color(193, 154, 71)); btnPedido.setFont(new
		 * Font("Arial", Font.BOLD, 18)); btnPedido.setFocusPainted(false);
		 * btnPedido.setOpaque(false); btnPedido.setContentAreaFilled(false);
		 * btnPedido.setBorderPainted(true); panelInicio.add(btnPedido);
		 */
		/*---------------------------------PANEL COCTELERIA---------------------------------------------------*/

		// ---------------------------------PANEL
		// INVENTARIO-----------------------------------------------
		
		panelInventario = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				Image image = new ImageIcon(
						"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo_efapolitan2.jpg")
						.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelInventario.setBounds(0, 0, 1684, 861);
		contentPane.add(panelInventario);
		panelInventario.setOpaque(false);
		panelInventario.setLayout(null);
		panelInventario.setVisible(false);
		// ------------------------------------------------------------------------------------------------
		// ----------------------------------DEFINICION DE ELEMENTOS DE PANEL
		// INVENTARIO-------------------
		lblRefrescosInventario = new JLabel("REFRESCOS");
		lblRefrescosInventario.setBounds(450, 218, 135, 30);
		lblRefrescosInventario.setOpaque(false);
		lblRefrescosInventario.setForeground(new Color(193, 154, 71));
		lblRefrescosInventario.setFont(new Font("Arial", Font.BOLD, 18));
		panelInventario.add(lblRefrescosInventario);

		listRefrescos = new JList();
		listRefrescos.setBounds(371, 259, 261, 72);

		scrollPaneRefrescos = new JScrollPane(listRefrescos);
		scrollPaneRefrescos.setBounds(371, 259, 261, 72);
		panelInventario.add(scrollPaneRefrescos);

		verticalScrollBarRefrescos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneRefrescos.setVerticalScrollBar(verticalScrollBarRefrescos);

		spinnerCantidadRefrescos = new JSpinner();
		spinnerCantidadRefrescos.setBounds(640, 259, 39, 33);
		panelInventario.add(spinnerCantidadRefrescos);
		spinnerCantidadRefrescos.setVisible(false);
		// ------------------------------------------------------------------------------------
		lblCervezasInventario = new JLabel("CERVEZAS");
		lblCervezasInventario.setBounds(450, 348, 135, 30);
		lblCervezasInventario.setOpaque(false);
		lblCervezasInventario.setForeground(new Color(193, 154, 71));
		lblCervezasInventario.setFont(new Font("Arial", Font.BOLD, 18));
		panelInventario.add(lblCervezasInventario);

		listCerveza = new JList();
		listCerveza.setBounds(371, 389, 261, 72);

		scrollPaneInventario = new JScrollPane(listCerveza);
		scrollPaneInventario.setBounds(371, 389, 261, 72);
		panelInventario.add(scrollPaneInventario);

		verticalScrollBarInventario = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneInventario.setVerticalScrollBar(verticalScrollBarInventario);

		spinnerCantidadCerveza = new JSpinner();
		spinnerCantidadCerveza.setBounds(640, 389, 39, 33);
		panelInventario.add(spinnerCantidadCerveza);
		spinnerCantidadCerveza.setVisible(false);
		// ------------------------------------------------------------------------------------

		lblBotellasInventario = new JLabel("BOTELLAS");
		lblBotellasInventario.setBounds(450, 478, 135, 30);
		lblBotellasInventario.setOpaque(false);
		lblBotellasInventario.setForeground(new Color(193, 154, 71));
		lblBotellasInventario.setFont(new Font("Arial", Font.BOLD, 18));
		panelInventario.add(lblBotellasInventario);

		listBotellas = new JList();
		listBotellas.setBounds(371, 519, 261, 72);

		scrollPaneBotellas = new JScrollPane(listBotellas);
		scrollPaneBotellas.setBounds(371, 519, 261, 72);
		panelInventario.add(scrollPaneBotellas);

		verticalScrollBarBotellas = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneBotellas.setVerticalScrollBar(verticalScrollBarBotellas);

		spinnerCantidadBotellas = new JSpinner();
		spinnerCantidadBotellas.setBounds(640, 519, 39, 33);
		panelInventario.add(spinnerCantidadBotellas);
		spinnerCantidadBotellas.setVisible(false);

		// -----------------------------------------------------------------------------------
		lblVinosInventario = new JLabel("VINOS");
		lblVinosInventario.setBounds(1034, 478, 135, 30);
		lblVinosInventario.setOpaque(false);
		lblVinosInventario.setForeground(new Color(193, 154, 71));
		lblVinosInventario.setFont(new Font("Arial", Font.BOLD, 18));
		panelInventario.add(lblVinosInventario);

		listVinos = new JList();
		listVinos.setBounds(938, 519, 261, 72);

		scrollPaneVinos = new JScrollPane(listVinos);
		scrollPaneVinos.setBounds(938, 519, 261, 72);
		panelInventario.add(scrollPaneVinos);

		verticalScrollBarVinos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneVinos.setVerticalScrollBar(verticalScrollBarVinos);

		spinnerCantidadVinos = new JSpinner();
		spinnerCantidadVinos.setBounds(1209, 519, 39, 33);
		panelInventario.add(spinnerCantidadVinos);
		spinnerCantidadVinos.setVisible(false);

		// ------------------------------------------------------------------------------------
		lblAperitivosInventario = new JLabel("APERITIVOS");
		lblAperitivosInventario.setBounds(1012, 348, 135, 30);
		lblAperitivosInventario.setOpaque(false);
		lblAperitivosInventario.setForeground(new Color(193, 154, 71));
		lblAperitivosInventario.setFont(new Font("Arial", Font.BOLD, 18));
		panelInventario.add(lblAperitivosInventario);

		listAperitivos = new JList();
		listAperitivos.setBounds(938, 389, 261, 72);

		scrollPaneAperitivos = new JScrollPane(listAperitivos);
		scrollPaneAperitivos.setBounds(938, 389, 261, 72);
		panelInventario.add(scrollPaneAperitivos);

		verticalScrollBarAperitivos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneAperitivos.setVerticalScrollBar(verticalScrollBarAperitivos);

		spinnerCantidadAperitivos = new JSpinner();
		spinnerCantidadAperitivos.setBounds(1209, 389, 39, 33);
		panelInventario.add(spinnerCantidadAperitivos);
		spinnerCantidadAperitivos.setVisible(false);

		// ------------------------------------------------------------------------------------
		lblIngredientesInventario = new JLabel("INGREDIENTES");
		lblIngredientesInventario.setBounds(1012, 218, 135, 30);
		lblIngredientesInventario.setOpaque(false);
		lblIngredientesInventario.setForeground(new Color(193, 154, 71));
		lblIngredientesInventario.setFont(new Font("Arial", Font.BOLD, 18));
		panelInventario.add(lblIngredientesInventario);

		listIngredientes = new JList();
		listIngredientes.setBounds(371, 259, 261, 72);

		scrollPaneIngredientes = new JScrollPane(listIngredientes);
		scrollPaneIngredientes.setBounds(938, 259, 261, 72);
		panelInventario.add(scrollPaneIngredientes);

		verticalScrollBarIngredientes = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneIngredientes.setVerticalScrollBar(verticalScrollBarIngredientes);

		spinnerCantidadIngredientes = new JSpinner();
		spinnerCantidadIngredientes.setBounds(1209, 259, 39, 33);
		panelInventario.add(spinnerCantidadIngredientes);
		spinnerCantidadIngredientes.setVisible(false);
		// ------------------------------------------------------------------------------------

		btnAceptarCambios = new JButton("ACEPTAR CAMBIOS");
		btnAceptarCambios.setBounds(1343, 259, 279, 85);
		btnAceptarCambios.setFont(new Font("Arial", Font.BOLD, 18));
		btnAceptarCambios.setFocusPainted(false);
		btnAceptarCambios.setOpaque(false);
		btnAceptarCambios.setContentAreaFilled(false);
		btnAceptarCambios.setBorderPainted(true);
		btnAceptarCambios.setForeground(new Color(193, 154, 71));
		panelInventario.add(btnAceptarCambios);

		btnRevertirCambios = new JButton("VOLVER");
		btnRevertirCambios.setBounds(57, 34, 208, 91);
		btnRevertirCambios.setFont(new Font("Arial", Font.BOLD, 18));
		btnRevertirCambios.setFocusPainted(false);
		btnRevertirCambios.setOpaque(false);
		btnRevertirCambios.setContentAreaFilled(false);
		btnRevertirCambios.setBorderPainted(true);
		btnRevertirCambios.setForeground(new Color(193, 154, 71));
		panelInventario.add(btnRevertirCambios);

		// ------------------------PANEL PAGAR PEDIDO, DENTRO DE
		// CAJA---------------------------------------
		panelPagarPedido = new JPanel();
		panelPagarPedido.setBounds(0, 0, 1684, 861);
		contentPane.add(panelPagarPedido);
		panelPagarPedido.setLayout(null);
		panelPagarPedido.setVisible(false);

		btnVolverACaja = new JButton("VOLVER");
		// btnVolverACaja.setBounds(125, 65, 189, 62);
		btnVolverACaja.setBounds(57, 34, 208, 91);
		btnVolverACaja.setFont(new Font("Arial", Font.BOLD, 18));
		btnVolverACaja.setFocusPainted(false);
		btnVolverACaja.setOpaque(false);
		btnVolverACaja.setContentAreaFilled(false);
		btnVolverACaja.setBorderPainted(true);
		btnVolverACaja.setForeground(new Color(193, 154, 71));
		panelPagarPedido.add(btnVolverACaja);

		// ---------------------------------PANEL PEDIDO
		// NUEVO---------------------------------------------------

		panelPedidoNuevo = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				Image image = new ImageIcon(
						"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo_efapolitan2.jpg")
						.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelPedidoNuevo.setBounds(0, 0, 1684, 861);
		contentPane.add(panelPedidoNuevo);
		panelPedidoNuevo.setLayout(null);

		btnRefrescos = new JButton("REFRESCOS");
		btnRefrescos.setBounds(57, 207, 205, 158);
		btnRefrescos.setFont(new Font("Arial", Font.BOLD, 18));
		btnRefrescos.setFocusPainted(false);
		btnRefrescos.setOpaque(false);
		btnRefrescos.setContentAreaFilled(false);
		btnRefrescos.setBorderPainted(true);
		btnRefrescos.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnRefrescos);
		panelPedidoNuevo.setVisible(false);

		DefaultListModel<String> modelPedido = new DefaultListModel<>();

		btnVolverInicio = new JButton("VOLVER A INICIO");
		btnVolverInicio.setBounds(57, 34, 208, 91);
		btnVolverInicio.setFont(new Font("Arial", Font.BOLD, 18));
		btnVolverInicio.setFocusPainted(false);
		btnVolverInicio.setOpaque(false);
		btnVolverInicio.setContentAreaFilled(false);
		btnVolverInicio.setBorderPainted(true);
		btnVolverInicio.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnVolverInicio);

		btnAnadirAlPedido = new JButton("AÑADIR AL PEDIDO");
		btnAnadirAlPedido.setBounds(1313, 149, 257, 90);
		btnAnadirAlPedido.setFont(new Font("Arial", Font.BOLD, 18));
		btnAnadirAlPedido.setFocusPainted(false);
		btnAnadirAlPedido.setOpaque(false);
		btnAnadirAlPedido.setContentAreaFilled(false);
		btnAnadirAlPedido.setBorderPainted(true);
		btnAnadirAlPedido.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnAnadirAlPedido);

		lblPedidoDisponible = new JLabel("El pedido no es posible. Insuficiente stock");
		lblPedidoDisponible.setBounds(1301, 540, 322, 47);
		lblPedidoDisponible.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblPedidoDisponible.setVisible(false);
		panelPedidoNuevo.add(lblPedidoDisponible);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(1084, 284, 145, 90);
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 18));
		btnAgregar.setFocusPainted(false);
		btnAgregar.setOpaque(false);
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorderPainted(true);
		btnAgregar.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnAgregar);

		btnQuitar = new JButton("QUITAR");
		btnQuitar.setBounds(1084, 412, 145, 90);
		btnQuitar.setFont(new Font("Arial", Font.BOLD, 18));
		btnQuitar.setFocusPainted(false);
		btnQuitar.setOpaque(false);
		btnQuitar.setContentAreaFilled(false);
		btnQuitar.setBorderPainted(true);
		btnQuitar.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnQuitar);

		scrollPanelCervezaspanelPedidoNuevo = new JScrollPane();
		scrollPanelCervezaspanelPedidoNuevo.setBounds(611, 250, 397, 279);
		panelPedidoNuevo.add(scrollPanelCervezaspanelPedidoNuevo);

		verticalScrollBarCervezaspanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanelCervezaspanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarCervezaspanelPedidoNuevo);

		listCervezaspanelPedidoNuevo = new JList();
		listCervezaspanelPedidoNuevo.setBounds(611, 250, 397, 279);
		scrollPanelCervezaspanelPedidoNuevo.setViewportView(listCervezaspanelPedidoNuevo);
		listCervezaspanelPedidoNuevo.setVisible(false);
		scrollPanelCervezaspanelPedidoNuevo.setVisible(false);

		btnCervezas = new JButton("CERVEZAS");
		btnCervezas.setBounds(297, 207, 205, 158);
		btnCervezas.setFont(new Font("Arial", Font.BOLD, 18));
		btnCervezas.setFocusPainted(false);
		btnCervezas.setOpaque(false);
		btnCervezas.setContentAreaFilled(false);
		btnCervezas.setBorderPainted(true);
		btnCervezas.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnCervezas);

		btnCocktels = new JButton("COCKTELS");
		btnCocktels.setBounds(297, 423, 205, 158);
		btnCocktels.setFont(new Font("Arial", Font.BOLD, 18));
		btnCocktels.setFocusPainted(false);
		btnCocktels.setOpaque(false);
		btnCocktels.setContentAreaFilled(false);
		btnCocktels.setBorderPainted(true);
		btnCocktels.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnCocktels);

		btnVino = new JButton("VINOS");
		btnVino.setBounds(57, 423, 205, 158);
		btnVino.setFont(new Font("Arial", Font.BOLD, 18));
		btnVino.setFocusPainted(false);
		btnVino.setOpaque(false);
		btnVino.setContentAreaFilled(false);
		btnVino.setBorderPainted(true);
		btnVino.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnVino);

		btnAperitivos = new JButton("APERITIVOS");
		btnAperitivos.setBounds(57, 639, 205, 158);
		btnAperitivos.setFont(new Font("Arial", Font.BOLD, 18));
		btnAperitivos.setFocusPainted(false);
		btnAperitivos.setOpaque(false);
		btnAperitivos.setContentAreaFilled(false);
		btnAperitivos.setBorderPainted(true);
		btnAperitivos.setForeground(new Color(193, 154, 71));
		panelPedidoNuevo.add(btnAperitivos);
		// --------------------------------- DEFINICION PANEL PEDIDO
		// NUEVO---------------------------------------------------

		listRefrescospanelPedidoNuevo = new JList();
		listRefrescospanelPedidoNuevo.setBounds(611, 250, 397, 279);
		scrollPaneRefrescospanelPedidoNuevo = new JScrollPane();
		scrollPaneRefrescospanelPedidoNuevo.setViewportView(listRefrescospanelPedidoNuevo);

		scrollPaneRefrescospanelPedidoNuevo.setBounds(611, 250, 397, 279);

		panelPedidoNuevo.add(scrollPaneRefrescospanelPedidoNuevo);

		verticalScrollBarRefrescospanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneRefrescospanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarRefrescospanelPedidoNuevo);
		listRefrescospanelPedidoNuevo.setVisible(false);
		scrollPaneRefrescospanelPedidoNuevo.setVisible(false);

		listPedidoMesa = new JList();
		listPedidoMesa = new JList<>(modelPedido);
		listPedidoMesa.setBounds(1243, 250, 397, 279);
		scrollPanePedidoMesa = new JScrollPane(listPedidoMesa);
		scrollPanePedidoMesa.setBounds(1243, 250, 397, 279);
		panelPedidoNuevo.add(scrollPanePedidoMesa);
		verticalScrollBarPedidoMesa = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanePedidoMesa.setVerticalScrollBar(verticalScrollBarPedidoMesa);

		listAperitivospanelPedidoNuevo = new JList();
		listAperitivospanelPedidoNuevo.setBounds(611, 250, 397, 279);
		scrollPaneAperitivospanelPedidoNuevo = new JScrollPane(listAperitivospanelPedidoNuevo);
		scrollPaneAperitivospanelPedidoNuevo.setBounds(611, 250, 397, 279);
		panelPedidoNuevo.add(scrollPaneAperitivospanelPedidoNuevo);

		verticalScrollBarAperitivospanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneAperitivospanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarAperitivospanelPedidoNuevo);

		listAperitivospanelPedidoNuevo.setVisible(false);
		scrollPaneAperitivospanelPedidoNuevo.setVisible(false);

		listBotellaspanelPedidoNuevo = new JList();
		listBotellaspanelPedidoNuevo.setBounds(611, 250, 397, 279);
		scrollPaneBotellaspanelPedidoNuevo = new JScrollPane();
		scrollPaneBotellaspanelPedidoNuevo.setViewportView(listBotellaspanelPedidoNuevo);

		scrollPaneBotellaspanelPedidoNuevo.setBounds(611, 250, 397, 279);
		panelPedidoNuevo.add(scrollPaneBotellaspanelPedidoNuevo);

		verticalScrollBarBotellaspanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneBotellaspanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarBotellaspanelPedidoNuevo);
		listBotellaspanelPedidoNuevo.setVisible(false);
		scrollPaneBotellaspanelPedidoNuevo.setVisible(false);

		listCocktelspanelPedidoNuevo = new JList();
		listCocktelspanelPedidoNuevo.setBounds(611, 250, 397, 279);
		scrollPaneCocktelspanelPedidoNuevo = new JScrollPane();
		scrollPaneCocktelspanelPedidoNuevo.setViewportView(listCocktelspanelPedidoNuevo);

		scrollPaneCocktelspanelPedidoNuevo.setBounds(611, 250, 397, 279);
		panelPedidoNuevo.add(scrollPaneCocktelspanelPedidoNuevo);

		verticalScrollBarCocktelspanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneCocktelspanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarCocktelspanelPedidoNuevo);
		listCocktelspanelPedidoNuevo.setVisible(false);
		scrollPaneCocktelspanelPedidoNuevo.setVisible(false);

		listVinopanelPedidoNuevo = new JList();
		listVinopanelPedidoNuevo.setBounds(611, 250, 397, 279);
		scrollPaneVinopanelPedidoNuevo = new JScrollPane();
		scrollPaneVinopanelPedidoNuevo.setViewportView(listVinopanelPedidoNuevo);

		scrollPaneVinopanelPedidoNuevo.setBounds(611, 250, 397, 279);
		panelPedidoNuevo.add(scrollPaneVinopanelPedidoNuevo);

		verticalScrollBarVinopanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneVinopanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarVinopanelPedidoNuevo);
		listVinopanelPedidoNuevo.setVisible(false);
		scrollPaneVinopanelPedidoNuevo.setVisible(false);
		// ---------------------------------PANEL
		// MUSICA---------------------------------------------------
		
		panelMusica = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				Image image = new ImageIcon(
						"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\resources\\fondo_efapolitan4.jpg")
						.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelMusica.setBounds(0, 0, 1684, 861);
		contentPane.add(panelMusica);
		panelMusica.setOpaque(false);
		panelMusica.setLayout(null);
		panelMusica.setVisible(false);
		// ---------------------------------
		

		comboBoxMusica = new JComboBox();
		comboBoxMusica.setBounds(640, 273, 467, 314);
		comboBoxMusica.setBackground(new Color(50, 50, 50));
		comboBoxMusica.setFont(new Font("Arial", Font.BOLD, 18));
		comboBoxMusica.setOpaque(false);
		comboBoxMusica.setForeground(new Color(193, 154, 71));
		panelMusica.add(comboBoxMusica);

		
		btnVolverInicio2 = new JButton("VOLVER INICIO");
		btnVolverInicio2.setBounds(57, 34, 208, 91);
		btnVolverInicio2.setFont(new Font("Arial", Font.BOLD, 18));
		btnVolverInicio2.setFocusPainted(false);
		btnVolverInicio2.setOpaque(false);
		btnVolverInicio2.setContentAreaFilled(false);
		btnVolverInicio2.setBorderPainted(true);
		btnVolverInicio2.setForeground(new Color(193, 154, 71));
		panelMusica.add(btnVolverInicio2);


	}
}
