/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa24;



/**
 *
 * @author node
 */
public class Departamento {
    private int num_departamento;
    private String nombre_departamento;
    private String NSS_dirige;
    private String Data_direccion;

    public Departamento(int num_departamento, String nombre_departamento, String NSS_dirige, String Data_direccion) {
        this.num_departamento = num_departamento;
        this.nombre_departamento = nombre_departamento;
        this.NSS_dirige = NSS_dirige;
        this.Data_direccion = Data_direccion;
    }

    public int getNum_departamento() {
        return num_departamento;
    }

    public void setNum_departamento(int num_departamento) {
        this.num_departamento = num_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public String getNSS_dirige() {
        return NSS_dirige;
    }

    public void setNSS_dirige(String NSS_dirige) {
        this.NSS_dirige = NSS_dirige;
    }

    public String getData_direccion() {
        return Data_direccion;
    }

    public void setData_direccion(String Data_direccion) {
        this.Data_direccion = Data_direccion;
    }
    
    
}
