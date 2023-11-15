/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

/**
 *
 * @author node
 */
public class Construccion {
    private int id;
    private String nombre;
    private float precio;
    private int id_granjero;

    public Construccion(int id, String nombre, float precio, int id_granjero) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.id_granjero = id_granjero;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getId_granjero() {
        return id_granjero;
    }

    public void setId_granjero(int id_granjero) {
        this.id_granjero = id_granjero;
    }

    @Override
    public String toString() {
        return "Construccion{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", id_granjero=" + id_granjero + '}';
    }
    
    
    
}
