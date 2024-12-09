
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class enfermeria {
    public int id;
    private String materialEnf;
    private Date fechaEnf;
    private String buenEstadoEnf;
    private String observacionesEnf;
    private String elaboradoEnf;
    private String revisadoEnf;
    private String aprobadoEnf;

    public enfermeria() {
    }

    public enfermeria(String materialEnf, Date fechaEnf, String buenEstadoEnf, String observacionesEnf, String elaboradoEnf, String revisadoEnf, String aprobadoEnf, int id) {
        this.materialEnf = materialEnf;
        this.fechaEnf = fechaEnf;
        this.buenEstadoEnf = buenEstadoEnf;
        this.observacionesEnf = observacionesEnf;
        this.elaboradoEnf = elaboradoEnf;
        this.revisadoEnf = revisadoEnf;
        this.aprobadoEnf = aprobadoEnf;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialEnf() {
        return materialEnf;
    }

    public void setMaterialEnf(String materialEnf) {
        this.materialEnf = materialEnf;
    }

    public Date getFechaEnf() {
        return fechaEnf;
    }

    public void setFechaEnf(Date fechaEnf) {
        this.fechaEnf = fechaEnf;
    }

    public String getBuenEstadoEnf() {
        return buenEstadoEnf;
    }

    public void setBuenEstadoEnf(String buenEstadoEnf) {
        this.buenEstadoEnf = buenEstadoEnf;
    }

    public String getObservacionesEnf() {
        return observacionesEnf;
    }

    public void setObservacionesEnf(String observacionesEnf) {
        this.observacionesEnf = observacionesEnf;
    }

    public String getElaboradoEnf() {
        return elaboradoEnf;
    }

    public void setElaboradoEnf(String elaboradoEnf) {
        this.elaboradoEnf = elaboradoEnf;
    }

    public String getRevisadoEnf() {
        return revisadoEnf;
    }

    public void setRevisadoEnf(String revisadoEnf) {
        this.revisadoEnf = revisadoEnf;
    }

    public String getAprobadoEnf() {
        return aprobadoEnf;
    }

    public void setAprobadoEnf(String aprobadoEnf) {
        this.aprobadoEnf = aprobadoEnf;
    }


}
