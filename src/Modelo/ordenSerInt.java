
package Modelo;

import java.util.Date;


public class ordenSerInt {
    private int id;
    private Date fecha;
    private String equipo;
    private String oficina;
    private String nameSolicito;
    private String equipo2;
    private String marca;
    private String modelo;
    private String serie;
    private String tipoMantenimiento;
    private String desMantenimiento;
    private String observacion;
    
    public ordenSerInt(){
        
    }

    public ordenSerInt(int id, Date fecha, String equipo, String oficina, String nameSolicito, String equipo2, String marca, String modelo, String serie, String tipoMantenimiento, String desMantenimiento, String observacion) {
        this.fecha = fecha;
        this.equipo = equipo;
        this.oficina = oficina;
        this.nameSolicito = nameSolicito;
        this.equipo2 = equipo2;
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.tipoMantenimiento = tipoMantenimiento;
        this.desMantenimiento = desMantenimiento;
        this.observacion = observacion;
        this.id = id;
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNameSolicito() {
        return nameSolicito;
    }

    public void setNameSolicito(String nameSolicito) {
        this.nameSolicito = nameSolicito;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    public String getDesMantenimiento() {
        return desMantenimiento;
    }

    public void setDesMantenimiento(String desMantenimiento) {
        this.desMantenimiento = desMantenimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
