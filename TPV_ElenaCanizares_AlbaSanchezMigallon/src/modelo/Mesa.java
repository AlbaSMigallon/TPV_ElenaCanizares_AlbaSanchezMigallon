package modelo;

import java.util.ArrayList;

public class Mesa {
	private ArrayList<String> mesas;

	public Mesa() {
		mesas = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
			mesas.add("Mesa " + i);
		}
	}

	public ArrayList<String> getMesas() {
		return mesas;
	}

}// FIN CLASS
