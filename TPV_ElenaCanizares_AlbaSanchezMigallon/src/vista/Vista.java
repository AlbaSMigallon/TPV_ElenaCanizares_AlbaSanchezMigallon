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
	public JLabel lblInicio;
	public JList listRefrescos, listCerveza, listPedido, listRefrescospanelPedidoNuevo;
	public JButton btnCaja, btnPedido, btnInventario, btnMusica, btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5,
			btnMesa6, btnMesa7, btnBarra, btnAceptarCambios, btnRevertirCambios, btnRefrescos, btnAnadirAlPedido,btnVolverInicio;
	public JSpinner spinnerCantidadRefrescos, spinnerCantidadCerveza;
	public JList<String> listPedidoMesa;

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

		panelPedido = new JPanel();
		panelPedido.setBounds(0, 0, 1684, 861);
		contentPane.add(panelPedido);
		panelPedido.setLayout(null);
		panelPedido.setVisible(false);

		listPedido = new JList();
		listPedido.setBounds(1263, 46, 295, 336);

		JScrollPane scrollPanePedido = new JScrollPane(listPedido);
		scrollPanePedido.setBounds(1263, 46, 295, 336);
		panelPedido.add(scrollPanePedido);
		JScrollBar verticalScrollBarPedido = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanePedido.setHorizontalScrollBar(verticalScrollBarPedido);
		panelPedidoNuevo = new JPanel();
		panelPedidoNuevo.setBounds(0, 0, 1684, 861);
		contentPane.add(panelPedidoNuevo);
		panelPedidoNuevo.setLayout(null);

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
		spinnerCantidadRefrescos = new JSpinner();
		spinnerCantidadRefrescos.setBounds(340, 29, 39, 33);
		panelInventario.add(spinnerCantidadRefrescos);
		spinnerCantidadRefrescos.setVisible(false);
		/*------------------------------------------------------------------------------------*/

		listRefrescos = new JList();
		listRefrescos.setBounds(69, 29, 261, 72);

		JScrollPane scrollPaneRefrescos = new JScrollPane(listRefrescos);
		scrollPaneRefrescos.setBounds(69, 29, 261, 72);
		panelInventario.add(scrollPaneRefrescos);

		JScrollBar verticalScrollBarRefrescos = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneRefrescos.setHorizontalScrollBar(verticalScrollBarRefrescos);
		/*------------------------------------------------------------------------------------*/

		listCerveza = new JList();
		listCerveza.setBounds(71, 256, 259, 70);

		JScrollPane scrollPaneInventario = new JScrollPane(listCerveza);
		scrollPaneInventario.setBounds(71, 256, 259, 70);
		panelInventario.add(scrollPaneInventario);

		JScrollBar verticalScrollBarInventario = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneInventario.setHorizontalScrollBar(verticalScrollBarInventario);
		/*------------------------------------------------------------------------------------*/

		spinnerCantidadCerveza = new JSpinner();
		spinnerCantidadCerveza.setBounds(340, 278, 39, 33);
		panelInventario.add(spinnerCantidadCerveza);
		/*------------------------------------------------------------------------------------*/

		btnAceptarCambios = new JButton("ACEPTAR CAMBIOS");
		btnAceptarCambios.setBounds(614, 34, 151, 85);
		panelInventario.add(btnAceptarCambios);

		btnRevertirCambios = new JButton("REVERTIR CAMBIOS");
		btnRevertirCambios.setBounds(614, 224, 151, 85);
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

		/*---------------------------------PANEL PEDIDO NUEVO---------------------------------------------------*/
		btnRefrescos = new JButton("Refrescos");
		btnRefrescos.setBounds(587, 11, 170, 114);
		panelPedidoNuevo.add(btnRefrescos);
		panelPedidoNuevo.setVisible(false);

		listRefrescospanelPedidoNuevo = new JList();
		listRefrescospanelPedidoNuevo.setBounds(69, 29, 261, 72);

		JScrollPane scrollPaneRefrescospanelPedidoNuevo = new JScrollPane(listRefrescospanelPedidoNuevo);
		scrollPaneRefrescospanelPedidoNuevo.setBounds(69, 29, 261, 72);
		panelPedidoNuevo.add(scrollPaneRefrescospanelPedidoNuevo);

		JScrollBar verticalScrollBarRefrescospanelPedidoNuevo = new JScrollBar(JScrollBar.VERTICAL);
		scrollPaneRefrescospanelPedidoNuevo.setHorizontalScrollBar(verticalScrollBarRefrescospanelPedidoNuevo);

		listPedidoMesa = new JList();

		// Después del cambio
		DefaultListModel<String> modelPedido = new DefaultListModel<>();
		listPedidoMesa = new JList<>(modelPedido);

		listPedidoMesa.setBounds(200, 173, 397, 227);

		JScrollPane scrollPanePedidoMesa = new JScrollPane(listPedidoMesa);
		scrollPanePedidoMesa.setBounds(200, 173, 397, 227);
		panelPedidoNuevo.add(scrollPanePedidoMesa);

		JScrollBar verticalScrollBarPedidoMesa = new JScrollBar(JScrollBar.VERTICAL);
		scrollPanePedidoMesa.setVerticalScrollBar(verticalScrollBarPedidoMesa);

		btnAnadirAlPedido = new JButton("AÑADIR AL PEDIDO");
		btnAnadirAlPedido.setBounds(871, 40, 145, 90);
		panelPedidoNuevo.add(btnAnadirAlPedido);
		
		btnVolverInicio = new JButton("VOLVER A INICIO");
		btnVolverInicio.setBounds(0, 0, 89, 23);
		panelPedidoNuevo.add(btnVolverInicio);

		/*---------------------------------PANEL MUSICA---------------------------------------------------*/

		panelMusica = new JPanel();
		panelMusica.setBounds(0, 0, 1684, 861);
		contentPane.add(panelMusica);
		panelMusica.setLayout(null);
		panelMusica.setVisible(false);

	}
}
