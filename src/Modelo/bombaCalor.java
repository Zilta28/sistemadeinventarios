
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth Ventura Talon
 */
public class bombaCalor {
    public int id;
    private String materialBC;
    private Date fechaBC;
    private String capacidadBC;
    private String unidadBC;
    private String marcaBC;
    private String modeloBC;
    private String noSerieBC;
    private String lavadoPresionBC;
    private String lavadoCondensadorBC;
    private String revisionMotorBC;
    private String revisionCompresorBC;
    private String medicionAmpBC;
    private String cambioTerminalesBC;
    private String pinturaBC;
    private String revisionValvulas;
    private String revisionFugas;
    private String revisionRefrigeranteBC;
    private String medicionPresionBC;
    private String revisionControlBC;
    private String observacionesBC;
    private String elaboradoBC;
    private String revisadoBC;
    private String aprobadoBC;


    public bombaCalor() {
    }

    public bombaCalor(String materialBC, Date fechaBC, String capacidadBC, String unidadBC, String marcaBC, String modeloBC, String noSerieBC, String lavadoPresionBC, String lavadoCondensadorBC, String revisionMotorBC, String revisionCompresorBC, String medicionAmpBC, String cambioTerminalesBC, String pinturaBC, String revisionValvulas, String revisionFugas, String revisionRefrigeranteBC, String medicionPresionBC, String revisionControlBC, String observacionesBC, String elaboradoBC, String revisadoBC, String aprobadoBC, int id) {
        this.materialBC = materialBC;
        this.fechaBC = fechaBC;
        this.capacidadBC = capacidadBC;
        this.unidadBC = unidadBC;
        this.marcaBC = marcaBC;
        this.modeloBC = modeloBC;
        this.noSerieBC = noSerieBC;
        this.lavadoPresionBC = lavadoPresionBC;
        this.lavadoCondensadorBC = lavadoCondensadorBC;
        this.revisionMotorBC = revisionMotorBC;
        this.revisionCompresorBC = revisionCompresorBC;
        this.medicionAmpBC = medicionAmpBC;
        this.cambioTerminalesBC = cambioTerminalesBC;
        this.pinturaBC = pinturaBC;
        this.revisionValvulas = revisionValvulas;
        this.revisionFugas = revisionFugas;
        this.revisionRefrigeranteBC = revisionRefrigeranteBC;
        this.medicionPresionBC = medicionPresionBC;
        this.revisionControlBC = revisionControlBC;
        this.observacionesBC = observacionesBC;
        this.elaboradoBC = elaboradoBC;
        this.revisadoBC = revisadoBC;
        this.aprobadoBC = aprobadoBC;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialBC() {
        return materialBC;
    }

    public void setMaterialBC(String materialBC) {
        this.materialBC = materialBC;
    }

    public Date getFechaBC() {
        return fechaBC;
    }

    public void setFechaBC(Date fechaBC) {
        this.fechaBC = fechaBC;
    }

    public String getCapacidadBC() {
        return capacidadBC;
    }

    public void setCapacidadBC(String capacidadBC) {
        this.capacidadBC = capacidadBC;
    }

    public String getUnidadBC() {
        return unidadBC;
    }

    public void setUnidadBC(String unidadBC) {
        this.unidadBC = unidadBC;
    }

    public String getMarcaBC() {
        return marcaBC;
    }

    public void setMarcaBC(String marcaBC) {
        this.marcaBC = marcaBC;
    }

    public String getModeloBC() {
        return modeloBC;
    }

    public void setModeloBC(String modeloBC) {
        this.modeloBC = modeloBC;
    }

    public String getNoSerieBC() {
        return noSerieBC;
    }

    public void setNoSerieBC(String noSerieBC) {
        this.noSerieBC = noSerieBC;
    }

    public String getLavadoPresionBC() {
        return lavadoPresionBC;
    }

    public void setLavadoPresionBC(String lavadoPresionBC) {
        this.lavadoPresionBC = lavadoPresionBC;
    }

    public String getLavadoCondensadorBC() {
        return lavadoCondensadorBC;
    }

    public void setLavadoCondensadorBC(String lavadoCondensadorBC) {
        this.lavadoCondensadorBC = lavadoCondensadorBC;
    }

    public String getRevisionMotorBC() {
        return revisionMotorBC;
    }

    public void setRevisionMotorBC(String revisionMotorBC) {
        this.revisionMotorBC = revisionMotorBC;
    }

    public String getRevisionCompresorBC() {
        return revisionCompresorBC;
    }

    public void setRevisionCompresorBC(String revisionCompresorBC) {
        this.revisionCompresorBC = revisionCompresorBC;
    }

    public String getMedicionAmpBC() {
        return medicionAmpBC;
    }

    public void setMedicionAmpBC(String medicionAmpBC) {
        this.medicionAmpBC = medicionAmpBC;
    }

    public String getCambioTerminalesBC() {
        return cambioTerminalesBC;
    }

    public void setCambioTerminalesBC(String cambioTerminalesBC) {
        this.cambioTerminalesBC = cambioTerminalesBC;
    }

    public String getPinturaBC() {
        return pinturaBC;
    }

    public void setPinturaBC(String pinturaBC) {
        this.pinturaBC = pinturaBC;
    }

    public String getRevisionValvulas() {
        return revisionValvulas;
    }

    public String getRevisionFugas() {
        return revisionFugas;
    }

    public void setRevisionFugas(String revisionFugas) {
        this.revisionFugas = revisionFugas;
    }

    public void setRevisionValvulas(String revisionValvulas) {
        this.revisionValvulas = revisionValvulas;
    }

    public String getRevisionRefrigeranteBC() {
        return revisionRefrigeranteBC;
    }

    public void setRevisionRefrigeranteBC(String revisionRefrigeranteBC) {
        this.revisionRefrigeranteBC = revisionRefrigeranteBC;
    }

    public String getMedicionPresionBC() {
        return medicionPresionBC;
    }

    public void setMedicionPresionBC(String medicionPresionBC) {
        this.medicionPresionBC = medicionPresionBC;
    }

    public String getRevisionControlBC() {
        return revisionControlBC;
    }

    public void setRevisionControlBC(String revisionControlBC) {
        this.revisionControlBC = revisionControlBC;
    }

    public String getObservacionesBC() {
        return observacionesBC;
    }

    public void setObservacionesBC(String observacionesBC) {
        this.observacionesBC = observacionesBC;
    }

    public String getElaboradoBC() {
        return elaboradoBC;
    }

    public void setElaboradoBC(String elaboradoBC) {
        this.elaboradoBC = elaboradoBC;
    }

    public String getRevisadoBC() {
        return revisadoBC;
    }

    public void setRevisadoBC(String revisadoBC) {
        this.revisadoBC = revisadoBC;
    }

    public String getAprobadoBC() {
        return aprobadoBC;
    }

    public void setAprobadoBC(String aprobadoBC) {
        this.aprobadoBC = aprobadoBC;
    }


}
