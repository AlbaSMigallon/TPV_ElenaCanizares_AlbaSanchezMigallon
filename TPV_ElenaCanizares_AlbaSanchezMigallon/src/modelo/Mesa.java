package modelo;

import java.util.ArrayList;

public class Mesa {
    private ArrayList<String> mesas;
    private Pedido pedido;  // Agregar un campo de tipo Pedido

    public Mesa() {
        mesas = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            mesas.add("Mesa " + i);
        }
        
        // Crear una instancia de Pedido para cada mesa
        pedido = new Pedido();
    }

    public ArrayList<String> getMesas() {
        return mesas;
    }

    public Pedido getPedido() {
        return pedido;
    }

    // Puedes agregar otros métodos relacionados con la mesa y su pedido si es necesario
}
