package modelo;

import java.util.ArrayList;

public class Mesa {
	private ArrayList<String> mesas;

	public Mesa() {

		mesas = new ArrayList<>();
		mesas.add("Mesa 1");
		mesas.add("Mesa 2");
		mesas.add("Mesa 3");
		mesas.add("Mesa 4");
		mesas.add("Mesa 5");
		mesas.add("Mesa 6");
		mesas.add("Mesa 7");
	}

	public ArrayList<String> getMesas() {
		return mesas;
	}

}// FIN CLASS
