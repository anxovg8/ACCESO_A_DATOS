/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PedidosXML;

import java.util.ArrayList;

/**
 *
 * @author node
 */
public class Pedido {
    
    private String idPedido;
    private String nombreCliente;
    private ArrayList<Producto> productos;

    public Pedido(String idPedido, String nombreCliente, ArrayList<Producto> productos) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.productos = productos;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return idPedido + ": " + nombreCliente +" Productos:"+ productos ;
    }
    
    
}
