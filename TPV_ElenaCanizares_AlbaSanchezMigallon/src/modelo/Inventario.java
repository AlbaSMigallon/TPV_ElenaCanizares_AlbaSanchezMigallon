package modelo;

import java.util.HashMap;
import java.util.Map;


public class Inventario {
	/*
	 * clase con un hashmap por tipo de producto en clave y en valor la cantidad de stock
	 * tambien controla tiene los metodos para restar productos de inventario cuando se aniaden a pedido
	 * recurso compartido con patron singleton
	 */
	

	private HashMap<Vino, Integer> vinos;
	private HashMap<Cerveza, Integer> cervezas;
	private HashMap<Aperitivo, Integer> aperitivos;
	private HashMap<Botella, Integer> botellas;
	private HashMap<Ingrediente, Integer> ingredientes;
	private HashMap<Refresco, Integer> refrescos;
	private HashMap<Coctel, Integer> cocteles;
	// Seccion critica
	private static Object object = new Object();

	// Patron Singleton
	private static Inventario instance;

	public Inventario() {
		super();
		this.vinos = new HashMap<>();
		this.cervezas = new HashMap<>();
		this.aperitivos = new HashMap<>();
		this.botellas = new HashMap<>();
		this.ingredientes = new HashMap<>();
		this.refrescos = new HashMap<>();
		this.cocteles= new HashMap<>();
		inicializarInventario();

	}

	private synchronized static void createInstance() {
		if (null == instance) {
			instance = new Inventario();
		}
	}

