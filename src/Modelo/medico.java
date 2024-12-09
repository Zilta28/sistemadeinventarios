/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class medico {
    public int id;
    private String materialMed;
    private Date fechaMed;
    private String buenEstadoMed;
    private String observacionesMed;
    private String elaboradoMed;
    private String revisadoMed;
    private String aprobadoMed;

    public medico() {
    }

    public medico(String materialMed, Date fechaMed, String buenEstadoMed, String observacionesMed, String elaboradoMed, String revisadoMed, String aprobadoMed, int id) {
        this.materialMed = materialMed;
        this.fechaMed = fechaMed;
        this.buenEstadoMed = buenEstadoMed;
        this.observacionesMed = observacionesMed;
        this.elaboradoMed = elaboradoMed;
        this.revisadoMed = revisadoMed;
        this.aprobadoMed = aprobadoMed;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialMed() {
        return materialMed;
    }

    public void setMaterialMed(String materialMed) {
        this.materialMed = materialMed;
    }

    public Date getFechaMed() {
        return fechaMed;
    }

    public void setFechaMed(Date fechaMed) {
        this.fechaMed = fechaMed;
    }

    public String getBuenEstadoMed() {
        return buenEstadoMed;
    }

    public void setBuenEstadoMed(String buenEstadoMed) {
        this.buenEstadoMed = buenEstadoMed;
    }

    public String getObservacionesMed() {
        return observacionesMed;
    }

    public void setObservacionesMed(String observacionesMed) {
        this.observacionesMed = observacionesMed;
    }

    public String getElaboradoMed() {
        return elaboradoMed;
    }

    public void setElaboradoMed(String elaboradoMed) {
        this.elaboradoMed = elaboradoMed;
    }

    public String getRevisadoMed() {
        return revisadoMed;
    }

    public void setRevisadoMed(String revisadoMed) {
        this.revisadoMed = revisadoMed;
    }

    public String getAprobadoMed() {
        return aprobadoMed;
    }

    public void setAprobadoMed(String aprobadoMed) {
        this.aprobadoMed = aprobadoMed;
    }


}
