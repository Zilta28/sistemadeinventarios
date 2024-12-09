
package Modelo;

import java.util.Date;

public class suministroGasLp {
    private int id;
    private Date fecha;
    private String materiaLp;
    private String litro;
    private String costo;
    private String subtotal;
    private String horaEntrada;
    private String horaSalida;
    private String seguridad;
    private String encargado;
    private String chofer;
    private String observacionesG;
    
    
    public suministroGasLp(){
        
    }

    public suministroGasLp(int id, Date fecha, String materiaLp, String litro, String costo, String subtotal, String horaEntrada, String horaSalida, String seguridad, String encargado, String chofer, String observacionesG) {
        this.id = id; 
        this.fecha = fecha;
        this.materiaLp = materiaLp;
        this.litro = litro;
        this.costo = costo;
        this.subtotal = subtotal;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.seguridad = seguridad;
        this.encargado = encargado;
        this.chofer = chofer;
        this.observacionesG = observacionesG;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMateriaLp() {
        return materiaLp;
    }

    public void setMateriaLp(String materiaLp) {
        this.materiaLp = materiaLp;
    }

    public String getLitro() {
        return litro;
    }

    public void setLitro(String litro) {
        this.litro = litro;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(String seguridad) {
        this.seguridad = seguridad;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getObservacionesG() {
        return observacionesG;
    }

    public void setObservacionesG(String observacionesG) {
        this.observacionesG = observacionesG;
    }
    
}
