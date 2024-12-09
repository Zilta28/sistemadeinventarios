
package Modelo;

import java.util.Date;

public class caldera {
    private int id;
    private int noCaldera;
    private String dia;
    private Date fecha;
    private String horaEncendido;
    private String horaApagado; 
    private String nombrePrende;
    private String nombreApaga;
    private String calderaTrabajando;
    private String porcentajeCa;
    private String observacionesCa;
    
    public caldera(){
        
    }

    public caldera(int noCaldera, String dia, Date fecha, String horaEncendido, String horaApagado, String nombrePrende, String nombreApaga, String calderaTrabajando, String porcentajeCa, String observacionesCa, int id) {
        this.noCaldera = noCaldera;
        this.dia = dia;
        this.fecha = fecha;
        this.horaEncendido = horaEncendido;
        this.horaApagado = horaApagado;
        this.nombrePrende = nombrePrende;
        this.nombreApaga = nombreApaga;
        this.calderaTrabajando = calderaTrabajando;
        this.porcentajeCa = porcentajeCa;
        this.observacionesCa = observacionesCa;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNoCaldera() {
        return noCaldera;
    }

    public void setNoCaldera(int noCaldera) {
        this.noCaldera = noCaldera;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraEncendido() {
        return horaEncendido;
    }

    public void setHoraEncendido(String horaEncendido) {
        this.horaEncendido = horaEncendido;
    }

    public String getHoraApagado() {
        return horaApagado;
    }

    public void setHoraApagado(String horaApagado) {
        this.horaApagado = horaApagado;
    }

    public String getNombrePrende() {
        return nombrePrende;
    }

    public void setNombrePrende(String nombrePrende) {
        this.nombrePrende = nombrePrende;
    }

    public String getNombreApaga() {
        return nombreApaga;
    }

    public void setNombreApaga(String nombreApaga) {
        this.nombreApaga = nombreApaga;
    }

    public String getCalderaTrabajando() {
        return calderaTrabajando;
    }

    public void setCalderaTrabajando(String calderaTrabajando) {
        this.calderaTrabajando = calderaTrabajando;
    }

    public String getPorcentajeCa() {
        return porcentajeCa;
    }

    public void setPorcentajeCa(String porcentajeCa) {
        this.porcentajeCa = porcentajeCa;
    }

    public String getObservacionesCa() {
        return observacionesCa;
    }

    public void setObservacionesCa(String observacionesCa) {
        this.observacionesCa = observacionesCa;
    }
    
    
}
