package modelo;

import java.util.HashMap;

public class Ingrediente {
	private HashMap<String, Integer> ingredientes;

	public Ingrediente() {
		this.ingredientes = new HashMap<>();
		ingredientes.put("Hierba buena", 30);
		ingredientes.put("Limon", 30);
		ingredientes.put("Naranja", 30);
		ingredientes.put("Tabasco", 30);
		ingredientes.put("Menta", 30);
		ingredientes.put("Fresas", 30);
		ingredientes.put("Lima", 30);
		ingredientes.put("Azucar", 30);
		ingredientes.put("Tomate", 30);
		ingredientes.put("Coco", 30);
		ingredientes.put("Eucalipto", 30);

	}

	public HashMap<String, Integer> getIngredientes() {
		return ingredientes;
	}

}// FIN CLASS