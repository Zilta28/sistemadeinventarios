
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth Ventura Talón
 */
public class calderaElectro {
    public int id;
    private String materialC;
    private Date fechaC;
    private String capacidadC;
    private String unidadC;
    private String marcaC;
    private String modeloC;
    private String noSerieC;
    private String limpiezaChimeneaC;
    private String limpiezaCeniceroC;
    private String limpiezaQuemadorC;
    private String limpiezaPilotoC;
    private String revisionFlamaC;
    private String revisionManometroC;
    private String revisionValvulasC;
    private String revisionSistemaC;
    private String medicionAmpC;
    private String observacionesC;
    private String elaboradoC;
    private String revisadoC;
    private String aprobadoC;

    public calderaElectro() {
    }

    public calderaElectro(String materialC, Date fechaC, String capacidadC, String unidadC, String marcaC, String modeloC, String noSerieC, String limpiezaChimeneaC, String limpiezaCeniceroC, String limpiezaQuemadorC, String limpiezaPilotoC, String revisionFlamaC, String revisionManometroC, String revisionValvulasC, String revisionSistemaC, String medicionAmpC, String observacionesC, String elaboradoC, String revisadoC, String aprobadoC, int id) {
        this.materialC = materialC;
        this.fechaC = fechaC;
        this.capacidadC = capacidadC;
        this.unidadC = unidadC;
        this.marcaC = marcaC;
        this.modeloC = modeloC;
        this.noSerieC = noSerieC;
        this.limpiezaChimeneaC = limpiezaChimeneaC;
        this.limpiezaCeniceroC = limpiezaCeniceroC;
        this.limpiezaQuemadorC = limpiezaQuemadorC;
        this.limpiezaPilotoC = limpiezaPilotoC;
        this.revisionFlamaC = revisionFlamaC;
        this.revisionManometroC = revisionManometroC;
        this.revisionValvulasC = revisionValvulasC;
        this.revisionSistemaC = revisionSistemaC;
        this.medicionAmpC = medicionAmpC;
        this.observacionesC = observacionesC;
        this.elaboradoC = elaboradoC;
        this.revisadoC = revisadoC;
        this.aprobadoC = aprobadoC;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialC() {
        return materialC;
    }

    public void setMaterialC(String materialC) {
        this.materialC = materialC;
    }

    public Date getFechaC() {
        return fechaC;
    }

    public void setFechaC(Date fechaC) {
        this.fechaC = fechaC;
    }

    public String getCapacidadC() {
        return capacidadC;
    }

    public void setCapacidadC(String capacidadC) {
        this.capacidadC = capacidadC;
    }

    public String getUnidadC() {
        return unidadC;
    }

    public void setUnidadC(String unidadC) {
        this.unidadC = unidadC;
    }

    public String getMarcaC() {
        return marcaC;
    }

    public void setMarcaC(String marcaC) {
        this.marcaC = marcaC;
    }

    public String getModeloC() {
        return modeloC;
    }

    public void setModeloC(String modeloC) {
        this.modeloC = modeloC;
    }

    public String getNoSerieC() {
        return noSerieC;
    }

    public void setNoSerieC(String noSerieC) {
        this.noSerieC = noSerieC;
    }

    public String getLimpiezaChimeneaC() {
        return limpiezaChimeneaC;
    }

    public void setLimpiezaChimeneaC(String limpiezaChimeneaC) {
        this.limpiezaChimeneaC = limpiezaChimeneaC;
    }

    public String getLimpiezaCeniceroC() {
        return limpiezaCeniceroC;
    }

    public void setLimpiezaCeniceroC(String limpiezaCeniceroC) {
        this.limpiezaCeniceroC = limpiezaCeniceroC;
    }

    public String getLimpiezaQuemadorC() {
        return limpiezaQuemadorC;
    }

    public void setLimpiezaQuemadorC(String limpiezaQuemadorC) {
        this.limpiezaQuemadorC = limpiezaQuemadorC;
    }

    public String getLimpiezaPilotoC() {
        return limpiezaPilotoC;
    }

    public void setLimpiezaPilotoC(String limpiezaPilotoC) {
        this.limpiezaPilotoC = limpiezaPilotoC;
    }

    public String getRevisionFlamaC() {
        return revisionFlamaC;
    }

    public void setRevisionFlamaC(String revisionFlamaC) {
        this.revisionFlamaC = revisionFlamaC;
    }

    public String getRevisionManometroC() {
        return revisionManometroC;
    }

    public void setRevisionManometroC(String revisionManometroC) {
        this.revisionManometroC = revisionManometroC;
    }

    public String getRevisionValvulasC() {
        return revisionValvulasC;
    }

    public void setRevisionValvulasC(String revisionValvulasC) {
        this.revisionValvulasC = revisionValvulasC;
    }

    public String getRevisionSistemaC() {
        return revisionSistemaC;
    }

    public void setRevisionSistemaC(String revisionSistemaC) {
        this.revisionSistemaC = revisionSistemaC;
    }

    public String getMedicionAmpC() {
        return medicionAmpC;
    }

    public void setMedicionAmpC(String medicionAmpC) {
        this.medicionAmpC = medicionAmpC;
    }

    public String getObservacionesC() {
        return observacionesC;
    }

    public void setObservacionesC(String observacionesC) {
        this.observacionesC = observacionesC;
    }

    public String getElaboradoC() {
        return elaboradoC;
    }

    public void setElaboradoC(String elaboradoC) {
        this.elaboradoC = elaboradoC;
    }

    public String getRevisadoC() {
        return revisadoC;
    }

    public void setRevisadoC(String revisadoC) {
        this.revisadoC = revisadoC;
    }

    public String getAprobadoC() {
        return aprobadoC;
    }

    public void setAprobadoC(String aprobadoC) {
        this.aprobadoC = aprobadoC;
    }


}
