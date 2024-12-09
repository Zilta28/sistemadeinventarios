/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth Ventura Talón
 */
public class compresionElectro {
    public int id;
    private String materialCom;
    private Date fechaCom;
    private String capacidadCom;
    private String unidadCom;
    private String marcaCom;
    private String modeloCom;
    private String noSerieCom;
    private String medicionAmpCom;
    private String medicionPresionCom;
    private String medicionSistemaCom;
    private String limpiezaGralCom;
    private String revisionAceiteCom;
    private String pinturaCom;
    private String revisionPurgadoCom;
    private String revisionTerminalCom;
    private String elaboradoCom;
    private String revisadoCom;
    private String aprobadoCom;
    private String observacionesCom;

    public compresionElectro() {
    }

    public compresionElectro(String materialCom, Date fechaCom, String capacidadCom, String unidadCom, String marcaCom, String modeloCom, String noSerieCom, String medicionAmpCom, String medicionPresionCom, String medicionSistemaCom, String limpiezaGralCom, String revisionAceiteCom, String pinturaCom, String revisionPurgadoCom, String revisionTerminalCom, String elaboradoCom, String revisadoCom, String aprobadoCom, String observacionesCom, int id) {
        this.materialCom = materialCom;
        this.fechaCom = fechaCom;
        this.capacidadCom = capacidadCom;
        this.unidadCom = unidadCom;
        this.marcaCom = marcaCom;
        this.modeloCom = modeloCom;
        this.noSerieCom = noSerieCom;
        this.medicionAmpCom = medicionAmpCom;
        this.medicionPresionCom = medicionPresionCom;
        this.medicionSistemaCom = medicionSistemaCom;
        this.limpiezaGralCom = limpiezaGralCom;
        this.revisionAceiteCom = revisionAceiteCom;
        this.pinturaCom = pinturaCom;
        this.revisionPurgadoCom = revisionPurgadoCom;
        this.revisionTerminalCom = revisionTerminalCom;
        this.elaboradoCom = elaboradoCom;
        this.revisadoCom = revisadoCom;
        this.aprobadoCom = aprobadoCom;
        this.observacionesCom = observacionesCom;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialCom() {
        return materialCom;
    }

    public void setMaterialCom(String materialCom) {
        this.materialCom = materialCom;
    }

    public Date getFechaCom() {
        return fechaCom;
    }

    public void setFechaCom(Date fechaCom) {
        this.fechaCom = fechaCom;
    }

    public String getCapacidadCom() {
        return capacidadCom;
    }

    public void setCapacidadCom(String capacidadCom) {
        this.capacidadCom = capacidadCom;
    }

    public String getUnidadCom() {
        return unidadCom;
    }

    public void setUnidadCom(String unidadCom) {
        this.unidadCom = unidadCom;
    }

    public String getMarcaCom() {
        return marcaCom;
    }

    public void setMarcaCom(String marcaCom) {
        this.marcaCom = marcaCom;
    }

    public String getModeloCom() {
        return modeloCom;
    }

    public void setModeloCom(String modeloCom) {
        this.modeloCom = modeloCom;
    }

    public String getNoSerieCom() {
        return noSerieCom;
    }

    public void setNoSerieCom(String noSerieCom) {
        this.noSerieCom = noSerieCom;
    }

    public String getMedicionAmpCom() {
        return medicionAmpCom;
    }

    public void setMedicionAmpCom(String medicionAmpCom) {
        this.medicionAmpCom = medicionAmpCom;
    }

    public String getMedicionPresionCom() {
        return medicionPresionCom;
    }

    public void setMedicionPresionCom(String medicionPresionCom) {
        this.medicionPresionCom = medicionPresionCom;
    }

    public String getMedicionSistemaCom() {
        return medicionSistemaCom;
    }

    public void setMedicionSistemaCom(String medicionSistemaCom) {
        this.medicionSistemaCom = medicionSistemaCom;
    }

    public String getLimpiezaGralCom() {
        return limpiezaGralCom;
    }

    public void setLimpiezaGralCom(String limpiezaGralCom) {
        this.limpiezaGralCom = limpiezaGralCom;
    }

    public String getRevisionAceiteCom() {
        return revisionAceiteCom;
    }

    public void setRevisionAceiteCom(String revisionAceiteCom) {
        this.revisionAceiteCom = revisionAceiteCom;
    }

    public String getPinturaCom() {
        return pinturaCom;
    }

    public void setPinturaCom(String pinturaCom) {
        this.pinturaCom = pinturaCom;
    }

    public String getRevisionPurgadoCom() {
        return revisionPurgadoCom;
    }

    public void setRevisionPurgadoCom(String revisionPurgadoCom) {
        this.revisionPurgadoCom = revisionPurgadoCom;
    }

    public String getRevisionTerminalCom() {
        return revisionTerminalCom;
    }

    public void setRevisionTerminalCom(String revisionTerminalCom) {
        this.revisionTerminalCom = revisionTerminalCom;
    }

    public String getElaboradoCom() {
        return elaboradoCom;
    }

    public void setElaboradoCom(String elaboradoCom) {
        this.elaboradoCom = elaboradoCom;
    }

    public String getRevisadoCom() {
        return revisadoCom;
    }

    public void setRevisadoCom(String revisadoCom) {
        this.revisadoCom = revisadoCom;
    }

    public String getAprobadoCom() {
        return aprobadoCom;
    }

    public void setAprobadoCom(String aprobadoCom) {
        this.aprobadoCom = aprobadoCom;
    }

    public String getObservacionesCom() {
        return observacionesCom;
    }

    public void setObservacionesCom(String observacionesCom) {
        this.observacionesCom = observacionesCom;
    }


}
