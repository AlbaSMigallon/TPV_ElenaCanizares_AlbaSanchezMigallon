package controlador;

import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
