package modelo;

import java.util.HashMap;

public class Botella {
    private HashMap<String, InfoBotella> botellas;

    public Botella() {
        this.botellas = new HashMap<>();
        botellas.put("Vozka", new InfoBotella("Vozka", 30, 20));
        botellas.put("Ron", new InfoBotella("Ron", 30, 25));
        botellas.put("Blue Label", new InfoBotella("Blue Label", 30, 100));
        botellas.put("Ginebra", new InfoBotella("Ginebra", 30, 30));
        botellas.put("Tequila", new InfoBotella("Tequila", 30, 35));
        botellas.put("Vermu", new InfoBotella("Vermu", 30, 15));
    }

    public HashMap<String, InfoBotella> getBotellas() {
		return botellas;
	}

    // Clase interna para representar la información completa de una botella
    public static class InfoBotella {
        private String nombre;
        private int cantidad;
        private int precio;

        public InfoBotella(String nombre, int cantidad, int precio) {
            this.nombre = nombre;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public int getPrecio() {
            return precio;
        }
    }//FIN INFO BOTELLA
}//FIN CLASS
