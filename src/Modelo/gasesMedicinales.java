package Modelo;

import java.util.Date;

public class gasesMedicinales {
    private int id;
    private Date fechaMed;
    private String tipoGas;
    private String presionTanque;
    private String reserva;
    private String limpieza;
    private String nombreRealizoInventario;
    private String observacion;

    public gasesMedicinales() {

    }

    public gasesMedicinales(int id, Date fechaMed, String tipoGas, String presionTanque, String reserva, String nombreRealizoInventario, String limpieza, String observacion) {
        this.fechaMed = fechaMed;
        this.tipoGas = tipoGas;
        this.presionTanque = presionTanque;
        this.reserva = reserva;
        this.nombreRealizoInventario = nombreRealizoInventario;
        this.limpieza = limpieza;
        this.observacion = observacion;
        this.id = id;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaMed() {
        return fechaMed;
    }

    public void setFechaMed(Date fechaMed) {
        this.fechaMed = fechaMed;
    }

    public String getPresionTanque() {
        return presionTanque;
    }

    public void setPresionTanque(String presionTanque) {
        this.presionTanque = presionTanque;
    }

    public String getReserva() {
        return reserva;
    }

    public void setReserva(String reserva) {
        this.reserva = reserva;
    }
        public String getLimpieza() {
        return limpieza;
    }

    public void setLimpieza(String limpieza) {
        this.limpieza = limpieza;
    }

    public String getNombreRealizoInventario() {
        return nombreRealizoInventario;
    }

    public void setNombreRealizoInventario(String nombreRealizoInventario) {
        this.nombreRealizoInventario = nombreRealizoInventario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getTipoGas() {
        return tipoGas;
    }

    public void setTipoGas(String tipoGas) {
        this.tipoGas = tipoGas;
    }
   
}
