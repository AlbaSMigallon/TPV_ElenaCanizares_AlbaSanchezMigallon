package modelo;

import java.util.*;

public class Cerveza {
	private HashMap<String, Integer> cervezas;

	public Cerveza() {
		this.cervezas = new HashMap<>();
		cervezas.put("Cerveza 1", 15);
		cervezas.put("Cerveza 2", 16);
		cervezas.put("Cerveza 3", 15);
		cervezas.put("Cerveza 4", 16);

	}

	public HashMap<String, Integer> getCervezas() {
		return cervezas;
	}

}// FIN CLASS
