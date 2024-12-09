
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class mecanoterapia {
    public int id;
    private String materialMeca;
    private Date fechaMeca;
    private String buenEstadoMeca;
    private String observacionesMeca;
    private String elaboradoMeca;
    private String revisadoMeca;
    private String aprobadoMeca;

    public mecanoterapia() {
    }

    public mecanoterapia(String materialMeca, Date fechaMeca, String buenEstadoMeca, String observacionesMeca, String elaboradoMeca, String revisadoMeca, String aprobadoMeca, int id) {
        this.materialMeca = materialMeca;
        this.fechaMeca = fechaMeca;
        this.buenEstadoMeca = buenEstadoMeca;
        this.observacionesMeca = observacionesMeca;
        this.elaboradoMeca = elaboradoMeca;
        this.revisadoMeca = revisadoMeca;
        this.aprobadoMeca = aprobadoMeca;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialMeca() {
        return materialMeca;
    }

    public void setMaterialMeca(String materialMeca) {
        this.materialMeca = materialMeca;
    }

    public Date getFechaMeca() {
        return fechaMeca;
    }

    public void setFechaMeca(Date fechaMeca) {
        this.fechaMeca = fechaMeca;
    }

    public String getBuenEstadoMeca() {
        return buenEstadoMeca;
    }

    public void setBuenEstadoMeca(String buenEstadoMeca) {
        this.buenEstadoMeca = buenEstadoMeca;
    }

    public String getObservacionesMeca() {
        return observacionesMeca;
    }

    public void setObservacionesMeca(String observacionesMeca) {
        this.observacionesMeca = observacionesMeca;
    }

    public String getElaboradoMeca() {
        return elaboradoMeca;
    }

    public void setElaboradoMeca(String elaboradoMeca) {
        this.elaboradoMeca = elaboradoMeca;
    }

    public String getRevisadoMeca() {
        return revisadoMeca;
    }

    public void setRevisadoMeca(String revisadoMeca) {
        this.revisadoMeca = revisadoMeca;
    }

    public String getAprobadoMeca() {
        return aprobadoMeca;
    }

    public void setAprobadoMeca(String aprobadoMeca) {
        this.aprobadoMeca = aprobadoMeca;
    }


}
