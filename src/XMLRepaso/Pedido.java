/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLRepaso;

import java.util.ArrayList;

/**
 *
 * @author node
 */
public class Pedido {
    private Clientes cliente;
    private ArrayList<Producto> productos;

    public Pedido(Clientes cliente, ArrayList<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return  cliente + "" + productos ;
    }
    
     
}
