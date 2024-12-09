
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class odontopediatria {
    public int id;
    private String materialOdo;
    private Date fechaOdo;
    private String buenEstadoOdo;
    private String observacionesOdo;
    private String elaboradoOdo;
    private String revisadoOdo;
    private String aprobadoOdo;

    public odontopediatria() {
    }

    public odontopediatria(String materialOdo, Date fechaOdo, String buenEstadoOdo, String observacionesOdo, String elaboradoOdo, String revisadoOdo, String aprobadoOdo, int id) {
        this.materialOdo = materialOdo;
        this.fechaOdo = fechaOdo;
        this.buenEstadoOdo = buenEstadoOdo;
        this.observacionesOdo = observacionesOdo;
        this.elaboradoOdo = elaboradoOdo;
        this.revisadoOdo = revisadoOdo;
        this.aprobadoOdo = aprobadoOdo;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialOdo() {
        return materialOdo;
    }

    public void setMaterialOdo(String materialOdo) {
        this.materialOdo = materialOdo;
    }

    public Date getFechaOdo() {
        return fechaOdo;
    }

    public void setFechaOdo(Date fechaOdo) {
        this.fechaOdo = fechaOdo;
    }

    public String getBuenEstadoOdo() {
        return buenEstadoOdo;
    }

    public void setBuenEstadoOdo(String buenEstadoOdo) {
        this.buenEstadoOdo = buenEstadoOdo;
    }

    public String getObservacionesOdo() {
        return observacionesOdo;
    }

    public void setObservacionesOdo(String observacionesOdo) {
        this.observacionesOdo = observacionesOdo;
    }

    public String getElaboradoOdo() {
        return elaboradoOdo;
    }

    public void setElaboradoOdo(String elaboradoOdo) {
        this.elaboradoOdo = elaboradoOdo;
    }

    public String getRevisadoOdo() {
        return revisadoOdo;
    }

    public void setRevisadoOdo(String revisadoOdo) {
        this.revisadoOdo = revisadoOdo;
    }

    public String getAprobadoOdo() {
        return aprobadoOdo;
    }

    public void setAprobadoOdo(String aprobadoOdo) {
        this.aprobadoOdo = aprobadoOdo;
    }


}
