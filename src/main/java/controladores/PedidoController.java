package controladores;

import modelo.Pedido;
import modelo.Repartidor;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {

    private List<Pedido> pedidos;
    private List<Repartidor> repartidores;

    public PedidoController() {
        pedidos = new ArrayList<>();

        repartidores = new ArrayList<>();
        repartidores.add(new Repartidor(1, "Carlos"));
        repartidores.add(new Repartidor(2, "María"));
        repartidores.add(new Repartidor(3, "Pedro"));
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    public List<Repartidor> obtenerRepartidores() {
        return repartidores;
    }
}