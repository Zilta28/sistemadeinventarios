/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Historial;
import Modelo.HistorialDAO;
import Modelo.aireAcondicionado;
import Modelo.aireAcondicionadoDAO;
import Modelo.bombaCalor;
import Modelo.bombaCalorDAO;
import Modelo.bombas;
import Modelo.bombasDAO;
import Modelo.calderaElectro;
import Modelo.calderaElectroDAO;
import Modelo.cems;
import Modelo.cemsDAO;
import Modelo.compresionElectro;
import Modelo.compresionElectroDAO;
import Modelo.conexionBD;
import Modelo.dosificador;
import Modelo.dosificadorDAO;
import Modelo.electricidad;
import Modelo.electricidadDAO;
import Modelo.enfermeria;
import Modelo.enfermeriaDAO;
import Modelo.extractores;
import Modelo.extractoresDAO;
import Modelo.mecanoterapia;
import Modelo.mecanoterapiaDAO;
import Modelo.medico;
import Modelo.medicoDAO;
import Modelo.refrigeradores;
import Modelo.refrigeradoresDAO;
import Modelo.odontopediatria;
import Modelo.odontopediatriaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lizbe
 */
public class Sistema extends javax.swing.JFrame {

    private String id;
    HistorialDAO historialdao = new HistorialDAO();

    mecanoterapia meca = new mecanoterapia();
    mecanoterapiaDAO mecanoterapiadao = new mecanoterapiaDAO();

    electricidad electri = new electricidad();
    electricidadDAO electricidaddao = new electricidadDAO();

    calderaElectro calderaelectro = new calderaElectro();
    calderaElectroDAO calderaelectrodao = new calderaElectroDAO();

    bombaCalor bombcalor = new bombaCalor();
    bombaCalorDAO bombcalordao = new bombaCalorDAO();

    compresionElectro compresion = new compresionElectro();
    compresionElectroDAO compresiondao = new compresionElectroDAO();

    aireAcondicionado aireacondicionado = new aireAcondicionado();
    aireAcondicionadoDAO aireacondicionadodao = new aireAcondicionadoDAO();

    refrigeradores refri = new refrigeradores();
    refrigeradoresDAO refrigeradoresdao = new refrigeradoresDAO();

    dosificador dosificado = new dosificador();
    dosificadorDAO dosificadordao = new dosificadorDAO();

    bombas bomb = new bombas();
    bombasDAO bombdao = new bombasDAO();

    extractores extra = new extractores();
    extractoresDAO extractoresdao = new extractoresDAO();

    medico medic = new medico();
    medicoDAO medicodao = new medicoDAO();

    enfermeria enferm = new enfermeria();
    enfermeriaDAO enfermeriadao = new enfermeriaDAO();

    odontopediatria odontopediatria = new odontopediatria();
    odontopediatriaDAO odontopediatriadao = new odontopediatriaDAO();

    cems c = new cems();
    cemsDAO ce = new cemsDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    Modelo.conexionBD con = new conexionBD();
    Connection cn = con.getConnection();

