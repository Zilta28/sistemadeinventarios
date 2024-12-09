
package Modelo;

import java.util.Date;

public class tanqueTerapeutico {
    private int id;
    private Date fecha;
    private String nombreLectura;
    private String diaSemana;
    private String hora;
    private String bromo;
    private String ph;
    private String alcalinidad;
    private String dureza;
    private String temperatura;
    private String cloroBromado;
    private String shockPreventivo;
    private String acido;
    private String clarificador;
    private String aspirado;
    private String cepillado;
    private String contornado;
    private String motobomba1; 
    private String motobomba2;
    private String filtro1; 
    private String presion1;
    private String retrolavado1;
    private String observacion;
    
   public tanqueTerapeutico(){
       
   }

    public tanqueTerapeutico(int id, Date fecha, String nombreLectura, String diaSemana, String hora, String bromo, String ph, String alcalinidad, String dureza, String temperatura, String cloroBromado, String shockPreventivo, String acido, String clarificador, String aspirado, String cepillado, String contornado, String motobomba1, String motobomba2, String filtro1, String presion1, String retrolavado1, String observacion) {
        this.id = id;
        this.fecha = fecha;
        this.nombreLectura = nombreLectura;
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.bromo = bromo;
        this.ph = ph;
        this.alcalinidad = alcalinidad;
        this.dureza = dureza;
        this.temperatura = temperatura;
        this.cloroBromado = cloroBromado;
        this.shockPreventivo = shockPreventivo;
        this.acido = acido;
        this.clarificador = clarificador;
        this.aspirado = aspirado;
        this.cepillado = cepillado;
        this.contornado = contornado;
        this.motobomba1 = motobomba1;
        this.motobomba2 = motobomba2;
        this.filtro1 = filtro1;
        this.presion1 = presion1;
        this.retrolavado1 = retrolavado1;
        this.observacion = observacion;
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

    public String getNombreLectura() {
        return nombreLectura;
    }

    public void setNombreLectura(String nombreLectura) {
        this.nombreLectura = nombreLectura;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getBromo() {
        return bromo;
    }

    public void setBromo(String bromo) {
        this.bromo = bromo;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getAlcalinidad() {
        return alcalinidad;
    }

    public void setAlcalinidad(String alcalinidad) {
        this.alcalinidad = alcalinidad;
    }

    public String getDureza() {
        return dureza;
    }

    public void setDureza(String dureza) {
        this.dureza = dureza;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getCloroBromado() {
        return cloroBromado;
    }

    public void setCloroBromado(String cloroBromado) {
        this.cloroBromado = cloroBromado;
    }

    public String getShockPreventivo() {
        return shockPreventivo;
    }

    public void setShockPreventivo(String shockPreventivo) {
        this.shockPreventivo = shockPreventivo;
    }

    public String getAcido() {
        return acido;
    }

    public void setAcido(String acido) {
        this.acido = acido;
    }

    public String getClarificador() {
        return clarificador;
    }

    public void setClarificador(String clarificador) {
        this.clarificador = clarificador;
    }

    public String getAspirado() {
        return aspirado;
    }

    public void setAspirado(String aspirado) {
        this.aspirado = aspirado;
    }

    public String getCepillado() {
        return cepillado;
    }

    public void setCepillado(String cepillado) {
        this.cepillado = cepillado;
    }

    public String getContornado() {
        return contornado;
    }

    public void setContornado(String contornado) {
        this.contornado = contornado;
    }

    public String getMotobomba1() {
        return motobomba1;
    }

    public void setMotobomba1(String motobomba1) {
        this.motobomba1 = motobomba1;
    }

    public String getMotobomba2() {
        return motobomba2;
    }

    public void setMotobomba2(String motobomba2) {
        this.motobomba2 = motobomba2;
    }

    public String getFiltro1() {
        return filtro1;
    }

    public void setFiltro1(String filtro1) {
        this.filtro1 = filtro1;
    }

    public String getPresion1() {
        return presion1;
    }

    public void setPresion1(String presion1) {
        this.presion1 = presion1;
    }

    public String getRetrolavado1() {
        return retrolavado1;
    }

    public void setRetrolavado1(String retrolavado1) {
        this.retrolavado1 = retrolavado1;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
   
}
