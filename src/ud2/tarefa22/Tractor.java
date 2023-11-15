/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

/**
 *
 * @author node
 */
public class Tractor {
    private int id;
    private enum enumTractor{rural,cosechar,carreras};
    private String modelo;
    private int velocidad;
    private float precio_venta;
    private int id_construccion;

    public Tractor(int id,String modelo ,int velocidad, float precio_venta, int id_construccion) {
        this.id = id;
        if(enumTractor.values().equals(modelo)){
            this.modelo = modelo;
        }
        this.velocidad = velocidad;
        this.precio_venta = precio_venta;
        
        this.id_construccion = id_construccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getId_construccion() {
        return id_construccion;
    }

    public void setId_construccion(int id_construccion) {
        this.id_construccion = id_construccion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Tractor{" + "id=" + id + ", modelo=" + modelo + ", velocidad=" + velocidad + ", precio_venta=" + precio_venta + ", id_construccion=" + id_construccion + '}';
    }
    


    
    
    
}