    /**
     * Creates new form Sistema
     */
    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(15);
        ListarElectricidad();
    }

    public String getId(){
      return id;
    }

    public void setId(String id){
      this.id = id;
    }

    public void ListarCems() {
        List<cems> ListaC = ce.ListarCems();
        modelo = (DefaultTableModel) tablaCems.getModel();
        Object[] ob = new Object[8];
        /*
            *   Aqui habia un problema y eso hacia que el for nunca entrara en
            *   la condicion:
            *   Se encontraba de esta forma
            *       for(int i = 0; i>ListaC.size(); i++)
            *   Por lo cual jamas hiba a entar ya que siempre seria mayor que i
         */
        for (int i = 0; i < ListaC.size(); i++) {
            ob[0] = ListaC.get(i).getMaterialC();
            ob[1] = ListaC.get(i).getFechaC();
            ob[2] = ListaC.get(i).getBuenEstadoC();
            ob[3] = ListaC.get(i).getObservacionesC();
            ob[4] = ListaC.get(i).getElaboradoC();
            ob[5] = ListaC.get(i).getRevisadoC();
            ob[6] = ListaC.get(i).getAprobadoC();
            ob[7] = ListaC.get(i).getId();
            modelo.addRow(ob);
        }
        tablaCems.setModel(modelo);
    }

    public void ListarElectricidad() {
        List<electricidad> ListaElectricidad = electricidaddao.ListarElectricidad();
        modelo = (DefaultTableModel) tableElect.getModel();
        Object[] ob = new Object[18];
        for (int i = 0; i < ListaElectricidad.size(); i++) {
            ob[0] = ListaElectricidad.get(i).getMatElectricidad();//2
            ob[1] = ListaElectricidad.get(i).getFechaElec();//3
            ob[2] = ListaElectricidad.get(i).getCapacidadElec();//4
            ob[3] = ListaElectricidad.get(i).getUnidadElec();//5
            ob[4] = ListaElectricidad.get(i).getMarcaElec();//6
            ob[5] = ListaElectricidad.get(i).getNoSerieElec();//7
            ob[6] = ListaElectricidad.get(i).getCambioAceiteElec();//8
            ob[7] = ListaElectricidad.get(i).getCambioRefrigeranteElec();//9
            ob[8] = ListaElectricidad.get(i).getCambioFiltroAElec();//10
            ob[9] = ListaElectricidad.get(i).getCambioFiltroDElec();//11
            ob[10] = ListaElectricidad.get(i).getCambioFiltroAceite();//12
            ob[11] = ListaElectricidad.get(i).getCambioFiltroRefri();//13
            ob[12] = ListaElectricidad.get(i).getLimpiezaGElec();//14
            ob[13] = ListaElectricidad.get(i).getObservacionesElec();//15
            ob[14] = ListaElectricidad.get(i).getElaboradoElec();//16
            ob[15] = ListaElectricidad.get(i).getRevisadoElec();//17
            ob[16] = ListaElectricidad.get(i).getAprobadoElec();//18
            ob[17] = ListaElectricidad.get(i).getId();//18
            modelo.addRow(ob);
        }
        tableElect.setModel(modelo);
    }

    public void ListarcalderaElectro() {
        List<calderaElectro> ListacalderaElectro = calderaelectrodao.ListarCalderaE();
        modelo = (DefaultTableModel) tablaCaldera.getModel();
        Object[] ob = new Object[21];
        for (int i = 0; i < ListacalderaElectro.size(); i++) {
            ob[0] = ListacalderaElectro.get(i).getMaterialC();//2
            ob[1] = ListacalderaElectro.get(i).getFechaC();//3
            ob[2] = ListacalderaElectro.get(i).getCapacidadC();//4
            ob[3] = ListacalderaElectro.get(i).getUnidadC();//5
            ob[4] = ListacalderaElectro.get(i).getMarcaC();//6
            ob[5] = ListacalderaElectro.get(i).getModeloC();//7
            ob[6] = ListacalderaElectro.get(i).getNoSerieC();//8
            ob[7] = ListacalderaElectro.get(i).getLimpiezaChimeneaC();//9
            ob[8] = ListacalderaElectro.get(i).getLimpiezaCeniceroC();//10
            ob[9] = ListacalderaElectro.get(i).getLimpiezaQuemadorC();//11
            ob[10] = ListacalderaElectro.get(i).getRevisionFlamaC();//12
            ob[11] = ListacalderaElectro.get(i).getLimpiezaPilotoC();//13
            ob[12] = ListacalderaElectro.get(i).getRevisionManometroC();//14
            ob[13] = ListacalderaElectro.get(i).getRevisionValvulasC();//15
            ob[14] = ListacalderaElectro.get(i).getRevisionSistemaC();//16
            ob[15] = ListacalderaElectro.get(i).getMedicionAmpC();//17
            ob[16] = ListacalderaElectro.get(i).getObservacionesC();//18
            ob[17] = ListacalderaElectro.get(i).getElaboradoC();//19
            ob[18] = ListacalderaElectro.get(i).getRevisadoC();//20
            ob[19] = ListacalderaElectro.get(i).getAprobadoC();//21
            ob[20] = ListacalderaElectro.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaCaldera.setModel(modelo);
    }

    public void ListarBombasDeCalor() {
        List<bombaCalor> Listabombcalor = bombcalordao.ListarBombaCalor();
        modelo = (DefaultTableModel) tablaBombaCalor.getModel();
        System.out.println("ListarBombasDeCalor");
        Object[] ob = new Object[24];
        for (int i = 0; i < Listabombcalor.size(); i++) {
            ob[0] = Listabombcalor.get(i).getMaterialBC();//2
            ob[1] = Listabombcalor.get(i).getFechaBC();//3
            ob[2] = Listabombcalor.get(i).getCapacidadBC();//4
            ob[3] = Listabombcalor.get(i).getUnidadBC();//5
            ob[4] = Listabombcalor.get(i).getMarcaBC();//6
            ob[5] = Listabombcalor.get(i).getModeloBC();//7
            ob[6] = Listabombcalor.get(i).getNoSerieBC();//8
            ob[7] = Listabombcalor.get(i).getLavadoPresionBC();//9
            ob[8] = Listabombcalor.get(i).getLavadoCondensadorBC();//10
            ob[9] = Listabombcalor.get(i).getRevisionMotorBC();//11
            ob[10] = Listabombcalor.get(i).getRevisionCompresorBC();//12
            ob[11] = Listabombcalor.get(i).getMedicionAmpBC();//13
            ob[12] = Listabombcalor.get(i).getCambioTerminalesBC();//14
            ob[13] = Listabombcalor.get(i).getPinturaBC();//15
            ob[14] = Listabombcalor.get(i).getRevisionValvulas();//16
            ob[15] = Listabombcalor.get(i).getRevisionFugas();//17
            ob[16] = Listabombcalor.get(i).getRevisionRefrigeranteBC();//18
            ob[17] = Listabombcalor.get(i).getMedicionPresionBC();//19
            ob[18] = Listabombcalor.get(i).getRevisionControlBC();//20
            ob[19] = Listabombcalor.get(i).getObservacionesBC();//21
            ob[20] = Listabombcalor.get(i).getElaboradoBC();//22
            ob[21] = Listabombcalor.get(i).getRevisadoBC();//23
            ob[22] = Listabombcalor.get(i).getAprobadoBC();//24
            ob[23] = Listabombcalor.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaBombaCalor.setModel(modelo);
    }

    public void ListarCompresion() {
        List<compresionElectro> Listacompresion = compresiondao.ListarCompresion();
        modelo = (DefaultTableModel) tablaCompresion.getModel();
        Object[] ob = new Object[20];
        for (int i = 0; i < Listacompresion.size(); i++) {
            ob[0] = Listacompresion.get(i).getMaterialCom();//2
            ob[1] = Listacompresion.get(i).getFechaCom();//3
            ob[2] = Listacompresion.get(i).getCapacidadCom();//4
            ob[3] = Listacompresion.get(i).getUnidadCom();//5
            ob[4] = Listacompresion.get(i).getMarcaCom();//6
            ob[5] = Listacompresion.get(i).getModeloCom();//7
            ob[6] = Listacompresion.get(i).getNoSerieCom();//8
            ob[7] = Listacompresion.get(i).getMedicionAmpCom();//9
            ob[8] = Listacompresion.get(i).getMedicionPresionCom();//10
            ob[9] = Listacompresion.get(i).getMedicionSistemaCom();//11
            ob[10] = Listacompresion.get(i).getLimpiezaGralCom();//12
            ob[11] = Listacompresion.get(i).getRevisionAceiteCom();//13
            ob[12] = Listacompresion.get(i).getPinturaCom();//14
            ob[13] = Listacompresion.get(i).getRevisionPurgadoCom();//15
            ob[14] = Listacompresion.get(i).getRevisionTerminalCom();//16
            ob[15] = Listacompresion.get(i).getObservacionesCom();//17
            ob[16] = Listacompresion.get(i).getElaboradoCom();//18
            ob[17] = Listacompresion.get(i).getRevisadoCom();//19
            ob[18] = Listacompresion.get(i).getAprobadoCom();//20
            ob[19] = Listacompresion.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaCompresion.setModel(modelo);
    }

    public void ListarAireAcondicionado() {
        List<aireAcondicionado> ListaaireAcondicionado = aireacondicionadodao.ListarAireAcondicionado();
        modelo = (DefaultTableModel) tabaAA.getModel();
        Object[] ob = new Object[19];
        for (int i = 0; i < ListaaireAcondicionado.size(); i++) {
            ob[0] = ListaaireAcondicionado.get(i).getMaterialAire();//2
            ob[1] = ListaaireAcondicionado.get(i).getFechaAire();//3
            ob[2] = ListaaireAcondicionado.get(i).getLimpiezaSerAire();//4
            ob[3] = ListaaireAcondicionado.get(i).getLimpiezaFiltroAire();//5
            ob[4] = ListaaireAcondicionado.get(i).getRevisionFugaAire();//6
            ob[5] = ListaaireAcondicionado.get(i).getMedicionPresionAire();//7
            ob[6] = ListaaireAcondicionado.get(i).getMedicionAmpAire();//8
            ob[7] = ListaaireAcondicionado.get(i).getTornilleriaAire();//9
            ob[8] = ListaaireAcondicionado.get(i).getPinturaAire();//10
            ob[9] = ListaaireAcondicionado.get(i).getLubricacionAire();//11
            ob[10] = ListaaireAcondicionado.get(i).getLimpiezaPanelControl();//11
            ob[11] = ListaaireAcondicionado.get(i).getVerificarAire();//12
            ob[12] = ListaaireAcondicionado.get(i).getDestaparDrenesAire();//13
            ob[13] = ListaaireAcondicionado.get(i).getLimpiezaSerAire();//14
            ob[14] = ListaaireAcondicionado.get(i).getObservacionesAire();//15
            ob[15] = ListaaireAcondicionado.get(i).getElaboradoAire();//16
            ob[16] = ListaaireAcondicionado.get(i).getRevisadoAire();//17
            ob[17] = ListaaireAcondicionado.get(i).getAprobadoAire();//18
            ob[18] = ListaaireAcondicionado.get(i).getId();//19
            modelo.addRow(ob);
        }
        tabaAA.setModel(modelo);
    }

    public void ListarRefrigeradores() {
        List<refrigeradores> Listaairerefrigeradores = refrigeradoresdao.ListarRefri();
        modelo = (DefaultTableModel) tablaRefrigerador.getModel();
        Object[] ob = new Object[14];
        for (int i = 0; i < Listaairerefrigeradores.size(); i++) {
            ob[0] = Listaairerefrigeradores.get(i).getMaterialRefri();//2
            ob[1] = Listaairerefrigeradores.get(i).getFechaRefri();//3
            ob[2] = Listaairerefrigeradores.get(i).getSelladoRefri();//4
            ob[3] = Listaairerefrigeradores.get(i).getFugasRefri();//5
            ob[4] = Listaairerefrigeradores.get(i).getCableadoRefri();//6
            ob[5] = Listaairerefrigeradores.get(i).getLimpiezaExtRefri();//7
            ob[6] = Listaairerefrigeradores.get(i).getLimpiezaIntRefri();//8
            ob[7] = Listaairerefrigeradores.get(i).getLimpiezaEvaRefri();//9
            ob[8] = Listaairerefrigeradores.get(i).getMedicionAmpRefri();//10
            ob[9] = Listaairerefrigeradores.get(i).getObservacionesRefri();//11
            ob[10] = Listaairerefrigeradores.get(i).getElaboradoRefri();//12
            ob[11] = Listaairerefrigeradores.get(i).getRevisadoRefri();//13
            ob[12] = Listaairerefrigeradores.get(i).getAprobadoRefri();//14
            ob[13] = Listaairerefrigeradores.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaRefrigerador.setModel(modelo);
    }

    public void ListarDosificadores() {
        List<dosificador> Listadosificador = dosificadordao.ListarDosif();
        modelo = (DefaultTableModel) tablaDosificadores.getModel();
        Object[] ob = new Object[14];
        for (int i = 0; i < Listadosificador.size(); i++) {
            ob[0] = Listadosificador.get(i).getMaterialDosi();//2
            ob[1] = Listadosificador.get(i).getFechaDosi();//3
            ob[2] = Listadosificador.get(i).getSelladoDosi();//4
            ob[3] = Listadosificador.get(i).getFugasDosi();//5
            ob[4] = Listadosificador.get(i).getCableadoDosi();//6
            ob[5] = Listadosificador.get(i).getLimpiezaExtDosi();//7
            ob[6] = Listadosificador.get(i).getLimpiezaIntDosi();//8
            ob[7] = Listadosificador.get(i).getLimpiezaEvaDosi();//9
            ob[8] = Listadosificador.get(i).getMedicionAmpDosi();//10
            ob[9] = Listadosificador.get(i).getObservacionesDosi();//11
            ob[10] = Listadosificador.get(i).getElaboradoDosi();//12
            ob[11] = Listadosificador.get(i).getRevisadoDosi();//13
            ob[12] = Listadosificador.get(i).getAprobadoDosi();//14
            ob[13] = Listadosificador.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaDosificadores.setModel(modelo);
    }

    public void ListarBombas() {
        List<bombas> Listabombas = bombdao.ListarBom();
        modelo = (DefaultTableModel) tableBombas.getModel();
        Object[] ob = new Object[15];
        for (int i = 0; i < Listabombas.size(); i++) {
            ob[0] = Listabombas.get(i).getMaterialBom();//2
            ob[1] = Listabombas.get(i).getFechaBom();//3
            ob[2] = Listabombas.get(i).getRodamientoBom();//4
            ob[3] = Listabombas.get(i).getSelloBom();//5
            ob[4] = Listabombas.get(i).getAmpBom();//6
            ob[5] = Listabombas.get(i).getTempBom();//7
            ob[6] = Listabombas.get(i).getTerminalesBom();//8
            ob[7] = Listabombas.get(i).getAccionamientoBom();//9
            ob[8] = Listabombas.get(i).getPinturaBom();//10
            ob[9] = Listabombas.get(i).getManometroBom();//11
            ob[10] = Listabombas.get(i).getObservacionesBom();//12
            ob[11] = Listabombas.get(i).getElaboradoBom();//13
            ob[12] = Listabombas.get(i).getRevisadoBom();//14
            ob[13] = Listabombas.get(i).getAprobadoBom();//15
            ob[14] = Listabombas.get(i).getId();//18
            modelo.addRow(ob);
        }
        tableBombas.setModel(modelo);
    }

    public void ListaExtratorDeAire() {
        List<extractores> Listaextractores = extractoresdao.ListarExtrac();
        modelo = (DefaultTableModel) tablaExtractorAire.getModel();
        Object[] ob = new Object[19];
        for (int i = 0; i < Listaextractores.size(); i++) {
            ob[0] = Listaextractores.get(i).getMaterialEx();//2
            ob[1] = Listaextractores.get(i).getFechaEx();//3
            ob[2] = Listaextractores.get(i).getMarcaEx();//4
            ob[3] = Listaextractores.get(i).getModeloEx();//5
            ob[4] = Listaextractores.get(i).getNoSerieEx();//6
            ob[5] = Listaextractores.get(i).getAmpEx();//7
            ob[6] = Listaextractores.get(i).getVoltajeEx();//8
            ob[7] = Listaextractores.get(i).getRevisionRodaEx();//9
            ob[8] = Listaextractores.get(i).getRevisionBandaEx();//10
            ob[9] = Listaextractores.get(i).getRevisionElectricidadEx();//11
            ob[10] = Listaextractores.get(i).getRevisionTableroEx();//12
            ob[11] = Listaextractores.get(i).getEliminacionEx();//13
            ob[12] = Listaextractores.get(i).getAjusteEx();//14
            ob[13] = Listaextractores.get(i).getLimpiezaEx();//15
            ob[14] = Listaextractores.get(i).getObservacionesEx();//16
            ob[15] = Listaextractores.get(i).getElaboradoEx();//17
            ob[16] = Listaextractores.get(i).getRevisadoEx();//18
            ob[17] = Listaextractores.get(i).getAprobadoEx();//19
            ob[18] = Listaextractores.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaExtractorAire.setModel(modelo);
    }

    public void ListaEquipoMedico() {
        List<medico> Listamedico = medicodao.ListarMed();
        modelo = (DefaultTableModel) tablaMedico.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < Listamedico.size(); i++) {
            ob[0] = Listamedico.get(i).getMaterialMed();//2
            ob[1] = Listamedico.get(i).getFechaMed();//3
            ob[2] = Listamedico.get(i).getBuenEstadoMed();//4
            ob[3] = Listamedico.get(i).getObservacionesMed();//5
            ob[4] = Listamedico.get(i).getElaboradoMed();//6
            ob[5] = Listamedico.get(i).getRevisadoMed();//7
            ob[6] = Listamedico.get(i).getAprobadoMed();//8
            ob[7] = Listamedico.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaMedico.setModel(modelo);
    }

    public void ListaEnfermeria() {
        List<enfermeria> Listaenfermeria = enfermeriadao.ListarEnf();
        modelo = (DefaultTableModel) tablaEnfermeria.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < Listaenfermeria.size(); i++) {
            ob[0] = Listaenfermeria.get(i).getMaterialEnf();//2
            ob[1] = Listaenfermeria.get(i).getFechaEnf();//3
            ob[2] = Listaenfermeria.get(i).getBuenEstadoEnf();//4
            ob[3] = Listaenfermeria.get(i).getObservacionesEnf();//5
            ob[4] = Listaenfermeria.get(i).getElaboradoEnf();//6
            ob[5] = Listaenfermeria.get(i).getRevisadoEnf();//7
            ob[6] = Listaenfermeria.get(i).getAprobadoEnf();//8
            ob[7] = Listaenfermeria.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaEnfermeria.setModel(modelo);
    }

    public void ListaOrtopedia() {
        List<odontopediatria> Listaodontopediatria = odontopediatriadao.ListarOdo();
        modelo = (DefaultTableModel) tablaOrto.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < Listaodontopediatria.size(); i++) {
            ob[0] = Listaodontopediatria.get(i).getMaterialOdo();//2
            ob[1] = Listaodontopediatria.get(i).getFechaOdo();//3
            ob[2] = Listaodontopediatria.get(i).getBuenEstadoOdo();//4
            ob[3] = Listaodontopediatria.get(i).getObservacionesOdo();//5
            ob[4] = Listaodontopediatria.get(i).getElaboradoOdo();//6
            ob[5] = Listaodontopediatria.get(i).getRevisadoOdo();//7
            ob[6] = Listaodontopediatria.get(i).getAprobadoOdo();//8
            ob[7] = Listaodontopediatria.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaOrto.setModel(modelo);
    }

    public void Listamecanotera() {
        List<mecanoterapia> Listamecanoterapia = mecanoterapiadao.ListarMeca();
        modelo = (DefaultTableModel) tablaMeca.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < Listamecanoterapia.size(); i++) {
            ob[0] = Listamecanoterapia.get(i).getMaterialMeca();//2
            ob[1] = Listamecanoterapia.get(i).getFechaMeca();//3
            ob[2] = Listamecanoterapia.get(i).getBuenEstadoMeca();//4
            ob[3] = Listamecanoterapia.get(i).getObservacionesMeca();//5
            ob[4] = Listamecanoterapia.get(i).getElaboradoMeca();//6
            ob[5] = Listamecanoterapia.get(i).getRevisadoMeca();//7
            ob[6] = Listamecanoterapia.get(i).getAprobadoMeca();//8
            ob[7] = Listamecanoterapia.get(i).getId();//18
            modelo.addRow(ob);
        }
        tablaMeca.setModel(modelo);
    }

    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnElectricidad = new javax.swing.JButton();
        btnBombaCalor = new javax.swing.JButton();
        btnCaldera = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btnAireAcond = new javax.swing.JButton();
        btnRefrigeradores = new javax.swing.JButton();
        btnDeso = new javax.swing.JButton();
        btnBombas = new javax.swing.JButton();
        btnExtractor = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnMedico = new javax.swing.JButton();
        btnEnfermeria = new javax.swing.JButton();
        btnOdon = new javax.swing.JButton();
        btnMeca = new javax.swing.JButton();
        btnCems = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        cmbMarcaElect = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cmbSerieElect = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableElect = new javax.swing.JTable();
        jLabel61 = new javax.swing.JLabel();
        cbxMatElect = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        fechaElect = new com.toedter.calendar.JDateChooser();
        jLabel63 = new javax.swing.JLabel();
        cmbCapElect = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        cmbUnidadElec = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtElaboradoElect = new javax.swing.JTextField();
        txtRevisadoElect = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        txtAprobadoElect = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtObsElect = new javax.swing.JTextField();
        cmbAceiteElect = new javax.swing.JComboBox<>();
        cmbRefrigeranteElect = new javax.swing.JComboBox<>();
        cmbFiltroAireElect = new javax.swing.JComboBox<>();
        cmbFiltroDieselElect = new javax.swing.JComboBox<>();
        cmbFiltroAceiteElect = new javax.swing.JComboBox<>();
        cmbLimpiezaElect = new javax.swing.JComboBox<>();
        btnGuardarElectricidad = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel191 = new javax.swing.JLabel();
        cmbFiltroRefri = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBombaCalor = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        cmbMatBombaCalor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fechabC = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        cmbCapBC = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cmbUnidadBC = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        cmbMarcaBC = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        cmbModeloBC = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cmbSerieBC = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        txtObBC = new javax.swing.JTextField();
        cmbRevisionCBC = new javax.swing.JComboBox<>();
        cmbMedicionAmpBC = new javax.swing.JComboBox<>();
        cmbCambioBC = new javax.swing.JComboBox<>();
        cmbPinturaBC = new javax.swing.JComboBox<>();
        cmbRevisionVBC = new javax.swing.JComboBox<>();
        cmbRevisionRBC = new javax.swing.JComboBox<>();
        cmbMedicionBC = new javax.swing.JComboBox<>();
        cmbLavadoPBC = new javax.swing.JComboBox<>();
        cmbLavadoCBC = new javax.swing.JComboBox<>();
        cmbControlB = new javax.swing.JComboBox<>();
        cmbRevisionMBC = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        txtElaboradoBC = new javax.swing.JTextField();
        txtRevisadoBC = new javax.swing.JTextField();
        txtAprobadoBC = new javax.swing.JTextField();
        btnGuardarBC = new javax.swing.JButton();
        btnActualizarBC = new javax.swing.JButton();
        btnEliminarBC = new javax.swing.JButton();
        jLabel192 = new javax.swing.JLabel();
        cmbRevisionFu = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCaldera = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbMatCaldera = new javax.swing.JComboBox<>();
        fechaCaldera = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        cmbCapC = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbUnidadC = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbMarcaC = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cmbModeloC = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cmbSerieC = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cmbLChimeneaC = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cmbLCeniceroC = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cmbRLQC = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cmbLPilotoC = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cmbFlamaC = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        cmbManoC = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        cmbValvulaC = new javax.swing.JComboBox<>();
        jLabel88 = new javax.swing.JLabel();
        cmbSistemaC = new javax.swing.JComboBox<>();
        jLabel89 = new javax.swing.JLabel();
        txtAmpC = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        txtElaboroC = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        txtRevisadoC = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        txtAprobadoC = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        txtObC = new javax.swing.JTextField();
        btnGuardarC = new javax.swing.JButton();
        btnActualizarC = new javax.swing.JButton();
        btnEliminarC = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaCompresion = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        cmbMatC = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        fechaC = new com.toedter.calendar.JDateChooser();
        jLabel30 = new javax.swing.JLabel();
        cmbCapaC = new javax.swing.JComboBox<>();
        jLabel94 = new javax.swing.JLabel();
        cmbUnidadCom = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        cmbMarcaCom = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        cmbModeloCom = new javax.swing.JComboBox<>();
        jLabel97 = new javax.swing.JLabel();
        cmbSerieCom = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        txtAmpCom = new javax.swing.JTextField();
        txtMedPreC = new javax.swing.JTextField();
        cmbMedicionCom = new javax.swing.JComboBox<>();
        cmbLimpiezaCom = new javax.swing.JComboBox<>();
        cmbRevisionAceiteCom = new javax.swing.JComboBox<>();
        cmbPinturaCom = new javax.swing.JComboBox<>();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        cmbSisPCom = new javax.swing.JComboBox<>();
        cmbTCCOM = new javax.swing.JComboBox<>();
        jLabel106 = new javax.swing.JLabel();
        txtElaboradoCom = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        txtRevisadoCom = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        txtAprobadoCom = new javax.swing.JTextField();
        jLabel109 = new javax.swing.JLabel();
        txtObCom = new javax.swing.JTextField();
        btnGuardarCom = new javax.swing.JButton();
        btnActualizarCom = new javax.swing.JButton();
        btnEliminarCom = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabaAA = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        txtObA = new javax.swing.JTextField();
        cmbMatA = new javax.swing.JComboBox<>();
        fechaA = new com.toedter.calendar.JDateChooser();
        cmbLimpiezaSA = new javax.swing.JComboBox<>();
        cmbFiltroA = new javax.swing.JComboBox<>();
        cmbRevisionFA = new javax.swing.JComboBox<>();
        cmbRefrigeracionA = new javax.swing.JComboBox<>();
        txtAmpA = new javax.swing.JTextField();
        cmPinturaA = new javax.swing.JComboBox<>();
        cmbLubA = new javax.swing.JComboBox<>();
        cmbVentiA = new javax.swing.JComboBox<>();
        cmbDrenesA = new javax.swing.JComboBox<>();
        cmbLimpiezaECA = new javax.swing.JComboBox<>();
        txtElaboradoA = new javax.swing.JTextField();
        txtRevisadoA = new javax.swing.JTextField();
        txtAprobadoA = new javax.swing.JTextField();
        btnGuardarA = new javax.swing.JButton();
        btnActualizarA = new javax.swing.JButton();
        btnEliminarA = new javax.swing.JButton();
        cmbTorA = new javax.swing.JComboBox<>();
        jLabel193 = new javax.swing.JLabel();
        cmbLimpiezaPC = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaRefrigerador = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        cmbMatR = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        fechaR = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cmbSelladoR = new javax.swing.JComboBox<>();
        cmbFugasR = new javax.swing.JComboBox<>();
        cmbCableadoR = new javax.swing.JComboBox<>();
        cmbLExteriorR = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cmbLInteriorR = new javax.swing.JComboBox<>();
        cmbLEvaporadorR = new javax.swing.JComboBox<>();
        cmbAmpR = new javax.swing.JComboBox<>();
        txtElaboradoR = new javax.swing.JTextField();
        txtRevisadoR = new javax.swing.JTextField();
        txtAprobadoR = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtObR = new javax.swing.JTextField();
        btnGuardarR = new javax.swing.JButton();
        btnActualizarR = new javax.swing.JButton();
        btnEliminarR = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaDosificadores = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        cmbMatD = new javax.swing.JComboBox<>();
        fechaD = new com.toedter.calendar.JDateChooser();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        cmbSelladoD = new javax.swing.JComboBox<>();
        cmbFugasD = new javax.swing.JComboBox<>();
        cmbCableadoD = new javax.swing.JComboBox<>();
        cmbLED = new javax.swing.JComboBox<>();
        cmbLID = new javax.swing.JComboBox<>();
        cmbLEvaporadorD = new javax.swing.JComboBox<>();
        cmbAmpD = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        txtElaboradoD = new javax.swing.JTextField();
        txtRevisadoD = new javax.swing.JTextField();
        txtAprobadoD = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        txtObD = new javax.swing.JTextField();
        btnGuardarD = new javax.swing.JButton();
        btnActualizarD = new javax.swing.JButton();
        btnEliminarD = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        cmbMatB = new javax.swing.JComboBox<>();
        fechaB = new com.toedter.calendar.JDateChooser();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        cmbRodaB = new javax.swing.JComboBox<>();
        cmbSelloB = new javax.swing.JComboBox<>();
        txtAmpB = new javax.swing.JTextField();
        txtTemB = new javax.swing.JTextField();
        cmbAprieteB = new javax.swing.JComboBox<>();
        cmbPinturaB = new javax.swing.JComboBox<>();
        cmbRevisionB = new javax.swing.JComboBox<>();
        txtElaboradoB = new javax.swing.JTextField();
        txtRevisadoB = new javax.swing.JTextField();
        txtAprobadoB = new javax.swing.JTextField();
        txtObB = new javax.swing.JTextField();
        txtValvulaB = new javax.swing.JTextField();
        btnGuardarB = new javax.swing.JButton();
        btnActualizarB = new javax.swing.JButton();
        btnEliminarB = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableBombas = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        cmbMatE = new javax.swing.JComboBox<>();
        jLabel139 = new javax.swing.JLabel();
        fechaE = new com.toedter.calendar.JDateChooser();
        jLabel140 = new javax.swing.JLabel();
        cmbMarcaE = new javax.swing.JComboBox<>();
        jLabel141 = new javax.swing.JLabel();
        cmbModeloE = new javax.swing.JComboBox<>();
        jLabel142 = new javax.swing.JLabel();
        cmbSerieE = new javax.swing.JComboBox<>();
        jLabel143 = new javax.swing.JLabel();
        txtAmpE = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaExtractorAire = new javax.swing.JTable();
        txtVoltajeE = new javax.swing.JTextField();
        jLabel145 = new javax.swing.JLabel();
        cmbRodaE = new javax.swing.JComboBox<>();
        jLabel146 = new javax.swing.JLabel();
        cmbBandaE = new javax.swing.JComboBox<>();
        jLabel147 = new javax.swing.JLabel();
        cmbConexE = new javax.swing.JComboBox<>();
        jLabel148 = new javax.swing.JLabel();
        cmbIinterruptorE = new javax.swing.JComboBox<>();
        jLabel149 = new javax.swing.JLabel();
        cmbVibE = new javax.swing.JComboBox<>();
        jLabel150 = new javax.swing.JLabel();
        cmbTorE = new javax.swing.JComboBox<>();
        jLabel151 = new javax.swing.JLabel();
        cmbLimpiezaE = new javax.swing.JComboBox<>();
        jLabel152 = new javax.swing.JLabel();
        txtObE = new javax.swing.JTextField();
        txtElaboradoE = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        txtRevisadoE = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        txtAprobadoE = new javax.swing.JTextField();
        btnGuardarE = new javax.swing.JButton();
        btnActualizarE = new javax.swing.JButton();
        btnEliminarE = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        cmbMateM = new javax.swing.JComboBox<>();
        jLabel157 = new javax.swing.JLabel();
        fechaM = new com.toedter.calendar.JDateChooser();
        jLabel158 = new javax.swing.JLabel();
        cmbEstadoM = new javax.swing.JComboBox<>();
        jLabel159 = new javax.swing.JLabel();
        txtObM = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        txtElaboradoM = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        txtRevisadoM = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        txtAprobadoM = new javax.swing.JTextField();
        btnGuardarM = new javax.swing.JButton();
        btnActualizarM = new javax.swing.JButton();
        btnEliminarM = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaMedico = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        cmbMatEnf = new javax.swing.JComboBox<>();
        jLabel164 = new javax.swing.JLabel();
        fechaEnfermeria = new com.toedter.calendar.JDateChooser();
        jLabel165 = new javax.swing.JLabel();
        cmbEstadoEnf = new javax.swing.JComboBox<>();
        jLabel166 = new javax.swing.JLabel();
        txtElaboradoEnf = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        txtRevisadoEnf = new javax.swing.JTextField();
        jLabel168 = new javax.swing.JLabel();
        txtAprobadoEnf = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaEnfermeria = new javax.swing.JTable();
        jLabel169 = new javax.swing.JLabel();
        txtObEnf = new javax.swing.JTextField();
        btnGuardarEnf = new javax.swing.JButton();
        btnActualizarEnf = new javax.swing.JButton();
        btnEliminarEnf = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        cmbMatOd = new javax.swing.JComboBox<>();
        fechaOdon = new com.toedter.calendar.JDateChooser();
        jLabel172 = new javax.swing.JLabel();
        cmbEstadoO = new javax.swing.JComboBox<>();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        txtElaboradoOdo = new javax.swing.JTextField();
        txtRevisadoOdo = new javax.swing.JTextField();
        txtAprobadoOdo = new javax.swing.JTextField();
        jLabel176 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tablaOrto = new javax.swing.JTable();
        txtObO = new javax.swing.JTextField();
        btnGuardarO = new javax.swing.JButton();
        btnActualizarO = new javax.swing.JButton();
        btnEliminarO = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        cmbMatMe = new javax.swing.JComboBox<>();
        fechaMecano = new com.toedter.calendar.JDateChooser();
        jLabel179 = new javax.swing.JLabel();
        cmbEstadoMeca = new javax.swing.JComboBox<>();
        jLabel180 = new javax.swing.JLabel();
        txtObMeca = new javax.swing.JTextField();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablaMeca = new javax.swing.JTable();
        btnGuardarMeca = new javax.swing.JButton();
        btnActualizarMeca = new javax.swing.JButton();
        btnEliminarMeca = new javax.swing.JButton();
        txtElaboradoMeca = new javax.swing.JTextField();
        txtRevisadoMeca = new javax.swing.JTextField();
        txtAprobadoMeca = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        cmbMatCe = new javax.swing.JComboBox<>();
        jLabel185 = new javax.swing.JLabel();
        fechaCe = new com.toedter.calendar.JDateChooser();
        jLabel186 = new javax.swing.JLabel();
        cmbEstadoCe = new javax.swing.JComboBox<>();
        jLabel187 = new javax.swing.JLabel();
        txtObCe = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        txtElaboradoCe = new javax.swing.JTextField();
        txtRevisadoCe = new javax.swing.JTextField();
        txtAprobadoCe = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tablaCems = new javax.swing.JTable();
        btnGuardarCe = new javax.swing.JButton();
        btnActualizarCe = new javax.swing.JButton();
        btnEliminarCe = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/png-transparent-universidad-teleton-2016-chilean-telethon-foundation-cancun-purple-text-hand-removebg-preview (1).png"))); // NOI18N

        btnElectricidad.setBackground(new java.awt.Color(255, 255, 255));
        btnElectricidad.setText("Electricidad");
        btnElectricidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElectricidadActionPerformed(evt);
            }
        });

        btnBombaCalor.setBackground(new java.awt.Color(255, 255, 255));
        btnBombaCalor.setText("Bombas de calor");
        btnBombaCalor.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                btnBombaCalorHierarchyChanged(evt);
            }
        });
        btnBombaCalor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBombaCalorActionPerformed(evt);
            }
        });

        btnCaldera.setBackground(new java.awt.Color(255, 255, 255));
        btnCaldera.setText("Calderas");
        btnCaldera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalderaActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Compresión");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        btnAireAcond.setBackground(new java.awt.Color(255, 255, 255));
        btnAireAcond.setText("Aire acondicionado");
        btnAireAcond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAireAcondActionPerformed(evt);
            }
        });

        btnRefrigeradores.setBackground(new java.awt.Color(255, 255, 255));
        btnRefrigeradores.setText("Refrigeradores");
        btnRefrigeradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefrigeradoresActionPerformed(evt);
            }
        });

        btnDeso.setBackground(new java.awt.Color(255, 255, 255));
        btnDeso.setText("Dosificadores de agua");
        btnDeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesoActionPerformed(evt);
            }
        });

        btnBombas.setBackground(new java.awt.Color(255, 255, 255));
        btnBombas.setText("Bombas");
        btnBombas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBombasActionPerformed(evt);
            }
        });

        btnExtractor.setBackground(new java.awt.Color(255, 255, 255));
        btnExtractor.setText("Extractores de aire");
        btnExtractor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtractorActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar-sesion.png"))); // NOI18N
        btnCerrar.setText("Cerrar sesión");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMedico.setBackground(new java.awt.Color(255, 255, 255));
        btnMedico.setText("Equipo médico");
        btnMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicoActionPerformed(evt);
            }
        });

        btnEnfermeria.setBackground(new java.awt.Color(255, 255, 255));
        btnEnfermeria.setText("Enfermería");
        btnEnfermeria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnfermeriaActionPerformed(evt);
            }
        });

        btnOdon.setBackground(new java.awt.Color(255, 255, 255));
        btnOdon.setText("Odontopediatría ");
        btnOdon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdonActionPerformed(evt);
            }
        });

        btnMeca.setBackground(new java.awt.Color(255, 255, 255));
        btnMeca.setText("Mecanoterapia");
        btnMeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMecaActionPerformed(evt);
            }
        });

        btnCems.setBackground(new java.awt.Color(255, 255, 255));
        btnCems.setText("CEMS");
        btnCems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnElectricidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBombaCalor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCaldera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAireAcond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRefrigeradores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBombas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExtractor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEnfermeria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOdon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElectricidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBombaCalor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCaldera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAireAcond)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefrigeradores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBombas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExtractor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnfermeria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOdon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMeca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 680));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Imagen2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 540, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/purple-yellow-wave-vector-background-260nw-2011354676.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 430, 80));

        cmbMarcaElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "9A0314B08" }));

        jLabel14.setText("No. serie:");

        cmbSerieElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S/N" }));

        tableElect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "material", "fecha", "capacidadEl", "unidadEl", "marcaEl", "noSerieEl", "cambioAceite", "cambioRefrigerante", "cambioFiltroAire", "cambioFiltroDiesel", "cambioFiltroAceite", "cambioFiltroRefrigerante", "limpiezaGral", "observaciones", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tableElect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableElectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableElect);

        jLabel61.setText("Material y ubicación:");

        cbxMatElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Planta de emergencia - Subestación de distribución" }));

        jLabel62.setText("Fecha:");

        jLabel63.setText("Capacidad:");

        cmbCapElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "314" }));

        jLabel64.setText("Unidad:");

        cmbUnidadElec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KW" }));

        jLabel65.setText("Marca:");

        jLabel12.setText("Elaborado por: ");

        jLabel13.setText("Revisado por:");

        jLabel60.setText("Aprobado por:");

        txtAprobadoElect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAprobadoElectActionPerformed(evt);
            }
        });

        jLabel66.setText("Cambio de aceite:");

        jLabel69.setText("Cambio de refrigerante:");

        jLabel70.setText("Cambio de filtro de aire:");

        jLabel71.setText("Cambio de filtro de diesel:");

        jLabel72.setText("Cambio de filtro de aceite:");

        jLabel73.setText("Limpieza general:");

        jLabel74.setText("Observaciones generales:");

        cmbAceiteElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbRefrigeranteElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbFiltroAireElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbFiltroDieselElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbFiltroAceiteElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbLimpiezaElect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        btnGuardarElectricidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarElectricidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarElectricidadActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel191.setText("Cambio de filtro de refrigerante:");

        cmbFiltroRefri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI ", "NO ", "Ningún cambio" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel61)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxMatElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fechaElect, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel66)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbAceiteElect, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel73)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbLimpiezaElect, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel191)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbFiltroRefri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnGuardarElectricidad)
                                                .addComponent(jLabel60)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtRevisadoElect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                                    .addComponent(txtElaboradoElect)
                                                    .addComponent(txtAprobadoElect)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(jButton2)
                                                .addGap(56, 56, 56)
                                                .addComponent(jButton3))))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel74)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtObsElect, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel63)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCapElect, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel64)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbUnidadElec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel65)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMarcaElect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSerieElect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel71)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbFiltroDieselElect, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbFiltroAireElect, 0, 1, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbRefrigeranteElect, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel72)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbFiltroAceiteElect, 0, 1, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel61)
                                .addComponent(cbxMatElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel191)
                                .addComponent(cmbFiltroRefri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(cmbAceiteElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fechaElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel73)
                                .addComponent(cmbLimpiezaElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(cmbCapElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel69)
                            .addComponent(cmbRefrigeranteElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel74)
                            .addComponent(txtObsElect))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(cmbUnidadElec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70)
                            .addComponent(cmbFiltroAireElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtElaboradoElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbMarcaElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel71)
                                .addComponent(cmbFiltroDieselElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRevisadoElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbSerieElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72)
                                    .addComponent(cmbFiltroAceiteElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAprobadoElect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3)
                        .addComponent(btnGuardarElectricidad, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );

        jTabbedPane1.addTab("Electricidad", jPanel2);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaBombaCalor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialb", "fecha", "capacidad", "unidad", "marca", "modelo", "serie", "lavadoAguaPresion", "lavadoCondensador	", "revisionMotor", "revisionCompresor", "medicionAmp", "cambioTerminales", "pintura", "revisionValvulasAgua", "revisionFugas	", "revisionSisRefrigerante", "medicionPresion", "revisionControl", "observaciones", "elaborado", "revisado	", "aprobado", "id"
            }
        ));
        tablaBombaCalor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBombaCalorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBombaCalor);
        if (tablaBombaCalor.getColumnModel().getColumnCount() > 0) {
            tablaBombaCalor.getColumnModel().getColumn(23).setResizable(false);
        }

        jLabel15.setText("Material y ubicación:");

        cmbMatBombaCalor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bomba de calor 1 - Hidroterapia", "Bomba de calor 2 - Hidroteratia" }));

        jLabel3.setText("Fecha:");

        jLabel5.setText("Capacidad:");

        cmbCapBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "236/340", "150/300" }));

        jLabel6.setText("Unidad:");

        cmbUnidadBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PSI" }));

        jLabel16.setText("Marca:");

        cmbMarcaBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HAYWARD" }));

        jLabel17.setText("Modelo:");

        cmbModeloBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HP21404T", "HP6003T" }));

        jLabel18.setText("No. serie:");

        cmbSerieBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "21131908104261000", "2112081100376000" }));

        jLabel19.setText("Lavado con agua a presión y desincrustante ");

        jLabel67.setText("Lavado del condensador con agua a presión");

        jLabel68.setText("Revisión de motor y ventilador (vibración y ruidos)");

        jLabel75.setText("Revisión de compresor (ruidos, vibración y calentamiento)");

        jLabel76.setText("Medición de amperaje a plena carga");

        jLabel77.setText("Cambio de terminales y conexiones");

        jLabel78.setText("Pintura");

        jLabel79.setText("Revisión y accionamiento de válvulas de agua (entrada y salida)");

        jLabel80.setText("Revisión del sistema de refrigerante");

        jLabel81.setText("Medición de alta y baja presión ");

        jLabel82.setText("Revisión del control y la instrumentación ");

        jLabel83.setText("Observaciones generales:");

        cmbRevisionCBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbMedicionAmpBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbCambioBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbPinturaBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbRevisionVBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbRevisionRBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbMedicionBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbLavadoPBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbLavadoCBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbControlB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbRevisionMBC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel84.setText("Elaborado por:");

        jLabel85.setText("Revisado por:");

        jLabel86.setText("Aprobado por:");

        btnGuardarBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarBCActionPerformed(evt);
            }
        });

        btnActualizarBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarBCActionPerformed(evt);
            }
        });

        btnEliminarBC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarBC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBCActionPerformed(evt);
            }
        });

        jLabel192.setText("Revisión de fugas y reparación:");

        cmbRevisionFu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbMatBombaCalor, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechabC, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbUnidadBC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbModeloBC, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel18))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbCapBC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel16)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbSerieBC, 0, 0, Short.MAX_VALUE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(cmbMarcaBC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLavadoPBC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel67)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbLavadoCBC, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel85)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRevisadoBC, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRevisionMBC, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel84)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtElaboradoBC, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel192)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRevisionFu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel83))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel82)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbControlB, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel86)
                                .addGap(18, 18, 18)
                                .addComponent(txtAprobadoBC))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel81)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMedicionBC, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel80)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbRevisionRBC, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtObBC))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel78)
                                                .addGap(5, 5, 5)
                                                .addComponent(cmbPinturaBC, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel79))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbRevisionVBC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel77)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbCambioBC, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel76)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cmbMedicionAmpBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel75))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbRevisionCBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarBC)
                                    .addComponent(btnActualizarBC)
                                    .addComponent(btnEliminarBC)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardarBC)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarBC))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cmbMatBombaCalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRevisionCBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel75))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cmbUnidadBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbMarcaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSerieBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(fechabC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(cmbCapBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cmbModeloBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel18)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(cmbLavadoPBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel67)
                                    .addComponent(cmbLavadoCBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel68)
                                    .addComponent(cmbRevisionMBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel84)
                                    .addComponent(txtElaboradoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(btnEliminarBC))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel76)
                                            .addComponent(cmbMedicionAmpBC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel77)
                                            .addComponent(cmbCambioBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel78)
                                            .addComponent(cmbPinturaBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel79)
                                            .addComponent(cmbRevisionVBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel192)
                                            .addComponent(cmbRevisionFu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel83)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel80)
                                            .addComponent(cmbRevisionRBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel81)
                                            .addComponent(cmbMedicionBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtObBC, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel82)
                                    .addComponent(cmbControlB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel86)
                                    .addComponent(txtAprobadoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel85)
                                    .addComponent(txtRevisadoBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bombas de calor", jPanel3);

        tablaCaldera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialc", "fecha", "capacidad", "unidad", "marca", "modelo", "serie", "limpiezaChimenea", "limpiezaCenicero", "revisionQuemador", "revisionFlama", "limpiezaPiloto", "revisionManometro", "revisionValvulas", "revisionSistema", "medicionAmp", "observaciones", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaCaldera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCalderaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCaldera);

        jLabel7.setText("Material y ubicación:");

        jLabel8.setText("Fecha:");

        cmbMatCaldera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caldera 1 - Azotea de Cisternas", "Caldera 2 - Azotea de Cisternas", "Caldera 3 - Azotea de Hidroterapia" }));

        jLabel9.setText("Capacidad:");

        cmbCapC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 /12" }));

        jLabel10.setText("Unidad:");

        cmbUnidadC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "HP" }));

        jLabel11.setText("Marca:");

        cmbMarcaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ARMSTRONG" }));

        jLabel20.setText("Modelo:");

        cmbModeloC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S-25 BF" }));

        jLabel21.setText("No. Serie:");

        cmbSerieC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "718", "318", "S/N" }));

        jLabel22.setText("Limpieza de chimenea ");

        cmbLChimeneaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel23.setText("Limpieza de cenicero ");

        cmbLCeniceroC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel24.setText("Revisión y limpieza de quemador ");

        cmbRLQC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No ", "Ningún cambio" }));

        jLabel25.setText("Limpieza de piloto ");

        cmbLPilotoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel26.setText("Revisión de flama ");

        cmbFlamaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel27.setText("Revisión de manómetro ");

        cmbManoC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No ", "Ningún cambio" }));

        jLabel87.setText("Revisión y accionamiento de válvulas de entrada y salida de agua ");

        cmbValvulaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel88.setText("Revisión del sistema de control ");

        cmbSistemaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel89.setText("Medición de amperaje ");

        jLabel90.setText("Elaborado por:");

        jLabel91.setText("Revisado por:");

        jLabel92.setText("Aprobado por:");

        jLabel93.setText("Observaciones generales:");

        btnGuardarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCActionPerformed(evt);
            }
        });

        btnActualizarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCActionPerformed(evt);
            }
        });

        btnEliminarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(fechaCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMatCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbUnidadC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCapC, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSerieC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbModeloC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMarcaC, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel22)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbLChimeneaC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbRLQC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmbLCeniceroC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbLPilotoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel26)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbFlamaC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cmbManoC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(50, 50, 50)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtObC, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel90)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtElaboroC))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel91)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtRevisadoC))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel92)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtAprobadoC))
                                        .addComponent(jLabel93)))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel87)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbValvulaC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel89)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAmpC))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel88)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSistemaC, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addComponent(btnGuardarC)
                                .addGap(37, 37, 37)
                                .addComponent(btnActualizarC)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarC))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbMatCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(cmbLChimeneaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(cmbLCeniceroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtObC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(cmbRLQC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25)
                                    .addComponent(cmbLPilotoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(cmbFlamaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel27)
                                    .addComponent(cmbManoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel90)
                                    .addComponent(txtElaboroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel91)
                                    .addComponent(txtRevisadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel92)
                                    .addComponent(txtAprobadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(cmbValvulaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel88)
                                        .addComponent(cmbSistemaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel89)
                                        .addComponent(txtAmpC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(btnGuardarC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnActualizarC, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarC, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(fechaCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbCapC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(cmbUnidadC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbMarcaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cmbModeloC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cmbSerieC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Calderas", jPanel4);

        tablaCompresion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialcom", "fecha", "capacidad", "unidad", "marca", "modelo", "serie", "medicionAmp", "medicionPresion", "medicionSistema", "limpiezaGral", "revisionAceite", "pintura", "revisionPurgado", "revisionTerminales", "observaciones", "elaborado", "revisado	", "aprobado	", "id"
            }
        ));
        tablaCompresion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCompresionMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaCompresion);

        jLabel28.setText("Material y ubicación:");

        cmbMatC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Compresor 1 - Parte alta de Tarja de Valoración ", "Compresor 2 - Parte alta de Tarja de Valoración ", "Compresor 3 - Puerto de Sillas", "Compresor 4 - Taller de Mantenimiento" }));

        jLabel29.setText("Fecha: ");

        jLabel30.setText("Capacidad:");

        cmbCapaC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "27", "10", "Desconocido" }));

        jLabel94.setText("Unidad: ");

        cmbUnidadCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Galones", "Litros", "Desconocido" }));

        jLabel95.setText("Marca: ");

        cmbMarcaCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "POWERMATE", "TRUPER", "Desconocido" }));

        jLabel96.setText("Modelo:");

        cmbModeloCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CL0601712", "COMP-10L", "CL0602712", "Desconocido" }));

        jLabel97.setText("No. Serie: ");

        cmbSerieCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D21813462", "C34410135", "Desconocido" }));

        jLabel98.setText("Medición de amperaje ");

        jLabel99.setText("Medición de presión de operación ");

        jLabel100.setText("Medición del sistema de control y ajuste ");

        jLabel101.setText("Limpieza general ");

        jLabel102.setText("Revisión de aceite");

        jLabel103.setText("Pintura");

        cmbMedicionCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbLimpiezaCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbRevisionAceiteCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbPinturaCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel104.setText("Revisión del sistema de purgado de condensados ");

        jLabel105.setText("Revisión de terminales y conexiones ");

        cmbSisPCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbTCCOM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel106.setText("Elaborado por:");

        jLabel107.setText("Revisado por:");

        jLabel108.setText("Aprobado por:");

        jLabel109.setText("Observaciones generales:");

        btnGuardarCom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComActionPerformed(evt);
            }
        });

        btnActualizarCom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarComActionPerformed(evt);
            }
        });

        btnEliminarCom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarComActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMatC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSisPCom, 0, 261, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechaC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel94)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbUnidadCom, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel30)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbCapaC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel95)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbMarcaCom, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel97)
                                        .addComponent(jLabel96))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbModeloCom, 0, 109, Short.MAX_VALUE)
                                        .addComponent(cmbSerieCom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel99)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMedPreC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAmpCom))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMedicionCom, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel102)
                                    .addComponent(jLabel101))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbLimpiezaCom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRevisionAceiteCom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel103)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPinturaCom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel105)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTCCOM, 0, 182, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel106)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtElaboradoCom))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel107)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRevisadoCom))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAprobadoCom))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel109)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtObCom)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(btnGuardarCom, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnActualizarCom, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnEliminarCom, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(cmbMatC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(cmbSisPCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(txtAmpCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel105)
                            .addComponent(cmbTCCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(cmbCapaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMedPreC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel99)
                        .addComponent(jLabel106)
                        .addComponent(txtElaboradoCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(cmbUnidadCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel100)
                    .addComponent(cmbMedicionCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107)
                    .addComponent(txtRevisadoCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(cmbMarcaCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101)
                    .addComponent(cmbLimpiezaCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108)
                    .addComponent(txtAprobadoCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbModeloCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96)
                    .addComponent(jLabel102)
                    .addComponent(cmbRevisionAceiteCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel97)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSerieCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel103)
                        .addComponent(cmbPinturaCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtObCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardarCom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarCom, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Compresión", jPanel6);

        tabaAA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materiala", "fecha", "limpiezaSerpetines", "limpiezaFiltroAire", "revisionFugas", "medicionPresion", "medicionAmp", "aprieteTornilleria", "pintura", "limpiezaPanelControl", "lubricacion	", "verificarVentilador", "destaparDrenes	", "limpiezaEvaporador", "observaciones", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tabaAA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabaAAMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabaAA);

        jLabel31.setText("Material:");

        jLabel32.setText("Limpieza de serpentines: ");

        jLabel33.setText("Limpieza de filtros de aire: ");

        jLabel34.setText("Revisión de posibles fugas y eliminar en caso de que existan:");

        jLabel35.setText("Medición de presión de baja y alta en líneas de refrigeración: ");

        jLabel110.setText("Medición de amperaje: ");

        jLabel111.setText("Apriete de tornillería y terminales: ");

        jLabel112.setText("Pintura de ser necesario");

        jLabel113.setText("Fecha:");

        jLabel114.setText("Lubricación de rodamientos ");

        jLabel115.setText("Verificar que gire libremente el ventilador ");

        jLabel116.setText("Destapar drenes de condensador ");

        jLabel117.setText("Limpieza de evaporador y condensador ");

        jLabel118.setText("Elaborado por:");

        jLabel119.setText("Revisado por:");

        jLabel120.setText("Aprobado por:");

        jLabel121.setText("Observaciones generales:");

        cmbMatA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aire acondicionado 1", "Aire acondicionado 2", "Aire acondicionado 3", "Aire acondicionado 4", "Aire acondicionado 5", "Aire acondicionado 6", "Aire acondicionado 7", "Aire acondicionado 8", "Aire acondicionado 9", "Aire acondicionado 10", "Aire acondicionado 11", "Aire acondicionado 12", "Aire acondicionado 13", "Aire acondicionado 14" }));

        cmbLimpiezaSA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbFiltroA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbRevisionFA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbRefrigeracionA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmPinturaA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbLubA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbVentiA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbDrenesA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbLimpiezaECA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        btnGuardarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAActionPerformed(evt);
            }
        });

        btnActualizarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAActionPerformed(evt);
            }
        });

        btnEliminarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAActionPerformed(evt);
            }
        });

        cmbTorA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel193.setText("Limpieza de panel de control:");

        cmbLimpiezaPC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbMatA, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel113)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaA, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbLimpiezaSA, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbFiltroA, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel34)
                                .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmbRevisionFA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbRefrigeracionA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel110)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAmpA, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTorA, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel193)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLimpiezaPC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel114)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLubA, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmPinturaA, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel117)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLimpiezaECA, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel118)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtElaboradoA, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbVentiA, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDrenesA, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel119)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRevisadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAprobadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObA, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarA, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(cmbMatA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel113)
                            .addComponent(fechaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(cmbLimpiezaSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(cmbFiltroA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRevisionFA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRefrigeracionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel112)
                                    .addComponent(cmPinturaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel114)
                                    .addComponent(cmbLubA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel115)
                                    .addComponent(cmbVentiA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel116)
                                    .addComponent(cmbDrenesA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel117)
                                    .addComponent(cmbLimpiezaECA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel118)
                                    .addComponent(txtElaboradoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel119)
                                    .addComponent(txtRevisadoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnGuardarA, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizarA, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarA, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel110)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel120)
                                .addComponent(txtAprobadoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtAmpA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel121)
                                .addComponent(txtObA, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel111)
                                    .addComponent(cmbTorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbLimpiezaPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel193))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aire acondicionado", jPanel7);

        tablaRefrigerador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materiales", "fecha", "chequeoSellado", "chequeoFuga", "chequeoCableado", "limpiezaExterior", "limpiezaInterior", "limpiezaEvaporador", "medicionAmp", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaRefrigerador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRefrigeradorMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablaRefrigerador);

        jLabel36.setText("Material y ubicación:");

        cmbMatR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Refrigerador 1 - Botica", "Refrigerador 2 - Enfermería ", "Refrigerador 3 - Bazar", "Refrigerador 4 - Cocina gobierno" }));

        jLabel37.setText("Fecha:");

        fechaR.setBackground(new java.awt.Color(255, 255, 255));
        fechaR.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel38.setText("Checar sellado hermético de puerta");

        jLabel39.setText("Checar fugas y eliminar si es que existieran");

        jLabel40.setText("Checar cableado y conexiones");

        jLabel41.setText("Limpieza exterior");

        cmbSelladoR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbFugasR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbCableadoR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbLExteriorR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel42.setText("Limpieza interior");

        jLabel43.setText("Limpieza de evaporador y condensador");

        jLabel52.setText("Medicion de amperaje");

        jLabel53.setText("Elaborado por:");

        jLabel54.setText("Revisado por:");

        jLabel55.setText("Aprobado por: ");

        cmbLInteriorR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbLEvaporadorR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbAmpR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        txtRevisadoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRevisadoRActionPerformed(evt);
            }
        });

        jLabel56.setText("Observaciones generales:");

        btnGuardarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRActionPerformed(evt);
            }
        });

        btnActualizarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRActionPerformed(evt);
            }
        });

        btnEliminarR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObR))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(18, 18, 18)
                                .addComponent(cmbLExteriorR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCableadoR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFugasR, 0, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSelladoR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMatR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbLEvaporadorR, 0, 133, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(cmbLInteriorR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbAmpR, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtElaboradoR))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel55))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAprobadoR)
                                    .addComponent(txtRevisadoR))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarR, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarR, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(cmbMatR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(cmbLInteriorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(fechaR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(cmbLEvaporadorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(cmbSelladoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52)
                        .addComponent(cmbAmpR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizarR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(cmbFugasR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel53)
                        .addComponent(txtElaboradoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminarR, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(cmbCableadoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(txtRevisadoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(cmbLExteriorR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55)
                    .addComponent(txtAprobadoR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtObR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Refrigeradores", jPanel9);

        tablaDosificadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materiald", "fecha", "chequeoSellado", "chequeoFuga", "chequeoCableado", "limpiezaExterior", "limpiezaInterior", "limpiezaEvaporador", "medicionAmp", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaDosificadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDosificadoresMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablaDosificadores);

        jLabel44.setText("Material y ubicación:");

        jLabel45.setText("Fecha:");

        jLabel46.setText("Checar sellado hermético de puerta");

        cmbMatD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dosificador 1 - Recepción Tren", "Dosificador 2 - Exterior de Bazar", "Dosificador 3 - Cocina de Gobierno", "Dosificador 4 - Recepción de Música", "Dosificador 5 - Área de descanso de terapias ", "Dosificador 6 - Cafetería" }));

        jLabel47.setText("Checar fugas y eliminar si es que existieran");

        jLabel48.setText("Checar cableado y conexiones ");

        jLabel49.setText("Limpieza exterior ");

        jLabel50.setText("Limpieza interior ");

        jLabel51.setText("Limpieza de evaporador y condensador ");

        jLabel57.setText("Medición de amperaje ");

        cmbSelladoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbFugasD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbCableadoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbLED.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbLID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbLEvaporadorD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        cmbAmpD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO", "Ningún cambio" }));

        jLabel58.setText("Elaborado por:");

        jLabel59.setText("Revisado por:");

        jLabel122.setText("Aprobado por:");

        jLabel123.setText("Observaciones generales:");

        btnGuardarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDActionPerformed(evt);
            }
        });

        btnActualizarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDActionPerformed(evt);
            }
        });

        btnEliminarD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel123)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObD))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel49)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbLED, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbCableadoD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbFugasD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel46)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSelladoD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechaD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbMatD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel57)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbAmpD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel51)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbLEvaporadorD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbLID, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtElaboradoD))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel122)
                                            .addComponent(jLabel59))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRevisadoD)
                                            .addComponent(txtAprobadoD))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnGuardarD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizarD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(cmbMatD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(cmbSelladoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel47)
                                    .addComponent(cmbFugasD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48)
                                    .addComponent(cmbCableadoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnEliminarD)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(cmbLED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel122)
                            .addComponent(txtAprobadoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(cmbLID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(cmbLEvaporadorD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(cmbAmpD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(txtElaboradoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(txtRevisadoD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel123)
                    .addComponent(txtObD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dosificadores", jPanel8);

        jLabel124.setText("Material y ubicación:");

        jLabel125.setText("Fecha");

        cmbMatB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bomba de agua potable 1 - Cuarto de bombas (Cisternas)", "Bomba de agua potable 2 - Cuarto de bombas (Cisternas)", "Bomba de agua filtrada 1 - Cuarto de bombas (Cisternas)", "Bomba de agua filtrada 2 - Cuarto de bombas (Cisternas)", "Bombas recirculación 1 - Cuarto de bombas (Hidroterapia)", "Bomba recirculación 2 - Cuarto de bombas (Hidroterapia)", "Bomba contraincendio - Cuarto de bombas (Cisternas)" }));

        jLabel126.setText("Chequeo de rodamientos (Vibración, ruido excesivo):");

        jLabel127.setText("Sello mecánico:");

        jLabel128.setText("Amperaje: ");

        jLabel129.setText("Temperatura:");

        jLabel130.setText("Apriete de Terminales y Conexiones:");

        jLabel131.setText("Accionamiento de Válvulas de Succión y Descarga (De 0  a 100 %)");

        jLabel132.setText("Pintura de bomba y tubería:");

        jLabel133.setText("Revisión de Manómetros:");

        jLabel134.setText("Elaborado por:");

        jLabel135.setText("Revisado por:");

        jLabel136.setText("Aprobado por:");

        jLabel137.setText("Observaciones generales:");

        cmbRodaB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbSelloB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbAprieteB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbPinturaB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbRevisionB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        btnGuardarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarBActionPerformed(evt);
            }
        });

        btnActualizarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarBActionPerformed(evt);
            }
        });

        btnEliminarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarBActionPerformed(evt);
            }
        });

        tableBombas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "material", "fecha", "chequeoRondamiento", "selloMecanico", "amp", "temperatura", "aprieteTC", "accionamiento", "pintura	", "revisionManometro", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tableBombas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBombasMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tableBombas);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel125)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fechaB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel124)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMatB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel127)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbSelloB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(150, 150, 150))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel130)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbAprieteB, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel129)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTemB))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel128)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAmpB, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel131)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtValvulaB, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel134)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtElaboradoB))
                                    .addComponent(jLabel137)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel136)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAprobadoB))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel135)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtRevisadoB))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel133)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbRevisionB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel132)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPinturaB, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtObB, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel126)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRodaB, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 46, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124)
                            .addComponent(cmbMatB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel125)
                            .addComponent(fechaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(cmbRodaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel127)
                            .addComponent(cmbSelloB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel128)
                            .addComponent(txtAmpB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel129)
                            .addComponent(txtTemB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(cmbAprieteB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(txtValvulaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel132)
                                    .addComponent(cmbPinturaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel133)
                                    .addComponent(cmbRevisionB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel134)
                                    .addComponent(txtElaboradoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel135)
                                    .addComponent(txtRevisadoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnGuardarB, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizarB, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarB, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel136)
                            .addComponent(txtAprobadoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel137)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bombas", jPanel11);

        jLabel138.setText("Material y ubicación:");

        cmbMatE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Extractor 1 - Baños de gobierno (mujeres y hombres)", "Extractor 2 - Baños de hombres valoración", "Extractor 3 - Baños de mujeres valoración", "Extractor 4 - Baños de música (mujeres y hombres)", "Extractor 5 - Extractor de cocina", "Extractor 6 - Baños neutros", "Extractor 7 - General de Hidroterapia", "Extractor 8 - Cuarto de bombas Hidroterapia", "Extractor 9 - Baño de casita" }));
        cmbMatE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMatEActionPerformed(evt);
            }
        });

        jLabel139.setText("Fecha:");

        jLabel140.setText("Marca:");

        cmbMarcaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SOLERPALAU" }));

        jLabel141.setText("Modelo:");

        cmbModeloE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CRHT-10", "CRHT-12", "CRHT-20", "No visible" }));

        jLabel142.setText("No. Serie:");

        cmbSerieE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50103001", "50101000", "50623000", "50623000", "No visible" }));

        jLabel143.setText("Medición de amperaje: ");

        jLabel144.setText("Voltaje:");

        tablaExtractorAire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialex", "fecha", "marca", "modelo", "serie", "medicionAmp", "voltaje", "revisionRondamiento", "revisionBanda", "revisionConexion", "revisionTablero", "eliminacionRuido", "ajusteTornilleria", "limpiezaGral", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaExtractorAire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaExtractorAireMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablaExtractorAire);

        jLabel145.setText("Revisión de rodamientos, engrasar o cambiar de ser necesario");

        cmbRodaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel146.setText("Revisión de banda (ajustar o cambiar de ser necesario)");

        cmbBandaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No ", "Ningún cambio" }));

        jLabel147.setText("Revisión de conexiones eléctricas que se encuentren en buen estado");

        cmbConexE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel148.setText("Revisión de tablero de control (interruptor):");

        cmbIinterruptorE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel149.setText("Eliminación de ruidos o vibraciones anormales");

        cmbVibE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel150.setText("Ajuste de tornillería en general");

        cmbTorE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel151.setText("Limpieza general");

        cmbLimpiezaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No ", "Ningún cambio" }));

        jLabel152.setText("Observaciones generales");

        jLabel153.setText("Elaborado por:");

        jLabel154.setText("Revisado por:");

        jLabel155.setText("Aprobado por:");

        btnGuardarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEActionPerformed(evt);
            }
        });

        btnActualizarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEActionPerformed(evt);
            }
        });

        btnEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel145, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRodaE, 0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel138)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMatE, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel144)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVoltajeE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel141)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbModeloE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel140)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMarcaE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel139)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fechaE, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel143)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAmpE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel142)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbSerieE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtElaboradoE)
                                    .addComponent(txtRevisadoE)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel153)
                                            .addComponent(jLabel154)
                                            .addComponent(jLabel155))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtAprobadoE))))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel152)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtObE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel150)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbTorE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel149)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbVibE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel148)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbIinterruptorE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel147)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbConexE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel151)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbLimpiezaE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel146)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbBandaE, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnGuardarE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(btnActualizarE, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(cmbMatE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel146)
                            .addComponent(cmbBandaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel139)
                            .addComponent(fechaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel147)
                                .addComponent(cmbConexE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel153)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel140)
                            .addComponent(cmbMarcaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148)
                            .addComponent(cmbIinterruptorE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtElaboradoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel141)
                            .addComponent(cmbModeloE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel149)
                            .addComponent(cmbVibE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel154))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel142)
                            .addComponent(cmbSerieE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRevisadoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel150)
                            .addComponent(cmbTorE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel143)
                            .addComponent(txtAmpE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel151)
                            .addComponent(cmbLimpiezaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel144)
                            .addComponent(txtVoltajeE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel152)
                            .addComponent(txtObE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAprobadoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel145)
                        .addComponent(cmbRodaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizarE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Extractores", jPanel10);

        jLabel156.setText("Material: ");

        cmbMateM.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cmbMateM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bahumanometros", "Negatoscopios", "Plantoscopios" }));

        jLabel157.setText("Fecha:");

        jLabel158.setText("¿El material se encuentra en buen estado?");

        cmbEstadoM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No (Comentar en observaciones generales)" }));

        jLabel159.setText("Observaciones generales:");

        jLabel160.setText("Elaborado por: ");

        jLabel161.setText("Revisado por:");

        jLabel162.setText("Aprobado por:");

        btnGuardarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMActionPerformed(evt);
            }
        });

        btnActualizarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMActionPerformed(evt);
            }
        });

        btnEliminarM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMActionPerformed(evt);
            }
        });

        tablaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialm", "fecha", "chequeoGral", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMedicoMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tablaMedico);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane10)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtObM)
                            .addComponent(jLabel159)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel158)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoM, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel156)
                                    .addComponent(jLabel157))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMateM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fechaM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel162)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAprobadoM))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel160)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtElaboradoM, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel161)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRevisadoM, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnGuardarM, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnActualizarM, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnEliminarM, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 146, Short.MAX_VALUE))))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel156)
                            .addComponent(cmbMateM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel157)
                            .addComponent(fechaM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel158)
                            .addComponent(cmbEstadoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel160)
                            .addComponent(txtElaboradoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel161)
                            .addComponent(txtRevisadoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel162)
                            .addComponent(txtAprobadoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel159)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarM, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(btnActualizarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtObM))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Médico", jPanel12);

        jLabel163.setText("Material:");

        cmbMatEnf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Báscula 60 Kilos", "Báscula 140 Kilos ", "Báscula 300 Kilos", "Pediátrica", "Carro rojo", "Horno de microondas ", "Autoclave ", "Cierra Strayker", " " }));

        jLabel164.setText("Fecha:");

        jLabel165.setText("¿El material se encuentra en buen estado?");

        cmbEstadoEnf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No (Comentar en observaciones generales)" }));

        jLabel166.setText("Elaborado por:");

        jLabel167.setText("Revisado por:");

        jLabel168.setText("Aprobado por:");

        tablaEnfermeria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialenf", "fecha", "chequeoGral", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaEnfermeria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEnfermeriaMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tablaEnfermeria);

        jLabel169.setText("Observaciones generales:");

        btnGuardarEnf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEnfActionPerformed(evt);
            }
        });

        btnActualizarEnf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEnfActionPerformed(evt);
            }
        });

        btnEliminarEnf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEnfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel169)
                    .addComponent(txtObEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel163)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMatEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel164)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaEnfermeria, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel165)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel166)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtElaboradoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel167)
                                    .addComponent(jLabel168)
                                    .addComponent(btnGuardarEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRevisadoEnf)
                                            .addComponent(txtAprobadoEnf)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(btnActualizarEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(btnEliminarEnf, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel163)
                    .addComponent(cmbMatEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel166)
                    .addComponent(txtElaboradoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel164)
                    .addComponent(fechaEnfermeria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel167)
                        .addComponent(txtRevisadoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel165)
                    .addComponent(cmbEstadoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel168)
                    .addComponent(txtAprobadoEnf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel169)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarEnf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizarEnf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarEnf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtObEnf, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Enfermería", jPanel13);

        jLabel170.setText("Material:");

        jLabel171.setText("Fecha:");

        cmbMatOd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carro rojo (Terapia ocupacional) ", "Sillón odontológico", "Autoclave ", "Aparato de rayos x" }));

        jLabel172.setText("¿El material se encuentra en buen estado?");

        cmbEstadoO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No (Comentar en observaciones generales)" }));

        jLabel173.setText("Elaborado por:");

        jLabel174.setText("Revisado por:");

        jLabel175.setText("Aprobado por:");

        jLabel176.setText("Observaciones generales:");

        tablaOrto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialo", "fecha", "chequeoGral", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaOrto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOrtoMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tablaOrto);

        btnGuardarO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOActionPerformed(evt);
            }
        });

        btnActualizarO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarOActionPerformed(evt);
            }
        });

        btnEliminarO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel176)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel170)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMatOd, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel171)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaOdon, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel172)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbEstadoO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtObO, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(btnGuardarO, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(btnActualizarO, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnEliminarO, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel175)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAprobadoOdo))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel174)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRevisadoOdo))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel173)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtElaboradoOdo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel170)
                    .addComponent(cmbMatOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel173)
                    .addComponent(txtElaboradoOdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel171)
                    .addComponent(fechaOdon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel174)
                        .addComponent(txtRevisadoOdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel172)
                    .addComponent(cmbEstadoO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel175)
                    .addComponent(txtAprobadoOdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel176)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarO, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarO, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarO, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Odontopediatría", jPanel14);

        jLabel177.setText("Material:");

        jLabel178.setText("Fecha:");

        cmbMatMe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estéreo ", "Caminadora ", "Mesa de bipedestación 1 (Gde) ", "Mesa de bipedestación 2 (ch)", "Mesa de bipedestación 3 (ch)", "Espejo 1", "Espejo 2 ", "Escalerilla de madera  ", "Timón ", "Barras paralelas", "Barras Suecas ", "Escaleras ", "Soporte parcial de peso ", "Mesa inestable o de inclinación  ", "Barra de equilibrio ", "Rollo de equilibrio" }));

        jLabel179.setText("¿El material se encuentra en buen estado?");

        cmbEstadoMeca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No (Comentar en observaciones generales)" }));

        jLabel180.setText("Observaciones generales:");

        jLabel181.setText("Elaborado por:");

        jLabel182.setText("Revisado por:");

        jLabel183.setText("Aprobado por:");

        tablaMeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialo", "fecha", "chequeoGral", "observacion", "elaborado", "revisado", "aprobado", "id"
            }
        ));
        tablaMeca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMecaMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tablaMeca);

        btnGuardarMeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarMeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMecaActionPerformed(evt);
            }
        });

        btnActualizarMeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarMeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarMecaActionPerformed(evt);
            }
        });

        btnEliminarMeca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarMeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMecaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel177)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbMatMe, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel178)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaMecano, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel179))
                            .addGap(66, 66, 66)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel183)
                                .addComponent(jLabel182)
                                .addComponent(jLabel181)
                                .addComponent(btnGuardarMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(btnActualizarMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(43, 43, 43)
                                    .addComponent(btnEliminarMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtElaboradoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtRevisadoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAprobadoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel180)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cmbEstadoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtObMeca, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel177)
                    .addComponent(cmbMatMe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel181)
                    .addComponent(txtElaboradoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel178)
                    .addComponent(fechaMecano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel182)
                        .addComponent(txtRevisadoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel179)
                    .addComponent(cmbEstadoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel183)
                    .addComponent(txtAprobadoMeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel180)
                .addGap(14, 14, 14)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEliminarMeca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btnActualizarMeca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarMeca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtObMeca))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mecanoterapia", jPanel15);

        jLabel184.setText("Material:");

        cmbMatCe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proyector de imágenes ", "Ramillete de fibra óptica ", "Alberca de pelotas ", "Microcomponente  ", "Tubo de burbujas 1", "Tubo de burbujas 2", "Base de tubo de burbujas 1 ", "Base de tubo de burbujas 2", "Cortina de fibra óptica 1 ", "Cortina de fibra óptica 2", "Piano (Teclado) ", "Hamaca 1", "Hamaca 2", "Esfera de espejos con proyector ", "Colchón de agua ", "Base de colchón de agua ", "Funda de colchón de agua ", "Panel de tacto ", "Panel de sonido ", "Espejo de burbujas diamante de acrílico ", "Espejo de acrílico ", "Tapete de fibra óptica ", "Base de tapete de fibra óptica ", "Laser star 1", "Laser star 2", "Botonera " }));

        jLabel185.setText("Fecha:");

        jLabel186.setText("¿El material se encuentra en buen estado?");

        cmbEstadoCe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si ", "No (Comentar en observaciones generales)" }));

        jLabel187.setText("Observaciones generales:");

        jLabel188.setText("Elaborado por:");

        jLabel189.setText("Revisado por:");

        jLabel190.setText("Aprobado por:");

        tablaCems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material", "Fecha", "Estado", "Observaciones generales", "Elaborado", "Revisado", "Aprobado", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaCems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCemsMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tablaCems);

        btnGuardarCe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCeActionPerformed(evt);
            }
        });

        btnActualizarCe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarCe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCeActionPerformed(evt);
            }
        });

        btnEliminarCe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel187)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel185)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaCe, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel186)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstadoCe, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtObCe, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel184)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMatCe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel189)
                                    .addComponent(jLabel188)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnGuardarCe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel190))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtElaboradoCe, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRevisadoCe, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                    .addComponent(btnActualizarCe, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(42, 42, 42)
                                    .addComponent(btnEliminarCe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(100, 100, 100))
                                .addComponent(txtAprobadoCe, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel184)
                    .addComponent(cmbMatCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel188)
                    .addComponent(txtElaboradoCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel189)
                        .addComponent(txtRevisadoCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel185))
                    .addComponent(fechaCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel190)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel186)
                        .addComponent(cmbEstadoCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAprobadoCe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jLabel187)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnGuardarCe, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtObCe, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarCe, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnActualizarCe, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CEMS", jPanel16);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 940, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAireAcondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAireAcondActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarAireAcondicionado();
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnAireAcondActionPerformed

    private void btnRefrigeradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefrigeradoresActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarRefrigeradores();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_btnRefrigeradoresActionPerformed

    private void btnDesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesoActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarDosificadores();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_btnDesoActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarCompresion();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void btnBombasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBombasActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarBombas();
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_btnBombasActionPerformed

    private void btnElectricidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElectricidadActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarElectricidad();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnElectricidadActionPerformed

    private void btnBombaCalorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBombaCalorActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarBombasDeCalor();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnBombaCalorActionPerformed

    private void btnCalderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalderaActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarcalderaElectro();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnCalderaActionPerformed

    private void btnExtractorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtractorActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListaExtratorDeAire();
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_btnExtractorActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        Login ventana2 = new Login();
        ventana2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed
