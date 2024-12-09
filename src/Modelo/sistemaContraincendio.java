
package Modelo;

import java.util.Date;


public class sistemaContraincendio {
    private int id;
    private Date fecha;
    private String material;
    private String prueba;
    private String observacion;
    private String elaborado;
    
    public sistemaContraincendio(){
        
    }

    public sistemaContraincendio(int id, Date fecha, String material, String prueba,String observacion, String elaborado) {
        this.id = id;
        this.fecha = fecha;
        this.material = material;
        this.prueba = prueba;
        this.observacion = observacion;
        this.elaborado = elaborado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPrueba() {
        return prueba;
    }

    public void setPrueba(String prueba) {
        this.prueba = prueba;
    }

public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getElaborado() {
        return elaborado;
    }

    public void setElaborado(String elaborado) {
        this.elaborado = elaborado;
    }
    
}
