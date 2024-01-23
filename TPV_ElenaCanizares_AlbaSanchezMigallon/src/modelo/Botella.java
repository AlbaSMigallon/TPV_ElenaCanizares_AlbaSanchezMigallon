package modelo;

import java.util.HashMap;

public class Botella {
	private HashMap<String, Integer> botellas;

	public Botella() {
		this.botellas = new HashMap<>();
		botellas.put("Vozka", 30);
		botellas.put("Ron", 30);
		botellas.put("Blue Label", 30);
		botellas.put("Ginebra", 30);
		botellas.put("Tequila", 30);
		botellas.put("Vermu", 30);

	}

	public HashMap<String, Integer> getBotellas() {
		return botellas;
	}
}
