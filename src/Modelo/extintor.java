
package Modelo;

import java.util.Date;

public class extintor {
    private int id;
    private String noExtintor;
    private Date fechaExtintor;
    private String marca; 
    private String agente;
    private String capacidad;
    private String ultimaRecarga;
    private String proximaRecarga;
    private String corrosion;
    private String escapePresion;
    private String golpesDeformaciones;
    private String expoFuego;
    private String roturas;
    private String desprendimientoS;
    private String protuberancias;
    private String perforaciones;
    private String obstrucciones;
    private String lugarAccesible;
    private String letreroSenalizacion;
    private String etiquetasLegibles;
    private String manometro;
    private String horquillaYcincho;
    private String observacionesEx;
    private String elaboradoExt;
    
    
    public extintor(){
        
    }

    public extintor(int id, String noExtintor, Date fechaExtintor, String marca, String agente, String capacidad, String ultimaRecarga, String proximaRecarga, String corrosion, String escapePresion, 
                    String golpesDeformaciones, String expoFuego, String roturas, String desprendimientoS, String protuberancias, String perforaciones, String obstrucciones,
                    String lugarAccesible, String letreroSeñalizacion, String etiquetasLegibles, String manometro, String horquillaYcincho, String observacionesEx, String elaboradoExt) {
        this.noExtintor = noExtintor;
        this.marca = marca;
        this.agente = agente;
        this.capacidad = capacidad;
        this.ultimaRecarga = ultimaRecarga;
        this.proximaRecarga = proximaRecarga;
        this.corrosion = corrosion;
        this.escapePresion = escapePresion;
        this.golpesDeformaciones = golpesDeformaciones;
        this.expoFuego = expoFuego;
        this.roturas = roturas;
        this.desprendimientoS = desprendimientoS; 
        this.protuberancias = protuberancias; 
        this.perforaciones = perforaciones;
        this.obstrucciones = obstrucciones;
        this.lugarAccesible = lugarAccesible;
        this.letreroSenalizacion = letreroSeñalizacion;
        this.etiquetasLegibles = etiquetasLegibles; 
        this.manometro = manometro; 
        this.horquillaYcincho = horquillaYcincho;
        this.observacionesEx = observacionesEx;
        this.elaboradoExt = elaboradoExt;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNoExtintor() {
        return noExtintor;
    }

    public void setNoExtintor(String noExtintor) {
        this.noExtintor = noExtintor;
    }

    public Date getFechaExtintor() {
        return fechaExtintor;
    }

    public void setFechaExtintor(Date fechaExtintor) {
        this.fechaExtintor = fechaExtintor;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getUltimaRecarga() {
        return ultimaRecarga;
    }

    public void setUltimaRecarga(String ultimaRecarga) {
        this.ultimaRecarga = ultimaRecarga;
    }

    public String getProximaRecarga() {
        return proximaRecarga;
    }

    public void setProximaRecarga(String proximaRecarga) {
        this.proximaRecarga = proximaRecarga;
    }

    public String getCorrosion() {
        return corrosion;
    }

    public void setCorrosion(String corrosion) {
        this.corrosion = corrosion;
    }

    public String getEscapePresion() {
        return escapePresion;
    }

    public void setEscapePresion(String escapePresion) {
        this.escapePresion = escapePresion;
    }

    public String getGolpesDeformaciones() {
        return golpesDeformaciones;
    }

    public void setGolpesDeformaciones(String golpesDeformaciones) {
        this.golpesDeformaciones = golpesDeformaciones;
    }

    public String getExpoFuego() {
        return expoFuego;
    }

    public void setExpoFuego(String expoFuego) {
        this.expoFuego = expoFuego;
    }

    public String getRoturas() {
        return roturas;
    }

    public void setRoturas(String roturas) {
        this.roturas = roturas;
    }

    public String getDesprendimientoS() {
        return desprendimientoS;
    }

    public void setDesprendimientoS(String desprendimientoS) {
        this.desprendimientoS = desprendimientoS;
    }

    public String getProtuberancias() {
        return protuberancias;
    }

    public void setProtuberancias(String protuberancias) {
        this.protuberancias = protuberancias;
    }

    public String getPerforaciones() {
        return perforaciones;
    }

    public void setPerforaciones(String perforaciones) {
        this.perforaciones = perforaciones;
    }

    public String getObstrucciones() {
        return obstrucciones;
    }

    public void setObstrucciones(String obstrucciones) {
        this.obstrucciones = obstrucciones;
    }

    public String getLugarAccesible() {
        return lugarAccesible;
    }

    public void setLugarAccesible(String lugarAccesible) {
        this.lugarAccesible = lugarAccesible;
    }

    public String getLetreroSenalizacion() {
        return letreroSenalizacion;
    }

    public void setLetreroSenalizacion(String letreroSenalizacion) {
        this.letreroSenalizacion = letreroSenalizacion;
    }

    public String getEtiquetasLegibles() {
        return etiquetasLegibles;
    }

    public void setEtiquetasLegibles(String etiquetasLegibles) {
        this.etiquetasLegibles = etiquetasLegibles;
    }

    public String getManometro() {
        return manometro;
    }

    public void setManometro(String manometro) {
        this.manometro = manometro;
    }

    public String getHorquillaYcincho() {
        return horquillaYcincho;
    }

    public void setHorquillaYcincho(String horquillaYcincho) {
        this.horquillaYcincho = horquillaYcincho;
    }

    public String getObservacionesEx() {
        return observacionesEx;
    }

    public void setObservacionesEx(String observacionesEx) {
        this.observacionesEx = observacionesEx;
    }

    public String getElaboradoExt() {
        return elaboradoExt;
    }

    public void setElaboradoExt(String elaboradoExt) {
        this.elaboradoExt = elaboradoExt;
    }
    
    
    
    
}
