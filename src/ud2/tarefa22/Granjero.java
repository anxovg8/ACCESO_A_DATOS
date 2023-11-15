/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

/**
 *
 * @author node
 */
public class Granjero {
    private int id;
    private String nombre;
    private String descripcion;
    private float dinero;
    private int puntos;
    private int nivel;

    public Granjero(int id, String nombre, String descripcion, float dinero,int puntos,int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dinero = dinero;
        this.puntos = puntos;
        this.nivel = nivel;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Granjero{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", dinero=" + dinero + ", puntos=" + puntos + ", nivel=" + nivel + '}';
    }
    
    
    
    
    
    
}
