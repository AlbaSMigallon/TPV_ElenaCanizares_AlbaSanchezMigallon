package modelo;

import java.util.HashMap;

public class Vino {
    private HashMap<String, InfoVino> vinos;

    public Vino() {
        this.vinos = new HashMap<>();
        vinos.put("Vino Tinto", new InfoVino("Vino Tinto", 15, 25));
        vinos.put("Vino Blanco", new InfoVino("Vino Blanco", 16, 30));
        vinos.put("Vino Rosado", new InfoVino("Vino Rosado", 15, 28));
        vinos.put("Vino Verdejo", new InfoVino("Vino Verdejo", 16, 32));
    }

    public HashMap<String, InfoVino> getVinos() {
        return vinos;
    }

    // Clase interna para representar la información completa de un vino
    public static class InfoVino {
        private String nombre;
        private int cantidad;
        private double precio;

        public InfoVino(String nombre, int cantidad, double precio) {
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

        public double getPrecio() {
            return precio;
        }
    }//FIN INFOVINO
}//FIN CLASS
