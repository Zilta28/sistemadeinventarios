
package Modelo;

import java.util.Date;


public class cisternaAguaPotable {
    private int id;
    private String noCisterna;
    private String diaSemana;
    private Date fechaAP;
    private String hora;
    private String cloro;
    private String ph;
    private String dureza;
    private String nivelAgua;
    private String nombreRevisa;
    private String observacionesCisterna;
    
    public cisternaAguaPotable(){
        
    }

    public cisternaAguaPotable(int id, String noCisterna, String diaSemana, Date fechaAP, String hora, String cloro, String ph, String dureza, String nivelAgua, String nombreRevisa, String observacionesCisterna) {
        this.noCisterna = noCisterna;
        this.diaSemana = diaSemana;
        this.fechaAP = fechaAP;
        this.hora = hora;
        this.cloro = cloro;
        this.ph = ph;
        this.dureza = dureza;
        this.nivelAgua = nivelAgua;
        this.nombreRevisa = nombreRevisa;
        this.observacionesCisterna = observacionesCisterna;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNoCisterna() {
        return noCisterna;
    }

    public void setNoCisterna(String noCisterna) {
        this.noCisterna = noCisterna;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Date getFechaAP() {
        return fechaAP;
    }

    public void setFechaAP(Date fechaAP) {
        this.fechaAP = fechaAP;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCloro() {
        return cloro;
    }

    public void setCloro(String cloro) {
        this.cloro = cloro;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public String getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(String nivelAgua) {
        this.nivelAgua = nivelAgua;
    }

    public String getNombreRevisa() {
        return nombreRevisa;
    }

    public void setNombreRevisa(String nombreRevisa) {
        this.nombreRevisa = nombreRevisa;
    }

    public String getObservacionesCisterna() {
        return observacionesCisterna;
    }

    public void setObservacionesCisterna(String observacionesCisterna) {
        this.observacionesCisterna = observacionesCisterna;
    }
    
    
}
