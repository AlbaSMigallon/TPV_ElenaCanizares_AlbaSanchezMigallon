package controlador;

import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.Vista;

public class Controlador implements ActionListener {
	Vista vista = new Vista();

	public Controlador(Vista vista) {
		this.vista = vista;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