	public static Inventario getInstance() {
		if (null == instance) {
			createInstance();
		}
		return instance;
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
	
	public HashMap<Coctel, Integer> getCocteles() {
		return cocteles;
	}

	public void setCocteles(HashMap<Coctel, Integer> cocteles) {
		this.cocteles = cocteles;
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

	private void inicializarInventario() {
		inicializarAperitivos();
		inicializarBotellas();
		inicializarCerveza();
		inicializarIngredientes();
		inicializarRefrescos();
		inicializarVinos();
		inicializarCocteles();

	}

	private void inicializarAperitivos() {
		Aperitivo gominolas = new Aperitivo(1, "Gominolas", false);
		this.aperitivos.put(gominolas, 100);
		Aperitivo patatas = new Aperitivo(3, "Patatas fritas", false);
		this.aperitivos.put(patatas, 50);
		Aperitivo cocktel = new Aperitivo(2, "Cocktel frutos secos", false);
		this.aperitivos.put(cocktel, 100);
		Aperitivo aceitunas = new Aperitivo(3, "Aceitunas", false);
		this.aperitivos.put(aceitunas, 100);
		Aperitivo quesos = new Aperitivo(8, "Tabla de quesos", false);
		this.aperitivos.put(quesos, 50);
	}

	private void inicializarBotellas() {
		Botella vodka = new Botella(30, "Vodka", false);
		this.botellas.put(vodka, 10);
		Botella ron = new Botella(30, "Ron", false);
		this.botellas.put(ron, 20);
		Botella bluelabel = new Botella(30, "Blue Label", false);
		this.botellas.put(bluelabel, 20);
		Botella larios = new Botella(12, "Larios", false);
		this.botellas.put(larios, 50);
		Botella tequila = new Botella(25, "Tequila", false);
		this.botellas.put(tequila, 20);
		Botella vermu = new Botella(30, "Vermut", false);
		this.botellas.put(vermu, 10);
	}

	private void inicializarCerveza() {
		Cerveza ipa = new Cerveza(6, "IPA", false);
		this.cervezas.put(ipa, 60);
		Cerveza stout = new Cerveza(8, "Stout", false);
		this.cervezas.put(stout, 60);
		Cerveza pilsner = new Cerveza(7, "Pilsner", false);
		this.cervezas.put(pilsner, 100);
		Cerveza franziskaner = new Cerveza(10, "Franziskaner", false);
		this.cervezas.put(franziskaner, 40);

	}
	
	private void inicializarCocteles() {
		Coctel cosmopolitan = new Coctel(12, "Cosmopolitan", false);
		this.cocteles.put(cosmopolitan, 0);
		Coctel tequilaSunrise = new Coctel(12, "Tequila Sunrise", false);
		this.cocteles.put(tequilaSunrise, 0);
		Coctel daiquiri = new Coctel(13, "Daiquiri", false);
		this.cocteles.put(daiquiri, 0);
		Coctel bloodymary = new Coctel(12, "Bloody Mary", false);
		this.cocteles.put(cosmopolitan, 0);
		Coctel mojito= new Coctel(10, "Mojito", false);
		this.cocteles.put(mojito, 0);
		Coctel pinaColada = new Coctel(11, "Pinia colada", false);
		this.cocteles.put(pinaColada, 0);
		Coctel martini = new Coctel(15, "Martini", false);
		this.cocteles.put(martini, 0);
	}
	

	private void inicializarIngredientes() {
		Ingrediente hierbabuena = new Ingrediente(1, "Hierba buena", false);
		this.ingredientes.put(hierbabuena, 60);
		Ingrediente limon = new Ingrediente(1, "Limon", false);
		this.ingredientes.put(limon, 60);
		Ingrediente naranja = new Ingrediente(2, "Naranja", false);
		this.ingredientes.put(naranja, 60);
		Ingrediente tabasco = new Ingrediente(2, "Tabasco", false);
		this.ingredientes.put(tabasco, 70);
		Ingrediente menta = new Ingrediente(1, "Menta", false);
		this.ingredientes.put(menta, 30);
		Ingrediente lima = new Ingrediente(1, "Lima", false);
		this.ingredientes.put(lima, 20);
		Ingrediente azucar = new Ingrediente(3, "Azucar", false);
		this.ingredientes.put(azucar, 80);
		Ingrediente tomate = new Ingrediente(2, "Tomate", false);
		this.ingredientes.put(tomate, 20);
		Ingrediente eucalipto = new Ingrediente(1, "Eucalipto", false);
		this.ingredientes.put(eucalipto, 60);

	}

	private void inicializarRefrescos() {
		Refresco cocacola = new Refresco(3, "Coca Cola", false);
		this.refrescos.put(cocacola, 200);
		Refresco fanta = new Refresco(2, "Fanta", false);
		this.refrescos.put(fanta, 200);
		Refresco nestea = new Refresco(2, "Nestea", false);
		this.refrescos.put(nestea, 300);
		Refresco agua = new Refresco(2, "Agua", false);
		this.refrescos.put(agua, 100);
		Refresco aguagas = new Refresco(2, "Agua con gas", false);
		this.refrescos.put(aguagas, 100);
		Refresco zumo = new Refresco(4, "Zumo", false);
		this.refrescos.put(zumo, 50);
	}

	private void inicializarVinos() {
		Vino tinto = new Vino(4, "Vino tinto", false);
		this.vinos.put(tinto, 100);
		Vino blanco = new Vino(5, "Vino blanco", false);
		this.vinos.put(blanco, 200);
		Vino rosado = new Vino(4, "Vino rosado", false);
		this.vinos.put(rosado, 100);
		Vino verdejo = new Vino(5, "Vino verdejo", false);
		this.vinos.put(verdejo, 50);

	}
	
	public void actualizarCantidadRefrescos(String producto, int cantidad) {
		
		for (HashMap.Entry<Refresco, Integer> entry : getRefrescos().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getRefrescos().put(entry.getKey(), entry.getValue());
			}
		}
		
	}
	
	public void actualizarCantidadCerveza(String producto, int cantidad) {
		
		for (HashMap.Entry<Cerveza, Integer> entry : getCervezas().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getCervezas().put(entry.getKey(), entry.getValue());
			}
		}
		
	}
	
