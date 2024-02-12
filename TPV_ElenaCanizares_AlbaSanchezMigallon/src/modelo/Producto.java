package modelo;

import java.util.Objects;

public abstract class Producto {
	/*
	 * Clase abstracta padre de los tipos de productos del local, Clases: Aperitivo,
	 * Botella, Carveza, Coctel, Ingrediente, Refresco, Vino
	 */
	protected double precio;
	protected String nombre;
	protected boolean pedido;

	public Producto(double precio, String nombre, boolean pedido) {

		this.nombre = nombre;
		this.precio = precio;
		this.pedido = pedido;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isPedido() {
		return pedido;
	}

	public void setPedido(boolean pedido) {
		this.pedido = pedido;
	}

	// para manejar que los objetos que extienden de producto puedan estar dentro de
	// un hashmap
	@Override
	public int hashCode() {
		return Objects.hash(nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre) && precio == other.precio;
	}

}
