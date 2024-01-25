package modelo;

import java.util.HashMap;

public class Coctel {
    private HashMap<String, InfoCoctel> cocteles;

    public Coctel() {
        this.cocteles = new HashMap<>();
        cocteles.put("Cosmopolitan", new InfoCoctel("Cosmopolitan", 15, 8));
        cocteles.put("Tequila Sunrise", new InfoCoctel("Tequila Sunrise", 16, 9));
        cocteles.put("Daiquiri", new InfoCoctel("Daiquiri", 15, 7.5));
        cocteles.put("Bloody Mary", new InfoCoctel("Bloody Mary", 16, 9));
        cocteles.put("Mojito", new InfoCoctel("Mojito", 15, 8));
        cocteles.put("Margarita", new InfoCoctel("Margarita", 16, 9));
        cocteles.put("Pina Colada", new InfoCoctel("Pina Colada", 15, 8));
        cocteles.put("Martini", new InfoCoctel("Martini", 16, 9));
    }

    public HashMap<String, InfoCoctel> getCocteles() {
        return cocteles;
    }

    // Clase interna para representar la información completa de un coctel
    public static class InfoCoctel {
        private String nombre;
        private int cantidad;
        private double precio;

        public InfoCoctel(String nombre, int cantidad, double precio) {
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
    }//FIN INFOCOCTEL
}//FIN CLASS
