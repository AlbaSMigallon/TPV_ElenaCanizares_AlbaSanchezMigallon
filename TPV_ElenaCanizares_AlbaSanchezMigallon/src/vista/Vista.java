package vista;

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

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		JPanel panelInicio = new JPanel();
		panelInicio.setBounds(0, 0, 1684, 861);
		contentPane.add(panelInicio);
		panelInicio.setLayout(null);

		JPanel panelCocteleria = new JPanel();
		panelCocteleria.setBounds(42, 133, 1031, 597);
		panelInicio.add(panelCocteleria);
		panelCocteleria.setLayout(null);
		panelInicio.add(panelCocteleria);

		JButton btnMesa4 = new JButton();
		btnMesa4.setBounds(628, 302, 136, 117);
		panelCocteleria.add(btnMesa4);
		btnMesa4.setBackground(new Color(255, 255, 255));
		btnMesa4.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa4.setOpaque(false);
		btnMesa4.setContentAreaFilled(false);
		btnMesa4.setBorderPainted(true);
		panelCocteleria.add(btnMesa4);

		JButton btnMesa5 = new JButton();
		btnMesa5.setBounds(388, 302, 136, 117);
		panelCocteleria.add(btnMesa5);
		btnMesa5.setBackground(new Color(255, 255, 255));
		btnMesa5.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa5.setOpaque(false);
		btnMesa5.setContentAreaFilled(false);
		btnMesa5.setBorderPainted(true);
		panelCocteleria.add(btnMesa5);

		JButton btnMesa6 = new JButton();
		btnMesa6.setBounds(109, 302, 136, 117);
		panelCocteleria.add(btnMesa6);
		btnMesa6.setBackground(new Color(255, 255, 255));
		btnMesa6.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa6.setOpaque(false);
		btnMesa6.setContentAreaFilled(false);
		btnMesa6.setBorderPainted(true);
		panelCocteleria.add(btnMesa6);

		JButton btnMesa3 = new JButton();
		btnMesa3.setBounds(751, 134, 136, 117);
		panelCocteleria.add(btnMesa3);
		btnMesa3.setBackground(new Color(255, 255, 255));
		btnMesa3.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa3.setOpaque(false);
		btnMesa3.setContentAreaFilled(false);
		btnMesa3.setBorderPainted(true);
		panelCocteleria.add(btnMesa3);

		JButton btnMesa2 = new JButton();
		btnMesa2.setBounds(489, 134, 136, 117);
		panelCocteleria.add(btnMesa2);
		btnMesa2.setBackground(new Color(255, 255, 255));
		btnMesa2.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa2.setOpaque(false);
		btnMesa2.setContentAreaFilled(false);
		btnMesa2.setBorderPainted(true);
		panelCocteleria.add(btnMesa2);

		JButton btnMesa1 = new JButton();
		btnMesa1.setBounds(247, 113, 136, 117);
		panelCocteleria.add(btnMesa1);
		btnMesa1.setBackground(new Color(255, 255, 255));
		btnMesa1.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa1.setOpaque(false);
		btnMesa1.setContentAreaFilled(false);
		btnMesa1.setBorderPainted(true);
		panelCocteleria.add(btnMesa1);

		JButton btnMesa7 = new JButton();
		btnMesa7.setBounds(34, 113, 136, 117);
		panelCocteleria.add(btnMesa7);
		btnMesa7.setBackground(new Color(255, 255, 255));
		btnMesa7.setIcon(new ImageIcon(
				"C:\\Users\\ELENA\\git\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\TPV_ElenaCanizares_AlbaSanchezMigallon\\src\\resources\\mesaAlba.png"));
		btnMesa7.setOpaque(false);
		btnMesa7.setContentAreaFilled(false);
		btnMesa7.setBorderPainted(true);
		panelCocteleria.add(btnMesa7);

	}
}
