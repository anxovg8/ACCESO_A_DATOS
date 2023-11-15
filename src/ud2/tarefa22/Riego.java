/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa22;

/**
 *
 * @author node
 */
public class Riego {
    private int id;
    private String tipo;
    private int velocidad;
    private int id_plantacion;

    public Riego(int id, String tipo, int velocidad, int id_plantacion) {
        this.id = id;
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.id_plantacion = id_plantacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getId_plantacion() {
        return id_plantacion;
    }

    public void setId_plantacion(int id_plantacion) {
        this.id_plantacion = id_plantacion;
    }

    @Override
    public String toString() {
        return "Riego{" + "id=" + id + ", tipo=" + tipo + ", velocidad=" + velocidad + ", id_plantacion=" + id_plantacion + '}';
    }
    
    
    
    
}
