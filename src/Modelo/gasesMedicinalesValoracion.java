
package Modelo;

import java.util.Date;

public class gasesMedicinalesValoracion {
    private int id;
    private Date fechaV;
    private String tipoGasV;
    private String diaV;
    private String presionTanqueV;
    private String reservaV;
    private String limpiezaV;
    private String nombreRealizoInventarioV;
    private String observacionV;
    
    public gasesMedicinalesValoracion(){
        
    }

    public gasesMedicinalesValoracion(int id, Date fechaV, String tipoGasV, String diaV, String presionTanqueV, String reservaV, String limpiezaV, String nombreRealizoInventarioV, String observacionV) {
        this.fechaV = fechaV;
        this.tipoGasV = tipoGasV;
        this.diaV = diaV;
        this.presionTanqueV = presionTanqueV;
        this.reservaV = reservaV;
        this.limpiezaV = limpiezaV;
        this.nombreRealizoInventarioV = nombreRealizoInventarioV;
        this.observacionV = observacionV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getFechaV() {
        return fechaV;
    }

    public void setFechaV(Date fechaV) {
        this.fechaV = fechaV;
    }

    public String getTipoGasV() {
        return tipoGasV;
    }

    public void setTipoGasV(String tipoGasV) {
        this.tipoGasV = tipoGasV;
    }

    public String getDiaV() {
        return diaV;
    }

    public void setDiaV(String diaV) {
        this.diaV = diaV;
    }

    public String getPresionTanqueV() {
        return presionTanqueV;
    }

    public void setPresionTanqueV(String presionTanqueV) {
        this.presionTanqueV = presionTanqueV;
    }

    public String getReservaV() {
        return reservaV;
    }

    public void setReservaV(String reservaV) {
        this.reservaV = reservaV;
    }

    public String getLimpiezaV() {
        return limpiezaV;
    }

    public void setLimpiezaV(String limpiezaV) {
        this.limpiezaV = limpiezaV;
    }

    public String getNombreRealizoInventarioV() {
        return nombreRealizoInventarioV;
    }

    public void setNombreRealizoInventarioV(String nombreRealizoInventarioV) {
        this.nombreRealizoInventarioV = nombreRealizoInventarioV;
    }

    public String getObservacionV() {
        return observacionV;
    }

    public void setObservacionV(String observacionV) {
        this.observacionV = observacionV;
    }
    
}