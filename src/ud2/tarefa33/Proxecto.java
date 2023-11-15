/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa33;

/**
 *
 * @author node
 */
public class Proxecto {
    
    private int Num_proxecto;
    private String Nome_proxecto;
    private String Lugar;
    private int Numero_departamento;

    public Proxecto(int Num_proxecto, String Nome_proxecto, String Lugar, int Numero_departamento) {
        this.Num_proxecto = Num_proxecto;
        this.Nome_proxecto = Nome_proxecto;
        this.Lugar = Lugar;
        this.Numero_departamento = Numero_departamento;
    }

    
    
    public int getNum_proxecto() {
        return Num_proxecto;
    }

    public void setNum_proxecto(int Num_proxecto) {
        this.Num_proxecto = Num_proxecto;
    }

    public String getNome_proxecto() {
        return Nome_proxecto;
    }

    public void setNome_proxecto(String Nome_proxecto) {
        this.Nome_proxecto = Nome_proxecto;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public int getNumero_departamento() {
        return Numero_departamento;
    }

    public void setNumero_departamento(int Numero_departamento) {
        this.Numero_departamento = Numero_departamento;
    }
    
    
    
}
