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
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;

public class Vista extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane, panelInicio, panelCocteleria, panelCaja, panelPedido, panelInventario, panelMusica,
			panelPedidoNuevo;
	public JLabel lblInicio, lblRefrescosInventario, lblCervezasInventario, lblBotellasInventario,
			lblCocktelsInventario, lblVinosInventario, lblAperitivosInventario, lblIngredientesInventario;
	public JList listRefrescos, listCerveza, listBotellas, listCocktels, listVinos, listAperitivos, listIngredientes,
			listPedido, listRefrescospanelPedidoNuevo, listCervezaspanelPedidoNuevo, listAperitivospanelPedidoNuevo,
			listBotellaspanelPedidoNuevo, listCocktelspanelPedidoNuevo, listVinopanelPedidoNuevo;
	public JButton btnCaja, btnPedido, btnInventario, btnMusica, btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5,
			btnMesa6, btnMesa7, btnBarra, btnAceptarCambios, btnRevertirCambios, btnRefrescos, btnAnadirAlPedido,
			btnCervezas, btnAperitivos, btnVino, btnBotellas, btnCocktels, btnVolverInicio;
	public JSpinner spinnerCantidadRefrescos, spinnerCantidadCerveza, spinnerCantidadBotellas, spinnerCantidadCocktels,
			spinnerCantidadVinos, spinnerCantidadAperitivos, spinnerCantidadIngredientes;
	public JList<String> listPedidoMesa;
	public JScrollBar verticalScrollBarRefrescospanelPedidoNuevo, verticalScrollBarPedidoMesa,
			verticalScrollBarCervezaspanelPedidoNuevo, verticalScrollBarPedido,
			verticalScrollBarAperitivospanelPedidoNuevo, verticalScrollBarBotellaspanelPedidoNuevo,
			verticalScrollBarCocktelspanelPedidoNuevo, verticalScrollBarVinopanelPedidoNuevo;
	public JScrollPane scrollPaneRefrescospanelPedidoNuevo, scrollPanePedidoMesa, scrollPanelCervezaspanelPedidoNuevo,
			scrollPanePedido, scrollPaneAperitivospanelPedidoNuevo, scrollPaneBotellaspanelPedidoNuevo,
			scrollPaneCocktelspanelPedidoNuevo, scrollPaneVinopanelPedidoNuevo;
	public JComboBox comboBoxMesa, comboBoxMusica;

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
		panelPedidoNuevo = new JPanel();
		panelPedidoNuevo.setBounds(0, 0, 1684, 861);
		contentPane.add(panelPedidoNuevo);
		panelPedidoNuevo.setLayout(null);
		btnRefrescos = new JButton("REFRESCOS");
		btnRefrescos.setBounds(57, 144, 205, 158);
		panelPedidoNuevo.add(btnRefrescos);
		panelPedidoNuevo.setVisible(false);

		DefaultListModel<String> modelPedido = new DefaultListModel<>();

		btnAnadirAlPedido = new JButton("AÑADIR AL PEDIDO");
		btnAnadirAlPedido.setBounds(1318, 39, 145, 90);
		panelPedidoNuevo.add(btnAnadirAlPedido);

		btnVolverInicio = new JButton("VOLVER A INICIO");
		btnVolverInicio.setBounds(78, 39, 137, 58);
		panelPedidoNuevo.add(btnVolverInicio);

		scrollPanelCervezaspanelPedidoNuevo = new JScrollPane();
		scrollPanelCervezaspanelPedidoNuevo.setBounds(611, 300, 448, 300);
		panelPedidoNuevo.add(scrollPanelCervezaspanelPedidoNuevo);

		verticalScrollBarCervezaspanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanelCervezaspanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarCervezaspanelPedidoNuevo);

		listCervezaspanelPedidoNuevo = new JList();
		scrollPanelCervezaspanelPedidoNuevo.setViewportView(listCervezaspanelPedidoNuevo);
		listCervezaspanelPedidoNuevo.setVisible(false);
		scrollPanelCervezaspanelPedidoNuevo.setVisible(false);

		btnCervezas = new JButton("CERVEZAS");
		btnCervezas.setBounds(297, 144, 205, 158);
		panelPedidoNuevo.add(btnCervezas);

		btnBotellas = new JButton("BOTELLAS");
		btnBotellas.setBounds(57, 356, 205, 158);
		panelPedidoNuevo.add(btnBotellas);

		btnCocktels = new JButton("COCKTELS");
		btnCocktels.setBounds(297, 356, 205, 158);
		panelPedidoNuevo.add(btnCocktels);

		btnVino = new JButton("VINOS");
		btnVino.setBounds(57, 551, 205, 158);
		panelPedidoNuevo.add(btnVino);

		btnAperitivos = new JButton("APERITIVOS");
		btnAperitivos.setBounds(297, 551, 205, 158);
		panelPedidoNuevo.add(btnAperitivos);

		panelPedido = new JPanel();
		panelPedido.setBounds(0, 0, 1684, 861);
		contentPane.add(panelPedido);
		panelPedido.setLayout(null);
		panelPedido.setVisible(false);

		listPedido = new JList();
		listPedido.setBounds(1263, 46, 295, 336);

		scrollPanePedido = new JScrollPane(listPedido);
		scrollPanePedido.setBounds(1263, 46, 295, 336);
		panelPedido.add(scrollPanePedido);
		verticalScrollBarPedido = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanePedido.setHorizontalScrollBar(verticalScrollBarPedido);

		panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 1684, 861);
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);

		/*---------------------------------PANEL COCTELERIA---------------------------------------------------*/
		panelCocteleria = new JPanel();
		panelCocteleria.setBounds(42, 133, 1031, 597);
		panelInicio.add(panelCocteleria);
		panelCocteleria.setLayout(null);
		panelInicio.add(panelCocteleria);

		btnMesa4 = new JButton();
		btnMesa4.setBounds(703, 230, 136, 117);
		panelCocteleria.add(btnMesa4);
		btnMesa4.setBackground(new Color(255, 255, 255));
		btnMesa4.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa4.setOpaque(false);
		btnMesa4.setContentAreaFilled(false);
		btnMesa4.setBorderPainted(true);
		panelCocteleria.add(btnMesa4);

		btnMesa5 = new JButton();
		btnMesa5.setBounds(454, 230, 136, 117);
		panelCocteleria.add(btnMesa5);
		btnMesa5.setBackground(new Color(255, 255, 255));
		btnMesa5.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa5.setOpaque(false);
		btnMesa5.setContentAreaFilled(false);
		btnMesa5.setBorderPainted(true);
		panelCocteleria.add(btnMesa5);

		btnMesa6 = new JButton();
		btnMesa6.setBounds(200, 230, 136, 117);
		panelCocteleria.add(btnMesa6);
		btnMesa6.setBackground(new Color(255, 255, 255));
		btnMesa6.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa6.setOpaque(false);
		btnMesa6.setContentAreaFilled(false);
		btnMesa6.setBorderPainted(true);
		panelCocteleria.add(btnMesa6);

		btnMesa3 = new JButton();
		btnMesa3.setBounds(778, 64, 136, 117);
		panelCocteleria.add(btnMesa3);
		btnMesa3.setBackground(new Color(255, 255, 255));
		btnMesa3.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa3.setOpaque(false);
		btnMesa3.setContentAreaFilled(false);
		btnMesa3.setBorderPainted(true);
		panelCocteleria.add(btnMesa3);

		btnMesa2 = new JButton();
		btnMesa2.setBounds(559, 64, 136, 117);
		panelCocteleria.add(btnMesa2);
		btnMesa2.setBackground(new Color(255, 255, 255));
		btnMesa2.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa2.setOpaque(false);
		btnMesa2.setContentAreaFilled(false);
		btnMesa2.setBorderPainted(true);
		panelCocteleria.add(btnMesa2);

		btnMesa1 = new JButton();
		btnMesa1.setBounds(325, 64, 136, 117);
		panelCocteleria.add(btnMesa1);
		btnMesa1.setBackground(new Color(255, 255, 255));
		btnMesa1.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa1.setOpaque(false);
		btnMesa1.setContentAreaFilled(false);
		btnMesa1.setBorderPainted(true);
		panelCocteleria.add(btnMesa1);

		btnMesa7 = new JButton();
		btnMesa7.setBounds(95, 64, 136, 117);
		panelCocteleria.add(btnMesa7);
		btnMesa7.setBackground(new Color(255, 255, 255));
		btnMesa7.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa7.setOpaque(false);
		btnMesa7.setContentAreaFilled(false);
		btnMesa7.setBorderPainted(true);
		panelCocteleria.add(btnMesa7);

		btnBarra = new JButton("Barra");
		btnBarra.setBounds(73, 459, 862, 127);
		btnBarra.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\Barra.png"));
		btnBarra.setOpaque(false);
		btnBarra.setContentAreaFilled(false);
		btnBarra.setBorderPainted(true);
		panelCocteleria.add(btnBarra);
		/*---------------------------------PANEL INVENTARIO---------------------------------------------------*/
		panelInventario = new JPanel();
		panelInventario.setBounds(0, 0, 1684, 861);
		contentPane.add(panelInventario);
		panelInventario.setVisible(false);
		panelInventario.setLayout(null);
		/*------------------------------------------------------------------------------------*/

		/*------------------------------------------------------------------------------------*/
		lblRefrescosInventario = new JLabel("REFRESCOS");
		lblRefrescosInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblRefrescosInventario.setBounds(150, 4, 120, 30);
		panelInventario.add(lblRefrescosInventario);

		listRefrescos = new JList();
		listRefrescos.setBounds(71, 49, 261, 72);

		JScrollPane scrollPaneRefrescos = new JScrollPane(listRefrescos);
		scrollPaneRefrescos.setBounds(71, 49, 261, 72);
		panelInventario.add(scrollPaneRefrescos);

		JScrollBar verticalScrollBarRefrescos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneRefrescos.setVerticalScrollBar(verticalScrollBarRefrescos);

		spinnerCantidadRefrescos = new JSpinner();
		spinnerCantidadRefrescos.setBounds(340, 49, 39, 33);
		panelInventario.add(spinnerCantidadRefrescos);
		spinnerCantidadRefrescos.setVisible(false);
		/*------------------------------------------------------------------------------------*/
		lblCervezasInventario = new JLabel("CERVEZAS");
		lblCervezasInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblCervezasInventario.setBounds(150, 138, 120, 30);
		panelInventario.add(lblCervezasInventario);

		listCerveza = new JList();
		listCerveza.setBounds(71, 179, 261, 72);

		JScrollPane scrollPaneInventario = new JScrollPane(listCerveza);
		scrollPaneInventario.setBounds(71, 179, 261, 72);
		panelInventario.add(scrollPaneInventario);

		JScrollBar verticalScrollBarInventario = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneInventario.setVerticalScrollBar(verticalScrollBarInventario);

		spinnerCantidadCerveza = new JSpinner();
		spinnerCantidadCerveza.setBounds(340, 179, 39, 33);
		panelInventario.add(spinnerCantidadCerveza);
		spinnerCantidadCerveza.setVisible(false);
		/*------------------------------------------------------------------------------------*/

		lblBotellasInventario = new JLabel("BOTELLAS");
		lblBotellasInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblBotellasInventario.setBounds(150, 268, 120, 30);
		panelInventario.add(lblBotellasInventario);

		listBotellas = new JList();
		listBotellas.setBounds(71, 309, 261, 72);

		JScrollPane scrollPaneBotellas = new JScrollPane(listBotellas);
		scrollPaneBotellas.setBounds(71, 309, 261, 72);
		panelInventario.add(scrollPaneBotellas);

		JScrollBar verticalScrollBarBotellas = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneBotellas.setVerticalScrollBar(verticalScrollBarBotellas);

		spinnerCantidadBotellas = new JSpinner();
		spinnerCantidadBotellas.setBounds(340, 309, 39, 33);
		panelInventario.add(spinnerCantidadBotellas);
		spinnerCantidadBotellas.setVisible(false);

		/*------------------------------------------------------------------------------------*/

		lblCocktelsInventario = new JLabel("COCKTELS");
		lblCocktelsInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblCocktelsInventario.setBounds(150, 398, 120, 30);
		panelInventario.add(lblCocktelsInventario);

		listCocktels = new JList();
		listCocktels.setBounds(71, 439, 261, 72);

		JScrollPane scrollPaneCocktels = new JScrollPane(listCocktels);
		scrollPaneCocktels.setBounds(71, 439, 261, 72);
		panelInventario.add(scrollPaneCocktels);

		JScrollBar verticalScrollBarCocktels = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneCocktels.setVerticalScrollBar(verticalScrollBarCocktels);

		spinnerCantidadCocktels = new JSpinner();
		spinnerCantidadCocktels.setBounds(340, 439, 39, 33);
		panelInventario.add(spinnerCantidadCocktels);
		spinnerCantidadCocktels.setVisible(false);

		/*------------------------------------------------------------------------------------*/
		lblVinosInventario = new JLabel("VINOS");
		lblVinosInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblVinosInventario.setBounds(745, 268, 120, 30);
		panelInventario.add(lblVinosInventario);

		listVinos = new JList();
		listVinos.setBounds(638, 309, 261, 72);

		JScrollPane scrollPaneVinos = new JScrollPane(listVinos);
		scrollPaneVinos.setBounds(638, 309, 261, 72);
		panelInventario.add(scrollPaneVinos);

		JScrollBar verticalScrollBarVinos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneVinos.setVerticalScrollBar(verticalScrollBarVinos);

		spinnerCantidadVinos = new JSpinner();
		spinnerCantidadVinos.setBounds(909, 309, 39, 33);
		panelInventario.add(spinnerCantidadVinos);
		spinnerCantidadVinos.setVisible(false);

		/*------------------------------------------------------------------------------------*/
		lblAperitivosInventario = new JLabel("APERITIVOS");
		lblAperitivosInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblAperitivosInventario.setBounds(712, 134, 120, 30);
		panelInventario.add(lblAperitivosInventario);

		listAperitivos = new JList();
		listAperitivos.setBounds(638, 179, 261, 72);

		JScrollPane scrollPaneAperitivos = new JScrollPane(listAperitivos);
		scrollPaneAperitivos.setBounds(638, 179, 261, 72);
		panelInventario.add(scrollPaneAperitivos);

		JScrollBar verticalScrollBarAperitivos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneAperitivos.setVerticalScrollBar(verticalScrollBarAperitivos);

		spinnerCantidadAperitivos = new JSpinner();
		spinnerCantidadAperitivos.setBounds(909, 179, 39, 33);
		panelInventario.add(spinnerCantidadAperitivos);
		spinnerCantidadAperitivos.setVisible(false);

		/*------------------------------------------------------------------------------------*/
		lblIngredientesInventario = new JLabel("INGREDIENTES");
		lblIngredientesInventario.setFont(new Font("Garamond", Font.ITALIC, 20));
		lblIngredientesInventario.setBounds(712, 11, 120, 30);
		panelInventario.add(lblIngredientesInventario);

		listIngredientes = new JList();
		listIngredientes.setBounds(71, 829, 261, 72);

		JScrollPane scrollPaneIngredientes = new JScrollPane(listIngredientes);
		scrollPaneIngredientes.setBounds(638, 49, 261, 72);
		panelInventario.add(scrollPaneIngredientes);

		JScrollBar verticalScrollBarIngredientes = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneIngredientes.setVerticalScrollBar(verticalScrollBarIngredientes);

		spinnerCantidadIngredientes = new JSpinner();
		spinnerCantidadIngredientes.setBounds(909, 49, 39, 33);
		panelInventario.add(spinnerCantidadIngredientes);
		spinnerCantidadIngredientes.setVisible(false);
		/*------------------------------------------------------------------------------------*/

		btnAceptarCambios = new JButton("ACEPTAR CAMBIOS");
		btnAceptarCambios.setBounds(1133, 36, 151, 85);
		panelInventario.add(btnAceptarCambios);

		btnRevertirCambios = new JButton("REVERTIR CAMBIOS");
		btnRevertirCambios.setBounds(1133, 213, 151, 85);
		panelInventario.add(btnRevertirCambios);
		/*---------------------------------PANEL INICIO---------------------------------------------------*/

		lblInicio = new JLabel("INICIO");
		lblInicio.setFont(new Font("Garamond", Font.ITALIC, 54));
		lblInicio.setBounds(431, 36, 169, 55);
		panelInicio.add(lblInicio);

		btnCaja = new JButton("Caja");
		btnCaja.setBounds(1286, 112, 317, 129);
		panelInicio.add(btnCaja);

		btnPedido = new JButton("Pedido");
		btnPedido.setBounds(1286, 303, 317, 129);
		panelInicio.add(btnPedido);

		btnInventario = new JButton("Inventario");
		btnInventario.setBounds(1286, 487, 317, 129);
		panelInicio.add(btnInventario);

		btnMusica = new JButton("Musica");
		btnMusica.setBounds(1286, 667, 317, 129);
		panelInicio.add(btnMusica);
		/*---------------------------------PANEL CAJA---------------------------------------------------*/

		panelCaja = new JPanel();
		panelCaja.setBounds(0, 0, 1684, 861);
		contentPane.add(panelCaja);
		panelCaja.setLayout(null);
		panelCaja.setVisible(false);

		/*---------------------------------PANEL PEDIDO---------------------------------------------------*/
		comboBoxMesa = new JComboBox();
		comboBoxMesa.setBounds(243, 153, 295, 215);
		panelPedido.add(comboBoxMesa);
		/*---------------------------------PANEL PEDIDO NUEVO---------------------------------------------------*/

		listRefrescospanelPedidoNuevo = new JList();
		scrollPaneRefrescospanelPedidoNuevo = new JScrollPane();
		scrollPaneRefrescospanelPedidoNuevo.setViewportView(listRefrescospanelPedidoNuevo);

		scrollPaneRefrescospanelPedidoNuevo.setBounds(611, 300, 448, 300);
		panelPedidoNuevo.add(scrollPaneRefrescospanelPedidoNuevo);

		verticalScrollBarRefrescospanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneRefrescospanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarRefrescospanelPedidoNuevo);
		listRefrescospanelPedidoNuevo.setVisible(false);
		scrollPaneRefrescospanelPedidoNuevo.setVisible(false);

		listPedidoMesa = new JList();
		listPedidoMesa = new JList<>(modelPedido);
		listPedidoMesa.setBounds(1243, 175, 397, 279);
		scrollPanePedidoMesa = new JScrollPane(listPedidoMesa);
		scrollPanePedidoMesa.setBounds(1243, 175, 397, 279);
		panelPedidoNuevo.add(scrollPanePedidoMesa);
		verticalScrollBarPedidoMesa = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanePedidoMesa.setVerticalScrollBar(verticalScrollBarPedidoMesa);

		listAperitivospanelPedidoNuevo = new JList();
		listAperitivospanelPedidoNuevo.setBounds(611, 300, 448, 300);
		scrollPaneAperitivospanelPedidoNuevo = new JScrollPane(listAperitivospanelPedidoNuevo);
		// scrollPaneAperitivospanelPedidoNuevo.setViewportView(listAperitivospanelPedidoNuevo);
		scrollPaneAperitivospanelPedidoNuevo.setBounds(611, 300, 448, 300);
		panelPedidoNuevo.add(scrollPaneAperitivospanelPedidoNuevo);

		verticalScrollBarAperitivospanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneAperitivospanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarAperitivospanelPedidoNuevo);

		listAperitivospanelPedidoNuevo.setVisible(false);
		scrollPaneAperitivospanelPedidoNuevo.setVisible(false);

		listBotellaspanelPedidoNuevo = new JList();
		scrollPaneBotellaspanelPedidoNuevo = new JScrollPane();
		scrollPaneBotellaspanelPedidoNuevo.setViewportView(listBotellaspanelPedidoNuevo);

		scrollPaneBotellaspanelPedidoNuevo.setBounds(611, 300, 448, 300);
		panelPedidoNuevo.add(scrollPaneBotellaspanelPedidoNuevo);

		verticalScrollBarBotellaspanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneBotellaspanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarBotellaspanelPedidoNuevo);
		listBotellaspanelPedidoNuevo.setVisible(false);
		scrollPaneBotellaspanelPedidoNuevo.setVisible(false);

		listCocktelspanelPedidoNuevo = new JList();
		scrollPaneCocktelspanelPedidoNuevo = new JScrollPane();
		scrollPaneCocktelspanelPedidoNuevo.setViewportView(listCocktelspanelPedidoNuevo);

		scrollPaneCocktelspanelPedidoNuevo.setBounds(611, 300, 448, 300);
		panelPedidoNuevo.add(scrollPaneCocktelspanelPedidoNuevo);

		verticalScrollBarCocktelspanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneCocktelspanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarCocktelspanelPedidoNuevo);
		listCocktelspanelPedidoNuevo.setVisible(false);
		scrollPaneCocktelspanelPedidoNuevo.setVisible(false);

		listVinopanelPedidoNuevo = new JList();
		scrollPaneVinopanelPedidoNuevo = new JScrollPane();
		scrollPaneVinopanelPedidoNuevo.setViewportView(listVinopanelPedidoNuevo);

		scrollPaneVinopanelPedidoNuevo.setBounds(611, 300, 448, 300);
		panelPedidoNuevo.add(scrollPaneVinopanelPedidoNuevo);

		verticalScrollBarVinopanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneVinopanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarVinopanelPedidoNuevo);
		listVinopanelPedidoNuevo.setVisible(false);
		scrollPaneVinopanelPedidoNuevo.setVisible(false);
		/*---------------------------------PANEL MUSICA---------------------------------------------------*/

		panelMusica = new JPanel();
		panelMusica.setBounds(0, 0, 1684, 861);
		contentPane.add(panelMusica);
		panelMusica.setLayout(null);
		panelMusica.setVisible(false);
		
		comboBoxMusica = new JComboBox();
		comboBoxMusica.setBounds(513, 244, 467, 314);
		panelMusica.add(comboBoxMusica);
		panelMusica.setVisible(false);

	}
}
