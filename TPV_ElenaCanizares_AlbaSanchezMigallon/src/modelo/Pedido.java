package modelo;

import java.util.HashMap;

public class Pedido {
    private boolean esOcupada;
    private HashMap<String, Integer> bebidasPedido;

    public Pedido() {
        this.bebidasPedido = new HashMap<>();
    }

    public void agregarBebida(String nombreBebida, int cantidad) {
        bebidasPedido.put(nombreBebida, cantidad);
    }

    public void eliminarBebida(String nombreBebida, int cantidad) {
        bebidasPedido.computeIfPresent(nombreBebida, (bebida, actualCantidad) -> actualCantidad - cantidad);
        bebidasPedido.remove(nombreBebida, 0); // Elimina si la cantidad es cero o negativa
    }

    public HashMap<String, Integer> getBebidasPedido() {
        return bebidasPedido;
    }

    public boolean esOcupada() {
        return esOcupada;
    }

    public void setEsOcupada(boolean esOcupada) {
        this.esOcupada = esOcupada;
    }
}
