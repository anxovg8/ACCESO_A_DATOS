/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

/**
 *
 * @author node
 */
public class Plantaciones {
    private int id;
    private String nombre;
    private float precio_compra;
    private float precio_venta;
    private String proxima_cosecha;
    private int id_construccion;

    public Plantaciones(int id, String nombre, float precio_compra, float precio_venta, String proxima_cosecha, int id_construccion) {
        this.id = id;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.proxima_cosecha = proxima_cosecha;
        this.id_construccion = id_construccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getProxima_cosecha() {
        return proxima_cosecha;
    }

    public void setProxima_cosecha(String proxima_cosecha) {
        this.proxima_cosecha = proxima_cosecha;
    }

    public int getId_construccion() {
        return id_construccion;
    }

    public void setId_construccion(int id_construccion) {
        this.id_construccion = id_construccion;
    }

    @Override
    public String toString() {
        return "Plantaciones{" + "id=" + id + ", nombre=" + nombre + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta + ", proxima_cosecha=" + proxima_cosecha + ", id_construccion=" + id_construccion + '}';
    }
    
    
}
