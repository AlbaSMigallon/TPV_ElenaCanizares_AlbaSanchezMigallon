package modelo;

import java.util.*;

public class Coctel {
	private HashMap<String, Integer> cocteles;

	public Coctel() {
		this.cocteles = new HashMap<>();
		cocteles.put("Cosmopolitan", 15);
		cocteles.put("Tequila Sunrise", 16);
		cocteles.put("Daiquiri", 15);
		cocteles.put("Bloody Mary", 16);
		cocteles.put("Mojito", 15);
		cocteles.put("Margarita", 16);
		cocteles.put("Pina Colada", 15);
		cocteles.put("Martini", 16);
	}

	public HashMap<String, Integer> getCocteles() {
		return cocteles;
	}

}// FIN CLASS
