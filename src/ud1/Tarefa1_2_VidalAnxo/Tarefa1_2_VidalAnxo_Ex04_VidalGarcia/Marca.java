/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex04_VidalGarcia;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author node
 */
public class Marca {
    private String nombre;
    private String modelos;

    public Marca(String nombre, String modelos) {
        this.nombre = nombre;
        this.modelos = modelos;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public String getModelos() {
        return modelos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.modelos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marca other = (Marca) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.modelos, other.modelos);
    }

    @Override
    public String toString() {
        return "Marca{" + "nombre=" + nombre + ", modelos=" + modelos + '}';
    }
    
    
    
}
