
package Modelo;

import java.util.Date;


public class hidrante {
    private int id;
    private String noHidrante;
    private Date periodoMensual;
    private String manguera;
    private Date fechaPrueba;
    private Date fechaProxima;
    private String edoPuerta;
    private String edoCristal; 
    private String edoPintura; 
    private String edoValvula;
    private String edoChiflon;
    private String edoManguera; 
    private String edoLlavePataGallo;
    private String edoSeñaletica; 
    private String elaborado;
    private String observacion;
    
    public hidrante(){
        
    }

    public hidrante(int id, Date periodoMensual, String noHidrante, String manguera, Date fechaPrueba, Date fechaProxima, String edoPuerta,
                            String edoCristal, String edoPintura, String edoValvula, String edoChiflon, String edoManguera,
                            String edoLlavePataGallo, String edoSeñaletica, String elaborado, String observacion) {
        this.id = id;
        this.periodoMensual = periodoMensual;
        this.noHidrante = noHidrante;
        this.manguera = manguera;
        this.fechaPrueba = fechaPrueba;
        this.fechaProxima = fechaProxima;
        this.edoPuerta = edoPuerta;
        this.edoCristal = edoCristal;
        this.edoPintura = edoPintura; 
        this.edoValvula = edoValvula; 
        this.edoChiflon = edoChiflon; 
        this.edoManguera = edoManguera; 
        this.edoLlavePataGallo = edoLlavePataGallo;
        this.edoSeñaletica = edoSeñaletica;
        this.elaborado = elaborado;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }

    public Date getPeriodoMensual() {
        return periodoMensual;
    }

    public void setPeriodoMensual(Date periodoMensual) {
        this.periodoMensual = periodoMensual;
    }
    
    public String getNoHidrante() {
        return noHidrante;
    }

    public void setNoHidrante(String noHidrante) {
        this.noHidrante = noHidrante;
    }

    public String getManguera() {
        return manguera;
    }

    public void setManguera(String manguera) {
        this.manguera = manguera;
    }

    public Date getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(Date fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public Date getFechaProxima() {
        return fechaProxima;
    }

    public void setFechaProxima(Date fechaProxima) {
        this.fechaProxima = fechaProxima;
    }

    public String getEdoPuerta() {
        return edoPuerta;
    }

    public void setEdoPuerta(String edoPuerta) {
        this.edoPuerta = edoPuerta;
    }

    public String getEdoCristal() {
        return edoCristal;
    }

    public void setEdoCristal(String edoCristal) {
        this.edoCristal = edoCristal;
    }

    public String getEdoPintura() {
        return edoPintura;
    }

    public void setEdoPintura(String edoPintura) {
        this.edoPintura = edoPintura;
    }

    public String getEdoValvula() {
        return edoValvula;
    }

    public void setEdoValvula(String edoValvula) {
        this.edoValvula = edoValvula;
    }

    public String getEdoChiflon() {
        return edoChiflon;
    }

    public void setEdoChiflon(String edoChiflon) {
        this.edoChiflon = edoChiflon;
    }

    public String getEdoManguera() {
        return edoManguera;
    }

    public void setEdoManguera(String edoManguera) {
        this.edoManguera = edoManguera;
    }

    public String getEdoLlavePataGallo() {
        return edoLlavePataGallo;
    }

    public void setEdoLlavePataGallo(String edoLlavePataGallo) {
        this.edoLlavePataGallo = edoLlavePataGallo;
    }

    public String getEdoSeñaletica() {
        return edoSeñaletica;
    }

    public void setEdoSeñaletica(String edoSeñaletica) {
        this.edoSeñaletica = edoSeñaletica;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
}
