package modelo;

import java.util.HashMap;

public class Aperitivo {
	private HashMap<String, Integer> aperitivos;

	public Aperitivo() {
		this.aperitivos = new HashMap<>();
		aperitivos.put("Gominolas", 30);
		aperitivos.put("Patatas fritas supreme", 30);
		aperitivos.put("Cocktel de secos", 30);
		aperitivos.put("Aceitunas rellenas", 30);
		aperitivos.put("Table de quesos", 30);

	}

	public HashMap<String, Integer> getAperitivos() {
		return aperitivos;
	}

}// FIN CLASS