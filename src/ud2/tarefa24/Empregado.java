/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud2.tarefa24;



/**
 *
 * @author node
 */
public class Empregado {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String NSS;
    private String rua;
    private int Num_rua;
    private String piso;
    private String cp;
    private String localidade;
    private String data_necemento;
    private float salario;
    private String sexo;
    private String NSS_Supervisa;
    private int Num_departamento;

    public Empregado(String nombre, String apellido1, String apellido2, String NSS, String rua, int Num_rua, String piso, String cp, String localidade, String data_necemento, float salario, String sexo, String NSS_Supervisa, int Num_departamento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.NSS = NSS;
        this.rua = rua;
        this.Num_rua = Num_rua;
        this.piso = piso;
        this.cp = cp;
        this.localidade = localidade;
        this.data_necemento = data_necemento;
        this.salario = salario;
        this.sexo = sexo;
        this.NSS_Supervisa = NSS_Supervisa;
        this.Num_departamento = Num_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum_rua() {
        return Num_rua;
    }

    public void setNum_rua(int Num_rua) {
        this.Num_rua = Num_rua;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getData_necemento() {
        return data_necemento;
    }

    public void setData_necemento(String data_necemento) {
        this.data_necemento = data_necemento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNSS_Supervisa() {
        return NSS_Supervisa;
    }

    public void setNSS_Supervisa(String NSS_Supervisa) {
        this.NSS_Supervisa = NSS_Supervisa;
    }

    public int getNum_departamento() {
        return Num_departamento;
    }

    public void setNum_departamento(int Num_departamento) {
        this.Num_departamento = Num_departamento;
    }

    @Override
    public String toString() {
        return "Empregado{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NSS=" + NSS + ", rua=" + rua + ", Num_rua=" + Num_rua + ", piso=" + piso + ", cp=" + cp + ", localidade=" + localidade + ", data_necemento=" + data_necemento + ", salario=" + salario + ", sexo=" + sexo + ", NSS_Supervisa=" + NSS_Supervisa + ", Num_departamento=" + Num_departamento + '}';
    }
    
    
    
    
}
