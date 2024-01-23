package modelo;

import java.util.HashMap;

public class Vino {
	private HashMap<String, Integer> vinos;

	public Vino() {
		this.vinos = new HashMap<>();
		vinos.put("Vino Tinto", 15);
		vinos.put("Vino Blanco", 16);
		vinos.put("Vino Rosado", 15);
		vinos.put("Vino Verdejo", 16);

	}

	public HashMap<String, Integer> getVinos() {
		return vinos;
	}

}// FIN CLASS
