package modelo;

import java.util.ArrayList;

public class Barra {
	private ArrayList<String> taburetes;

	public Barra() {

		taburetes = new ArrayList<>();
		taburetes.add("Taburete 1");
		taburetes.add("Taburete 2");
		taburetes.add("Taburete 3");
		taburetes.add("Taburete 4");
		taburetes.add("Taburete 5");
		taburetes.add("Taburete 6");
		taburetes.add("Taburete 7");
	}

	public ArrayList<String> getBarra() {
		return taburetes;
	}

}// FIN CLASS
