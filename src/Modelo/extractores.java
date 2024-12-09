
package Modelo;

import java.util.Date;

/**
 *
 * @author Lizbeth
 */
public class extractores {
    public int id;
    private String materialEx;
    private Date fechaEx;
    private String marcaEx;
    private String modeloEx;
    private String noSerieEx;
    private String ampEx;
    private String voltajeEx;
    private String revisionRodaEx;
    private String revisionBandaEx;
    private String revisionElectricidadEx;
    private String revisionTableroEx;
    private String eliminacionEx;
    private String ajusteEx;
    private String limpiezaEx;
    private String observacionesEx;
    private String elaboradoEx;
    private String revisadoEx;
    private String aprobadoEx;

    public extractores() {
    }

    public extractores(String materialEx, Date fechaEx, String marcaEx, String modeloEx, String noSerieEx, String ampEx, String voltajeEx, String revisionRodaEx, String revisionBandaEx, String revisionElectricidadEx, String revisionTableroEx, String eliminacionEx, String ajusteEx, String limpiezaEx, String observacionesEx, String elaboradoEx, String revisadoEx, String aprobadoEx, int id) {
        this.materialEx = materialEx;
        this.fechaEx = fechaEx;
        this.marcaEx = marcaEx;
        this.modeloEx = modeloEx;
        this.noSerieEx = noSerieEx;
        this.ampEx = ampEx;
        this.voltajeEx = voltajeEx;
        this.revisionRodaEx = revisionRodaEx;
        this.revisionBandaEx = revisionBandaEx;
        this.revisionElectricidadEx = revisionElectricidadEx;
        this.revisionTableroEx = revisionTableroEx;
        this.eliminacionEx = eliminacionEx;
        this.ajusteEx = ajusteEx;
        this.limpiezaEx = limpiezaEx;
        this.observacionesEx = observacionesEx;
        this.elaboradoEx = elaboradoEx;
        this.revisadoEx = revisadoEx;
        this.aprobadoEx = aprobadoEx;
        this.id = id;
    }

    public int getId(){
      return id;
    }

    public void setId(int id){
      this.id = id;
    }

    public String getMaterialEx() {
        return materialEx;
    }

    public void setMaterialEx(String materialEx) {
        this.materialEx = materialEx;
    }

    public Date getFechaEx() {
        return fechaEx;
    }

    public void setFechaEx(Date fechaEx) {
        this.fechaEx = fechaEx;
    }

    public String getMarcaEx() {
        return marcaEx;
    }

    public void setMarcaEx(String marcaEx) {
        this.marcaEx = marcaEx;
    }

    public String getModeloEx() {
        return modeloEx;
    }

    public void setModeloEx(String modeloEx) {
        this.modeloEx = modeloEx;
    }

    public String getNoSerieEx() {
        return noSerieEx;
    }

    public void setNoSerieEx(String noSerieEx) {
        this.noSerieEx = noSerieEx;
    }

    public String getAmpEx() {
        return ampEx;
    }

    public void setAmpEx(String ampEx) {
        this.ampEx = ampEx;
    }

    public String getVoltajeEx() {
        return voltajeEx;
    }

    public void setVoltajeEx(String voltajeEx) {
        this.voltajeEx = voltajeEx;
    }

    public String getRevisionRodaEx() {
        return revisionRodaEx;
    }

    public void setRevisionRodaEx(String revisionRodaEx) {
        this.revisionRodaEx = revisionRodaEx;
    }

    public String getRevisionBandaEx() {
        return revisionBandaEx;
    }

    public void setRevisionBandaEx(String revisionBandaEx) {
        this.revisionBandaEx = revisionBandaEx;
    }

    public String getRevisionElectricidadEx() {
        return revisionElectricidadEx;
    }

    public void setRevisionElectricidadEx(String revisionElectricidadEx) {
        this.revisionElectricidadEx = revisionElectricidadEx;
    }

    public String getRevisionTableroEx() {
        return revisionTableroEx;
    }

    public void setRevisionTableroEx(String revisionTableroEx) {
        this.revisionTableroEx = revisionTableroEx;
    }

    public String getEliminacionEx() {
        return eliminacionEx;
    }

    public void setEliminacionEx(String eliminacionEx) {
        this.eliminacionEx = eliminacionEx;
    }

    public String getAjusteEx() {
        return ajusteEx;
    }

    public void setAjusteEx(String ajusteEx) {
        this.ajusteEx = ajusteEx;
    }

    public String getLimpiezaEx() {
        return limpiezaEx;
    }

    public void setLimpiezaEx(String limpiezaEx) {
        this.limpiezaEx = limpiezaEx;
    }

    public String getObservacionesEx() {
        return observacionesEx;
    }

    public void setObservacionesEx(String observacionesEx) {
        this.observacionesEx = observacionesEx;
    }

    public String getElaboradoEx() {
        return elaboradoEx;
    }

    public void setElaboradoEx(String elaboradoEx) {
        this.elaboradoEx = elaboradoEx;
    }

    public String getRevisadoEx() {
        return revisadoEx;
    }

    public void setRevisadoEx(String revisadoEx) {
        this.revisadoEx = revisadoEx;
    }

    public String getAprobadoEx() {
        return aprobadoEx;
    }

    public void setAprobadoEx(String aprobadoEx) {
        this.aprobadoEx = aprobadoEx;
    }


}
