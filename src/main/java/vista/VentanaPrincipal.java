package vista;

import controladores.PedidoController;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PedidoController pedidoController;

    public VentanaPrincipal(PedidoController pedidoController) {

        this.pedidoController = pedidoController;

        setTitle("SpeedFast - Gestión de Pedidos");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        JLabel titulo = new JLabel(
                "SPEEDFAST - GESTIÓN DE PEDIDOS",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(
                new GridLayout(3, 1, 10, 10)
        );

        JButton botonRegistrar =
                new JButton("Registrar pedido");

        JButton botonListar =
                new JButton("Listar pedidos");

        JButton botonEntrega =
                new JButton("Asignar repartidor / Iniciar entrega");

        panelBotones.add(botonRegistrar);
        panelBotones.add(botonListar);
        panelBotones.add(botonEntrega);

        add(titulo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);

        botonRegistrar.addActionListener(e ->
                new VentanaRegistroPedido(pedidoController)
                        .setVisible(true)
        );

        botonListar.addActionListener(e ->
                new VentanaListaPedidos(pedidoController)
                        .setVisible(true)
        );

        botonEntrega.addActionListener(e ->
                new VentanaAsignarEntrega(pedidoController)
                        .setVisible(true)
        );
    }
}