
package Modelo;

import java.util.Date;

/**
 *
 * @author lizbeth Ventura Talón
 * Licenciatura en Ciencias Computacionales
 */
public class electricidad {
    public int id;
    private String matElectricidad;
    private Date fechaElec;
    private String capacidadElec;
    private String unidadElec;
    private String marcaElec;
    private String noSerieElec;
    private String cambioAceiteElec;
    private String cambioRefrigeranteElec;
    private String cambioFiltroDElec;
    private String cambioFiltroAElec;
    private String cambioFiltroAceite;
    private String cambioFiltroRefri;
    private String limpiezaGElec;
    private String observacionesElec;
    private String elaboradoElec;
    private String revisadoElec;
    private String aprobadoElec;

    public electricidad() {
    }

    public electricidad(String matElectricidad, Date fechaElec, String capacidadElec, String unidadElec, String marcaElec, String noSerieElec, String cambioAceiteElec, String cambioRefrigeranteElec, String cambioFiltroDElec, String cambioFiltroAElec, String cambioFiltroAceite, String cambioFiltroRefri, String limpiezaGElec, String observacionesElec, String elaboradoElec, String revisadoElec, String aprobadoElec, int id) {
        this.matElectricidad = matElectricidad;
        this.fechaElec = fechaElec;
        this.capacidadElec = capacidadElec;
        this.unidadElec = unidadElec;
        this.marcaElec = marcaElec;
        this.noSerieElec = noSerieElec;
        this.cambioAceiteElec = cambioAceiteElec;
        this.cambioRefrigeranteElec = cambioRefrigeranteElec;
        this.cambioFiltroDElec = cambioFiltroDElec;
        this.cambioFiltroAElec = cambioFiltroAElec;
        this.cambioFiltroAceite = cambioFiltroAceite;
        this.cambioFiltroRefri = cambioFiltroRefri;
        this.limpiezaGElec = limpiezaGElec;
        this.observacionesElec = observacionesElec;
        this.elaboradoElec = elaboradoElec;
        this.revisadoElec = revisadoElec;
        this.aprobadoElec = aprobadoElec;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMatElectricidad() {
        return matElectricidad;
    }

    public void setMatElectricidad(String matElectricidad) {
        this.matElectricidad = matElectricidad;
    }

    public Date getFechaElec() {
        return fechaElec;
    }

    public void setFechaElec(Date fechaElec) {
        this.fechaElec = fechaElec;
    }

    public String getCapacidadElec() {
        return capacidadElec;
    }

    public void setCapacidadElec(String capacidadElec) {
        this.capacidadElec = capacidadElec;
    }

    public String getUnidadElec() {
        return unidadElec;
    }

    public void setUnidadElec(String unidadElec) {
        this.unidadElec = unidadElec;
    }

    public String getMarcaElec() {
        return marcaElec;
    }

    public void setMarcaElec(String marcaElec) {
        this.marcaElec = marcaElec;
    }

    public String getNoSerieElec() {
        return noSerieElec;
    }

    public void setNoSerieElec(String noSerieElec) {
        this.noSerieElec = noSerieElec;
    }

    public String getCambioAceiteElec() {
        return cambioAceiteElec;
    }

    public void setCambioAceiteElec(String cambioAceiteElec) {
        this.cambioAceiteElec = cambioAceiteElec;
    }

    public String getCambioRefrigeranteElec() {
        return cambioRefrigeranteElec;
    }

    public void setCambioRefrigeranteElec(String cambioRefrigeranteElec) {
        this.cambioRefrigeranteElec = cambioRefrigeranteElec;
    }

    public String getCambioFiltroDElec() {
        return cambioFiltroDElec;
    }

    public void setCambioFiltroDElec(String cambioFiltroDElec) {
        this.cambioFiltroDElec = cambioFiltroDElec;
    }

    public String getCambioFiltroAElec() {
        return cambioFiltroAElec;
    }

    public void setCambioFiltroAElec(String cambioFiltroAElec) {
        this.cambioFiltroAElec = cambioFiltroAElec;
    }

    public String getCambioFiltroAceite() {
        return cambioFiltroAceite;
    }

    public void setCambioFiltroAceite(String cambioFiltroAceite) {
        this.cambioFiltroAceite = cambioFiltroAceite;
    }

    public String getCambioFiltroRefri() {
        return cambioFiltroRefri;
    }

    public void setCambioFiltroRefri(String cambioFiltroRefri) {
        this.cambioFiltroRefri = cambioFiltroRefri;
    }

    public String getLimpiezaGElec() {
        return limpiezaGElec;
    }

    public void setLimpiezaGElec(String limpiezaGElec) {
        this.limpiezaGElec = limpiezaGElec;
    }

    public String getObservacionesElec() {
        return observacionesElec;
    }

    public void setObservacionesElec(String observacionesElec) {
        this.observacionesElec = observacionesElec;
    }

    public String getElaboradoElec() {
        return elaboradoElec;
    }

    public void setElaboradoElec(String elaboradoElec) {
        this.elaboradoElec = elaboradoElec;
    }

    public String getRevisadoElec() {
        return revisadoElec;
    }

    public void setRevisadoElec(String revisadoElec) {
        this.revisadoElec = revisadoElec;
    }

    public String getAprobadoElec() {
        return aprobadoElec;
    }

    public void setAprobadoElec(String aprobadoElec) {
        this.aprobadoElec = aprobadoElec;
    }
}
