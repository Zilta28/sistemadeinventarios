
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class dosificador {
    public int id;
    private String materialDosi;
    private Date fechaDosi;
    private String selladoDosi;
    private String fugasDosi;
    private String cableadoDosi;
    private String limpiezaExtDosi;
    private String limpiezaIntDosi;
    private String limpiezaEvaDosi;
    private String medicionAmpDosi;
    private String observacionesDosi;
    private String elaboradoDosi;
    private String revisadoDosi;
    private String aprobadoDosi;


    public dosificador() {
    }

    public dosificador(String materialDosi, Date fechaDosi, String selladoDosi, String fugasDosi, String cableadoDosi, String limpiezaExtDosi, String limpiezaIntDosi, String limpiezaEvaDosi, String medicionAmpDosi, String observacionesDosi, String elaboradoDosi, String revisadoDosi, String aprobadoDosi, int id) {
        this.materialDosi = materialDosi;
        this.fechaDosi = fechaDosi;
        this.selladoDosi = selladoDosi;
        this.fugasDosi = fugasDosi;
        this.cableadoDosi = cableadoDosi;
        this.limpiezaExtDosi = limpiezaExtDosi;
        this.limpiezaIntDosi = limpiezaIntDosi;
        this.limpiezaEvaDosi = limpiezaEvaDosi;
        this.medicionAmpDosi = medicionAmpDosi;
        this.observacionesDosi = observacionesDosi;
        this.elaboradoDosi = elaboradoDosi;
        this.revisadoDosi = revisadoDosi;
        this.aprobadoDosi = aprobadoDosi;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialDosi() {
        return materialDosi;
    }

    public void setMaterialDosi(String materialDosi) {
        this.materialDosi = materialDosi;
    }

    public Date getFechaDosi() {
        return fechaDosi;
    }

    public void setFechaDosi(Date fechaDosi) {
        this.fechaDosi = fechaDosi;
    }

    public String getSelladoDosi() {
        return selladoDosi;
    }

    public void setSelladoDosi(String selladoDosi) {
        this.selladoDosi = selladoDosi;
    }

    public String getFugasDosi() {
        return fugasDosi;
    }

    public void setFugasDosi(String fugasDosi) {
        this.fugasDosi = fugasDosi;
    }

    public String getCableadoDosi() {
        return cableadoDosi;
    }

    public void setCableadoDosi(String cableadoDosi) {
        this.cableadoDosi = cableadoDosi;
    }

    public String getLimpiezaExtDosi() {
        return limpiezaExtDosi;
    }

    public void setLimpiezaExtDosi(String limpiezaExtDosi) {
        this.limpiezaExtDosi = limpiezaExtDosi;
    }

    public String getLimpiezaIntDosi() {
        return limpiezaIntDosi;
    }

    public void setLimpiezaIntDosi(String limpiezaIntDosi) {
        this.limpiezaIntDosi = limpiezaIntDosi;
    }

    public String getLimpiezaEvaDosi() {
        return limpiezaEvaDosi;
    }

    public void setLimpiezaEvaDosi(String limpiezaEvaDosi) {
        this.limpiezaEvaDosi = limpiezaEvaDosi;
    }

    public String getMedicionAmpDosi() {
        return medicionAmpDosi;
    }

    public void setMedicionAmpDosi(String medicionAmpDosi) {
        this.medicionAmpDosi = medicionAmpDosi;
    }

    public String getElaboradoDosi() {
        return elaboradoDosi;
    }

    public void setElaboradoDosi(String elaboradoDosi) {
        this.elaboradoDosi = elaboradoDosi;
    }

    public String getRevisadoDosi() {
        return revisadoDosi;
    }

    public void setRevisadoDosi(String revisadoDosi) {
        this.revisadoDosi = revisadoDosi;
    }

    public String getAprobadoDosi() {
        return aprobadoDosi;
    }

    public void setAprobadoDosi(String aprobadoDosi) {
        this.aprobadoDosi = aprobadoDosi;
    }

    public String getObservacionesDosi() {
        return observacionesDosi;
    }

    public void setObservacionesDosi(String observacionesDosi) {
        this.observacionesDosi = observacionesDosi;
    }


}
