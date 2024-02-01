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
    
    

    public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}



	public List<Mesa> getMesas() {
        return mesas;
    }
    public Mesa getMesaPorNumero(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numeroMesa) {
                return mesa;
            }
        }
        return null; // Manejar el caso en que no se encuentra la mesa
    }
    public void agregarBebidaAMesa(int numeroMesa, String nombreBebida, int cantidad) {
        if (numeroMesa >= 1 && numeroMesa <= mesas.size()) {
            Mesa mesa = mesas.get(numeroMesa - 1);
            
            // crear un nuevo Pedido si no existe uno
            if (mesa.getPedido() == null) {
                mesa.setPedido(new Pedido());
            }
            
            mesa.getPedido().agregarBebida(nombreBebida, cantidad);
        } else {
            System.out.println("Número de mesa inválido");
        }
    }
}
