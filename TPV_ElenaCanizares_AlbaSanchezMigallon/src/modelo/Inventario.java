package modelo;

import java.util.HashMap;

public class Inventario {
	// clase con un hashmap por tipo de producto en clave y en valor la cantidad de stock

	private HashMap<Vino, Integer> vinos;
	private HashMap<Cerveza, Integer> cervezas;
	private HashMap<Aperitivo, Integer> aperitivos;
	private HashMap<Botella, Integer> botellas;
	private HashMap<Ingrediente, Integer> ingredientes;
	private HashMap<Refresco, Integer> refrescos;
	
	public Inventario() {
		super();
		this.vinos = new HashMap<>();
		this.cervezas = new HashMap<>();
		this.aperitivos = new HashMap<>();
		this.botellas = new HashMap<>();
		this.ingredientes = new HashMap<>();
		this.refrescos = new HashMap<>();
	}

	public HashMap<Vino, Integer> getVinos() {
		return vinos;
	}

	public void setVinos(HashMap<Vino, Integer> vinos) {
		this.vinos = vinos;
	}

	public HashMap<Cerveza, Integer> getCervezas() {
		return cervezas;
	}

	public void setCervezas(HashMap<Cerveza, Integer> cervezas) {
		this.cervezas = cervezas;
	}

	public HashMap<Aperitivo, Integer> getAperitivos() {
		return aperitivos;
	}

	public void setAperitivos(HashMap<Aperitivo, Integer> aperitivos) {
		this.aperitivos = aperitivos;
	}

	public HashMap<Botella, Integer> getBotellas() {
		return botellas;
	}

	public void setBotellas(HashMap<Botella, Integer> botellas) {
		this.botellas = botellas;
	}

	public HashMap<Ingrediente, Integer> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(HashMap<Ingrediente, Integer> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public HashMap<Refresco, Integer> getRefrescos() {
		return refrescos;
	}

	public void setRefrescos(HashMap<Refresco, Integer> refrescos) {
		this.refrescos = refrescos;
	}
	
	

    // Métodos para manipular el inventario

    public void agregarVino(Vino vino, int cantidad) {
        vinos.put(vino, cantidad);
    }

    public void agregarCerveza(Cerveza cerveza, int cantidad) {
        cervezas.put(cerveza, cantidad);
    }

    public void agregarAperitivo(Aperitivo aperitivo, int cantidad) {
        aperitivos.put(aperitivo, cantidad);
    }

    public void agregarBotella(Botella botella, int cantidad) {
        botellas.put(botella, cantidad);
    }

    public void agregarIngrediente(Ingrediente ingrediente, int cantidad) {
        ingredientes.put(ingrediente, cantidad);
    }

    public void agregarRefresco(Refresco refresco, int cantidad) {
        refrescos.put(refresco, cantidad);
    }

    public int obtenerCantidadVino(Vino vino) {
        return vinos.getOrDefault(vino, 0);
    }

    public int obtenerCantidadCerveza(Cerveza cerveza) {
        return cervezas.getOrDefault(cerveza, 0);
    }

    public int obtenerCantidadAperitivo(Aperitivo aperitivo) {
        return aperitivos.getOrDefault(aperitivo, 0);
    }

    public int obtenerCantidadBotella(Botella botella) {
        return botellas.getOrDefault(botella, 0);
    }

    public int obtenerCantidadIngrediente(Ingrediente ingrediente) {
        return ingredientes.getOrDefault(ingrediente, 0);
    }

    public int obtenerCantidadRefresco(Refresco refresco) {
        return refrescos.getOrDefault(refresco, 0);
    }
	
	


/*

	public void agregarProducto(String nombreBebida, int cantidad) {
		inventario.put(nombreBebida, cantidad);
	}

	public void eliminarProducto(String nombreBebida, int cantidad) {
		inventario.remove(nombreBebida, cantidad);
	}

	public HashMap<String, Integer> getInventario() {
		return inventario;
	}

	public void actualizarCantidad(String nombreProducto, int nuevaCantidad) {
		// Actualizamos la cantidad en el HashMap del Inventario
		if (inventario.containsKey(nombreProducto)) {
			inventario.put(nombreProducto, nuevaCantidad);
		}

	}
	
	*/
}