//
    private void btnBombaCalorHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_btnBombaCalorHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBombaCalorHierarchyChanged
//
    private void btnMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicoActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListaEquipoMedico();
        jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_btnMedicoActionPerformed

    private void btnEnfermeriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnfermeriaActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListaEnfermeria();
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_btnEnfermeriaActionPerformed

    private void btnOdonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdonActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListaOrtopedia();
        jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_btnOdonActionPerformed

    private void btnMecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMecaActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        Listamecanotera();
        jTabbedPane1.setSelectedIndex(12);
    }//GEN-LAST:event_btnMecaActionPerformed

    private void btnCemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCemsActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarCems();
        jTabbedPane1.setSelectedIndex(13);
    }//GEN-LAST:event_btnCemsActionPerformed

    private void btnGuardarElectricidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarElectricidadActionPerformed
        // TODO add your handling code here:
        String matElectricidad = cbxMatElect.getSelectedItem().toString();
        String fechaElec;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaElec = f.format(fechaElect.getDate());
        String capacidadElec = cmbCapElect.getSelectedItem().toString();
        String unidadElec = cmbUnidadElec.getSelectedItem().toString();
        String marcaElec = cmbMarcaElect.getSelectedItem().toString();
        String noSerieElec = cmbSerieElect.getSelectedItem().toString();
        String cambioAceiteElec = cmbAceiteElect.getSelectedItem().toString();
        String cambioRefrigeranteElec = cmbRefrigeranteElect.getSelectedItem().toString();
        String cambioFiltroDElec = cmbFiltroAireElect.getSelectedItem().toString();
        String cambioFiltroAElec = cmbFiltroDieselElect.getSelectedItem().toString();
        String cambioFiltroAceite = cmbFiltroAceiteElect.getSelectedItem().toString();
        String cambioFiltroRefri = cmbFiltroRefri.getSelectedItem().toString();
        String limpiezaGElec = cmbLimpiezaElect.getSelectedItem().toString();
        String observacionesElec = txtObsElect.getText();
        String elaboradoElec = txtElaboradoElect.getText();
        String revisadoElec = txtRevisadoElect.getText();
        String aprobadoElec = txtAprobadoElect.getText();

        if (elaboradoElec.isEmpty() || revisadoElec.isEmpty() || aprobadoElec.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO electricidade(material,fecha, capacidadEl, unidadEl, marcaEl, noSerieEl, cambioAceite, cambioRefrigerante, cambioFiltroAire, cambioFiltroDiesel, cambioFiltroAceite, cambioFiltroRefrigerante, limpiezaGral, observaciones, elaborado, revisado, aprobado) VALUES ('" + matElectricidad + "','" + fechaElec + "','" + capacidadElec + "','" + unidadElec + "','" + marcaElec + "','" + noSerieElec + "','" + cambioAceiteElec + "','" + cambioRefrigeranteElec + "','" + cambioFiltroDElec + "','" + cambioFiltroAElec + "','" + cambioFiltroAceite + "','" + cambioFiltroRefri + "','" + limpiezaGElec + "','" + observacionesElec + "','" + elaboradoElec + "','" + revisadoElec + "','" + aprobadoElec + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }

    }//GEN-LAST:event_btnGuardarElectricidadActionPerformed
    void limpiar() {
        cbxMatElect.setSelectedIndex(0);
        fechaElect.setDate(new Date());
        cmbCapElect.setSelectedIndex(0);
        cmbUnidadElec.setSelectedIndex(0);
        cmbMarcaElect.setSelectedIndex(0);
        cmbSerieElect.setSelectedIndex(0);
        cmbAceiteElect.setSelectedIndex(0);
        cmbRefrigeranteElect.setSelectedIndex(0);
        cmbFiltroAireElect.setSelectedIndex(0);
        cmbFiltroDieselElect.setSelectedIndex(0);
        cmbFiltroAceiteElect.setSelectedIndex(0);
        cmbFiltroRefri.setSelectedIndex(0);
        cmbLimpiezaElect.setSelectedIndex(0);
        txtObsElect.setText("");
        txtElaboradoElect.setText("");
        txtRevisadoElect.setText("");
        txtAprobadoElect.setText("");
    }
    private void txtRevisadoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRevisadoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRevisadoRActionPerformed
    private void limpiarDosi() {
        cmbMatD.setSelectedIndex(0);
        fechaD.setDate(new Date());
        cmbSelladoD.setSelectedIndex(0);
        cmbFugasD.setSelectedIndex(0);
        cmbCableadoD.setSelectedIndex(0);
        cmbLED.setSelectedIndex(0);
        cmbLID.setSelectedIndex(0);
        cmbLEvaporadorD.setSelectedIndex(0);
        cmbAmpD.setSelectedIndex(0);
        txtObD.setText("");
        txtElaboradoD.setText("");
        txtRevisadoD.setText("");
        txtAprobadoD.setText("");

    }
    private void cmbMatEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMatEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMatEActionPerformed

    private void btnGuardarCeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCeActionPerformed
        // CODIGO DEL BOTÓN GUARDAR EN CEMS
        String materialC = cmbMatCe.getSelectedItem().toString();
        String fechaC;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaC = f.format(fechaCe.getDate());
        String buenEstadoC = cmbEstadoCe.getSelectedItem().toString();
        String observacionesC = txtObCe.getText();
        String elaboradoC = txtElaboradoCe.getText();
        String revisadoC = txtRevisadoCe.getText();
        String aprobadoC = txtAprobadoCe.getText();

        if (materialC.isEmpty() || elaboradoC.isEmpty() || revisadoC.isEmpty() || aprobadoC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO cems(materialce, fecha, chequeoGral, observacion, elaborado, revisado, aprobado)VALUES('" + materialC + "','" + fechaC + "','" + buenEstadoC + "','" + observacionesC + "','" + elaboradoC + "','" + revisadoC + "','" + aprobadoC + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                limpiar();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarCems();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }


    }//GEN-LAST:event_btnGuardarCeActionPerformed

    private void limpiarCems() {
        cmbMatCe.setSelectedIndex(0);
        fechaCe.setDate(new Date());
        cmbEstadoCe.setSelectedIndex(0);
        txtObCe.setText("");
        txtElaboradoCe.setText("");
        txtRevisadoCe.setText("");
        txtAprobadoCe.setText("");
    }
    private void btnGuardarMecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMecaActionPerformed
        // TODO add your handling code here
        String materialMeca = cmbMatMe.getSelectedItem().toString();
        String fechaMeca;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaMeca = f.format(fechaMecano.getDate());
        String buenEstadoMeca = cmbEstadoMeca.getSelectedItem().toString();
        String observacionesMeca = txtObMeca.getText();
        String elaboradoMeca = txtElaboradoMeca.getText();
        String revisadoMeca = txtRevisadoMeca.getText();
        String aprobadoMeca = txtAprobadoMeca.getText();

        if (materialMeca.isEmpty() || elaboradoMeca.isEmpty() || revisadoMeca.isEmpty() || aprobadoMeca.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO mecanoterapia(materialm, fecha, chequeoGral, observacion, elaborado, revisado, aprobado)VALUES('" + materialMeca + "','" + fechaMeca + "','" + buenEstadoMeca + "','" + observacionesMeca + "','" + elaboradoMeca + "','" + revisadoMeca + "','" + aprobadoMeca + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                limpiar();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarMeca();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }

    }//GEN-LAST:event_btnGuardarMecaActionPerformed
    private void limpiarMeca() {
        cmbMatMe.setSelectedIndex(0);
        fechaMecano.setDate(new Date());
        cmbEstadoMeca.setSelectedIndex(0);
        txtObMeca.setText("");
        txtElaboradoMeca.setText("");
        txtRevisadoMeca.setText("");
        txtAprobadoMeca.setText("");
    }
    private void btnActualizarCeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCeActionPerformed
        String materialC = cmbMatCe.getSelectedItem().toString();
        String fechaC;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaC = f.format(fechaCe.getDate());
        String buenEstadoC = cmbEstadoCe.getSelectedItem().toString();
        String observacionesC = txtObCe.getText();
        String elaboradoC = txtElaboradoCe.getText();
        String revisadoC = txtRevisadoCe.getText();
        String aprobadoC = txtAprobadoCe.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoCe) || !"".equals(txtRevisadoCe) || !"".equals(txtAprobadoCe)) {
                mecanoterapiadao.modificarMeca(materialC,fechaC,buenEstadoC,observacionesC,elaboradoC,revisadoC,aprobadoC, this.getId());

                limpiarCems();
                ListarCems();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarCeActionPerformed

    private void btnGuardarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOActionPerformed
        // TODO add your handling code here:
        String materialOdo = cmbMatOd.getSelectedItem().toString();
        String fechaOdo;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaOdo = f.format(fechaOdon.getDate());
        String buenEstadoOdo = cmbEstadoO.getSelectedItem().toString();
        String observacionesOdo = txtObO.getText();
        String elaboradoOdo = txtElaboradoOdo.getText();
        String revisadoOdo = txtRevisadoOdo.getText();
        String aprobadoOdo = txtAprobadoOdo.getText();

        if (materialOdo.isEmpty() || buenEstadoOdo.isEmpty() || elaboradoOdo.isEmpty() || revisadoOdo.isEmpty() || aprobadoOdo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO odontopediatria (materialo, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES('" + materialOdo + "','" + fechaOdo + "','" + buenEstadoOdo + "','" + observacionesOdo + "','" + elaboradoOdo + "','" + revisadoOdo + "','" + aprobadoOdo + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                limpiar();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarOdo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarOActionPerformed
    private void limpiarOdo() {
        cmbMatOd.setSelectedIndex(0);
        fechaOdon.setDate(new Date());
        cmbEstadoO.setSelectedIndex(0);
        txtObO.setText("");
        txtElaboradoOdo.setText("");
        txtRevisadoOdo.setText("");
        txtAprobadoOdo.setText("");
    }
    private void btnGuardarEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEnfActionPerformed
        // TODO add your handling code here:
        String materialEnf = cmbMatEnf.getSelectedItem().toString();
        String fechaEnf;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaEnf = f.format(fechaEnfermeria.getDate());
        String buenEstadoEnf = cmbEstadoEnf.getSelectedItem().toString();
        String observacionesEnf = txtObEnf.getText();
        String elaboradoEnf = txtElaboradoEnf.getText();
        String revisadoEnf = txtRevisadoEnf.getText();
        String aprobadoEnf = txtAprobadoEnf.getText();

        if (elaboradoEnf.isEmpty() || revisadoEnf.isEmpty() || aprobadoEnf.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO enfermeria (materialenf, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES('" + materialEnf + "','" + fechaEnf + "','" + buenEstadoEnf + "','" + observacionesEnf + "','" + elaboradoEnf + "','" + revisadoEnf + "','" + aprobadoEnf + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                limpiar();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarEnf();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarEnfActionPerformed
    private void limpiarEnf() {
        cmbMatEnf.setSelectedIndex(0);
        fechaEnfermeria.setDate(new Date());
        cmbEstadoEnf.setSelectedIndex(0);
        txtObEnf.setText("");
        txtElaboradoEnf.setText("");
        txtRevisadoEnf.setText("");
        txtAprobadoEnf.setText("");
    }
    private void btnGuardarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMActionPerformed
        // TODO add your handling code here:
        String materialMed = cmbMateM.getSelectedItem().toString();
        String fechaMed;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaMed = f.format(fechaM.getDate());
        String buenEstadoMed = cmbEstadoM.getSelectedItem().toString();
        String observacionesMed = txtObM.getText();
        String elaboradoMed = txtElaboradoM.getText();
        String revisadoMed = txtRevisadoM.getText();
        String aprobadoMed = txtAprobadoM.getText();

        if (materialMed.isEmpty() || buenEstadoMed.isEmpty() || elaboradoMed.isEmpty() || revisadoMed.isEmpty() || aprobadoMed.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO equipomedico (materialm, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES('" + materialMed + "','" + fechaMed + "','" + buenEstadoMed + "','" + observacionesMed + "','" + elaboradoMed + "','" + revisadoMed + "','" + aprobadoMed + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarMed();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarMActionPerformed

    private void btnGuardarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEActionPerformed
        // Botón de guardado de Extintores
        String materialEx = cmbMatE.getSelectedItem().toString();
        String fechaEx;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaEx = f.format(fechaE.getDate());
        String marcaEx = cmbMarcaE.getSelectedItem().toString();
        String modeloEx = cmbModeloE.getSelectedItem().toString();
        String noSerieEx = cmbSerieE.getSelectedItem().toString();
        String ampEx = txtAmpE.getText();
        String voltajeEx = txtVoltajeE.getText();
        String revisionRodaEx = cmbRodaE.getSelectedItem().toString();
        String revisionBandaEx = cmbBandaE.getSelectedItem().toString();
        String revisionElectricidadEx = cmbConexE.getSelectedItem().toString();
        String revisionTableroEx = cmbIinterruptorE.getSelectedItem().toString();
        String eliminacionEx = cmbVibE.getSelectedItem().toString();
        String ajusteEx = cmbTorE.getSelectedItem().toString();
        String limpiezaEx = cmbLimpiezaE.getSelectedItem().toString();
        String observacionesEx = txtObE.getText();
        String elaboradoEx = txtElaboradoE.getText();
        String revisadoEx = txtRevisadoE.getText();
        String aprobadoEx = txtAprobadoE.getText();

        if (materialEx.isEmpty() || ampEx.isEmpty() || voltajeEx.isEmpty() || elaboradoEx.isEmpty() || revisadoEx.isEmpty() || aprobadoEx.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO extractoraire (materialex, fecha, marca, modelo, serie, medicionAmp, voltaje, revisionRondamiento, revisionBanda, revisionConexion, revisionTablero, eliminacionRuido, ajusteTornilleria, limpiezaGral, observacion, elaborado, revisado, aprobado) VALUES('" + materialEx + "','" + fechaEx + "','" + marcaEx + "','" + modeloEx + "','" + noSerieEx + "','" + ampEx + "','" + voltajeEx + "','" + revisionRodaEx + "','" + revisionBandaEx + "','" + revisionElectricidadEx + "','" + revisionTableroEx + "','" + eliminacionEx + "','" + ajusteEx + "','" + limpiezaEx + "','" + observacionesEx + "','" + elaboradoEx + "','" + revisadoEx + "','" + aprobadoEx + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarExtractor();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }

    }//GEN-LAST:event_btnGuardarEActionPerformed

    private void btnGuardarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarBActionPerformed
        // CODIGO DE GUARDADO EN BOMBAS
        String materialBom = cmbMatB.getSelectedItem().toString();
        String fechaBom;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaBom = f.format(fechaB.getDate());
        String rodamientoBom = cmbRodaB.getSelectedItem().toString();
        String selloBom = cmbSelloB.getSelectedItem().toString();
        String ampBom = txtAmpB.getText();
        String tempBom = txtTemB.getText();
        String terminalesBom = cmbAprieteB.getSelectedItem().toString();
        String accionamientoBom = txtValvulaB.getText();
        String pinturaBom = cmbPinturaB.getSelectedItem().toString();
        String manometroBom = cmbRevisionB.getSelectedItem().toString();
        String elaboradoBom = txtElaboradoB.getText();
        String revisadoBom = txtRevisadoB.getText();
        String aprobadoBom = txtAprobadoB.getText();
        String observacionesBom = txtObB.getText();

        if (materialBom.isEmpty() || ampBom.isEmpty() || tempBom.isEmpty() || accionamientoBom.isEmpty() || elaboradoBom.isEmpty() || revisadoBom.isEmpty() || aprobadoBom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO bombas (materialb, fecha, chequeoRondamiento, selloMecanico, amp, temperatura, aprieteTC, accionamiento, pintura, revisionManometro, observacion, elaborado, revisado, aprobado) VALUES('" + materialBom + "','" + fechaBom + "','" + rodamientoBom + "','" + selloBom + "','" + ampBom + "','" + tempBom + "','" + terminalesBom + "','" + accionamientoBom + "','" + pinturaBom + "','" + manometroBom + "','" + elaboradoBom + "','" + revisadoBom + "','" + aprobadoBom + "','" + observacionesBom + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarBombas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarBActionPerformed

    private void btnGuardarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRActionPerformed
        //CODIGO DE GUARDADO DE REFRIGERADORES
        String materialRefri = cmbMatR.getSelectedItem().toString();
        String fechaRefri;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaRefri = f.format(fechaR.getDate());
        String selladoRefri = cmbSelladoR.getSelectedItem().toString();
        String fugasRefri = cmbFugasR.getSelectedItem().toString();
        String cableadoRefri = cmbCableadoR.getSelectedItem().toString();
        String limpiezaExtRefri = cmbLExteriorR.getSelectedItem().toString();
        String limpiezaIntRefri = cmbLInteriorR.getSelectedItem().toString();
        String limpiezaEvaRefri = cmbLEvaporadorR.getSelectedItem().toString();
        String medicionAmpRefri = cmbAmpR.getSelectedItem().toString();
        String observacionesRefri = txtObR.getText();
        String elaboradoRefri = txtElaboradoR.getText();
        String revisadoRefri = txtRevisadoR.getText();
        String aprobadoRefri = txtAprobadoR.getText();

        if (elaboradoRefri.isEmpty() || revisadoRefri.isEmpty() || aprobadoRefri.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO refrigerador (materialref, fecha, chequeoSellado, chequeoFuga, chequeoCableado, limpiezaExterior, limpiezaInterior, limpiezaEvaporador, medicionAmp, observacion, elaborado, revisado, aprobado) VALUES('" + materialRefri + "','" + fechaRefri + "','" + selladoRefri + "','" + fugasRefri + "','" + cableadoRefri + "','" + limpiezaExtRefri + "','" + limpiezaIntRefri + "','" + limpiezaEvaRefri + "','" + medicionAmpRefri + "','" + observacionesRefri + "','" + elaboradoRefri + "','" + revisadoRefri + "','" + aprobadoRefri + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarRefri();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarRActionPerformed

    private void btnGuardarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAActionPerformed
        // CODIGO DE GUARDADO DE AIRE ACONDICIONADO
        String materialAire = cmbMatA.getSelectedItem().toString();
        String fechaAire;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaAire = f.format(fechaA.getDate());
        String limpiezaSerAire = cmbLimpiezaSA.getSelectedItem().toString();
        String limpiezaFiltroAire = cmbFiltroA.getSelectedItem().toString();
        String revisionFugaAire = cmbRevisionFA.getSelectedItem().toString();
        String medicionPresionAire = cmbRefrigeracionA.getSelectedItem().toString();
        String medicionAmpAire = txtAmpA.getText();
        String tornilleriaAire = cmbTorA.getSelectedItem().toString();
        String pinturaAire = cmPinturaA.getSelectedItem().toString();
        String limpiezaPanelControl = cmbLimpiezaPC.getSelectedItem().toString();
        String lubricacionAire = cmbLubA.getSelectedItem().toString();
        String verificarAire = cmbVentiA.getSelectedItem().toString();
        String destaparDrenesAire = cmbDrenesA.getSelectedItem().toString();
        String limpiezaEvaporadorAire = cmbLimpiezaECA.getSelectedItem().toString();
        String observacionesAire = txtObA.getText();
        String elaboradoAire = txtElaboradoA.getText();
        String revisadoAire = txtRevisadoA.getText();
        String aprobadoAire = txtAprobadoA.getText();

        if (medicionAmpAire.isEmpty() || elaboradoAire.isEmpty() || revisadoAire.isEmpty() || aprobadoAire.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO aireacondicionado (materiala, fecha, limpiezaSerpetines, limpiezaFiltroAire, revisionFugas, medicionPresion, medicionAmp, aprieteTornilleria, pintura, limpiezaPanelControl, lubricacion, verificarVentilador, destaparDrenes, limpiezaEvaporador, observaciones, elaborado, revisado, aprobado) VALUES('" + materialAire + "','" + fechaAire + "','" + limpiezaSerAire + "','" + limpiezaFiltroAire + "','" + revisionFugaAire + "','" + medicionPresionAire + "','" + medicionAmpAire + "','" + tornilleriaAire + "','" + pinturaAire + "','" + limpiezaPanelControl + "','" + lubricacionAire + "','" + verificarAire + "','" + destaparDrenesAire + "','" + limpiezaEvaporadorAire + "','" + observacionesAire + "','" + elaboradoAire + "','" + revisadoAire + "','" + aprobadoAire + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarAA();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarAActionPerformed

    private void btnGuardarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComActionPerformed
        // CODIGO DE GUARDADO DE COMPRESION
        String materialCom = cmbMatC.getSelectedItem().toString();
        String fechaCom;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaCom = f.format(fechaC.getDate());
        String capacidadCom = cmbCapaC.getSelectedItem().toString();
        String unidadCom = cmbUnidadCom.getSelectedItem().toString();
        String marcaCom = cmbMarcaCom.getSelectedItem().toString();
        String modeloCom = cmbModeloCom.getSelectedItem().toString();
        String noSerieCom = cmbSerieCom.getSelectedItem().toString();
        String medicionAmpCom = txtAmpCom.getText();
        String medicionPresionCom = txtMedPreC.getText();
        String medicionSistemaCom = cmbMedicionCom.getSelectedItem().toString();
        String limpiezaGralCom = cmbLimpiezaCom.getSelectedItem().toString();
        String revisionAceiteCom = cmbRevisionAceiteCom.getSelectedItem().toString();
        String pinturaCom = cmbPinturaCom.getSelectedItem().toString();
        String revisionPurgadoCom = cmbSisPCom.getSelectedItem().toString();
        String revisionTerminalCom = cmbTCCOM.getSelectedItem().toString();
        String observacionesCom = txtObCom.getText();
        String elaboradoCom = txtElaboradoCom.getText();
        String revisadoCom = txtRevisadoCom.getText();
        String aprobadoCom = txtAprobadoCom.getText();

        if (medicionAmpCom.isEmpty() || medicionPresionCom.isEmpty() || elaboradoCom.isEmpty() || revisadoCom.isEmpty() || aprobadoCom.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO compresoraire (materialcom, fecha, capacidad, unidad, marca, modelo, serie, medicionAmp, medicionPresion, medicionSistema, limpiezaGral, revisionAceite, pintura, revisionPurgado, revisionTerminales, observaciones, elaborado, revisado, aprobado) VALUES('" + materialCom + "','" + fechaCom + "','" + capacidadCom + "','" + unidadCom + "','" + marcaCom + "','" + modeloCom + "','" + noSerieCom + "','" + medicionAmpCom + "','" + medicionPresionCom + "','" + medicionSistemaCom + "','" + limpiezaGralCom + "','" + revisionAceiteCom + "','" + pinturaCom + "','" + revisionPurgadoCom + "','" + revisionTerminalCom + "','" + observacionesCom + "','" + elaboradoCom + "','" + revisadoCom + "','" + aprobadoCom + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarCom();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarComActionPerformed

    private void btnGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCActionPerformed
        // CODIGO DE GUARDADO DE CALDERAS
        String materialC = cmbMatCaldera.getSelectedItem().toString();
        String fechaC;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaC = f.format(fechaCaldera.getDate());
        String capacidadC = cmbCapC.getSelectedItem().toString();
        String unidadC = cmbUnidadC.getSelectedItem().toString();
        String marcaC = cmbMarcaC.getSelectedItem().toString();
        String modeloC = cmbModeloC.getSelectedItem().toString();
        String noSerieC = cmbSerieC.getSelectedItem().toString();
        String limpiezaChimeneaC = cmbLChimeneaC.getSelectedItem().toString();
        String limpiezaCeniceroC = cmbLCeniceroC.getSelectedItem().toString();
        String limpiezaQuemadorC = cmbRLQC.getSelectedItem().toString();
        String limpiezaPilotoC = cmbLPilotoC.getSelectedItem().toString();
        String revisionFlamaC = cmbFlamaC.getSelectedItem().toString();
        String revisionManometroC = cmbManoC.getSelectedItem().toString();
        String revisionValvulasC = cmbValvulaC.getSelectedItem().toString();
        String revisionSistemaC = cmbSistemaC.getSelectedItem().toString();
        String medicionAmpC = txtAmpC.getText();
        String observacionesC = txtObC.getText();
        String elaboradoC = txtElaboroC.getText();
        String revisadoC = txtRevisadoC.getText();
        String aprobadoC = txtAprobadoC.getText();

        if (medicionAmpC.isEmpty() || elaboradoC.isEmpty() || revisadoC.isEmpty() || aprobadoC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO calderaelectromecanico (materialc, fecha, capacidad, unidad, marca, modelo, serie, limpiezaChimenea, limpiezaCenicero, revisionQuemador, limpiezaPiloto, revisionFlama, revisionManometro, revisionValvulas, revisionSistema, medicionAmp, observaciones, elaborado, revisado, aprobado) VALUES('" + materialC + "','" + fechaC + "','" + capacidadC + "','" + unidadC + "','" + marcaC + "','" + modeloC + "','" + noSerieC + "','" + limpiezaChimeneaC + "','" + limpiezaCeniceroC + "','" + limpiezaQuemadorC + "','" + limpiezaPilotoC + "','" + revisionFlamaC + "','" + revisionManometroC + "','" + revisionValvulasC + "','" + revisionSistemaC + "','" + medicionAmpC + "','" + observacionesC + "','" + elaboradoC + "','" + revisadoC + "','" + aprobadoC + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarCalderaE();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarCActionPerformed

    private void btnGuardarBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarBCActionPerformed
        //CODIGO DE GUARDADO DE BOMBAS DE CALOR
        String materialBC = cmbMatBombaCalor.getSelectedItem().toString();
        String fechaBC;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaBC = f.format(fechabC.getDate());
        String capacidadBC = cmbCapBC.getSelectedItem().toString();
        String unidadBC = cmbUnidadBC.getSelectedItem().toString();
        String marcaBC = cmbMarcaBC.getSelectedItem().toString();
        String modeloBC = cmbModeloBC.getSelectedItem().toString();
        String noSerieBC = cmbSerieBC.getSelectedItem().toString();
        String lavadoPresionBC = cmbLavadoPBC.getSelectedItem().toString();
        String lavadoCondensadorBC = cmbLavadoCBC.getSelectedItem().toString();
        String revisionMotorBC = cmbRevisionMBC.getSelectedItem().toString();
        String revisionCompresorBC = cmbRevisionCBC.getSelectedItem().toString();
        String medicionAmpBC = cmbMedicionAmpBC.getSelectedItem().toString();
        String cambioTerminalesBC = cmbCambioBC.getSelectedItem().toString();
        String pinturaBC = cmbPinturaBC.getSelectedItem().toString();
        String revisionValvulasBC = cmbRevisionVBC.getSelectedItem().toString();
        String revisionFugas = cmbRevisionFu.getSelectedItem().toString();
        String revisionRefrigeranteBC = cmbRevisionRBC.getSelectedItem().toString();
        String medicionPresionBC = cmbMedicionBC.getSelectedItem().toString();
        String revisionControlBC = cmbControlB.getSelectedItem().toString();
        String observacionesBC = txtObBC.getText();
        String elaboradoBC = txtElaboradoBC.getText();
        String revisadoBC = txtRevisadoBC.getText();
        String aprobadoBC = txtAprobadoBC.getText();

        if (elaboradoBC.isEmpty() || revisadoBC.isEmpty() || aprobadoBC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO bombacalor(materialb, fecha, capacidad, unidad, marca, modelo, serie, lavadoAguaPresion, lavadoCondensador, revisionMotor, revisionCompresor, medicionAmp, cambioTerminales, pintura, revisionValvulasAgua, revisionFugas, revisionSisRefrigerante, medicionPresion, revisionControl, observaciones, elaborado, revisado, aprobado) VALUES('" + materialBC + "','" + fechaBC + "','" + capacidadBC + "','" + unidadBC + "','" + marcaBC + "','" + modeloBC + "','" + noSerieBC + "','" + lavadoPresionBC + "','" + lavadoCondensadorBC + "','" + revisionMotorBC + "','" + revisionCompresorBC + "','" + medicionAmpBC + "','" + cambioTerminalesBC + "','" + pinturaBC + "','" + revisionValvulasBC + "','" + revisionFugas + "','" + revisionRefrigeranteBC + "','" + medicionPresionBC + "','" + revisionControlBC + "','" + observacionesBC + "','" + elaboradoBC + "','" + revisadoBC + "','" + aprobadoBC + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarBombaCalor();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }

    }//GEN-LAST:event_btnGuardarBCActionPerformed

    public static Date getDateFormat(String formatPattern, String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
            return formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void tableElectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableElectMouseClicked
        // TODO add your handling code here:
        int fila = tableElect.rowAtPoint(evt.getPoint());
        cbxMatElect.setSelectedItem(tableElect.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableElect.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaElect.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbCapElect.setSelectedItem(tableElect.getValueAt(fila, 2).toString());
        cmbUnidadElec.setSelectedItem(tableElect.getValueAt(fila, 3).toString());
        cmbMarcaElect.setSelectedItem(tableElect.getValueAt(fila, 4).toString());
        cmbSerieElect.setSelectedItem(tableElect.getValueAt(fila, 5).toString());
        cmbAceiteElect.setSelectedItem(tableElect.getValueAt(fila, 6).toString());
        cmbRefrigeranteElect.setSelectedItem(tableElect.getValueAt(fila, 7).toString());
        cmbFiltroAireElect.setSelectedItem(tableElect.getValueAt(fila, 8).toString());
        cmbFiltroDieselElect.setSelectedItem(tableElect.getValueAt(fila, 9).toString());
        cmbFiltroAceiteElect.setSelectedItem(tableElect.getValueAt(fila, 10).toString());
        cmbFiltroRefri.setSelectedItem(tableElect.getValueAt(fila, 11).toString());
        cmbLimpiezaElect.setSelectedItem(tableElect.getValueAt(fila, 12).toString());
        txtObsElect.setText(tableElect.getValueAt(fila, 13).toString());
        txtElaboradoElect.setText(tableElect.getValueAt(fila, 14).toString());
        txtRevisadoElect.setText(tableElect.getValueAt(fila, 15).toString());
        this.setId(tableElect.getValueAt(fila, 17).toString());
    }//GEN-LAST:event_tableElectMouseClicked

    private void tablaBombaCalorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBombaCalorMouseClicked
        int fila = tablaBombaCalor.rowAtPoint(evt.getPoint());
        cmbMatBombaCalor.setSelectedItem(tablaBombaCalor.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaBombaCalor.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechabC.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbCapBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 2).toString());
        cmbUnidadBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 3).toString());
        cmbMarcaBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 4).toString());
        cmbModeloBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 5).toString());
        cmbSerieBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 6).toString());
        cmbLavadoPBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 7).toString());
        cmbLavadoCBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 8).toString());
        cmbRevisionMBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 9).toString());
        cmbRevisionCBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 10).toString());
        cmbMedicionAmpBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 11).toString());
        cmbCambioBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 12).toString());
        cmbPinturaBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 13).toString());
        cmbRevisionVBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 14).toString());
        cmbRevisionFu.setSelectedItem(tablaBombaCalor.getValueAt(fila, 15).toString());
        cmbRevisionRBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 16).toString());
        cmbMedicionBC.setSelectedItem(tablaBombaCalor.getValueAt(fila, 17).toString());
        cmbControlB.setSelectedItem(tablaBombaCalor.getValueAt(fila, 18).toString());
        txtObBC.setText(tablaBombaCalor.getValueAt(fila, 19).toString());
        txtElaboradoBC.setText(tablaBombaCalor.getValueAt(fila, 20).toString());
        txtRevisadoBC.setText(tablaBombaCalor.getValueAt(fila, 21).toString());
        txtAprobadoBC.setText(tablaBombaCalor.getValueAt(fila, 22).toString());
        this.setId(tablaBombaCalor.getValueAt(fila, 23).toString());
    }//GEN-LAST:event_tablaBombaCalorMouseClicked

    private void tablaCalderaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCalderaMouseClicked
        // TODO add your handling code here:
        int fila = tablaCaldera.rowAtPoint(evt.getPoint());
        cmbMatCaldera.setSelectedItem(tablaCaldera.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaCaldera.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaCaldera.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbCapC.setSelectedItem(tablaCaldera.getValueAt(fila, 2).toString());
        cmbUnidadC.setSelectedItem(tablaCaldera.getValueAt(fila, 3).toString());
        cmbMarcaC.setSelectedItem(tablaCaldera.getValueAt(fila, 4).toString());
        cmbModeloC.setSelectedItem(tablaCaldera.getValueAt(fila, 5).toString());
        cmbSerieC.setSelectedItem(tablaCaldera.getValueAt(fila, 6).toString());
        cmbLChimeneaC.setSelectedItem(tablaCaldera.getValueAt(fila, 7).toString());
        cmbLCeniceroC.setSelectedItem(tablaCaldera.getValueAt(fila, 8).toString());
        cmbRLQC.setSelectedItem(tablaCaldera.getValueAt(fila, 9).toString());
        cmbLPilotoC.setSelectedItem(tablaCaldera.getValueAt(fila, 10).toString());
        cmbFlamaC.setSelectedItem(tablaCaldera.getValueAt(fila, 11).toString());
        cmbManoC.setSelectedItem(tablaCaldera.getValueAt(fila, 12).toString());
        cmbValvulaC.setSelectedItem(tablaCaldera.getValueAt(fila, 13).toString());
        cmbSistemaC.setSelectedItem(tablaCaldera.getValueAt(fila, 14).toString());
        txtAmpC.setText(tablaCaldera.getValueAt(fila, 15).toString());
        txtObC.setText(tablaCaldera.getValueAt(fila, 16).toString());
        txtElaboroC.setText(tablaCaldera.getValueAt(fila, 17).toString());
        txtRevisadoC.setText(tablaCaldera.getValueAt(fila, 18).toString());
        txtAprobadoC.setText(tablaCaldera.getValueAt(fila, 19).toString());
        this.setId(tablaCaldera.getValueAt(fila, 20).toString());
    }//GEN-LAST:event_tablaCalderaMouseClicked

    private void tablaCompresionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCompresionMouseClicked
        // TODO add your handling code here:
        int fila = tablaCompresion.rowAtPoint(evt.getPoint());
        cmbMatC.setSelectedItem(tablaCompresion.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaCompresion.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaC.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbCapaC.setSelectedItem(tablaCompresion.getValueAt(fila, 2).toString());
        cmbUnidadCom.setSelectedItem(tablaCompresion.getValueAt(fila, 3).toString());
        cmbMarcaCom.setSelectedItem(tablaCompresion.getValueAt(fila, 4).toString());
        cmbModeloCom.setSelectedItem(tablaCompresion.getValueAt(fila, 5).toString());
        cmbSerieCom.setSelectedItem(tablaCompresion.getValueAt(fila, 6).toString());
        txtAmpCom.setText(tablaCompresion.getValueAt(fila, 7).toString());
        txtMedPreC.setText(tablaCompresion.getValueAt(fila, 8).toString());
        cmbMedicionCom.setSelectedItem(tablaCompresion.getValueAt(fila, 9).toString());
        cmbLimpiezaCom.setSelectedItem(tablaCompresion.getValueAt(fila, 10).toString());
        cmbRevisionAceiteCom.setSelectedItem(tablaCompresion.getValueAt(fila, 11).toString());
        cmbPinturaCom.setSelectedItem(tablaCompresion.getValueAt(fila, 12).toString());
        cmbSisPCom.setSelectedItem(tablaCompresion.getValueAt(fila, 13).toString());
        cmbTCCOM.setSelectedItem(tablaCompresion.getValueAt(fila, 14).toString());
        txtObCom.setText(tablaCompresion.getValueAt(fila, 15).toString());
        txtElaboradoCom.setText(tablaCompresion.getValueAt(fila, 16).toString());
        txtRevisadoCom.setText(tablaCompresion.getValueAt(fila, 17).toString());
        txtAprobadoCom.setText(tablaCompresion.getValueAt(fila, 18).toString());
        this.setId(tablaCompresion.getValueAt(fila, 19).toString());
    }//GEN-LAST:event_tablaCompresionMouseClicked

    private void tabaAAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabaAAMouseClicked
        // TODO add your handling code here:
        int fila = tabaAA.rowAtPoint(evt.getPoint());
        cmbMatA.setSelectedItem(tabaAA.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tabaAA.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaA.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbLimpiezaSA.setSelectedItem(tabaAA.getValueAt(fila, 2).toString());
        cmbFiltroA.setSelectedItem(tabaAA.getValueAt(fila, 3).toString());
        cmbRevisionFA.setSelectedItem(tabaAA.getValueAt(fila, 4).toString());
        cmbRefrigeracionA.setSelectedItem(tabaAA.getValueAt(fila, 5).toString());
        txtAmpA.setText(tabaAA.getValueAt(fila, 6).toString());
        cmbTorA.setSelectedItem(tabaAA.getValueAt(fila, 7).toString());
        cmPinturaA.setSelectedItem(tabaAA.getValueAt(fila, 8).toString());
        cmbLubA.setSelectedItem(tabaAA.getValueAt(fila, 9).toString());
        cmbVentiA.setSelectedItem(tabaAA.getValueAt(fila, 10).toString());
        cmbVentiA.setSelectedItem(tabaAA.getValueAt(fila, 11).toString());
        cmbDrenesA.setSelectedItem(tabaAA.getValueAt(fila, 12).toString());
        cmbLimpiezaECA.setSelectedItem(tabaAA.getValueAt(fila, 13).toString());
        txtObA.setText(tabaAA.getValueAt(fila, 14).toString());
        txtElaboradoA.setText(tabaAA.getValueAt(fila, 15).toString());
        txtRevisadoA.setText(tabaAA.getValueAt(fila, 16).toString());
        txtAprobadoA.setText(tabaAA.getValueAt(fila, 17).toString());
        this.setId(tabaAA.getValueAt(fila, 18).toString());
        System.out.println(tabaAA.getValueAt(fila, 18).toString());
    }//GEN-LAST:event_tabaAAMouseClicked

    private void tablaRefrigeradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRefrigeradorMouseClicked
        // TODO add your handling code here:
        int fila = tablaRefrigerador.rowAtPoint(evt.getPoint());
        cmbMatR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaRefrigerador.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaR.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbSelladoR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 2).toString());
        cmbFugasR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 3).toString());
        cmbCableadoR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 4).toString());
        cmbLExteriorR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 5).toString());
        cmbLInteriorR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 6).toString());
        cmbLEvaporadorR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 7).toString());
        cmbAmpR.setSelectedItem(tablaRefrigerador.getValueAt(fila, 8).toString());
        txtObR.setText(tablaRefrigerador.getValueAt(fila, 9).toString());
        txtElaboradoR.setText(tablaRefrigerador.getValueAt(fila, 10).toString());
        txtRevisadoR.setText(tablaRefrigerador.getValueAt(fila, 11).toString());
        txtAprobadoR.setText(tablaRefrigerador.getValueAt(fila, 12).toString());
        this.setId(tablaRefrigerador.getValueAt(fila, 13).toString());
    }//GEN-LAST:event_tablaRefrigeradorMouseClicked

    private void tableBombasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBombasMouseClicked
        // TODO add your handling code here:
        int fila = tableBombas.rowAtPoint(evt.getPoint());
        cmbMatB.setSelectedItem(tableBombas.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableBombas.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaB.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbRodaB.setSelectedItem(tableBombas.getValueAt(fila, 2).toString());
        cmbSelloB.setSelectedItem(tableBombas.getValueAt(fila, 3).toString());
        txtAmpB.setText(tableBombas.getValueAt(fila, 4).toString());
        txtTemB.setText(tableBombas.getValueAt(fila, 5).toString());
        cmbAprieteB.setSelectedItem(tableBombas.getValueAt(fila, 6).toString());
        txtValvulaB.setText(tableBombas.getValueAt(fila, 7).toString());
        cmbPinturaB.setSelectedItem(tableBombas.getValueAt(fila, 8).toString());
        cmbRevisionB.setSelectedItem(tableBombas.getValueAt(fila, 9).toString());
        txtElaboradoB.setText(tableBombas.getValueAt(fila, 10).toString());
        txtRevisadoB.setText(tableBombas.getValueAt(fila, 11).toString());
        txtObB.setText(tableBombas.getValueAt(fila, 12).toString());
        txtAprobadoB.setText(tableBombas.getValueAt(fila, 13).toString());
        this.setId(tableBombas.getValueAt(fila, 14).toString());
        System.out.println(tableBombas.getValueAt(fila, 14).toString());
    }//GEN-LAST:event_tableBombasMouseClicked

    private void tablaExtractorAireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaExtractorAireMouseClicked
        // TODO add your handling code here:
        int fila = tablaExtractorAire.rowAtPoint(evt.getPoint());
        cmbMatE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaExtractorAire.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaE.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbMarcaE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 2).toString());
        cmbModeloE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 3).toString());
        cmbSerieE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 4).toString());
        txtAmpE.setText(tablaExtractorAire.getValueAt(fila, 5).toString());
        txtVoltajeE.setText(tablaExtractorAire.getValueAt(fila, 6).toString());
        cmbRodaE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 7).toString());
        cmbBandaE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 8).toString());
        cmbConexE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 9).toString());
        cmbIinterruptorE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 10).toString());
        cmbVibE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 11).toString());
        cmbTorE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 12).toString());
        cmbLimpiezaE.setSelectedItem(tablaExtractorAire.getValueAt(fila, 13).toString());
        txtObE.setText(tablaExtractorAire.getValueAt(fila, 14).toString());
        txtElaboradoE.setText(tablaExtractorAire.getValueAt(fila, 15).toString());
        txtRevisadoE.setText(tablaExtractorAire.getValueAt(fila, 16).toString());
        txtAprobadoE.setText(tablaExtractorAire.getValueAt(fila, 17).toString());
        this.setId(tablaExtractorAire.getValueAt(fila, 18).toString());
    }//GEN-LAST:event_tablaExtractorAireMouseClicked

    private void tablaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMedicoMouseClicked
        // TODO add your handling code here:
        int fila = tablaMedico.rowAtPoint(evt.getPoint());
        cmbMateM.setSelectedItem(tablaMedico.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaMedico.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaM.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbEstadoM.setSelectedItem(tablaMedico.getValueAt(fila, 2).toString());
        txtObM.setText(tablaMedico.getValueAt(fila, 3).toString());
        txtElaboradoM.setText(tablaMedico.getValueAt(fila, 4).toString());
        txtRevisadoM.setText(tablaMedico.getValueAt(fila, 5).toString());
        txtAprobadoM.setText(tablaMedico.getValueAt(fila, 6).toString());
        this.setId(tablaMedico.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablaMedicoMouseClicked

    private void tablaEnfermeriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEnfermeriaMouseClicked
        // TODO add your handling code here:
        int fila = tablaEnfermeria.rowAtPoint(evt.getPoint());
        cmbMateM.setSelectedItem(tablaEnfermeria.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaEnfermeria.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaM.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbEstadoM.setSelectedItem(tablaEnfermeria.getValueAt(fila, 2).toString());
        txtObM.setText(tablaEnfermeria.getValueAt(fila, 3).toString());
        txtElaboradoM.setText(tablaEnfermeria.getValueAt(fila, 4).toString());
        txtRevisadoM.setText(tablaEnfermeria.getValueAt(fila, 5).toString());
        txtAprobadoM.setText(tablaEnfermeria.getValueAt(fila, 6).toString());
        this.setId(tablaEnfermeria.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablaEnfermeriaMouseClicked

    private void tablaOrtoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOrtoMouseClicked
        // TODO add your handling code here:
        int fila = tablaOrto.rowAtPoint(evt.getPoint());
        cmbMatOd.setSelectedItem(tablaOrto.getValueAt(fila, 1).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaOrto.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaOdon.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbEstadoO.setSelectedItem(tablaOrto.getValueAt(fila, 2).toString());
        txtObO.setText(tablaOrto.getValueAt(fila, 3).toString());
        txtElaboradoOdo.setText(tablaOrto.getValueAt(fila, 4).toString());
        txtRevisadoOdo.setText(tablaOrto.getValueAt(fila, 5).toString());
        txtAprobadoOdo.setText(tablaOrto.getValueAt(fila, 6).toString());
        this.setId(tablaOrto.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablaOrtoMouseClicked

    private void tablaMecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMecaMouseClicked
        // TODO add your handling code here:
        int fila = tablaMeca.rowAtPoint(evt.getPoint());
        cmbMatMe.setSelectedItem(tablaMeca.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaMeca.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaMecano.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbEstadoMeca.setSelectedItem(tablaMeca.getValueAt(fila, 2).toString());
        txtObMeca.setText(tablaMeca.getValueAt(fila, 3).toString());
        txtElaboradoMeca.setText(tablaMeca.getValueAt(fila, 4).toString());
        txtRevisadoMeca.setText(tablaMeca.getValueAt(fila, 5).toString());
        txtAprobadoMeca.setText(tablaMeca.getValueAt(fila, 6).toString());
        this.setId(tablaMeca.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablaMecaMouseClicked

    private void tablaCemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCemsMouseClicked
        // TODO add your handling code here:
        int fila = tablaCems.rowAtPoint(evt.getPoint());
        cmbMatCe.setSelectedItem(tablaCems.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaCems.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaCe.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbEstadoCe.setSelectedItem(tablaCems.getValueAt(fila, 2).toString());
        txtObCe.setText(tablaCems.getValueAt(fila, 3).toString());
        txtElaboradoCe.setText(tablaCems.getValueAt(fila, 4).toString());
        txtRevisadoCe.setText(tablaCems.getValueAt(fila, 5).toString());
        txtAprobadoCe.setText(tablaCems.getValueAt(fila, 6).toString());
        this.setId(tablaCems.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tablaCemsMouseClicked

    private void btnEliminarBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBCActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(bombcalordao.eliminarBombaCalor(rv));
                LimpiarTabla();
                ListarBombasDeCalor();
            }
        }
    }//GEN-LAST:event_btnEliminarBCActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(electricidaddao.eliminarElectricidad(rv));
                LimpiarTabla();
                ListarElectricidad();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEliminarCeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCeActionPerformed
        // CODIGO PARA ELIMINAR
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(ce.EliminarCems(rv));
                LimpiarTabla();
                ListarElectricidad();
            }
        }
    }//GEN-LAST:event_btnEliminarCeActionPerformed

    private void btnEliminarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(calderaelectrodao.eliminarCalderaE(rv));
                LimpiarTabla();
                ListarcalderaElectro();
            }
        }
    }//GEN-LAST:event_btnEliminarCActionPerformed

    private void btnEliminarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarComActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(compresiondao.eliminarCompresion(rv));
                LimpiarTabla();
                ListarcalderaElectro();
            }
        }
    }//GEN-LAST:event_btnEliminarComActionPerformed

    private void btnEliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(aireacondicionadodao.eliminarAcondicionado(rv));
                LimpiarTabla();
                ListarAireAcondicionado();
            }
        }
    }//GEN-LAST:event_btnEliminarAActionPerformed

    private void btnEliminarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(refrigeradoresdao.eliminarRefri(rv));
                LimpiarTabla();
                ListarRefrigeradores();
            }
        }
    }//GEN-LAST:event_btnEliminarRActionPerformed

    private void btnEliminarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(bombdao.eliminarBom(rv));
                LimpiarTabla();
                ListarBombas();
            }
        }
    }//GEN-LAST:event_btnEliminarBActionPerformed

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(extractoresdao.eliminarExtrac(rv));
                LimpiarTabla();
                ListaExtratorDeAire();
            }
        }
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void btnEliminarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(medicodao.eliminarMed(rv));
                LimpiarTabla();
                ListaEquipoMedico();
            }
        }
    }//GEN-LAST:event_btnEliminarMActionPerformed

    private void btnEliminarEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEnfActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(enfermeriadao.eliminarEnf(rv));
                LimpiarTabla();
                ListaEnfermeria();
            }
        }
    }//GEN-LAST:event_btnEliminarEnfActionPerformed

    private void btnEliminarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarOActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(odontopediatriadao.eliminarOdo(rv));
                LimpiarTabla();
                ListaOrtopedia();
            }
        }
    }//GEN-LAST:event_btnEliminarOActionPerformed

    private void btnEliminarMecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMecaActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(mecanoterapiadao.eliminarMeca(rv));
                LimpiarTabla();
                Listamecanotera();
            }
        }
    }//GEN-LAST:event_btnEliminarMecaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String datefacha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        datefacha = f.format(fechaElect.getDate());

        String matElectricidad = cbxMatElect.getSelectedItem().toString();

        String capacidadElec = cmbCapElect.getSelectedItem().toString();
        String unidadElec = cmbUnidadElec.getSelectedItem().toString();
        String marcaElec = cmbMarcaElect.getSelectedItem().toString();
        String noSerieElec = cmbSerieElect.getSelectedItem().toString();
        String cambioAceiteElec = cmbAceiteElect.getSelectedItem().toString();
        String cambioRefrigeranteElec = cmbRefrigeranteElect.getSelectedItem().toString();
        String cambioFiltroDElec = cmbFiltroAireElect.getSelectedItem().toString();
        String cambioFiltroAElec = cmbFiltroDieselElect.getSelectedItem().toString();
        String cambioFiltroAceite = cmbFiltroAceiteElect.getSelectedItem().toString();
        String cambioFiltroRefri = cmbFiltroRefri.getSelectedItem().toString();
        String limpiezaGElec = cmbLimpiezaElect.getSelectedItem().toString();
        String observacionesElec = txtObsElect.getText();
        String elaboradoElec = txtElaboradoElect.getText();
        String revisadoElec = txtRevisadoElect.getText();
        String aprobadoElec = txtAprobadoElect.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoElect.getText()) || !"".equals(txtRevisadoElect.getText()) || !"".equals(txtAprobadoElect.getText())) {
                System.out.println(datefacha);
                electricidaddao.modificarElectricidad(matElectricidad, datefacha, capacidadElec, unidadElec, marcaElec, noSerieElec, cambioAceiteElec, cambioRefrigeranteElec, cambioFiltroDElec, cambioFiltroAElec, cambioFiltroAceite, cambioFiltroRefri, limpiezaGElec, observacionesElec, elaboradoElec, revisadoElec, aprobadoElec, this.getId());
                ListarElectricidad();
                limpiar();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnActualizarBCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarBCActionPerformed
        // TODO add your handling code here:
        String datefacha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        datefacha = f.format(fechabC.getDate());

        String materialBC = cmbMatBombaCalor.getSelectedItem().toString();
        String capacidadBC = cmbCapBC.getSelectedItem().toString();
        String unidadBC = cmbUnidadBC.getSelectedItem().toString();
        String marcaBC = cmbMarcaBC.getSelectedItem().toString();
        String modeloBC = cmbModeloBC.getSelectedItem().toString();
        String noSerieBC = cmbSerieBC.getSelectedItem().toString();
        String lavadoPresionBC = cmbLavadoPBC.getSelectedItem().toString();
        String lavadoCondensadorBC = cmbLavadoCBC.getSelectedItem().toString();
        String revisionMotorBC = cmbRevisionMBC.getSelectedItem().toString();
        String revisionCompresorBC = cmbRevisionCBC.getSelectedItem().toString();
        String medicionAmpBC = cmbMedicionAmpBC.getSelectedItem().toString();
        String cambioTerminalesBC = cmbCambioBC.getSelectedItem().toString();
        String pinturaBC = cmbPinturaBC.getSelectedItem().toString();
        String revisionValvulasBC = cmbRevisionVBC.getSelectedItem().toString();
        String revisionFugas = cmbRevisionFu.getSelectedItem().toString();
        String revisionRefrigeranteBC = cmbRevisionRBC.getSelectedItem().toString();
        String medicionPresionBC = cmbMedicionBC.getSelectedItem().toString();
        String revisionControlBC = cmbControlB.getSelectedItem().toString();
        String observacionesBC = txtObBC.getText();
        String elaboradoBC = txtElaboradoBC.getText();
        String revisadoBC = txtRevisadoBC.getText();
        String aprobadoBC = txtAprobadoBC.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoBC.getText()) || !"".equals(txtRevisadoBC.getText()) || !"".equals(txtAprobadoBC.getText())) {
                bombcalordao.modificarBombaCalor(materialBC, datefacha, capacidadBC, unidadBC, marcaBC, modeloBC, noSerieBC, lavadoPresionBC, lavadoCondensadorBC, revisionMotorBC, revisionCompresorBC, medicionAmpBC, cambioTerminalesBC, pinturaBC, revisionValvulasBC, revisionFugas, revisionRefrigeranteBC, medicionPresionBC, revisionControlBC, observacionesBC, elaboradoBC, revisadoBC, aprobadoBC, this.getId());
                ListarBombasDeCalor();
                limpiarBombaCalor();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarBCActionPerformed

    private void btnActualizarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCActionPerformed
        // TODO add your handling code here:
        String materialC = cmbMatCaldera.getSelectedItem().toString();
        String datefacha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        datefacha = f.format(fechaCaldera.getDate());
        String capacidadC = cmbCapC.getSelectedItem().toString();
        String unidadC = cmbUnidadC.getSelectedItem().toString();
        String marcaC = cmbMarcaC.getSelectedItem().toString();
        String modeloC = cmbModeloC.getSelectedItem().toString();
        String noSerieC = cmbSerieC.getSelectedItem().toString();
        String limpiezaChimeneaC = cmbLChimeneaC.getSelectedItem().toString();
        String limpiezaCeniceroC = cmbLCeniceroC.getSelectedItem().toString();
        String limpiezaQuemadorC = cmbRLQC.getSelectedItem().toString();
        String limpiezaPilotoC = cmbLPilotoC.getSelectedItem().toString();
        String revisionFlamaC = cmbFlamaC.getSelectedItem().toString();
        String revisionManometroC = cmbManoC.getSelectedItem().toString();
        String revisionValvulasC = cmbValvulaC.getSelectedItem().toString();
        String revisionSistemaC = cmbSistemaC.getSelectedItem().toString();
        String medicionAmpC = txtAmpC.getText();
        String observacionesC = txtObC.getText();
        String elaboradoC = txtElaboroC.getText();
        String revisadoC = txtRevisadoC.getText();
        String aprobadoC = txtAprobadoC.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboroC.getText()) || !"".equals(txtRevisadoC.getText()) || !"".equals(txtAprobadoC.getText())) {
                calderaelectrodao.modificarCalderaE(materialC, datefacha, capacidadC, unidadC, marcaC, modeloC, noSerieC, limpiezaChimeneaC, limpiezaCeniceroC, limpiezaQuemadorC, limpiezaPilotoC, revisionFlamaC, revisionManometroC, revisionValvulasC, revisionSistemaC, medicionAmpC, observacionesC, elaboradoC, revisadoC, aprobadoC, this.getId());
                ListarcalderaElectro();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarCActionPerformed

    private void btnActualizarComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarComActionPerformed
        // TODO add your handling code here:
        String materialRefri = cmbMatR.getSelectedItem().toString();
        String fechaRefri;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaRefri = f.format(fechaR.getDate());
        String selladoRefri = cmbSelladoR.getSelectedItem().toString();
        String fugasRefri = cmbFugasR.getSelectedItem().toString();
        String cableadoRefri = cmbCableadoR.getSelectedItem().toString();
        String limpiezaExtRefri = cmbLExteriorR.getSelectedItem().toString();
        String limpiezaIntRefri = cmbLInteriorR.getSelectedItem().toString();
        String limpiezaEvaRefri = cmbLEvaporadorR.getSelectedItem().toString();
        String medicionAmpRefri = cmbAmpR.getSelectedItem().toString();
        String observacionesRefri = txtObR.getText();
        String elaboradoRefri = txtElaboradoR.getText();
        String revisadoRefri = txtRevisadoR.getText();
        String aprobadoRefri = txtAprobadoR.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoR.getText()) || !"".equals(txtRevisadoR.getText()) || !"".equals(txtAprobadoR.getText())) {
                refrigeradoresdao.modificarRefri(materialRefri, fechaRefri, selladoRefri, fugasRefri, cableadoRefri, limpiezaExtRefri, limpiezaIntRefri, limpiezaEvaRefri, medicionAmpRefri, observacionesRefri, elaboradoRefri, revisadoRefri, aprobadoRefri, this.getId());
                ListarRefrigeradores();
                limpiarRefri();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarComActionPerformed

    private void btnActualizarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAActionPerformed
        // TODO add your handling code here:
        String materialAire = cmbMatA.getSelectedItem().toString();
        String fechaAire;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaAire = f.format(fechaA.getDate());
        String limpiezaSerAire = cmbLimpiezaSA.getSelectedItem().toString();
        String limpiezaFiltroAire = cmbFiltroA.getSelectedItem().toString();
        String revisionFugaAire = cmbRevisionFA.getSelectedItem().toString();
        String medicionPresionAire = cmbRefrigeracionA.getSelectedItem().toString();
        String medicionAmpAire = txtAmpA.getText();
        String tornilleriaAire = cmbTorA.getSelectedItem().toString();
        String pinturaAire = cmPinturaA.getSelectedItem().toString();
        String limpiezaPanelControl = cmbLimpiezaPC.getSelectedItem().toString();
        String lubricacionAire = cmbLubA.getSelectedItem().toString();
        String verificarAire = cmbVentiA.getSelectedItem().toString();
        String destaparDrenesAire = cmbDrenesA.getSelectedItem().toString();
        String limpiezaEvaporadorAire = cmbLimpiezaECA.getSelectedItem().toString();
        String observacionesAire = txtObA.getText();
        String elaboradoAire = txtElaboradoA.getText();
        String revisadoAire = txtRevisadoA.getText();
        String aprobadoAire = txtAprobadoA.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoA.getText()) || !"".equals(txtRevisadoA.getText()) || !"".equals(txtAprobadoA.getText())) {
                aireacondicionadodao.modficarAire(materialAire, fechaAire, limpiezaSerAire, limpiezaFiltroAire, revisionFugaAire, medicionPresionAire, medicionAmpAire, tornilleriaAire, pinturaAire, limpiezaPanelControl, lubricacionAire, verificarAire, destaparDrenesAire, limpiezaEvaporadorAire, observacionesAire, elaboradoAire, revisadoAire, aprobadoAire, this.getId());
                ListarAireAcondicionado();
                limpiarAA();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarAActionPerformed

    private void btnActualizarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRActionPerformed
        // TODO add your handling code here:
        String materialRefri = cmbMatR.getSelectedItem().toString();
        String fechaRefri;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaRefri = f.format(fechaR.getDate());
        String selladoRefri = cmbSelladoR.getSelectedItem().toString();
        String fugasRefri = cmbFugasR.getSelectedItem().toString();
        String cableadoRefri = cmbCableadoR.getSelectedItem().toString();
        String limpiezaExtRefri = cmbLExteriorR.getSelectedItem().toString();
        String limpiezaIntRefri = cmbLInteriorR.getSelectedItem().toString();
        String limpiezaEvaRefri = cmbLEvaporadorR.getSelectedItem().toString();
        String medicionAmpRefri = cmbAmpR.getSelectedItem().toString();
        String observacionesRefri = txtObR.getText();
        String elaboradoRefri = txtElaboradoR.getText();
        String revisadoRefri = txtRevisadoR.getText();
        String aprobadoRefri = txtAprobadoR.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoR.getText()) || !"".equals(txtRevisadoR.getText()) || !"".equals(txtAprobadoR.getText())) {
                refrigeradoresdao.modificarRefri(materialRefri, fechaRefri, selladoRefri, fugasRefri, cableadoRefri, limpiezaExtRefri, limpiezaIntRefri, limpiezaEvaRefri, medicionAmpRefri, observacionesRefri, elaboradoRefri, revisadoRefri, aprobadoRefri, this.getId());
                ListarRefrigeradores();
                limpiarRefri();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarRActionPerformed

    private void btnActualizarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarBActionPerformed
        // TODO add your handling code here:
        String materialBom = cmbMatB.getSelectedItem().toString();
        String fechaBom;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaBom = f.format(fechaB.getDate());
        String rodamientoBom = cmbRodaB.getSelectedItem().toString();
        String selloBom = cmbSelloB.getSelectedItem().toString();
        String ampBom = txtAmpB.getText();
        String tempBom = txtTemB.getText();
        String terminalesBom = cmbAprieteB.getSelectedItem().toString();
        String accionamientoBom = txtValvulaB.getText();
        String pinturaBom = cmbPinturaB.getSelectedItem().toString();
        String manometroBom = cmbRevisionB.getSelectedItem().toString();
        String elaboradoBom = txtElaboradoB.getText();
        String revisadoBom = txtRevisadoB.getText();
        String aprobadoBom = txtAprobadoB.getText();
        String observacionesBom = txtObB.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoB.getText()) || !"".equals(txtRevisadoB.getText()) || !"".equals(txtAprobadoB.getText())) {
                bombdao.modificarBombas(materialBom, fechaBom, rodamientoBom, selloBom, ampBom, tempBom, terminalesBom, accionamientoBom, pinturaBom, manometroBom, elaboradoBom, revisadoBom, aprobadoBom, observacionesBom, this.getId());
                ListarBombas();
                limpiarBombas();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarBActionPerformed

    private void btnActualizarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEActionPerformed
        // TODO add your handling code here:
        String materialEx = cmbMatE.getSelectedItem().toString();
        String fechaEx;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaEx = f.format(fechaE.getDate());
        String marcaEx = cmbMarcaE.getSelectedItem().toString();
        String modeloEx = cmbModeloE.getSelectedItem().toString();
        String noSerieEx = cmbSerieE.getSelectedItem().toString();
        String ampEx = txtAmpE.getText();
        String voltajeEx = txtVoltajeE.getText();
        String revisionRodaEx = cmbRodaE.getSelectedItem().toString();
        String revisionBandaEx = cmbBandaE.getSelectedItem().toString();
        String revisionElectricidadEx = cmbConexE.getSelectedItem().toString();
        String revisionTableroEx = cmbIinterruptorE.getSelectedItem().toString();
        String eliminacionEx = cmbVibE.getSelectedItem().toString();
        String ajusteEx = cmbTorE.getSelectedItem().toString();
        String limpiezaEx = cmbLimpiezaE.getSelectedItem().toString();
        String observacionesEx = txtObE.getText();
        String elaboradoEx = txtElaboradoE.getText();
        String revisadoEx = txtRevisadoE.getText();
        String aprobadoEx = txtAprobadoE.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoE.getText()) || !"".equals(txtRevisadoE.getText()) || !"".equals(txtAprobadoE.getText())) {
                extractoresdao.modificarExtractor(materialEx, fechaEx, marcaEx, modeloEx, noSerieEx, ampEx, voltajeEx, revisionRodaEx, revisionBandaEx, revisionElectricidadEx, revisionTableroEx, eliminacionEx, ajusteEx, limpiezaEx, observacionesEx, elaboradoEx, revisadoEx, aprobadoEx, this.getId());
                ListaExtratorDeAire();
                limpiarExtractor();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarEActionPerformed

    private void btnActualizarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMActionPerformed
        // TODO add your handling code here:
        String materialMed = cmbMateM.getSelectedItem().toString();
        String fechaMed;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaMed = f.format(fechaM.getDate());
        String buenEstadoMed = cmbEstadoM.getSelectedItem().toString();
        String observacionesMed = txtObM.getText();
        String elaboradoMed = txtElaboradoM.getText();
        String revisadoMed = txtRevisadoM.getText();
        String aprobadoMed = txtAprobadoM.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoM.getText()) || !"".equals(txtRevisadoM.getText()) || !"".equals(txtAprobadoM.getText())) {
                medicodao.modificarMedico(materialMed, fechaMed, buenEstadoMed, observacionesMed, elaboradoMed, revisadoMed, aprobadoMed, this.getId());
                ListaEquipoMedico();
                limpiarMed();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarMActionPerformed

    private void btnActualizarEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEnfActionPerformed
        // TODO add your handling code here:
        String materialEnf = cmbMatEnf.getSelectedItem().toString();
        String fechaEnf;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaEnf = f.format(fechaEnfermeria.getDate());
        String buenEstadoEnf = cmbEstadoEnf.getSelectedItem().toString();
        String observacionesEnf = txtObEnf.getText();
        String elaboradoEnf = txtElaboradoEnf.getText();
        String revisadoEnf = txtRevisadoEnf.getText();
        String aprobadoEnf = txtAprobadoEnf.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoM.getText()) || !"".equals(txtRevisadoM.getText()) || !"".equals(txtAprobadoM.getText())) {
                enfermeriadao.modificararEnf(materialEnf, fechaEnf, buenEstadoEnf, observacionesEnf, elaboradoEnf, revisadoEnf, aprobadoEnf, this.getId());
                ListaEnfermeria();
                limpiarEnf();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarEnfActionPerformed

    private void btnActualizarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarOActionPerformed
        // TODO add your handling code here:
        String materialOdo = cmbMatOd.getSelectedItem().toString();
        String fechaOdo;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaOdo = f.format(fechaOdon.getDate());
        String buenEstadoOdo = cmbEstadoO.getSelectedItem().toString();
        String observacionesOdo = txtObO.getText();
        String elaboradoOdo = txtElaboradoOdo.getText();
        String revisadoOdo = txtRevisadoOdo.getText();
        String aprobadoOdo = txtAprobadoOdo.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoOdo.getText()) || !"".equals(txtRevisadoOdo.getText()) || !"".equals(txtAprobadoOdo.getText())) {
                odontopediatriadao.modificarOdon(materialOdo,fechaOdo,buenEstadoOdo,observacionesOdo,elaboradoOdo,revisadoOdo, aprobadoOdo, this.getId());
                ListaOrtopedia();
                limpiarOdo();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarOActionPerformed

    private void btnActualizarMecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarMecaActionPerformed
        // TODO add your handling code here:
        String materialMeca = cmbMatMe.getSelectedItem().toString();
        String fechaMeca;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaMeca = f.format(fechaMecano.getDate());
        String buenEstadoMeca = cmbEstadoMeca.getSelectedItem().toString();
        String observacionesMeca = txtObMeca.getText();
        String elaboradoMeca = txtElaboradoMeca.getText();
        String revisadoMeca = txtRevisadoMeca.getText();
        String aprobadoMeca = txtAprobadoMeca.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(elaboradoMeca) || !"".equals(revisadoMeca) || !"".equals(aprobadoMeca)) {
                this.mecanoterapiadao.modificarMeca(materialMeca,fechaMeca,buenEstadoMeca,observacionesMeca,elaboradoMeca,revisadoMeca,aprobadoMeca, this.getId());
                Listamecanotera();
                limpiarMeca();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarMecaActionPerformed

   // private void historiaByTable(String t){
     //       List<Historial> ListaHistorial = historialdao.ListarBitacoraByTable(t);
       //     modelo = (DefaultTableModel) jtblHistorial.getModel();
         //   Object[] ob = new Object[4];
           // for (int i = 0; i < ListaHistorial.size(); i++) {
             //   System.out.println("Hola mundo");
              //  ob[0] = ListaHistorial.get(i).getId();
               // ob[1] = ListaHistorial.get(i).getHost();
               // ob[2] = ListaHistorial.get(i).getUsusario();
                //ob[3] = ListaHistorial.get(i).getAccion();
               // modelo.addRow(ob);
           // }
            //jtblHistorial.setModel(modelo);
    //}
    
   // private void historiaByDate(String d){
    //        List<Historial> ListaHistorial = historialdao.ListarBitacoraByDate(d);
      //      modelo = (DefaultTableModel) jtblHistorial.getModel();
        //    Object[] ob = new Object[4];
          //  for (int i = 0; i < ListaHistorial.size(); i++) {
            //    System.out.println("Hola mundo");
              //  ob[0] = ListaHistorial.get(i).getId();
                //ob[1] = ListaHistorial.get(i).getHost();
               // ob[2] = ListaHistorial.get(i).getUsusario();
               // ob[3] = ListaHistorial.get(i).getAccion();
              //  modelo.addRow(ob);
           // }
           // jtblHistorial.setModel(modelo);
    //}
    
   // public void LimpiarHistorial(){
     //   cmbtablHisto.setSelectedIndex(0);
      //  jdcFechaHistorial.setDate(new Date());
    //}
        
    private void btnEliminarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(dosificadordao.eliminarDosif(rv));
                LimpiarTabla();
                ListarDosificadores();
            }
        }
    }//GEN-LAST:event_btnEliminarDActionPerformed

    private void btnActualizarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDActionPerformed
        // TODO add your handling code here:
        String materialDosi = cmbMatD.getSelectedItem().toString();
        String fechaDosi;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaDosi = f.format(fechaD.getDate());
        String selladoDosi = cmbSelladoD.getSelectedItem().toString();
        String fugasDosi = cmbFugasD.getSelectedItem().toString();
        String cableadoDosi = cmbCableadoD.getSelectedItem().toString();
        String limpiezaExtDosi = cmbLED.getSelectedItem().toString();
        String limpiezaIntDosi = cmbLID.getSelectedItem().toString();
        String limpiezaEvaDosi = cmbLEvaporadorD.getSelectedItem().toString();
        String medicionAmpDosi = cmbAmpD.getSelectedItem().toString();
        String observacionesDosi = txtObD.getText();
        String elaboradoDosi = txtElaboradoD.getText();
        String revisadoDosi = txtRevisadoD.getText();
        String aprobadoDosi = txtAprobadoD.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoD.getText()) || !"".equals(txtRevisadoD.getText()) || !"".equals(txtAprobadoD.getText())) {
                dosificadordao.modificarDosi(materialDosi, fechaDosi, selladoDosi, fugasDosi, cableadoDosi, limpiezaExtDosi, limpiezaIntDosi, limpiezaEvaDosi, medicionAmpDosi, observacionesDosi, elaboradoDosi, revisadoDosi, aprobadoDosi, this.getId());
                ListarDosificadores();
                limpiarDosi();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarDActionPerformed

    private void btnGuardarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDActionPerformed
        // CODIGO DE GUARDADO DE DOSIFICADORES
        String materialDosi = cmbMatD.getSelectedItem().toString();
        String fechaDosi;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaDosi = f.format(fechaD.getDate());
        String selladoDosi = cmbSelladoD.getSelectedItem().toString();
        String fugasDosi = cmbFugasD.getSelectedItem().toString();
        String cableadoDosi = cmbCableadoD.getSelectedItem().toString();
        String limpiezaExtDosi = cmbLED.getSelectedItem().toString();
        String limpiezaIntDosi = cmbLID.getSelectedItem().toString();
        String limpiezaEvaDosi = cmbLEvaporadorD.getSelectedItem().toString();
        String medicionAmpDosi = cmbAmpD.getSelectedItem().toString();
        String observacionesDosi = txtObD.getText();
        String elaboradoDosi = txtElaboradoD.getText();
        String revisadoDosi = txtRevisadoD.getText();
        String aprobadoDosi = txtAprobadoD.getText();

        if (elaboradoDosi.isEmpty() || revisadoDosi.isEmpty() || aprobadoDosi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        } else {
            try {
                String consulta = "INSERT INTO dosificadoragua(materiald, fecha, chequeoSellado, chequeoFuga, chequeoCableado, limpiezaExterior, limpiezaInterior, limpiezaEvaporador, medicionAmp, observacion, elaborado, revisado, aprobado)VALUES('" + materialDosi + "','" + fechaDosi + "','" + selladoDosi + "','" + fugasDosi + "','" + cableadoDosi + "','" + limpiezaExtDosi + "','" + limpiezaIntDosi + "','" + limpiezaEvaDosi + "','" + medicionAmpDosi + "','" + observacionesDosi + "','" + elaboradoDosi + "','" + revisadoDosi + "','" + aprobadoDosi + "')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarDosi();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion" + e);
            }
        }
    }//GEN-LAST:event_btnGuardarDActionPerformed

    private void tablaDosificadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDosificadoresMouseClicked
        // TODO add your handling code here:
        int fila = tablaDosificadores.rowAtPoint(evt.getPoint());
        cmbMatD.setSelectedItem(tablaDosificadores.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tablaDosificadores.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaD.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbSelladoD.setSelectedItem(tablaDosificadores.getValueAt(fila, 2).toString());
        cmbFugasD.setSelectedItem(tablaDosificadores.getValueAt(fila, 3).toString());
        cmbCableadoD.setSelectedItem(tablaDosificadores.getValueAt(fila, 4).toString());
        cmbLED.setSelectedItem(tablaDosificadores.getValueAt(fila, 5).toString());
        cmbLID.setSelectedItem(tablaDosificadores.getValueAt(fila, 6).toString());
        cmbLEvaporadorD.setSelectedItem(tablaDosificadores.getValueAt(fila, 7).toString());
        cmbAmpD.setSelectedItem(tablaDosificadores.getValueAt(fila, 8).toString());
        txtObD.setText(tablaDosificadores.getValueAt(fila, 9).toString());
        txtElaboradoD.setText(tablaDosificadores.getValueAt(fila, 10).toString());
        txtRevisadoD.setText(tablaDosificadores.getValueAt(fila, 11).toString());
        txtAprobadoD.setText(tablaDosificadores.getValueAt(fila, 12).toString());
        this.setId(tablaDosificadores.getValueAt(fila, 13).toString());
    }//GEN-LAST:event_tablaDosificadoresMouseClicked

    private void txtAprobadoElectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAprobadoElectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAprobadoElectActionPerformed
    private void limpiarBombaCalor() {
        cmbMatBombaCalor.setSelectedIndex(0);
        fechabC.setDate(new Date());
        cmbCapBC.setSelectedIndex(0);
        cmbUnidadBC.setSelectedIndex(0);
        cmbMarcaBC.setSelectedIndex(0);
        cmbModeloBC.setSelectedIndex(0);
        cmbSerieBC.setSelectedIndex(0);
        cmbLavadoPBC.setSelectedIndex(0);
        cmbLavadoCBC.setSelectedIndex(0);
        cmbRevisionMBC.setSelectedIndex(0);
        cmbMedicionAmpBC.setSelectedIndex(0);
        cmbCambioBC.setSelectedIndex(0);
        cmbPinturaBC.setSelectedIndex(0);
        cmbRevisionVBC.setSelectedIndex(0);
        cmbRevisionFu.setSelectedIndex(0);
        cmbRevisionRBC.setSelectedIndex(0);
        cmbMedicionBC.setSelectedIndex(0);
        cmbControlB.setSelectedIndex(0);
        txtObBC.setText("");
        txtElaboradoBC.setText("");
        txtRevisadoBC.setText("");
        txtAprobadoBC.setText("");

    }

    private void limpiarCalderaE() {
        cmbMatCaldera.setSelectedIndex(0);
        fechaCaldera.setDate(new Date());
        cmbCapC.setSelectedIndex(0);
        cmbUnidadC.setSelectedIndex(0);
        cmbMarcaC.setSelectedIndex(0);
        cmbModeloC.setSelectedIndex(0);
        cmbSerieC.setSelectedIndex(0);
        cmbLChimeneaC.setSelectedIndex(0);
        cmbLCeniceroC.setSelectedIndex(0);
        cmbRLQC.setSelectedIndex(0);
        cmbLPilotoC.setSelectedIndex(0);
        cmbFlamaC.setSelectedIndex(0);
        cmbManoC.setSelectedIndex(0);
        cmbValvulaC.setSelectedIndex(0);
        cmbSistemaC.setSelectedIndex(0);
        txtAmpC.setText("");
        txtObC.setText("");
        txtElaboroC.setText("");
        txtRevisadoC.setText("");
        txtAprobadoC.setText("");
    }

    private void limpiarCom() {
        cmbMatC.setSelectedIndex(0);
        fechaC.setDate(new Date());
        cmbCapaC.setSelectedIndex(0);
        cmbUnidadCom.setSelectedIndex(0);
        cmbMarcaCom.setSelectedIndex(0);
        cmbModeloCom.setSelectedIndex(0);
        cmbSerieCom.setSelectedIndex(0);
        txtAmpCom.setText("");
        txtMedPreC.setText("");
        cmbMedicionCom.setSelectedIndex(0);
        cmbLimpiezaCom.setSelectedIndex(0);
        cmbRevisionAceiteCom.setSelectedIndex(0);
        cmbPinturaCom.setSelectedIndex(0);
        cmbSisPCom.setSelectedIndex(0);
        cmbTCCOM.setSelectedIndex(0);
        txtObCom.setText("");
        txtElaboradoCom.setText("");
        txtRevisadoCom.setText("");
        txtAprobadoCom.setText("");

    }

    private void limpiarAA() {
        cmbMatA.setSelectedIndex(0);
        fechaA.setDate(new Date());
        cmbLimpiezaSA.setSelectedIndex(0);
        cmbFiltroA.setSelectedIndex(0);
        cmbRevisionFA.setSelectedIndex(0);
        cmbRefrigeracionA.setSelectedIndex(0);
        txtAmpA.setText("");
        cmbTorA.setSelectedIndex(0);
        cmPinturaA.setSelectedIndex(0);
        cmbLubA.setSelectedIndex(0);
        cmbVentiA.setSelectedIndex(0);
        cmbDrenesA.setSelectedIndex(0);
        cmbLimpiezaECA.setSelectedIndex(0);
        txtObA.setText("");
        txtElaboradoA.setText("");
        txtRevisadoA.setText("");
        txtAprobadoA.setText("");
    }

    private void limpiarRefri() {
        cmbMatR.setSelectedIndex(0);
        fechaR.setDate(new Date());
        cmbSelladoR.setSelectedIndex(0);
        cmbFugasR.setSelectedIndex(0);
        cmbCableadoR.setSelectedIndex(0);
        cmbLExteriorR.setSelectedIndex(0);
        cmbLInteriorR.setSelectedIndex(0);
        cmbLEvaporadorR.setSelectedIndex(0);
        cmbAmpR.setSelectedIndex(0);
        txtObR.setText("");
        txtElaboradoR.setText("");
        txtRevisadoR.setText("");
        txtAprobadoR.setText("");
    }

    private void limpiarBombas() {
        cmbMatB.setSelectedIndex(0);
        fechaB.setDate(new Date());
        cmbRodaB.setSelectedIndex(0);
        cmbSelloB.setSelectedIndex(0);
        txtAmpB.setText("");
        txtTemB.setText("");
        cmbAprieteB.setSelectedIndex(0);
        txtValvulaB.setText("");
        cmbPinturaB.setSelectedIndex(0);
        cmbRevisionB.setSelectedIndex(0);
        txtElaboradoB.setText("");
        txtRevisadoB.setText("");
        txtObB.setText("");
    }

    private void limpiarExtractor() {
        cmbMatE.setSelectedIndex(0);
        fechaE.setDate(new Date());
        cmbMarcaE.setSelectedIndex(0);
        cmbModeloE.setSelectedIndex(0);
        cmbSerieE.setSelectedIndex(0);
        txtAmpE.setText("");
        txtVoltajeE.setText("");
        cmbRodaE.setSelectedIndex(0);
        cmbBandaE.setSelectedIndex(0);
        cmbConexE.setSelectedIndex(0);
        cmbIinterruptorE.setSelectedIndex(0);
        cmbVibE.setSelectedIndex(0);
        cmbTorE.setSelectedIndex(0);
        cmbLimpiezaE.setSelectedIndex(0);
        txtObE.setText("");
        txtElaboradoE.setText("");
        txtRevisadoE.setText("");
        txtAprobadoE.setText("");

    }

    private void limpiarMed() {
        cmbMateM.setSelectedIndex(0);
        fechaM.setDate(new Date());
        cmbEstadoM.setSelectedIndex(0);
        txtObM.setText("");
        txtElaboradoM.setText("");
        txtRevisadoM.setText("");
        txtAprobadoM.setText("");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarA;
    private javax.swing.JButton btnActualizarB;
    private javax.swing.JButton btnActualizarBC;
    private javax.swing.JButton btnActualizarC;
    private javax.swing.JButton btnActualizarCe;
    private javax.swing.JButton btnActualizarCom;
    private javax.swing.JButton btnActualizarD;
    private javax.swing.JButton btnActualizarE;
    private javax.swing.JButton btnActualizarEnf;
    private javax.swing.JButton btnActualizarM;
    private javax.swing.JButton btnActualizarMeca;
    private javax.swing.JButton btnActualizarO;
    private javax.swing.JButton btnActualizarR;
    private javax.swing.JButton btnAireAcond;
    private javax.swing.JButton btnBombaCalor;
    private javax.swing.JButton btnBombas;
    private javax.swing.JButton btnCaldera;
    private javax.swing.JButton btnCems;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDeso;
    private javax.swing.JButton btnElectricidad;
    private javax.swing.JButton btnEliminarA;
    private javax.swing.JButton btnEliminarB;
    private javax.swing.JButton btnEliminarBC;
    private javax.swing.JButton btnEliminarC;
    private javax.swing.JButton btnEliminarCe;
    private javax.swing.JButton btnEliminarCom;
    private javax.swing.JButton btnEliminarD;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnEliminarEnf;
    private javax.swing.JButton btnEliminarM;
    private javax.swing.JButton btnEliminarMeca;
    private javax.swing.JButton btnEliminarO;
    private javax.swing.JButton btnEliminarR;
    private javax.swing.JButton btnEnfermeria;
    private javax.swing.JButton btnExtractor;
    private javax.swing.JButton btnGuardarA;
    private javax.swing.JButton btnGuardarB;
    private javax.swing.JButton btnGuardarBC;
    private javax.swing.JButton btnGuardarC;
    private javax.swing.JButton btnGuardarCe;
    private javax.swing.JButton btnGuardarCom;
    private javax.swing.JButton btnGuardarD;
    private javax.swing.JButton btnGuardarE;
    private javax.swing.JButton btnGuardarElectricidad;
    private javax.swing.JButton btnGuardarEnf;
    private javax.swing.JButton btnGuardarM;
    private javax.swing.JButton btnGuardarMeca;
    private javax.swing.JButton btnGuardarO;
    private javax.swing.JButton btnGuardarR;
    private javax.swing.JButton btnMeca;
    private javax.swing.JButton btnMedico;
    private javax.swing.JButton btnOdon;
    private javax.swing.JButton btnRefrigeradores;
    private javax.swing.JComboBox<String> cbxMatElect;
    private javax.swing.JComboBox<String> cmPinturaA;
    private javax.swing.JComboBox<String> cmbAceiteElect;
    private javax.swing.JComboBox<String> cmbAmpD;
    private javax.swing.JComboBox<String> cmbAmpR;
    private javax.swing.JComboBox<String> cmbAprieteB;
    private javax.swing.JComboBox<String> cmbBandaE;
    private javax.swing.JComboBox<String> cmbCableadoD;
    private javax.swing.JComboBox<String> cmbCableadoR;
    private javax.swing.JComboBox<String> cmbCambioBC;
    private javax.swing.JComboBox<String> cmbCapBC;
    private javax.swing.JComboBox<String> cmbCapC;
    private javax.swing.JComboBox<String> cmbCapElect;
    private javax.swing.JComboBox<String> cmbCapaC;
    private javax.swing.JComboBox<String> cmbConexE;
    private javax.swing.JComboBox<String> cmbControlB;
    private javax.swing.JComboBox<String> cmbDrenesA;
    private javax.swing.JComboBox<String> cmbEstadoCe;
    private javax.swing.JComboBox<String> cmbEstadoEnf;
    private javax.swing.JComboBox<String> cmbEstadoM;
    private javax.swing.JComboBox<String> cmbEstadoMeca;
    private javax.swing.JComboBox<String> cmbEstadoO;
    private javax.swing.JComboBox<String> cmbFiltroA;
    private javax.swing.JComboBox<String> cmbFiltroAceiteElect;
    private javax.swing.JComboBox<String> cmbFiltroAireElect;
    private javax.swing.JComboBox<String> cmbFiltroDieselElect;
    private javax.swing.JComboBox<String> cmbFiltroRefri;
    private javax.swing.JComboBox<String> cmbFlamaC;
    private javax.swing.JComboBox<String> cmbFugasD;
    private javax.swing.JComboBox<String> cmbFugasR;
    private javax.swing.JComboBox<String> cmbIinterruptorE;
    private javax.swing.JComboBox<String> cmbLCeniceroC;
    private javax.swing.JComboBox<String> cmbLChimeneaC;
    private javax.swing.JComboBox<String> cmbLED;
    private javax.swing.JComboBox<String> cmbLEvaporadorD;
    private javax.swing.JComboBox<String> cmbLEvaporadorR;
    private javax.swing.JComboBox<String> cmbLExteriorR;
    private javax.swing.JComboBox<String> cmbLID;
    private javax.swing.JComboBox<String> cmbLInteriorR;
    private javax.swing.JComboBox<String> cmbLPilotoC;
    private javax.swing.JComboBox<String> cmbLavadoCBC;
    private javax.swing.JComboBox<String> cmbLavadoPBC;
    private javax.swing.JComboBox<String> cmbLimpiezaCom;
    private javax.swing.JComboBox<String> cmbLimpiezaE;
    private javax.swing.JComboBox<String> cmbLimpiezaECA;
    private javax.swing.JComboBox<String> cmbLimpiezaElect;
    private javax.swing.JComboBox<String> cmbLimpiezaPC;
    private javax.swing.JComboBox<String> cmbLimpiezaSA;
    private javax.swing.JComboBox<String> cmbLubA;
    private javax.swing.JComboBox<String> cmbManoC;
    private javax.swing.JComboBox<String> cmbMarcaBC;
    private javax.swing.JComboBox<String> cmbMarcaC;
    private javax.swing.JComboBox<String> cmbMarcaCom;
    private javax.swing.JComboBox<String> cmbMarcaE;
    private javax.swing.JComboBox<String> cmbMarcaElect;
    private javax.swing.JComboBox<String> cmbMatA;
    private javax.swing.JComboBox<String> cmbMatB;
    private javax.swing.JComboBox<String> cmbMatBombaCalor;
    private javax.swing.JComboBox<String> cmbMatC;
    private javax.swing.JComboBox<String> cmbMatCaldera;
    private javax.swing.JComboBox<String> cmbMatCe;
    private javax.swing.JComboBox<String> cmbMatD;
    private javax.swing.JComboBox<String> cmbMatE;
    private javax.swing.JComboBox<String> cmbMatEnf;
    private javax.swing.JComboBox<String> cmbMatMe;
    private javax.swing.JComboBox<String> cmbMatOd;
    private javax.swing.JComboBox<String> cmbMatR;
    private javax.swing.JComboBox<String> cmbMateM;
    private javax.swing.JComboBox<String> cmbMedicionAmpBC;
    private javax.swing.JComboBox<String> cmbMedicionBC;
    private javax.swing.JComboBox<String> cmbMedicionCom;
    private javax.swing.JComboBox<String> cmbModeloBC;
    private javax.swing.JComboBox<String> cmbModeloC;
    private javax.swing.JComboBox<String> cmbModeloCom;
    private javax.swing.JComboBox<String> cmbModeloE;
    private javax.swing.JComboBox<String> cmbPinturaB;
    private javax.swing.JComboBox<String> cmbPinturaBC;
    private javax.swing.JComboBox<String> cmbPinturaCom;
    private javax.swing.JComboBox<String> cmbRLQC;
    private javax.swing.JComboBox<String> cmbRefrigeracionA;
    private javax.swing.JComboBox<String> cmbRefrigeranteElect;
    private javax.swing.JComboBox<String> cmbRevisionAceiteCom;
    private javax.swing.JComboBox<String> cmbRevisionB;
    private javax.swing.JComboBox<String> cmbRevisionCBC;
    private javax.swing.JComboBox<String> cmbRevisionFA;
    private javax.swing.JComboBox<String> cmbRevisionFu;
    private javax.swing.JComboBox<String> cmbRevisionMBC;
    private javax.swing.JComboBox<String> cmbRevisionRBC;
    private javax.swing.JComboBox<String> cmbRevisionVBC;
    private javax.swing.JComboBox<String> cmbRodaB;
    private javax.swing.JComboBox<String> cmbRodaE;
    private javax.swing.JComboBox<String> cmbSelladoD;
    private javax.swing.JComboBox<String> cmbSelladoR;
    private javax.swing.JComboBox<String> cmbSelloB;
    private javax.swing.JComboBox<String> cmbSerieBC;
    private javax.swing.JComboBox<String> cmbSerieC;
    private javax.swing.JComboBox<String> cmbSerieCom;
    private javax.swing.JComboBox<String> cmbSerieE;
    private javax.swing.JComboBox<String> cmbSerieElect;
    private javax.swing.JComboBox<String> cmbSisPCom;
    private javax.swing.JComboBox<String> cmbSistemaC;
    private javax.swing.JComboBox<String> cmbTCCOM;
    private javax.swing.JComboBox<String> cmbTorA;
    private javax.swing.JComboBox<String> cmbTorE;
    private javax.swing.JComboBox<String> cmbUnidadBC;
    private javax.swing.JComboBox<String> cmbUnidadC;
    private javax.swing.JComboBox<String> cmbUnidadCom;
    private javax.swing.JComboBox<String> cmbUnidadElec;
    private javax.swing.JComboBox<String> cmbValvulaC;
    private javax.swing.JComboBox<String> cmbVentiA;
    private javax.swing.JComboBox<String> cmbVibE;
    private com.toedter.calendar.JDateChooser fechaA;
    private com.toedter.calendar.JDateChooser fechaB;
    private com.toedter.calendar.JDateChooser fechaC;
    private com.toedter.calendar.JDateChooser fechaCaldera;
    private com.toedter.calendar.JDateChooser fechaCe;
    private com.toedter.calendar.JDateChooser fechaD;
    private com.toedter.calendar.JDateChooser fechaE;
    private com.toedter.calendar.JDateChooser fechaElect;
    private com.toedter.calendar.JDateChooser fechaEnfermeria;
    private com.toedter.calendar.JDateChooser fechaM;
    private com.toedter.calendar.JDateChooser fechaMecano;
    private com.toedter.calendar.JDateChooser fechaOdon;
    private com.toedter.calendar.JDateChooser fechaR;
    private com.toedter.calendar.JDateChooser fechabC;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabaAA;
    private javax.swing.JTable tablaBombaCalor;
    private javax.swing.JTable tablaCaldera;
    private javax.swing.JTable tablaCems;
    private javax.swing.JTable tablaCompresion;
    private javax.swing.JTable tablaDosificadores;
    private javax.swing.JTable tablaEnfermeria;
    private javax.swing.JTable tablaExtractorAire;
    private javax.swing.JTable tablaMeca;
    private javax.swing.JTable tablaMedico;
    private javax.swing.JTable tablaOrto;
    private javax.swing.JTable tablaRefrigerador;
    private javax.swing.JTable tableBombas;
    private javax.swing.JTable tableElect;
    private javax.swing.JTextField txtAmpA;
    private javax.swing.JTextField txtAmpB;
    private javax.swing.JTextField txtAmpC;
    private javax.swing.JTextField txtAmpCom;
    private javax.swing.JTextField txtAmpE;
    private javax.swing.JTextField txtAprobadoA;
    private javax.swing.JTextField txtAprobadoB;
    private javax.swing.JTextField txtAprobadoBC;
    private javax.swing.JTextField txtAprobadoC;
    private javax.swing.JTextField txtAprobadoCe;
    private javax.swing.JTextField txtAprobadoCom;
    private javax.swing.JTextField txtAprobadoD;
    private javax.swing.JTextField txtAprobadoE;
    private javax.swing.JTextField txtAprobadoElect;
    private javax.swing.JTextField txtAprobadoEnf;
    private javax.swing.JTextField txtAprobadoM;
    private javax.swing.JTextField txtAprobadoMeca;
    private javax.swing.JTextField txtAprobadoOdo;
    private javax.swing.JTextField txtAprobadoR;
    private javax.swing.JTextField txtElaboradoA;
    private javax.swing.JTextField txtElaboradoB;
    private javax.swing.JTextField txtElaboradoBC;
    private javax.swing.JTextField txtElaboradoCe;
    private javax.swing.JTextField txtElaboradoCom;
    private javax.swing.JTextField txtElaboradoD;
    private javax.swing.JTextField txtElaboradoE;
    private javax.swing.JTextField txtElaboradoElect;
    private javax.swing.JTextField txtElaboradoEnf;
    private javax.swing.JTextField txtElaboradoM;
    private javax.swing.JTextField txtElaboradoMeca;
    private javax.swing.JTextField txtElaboradoOdo;
    private javax.swing.JTextField txtElaboradoR;
    private javax.swing.JTextField txtElaboroC;
    private javax.swing.JTextField txtMedPreC;
    private javax.swing.JTextField txtObA;
    private javax.swing.JTextField txtObB;
    private javax.swing.JTextField txtObBC;
    private javax.swing.JTextField txtObC;
    private javax.swing.JTextField txtObCe;
    private javax.swing.JTextField txtObCom;
    private javax.swing.JTextField txtObD;
    private javax.swing.JTextField txtObE;
    private javax.swing.JTextField txtObEnf;
    private javax.swing.JTextField txtObM;
    private javax.swing.JTextField txtObMeca;
    private javax.swing.JTextField txtObO;
    private javax.swing.JTextField txtObR;
    private javax.swing.JTextField txtObsElect;
    private javax.swing.JTextField txtRevisadoA;
    private javax.swing.JTextField txtRevisadoB;
    private javax.swing.JTextField txtRevisadoBC;
    private javax.swing.JTextField txtRevisadoC;
    private javax.swing.JTextField txtRevisadoCe;
    private javax.swing.JTextField txtRevisadoCom;
    private javax.swing.JTextField txtRevisadoD;
    private javax.swing.JTextField txtRevisadoE;
    private javax.swing.JTextField txtRevisadoElect;
    private javax.swing.JTextField txtRevisadoEnf;
    private javax.swing.JTextField txtRevisadoM;
    private javax.swing.JTextField txtRevisadoMeca;
    private javax.swing.JTextField txtRevisadoOdo;
    private javax.swing.JTextField txtRevisadoR;
    private javax.swing.JTextField txtTemB;
    private javax.swing.JTextField txtValvulaB;
    private javax.swing.JTextField txtVoltajeE;
    // End of variables declaration//GEN-END:variables
}
