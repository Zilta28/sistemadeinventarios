
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class bombas {
    public int id;
    private String materialBom;
    private Date fechaBom;
    private String rodamientoBom;
    private String selloBom;
    private String ampBom;
    private String tempBom;
    private String terminalesBom;
    private String accionamientoBom;
    private String pinturaBom;
    private String manometroBom;
    private String elaboradoBom;
    private String revisadoBom;
    private String aprobadoBom;
    private String observacionesBom;

    public bombas() {
    }

    public bombas(String materialBom, Date fechaBom, String rodamientoBom, String selloBom, String ampBom, String tempBom, String terminalesBom, String accionamientoBom, String pinturaBom, String manometroBom, String elaboradoBom, String revisadoBom, String aprobadoBom, String observacionesBom, int id) {
        this.materialBom = materialBom;
        this.fechaBom = fechaBom;
        this.rodamientoBom = rodamientoBom;
        this.selloBom = selloBom;
        this.ampBom = ampBom;
        this.tempBom = tempBom;
        this.terminalesBom = terminalesBom;
        this.accionamientoBom = accionamientoBom;
        this.pinturaBom = pinturaBom;
        this.manometroBom = manometroBom;
        this.elaboradoBom = elaboradoBom;
        this.revisadoBom = revisadoBom;
        this.aprobadoBom = aprobadoBom;
        this.observacionesBom = observacionesBom;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialBom() {
        return materialBom;
    }

    public void setMaterialBom(String materialBom) {
        this.materialBom = materialBom;
    }

    public Date getFechaBom() {
        return fechaBom;
    }

    public void setFechaBom(Date fechaBom) {
        this.fechaBom = fechaBom;
    }

    public String getRodamientoBom() {
        return rodamientoBom;
    }

    public void setRodamientoBom(String rodamientoBom) {
        this.rodamientoBom = rodamientoBom;
    }

    public String getSelloBom() {
        return selloBom;
    }

    public void setSelloBom(String selloBom) {
        this.selloBom = selloBom;
    }

    public String getAmpBom() {
        return ampBom;
    }

    public void setAmpBom(String ampBom) {
        this.ampBom = ampBom;
    }

    public String getTempBom() {
        return tempBom;
    }

    public void setTempBom(String tempBom) {
        this.tempBom = tempBom;
    }

    public String getTerminalesBom() {
        return terminalesBom;
    }

    public void setTerminalesBom(String terminalesBom) {
        this.terminalesBom = terminalesBom;
    }

    public String getAccionamientoBom() {
        return accionamientoBom;
    }

    public void setAccionamientoBom(String accionamientoBom) {
        this.accionamientoBom = accionamientoBom;
    }

    public String getPinturaBom() {
        return pinturaBom;
    }

    public void setPinturaBom(String pinturaBom) {
        this.pinturaBom = pinturaBom;
    }

    public String getManometroBom() {
        return manometroBom;
    }

    public void setManometroBom(String manometroBom) {
        this.manometroBom = manometroBom;
    }

    public String getElaboradoBom() {
        return elaboradoBom;
    }

    public void setElaboradoBom(String elaboradoBom) {
        this.elaboradoBom = elaboradoBom;
    }

    public String getRevisadoBom() {
        return revisadoBom;
    }

    public void setRevisadoBom(String revisadoBom) {
        this.revisadoBom = revisadoBom;
    }

    public String getAprobadoBom() {
        return aprobadoBom;
    }

    public void setAprobadoBom(String aprobadoBom) {
        this.aprobadoBom = aprobadoBom;
    }

    public String getObservacionesBom() {
        return observacionesBom;
    }

    public void setObservacionesBom(String observacionesBom) {
        this.observacionesBom = observacionesBom;
    }


}
