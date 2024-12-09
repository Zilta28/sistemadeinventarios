
package Modelo;

import java.util.Date;


public class incidentesTanTera {
    private int id;
    private Date fecha;
    private String personaResponsable;
    private String hora;
    private String tipoMateriaOrganica;
    private String bromaminas;
    private String tiempoCancelacion;
    private String quimicoAplicado;
    private String inicioActividades;
    private String equipoFiltracion;
    private String observacion;
    
    public incidentesTanTera(){
        
    }

    public incidentesTanTera(int id, String personaResponsable, Date fecha, String hora, String tipoMateriaOrganica, String bromaminas, String tiempoCancelacion, String quimicoAplicado, String inicioActividades, String equipoFiltracion, String observacion) {
        this.personaResponsable = personaResponsable;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoMateriaOrganica = tipoMateriaOrganica;
        this.bromaminas = bromaminas;
        this.tiempoCancelacion = tiempoCancelacion;
        this.quimicoAplicado = quimicoAplicado;
        this.inicioActividades = inicioActividades;
        this.equipoFiltracion = equipoFiltracion;
        this.observacion = observacion;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPersonaResponsable() {
        return personaResponsable;
    }

    public void setPersonaResponsable(String personaResponsable) {
        this.personaResponsable = personaResponsable;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTipoMateriaOrganica() {
        return tipoMateriaOrganica;
    }

    public void setTipoMateriaOrganica(String tipoMateriaOrganica) {
        this.tipoMateriaOrganica = tipoMateriaOrganica;
    }

    public String getBromaminas() {
        return bromaminas;
    }

    public void setBromaminas(String bromaminas) {
        this.bromaminas = bromaminas;
    }

    public String getTiempoCancelacion() {
        return tiempoCancelacion;
    }

    public void setTiempoCancelacion(String tiempoCancelacion) {
        this.tiempoCancelacion = tiempoCancelacion;
    }

    public String getQuimicoAplicado() {
        return quimicoAplicado;
    }

    public void setQuimicoAplicado(String quimicoAplicado) {
        this.quimicoAplicado = quimicoAplicado;
    }

    public String getInicioActividades() {
        return inicioActividades;
    }

    public void setInicioActividades(String inicioActividades) {
        this.inicioActividades = inicioActividades;
    }

    public String getEquipoFiltracion() {
        return equipoFiltracion;
    }

    public void setEquipoFiltracion(String equipoFiltracion) {
        this.equipoFiltracion = equipoFiltracion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
}