	public void actualizarCantidadAperitivos(String producto, int cantidad) {
		
		for (HashMap.Entry<Aperitivo, Integer> entry : getAperitivos().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getAperitivos().put(entry.getKey(), entry.getValue());
			}
		}
		
	}
	
	public void actualizarCantidadBotellas(String producto, int cantidad) {
		
		for (HashMap.Entry<Botella, Integer> entry : getBotellas().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getBotellas().put(entry.getKey(), entry.getValue());
			}
		}
		
	}
	
	public void actualizarCantidadCocteles(String producto, int cantidad) {
		
		for (HashMap.Entry<Coctel, Integer> entry : getCocteles().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getCocteles().put(entry.getKey(), entry.getValue());
			}
		}
		
	}
	
	public void actualizarCantidadIngredientes(String producto, int cantidad) {
		
		for (HashMap.Entry<Ingrediente, Integer> entry : getIngredientes().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getIngredientes().put(entry.getKey(), entry.getValue());
			}
		}
		
	}
	
	public void actualizarCantidadVinos(String producto, int cantidad) {
		
		for (HashMap.Entry<Vino, Integer> entry : getVinos().entrySet()) {
			if(entry.getKey().getNombre().equals(producto)) {
				entry.setValue(cantidad);
				getVinos().put(entry.getKey(), entry.getValue());
			}
		}
		
	}

	public boolean restarStockAperitivos(int cantidad, String nombre) {
		boolean esModificado = false;
		synchronized (object) {

			for (Map.Entry<Aperitivo, Integer> entry : aperitivos.entrySet()) {// recorremos hashmap
				if (entry.getKey().getNombre().equalsIgnoreCase(nombre)) {// encontramos producto
					if (entry.getValue() - cantidad >= 0) {// vemos si podemos restar esa cantidad, que tengamos stock
															// suficiente
						this.aperitivos.put(entry.getKey(), (entry.getValue() - cantidad));
						esModificado = true;
					}
				}
			}

		}
		return esModificado;
	}

	public boolean restarStockBotellas(int cantidad, String nombre) {
		boolean esModificado = false;
		synchronized (object) {

			for (Map.Entry<Botella, Integer> entry : botellas.entrySet()) {// recorremos hashmap
				if (entry.getKey().getNombre().equalsIgnoreCase(nombre)) {// encontramos producto
					if (entry.getValue() - cantidad >= 0) {// vemos si podemos restar esa cantidad, que tengamos stock
															// suficiente
						this.botellas.put(entry.getKey(), (entry.getValue() - cantidad));
						esModificado = true;
					}
				}
			}

		}
		return esModificado;
	}

	public boolean restarStockCervezas(int cantidad, String nombre) {
		boolean esModificado = false;
		synchronized (object) {

			for (Map.Entry<Cerveza, Integer> entry : cervezas.entrySet()) {// recorremos hashmap
				if (entry.getKey().getNombre().equalsIgnoreCase(nombre)) {// encontramos producto
					if (entry.getValue() - cantidad >= 0) {// vemos si podemos restar esa cantidad, que tengamos stock
															// suficiente
						this.cervezas.put(entry.getKey(), (entry.getValue() - cantidad));
						esModificado = true;
					}
				}
			}

		}
		return esModificado;
	}

	public boolean restarStockIngredientes(int cantidad, String nombre) {
		boolean esModificado = false;
		synchronized (object) {

			for (Map.Entry<Ingrediente, Integer> entry : ingredientes.entrySet()) {// recorremos hashmap
				if (entry.getKey().getNombre().equalsIgnoreCase(nombre)) {// encontramos producto
					if (entry.getValue() - cantidad >= 0) {// vemos si podemos restar esa cantidad, que tengamos stock
															// suficiente
						this.ingredientes.put(entry.getKey(), (entry.getValue() - cantidad));
						esModificado = true;
					}
				}
			}

		}
		return esModificado;
	}

	public boolean restarStockRefresco(int cantidad, String nombre) {
		boolean esModificado = false;
		synchronized (object) {

			for (Map.Entry<Refresco, Integer> entry : refrescos.entrySet()) {// recorremos hashmap
				if (entry.getKey().getNombre().equalsIgnoreCase(nombre)) {// encontramos producto
					if (entry.getValue() - cantidad >= 0) {// vemos si podemos restar esa cantidad, que tengamos stock
															// suficiente
						this.refrescos.put(entry.getKey(), (entry.getValue() - cantidad));
						esModificado = true;
					}
				}
			}

		}
		return esModificado;
	}

	public boolean restarStockVinos(int cantidad, String nombre) {
		boolean esModificado = false;
		synchronized (object) {

			for (Map.Entry<Vino, Integer> entry : vinos.entrySet()) {// recorremos hashmap
				if (entry.getKey().getNombre().equalsIgnoreCase(nombre)) {// encontramos producto
					if (entry.getValue() - cantidad >= 0) {// vemos si podemos restar esa cantidad, que tengamos stock
															// suficiente
						this.vinos.put(entry.getKey(), (entry.getValue() - cantidad));
						esModificado = true;
					}
				}
			}

		}
		return esModificado;
	}
}
