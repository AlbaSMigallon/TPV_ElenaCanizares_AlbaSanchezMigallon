package modelo;

import java.util.Objects;

public abstract class Producto {
	protected double precio;
	protected String nombre;
	
	public Producto(double precio, String nombre) {
		// TODO Auto-generated constructor stub
		this.nombre= nombre;
		this.precio= precio;
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
	
	//para manejar que los objetos que extienden de producto puedan estar dentro de un hashmap
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
