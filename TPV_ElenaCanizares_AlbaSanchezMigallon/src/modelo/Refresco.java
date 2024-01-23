package modelo;

import java.util.HashMap;

public class Refresco {
	private HashMap<String, Integer> refrescos;

	public Refresco() {
		this.refrescos = new HashMap<>();
		refrescos.put("Coca Cola", 3);
		refrescos.put("Fanta de Limon", 2);
		refrescos.put("Fanta de Naranja", 2);
		refrescos.put("Nestea", 3);
		refrescos.put("Agua", 1);
		refrescos.put("Agua con gas", 1);
		refrescos.put("Zumo de limon", 3);
		refrescos.put("Zumo de pina", 3);

	}

	public HashMap<String, Integer> getRefrescos() {
		return refrescos;
	}
}