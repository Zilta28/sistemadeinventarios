
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth Ventura Talón
 */
public class aireAcondicionado {
    public int id;
    private String materialAire;
    private Date fechaAire;
    private String limpiezaSerAire;
    private String limpiezaFiltroAire;
    private String revisionFugaAire;
    private String medicionPresionAire;
    private String medicionAmpAire;
    private String tornilleriaAire;
    private String pinturaAire;
    private String limpiezaPanelControl;
    private String lubricacionAire;
    private String verificarAire;
    private String destaparDrenesAire;
    private String limpiezaEvaporadorAire;
    private String elaboradoAire;
    private String revisadoAire;
    private String aprobadoAire;
    private String observacionesAire;

    public aireAcondicionado() {
    }

    public aireAcondicionado(String materialAire, Date fechaAire, String limpiezaSerAire, String limpiezaFiltroAire, String revisionFugaAire, String medicionPresionAire, String medicionAmpAire, String tornilleriaAire, String pinturaAire, String limpiezaPanelControl, String lubricacionAire, String verificarAire, String destaparDrenesAire,String limpiezaEvaporadorAire, String elaboradoAire, String revisadoAire, String aprobadoAire, String observacionesAire, int id) {
        this.materialAire = materialAire;
        this.fechaAire = fechaAire;
        this.limpiezaSerAire = limpiezaSerAire;
        this.limpiezaFiltroAire = limpiezaFiltroAire;
        this.revisionFugaAire = revisionFugaAire;
        this.medicionPresionAire = medicionPresionAire;
        this.medicionAmpAire = medicionAmpAire;
        this.tornilleriaAire = tornilleriaAire;
        this.pinturaAire = pinturaAire;
        this.limpiezaPanelControl = limpiezaPanelControl;
        this.lubricacionAire = lubricacionAire;
        this.verificarAire = verificarAire;
        this.destaparDrenesAire = destaparDrenesAire;
        this.limpiezaEvaporadorAire = limpiezaEvaporadorAire;
        this.elaboradoAire = elaboradoAire;
        this.revisadoAire = revisadoAire;
        this.aprobadoAire = aprobadoAire;
        this.observacionesAire = observacionesAire;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialAire() {
        return materialAire;
    }

    public void setMaterialAire(String materialAire) {
        this.materialAire = materialAire;
    }

    public Date getFechaAire() {
        return fechaAire;
    }

    public void setFechaAire(Date fechaAire) {
        this.fechaAire = fechaAire;
    }

    public String getLimpiezaSerAire() {
        return limpiezaSerAire;
    }

    public void setLimpiezaSerAire(String limpiezaSerAire) {
        this.limpiezaSerAire = limpiezaSerAire;
    }

    public String getLimpiezaFiltroAire() {
        return limpiezaFiltroAire;
    }

    public void setLimpiezaFiltroAire(String limpiezaFiltroAire) {
        this.limpiezaFiltroAire = limpiezaFiltroAire;
    }

    public String getRevisionFugaAire() {
        return revisionFugaAire;
    }

    public void setRevisionFugaAire(String revisionFugaAire) {
        this.revisionFugaAire = revisionFugaAire;
    }

    public String getMedicionPresionAire() {
        return medicionPresionAire;
    }

    public void setMedicionPresionAire(String medicionPresionAire) {
        this.medicionPresionAire = medicionPresionAire;
    }

    public String getMedicionAmpAire() {
        return medicionAmpAire;
    }

    public void setMedicionAmpAire(String medicionAmpAire) {
        this.medicionAmpAire = medicionAmpAire;
    }

    public String getTornilleriaAire() {
        return tornilleriaAire;
    }

    public void setTornilleriaAire(String tornilleriaAire) {
        this.tornilleriaAire = tornilleriaAire;
    }

    public String getPinturaAire() {
        return pinturaAire;
    }

    public void setPinturaAire(String pinturaAire) {
        this.pinturaAire = pinturaAire;
    }

    public String getLimpiezaPanelControl() {
        return limpiezaPanelControl;
    }

    public void setLimpiezaPanelControl(String limpiezaPanelControl) {
        this.limpiezaPanelControl = limpiezaPanelControl;
    }

    public String getLubricacionAire() {
        return lubricacionAire;
    }

    public void setLubricacionAire(String lubricacionAire) {
        this.lubricacionAire = lubricacionAire;
    }

    public String getVerificarAire() {
        return verificarAire;
    }

    public void setVerificarAire(String verificarAire) {
        this.verificarAire = verificarAire;
    }

    public String getDestaparDrenesAire() {
        return destaparDrenesAire;
    }

    public void setDestaparDrenesAire(String destaparDrenesAire) {
        this.destaparDrenesAire = destaparDrenesAire;
    }

    public String getLimpiezaEvaporadorAire() {
        return limpiezaEvaporadorAire;
    }

    public void setLimpiezaEvaporadorAire(String limpiezaEvaporadorAire) {
        this.limpiezaEvaporadorAire = limpiezaEvaporadorAire;
    }


    public String getElaboradoAire() {
        return elaboradoAire;
    }

    public void setElaboradoAire(String elaboradoAire) {
        this.elaboradoAire = elaboradoAire;
    }

    public String getRevisadoAire() {
        return revisadoAire;
    }

    public void setRevisadoAire(String revisadoAire) {
        this.revisadoAire = revisadoAire;
    }

    public String getAprobadoAire() {
        return aprobadoAire;
    }

    public void setAprobadoAire(String aprobadoAire) {
        this.aprobadoAire = aprobadoAire;
    }

    public String getObservacionesAire() {
        return observacionesAire;
    }

    public void setObservacionesAire(String observacionesAire) {
        this.observacionesAire = observacionesAire;
    }


}
