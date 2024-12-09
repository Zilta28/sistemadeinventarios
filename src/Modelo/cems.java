
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class cems {
    public int id;
    private String materialC;
    private Date fechaC;
    private String buenEstadoC;
    private String observacionesC;
    private String elaboradoC;
    private String revisadoC;
    private String aprobadoC;

    public cems() {
    }

    public cems(String materialC, Date fechaC, String buenEstadoC, String observacionesC, String elaboradoC, String revisadoC, String aprobadoC, int id) {
        this.materialC = materialC;
        this.fechaC = fechaC;
        this.buenEstadoC = buenEstadoC;
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

    public String getBuenEstadoC() {
        return buenEstadoC;
    }

    public void setBuenEstadoC(String buenEstadoC) {
        this.buenEstadoC = buenEstadoC;
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
