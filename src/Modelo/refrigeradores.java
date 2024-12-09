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
public class refrigeradores {
    public int id;
    private String materialRefri;
    private Date fechaRefri;
    private String selladoRefri;
    private String fugasRefri;
    private String cableadoRefri;
    private String limpiezaExtRefri;
    private String limpiezaIntRefri;
    private String limpiezaEvaRefri;
    private String medicionAmpRefri;
    private String elaboradoRefri;
    private String revisadoRefri;
    private String aprobadoRefri;
    private String observacionesRefri;

    public refrigeradores() {
    }

    public refrigeradores(String materialRefri, Date fechaRefri, String selladoRefri, String fugasRefri, String cableadoRefri, String limpiezaExtRefri, String limpiezaIntRefri, String limpiezaEvaRefri, String medicionAmpRefri, String elaboradoRefri, String revisadoRefri, String aprobadoRefri, String observacionesRefri, int id) {
        this.materialRefri = materialRefri;
        this.fechaRefri = fechaRefri;
        this.selladoRefri = selladoRefri;
        this.fugasRefri = fugasRefri;
        this.cableadoRefri = cableadoRefri;
        this.limpiezaExtRefri = limpiezaExtRefri;
        this.limpiezaIntRefri = limpiezaIntRefri;
        this.limpiezaEvaRefri = limpiezaEvaRefri;
        this.medicionAmpRefri = medicionAmpRefri;
        this.elaboradoRefri = elaboradoRefri;
        this.revisadoRefri = revisadoRefri;
        this.aprobadoRefri = aprobadoRefri;
        this.observacionesRefri = observacionesRefri;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialRefri() {
        return materialRefri;
    }

    public void setMaterialRefri(String materialRefri) {
        this.materialRefri = materialRefri;
    }

    public Date getFechaRefri() {
        return fechaRefri;
    }

    public void setFechaRefri(Date fechaRefri) {
        this.fechaRefri = fechaRefri;
    }

    public String getSelladoRefri() {
        return selladoRefri;
    }

    public void setSelladoRefri(String selladoRefri) {
        this.selladoRefri = selladoRefri;
    }

    public String getFugasRefri() {
        return fugasRefri;
    }

    public void setFugasRefri(String fugasRefri) {
        this.fugasRefri = fugasRefri;
    }

    public String getCableadoRefri() {
        return cableadoRefri;
    }

    public void setCableadoRefri(String cableadoRefri) {
        this.cableadoRefri = cableadoRefri;
    }

    public String getLimpiezaExtRefri() {
        return limpiezaExtRefri;
    }

    public void setLimpiezaExtRefri(String limpiezaExtRefri) {
        this.limpiezaExtRefri = limpiezaExtRefri;
    }

    public String getLimpiezaIntRefri() {
        return limpiezaIntRefri;
    }

    public void setLimpiezaIntRefri(String limpiezaIntRefri) {
        this.limpiezaIntRefri = limpiezaIntRefri;
    }

    public String getLimpiezaEvaRefri() {
        return limpiezaEvaRefri;
    }

    public void setLimpiezaEvaRefri(String limpiezaEvaRefri) {
        this.limpiezaEvaRefri = limpiezaEvaRefri;
    }

    public String getMedicionAmpRefri() {
        return medicionAmpRefri;
    }

    public void setMedicionAmpRefri(String medicionAmpRefri) {
        this.medicionAmpRefri = medicionAmpRefri;
    }

    public String getElaboradoRefri() {
        return elaboradoRefri;
    }

    public void setElaboradoRefri(String elaboradoRefri) {
        this.elaboradoRefri = elaboradoRefri;
    }

    public String getRevisadoRefri() {
        return revisadoRefri;
    }

    public void setRevisadoRefri(String revisadoRefri) {
        this.revisadoRefri = revisadoRefri;
    }

    public String getAprobadoRefri() {
        return aprobadoRefri;
    }

    public void setAprobadoRefri(String aprobadoRefri) {
        this.aprobadoRefri = aprobadoRefri;
    }

    public String getObservacionesRefri() {
        return observacionesRefri;
    }

    public void setObservacionesRefri(String observacionesRefri) {
        this.observacionesRefri = observacionesRefri;
    }


}
