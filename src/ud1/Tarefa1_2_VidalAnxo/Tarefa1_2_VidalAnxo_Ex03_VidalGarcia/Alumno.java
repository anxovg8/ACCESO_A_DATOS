/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud1.Tarefa1_2_VidalAnxo.Tarefa1_2_VidalAnxo_Ex03_VidalGarcia;

import java.util.Objects;

/**
 *
 * @author node
 */
public class Alumno {

    private String id;
    private String resultados;
    private Double nota;

    public String getId() {
        return id;
    }

    public String getResultados() {
        return resultados;
    }
    public Double getNota(){
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Alumno(String id, String resultados) {
        this.id = id;
        this.resultados = resultados;
    }
    
    
    public Alumno(String id, String resultados,Double nota) {
        this.id = id;
        this.resultados = resultados;
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.resultados);
        hash = 59 * hash + Objects.hashCode(this.nota);
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
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.resultados, other.resultados)) {
            return false;
        }
        return Objects.equals(this.nota, other.nota);
    }

   



    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", resultados=" + resultados + ", nota=" + nota + '}';
    }

    public char[] result(){
        
        return this.resultados.toCharArray();
    }

}
