package modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorDePedidos {
    private List<Mesa> mesas;

    public GestorDePedidos() {
        mesas = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            mesas.add(new Mesa(i));
        }
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void agregarBebidaAMesa(int numeroMesa, String nombreBebida, int cantidad) {
        if (numeroMesa >= 1 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            mesa.getPedido().agregarBebida(nombreBebida, cantidad);
        } else {
            System.out.println("Número de mesa inválido");
        }
    }
}
