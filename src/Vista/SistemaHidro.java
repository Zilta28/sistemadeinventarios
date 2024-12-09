/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Historial;
import Modelo.HistorialDAO;
import Modelo.caldera;
import Modelo.calderaDAO;
import Modelo.cisternaAguaPotable;
import Modelo.cisternaAguaPotableDAO;
import Modelo.conexionBD;
import Modelo.extintor;
import Modelo.extintorDao;
import Modelo.gasesMedicinales;
import Modelo.gasesMedicinalesDAO;
import Modelo.gasesMedicinalesValoracion;
import Modelo.gasesMedicinalesValoracionDAO;
import Modelo.hidrante;
import Modelo.hidranteDAO;
import Modelo.incidentesTanTera;
import Modelo.incidentesTanTeraDAO;
import Modelo.ordenSerInt;
import Modelo.ordenSerIntDAO;
import Modelo.sistemaContraincendio;
import Modelo.sistemaContraincendioDAO;
import Modelo.suministroGasLp;
import Modelo.suministroGasLpDAO;
import Modelo.tanqueGas;
import Modelo.tanqueGasDAO;
import Modelo.tanqueTerapeutico;
import Modelo.tanqueTerapeuticoDAO;
import static Vista.Sistema.getDateFormat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemainventario.SistemaInventario;



/**
 *
 * @author lizbe
 */
public class SistemaHidro extends javax.swing.JFrame {
    
    private String id;
    HistorialDAO historialdao = new HistorialDAO();
    
    caldera cal = new caldera();
    calderaDAO calderaD = new calderaDAO();
    tanqueGas gas = new tanqueGas();
    tanqueGasDAO tanqueDao = new tanqueGasDAO();
    cisternaAguaPotable cis = new cisternaAguaPotable();
    cisternaAguaPotableDAO cisternaDao = new cisternaAguaPotableDAO();
    extintor ext = new extintor();
    extintorDao extDao = new extintorDao();
    gasesMedicinales gasMed = new gasesMedicinales();
    gasesMedicinalesDAO gasMDao = new gasesMedicinalesDAO();
    gasesMedicinalesValoracion gasMV = new gasesMedicinalesValoracion();
    gasesMedicinalesValoracionDAO gasVDao = new gasesMedicinalesValoracionDAO();
    hidrante hi = new hidrante();
    hidranteDAO hiDao = new hidranteDAO();
    incidentesTanTera inc = new incidentesTanTera();
    incidentesTanTeraDAO incDao = new incidentesTanTeraDAO();
    ordenSerInt ord = new ordenSerInt();
    ordenSerIntDAO ordDao = new ordenSerIntDAO();
    sistemaContraincendio sisCon = new sistemaContraincendio();
    sistemaContraincendioDAO sisConDao = new sistemaContraincendioDAO();
    suministroGasLp sumLp = new suministroGasLp();
    suministroGasLpDAO sumLpDao = new suministroGasLpDAO();
    tanqueTerapeutico tan = new tanqueTerapeutico();
    tanqueTerapeuticoDAO tanDao = new tanqueTerapeuticoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    Modelo.conexionBD con = new conexionBD();
    Connection cn = con.getConnection();
    /**
     * Creates new form SistemaHidro
     */
    public SistemaHidro() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(8);
    }
    public String getId(){
      return id;
    }

    public void setId(String id){
      this.id = id;
    }
//*
public void ListarCaldera() {
        List<caldera> ListaCalder= calderaD.ListarCaldera();
        modelo = (DefaultTableModel) TableCaldera.getModel();
        Object[] ob = new Object[11];
        for (int i = 0; i < ListaCalder.size(); i++) {
            ob[0] = ListaCalder.get(i).getNoCaldera();//2
            ob[1] = ListaCalder.get(i).getDia();//3
            ob[2] = ListaCalder.get(i).getFecha();//4
            ob[3] = ListaCalder.get(i).getHoraEncendido();//5
            ob[4] = ListaCalder.get(i).getHoraApagado();//6
            ob[5] = ListaCalder.get(i).getNombrePrende();//7
            ob[6] = ListaCalder.get(i).getNombreApaga();//8
            ob[7] = ListaCalder.get(i).getCalderaTrabajando();//9
            ob[8] = ListaCalder.get(i).getPorcentajeCa();//10
            ob[9] = ListaCalder.get(i).getObservacionesCa();//11
            ob[10] = ListaCalder.get(i).getId();//12
            modelo.addRow(ob);
        }
        TableCaldera.setModel(modelo);
    }
public void ListarTanque() {
        List<tanqueGas> ListaTanque = tanqueDao.ListarTanque();
        modelo = (DefaultTableModel) tableTanque.getModel();
        Object[] ob = new Object[10];
        for (int i = 0; i < ListaTanque.size(); i++) {
            ob[0] = ListaTanque.get(i).getNoTanquegas();//2
            ob[1] = ListaTanque.get(i).getFecha();//3
            ob[2] = ListaTanque.get(i).getHoraEncendido();//4
            ob[3] = ListaTanque.get(i).getHoraApagado();//5
            ob[4] = ListaTanque.get(i).getNombrePrende();//6
            ob[5] = ListaTanque.get(i).getNombreApaga();//7
            ob[6] = ListaTanque.get(i).getPorcentajeGas();//8
            ob[7] = ListaTanque.get(i).getElaboradoG();//9
            ob[8] = ListaTanque.get(i).getObservacionesG();//10
            ob[9] = ListaTanque.get(i).getId();//11
            modelo.addRow(ob);
        }
        tableTanque.setModel(modelo);
    }
public void ListarCisterna() {
        List<cisternaAguaPotable> ListaCist = cisternaDao.ListarCisterna();
        modelo = (DefaultTableModel) tableCisterna.getModel();
        Object[] ob = new Object[11];
        for (int i = 0; i < ListaCist.size(); i++) {
            ob[0] = ListaCist.get(i).getNoCisterna();//2
            ob[1] = ListaCist.get(i).getDiaSemana();//3
            ob[2] = ListaCist.get(i).getFechaAP();//4
            ob[3] = ListaCist.get(i).getHora();//5
            ob[4] = ListaCist.get(i).getCloro();//6
            ob[5] = ListaCist.get(i).getPh();//7
            ob[6] = ListaCist.get(i).getDureza();//8
            ob[7] = ListaCist.get(i).getNivelAgua();//9
            ob[8] = ListaCist.get(i).getNombreRevisa();//10
            ob[9] = ListaCist.get(i).getObservacionesCisterna();//11
            ob[10] = ListaCist.get(i).getId();//12
            modelo.addRow(ob);
        }
        tableTanque.setModel(modelo);
    }
    public void ListarExtintor() {
        List<extintor> ListaExtintor = extDao.ListarExtintor();
        modelo = (DefaultTableModel) tableExtintores.getModel();
        Object[] ob = new Object[24];
        for (int i = 0; i < ListaExtintor.size(); i++) {
            ob[0] = ListaExtintor.get(i).getNoExtintor();//2
            ob[1] = ListaExtintor.get(i).getFechaExtintor();//3
            ob[2] = ListaExtintor.get(i).getMarca();//4
            ob[3] = ListaExtintor.get(i).getAgente();//5
            ob[4] = ListaExtintor.get(i).getCapacidad();//6
            ob[5] = ListaExtintor.get(i).getUltimaRecarga();//7
            ob[6] = ListaExtintor.get(i).getProximaRecarga();//8
            ob[7] = ListaExtintor.get(i).getLugarAccesible();//)
            ob[8] = ListaExtintor.get(i).getLetreroSenalizacion();//18
            ob[9] = ListaExtintor.get(i).getEtiquetasLegibles();//19
            ob[10] = ListaExtintor.get(i).getHorquillaYcincho();//21
            
            ob[11] = ListaExtintor.get(i).getCorrosion();//9
            ob[12] = ListaExtintor.get(i).getEscapePresion();//10
            ob[13] = ListaExtintor.get(i).getGolpesDeformaciones();//11
            ob[14] = ListaExtintor.get(i).getExpoFuego();//12
            ob[15] = ListaExtintor.get(i).getRoturas();//13
            ob[16] = ListaExtintor.get(i).getDesprendimientoS();//14
            ob[17] = ListaExtintor.get(i).getProtuberancias();//15
            ob[18] = ListaExtintor.get(i).getPerforaciones();//16
            ob[19] = ListaExtintor.get(i).getObstrucciones();//17
            ob[20] = ListaExtintor.get(i).getManometro();//21
            ob[21] = ListaExtintor.get(i).getObservacionesEx();//22
            ob[22] = ListaExtintor.get(i).getElaboradoExt();//23
            ob[23] = ListaExtintor.get(i).getId();//24
            modelo.addRow(ob);
        }
        tableExtintores.setModel(modelo);
    }
    public void ListarGasMed() {
        List<gasesMedicinales> ListaMed = gasMDao.ListarGasMed();
        modelo = (DefaultTableModel) tableGasM.getModel();
        Object[] ob = new Object[8];
        for (int i = 0; i < ListaMed.size(); i++) {
            ob[0] = ListaMed.get(i).getFechaMed();//2
            ob[1] = ListaMed.get(i).getTipoGas();//3
            ob[2] = ListaMed.get(i).getPresionTanque();//4
            ob[3] = ListaMed.get(i).getReserva();//5
            ob[4] = ListaMed.get(i).getLimpieza();//6
            ob[5] = ListaMed.get(i).getNombreRealizoInventario();//7
            ob[6] = ListaMed.get(i).getObservacion();//8
            ob[7] = ListaMed.get(i).getId();//12
            modelo.addRow(ob);
        }
        tableGasM.setModel(modelo);
    }
//
    public void ListarMedValo() {
        List<gasesMedicinalesValoracion> ListaMedV = gasVDao.ListarMedValo();
        modelo = (DefaultTableModel) tableGasValoracion.getModel();
        Object[] ob = new Object[9];
        for (int i = 0; i < ListaMedV.size(); i++) {
            ob[0] = ListaMedV.get(i).getFechaV();//2
            ob[1] = ListaMedV.get(i).getTipoGasV();//3
            ob[2] = ListaMedV.get(i).getDiaV();//4
            ob[3] = ListaMedV.get(i).getPresionTanqueV();//5
            ob[4] = ListaMedV.get(i).getReservaV();//6
            ob[5] = ListaMedV.get(i).getLimpiezaV();//7
            ob[6] = ListaMedV.get(i).getNombreRealizoInventarioV();//8
            ob[7] = ListaMedV.get(i).getObservacionV();//9
            ob[8] = ListaMedV.get(i).getId();//10
            modelo.addRow(ob);
        }
        tableGasM.setModel(modelo);
    }
        public void ListarHidrante() {
        List<hidrante> ListaHidrante = hiDao.ListarHidrante();
        modelo = (DefaultTableModel) tableHidrante.getModel();
        Object[] ob = new Object[16];
        for (int i = 0; i < ListaHidrante.size(); i++) {
            ob[0] = ListaHidrante.get(i).getNoHidrante();//2
            ob[1] = ListaHidrante.get(i).getPeriodoMensual();//3
            ob[2] = ListaHidrante.get(i).getManguera();//4
            ob[3] = ListaHidrante.get(i).getFechaPrueba();//5
            ob[4] = ListaHidrante.get(i).getFechaProxima();//6
            ob[5] = ListaHidrante.get(i).getEdoPuerta();//7
            ob[6] = ListaHidrante.get(i).getEdoCristal();//8
            ob[7] = ListaHidrante.get(i).getEdoPintura();//9
            ob[8] = ListaHidrante.get(i).getEdoValvula();//10
            ob[9] = ListaHidrante.get(i).getEdoChiflon();//11
            ob[10] = ListaHidrante.get(i).getEdoManguera();//12
            ob[11] = ListaHidrante.get(i).getEdoLlavePataGallo();//13
            ob[12] = ListaHidrante.get(i).getEdoSeñaletica();//14
            ob[13] = ListaHidrante.get(i).getElaborado();//15
            ob[14] = ListaHidrante.get(i).getObservacion();//16
            ob[15] = ListaHidrante.get(i).getId();//17
            modelo.addRow(ob);
        }
        tableHidrante.setModel(modelo);
    }
    public void ListarIncidente() {
        List<incidentesTanTera> ListaInc = incDao.ListarIncidente();
        modelo = (DefaultTableModel) tableInc.getModel();
        Object[] ob = new Object[11];
        for (int i = 0; i < ListaInc.size(); i++) {
            ob[0] = ListaInc.get(i).getPersonaResponsable();//2
            ob[1] = ListaInc.get(i).getFecha();//3
            ob[2] = ListaInc.get(i).getHora();//4
            ob[3] = ListaInc.get(i).getTipoMateriaOrganica();//5
            ob[4] = ListaInc.get(i).getBromaminas();//6
            ob[5] = ListaInc.get(i).getTiempoCancelacion();//7
            ob[6] = ListaInc.get(i).getQuimicoAplicado();//8
            ob[7] = ListaInc.get(i).getInicioActividades();//9
            ob[8] = ListaInc.get(i).getEquipoFiltracion();//10
            ob[9] = ListaInc.get(i).getObservacion();//11
            ob[10] = ListaInc.get(i).getId();//12
            modelo.addRow(ob);
        }
        tableInc.setModel(modelo);
    }
        public void ListarOrdenSI() {
        List<ordenSerInt> ListaOrden = ordDao.ListarOrdenSI();
        modelo = (DefaultTableModel) tableSerInt.getModel();
        Object[] ob = new Object[12];
        for (int i = 0; i < ListaOrden.size(); i++) {
            ob[0] = ListaOrden.get(i).getFecha();//2
            ob[1] = ListaOrden.get(i).getEquipo();//3
            ob[2] = ListaOrden.get(i).getOficina();//4
            ob[3] = ListaOrden.get(i).getNameSolicito();//5
            ob[4] = ListaOrden.get(i).getEquipo2();//6
            ob[5] = ListaOrden.get(i).getMarca();//7
            ob[6] = ListaOrden.get(i).getModelo();//8
            ob[7] = ListaOrden.get(i).getSerie();//9
            ob[8] = ListaOrden.get(i).getTipoMantenimiento();//10
            ob[9] = ListaOrden.get(i).getDesMantenimiento();//11
            ob[10] = ListaOrden.get(i).getObservacion();//12
            ob[11] = ListaOrden.get(i).getId();//13
            modelo.addRow(ob);
        }
        tableSerInt.setModel(modelo);
    }
        public void ListarContraincendio() {
        List<sistemaContraincendio> ListaContra = sisConDao.ListarContraincendio();
        modelo = (DefaultTableModel) tableSisCon.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < ListaContra.size(); i++) {
            ob[0] = ListaContra.get(i).getFecha();//2
            ob[1] = ListaContra.get(i).getMaterial();//3
            ob[2] = ListaContra.get(i).getPrueba();//4
            ob[3] = ListaContra.get(i).getObservacion();//5
            ob[4] = ListaContra.get(i).getElaborado();//6
            ob[5] = ListaContra.get(i).getId();//7
            modelo.addRow(ob);
        }
        tableSisCon.setModel(modelo);
    }
    public void ListarLp() {
      List<suministroGasLp> ListaLp = sumLpDao.ListarLpo();
      modelo = (DefaultTableModel) tableLp.getModel();
      Object[] ob = new Object[12];
      for (int i = 0; i < ListaLp.size(); i++) {
        ob[0] = ListaLp.get(i).getFecha();//2
        ob[1] = ListaLp.get(i).getMateriaLp();//3
        ob[2] = ListaLp.get(i).getLitro();//4
        ob[3] = ListaLp.get(i).getCosto();//5
        ob[4] = ListaLp.get(i).getSubtotal();//6
        ob[5] = ListaLp.get(i).getHoraEntrada();//7
        ob[6] = ListaLp.get(i).getHoraSalida();//8
        ob[7] = ListaLp.get(i).getSeguridad();//9
        ob[8] = ListaLp.get(i).getEncargado();//10
        ob[9] = ListaLp.get(i).getChofer();//11
        ob[10] = ListaLp.get(i).getObservacionesG();//12
        ob[11] = ListaLp.get(i).getId();//13
            modelo.addRow(ob);
        }
        tableLp.setModel(modelo);
    }
    
        public void ListarTanTera() {
        List<tanqueTerapeutico> ListaTera = tanDao.ListarTera();
        modelo = (DefaultTableModel) tableTera.getModel();
        Object[] ob = new Object[23];
        for (int i = 0; i < ListaTera.size(); i++) {
            ob[0] = ListaTera.get(i).getFecha();//2
            ob[1] = ListaTera.get(i).getNombreLectura();//3
            ob[2] = ListaTera.get(i).getDiaSemana();//4
            ob[3] = ListaTera.get(i).getHora();//5
            ob[4] = ListaTera.get(i).getBromo();//6
            ob[5] = ListaTera.get(i).getPh();//7
            ob[6] = ListaTera.get(i).getAlcalinidad();//8
            ob[7] = ListaTera.get(i).getDureza(); //9
            ob[8] = ListaTera.get(i).getTemperatura();//10
            ob[9] = ListaTera.get(i).getCloroBromado();//11
            ob[10] = ListaTera.get(i).getShockPreventivo(); //12
            ob[11] = ListaTera.get(i).getAcido();//13 
            ob[12] = ListaTera.get(i).getClarificador();//14
            ob[13] = ListaTera.get(i).getAspirado();//15
            ob[14] = ListaTera.get(i).getCepillado();//16
            ob[15] = ListaTera.get(i).getContornado();//17
            ob[16] = ListaTera.get(i).getMotobomba1();//18
            ob[17] = ListaTera.get(i).getMotobomba2();//19
            ob[18] = ListaTera.get(i).getFiltro1();//20
            ob[19] = ListaTera.get(i).getPresion1();//21
            ob[20] = ListaTera.get(i).getRetrolavado1();//22
            ob[21] = ListaTera.get(i).getObservacion();//23
            ob[22] = ListaTera.get(i).getId();//12
            modelo.addRow(ob);
        }
        tableTera.setModel(modelo);
    }
    //*    
        public void LimpiarTable(){
            for(int i = 0; i<modelo.getRowCount(); i++){
                modelo.removeRow(i);
                i = i-1;
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

        grupo1 = new javax.swing.ButtonGroup();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableExtintor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbnoCaldera = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoraEncendido = new javax.swing.JTextField();
        txtHoraApagado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombrePrendeCal = new javax.swing.JTextField();
        txtNameApagaCal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableCaldera = new javax.swing.JTable();
        btnGuardarCal = new javax.swing.JButton();
        fechaCaldera = new com.toedter.calendar.JDateChooser();
        cmbDiaCal = new javax.swing.JComboBox<>();
        btnEliminarCal = new javax.swing.JButton();
        btnActualizarCal = new javax.swing.JButton();
        cmbCalderaTra = new javax.swing.JComboBox<>();
        jLabel64 = new javax.swing.JLabel();
        txtPorcentajeCal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtObCa = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cmbTanque = new javax.swing.JComboBox<>();
        txtHoraET = new javax.swing.JTextField();
        txtHoraAG = new javax.swing.JTextField();
        txtNamePrendeT = new javax.swing.JTextField();
        txtNameAoagaT = new javax.swing.JTextField();
        txtPorceT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTanque = new javax.swing.JTable();
        btnGuardarT = new javax.swing.JButton();
        btnActualizarT = new javax.swing.JButton();
        btnEliminarT = new javax.swing.JButton();
        fechaTanqueG = new com.toedter.calendar.JDateChooser();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        txtElaboradoTan = new javax.swing.JTextField();
        txtObTan = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cmbCisterna = new javax.swing.JComboBox<>();
        txtHoraCis = new javax.swing.JTextField();
        txtCloroC = new javax.swing.JTextField();
        txtPhC = new javax.swing.JTextField();
        txtDurezaC = new javax.swing.JTextField();
        txtNivelC = new javax.swing.JTextField();
        btnGuardarCisterna = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCisterna = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        cmbSemanaCis = new javax.swing.JComboBox<>();
        btnActualizarCis = new javax.swing.JButton();
        btnEliminarCis = new javax.swing.JButton();
        fechaCisterna = new com.toedter.calendar.JDateChooser();
        jLabel74 = new javax.swing.JLabel();
        txtObCisterna = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        btnGuardarExtintor = new javax.swing.JButton();
        cmbNoExtintor = new javax.swing.JComboBox<>();
        btnEliminarE = new javax.swing.JButton();
        btnActualizarE = new javax.swing.JButton();
        cmbMarcaEx = new javax.swing.JComboBox<>();
        cmbAgenteE = new javax.swing.JComboBox<>();
        cmbCapE = new javax.swing.JComboBox<>();
        cmbAccesibleExt = new javax.swing.JComboBox<>();
        cmbSenalE = new javax.swing.JComboBox<>();
        cmbEtiquetaE = new javax.swing.JComboBox<>();
        cmbManoE = new javax.swing.JComboBox<>();
        cmbSeguridadE = new javax.swing.JComboBox<>();
        cmbCorrosionExt = new javax.swing.JComboBox<>();
        cmbPresionExt = new javax.swing.JComboBox<>();
        cmbGolpeExt = new javax.swing.JComboBox<>();
        cmbExpoExt = new javax.swing.JComboBox<>();
        cmbRoturaExt = new javax.swing.JComboBox<>();
        cmbDesprenExt = new javax.swing.JComboBox<>();
        cmbProtuExt = new javax.swing.JComboBox<>();
        cmbPerfoExt = new javax.swing.JComboBox<>();
        cmbObstruccionExt = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        fechaExt = new com.toedter.calendar.JDateChooser();
        jLabel91 = new javax.swing.JLabel();
        txtObExt = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        txtElaboradoExt = new javax.swing.JTextField();
        jScrollPane14 = new javax.swing.JScrollPane();
        tableExtintores = new javax.swing.JTable();
        cmbGolpesDefor = new javax.swing.JComboBox<>();
        fechaUltExt = new javax.swing.JTextField();
        fechaProExt = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtNameInv = new javax.swing.JTextField();
        tipoGasH = new javax.swing.JComboBox<>();
        txtPresionT = new javax.swing.JTextField();
        txtReservaT = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableGasM = new javax.swing.JTable();
        btnGuardarGas = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtObGenGa = new javax.swing.JTextField();
        btnActualizarGas = new javax.swing.JButton();
        btnEliminarGas = new javax.swing.JButton();
        cmbLimpiezaG = new javax.swing.JComboBox<>();
        fechaGasesH = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        cmbTipoGasV = new javax.swing.JComboBox<>();
        txtPresionTanV = new javax.swing.JTextField();
        txtReservaGasV = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableGasValoracion = new javax.swing.JTable();
        btnGuardarGasV = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        txtNameRealizoGV = new javax.swing.JTextField();
        cmbFechaGasV = new javax.swing.JComboBox<>();
        jLabel182 = new javax.swing.JLabel();
        txtObserGenGaV = new javax.swing.JTextField();
        btnActualizarGasV = new javax.swing.JButton();
        btnEliminarGasV = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        fechaGaValor = new com.toedter.calendar.JDateChooser();
        jLabel66 = new javax.swing.JLabel();
        cmbLimpiezaGasV = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        btnGuardarH = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableHidrante = new javax.swing.JTable();
        cmbMatH = new javax.swing.JComboBox<>();
        btnActualizarH = new javax.swing.JButton();
        btnEliminarH = new javax.swing.JButton();
        fechaPruebaH = new com.toedter.calendar.JDateChooser();
        fechaProxH = new com.toedter.calendar.JDateChooser();
        jLabel76 = new javax.swing.JLabel();
        jLabel183 = new javax.swing.JLabel();
        txtObG = new javax.swing.JTextField();
        cmbManH = new javax.swing.JComboBox<>();
        cmbPuertaH = new javax.swing.JComboBox<>();
        cmbCristalH = new javax.swing.JComboBox<>();
        cmbPinturaH = new javax.swing.JComboBox<>();
        cmbValvulaH = new javax.swing.JComboBox<>();
        cmbChiflonH = new javax.swing.JComboBox<>();
        cmbMangueraH = new javax.swing.JComboBox<>();
        cmbLlaveH = new javax.swing.JComboBox<>();
        cmbSenalH = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        txtElaboroH = new javax.swing.JTextField();
        fechaHidrante = new com.toedter.calendar.JDateChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        txtPersonalIn = new javax.swing.JTextField();
        txtHoraIn = new javax.swing.JTextField();
        txtMateriaInc = new javax.swing.JTextField();
        txtBromaminasInc = new javax.swing.JTextField();
        txtCancelacionInc = new javax.swing.JTextField();
        txtQuimicoInc = new javax.swing.JTextField();
        txtActividadInc = new javax.swing.JTextField();
        txtFiltracionInc = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        txtObservacionInc = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableInc = new javax.swing.JTable();
        btnGuardarInc = new javax.swing.JButton();
        btnActualizarInc = new javax.swing.JButton();
        btnEliminarInc = new javax.swing.JButton();
        fechaIncidente = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        txtEquipoSerInt = new javax.swing.JTextField();
        txtSAreaerInt = new javax.swing.JTextField();
        txtSoliSerInt = new javax.swing.JTextField();
        txtEquipoServicio = new javax.swing.JTextField();
        txtMarcaServInt = new javax.swing.JTextField();
        txtModeloSerInt = new javax.swing.JTextField();
        txtSerieSerInt = new javax.swing.JTextField();
        txtTipoSerInt = new javax.swing.JTextField();
        txtDescSerInt = new javax.swing.JTextField();
        txtObserSerInt = new javax.swing.JTextField();
        btnGuardarSerInt = new javax.swing.JButton();
        fechaServInt = new com.toedter.calendar.JDateChooser();
        btnActualizarSerInt = new javax.swing.JButton();
        btnEliminarSerInt = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableSerInt = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        btnGuardarContra = new javax.swing.JButton();
        jLabel129 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jButton47 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        fechaSis = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        cmbMatC = new javax.swing.JComboBox<>();
        cmbPrueba = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        tableSisCon = new javax.swing.JTable();
        jLabel106 = new javax.swing.JLabel();
        txtElaboradoSis = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        txtHoraEntradaSum = new javax.swing.JTextField();
        txtHoraSalidaSum = new javax.swing.JTextField();
        txtFirmaEncargadoSum = new javax.swing.JTextField();
        txtFirmaChoferSum = new javax.swing.JTextField();
        cmbSeguridadSum = new javax.swing.JComboBox<>();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        txtLitroSum = new javax.swing.JTextField();
        txtCostoSum = new javax.swing.JTextField();
        jLabel147 = new javax.swing.JLabel();
        txtSubtotalSum = new javax.swing.JTextField();
        btnGuardarSuministroGas = new javax.swing.JButton();
        jFechaSum = new com.toedter.calendar.JDateChooser();
        btnActualizarSum = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        cmbMatSum = new javax.swing.JComboBox<>();
        btnEliminarSum = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        tableLp = new javax.swing.JTable();
        jLabel120 = new javax.swing.JLabel();
        txtObLp = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        cmbDiaT = new javax.swing.JComboBox<>();
        cmbHoraT = new javax.swing.JComboBox<>();
        jLabel152 = new javax.swing.JLabel();
        txtElaboroT = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        txtBromoT = new javax.swing.JTextField();
        txtPhT = new javax.swing.JTextField();
        txtAlcaT = new javax.swing.JTextField();
        txtDurezaT = new javax.swing.JTextField();
        txtTempT = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        txtPresionTera = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();
        jLabel181 = new javax.swing.JLabel();
        txtObsT = new javax.swing.JTextField();
        fechaT = new com.toedter.calendar.JDateChooser();
        cmbCloroT = new javax.swing.JComboBox<>();
        cmbShockT = new javax.swing.JComboBox<>();
        cmbAcidoT = new javax.swing.JComboBox<>();
        cmbClaT = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        cmbFiltroT = new javax.swing.JComboBox<>();
        cmbRetroT = new javax.swing.JComboBox<>();
        cmbAspiradoT = new javax.swing.JComboBox<>();
        cmbCepilladoT = new javax.swing.JComboBox<>();
        cmbConT = new javax.swing.JComboBox<>();
        cmbMoto1T = new javax.swing.JComboBox<>();
        cmbMoto2T = new javax.swing.JComboBox<>();
        jButton55 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tableTera = new javax.swing.JTable();

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(jTable11);

        tableExtintor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "materialext", "fecha", "marca", "agentExtintor", "capacidad", "fechaUltimaRecarga", "fechaProxRecarga", "lugarAccesible", "letrero", "etiquetasLegibles", "horquilla", "corrocion", "nullescapePresion", "deformacion", "exposicion", "roturas", "desprendimiento", "protuberacion", "perforacion", "obstruccion", "manometro", "observacion", "elaborado"
            }
        ));
        jScrollPane8.setViewportView(tableExtintor);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/png-transparent-universidad-teleton-2016-chilean-telethon-foundation-cancun-purple-text-hand-removebg-preview (1).png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calderas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cisterna de agua potable");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Extintores");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Gases medicinales");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Hidrante");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Incidentes de tanques terapeúticos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Orden de servicio interno");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Sistema contraincendio");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Suministro de gas LP");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Tanque terapeútico");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Gases medicinales valoracion");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cerrar-sesion.png"))); // NOI18N
        jButton14.setText("Cerrar sesión");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Tanques de gas");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(11, 11, 11)
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addGap(18, 18, 18)
                .addComponent(jButton14)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 670));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Imagen1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 510, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Imagen2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 560, 90));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("¿Qué caldera o tanque de gas desea registrar?");

        cmbnoCaldera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cmbnoCaldera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbnoCalderaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setText("Dia de la semana:");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setText("Fecha:");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setText("Hora de encendido:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setText("Hora de apagado:");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setText("Nombre de quien prende:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setText("Nombre de quien apaga:");

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setText("¿La caldera se encuentra trabajando?");

        TableCaldera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "noCaldera", "dia", "fecha", "horaEncendido", "horaApagado", "nombrePrende", "nombreApaga", "calderatrabajando", "porcentaje", "observaciones", "id"
            }
        ));
        TableCaldera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCalderaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableCaldera);

        btnGuardarCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCalActionPerformed(evt);
            }
        });

        cmbDiaCal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes ", "Martes", "Miercoles", "Jueves ", "Viernes" }));

        btnEliminarCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCalActionPerformed(evt);
            }
        });

        btnActualizarCal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarCal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCalActionPerformed(evt);
            }
        });

        cmbCalderaTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No" }));

        jLabel64.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel64.setText("Porcentaje de gas Lp:");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setText("Observaciones generales:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNameApagaCal))
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbDiaCal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(fechaCaldera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraEncendido, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombrePrendeCal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtHoraApagado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbCalderaTra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(btnGuardarCal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnActualizarCal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnEliminarCal)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(jLabel13)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbnoCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel64)
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObCa, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcentajeCal, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbnoCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(txtPorcentajeCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbDiaCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(fechaCaldera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtHoraEncendido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtHoraApagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNombrePrendeCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtNameApagaCal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)
                        .addGap(30, 30, 30)
                        .addComponent(cmbCalderaTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObCa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarCal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarCal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Calderas", jPanel1);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setText("¿Qué tanque desea registrar?");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setText("Fecha:");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setText("Hora de encendido:");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel16.setText("Hora de apagado:");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setText("Nombre de quien prende:");

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel18.setText("Nombre de quien apaga:");

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel19.setText("¿Cúal es el porcentaje de gas?");

        cmbTanque.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        tableTanque.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        tableTanque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "noMat", "fecha", "encendido", "apagado", "nameprende", "nameapaga", "porcentaje", "elaborado", "observacion", "id"
            }
        ));
        tableTanque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTanqueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableTanque);

        btnGuardarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarTActionPerformed(evt);
            }
        });

        btnActualizarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTActionPerformed(evt);
            }
        });

        btnEliminarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel93.setText("Elaborado por:");

        jLabel95.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel95.setText("Observaciones generales:");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTanque, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnGuardarT)
                        .addGap(61, 61, 61)
                        .addComponent(btnActualizarT)
                        .addGap(66, 66, 66)
                        .addComponent(btnEliminarT)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addComponent(txtObTan, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaTanqueG, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraET, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(txtHoraAG, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNamePrendeT, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNameAoagaT, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPorceT, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtElaboradoTan, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbTanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(fechaTanqueG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtHoraET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtHoraAG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtNamePrendeT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNameAoagaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtPorceT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel93)
                            .addComponent(txtElaboradoTan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel95)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObTan, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarT, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tanques de gas", jPanel15);

        jLabel20.setText("¿Qué número de cisterna desea registrar?");

        jLabel21.setText("Día de la semana:");

        jLabel22.setText("Fecha:");

        jLabel23.setText("Hora:");

        jLabel24.setText("Cloro 0.20-1.50 mg/litro (ppm):");

        jLabel25.setText("pH (ppm):");

        jLabel26.setText("Dureza total (ppm):");

        jLabel27.setText("Nivel de agua:");

        cmbCisterna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cisterna 1 (agua potable) 90 m3", "Cisterna 2 (agua potable) 90 m3", "Cisterna 3 (Agua de Reuso) 40 m3 " }));
        cmbCisterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCisternaActionPerformed(evt);
            }
        });

        btnGuardarCisterna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCisterna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCisternaActionPerformed(evt);
            }
        });

        tableCisterna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "noCisterna", "dia", "fecha", "hora", "cloro", "ph", "durezaTotal", "nivelAgua", "nombre", "observaciones", "id"
            }
        ));
        tableCisterna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCisternaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCisterna);

        jLabel28.setText("Nombre de quien revisa:");

        cmbSemanaCis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes ", "Miercoles ", "Jueves ", "Viernes" }));

        btnActualizarCis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarCis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCisActionPerformed(evt);
            }
        });

        btnEliminarCis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCisActionPerformed(evt);
            }
        });

        jLabel74.setText("Observaciones generales:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(18, 18, 18)
                                .addComponent(txtHoraCis, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCloroC, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhC, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDurezaC, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNivelC, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreC))
                            .addComponent(jLabel74)
                            .addComponent(txtObCisterna))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSemanaCis, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115)
                                .addComponent(btnGuardarCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnActualizarCis, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(btnEliminarCis, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 214, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminarCis, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                .addComponent(btnActualizarCis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(cmbSemanaCis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(fechaCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtHoraCis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtCloroC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtPhC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtDurezaC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtNivelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObCisterna, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cisterna", jPanel3);

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel29.setText("No. Extintor:");

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel31.setText("Marca:");

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel32.setText("Agente extintor:");

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel33.setText("Capacidad:");

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel34.setText("Fecha de ultima recarga:");

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel35.setText("Fecha de proxima recarga:");

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel36.setText("Ubicación");

        jLabel37.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel37.setText("El lugar en donde se encuentra es accesible y libre de obstaculos:");

        jLabel40.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel40.setText("Cuenta con letrero de señalización:");

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel41.setText("Las etiquetas se encuentran legibles y sin alteraciones:");

        jLabel42.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel42.setText("Aguja del manómetro esta ubicada en la zona verde:");

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel43.setText("Cuenta con horquilla y cincho de seguridad:");

        jLabel44.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel44.setText("Identificación");

        jLabel45.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel45.setText("Seguridad");

        jLabel46.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel46.setText("EN EL CUERPO DEL EXTINTOR");

        jLabel47.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel47.setText("Corrosion");

        jLabel48.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel48.setText("Escape de presión");

        jLabel49.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel49.setText("EN MANGUERAS Y BOQUILLAS");

        jLabel50.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel50.setText("Roturas");

        jLabel51.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel51.setText("Golpes deformaciones");

        jLabel52.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel52.setText("Exposición al fuego");

        jLabel53.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel53.setText("Desprendimientos");

        jLabel54.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel54.setText("Protuberancias");

        jLabel55.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel55.setText("Perforaciones");

        jLabel56.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel56.setText("Obstrucciones");

        btnGuardarExtintor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarExtintor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarExtintorActionPerformed(evt);
            }
        });

        cmbNoExtintor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Extintor 1 - Caseta de vigilancia", "Extintor 2 - Subestación de caseta", "Extintor 3 - Bodega limpieza(pasillo almacen)", "Extintor 4 - Almacen interior", "Extintor 5 - Subestación (planta emergencia)", "Extintor 6 - Taller de mantenimiento", "Extintor 7 - Taller de mantenimiento", "Extintor 8 - Puerto de sillas", "Extintor 9 - Recepción de tren", "Extintor 10 - Valoración(baños mujeres)", "Extintor 11 - Valoración (cubiculo 716)", "Extintor 12 - Valoracion (cubiculo 728)", "Extintor 13 - Valoración (cubiculo 734)", "Extintor 14 - Pasillo galeria(recepción reloj-capilla)", "Extintor 15 - Capilla", "Extintor 16 - Recepción madre teresa", "Extintor 17 - Gobierno(cubiculo 107)", "Extintor 18 - Site pasillo", "Extintor 19 - Site interior", "Extintor 20 - Gobierno (cubiculo 119)", "Extintor 21 - Sala de juntas", "Extintor 22 - Baños h/m Area azul", "Extintor 23 - Aula 1", "Extintor 24 - Aula 2", "Extintor 25 - Aula  3", "Extintor 26 - Aula 4", "Extintor 27 - Archivo clínico", "Extintor 28 - Pasillo area azul(biblioteca)", "Extintor 29 - Ventanal galerias(juegos)", "Extintor 30 - Recepción de musica", "Extintor 31 - Pasillo mecanoterpia(idf)", "Extintor 32 - Mecanoterapia (lokomat)", "Extintor 33 - Pasillo hidroterapia ", "Extintor 34 - Sala de cumputo", "Extintor 35 - Pasillo area roja(cubiculo 403)", "Extintor 36 - Taller asistencia tecnologica (404)", "Extintor 37 - Pasillo area roja(cubiculo 415)", "Extintor 38 - Cafetería (microondas)", "Extintor 39 - Cocina (preparación de alimentos)", "Extintor 40 - Cuarto de maquinas(cisternas)", "Extintor 41 - Cuarto de maquinas(cisternas)", "Extintor 42 - Bodega anexa 3", "Extintor 43 - Bodega anexa 2", "Extintor 44 - Bodega anexa 1 ", "Extintor 45 - Almacen RPBI", "Extintor 46 - Cuarto de ups y Telmex", "Extintor 47 - Cuarto de oxigeno valoración ", "Extintor 48 - Ambulancia ", "Extintor 49 - Ambulancia ", "Extintor 50 - Microbús DINA", "Extintor 51 - Teletona", "Extintor 52 - Camioneta Nissan", "Extintor 53 - Toyota", "Extintor 54 - Camioneta Hilux", "Extintor 55 - Bodega nueva puerta 1 externo", "Extintor 56 - Bodega nueva interior ", "Extintor 57 - Bodega nueva interior taller ", "Extintor 58 - Bodega nueva puerta 2 externo", "Extintor 59 - Zona de marcha puerta 1", "Extintor 60 - Zona de marcha puerta 2", " " }));

        btnEliminarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEActionPerformed(evt);
            }
        });

        btnActualizarE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEActionPerformed(evt);
            }
        });

        cmbMarcaEx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vymecfuego" }));

        cmbAgenteE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PQS", "AL", "CO2", "Desconocido" }));

        cmbCapE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4.5", "4.59", "6" }));

        cmbAccesibleExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbSenalE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbEtiquetaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbManoE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbSeguridadE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbCorrosionExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbPresionExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbGolpeExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbExpoExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbRoturaExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbDesprenExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbProtuExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbPerfoExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        cmbObstruccionExt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        jLabel38.setText("Fecha:");

        jLabel91.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel91.setText("Observaciones generales:");

        jLabel92.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel92.setText("Elaborado por:");

        tableExtintores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "materialext", "fecha", "marca", "agentExtintor", "capacidad", "fechaUltimaRecarga", "fechaProxRecarga", "lugarAccesible", "letrero", "etiquetasLegibles", "horquilla", "corrocion", "escapePresion", "deformacion", "exposicion", "roturas", "desprendimiento", "protuberacion", "perforacion", "obstruccion", "manometro", "observacion", "elaborado", "id"
            }
        ));
        tableExtintores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExtintoresMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tableExtintores);

        cmbGolpesDefor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbNoExtintor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbMarcaEx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fechaUltExt))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel35)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaProExt))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbAgenteE, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbCapE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaExt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel46))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCorrosionExt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbGolpesDefor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbPresionExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52)
                            .addComponent(cmbExpoExt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAccesibleExt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbSenalE, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbSeguridadE, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel91)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObExt, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel41)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbEtiquetaE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel42)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbManoE, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbDesprenExt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbObstruccionExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel50)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbRoturaExt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbPerfoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnGuardarExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnActualizarE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProtuExt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnEliminarE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel92)
                                    .addComponent(txtElaboradoExt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbGolpeExt, 0, 1, Short.MAX_VALUE)
                .addGap(927, 927, 927))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(cmbAccesibleExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(cmbSenalE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(cmbEtiquetaE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(cmbManoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(cmbSeguridadE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(txtObExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29)
                                    .addComponent(cmbNoExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(fechaExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(cmbMarcaEx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(cmbAgenteE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(cmbCapE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(fechaUltExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(fechaProExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(jLabel50)
                            .addComponent(cmbRoturaExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)
                            .addComponent(cmbPerfoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(cmbCorrosionExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(cmbDesprenExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56)
                            .addComponent(cmbObstruccionExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbPresionExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(cmbExpoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54)
                            .addComponent(cmbProtuExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarE, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarExtintor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel51)
                                    .addComponent(cmbGolpeExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbGolpesDefor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel92)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtElaboradoExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(btnEliminarE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Extintores", jPanel4);

        jLabel67.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel67.setText("Tipo de gas:");

        jLabel68.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel68.setText("Fecha:");

        jLabel69.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel69.setText("Presión de tanque/Presión en línea:");

        jLabel70.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel70.setText("Reserva (Cantidad de tanques):");

        jLabel71.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel71.setText("Se realizó limpieza:");

        jLabel72.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel72.setText("Nombre de quien realizó el inventario:");

        tipoGasH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oxigeno ", "Aire" }));

        tableGasM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "tipoGas", "presionTanque", "reserva", "limpieza", "name", "observacion", "id"
            }
        ));
        tableGasM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGasMMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableGasM);

        btnGuardarGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGasActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel30.setText("Observaciones generales:");

        btnActualizarGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarGasActionPerformed(evt);
            }
        });

        btnEliminarGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarGasActionPerformed(evt);
            }
        });

        cmbLimpiezaG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No ", "Ningún cambio" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(18, 18, 18)
                        .addComponent(tipoGasH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtReservaT))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel71)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLimpiezaG, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel72)
                    .addComponent(txtNameInv)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPresionT))
                    .addComponent(jLabel30)
                    .addComponent(txtObGenGa)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaGasesH, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnGuardarGas, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnActualizarGas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnEliminarGas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68)
                            .addComponent(fechaGasesH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(tipoGasH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarGas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarGas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarGas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(txtPresionT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(txtReservaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(cmbLimpiezaG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel72)
                        .addGap(18, 18, 18)
                        .addComponent(txtNameInv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(txtObGenGa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gases", jPanel5);

        jLabel57.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel57.setText("Tipo de gas:");

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel58.setText("Día:");

        jLabel59.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel59.setText("Presion de tanque/Presion en linea");

        jLabel60.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel60.setText("Reserva (Cantidad de tanques):");

        cmbTipoGasV.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cmbTipoGasV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Oxigeno", "Aire" }));

        tableGasValoracion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "tipoGas", "dia", "presionTanque", "reserva", "limpieza", "name", "observacion", "id"
            }
        ));
        tableGasValoracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableGasValoracionMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableGasValoracion);

        btnGuardarGasV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarGasV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGasVActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel65.setText("Nombre de quien realizó el inventario:");

        cmbFechaGasV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes ", "Martes ", "Miercoles ", "Jueves ", "Viernes" }));

        jLabel182.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel182.setText("Observaciones generales:");

        btnActualizarGasV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarGasV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarGasVActionPerformed(evt);
            }
        });

        btnEliminarGasV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarGasV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarGasVActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel39.setText("Fecha:");

        jLabel66.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel66.setText("Realización de limpieza:");

        cmbLimpiezaGasV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addGap(18, 18, 18)
                        .addComponent(cmbFechaGasV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addGap(28, 28, 28)
                        .addComponent(cmbTipoGasV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPresionTanV, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel65)
                    .addComponent(txtNameRealizoGV, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel182)
                    .addComponent(txtObserGenGaV, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaGaValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel66)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbLimpiezaGasV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel60)
                        .addGap(4, 4, 4)
                        .addComponent(txtReservaGasV, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnGuardarGasV, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnActualizarGasV, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(btnEliminarGasV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39)
                            .addComponent(fechaGaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(cmbTipoGasV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnEliminarGasV, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addComponent(btnActualizarGasV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnGuardarGasV, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(cmbFechaGasV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(txtPresionTanV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(txtReservaGasV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(cmbLimpiezaGasV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel65)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNameRealizoGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel182)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObserGenGaV, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gases valoración", jPanel6);

        jLabel75.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel75.setText("No. Hidrante con su ubicacion:");

        jLabel77.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel77.setText("Manguera (Longitud metros):");

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel78.setText("Fecha de prueba hidrostatica manguera:");

        jLabel79.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel79.setText("Próxima Fecha de prueba hidrostatica manguera:");

        jLabel80.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel80.setText("Estado del material");

        jLabel81.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel81.setText("Gabinete");

        jLabel82.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel82.setText("Puerta");

        jLabel83.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel83.setText("Cristal");

        jLabel84.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel84.setText("Pintura");

        jLabel85.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel85.setText("Interior");

        jLabel86.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel86.setText("Válvula");

        jLabel87.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel87.setText("Chiflón");

        jLabel88.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel88.setText("Manguera");

        jLabel89.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel89.setText("Existe llave pata de gallo");

        jLabel90.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel90.setText("Señaletica");

        btnGuardarH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarHActionPerformed(evt);
            }
        });

        tableHidrante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "noHidrante", "fechaH", "manguera", "fechaPrueba", "fechaProx", "puerta", "cristal", "pintura", "valvula", "chiflon", "edoManguera", "llave", "señaletica", "elaborado", "observacion", "id"
            }
        ));
        tableHidrante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHidranteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableHidrante);

        cmbMatH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Valoración Baños mujeres", "2 - Valoración botica", "3 - Gobierno (cubiculo 101)", "4 - Area azul(baños)", "5 - Pasillo mecano(idf)", "6 - Pasillo rojo(cubiculo 406)", "7 - Pasillo galeria( baños de musica)", "8 - Almacen (pasillo externo)" }));

        btnActualizarH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarHActionPerformed(evt);
            }
        });

        btnEliminarH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel76.setText("Fecha:");

        jLabel183.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel183.setText("Observaciones generales:");

        cmbManH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "30 m" }));

        cmbPuertaH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbCristalH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbPinturaH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbValvulaH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbChiflonH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbMangueraH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbLlaveH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        cmbSenalH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excelente ", "Regular", "Malo" }));

        jLabel61.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel61.setText("Nombre de quien elaboró:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaHidrante, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel183)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtObG, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel79)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fechaProxH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel78)
                                    .addGap(18, 18, 18)
                                    .addComponent(fechaPruebaH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel75)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbMatH, 0, 1, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel77)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbManH, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel81)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel84)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbPinturaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel82)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbPuertaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel83)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbCristalH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel86)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbValvulaH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel87)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbChiflonH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel88)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbMangueraH, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 50, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarH, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnEliminarH, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnActualizarH, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addComponent(jLabel80))
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel90)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbSenalH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addComponent(jLabel89)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cmbLlaveH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel61)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtElaboroH, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(78, 78, 78))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel80))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaHidrante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel76))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(cmbMatH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(cmbManH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaPruebaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel79)
                            .addComponent(fechaProxH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel183)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtObG, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addGap(2, 2, 2)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel82)
                                    .addComponent(cmbPuertaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel83)
                                    .addComponent(cmbCristalH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel84)
                                    .addComponent(cmbPinturaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel85)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel86))
                                    .addComponent(cmbValvulaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel87)
                                    .addComponent(cmbChiflonH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel88)
                                    .addComponent(cmbMangueraH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnGuardarH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnActualizarH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel89)
                                    .addComponent(cmbLlaveH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel90)
                                    .addComponent(cmbSenalH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel61)
                                    .addComponent(txtElaboroH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnEliminarH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hidrante", jPanel7);

        jLabel94.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel94.setText("Personal responsable:");

        jLabel96.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel96.setText("Fecha:");

        jLabel97.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel97.setText("Hora:");

        jLabel98.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel98.setText("Tipo de materia orgánica:");

        jLabel99.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel99.setText("Bromaminas:");

        jLabel100.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel100.setText("Tiempo de cancelación:");

        jLabel101.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel101.setText("Químico aplicado:");

        jLabel102.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel102.setText("Inicio de actividades: ");

        jLabel103.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel103.setText("Equipo de filtración:");

        jLabel104.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel104.setText("Observación:");

        tableInc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "persona", "fecha", "hora", "tipoMateriaOrganica", "bromaminas", "tiempoCancelacion", "quimicoAplicado", "inicioActividad", "equipoFiltrcion", "observacion", "id"
            }
        ));
        tableInc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIncMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableInc);

        btnGuardarInc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarIncActionPerformed(evt);
            }
        });

        btnActualizarInc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarIncActionPerformed(evt);
            }
        });

        btnEliminarInc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarInc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIncActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObservacionInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFiltracionInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtActividadInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuimicoInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel100)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCancelacionInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBromaminasInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMateriaInc))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaIncidente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel94)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPersonalIn, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel97)
                        .addGap(18, 18, 18)
                        .addComponent(txtHoraIn)))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(btnGuardarInc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnActualizarInc, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnEliminarInc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(txtPersonalIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel96)
                            .addComponent(fechaIncidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(txtHoraIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(txtMateriaInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(txtBromaminasInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(txtCancelacionInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel101)
                            .addComponent(txtQuimicoInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel102)
                            .addComponent(txtActividadInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel103)
                            .addComponent(txtFiltracionInc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel104)
                            .addComponent(txtObservacionInc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminarInc, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(btnActualizarInc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardarInc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Incidentes", jPanel8);

        jLabel107.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel107.setText("Fecha:");

        jLabel108.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel108.setText("Equipo:");

        jLabel109.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel109.setText("Área / Oficina:");

        jLabel110.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel110.setText("Solicitó:");

        jLabel111.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel111.setText("Equipo:");

        jLabel112.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel112.setText("Marca:");

        jLabel113.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel113.setText("Modelo:");

        jLabel114.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel114.setText("Serie:");

        jLabel115.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel115.setText("Tipo de mantenimiento:");

        jLabel116.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel116.setText("Descripción del servicio:");

        jLabel117.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel117.setText("Observaciones:");

        btnGuardarSerInt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarSerInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSerIntActionPerformed(evt);
            }
        });

        btnActualizarSerInt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarSerInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSerIntActionPerformed(evt);
            }
        });

        btnEliminarSerInt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarSerInt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSerIntActionPerformed(evt);
            }
        });

        tableSerInt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "equipo", "areaAtencion", "nombreSolicitante", "equipoo", "marca", "modelo", "serie", "tipoMantenimiento", "descripcionServicio", "observacion", "id"
            }
        ));
        tableSerInt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSerIntMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tableSerInt);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTipoSerInt)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel113)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtModeloSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel107)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fechaServInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel108)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEquipoSerInt))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel114)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSerieSerInt))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel112)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMarcaServInt))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel111)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEquipoServicio))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel110)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSoliSerInt))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel109)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSAreaerInt)))
                    .addComponent(jLabel115))
                .addGap(38, 38, 38)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel116)
                            .addComponent(jLabel117)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtObserSerInt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                                    .addComponent(txtDescSerInt, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarSerInt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActualizarSerInt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel116)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminarSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuardarSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel117)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObserSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaServInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel107))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(txtEquipoSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSAreaerInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110)
                            .addComponent(txtSoliSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel111)
                            .addComponent(txtEquipoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(txtMarcaServInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113)
                            .addComponent(txtModeloSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(txtSerieSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel115)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoSerInt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Serv. Int", jPanel10);

        jLabel118.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel118.setText("Bitacora prueba de motores de sistemas contraincendio");

        jLabel119.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel119.setText("Fecha:");

        jLabel124.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel124.setText("Prueba de arranque de motor");

        btnGuardarContra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContraActionPerformed(evt);
            }
        });

        jLabel129.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel129.setText("Observaciones:");

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel62.setText("Material:");

        cmbMatC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bomba Jockey", "Bomba eléctrico", "Bomba combustión " }));
        cmbMatC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMatCActionPerformed(evt);
            }
        });

        cmbPrueba.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        tableSisCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "material", "pruebaS", "obs", "name", "id"
            }
        ));
        tableSisCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSisConMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tableSisCon);

        jLabel106.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel106.setText("Elaborado por:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel118))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                    .addComponent(jLabel62)
                                    .addGap(18, 18, 18)
                                    .addComponent(cmbMatC, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel129)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel124)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPrueba, 0, 1, Short.MAX_VALUE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel119)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fechaSis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtObs)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(btnGuardarContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(43, 43, 43)
                                        .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))))
                            .addComponent(jLabel106)
                            .addComponent(txtElaboradoSis))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel118)
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaSis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel119))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(cmbMatC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel124, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel129)
                        .addGap(15, 15, 15)
                        .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtElaboradoSis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnGuardarContra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contraincendio", jPanel11);

        jLabel130.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel130.setText("Fecha:");

        jLabel131.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel131.setText("Hora de entrada:");

        jLabel132.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel132.setText("Hora de salida:");

        jLabel133.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel133.setText("Equipo de seguridad (cumple):");

        jLabel137.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel137.setText("Firma del encargado:");

        jLabel138.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel138.setText("Firma del chofer:");

        txtHoraEntradaSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraEntradaSumActionPerformed(evt);
            }
        });

        cmbSeguridadSum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SI", "NO" }));

        jLabel139.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel139.setText("Litro:");

        jLabel140.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel140.setText("Costo:");

        jLabel147.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel147.setText("Subtotal");

        btnGuardarSuministroGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarSuministroGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarSuministroGasActionPerformed(evt);
            }
        });

        btnActualizarSum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSumActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel73.setText("Material y ubicación:");

        cmbMatSum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Cafetería", "2 - Calderas cisternas ", "3 - Hidroterapia" }));

        btnEliminarSum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSumActionPerformed(evt);
            }
        });

        tableLp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "noMat", "litro", "costo", "subtotal", "entrada", "salida", "seg", "encargado", "chofer", "observacion", "id"
            }
        ));
        tableLp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLpMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tableLp);

        jLabel120.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel120.setText("Observaciones generales:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel139)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLitroSum))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel73)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbMatSum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel130)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFechaSum, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel140)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCostoSum, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(jLabel147)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSubtotalSum)))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel131)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraEntradaSum, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel133)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSeguridadSum, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel132)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoraSalidaSum, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel137)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirmaEncargadoSum, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel138)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirmaChoferSum, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel120)
                            .addComponent(txtObLp, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(btnGuardarSuministroGas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnActualizarSum, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnEliminarSum, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel130)
                            .addComponent(jFechaSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(cmbMatSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnGuardarSuministroGas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarSum, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarSum, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel139)
                            .addComponent(txtLitroSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel140)
                            .addComponent(txtCostoSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel147)
                            .addComponent(txtSubtotalSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(txtHoraEntradaSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel132)
                            .addComponent(txtHoraSalidaSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel133)
                            .addComponent(cmbSeguridadSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel137)
                            .addComponent(txtFirmaEncargadoSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel138)
                            .addComponent(txtFirmaChoferSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel120)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtObLp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Suministro de gas", jPanel12);

        jLabel149.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel149.setText("Dia:");

        jLabel150.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel150.setText("Hora:");

        jLabel151.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel151.setText("Fecha:");

        cmbDiaT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes ", "Martes", "Miercoles", "Jueves ", "Viernes" }));

        cmbHoraT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07:00", "11:00", "15:00" }));

        jLabel152.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel152.setText("Elaboró:");

        jLabel153.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(204, 0, 204));
        jLabel153.setText("Pruebas químicas");

        jLabel154.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel154.setText("Bromo (pmm):");

        jLabel155.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel155.setText("PH (pmm):");

        jLabel156.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel156.setText("Alcalinidad(pmm):");

        jLabel157.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel157.setText("Dureza (pmm):");

        jLabel158.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel158.setText("Temperatura (°C):");

        jLabel159.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(204, 0, 204));
        jLabel159.setText("Químico aplicado");

        jLabel160.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel160.setText("Cloro bromado (Kg)");

        jLabel161.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel161.setText("Shock preventivo (Kg)");

        jLabel162.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel162.setText("Acido (Kg)");

        jLabel163.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel163.setText("Clarificador (Lts)");

        jLabel164.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(204, 0, 204));
        jLabel164.setText("Limpieza general");

        jLabel165.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel165.setText("Aspirado");

        jLabel166.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel166.setText("Cepillado");

        jLabel167.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel167.setText("Contornado y desnatadores");

        jLabel168.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel168.setText("Motobomba en operacion 1");

        jLabel169.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel169.setText("Motobomba en operacion 2");

        jLabel174.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(204, 0, 204));
        jLabel174.setText("Servicio de filtrado de tanque");

        jLabel176.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel176.setText("Presión de filtrado:");

        jLabel180.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel180.setText("Retrolavado");

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jLabel181.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel181.setText("Observaciones:");

        cmbCloroT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbShockT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbAcidoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbClaT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jLabel63.setText("No. Filtro:");

        cmbFiltroT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtro 1", "Filtro 2" }));

        cmbRetroT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbAspiradoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbCepilladoT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbConT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbMoto1T.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        cmbMoto2T.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si", "No", "Ningún cambio" }));

        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        tableTera.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fechaT", "name", "semana", "hora", "bromo", "ph", "alca", "dureza", "temp", "cloro", "shock", "acido", "clarifi", "aspirado", "cepillado", "contornado", "moto1", "moto2", "filtro", "presion", "retrolavado", "obs", "id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTeraMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tableTera);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel155, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel154)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtBromoT, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(1, 1, 1)))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel152)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtElaboroT))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel151)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fechaT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel149)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel150)
                                    .addGap(4, 4, 4)))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbHoraT, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbDiaT, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel153, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPhT, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel156)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAlcaT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel159)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel157)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDurezaT))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel158)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTempT))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel160)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCloroT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel161)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbShockT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel162)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbAcidoT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel163)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClaT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel164)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel168)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbMoto1T, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel169)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cmbMoto2T, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel166)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbCepilladoT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel165)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbAspiradoT, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel167)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbConT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel174))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbFiltroT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel176)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPresionTera))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel180)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRetroT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel181)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObsT, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton55))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton56)
                                .addGap(35, 35, 35))))
                    .addComponent(jScrollPane11))
                .addGap(23, 23, 23))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel164)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel165)
                                    .addComponent(cmbAspiradoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel166)
                                    .addComponent(cmbCepilladoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbConT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel167))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel168)
                                    .addComponent(cmbMoto1T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel169)
                                    .addComponent(cmbMoto2T, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel151)
                                    .addComponent(fechaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel152)
                                    .addComponent(txtElaboroT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel149)
                                    .addComponent(cmbDiaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel150)
                                    .addComponent(cmbHoraT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel153)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel154)
                                    .addComponent(txtBromoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPhT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel155))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAlcaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel156))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel157)
                                    .addComponent(txtDurezaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel158)
                                    .addComponent(txtTempT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jLabel159)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel160)
                                    .addComponent(cmbCloroT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel161)
                                    .addComponent(cmbShockT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel162)
                                    .addComponent(cmbAcidoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel163)
                                    .addComponent(cmbClaT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel174)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel63)
                                    .addComponent(cmbFiltroT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel176)
                                    .addComponent(txtPresionTera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton20)
                                    .addComponent(jButton55))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jButton56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel180)
                                    .addComponent(cmbRetroT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel181)
                                    .addComponent(txtObsT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Terapeútico", jPanel13);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 1040, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarIncidente();
        jTabbedPane1.setSelectedIndex(7);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarCaldera();
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarCisterna();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarExtintor();
        
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarGasMed();
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarMedValo();
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarHidrante();
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarOrdenSI();
        jTabbedPane1.setSelectedIndex(8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
            LimpiarTabla();
            ListarContraincendio();
            jTabbedPane1.setSelectedIndex(9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarLp();
        jTabbedPane1.setSelectedIndex(10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarTanTera();
                jTabbedPane1.setSelectedIndex(11);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        Login ventana2  = new Login();
        ventana2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        ListarTanque();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void tableTeraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTeraMouseClicked
        // TODO add your handling code here:
        int fila = tableTera.rowAtPoint(evt.getPoint());

        String separador = Pattern.quote("-");
        String[] fechasParts = tableTera.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaT.setDate(getDateFormat("dd/MM/yyyy", fecha));

        txtElaboroT.setText(tableTera.getValueAt(fila, 1).toString());
        cmbDiaT.setSelectedItem(tableTera.getValueAt(fila, 2).toString());
        cmbHoraT.setSelectedItem(tableTera.getValueAt(fila, 3).toString());
        txtBromoT.setText(tableTera.getValueAt(fila, 4).toString());
        txtPhT.setText(tableTera.getValueAt(fila, 5).toString());
        txtAlcaT.setText(tableTera.getValueAt(fila, 6).toString());
        txtDurezaT.setText(tableTera.getValueAt(fila, 7).toString());
        txtTempT.setText(tableTera.getValueAt(fila, 8).toString());
        cmbCloroT.setSelectedItem(tableTera.getValueAt(fila, 9).toString());
        cmbShockT.setSelectedItem(tableTera.getValueAt(fila, 10).toString());
        cmbAcidoT.setSelectedItem(tableTera.getValueAt(fila, 11).toString());
        cmbClaT.setSelectedItem(tableTera.getValueAt(fila, 12).toString());
        cmbAspiradoT.setSelectedItem(tableTera.getValueAt(fila, 13).toString());
        cmbCepilladoT.setSelectedItem(tableTera.getValueAt(fila, 14).toString());
        cmbConT.setSelectedItem(tableTera.getValueAt(fila, 15).toString());
        cmbMoto1T.setSelectedItem(tableTera.getValueAt(fila, 16).toString());
        cmbMoto2T.setSelectedItem(tableTera.getValueAt(fila, 17).toString());
        cmbFiltroT.setSelectedItem(tableTera.getValueAt(fila, 18).toString());
        txtPresionTera.setText(tableTera.getValueAt(fila, 19).toString());
        cmbRetroT.setSelectedItem(tableTera.getValueAt(fila, 20).toString());
        txtObsT.setText(tableTera.getValueAt(fila, 21).toString());

        this.setId(tableTera.getValueAt(fila, 22).toString());
    }//GEN-LAST:event_tableTeraMouseClicked

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(tanDao.eliminarTe(rv));
                LimpiarTabla();
                ListarTanTera();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaT.getDate());
        String nombreLectura = txtElaboroT.getText();
        String diaSemana = cmbDiaT.getSelectedItem().toString();
        String hora = cmbHoraT.getSelectedItem().toString();
        String bromo = txtBromoT.getText();
        String ph = txtPhT.getText();
        String alcalinidad = txtAlcaT.getText();
        String dureza = txtDurezaT.getText();
        String temperatura = txtTempT.getText();
        String cloroBromado = cmbCloroT.getSelectedItem().toString();
        String shockPreventivo = cmbShockT.getSelectedItem().toString();
        String acido = cmbAcidoT.getSelectedItem().toString();
        String clarificador = cmbClaT.getSelectedItem().toString();
        String aspirado = cmbAspiradoT.getSelectedItem().toString();
        String cepillado = cmbCepilladoT.getSelectedItem().toString();
        String contornado = cmbConT.getSelectedItem().toString();
        String motobomba1 = cmbMoto1T.getSelectedItem().toString();
        String motobomba2 = cmbMoto2T.getSelectedItem().toString();
        String filtro1 = cmbFiltroT.getSelectedItem().toString();
        String presion1 = txtPresionTera.getText();
        String retrolavado1 = cmbRetroT.getSelectedItem().toString();
        String observacion = txtObsT.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboroT.getText())) {
                System.out.println(fecha);
                tanDao.modificarTera(fecha, nombreLectura, diaSemana, hora, bromo, ph, alcalinidad, dureza, temperatura, cloroBromado, shockPreventivo, acido, clarificador, aspirado, cepillado, contornado, motobomba1, motobomba2, filtro1, presion1, retrolavado1, observacion, this.getId());
                ListarTanTera();
                limpiarTerapeutico();
                LimpiarTabla();
            }
        }

    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // CODIGO DE GUARDADO DE TANQUE TERAPEUTICO
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaT.getDate());
        String nombreLectura = txtElaboroT.getText();
        String diaSemana = cmbDiaT.getSelectedItem().toString();
        String hora = cmbHoraT.getSelectedItem().toString();
        String bromo = txtBromoT.getText();
        String ph = txtPhT.getText();
        String alcalinidad = txtAlcaT.getText();
        String dureza = txtDurezaT.getText();
        String temperatura = txtTempT.getText();
        String cloroBromado = cmbCloroT.getSelectedItem().toString();
        String shockPreventivo = cmbShockT.getSelectedItem().toString();
        String acido = cmbAcidoT.getSelectedItem().toString();
        String clarificador = cmbClaT.getSelectedItem().toString();
        String aspirado = cmbAspiradoT.getSelectedItem().toString();
        String cepillado = cmbCepilladoT.getSelectedItem().toString();
        String contornado = cmbConT.getSelectedItem().toString();
        String motobomba1 = cmbMoto1T.getSelectedItem().toString();
        String motobomba2 = cmbMoto2T.getSelectedItem().toString();
        String filtro1 = cmbFiltroT.getSelectedItem().toString();
        String presion1 = txtPresionTera.getText();
        String retrolavado1 = cmbRetroT.getSelectedItem().toString();
        String observacion = txtObsT.getText();

        if(nombreLectura.isEmpty() || bromo.isEmpty() || ph.isEmpty()|| alcalinidad.isEmpty()|| dureza.isEmpty()|| temperatura.isEmpty()|| presion1.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO tanqueterapeutico (fechaT, name, semana, hora, bromo, ph, alca, dureza, temp, cloro, shock, acido, clarifi, aspirado, cepillado, contornado, moto1, moto2, filtro, presion, retrolavado, obs) VALUES ('"+fecha+"','"+nombreLectura+"','"+diaSemana+"','"+hora+"','"+bromo+"','"+ph+"','"+alcalinidad+"','"+dureza+"','"+temperatura+"','"+cloroBromado+"','"+shockPreventivo+"','"+acido+"','"+clarificador+"','"+aspirado+"','"+cepillado+"','"+contornado+"','"+motobomba1+"','"+motobomba2+"','"+filtro1+"','"+presion1+"','"+retrolavado1+"','"+observacion+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarTerapeutico();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void tableLpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLpMouseClicked
        // TODO add your handling code here:
        int fila = tableLp.rowAtPoint(evt.getPoint());

        String separador = Pattern.quote("-");
        String[] fechasParts = tableLp.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        jFechaSum.setDate(getDateFormat("dd/MM/yyyy", fecha));

        cmbMatSum.setSelectedItem(tableLp.getValueAt(fila, 1).toString());
        txtLitroSum.setText(tableLp.getValueAt(fila, 2).toString());
        txtCostoSum.setText(tableLp.getValueAt(fila, 3).toString());
        txtSubtotalSum.setText(tableLp.getValueAt(fila, 4).toString());
        txtHoraEntradaSum.setText(tableLp.getValueAt(fila, 5).toString());
        txtHoraSalidaSum.setText(tableLp.getValueAt(fila, 6).toString());
        cmbSeguridadSum.setSelectedItem(tableLp.getValueAt(fila, 7).toString());
        txtFirmaEncargadoSum.setText(tableLp.getValueAt(fila, 8).toString());
        txtFirmaChoferSum.setText(tableLp.getValueAt(fila, 9).toString());
        txtObLp.setText(tableLp.getValueAt(fila, 10).toString());

        this.setId(tableLp.getValueAt(fila, 11).toString());
    }//GEN-LAST:event_tableLpMouseClicked

    private void btnEliminarSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSumActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(sumLpDao.eliminarLp(rv));
                LimpiarTabla();
                ListarLp();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarSumActionPerformed

    private void btnActualizarSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSumActionPerformed
        // TODO add your handling code here:
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(jFechaSum.getDate());
        String materiaLp = cmbMatSum.getSelectedItem().toString();
        String litro = txtLitroSum.getText();
        String costo = txtCostoSum.getText();
        String subtotal = txtSubtotalSum.getText();
        String horaEntrada = txtHoraEntradaSum.getText();
        String horaSalida = txtHoraSalidaSum.getText();
        String seguridad = cmbSeguridadSum.getSelectedItem().toString();
        String encargado = txtFirmaEncargadoSum.getText();
        String chofer = txtFirmaChoferSum.getText();
        String observacionesG = txtObLp.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtFirmaEncargadoSum.getText())) {
                System.out.println(fecha);
                sumLpDao.modificarLp(fecha, materiaLp, litro, costo, subtotal, horaEntrada, horaSalida, seguridad, encargado, chofer, observacionesG, this.getId());
                ListarLp();
                limpiarLp();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarSumActionPerformed

    private void btnGuardarSuministroGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSuministroGasActionPerformed
        // CODIGO DE GUARADADO DE SUMINISTRO DE GAS LP
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(jFechaSum.getDate());
        String materialLp = cmbMatSum.getSelectedItem().toString();
        String litro = txtLitroSum.getText();
        String costo = txtCostoSum.getText();
        String subtotal = txtSubtotalSum.getText();
        String horaEntrada = txtHoraEntradaSum.getText();
        String horaSalida = txtHoraSalidaSum.getText();
        String seguridad = cmbSeguridadSum.getSelectedItem().toString();
        String encargado = txtFirmaEncargadoSum.getText();
        String chofer = txtFirmaChoferSum.getText();
        String observacionesG = txtObLp.getText();

        if(litro.isEmpty()||costo.isEmpty()||subtotal.isEmpty()||horaEntrada.isEmpty()||horaSalida.isEmpty()||encargado.isEmpty()||chofer.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO suministrogaslp(fecha, noMat, litro, costo, subtotal, entrada, salida, seg, encargado, chofer, observacion) VALUES ('"+fecha+"','"+materialLp+"','"+litro+"','"+costo+"','"+subtotal+"','"+horaEntrada+"','"+horaSalida+"','"+seguridad+"','"+encargado+"','"+chofer+"','"+observacionesG+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarLp();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarSuministroGasActionPerformed

    private void txtHoraEntradaSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraEntradaSumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraEntradaSumActionPerformed

    private void tableSisConMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSisConMouseClicked
        // TODO add your handling code here:
        int fila = tableSisCon.rowAtPoint(evt.getPoint());

        String separador = Pattern.quote("-");
        String[] fechasParts = tableSisCon.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaSis.setDate(getDateFormat("dd/MM/yyyy", fecha));

        cmbMatC.setSelectedItem(tableSisCon.getValueAt(fila, 1).toString());
        cmbPrueba.setSelectedItem(tableSisCon.getValueAt(fila, 2).toString());
        txtObs.setText(tableSisCon.getValueAt(fila, 3).toString());
        txtElaboradoSis.setText(tableSisCon.getValueAt(fila, 4).toString());

        this.setId(tableSisCon.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_tableSisConMouseClicked

    private void cmbMatCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMatCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMatCActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(sisConDao.eliminarContra(rv));
                LimpiarTabla();
                ListarContraincendio();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaSis.getDate());
        String material = cmbMatC.getSelectedItem().toString();
        String prueba = cmbPrueba.getSelectedItem().toString();
        String observacion = txtObs.getText();
        String elaborado = txtElaboradoSis.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoSis.getText())) {
                System.out.println(fecha);
                sisConDao.modificarContra(fecha, material, prueba, observacion, elaborado, this.getId());
                ListarContraincendio();
                limpiarContraIncendio();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void btnGuardarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContraActionPerformed
        // CODIGO DE GUARDADO DE SISTEMA CONTRAINCENDIO
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaSis.getDate());
        String material = cmbMatC.getSelectedItem().toString();
        String prueba = cmbPrueba.getSelectedItem().toString();
        String observacion = txtObs.getText();
        String elaborado = txtElaboradoSis.getText();

        if(elaborado.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO siscontraincendio (fecha, material, pruebaS, obs, name) VALUES ('"+fecha+"','"+material+"','"+prueba+"','"+observacion+"','"+elaborado+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarContraIncendio();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarContraActionPerformed

    private void tableSerIntMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSerIntMouseClicked
        // TODO add your handling code here:
        int fila = tableSerInt.rowAtPoint(evt.getPoint());

        String separador = Pattern.quote("-");
        String[] fechasParts = tableSerInt.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaServInt.setDate(getDateFormat("dd/MM/yyyy", fecha));

        txtEquipoSerInt.setText(tableSerInt.getValueAt(fila, 1).toString());
        txtSAreaerInt.setText(tableSerInt.getValueAt(fila, 2).toString());
        txtSoliSerInt.setText(tableSerInt.getValueAt(fila, 3).toString());
        txtEquipoServicio.setText(tableSerInt.getValueAt(fila, 4).toString());
        txtMarcaServInt.setText(tableSerInt.getValueAt(fila, 5).toString());
        txtModeloSerInt.setText(tableSerInt.getValueAt(fila, 6).toString());
        txtSerieSerInt.setText(tableSerInt.getValueAt(fila, 7).toString());
        txtTipoSerInt.setText(tableSerInt.getValueAt(fila, 8).toString());
        txtDescSerInt.setText(tableSerInt.getValueAt(fila, 9).toString());
        txtObserSerInt.setText(tableSerInt.getValueAt(fila, 10).toString());

        this.setId(tableSerInt.getValueAt(fila, 11).toString());
    }//GEN-LAST:event_tableSerIntMouseClicked

    private void btnEliminarSerIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSerIntActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(ordDao.eliminarOrden(rv));
                LimpiarTabla();
                ListarOrdenSI();
            }
        }else{
            System.out.println(id);
        }

    }//GEN-LAST:event_btnEliminarSerIntActionPerformed

    private void btnActualizarSerIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSerIntActionPerformed
        // TODO add your handling code here:
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaServInt.getDate());
        String equipo = txtEquipoSerInt.getText();
        String oficina = txtSAreaerInt.getText();
        String nameSolicito = txtSoliSerInt.getText();
        String equipo2 = txtEquipoServicio.getText();
        String marca = txtMarcaServInt.getText();
        String modelo = txtModeloSerInt.getText();
        String serie = txtSerieSerInt.getText();
        String tipoMantenimiento = txtTipoSerInt.getText();
        String desMantenimiento = txtDescSerInt.getText();
        String observacion = txtObserSerInt.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtSoliSerInt.getText())) {
                System.out.println(fecha);
                ordDao.modificarOrden(fecha, equipo, oficina, nameSolicito, equipo2, marca, modelo, serie, tipoMantenimiento, desMantenimiento, observacion, this.getId());
                ListarOrdenSI();
                limpiarOrden();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarSerIntActionPerformed

    private void btnGuardarSerIntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarSerIntActionPerformed
        //CODIGO DE GUARDADO DE SERVICIO INTERNO
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaServInt.getDate());
        String equipo = txtEquipoSerInt.getText();
        String oficina = txtSAreaerInt.getText();
        String nameSolicito = txtSoliSerInt.getText();
        String equipo2 = txtEquipoServicio.getText();
        String marca = txtMarcaServInt.getText();
        String modelo = txtModeloSerInt.getText();
        String serie = txtSerieSerInt.getText();
        String tipoMantenimiento = txtTipoSerInt.getText();
        String desMantenimiento = txtDescSerInt.getText();
        String observacion = txtObserSerInt.getText();

        if(equipo.isEmpty()|| oficina.isEmpty()||nameSolicito.isEmpty()||equipo2.isEmpty()|| marca.isEmpty()||modelo.isEmpty()||serie.isEmpty()||tipoMantenimiento.isEmpty()||desMantenimiento.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO ordenservicio (fecha, equipo, areaAtencion, nombreSolicitante, equipoo, marca, modelo, serie, tipoMantenimiento, descripcionServicio, observacion) VALUES ('"+fecha+"','"+equipo+"','"+oficina+"','"+nameSolicito+"','"+equipo2+"','"+marca+"','"+modelo+"','"+serie+"','"+tipoMantenimiento+"','"+desMantenimiento+"','"+observacion+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarOrden();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarSerIntActionPerformed

    private void btnEliminarIncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIncActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(incDao.eliminarInc(rv));
                LimpiarTabla();
                ListarIncidente();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarIncActionPerformed

    private void btnActualizarIncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarIncActionPerformed
        // TODO add your handling code here:
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaIncidente.getDate());
        String personaResponsable = txtPersonalIn.getText();
        String hora = txtHoraIn.getText();
        String tipoMateriaOrganica = txtMateriaInc.getText();
        String bromaminas = txtBromaminasInc.getText();
        String tiempoCancelacion = txtCancelacionInc.getText();
        String quimicoAplicado = txtQuimicoInc.getText();
        String inicioActividades = txtActividadInc.getText();
        String equipoFiltracion = txtFiltracionInc.getText();
        String observacion = txtObservacionInc.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboroH.getText())) {
                System.out.println(fecha);
                incDao.modificarIncid(personaResponsable, fecha, hora, tipoMateriaOrganica, bromaminas, tiempoCancelacion, quimicoAplicado, inicioActividades, equipoFiltracion, observacion, this.getId());
                ListarIncidente();
                limpiarIncidente();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarIncActionPerformed

    private void btnGuardarIncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarIncActionPerformed
        //CODIGO DE GUARDADO DE INCIDENTES
        String personaResponsable = txtPersonalIn.getText();
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaIncidente.getDate());
        String hora = txtHoraIn.getText();
        String tipoMateriaOrganica = txtMateriaInc.getText();
        String bromaminas = txtBromaminasInc.getText();
        String tiempoCancelacion = txtCancelacionInc.getText();
        String quimicoAplicado = txtQuimicoInc.getText();
        String inicioActividades = txtActividadInc.getText();
        String equipoFiltracion = txtFiltracionInc.getText();
        String observacion = txtObservacionInc.getText();

        if(personaResponsable.isEmpty()||hora.isEmpty()||tipoMateriaOrganica.isEmpty()||bromaminas.isEmpty()|| tiempoCancelacion.isEmpty()||quimicoAplicado.isEmpty()||inicioActividades.isEmpty()||equipoFiltracion.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO incidentestanqueterapeutico (persona, fecha, hora, tipoMateriaOrganica, bromaminas, tiempoCancelacion, quimicoAplicado, inicioActividad, equipoFiltrcion, observacion) VALUES ('"+personaResponsable+"','"+fecha+"','"+hora+"','"+tipoMateriaOrganica+"','"+bromaminas+"','"+tiempoCancelacion+"','"+quimicoAplicado+"','"+inicioActividades+"','"+equipoFiltracion+"','"+observacion+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarIncidente();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarIncActionPerformed

    private void tableIncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIncMouseClicked
        // TODO add your handling code here:
        int fila = tableInc.rowAtPoint(evt.getPoint());
        txtPersonalIn.setText(tableInc.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableInc.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaIncidente.setDate(getDateFormat("dd/MM/yyyy", fecha));

        txtHoraIn.setText(tableInc.getValueAt(fila, 2).toString());
        txtMateriaInc.setText(tableInc.getValueAt(fila, 3).toString());
        txtBromaminasInc.setText(tableInc.getValueAt(fila, 4).toString());
        txtCancelacionInc.setText(tableInc.getValueAt(fila, 5).toString());
        txtQuimicoInc.setText(tableInc.getValueAt(fila, 6).toString());
        txtActividadInc.setText(tableInc.getValueAt(fila, 7).toString());
        txtFiltracionInc.setText(tableInc.getValueAt(fila, 8).toString());
        txtObservacionInc.setText(tableInc.getValueAt(fila, 9).toString());

        this.setId(tableInc.getValueAt(fila, 10).toString());
    }//GEN-LAST:event_tableIncMouseClicked

    private void btnEliminarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(hiDao.eliminarHidrante(rv));
                LimpiarTabla();
                ListarHidrante();
            }
        }else{
            System.out.println(id);
        }

    }//GEN-LAST:event_btnEliminarHActionPerformed

    private void btnActualizarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarHActionPerformed
        // TODO add your handling code here:
        String periodoMensual;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        periodoMensual = f.format(fechaHidrante.getDate());
        String noHidrante = cmbMatH.getSelectedItem().toString();
        String manguera = cmbManH.getSelectedItem().toString();
        String fechaPrueba;
        fechaPrueba = f.format(fechaPruebaH.getDate());
        String fechaProxima;
        fechaProxima = f.format(fechaProxH.getDate());

        String edoPuerta = cmbPuertaH.getSelectedItem().toString();
        String edoCristal = cmbCristalH.getSelectedItem().toString();
        String edoPintura = cmbPinturaH.getSelectedItem().toString();
        String edoValvula = cmbValvulaH.getSelectedItem().toString();
        String edoChiflon = cmbChiflonH.getSelectedItem().toString();
        String edoManguera = cmbMangueraH.getSelectedItem().toString();
        String edoLlavePataGallo = cmbLlaveH.getSelectedItem().toString();
        String edoSeñaletica = cmbSenalH.getSelectedItem().toString();

        String elaborado = txtElaboroH.getText();
        String observacion = txtObG.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboroH.getText())) {
                System.out.println(periodoMensual);
                hiDao.modificarHidrante(noHidrante, periodoMensual, manguera, fechaPrueba, fechaProxima, edoPuerta, edoCristal, edoPintura, edoValvula, edoChiflon, edoManguera, edoLlavePataGallo, edoSeñaletica, elaborado, observacion, this.getId());
                ListarHidrante();
                limpiarHidrante();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarHActionPerformed

    private void tableHidranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHidranteMouseClicked
        // TODO add your handling code here:
        int fila = tableHidrante.rowAtPoint(evt.getPoint());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableHidrante.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaHidrante.setDate(getDateFormat("dd/MM/yyyy", fecha));

        cmbMatH.setSelectedItem(tableHidrante.getValueAt(fila, 1).toString());
        cmbManH.setSelectedItem(tableHidrante.getValueAt(fila, 2).toString());

        String[] fechasParts2 = tableHidrante.getValueAt(fila, 3).toString().split(separador);
        String fecha2 = "" + fechasParts2[2] + "/" + fechasParts2[1] + "/" + fechasParts2[0];
        fechaPruebaH.setDate(getDateFormat("dd/MM/yyyy", fecha2));

        String[] fechasParts3 = tableHidrante.getValueAt(fila, 4).toString().split(separador);
        String fecha3 = "" + fechasParts3[2] + "/" + fechasParts3[1] + "/" + fechasParts3[0];
        fechaProxH.setDate(getDateFormat("dd/MM/yyyy", fecha3));

        cmbPuertaH.setSelectedItem(tableHidrante.getValueAt(fila, 5).toString());
        cmbCristalH.setSelectedItem(tableHidrante.getValueAt(fila, 6).toString());
        cmbPinturaH.setSelectedItem(tableHidrante.getValueAt(fila, 7).toString());
        cmbValvulaH.setSelectedItem(tableHidrante.getValueAt(fila, 8).toString());
        cmbChiflonH.setSelectedItem(tableHidrante.getValueAt(fila, 9).toString());
        cmbMangueraH.setSelectedItem(tableHidrante.getValueAt(fila, 10).toString());
        cmbLlaveH.setSelectedItem(tableHidrante.getValueAt(fila, 11).toString());
        cmbSenalH.setSelectedItem(tableHidrante.getValueAt(fila, 12).toString());
        txtElaboroH.setText(tableHidrante.getValueAt(fila, 13).toString());
        txtObG.setText(tableHidrante.getValueAt(fila, 14).toString());

        this.setId(tableHidrante.getValueAt(fila, 15).toString());
    }//GEN-LAST:event_tableHidranteMouseClicked

    private void btnGuardarHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarHActionPerformed
        // TODO add your handling code here:
        String periodoMensual;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        periodoMensual = f.format(fechaHidrante.getDate());
        String noHidrante = cmbMatH.getSelectedItem().toString();
        String manguera = cmbManH.getSelectedItem().toString();
        String fechaPrueba;
        fechaPrueba = f.format(fechaPruebaH.getDate());
        String fechaProxima;
        fechaProxima = f.format(fechaProxH.getDate());

        String edoPuerta = cmbPuertaH.getSelectedItem().toString();
        String edoCristal = cmbCristalH.getSelectedItem().toString();
        String edoPintura = cmbPinturaH.getSelectedItem().toString();
        String edoValvula = cmbValvulaH.getSelectedItem().toString();
        String edoChiflon = cmbChiflonH.getSelectedItem().toString();
        String edoManguera = cmbMangueraH.getSelectedItem().toString();
        String edoLlavePataGallo = cmbLlaveH.getSelectedItem().toString();
        String edoSeñaletica = cmbSenalH.getSelectedItem().toString();

        String elaborado = txtElaboroH.getText();
        String observacion = txtObG.getText();

        if(elaborado.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO hidrante (noHidrante, fechaH, manguera, fechaPrueba, fechaProx, puerta, cristal, pintura, valvula, chiflon, estadoManguera, llave, señaletica, elaborado, observacion) VALUES ('"+noHidrante+"','"+periodoMensual+"','"+manguera+"','"+fechaPrueba+"','"+fechaProxima+"','"+edoPuerta+"','"+edoCristal+"','"+edoPintura+"','"+edoValvula+"','"+edoChiflon+"','"+edoManguera+"','"+edoLlavePataGallo+"','"+edoSeñaletica+"','"+elaborado+"','"+observacion+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarHidrante();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }

    }//GEN-LAST:event_btnGuardarHActionPerformed

    private void btnEliminarGasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGasVActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(gasVDao.eliminarMedV(rv));
                LimpiarTabla();
                ListarCisterna();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarGasVActionPerformed

    private void btnActualizarGasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarGasVActionPerformed
        // TODO add your handling code here:
        String fechaMedV;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaMedV = f.format(fechaGaValor.getDate());
        String tipoGasV = cmbTipoGasV.getSelectedItem().toString();
        String diaV = cmbFechaGasV.getSelectedItem().toString();
        String presionTanqueV = txtPresionTanV.getText();
        String reservaV= txtReservaGasV.getText();
        String limpiezaV = cmbLimpiezaGasV.getSelectedItem().toString();
        String nombreRealizoInventarioV = txtNameRealizoGV.getText();
        String observacionV = txtObserGenGaV.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtNameInv.getText())) {
                System.out.println(fechaMedV);
                gasVDao.modificarMedicoValoracion(fechaMedV, tipoGasV, diaV, presionTanqueV, reservaV, limpiezaV, nombreRealizoInventarioV, observacionV, this.getId());
                ListarMedValo();
                limpiarGasMV();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarGasVActionPerformed

    private void btnGuardarGasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGasVActionPerformed
        //CODIGO DE GUARDADO DE GASES MEDICINALES VALORACION
        String fechaV;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaV = f.format(fechaGaValor.getDate());
        String tipoGasV = cmbTipoGasV.getSelectedItem().toString();
        String diaV = cmbFechaGasV.getSelectedItem().toString();
        String presionTanqueV = txtPresionTanV.getText();
        String reservaV = txtReservaGasV.getText();
        String limpiezaV = cmbLimpiezaGasV.getSelectedItem().toString();
        String nombreRealizoInventarioV = txtNameRealizoGV.getText();
        String observacionV = txtObserGenGaV.getText();

        if(presionTanqueV.isEmpty()||reservaV.isEmpty()||nombreRealizoInventarioV.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO suministrovaloracion (fecha, tipoGas, dia, presionTanque, reserva, limpieza, name, observacion) VALUES ('"+fechaV+"','"+tipoGasV+"','"+diaV+"','"+presionTanqueV+"','"+reservaV+"','"+limpiezaV+"','"+nombreRealizoInventarioV+"','"+observacionV+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarGasMV();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarGasVActionPerformed

    private void tableGasValoracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGasValoracionMouseClicked
        // TODO add your handling code here:
        int fila = tableGasValoracion.rowAtPoint(evt.getPoint());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableGasValoracion.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaGaValor.setDate(getDateFormat("dd/MM/yyyy", fecha));

        cmbTipoGasV.setSelectedItem(tableGasValoracion.getValueAt(fila, 1).toString());
        cmbFechaGasV.setSelectedItem(tableGasValoracion.getValueAt(fila, 2).toString());
        txtPresionTanV.setText(tableGasValoracion.getValueAt(fila, 3).toString());
        txtReservaGasV.setText(tableGasValoracion.getValueAt(fila, 4).toString());
        cmbLimpiezaGasV.setSelectedItem(tableGasValoracion.getValueAt(fila, 5).toString());
        txtNameRealizoGV.setText(tableGasValoracion.getValueAt(fila, 6).toString());
        txtObserGenGaV.setText(tableGasValoracion.getValueAt(fila, 7).toString());

        this.setId(tableGasValoracion.getValueAt(fila, 8).toString());
    }//GEN-LAST:event_tableGasValoracionMouseClicked

    private void btnEliminarGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarGasActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(gasMDao.eliminarGasMed(rv));
                LimpiarTabla();
                ListarCisterna();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarGasActionPerformed

    private void btnActualizarGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarGasActionPerformed
        // TODO add your handling code here:
        String fechaMed;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaMed = f.format(fechaGasesH.getDate());
        String tipoGas = tipoGasH.getSelectedItem().toString();
        String presionTanque = txtPresionT.getText();
        String reserva = txtReservaT.getText();
        String limpieza = cmbLimpiezaG.getSelectedItem().toString();
        String nombreRealizoInventario = txtNameInv.getText();
        String observacion = txtObGenGa.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtNameInv.getText())) {
                System.out.println(fechaMed);
                gasMDao.modificarGasMed(fechaMed, tipoGas, presionTanque, reserva, limpieza, nombreRealizoInventario, observacion, this.getId());
                ListarGasMed();
                limpiarGasM();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarGasActionPerformed

    private void btnGuardarGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGasActionPerformed
        // CODIGO DE GUARDADOO DE GASES MEDICINALES
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaGasesH.getDate());
        String tipoGas = tipoGasH.getSelectedItem().toString();
        String presionTanque = txtPresionT.getText();
        String reserva = txtReservaT.getText();
        String limpieza = cmbLimpiezaG.getSelectedItem().toString();
        String nombreRealizoInventario = txtNameInv.getText();
        String observacion = txtObGenGa.getText();

        if(presionTanque.isEmpty()||reserva.isEmpty()||nombreRealizoInventario.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO suministro (fecha, tipoGas, presionTanque, reserva, limpieza, name, observacion) VALUES ('"+fecha+"','"+tipoGas+"','"+presionTanque+"','"+reserva+"','"+limpieza+"','"+nombreRealizoInventario+"','"+observacion+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarGasM();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarGasActionPerformed

    private void tableGasMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableGasMMouseClicked
        // TODO add your handling code here:
        int fila = tableGasM.rowAtPoint(evt.getPoint());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableGasM.getValueAt(fila, 0).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaGasesH.setDate(getDateFormat("dd/MM/yyyy", fecha));

        tipoGasH.setSelectedItem(tableGasM.getValueAt(fila, 1).toString());
        txtPresionT.setText(tableGasM.getValueAt(fila, 2).toString());
        txtReservaT.setText(tableGasM.getValueAt(fila, 3).toString());
        cmbLimpiezaG.setSelectedItem(tableGasM.getValueAt(fila, 4).toString());
        txtNameInv.setText(tableGasM.getValueAt(fila, 5).toString());
        txtObGenGa.setText(tableGasM.getValueAt(fila, 6).toString());

        this.setId(tableGasM.getValueAt(fila, 7).toString());
    }//GEN-LAST:event_tableGasMMouseClicked

    private void tableExtintoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableExtintoresMouseClicked
        // TODO add your handling code here:
        int fila = tableExtintores.rowAtPoint(evt.getPoint());
        cmbNoExtintor.setSelectedItem(tableExtintores.getValueAt(fila, 0).toString());

        String separador = Pattern.quote("-");
        String[] fechasParts = tableExtintores.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaExt.setDate(getDateFormat("dd/MM/yyyy", fecha));
        cmbMarcaEx.setSelectedItem(tableExtintores.getValueAt(fila, 2).toString());
        cmbAgenteE.setSelectedItem(tableExtintores.getValueAt(fila, 3).toString());
        cmbCapE.setSelectedItem(tableExtintores.getValueAt(fila, 4).toString());
        fechaUltExt.setText(tableExtintores.getValueAt(fila, 5).toString());
        fechaProExt.setText(tableExtintores.getValueAt(fila, 6).toString());
        cmbAccesibleExt.setSelectedItem(tableExtintores.getValueAt(fila, 7).toString());
        cmbSenalE.setSelectedItem(tableExtintores.getValueAt(fila, 8).toString());
        cmbEtiquetaE.setSelectedItem(tableExtintores.getValueAt(fila, 9).toString());
        cmbSeguridadE.setSelectedItem(tableExtintores.getValueAt(fila, 10).toString());
        cmbCorrosionExt.setSelectedItem(tableExtintores.getValueAt(fila, 11).toString());
        cmbPresionExt.setSelectedItem(tableExtintores.getValueAt(fila, 12).toString());
        cmbGolpesDefor.setSelectedItem(tableExtintores.getValueAt(fila, 13).toString());
        cmbExpoExt.setSelectedItem(tableExtintores.getValueAt(fila, 14).toString());
        cmbRoturaExt.setSelectedItem(tableExtintores.getValueAt(fila, 15).toString());
        cmbDesprenExt.setSelectedItem(tableExtintores.getValueAt(fila, 16).toString());
        cmbProtuExt.setSelectedItem(tableExtintores.getValueAt(fila, 17).toString());
        cmbPerfoExt.setSelectedItem(tableExtintores.getValueAt(fila, 18).toString());
        cmbObstruccionExt.setSelectedItem(tableExtintores.getValueAt(fila, 19).toString());
        cmbManoE.setSelectedItem(tableExtintores.getValueAt(fila, 20).toString());
        txtObExt.setText(tableExtintores.getValueAt(fila, 21).toString());
        txtElaboradoExt.setText(tableExtintores.getValueAt(fila, 22).toString());

        this.setId(tableExtintores.getValueAt(fila, 23).toString());
    }//GEN-LAST:event_tableExtintoresMouseClicked

    private void btnActualizarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEActionPerformed
        // TODO add your handling code here:
        String fechaExtintor;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaExtintor = f.format(fechaExt.getDate());
        String ultimaRecarga = fechaUltExt.getText();
        String proximaRecarga = fechaProExt.getText();
        String noExtintor = cmbNoExtintor.getSelectedItem().toString();
        String marca = cmbMarcaEx.getSelectedItem().toString();
        String agente = cmbAgenteE.getSelectedItem().toString();
        String capacidad = cmbCapE.getSelectedItem().toString();
        String corrosion = cmbCorrosionExt.getSelectedItem().toString();
        String escapePresion = cmbPresionExt.getSelectedItem().toString();
        String golpesDeformaciones = cmbGolpesDefor.getSelectedItem().toString();
        String expoFuego = cmbExpoExt.getSelectedItem().toString();
        String roturas = cmbRoturaExt.getSelectedItem().toString();
        String desprendimientoS = cmbDesprenExt.getSelectedItem().toString();
        String protuberancias = cmbProtuExt.getSelectedItem().toString();
        String perforaciones = cmbPerfoExt.getSelectedItem().toString();
        String obstrucciones = cmbObstruccionExt.getSelectedItem().toString();
        String lugarAccesible = cmbAccesibleExt.getSelectedItem().toString();
        String letreroSenalizacion = cmbSenalE.getSelectedItem().toString();
        String etiquetasLegibles = cmbEtiquetaE.getSelectedItem().toString();
        String manometro = cmbManoE.getSelectedItem().toString();
        String horquillaYcincho = cmbSeguridadE.getSelectedItem().toString();
        String observacionesEx = txtObExt.getText();
        String elaboradoExt = txtElaboradoExt.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoTan.getText())) {
                System.out.println(fechaExtintor);
                extDao.modificarExtintor(noExtintor, fechaExtintor, marca, agente, capacidad, ultimaRecarga, proximaRecarga, corrosion, escapePresion, golpesDeformaciones, expoFuego, roturas, desprendimientoS, protuberancias, perforaciones, obstrucciones, lugarAccesible, letreroSenalizacion, etiquetasLegibles, manometro, horquillaYcincho, observacionesEx, elaboradoExt, this.getId());
                ListarExtintor();
                limpiarExtintor();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarEActionPerformed

    private void btnEliminarEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(extDao.eliminarExtintor(rv));
                LimpiarTabla();
                ListarExtintor();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarEActionPerformed

    private void btnGuardarExtintorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarExtintorActionPerformed
        // CODIGO DE GUARDADO EN EXTINTORES
        String noExtintor = cmbNoExtintor.getSelectedItem().toString();
        String fechaExtintor;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaExtintor = f.format(fechaExt.getDate());
        String marca = cmbMarcaEx.getSelectedItem().toString();
        String agente = cmbAgenteE.getSelectedItem().toString();
        String capacidad = cmbCapE.getSelectedItem().toString();
        String ultimaRecarga = fechaUltExt.getText();
        String proximaRecarga = fechaProExt.getText();
        String lugarAccesible = cmbAccesibleExt.getSelectedItem().toString();
        String letreroSenalizacion = cmbSenalE.getSelectedItem().toString();
        String etiquetasLegibles = cmbEtiquetaE.getSelectedItem().toString();
        String horquillaYcincho = cmbSeguridadE.getSelectedItem().toString();
        String corrosion = cmbCorrosionExt.getSelectedItem().toString();
        String escapePresion = cmbPresionExt.getSelectedItem().toString();
        String golpesDeformaciones = cmbGolpesDefor.getSelectedItem().toString();
        String expoFuego = cmbExpoExt.getSelectedItem().toString();
        String roturas = cmbRoturaExt.getSelectedItem().toString();
        String desprendimientoS = cmbDesprenExt.getSelectedItem().toString();
        String protuberancias = cmbProtuExt.getSelectedItem().toString();
        String perforaciones = cmbPerfoExt.getSelectedItem().toString();
        String obstrucciones = cmbObstruccionExt.getSelectedItem().toString();
        String manometro = cmbManoE.getSelectedItem().toString();
        String observacionesEx = txtObExt.getText();
        String elaboradoExt = txtElaboradoExt.getText();

        if(elaboradoExt.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO extintor (materialext, fecha, marca, agentExtintor, capacidad, fechaUltimaRecarga, fechaProxRecarga, lugarAccesible, letrero, etiquetasLegibles, horquilla, corrocion, escapePresion, deformacion, exposicion, roturas, desprendimiento, protuberacion, perforacion, obstruccion, manometro, observacion, elaborado) VALUES ('"+noExtintor+"','"+fechaExtintor+"','"+marca+"','"+agente+"','"+capacidad+"','"+ultimaRecarga+"','"+proximaRecarga+"','"+lugarAccesible+"','"+letreroSenalizacion+"','"+etiquetasLegibles+"','"+horquillaYcincho+"','"+corrosion+"','"+escapePresion+"','"+golpesDeformaciones+"','"+expoFuego+"','"+roturas+"','"+desprendimientoS+"','"+protuberancias+"','"+perforaciones+"','"+obstrucciones+"','"+manometro+"','"+observacionesEx+"','"+elaboradoExt+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarExtintor();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarExtintorActionPerformed

    private void btnEliminarCisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCisActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(cisternaDao.eliminarCisterna(rv));
                LimpiarTabla();
                ListarCisterna();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarCisActionPerformed

    private void btnActualizarCisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCisActionPerformed
        // TODO add your handling code here:
        String fechaAP;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaAP = f.format(fechaCisterna.getDate());
        String noCisterna = cmbCisterna.getSelectedItem().toString();
        String diaSemana = cmbSemanaCis.getSelectedItem().toString();
        String hora = txtHoraCis.getText();
        String cloro = txtCloroC.getText();
        String ph = txtPhC.getText();
        String dureza = txtDurezaC.getText();
        String nivelAgua = txtNivelC.getText();
        String nombreRevisa = txtNombreC.getText();
        String observacionesCisterna = txtObCisterna.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoTan.getText())) {
                System.out.println(fechaAP);
                cisternaDao.modificarCisterna(noCisterna, diaSemana, fechaAP, hora, cloro, ph, dureza, nivelAgua, nombreRevisa, observacionesCisterna, this.getId());
                ListarCisterna();
                limpiarCisterna();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarCisActionPerformed

    private void tableCisternaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCisternaMouseClicked
        // TODO add your handling code here:
        int fila = tableCisterna.rowAtPoint(evt.getPoint());
        cmbCisterna.setSelectedItem(tableCisterna.getValueAt(fila, 0).toString());
        cmbSemanaCis.setSelectedItem(tableCisterna.getValueAt(fila, 1).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableTanque.getValueAt(fila, 2).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaCisterna.setDate(getDateFormat("dd/MM/yyyy", fecha));
        txtHoraCis.setText(tableCisterna.getValueAt(fila, 3).toString());
        txtCloroC.setText(tableCisterna.getValueAt(fila, 4).toString());
        txtPhC.setText(tableCisterna.getValueAt(fila, 5).toString());
        txtDurezaC.setText(tableCisterna.getValueAt(fila, 6).toString());
        txtNivelC.setText(tableCisterna.getValueAt(fila, 7).toString());
        txtNombreC.setText(tableCisterna.getValueAt(fila, 8).toString());
        txtObCisterna.setText(tableCisterna.getValueAt(fila, 9).toString());
        this.setId(tableTanque.getValueAt(fila, 10).toString());
    }//GEN-LAST:event_tableCisternaMouseClicked

    private void btnGuardarCisternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCisternaActionPerformed
        // CODIGO DE GUARDADO DE CISTERNA
        String noCisterna = cmbCisterna.getSelectedItem().toString();
        String diaSemana = cmbSemanaCis.getSelectedItem().toString();
        String fechaAP;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fechaAP = f.format(fechaCisterna.getDate());
        String hora = txtHoraCis.getText();
        String cloro = txtCloroC.getText();
        String ph = txtPhC.getText();
        String dureza = txtDurezaC.getText();
        String nivelAgua = txtNivelC.getText();
        String nombreRevisa = txtNombreC.getText();
        String observacionesCisterna = txtObCisterna.getText();

        if(hora.isEmpty() || cloro.isEmpty() || ph.isEmpty()|| dureza.isEmpty()|| nivelAgua.isEmpty()||nombreRevisa.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO cisternaagua (noCisterna, dia, fecha, hora, cloro, ph, durezaTotal, nivelAgua,nombre, observaciones) VALUES ('"+noCisterna+"','"+diaSemana+"','"+fechaAP+"','"+hora+"','"+cloro+"','"+ph+"','"+dureza+"','"+nivelAgua+"','"+nombreRevisa+"','"+observacionesCisterna+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarCisterna();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarCisternaActionPerformed

    private void cmbCisternaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCisternaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCisternaActionPerformed

    private void btnEliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTActionPerformed
        // TODO add your handling code here:
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(tanqueDao.eliminarTanque(rv));
                LimpiarTabla();
                ListarTanque();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarTActionPerformed

    private void btnActualizarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTActionPerformed
        // TODO add your handling code here:
        String datefacha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        datefacha = f.format(fechaTanqueG.getDate());
        String noTanqueGas = cmbTanque.getSelectedItem().toString();
        String horaEncendido = txtHoraET.getText();
        String horaApagado = txtHoraAG.getText();
        String nombrePrende = txtNamePrendeT.getText();
        String nombreApaga = txtNameAoagaT.getText();
        String porcentajeGas = txtPorceT.getText();
        String elaboradoG = txtElaboradoTan.getText();
        String observacionesG = txtObTan.getText();
        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtElaboradoTan.getText())) {
                System.out.println(datefacha);
                tanqueDao.modificarTanque(noTanqueGas, datefacha, horaEncendido, horaApagado, nombrePrende, nombreApaga, porcentajeGas, elaboradoG, observacionesG, this.getId());
                ListarTanque();
                limpiarTanqueGas();
                LimpiarTabla();
            }
        }
    }//GEN-LAST:event_btnActualizarTActionPerformed

    private void btnGuardarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTActionPerformed
        // CODIGO DE GUARDADO DE TANQUES DE GAS
        String noTanqueGas = cmbTanque.getSelectedItem().toString();
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaTanqueG.getDate());
        String horaEncendido = txtHoraET.getText();
        String horaApagado = txtHoraAG.getText();
        String nombrePrende = txtNamePrendeT.getText();
        String nombreApaga = txtNameAoagaT.getText();
        String porcentajeGas = txtPorceT.getText();
        String elaboradoG = txtElaboradoTan.getText();
        String observacionesG = txtObTan.getText();

        if(horaEncendido.isEmpty()||horaApagado.isEmpty()||nombrePrende.isEmpty()||nombreApaga.isEmpty()|| porcentajeGas.isEmpty()||elaboradoG.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO tanquegas (noMat, fecha, encendido, apagado, nameprende, nameapaga, porcentaje, elaborado, observacion) VALUES ('"+noTanqueGas+"','"+fecha+"','"+horaEncendido+"','"+horaApagado+"','"+nombrePrende+"','"+nombreApaga+"','"+porcentajeGas+"','"+elaboradoG+"','"+observacionesG+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarTanqueGas();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarTActionPerformed

    private void tableTanqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTanqueMouseClicked
        // TODO add your handling code here:
        int fila = tableTanque.rowAtPoint(evt.getPoint());
        cmbTanque.setSelectedItem(tableTanque.getValueAt(fila, 0).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = tableTanque.getValueAt(fila, 1).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaTanqueG.setDate(getDateFormat("dd/MM/yyyy", fecha));
        txtHoraET.setText(tableTanque.getValueAt(fila, 2).toString());
        txtHoraAG.setText(tableTanque.getValueAt(fila, 3).toString());
        txtNamePrendeT.setText(tableTanque.getValueAt(fila, 4).toString());
        txtNameAoagaT.setText(tableTanque.getValueAt(fila, 5).toString());
        txtPorceT.setText(tableTanque.getValueAt(fila, 6).toString());
        txtElaboradoTan.setText(tableTanque.getValueAt(fila, 7).toString());
        txtObTan.setText(tableTanque.getValueAt(fila, 8).toString());
        this.setId(tableTanque.getValueAt(fila, 9).toString());
    }//GEN-LAST:event_tableTanqueMouseClicked

    private void btnActualizarCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCalActionPerformed
        // TODO add your handling code here:

        String noCaldera = cmbnoCaldera.getSelectedItem().toString();
        String dia = cmbDiaCal.getSelectedItem().toString();
        String datefacha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        datefacha = f.format(fechaCaldera.getDate());
        String horaEncendido = txtHoraEncendido.getText();
        String horaApagado = txtHoraApagado.getText();
        String nombrePrende = txtNombrePrendeCal.getText();
        String nombreApaga = txtNameApagaCal.getText();
        String calderaTrabajando = cmbCalderaTra.getSelectedItem().toString();
        String porcentajeCa = txtPorcentajeCal.getText();
        String observacionesCa = txtObCa.getText();

        if("".equals(this.getId())){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            if (!"".equals(txtHoraEncendido.getText()) || !"".equals(txtHoraApagado.getText()) || !"".equals(txtNombrePrendeCal.getText()) || !"".equals(txtNameApagaCal.getText()) || !"".equals(txtPorcentajeCal.getText())) {
                System.out.println(datefacha);
                calderaD.modificarCaldera(noCaldera, dia, datefacha, horaEncendido, horaApagado, nombrePrende, nombreApaga, calderaTrabajando, porcentajeCa, observacionesCa, this.getId());
                ListarCaldera();
                limpiarCald();
                LimpiarTabla();
                
            }
        }
    }//GEN-LAST:event_btnActualizarCalActionPerformed

    private void btnEliminarCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCalActionPerformed
        if (!"".equals(this.getId())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Seguro");
            if (pregunta == 0) {
                String rv = this.getId();
                System.out.println(calderaD.eliminarCaldera(rv));
                LimpiarTabla();
                ListarCaldera();
            }
        }else{
            System.out.println(id);
        }
    }//GEN-LAST:event_btnEliminarCalActionPerformed

    private void btnGuardarCalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCalActionPerformed
        // CODIGO DE GUARDADO EN CALDERA
        String noCaldera = cmbnoCaldera.getSelectedItem().toString();
        String dia = cmbDiaCal.getSelectedItem().toString();
        String fecha;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        fecha = f.format(fechaCaldera.getDate());
        String horaEncendido = txtHoraEncendido.getText();
        String horaApagado = txtHoraApagado.getText();
        String nombrePrende = txtNombrePrendeCal.getText();
        String nombreApaga = txtNameApagaCal.getText();
        String calderaTrabajando = cmbCalderaTra.getSelectedItem().toString();
        String porcentajeCa = txtPorcentajeCal.getText();
        String observacionesCa = txtObCa.getText();

        if(horaEncendido.isEmpty() || horaApagado.isEmpty() || nombrePrende.isEmpty()|| nombreApaga.isEmpty()|| porcentajeCa.isEmpty()){
            JOptionPane.showMessageDialog(null, "DEBE COMPLETAR LOS DATOS");
        }else{
            try{
                String consulta = "INSERT INTO calderas (noCaldera, dia, fecha, horaEncendido, horaApagado, nombrePrende, nombreApaga, calderatrabajando, porcentaje, observaciones) VALUES ('"+noCaldera+"','"+dia+"','"+fecha+"','"+horaEncendido+"','"+horaApagado+"','"+nombrePrende+"','"+nombreApaga+"','"+calderaTrabajando+"','"+porcentajeCa+"','"+observacionesCa+"')";
                PreparedStatement ps = cn.prepareStatement(consulta);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos han sido guardados correctamente");
                limpiarCald();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion"+e);
            }
        }
    }//GEN-LAST:event_btnGuardarCalActionPerformed

    private void TableCalderaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCalderaMouseClicked
        // TODO add your handling code here:
        int fila = TableCaldera.rowAtPoint(evt.getPoint());
        cmbnoCaldera.setSelectedItem(TableCaldera.getValueAt(fila, 0).toString());
        cmbDiaCal.setSelectedItem(TableCaldera.getValueAt(fila, 1).toString());
        String separador = Pattern.quote("-");
        String[] fechasParts = TableCaldera.getValueAt(fila, 2).toString().split(separador);
        String fecha = "" + fechasParts[2] + "/" + fechasParts[1] + "/" + fechasParts[0];
        fechaCaldera.setDate(getDateFormat("dd/MM/yyyy", fecha));
        txtHoraEncendido.setText(TableCaldera.getValueAt(fila, 3).toString());
        txtHoraApagado.setText(TableCaldera.getValueAt(fila, 4).toString());
        txtNombrePrendeCal.setText(TableCaldera.getValueAt(fila, 5).toString());
        txtNameApagaCal.setText(TableCaldera.getValueAt(fila, 6).toString());
        cmbCalderaTra.setSelectedItem(TableCaldera.getValueAt(fila, 7).toString());
        txtPorcentajeCal.setText(TableCaldera.getValueAt(fila, 8).toString());
        txtObCa.setText(TableCaldera.getValueAt(fila, 9).toString());
        this.setId(TableCaldera.getValueAt(fila, 10).toString());
    }//GEN-LAST:event_TableCalderaMouseClicked

    private void cmbnoCalderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbnoCalderaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbnoCalderaActionPerformed
    public void LimpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }    public static Date getDateFormat(String formatPattern, String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
            return formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(SistemaHidro.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
   //7  private void historiaByTable(String t){
      //      List<Historial> ListaHistorial = historialdao.ListarBitacoraByTable(t);
        //    modelo = (DefaultTableModel) tableHistorialH.getModel();
          //  Object[] ob = new Object[4];
           // for (int i = 0; i < ListaHistorial.size(); i++) {
             //   System.out.println("Hola mundo");
               // ob[0] = ListaHistorial.get(i).getId();
               // ob[1] = ListaHistorial.get(i).getHost();
               // ob[2] = ListaHistorial.get(i).getUsusario();
               // ob[3] = ListaHistorial.get(i).getAccion();
               // modelo.addRow(ob);
           // }
           // tableHistorialH.setModel(modelo);
    //}
     
       // private void historiaByDate(String d){
         //   List<Historial> ListaHistorial = historialdao.ListarBitacoraByDate(d);
           // modelo = (DefaultTableModel) tableHistorialH.getModel();
           // Object[] ob = new Object[4];
            //for (int i = 0; i < ListaHistorial.size(); i++) {
              //  System.out.println("Hola mundo");
                //ob[0] = ListaHistorial.get(i).getId();
                //ob[1] = ListaHistorial.get(i).getHost();
               // ob[2] = ListaHistorial.get(i).getUsusario();
                //ob[3] = ListaHistorial.get(i).getAccion();
               // modelo.addRow(ob);
            //}
            //tableHistorialH.setModel(modelo);
    //}    public void LimpiarHistorial(){
      //  cmbHistorialH.setSelectedIndex(0);
        //dateHistorial.setDate(new Date());
   // }
    private void limpiarHidrante(){
        fechaHidrante.setDate(new Date());
        cmbMatH.setSelectedIndex(0);
        cmbManH.setSelectedIndex(0);
        fechaPruebaH.setDate(new Date());
        fechaProxH.setDate(new Date());
        cmbPuertaH.setSelectedIndex(0);
        cmbCristalH.setSelectedIndex(0);
        cmbPinturaH.setSelectedIndex(0);
        cmbValvulaH.setSelectedIndex(0);
        cmbChiflonH.setSelectedIndex(0);
        cmbMangueraH.setSelectedIndex(0);
        cmbLlaveH.setSelectedIndex(0);
        cmbSenalH.setSelectedIndex(0);
        txtElaboroH.setText("");
        txtObG.setText("");
    }
    private void limpiarTerapeutico(){
        fechaT.setDate(new Date());
        txtElaboroT.setText("");
        cmbDiaT.setSelectedIndex(0);
        cmbHoraT.setSelectedIndex(0);
        txtBromoT.setText("");
        txtPhT.setText("");
        txtAlcaT.setText("");
        txtDurezaT.setText("");
        txtTempT.setText("");
        cmbCloroT.setSelectedIndex(0);
        cmbShockT.setSelectedIndex(0);
        cmbAcidoT.setSelectedIndex(0);
        cmbClaT.setSelectedIndex(0);
        cmbAspiradoT.setSelectedIndex(0);
        cmbCepilladoT.setSelectedIndex(0);
        cmbConT.setSelectedIndex(0);
        cmbMoto1T.setSelectedIndex(0);
        cmbMoto2T.setSelectedIndex(0);
        cmbFiltroT.setSelectedIndex(0);
        txtPresionTera.setText("");
        cmbRetroT.setSelectedIndex(0);
        txtObsT.setText("");
    } 
            
    private void limpiarCald(){
        cmbnoCaldera.setSelectedIndex(0);
        cmbDiaCal.setSelectedIndex(0);
        fechaCaldera.setDate(new Date());
        txtHoraEncendido.setText("");
        txtHoraApagado.setText("");
        txtNombrePrendeCal.setText("");
        txtNameApagaCal.setText("");
        cmbCalderaTra.setSelectedIndex(0);
        txtPorcentajeCal.setText("");
        txtObCa.setText("");
    }    private void limpiarCisterna(){
        cmbCisterna.setSelectedIndex(0);
        cmbSemanaCis.setSelectedIndex(0);
        fechaCisterna.setDate(new Date());
        txtHoraCis.setText("");
        txtCloroC.setText("");
        txtPhC.setText("");
        txtDurezaC.setText("");
        txtNivelC.setText("");
        txtNombreC.setText("");
        txtObCisterna.setText("");
    }    private void limpiarContraIncendio(){
          fechaSis.setDate(new Date());
          cmbMatC.setSelectedIndex(0);
          cmbPrueba.setSelectedIndex(0);
          txtObs.setText("");
          txtElaboradoSis.setText("");
    }
        private void limpiarExtintor(){
        cmbNoExtintor.setSelectedIndex(0);
        fechaExt.setDate(new Date());
        cmbMarcaEx.setSelectedIndex(0);
        cmbAgenteE.setSelectedIndex(0);
        cmbCapE.setSelectedIndex(0);
        fechaUltExt.setText("");
        fechaProExt.setText("");
        cmbAccesibleExt.setSelectedIndex(0);
        cmbSenalE.setSelectedIndex(0);
        cmbEtiquetaE.setSelectedIndex(0);
        cmbSeguridadE.setSelectedIndex(0);
        cmbCorrosionExt.setSelectedIndex(0);
        cmbPresionExt.setSelectedIndex(0);
        cmbGolpesDefor.setSelectedIndex(0);
        cmbExpoExt.setSelectedIndex(0);
        cmbRoturaExt.setSelectedIndex(0);
        cmbDesprenExt.setSelectedIndex(0);
        cmbProtuExt.setSelectedIndex(0);
        cmbPerfoExt.setSelectedIndex(0);
        cmbObstruccionExt.setSelectedIndex(0);
        cmbManoE.setSelectedIndex(0);
        txtObExt.setText("");
        txtElaboradoExt.setText("");
    }    private void limpiarLp(){
        jFechaSum.setDate(new Date());
        cmbMatSum.setSelectedIndex(0);
        txtLitroSum.setText("");
        txtCostoSum.setText("");
        txtSubtotalSum.setText("");
        txtHoraEntradaSum.setText("");
        cmbSeguridadSum.setSelectedIndex(0);
        txtFirmaEncargadoSum.setText("");
        txtFirmaChoferSum.setText("");
        txtObLp.setText("");
    }    private void limpiarOrden(){
        fechaServInt.setDate(new Date());
        txtEquipoSerInt.setText("");
        txtSAreaerInt.setText("");
        txtSoliSerInt.setText("");
        txtEquipoServicio.setText("");
        txtMarcaServInt.setText("");
        txtModeloSerInt.setText("");
        txtSerieSerInt.setText("");
        txtTipoSerInt.setText("");
        txtDescSerInt.setText("");
        txtObserSerInt.setText("");
    }
    private void limpiarIncidente(){
        txtPersonalIn.setText("");
        fechaIncidente.setDate(new Date());
        txtHoraIn.setText("");
        txtMateriaInc.setText("");
        txtBromaminasInc.setText("");
        txtCancelacionInc.setText("");
        txtQuimicoInc.setText("");
        txtActividadInc.setText("");
        txtFiltracionInc.setText("");
        txtObservacionInc.setText("");
    }
    private void limpiarTanqueGas(){
        cmbTanque.setSelectedIndex(0);
        fechaTanqueG.setDate(new Date());
        txtHoraET.setText("");
        txtHoraAG.setText("");
        txtNamePrendeT.setText("");
        txtNameAoagaT.setText("");
        txtElaboradoTan.setText("");
        txtPorceT.setText("");
        txtObTan.setText("");
    }
    private void limpiarGasMV(){
        fechaGaValor.setDate(new Date());
        cmbTipoGasV.setSelectedIndex(0);
        cmbFechaGasV.setSelectedIndex(0);
        txtPresionTanV.setText("");
        txtReservaGasV.setText("");
        cmbLimpiezaGasV.setSelectedIndex(0);
        txtNameRealizoGV.setText("");
        txtObserGenGaV.setText("");
    }
    private void limpiarGasM(){
        fechaGasesH.setDate(new Date());
        tipoGasH.setSelectedIndex(0);
        txtPresionT.setText("");
        txtReservaT.setText("");
        cmbLimpiezaG.setSelectedIndex(0);
        txtNameInv.setText("");
        txtObGenGa.setText("");
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
            java.util.logging.Logger.getLogger(SistemaHidro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SistemaHidro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SistemaHidro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SistemaHidro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaHidro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableCaldera;
    private javax.swing.JButton btnActualizarCal;
    private javax.swing.JButton btnActualizarCis;
    private javax.swing.JButton btnActualizarE;
    private javax.swing.JButton btnActualizarGas;
    private javax.swing.JButton btnActualizarGasV;
    private javax.swing.JButton btnActualizarH;
    private javax.swing.JButton btnActualizarInc;
    private javax.swing.JButton btnActualizarSerInt;
    private javax.swing.JButton btnActualizarSum;
    private javax.swing.JButton btnActualizarT;
    private javax.swing.JButton btnEliminarCal;
    private javax.swing.JButton btnEliminarCis;
    private javax.swing.JButton btnEliminarE;
    private javax.swing.JButton btnEliminarGas;
    private javax.swing.JButton btnEliminarGasV;
    private javax.swing.JButton btnEliminarH;
    private javax.swing.JButton btnEliminarInc;
    private javax.swing.JButton btnEliminarSerInt;
    private javax.swing.JButton btnEliminarSum;
    private javax.swing.JButton btnEliminarT;
    private javax.swing.JButton btnGuardarCal;
    private javax.swing.JButton btnGuardarCisterna;
    private javax.swing.JButton btnGuardarContra;
    private javax.swing.JButton btnGuardarExtintor;
    private javax.swing.JButton btnGuardarGas;
    private javax.swing.JButton btnGuardarGasV;
    private javax.swing.JButton btnGuardarH;
    private javax.swing.JButton btnGuardarInc;
    private javax.swing.JButton btnGuardarSerInt;
    private javax.swing.JButton btnGuardarSuministroGas;
    private javax.swing.JButton btnGuardarT;
    private javax.swing.JComboBox<String> cmbAccesibleExt;
    private javax.swing.JComboBox<String> cmbAcidoT;
    private javax.swing.JComboBox<String> cmbAgenteE;
    private javax.swing.JComboBox<String> cmbAspiradoT;
    private javax.swing.JComboBox<String> cmbCalderaTra;
    private javax.swing.JComboBox<String> cmbCapE;
    private javax.swing.JComboBox<String> cmbCepilladoT;
    private javax.swing.JComboBox<String> cmbChiflonH;
    private javax.swing.JComboBox<String> cmbCisterna;
    private javax.swing.JComboBox<String> cmbClaT;
    private javax.swing.JComboBox<String> cmbCloroT;
    private javax.swing.JComboBox<String> cmbConT;
    private javax.swing.JComboBox<String> cmbCorrosionExt;
    private javax.swing.JComboBox<String> cmbCristalH;
    private javax.swing.JComboBox<String> cmbDesprenExt;
    private javax.swing.JComboBox<String> cmbDiaCal;
    private javax.swing.JComboBox<String> cmbDiaT;
    private javax.swing.JComboBox<String> cmbEtiquetaE;
    private javax.swing.JComboBox<String> cmbExpoExt;
    private javax.swing.JComboBox<String> cmbFechaGasV;
    private javax.swing.JComboBox<String> cmbFiltroT;
    private javax.swing.JComboBox<String> cmbGolpeExt;
    private javax.swing.JComboBox<String> cmbGolpesDefor;
    private javax.swing.JComboBox<String> cmbHoraT;
    private javax.swing.JComboBox<String> cmbLimpiezaG;
    private javax.swing.JComboBox<String> cmbLimpiezaGasV;
    private javax.swing.JComboBox<String> cmbLlaveH;
    private javax.swing.JComboBox<String> cmbManH;
    private javax.swing.JComboBox<String> cmbMangueraH;
    private javax.swing.JComboBox<String> cmbManoE;
    private javax.swing.JComboBox<String> cmbMarcaEx;
    private javax.swing.JComboBox<String> cmbMatC;
    private javax.swing.JComboBox<String> cmbMatH;
    private javax.swing.JComboBox<String> cmbMatSum;
    private javax.swing.JComboBox<String> cmbMoto1T;
    private javax.swing.JComboBox<String> cmbMoto2T;
    private javax.swing.JComboBox<String> cmbNoExtintor;
    private javax.swing.JComboBox<String> cmbObstruccionExt;
    private javax.swing.JComboBox<String> cmbPerfoExt;
    private javax.swing.JComboBox<String> cmbPinturaH;
    private javax.swing.JComboBox<String> cmbPresionExt;
    private javax.swing.JComboBox<String> cmbProtuExt;
    private javax.swing.JComboBox<String> cmbPrueba;
    private javax.swing.JComboBox<String> cmbPuertaH;
    private javax.swing.JComboBox<String> cmbRetroT;
    private javax.swing.JComboBox<String> cmbRoturaExt;
    private javax.swing.JComboBox<String> cmbSeguridadE;
    private javax.swing.JComboBox<String> cmbSeguridadSum;
    private javax.swing.JComboBox<String> cmbSemanaCis;
    private javax.swing.JComboBox<String> cmbSenalE;
    private javax.swing.JComboBox<String> cmbSenalH;
    private javax.swing.JComboBox<String> cmbShockT;
    private javax.swing.JComboBox<String> cmbTanque;
    private javax.swing.JComboBox<String> cmbTipoGasV;
    private javax.swing.JComboBox<String> cmbValvulaH;
    private javax.swing.JComboBox<String> cmbnoCaldera;
    private com.toedter.calendar.JDateChooser fechaCaldera;
    private com.toedter.calendar.JDateChooser fechaCisterna;
    private com.toedter.calendar.JDateChooser fechaExt;
    private com.toedter.calendar.JDateChooser fechaGaValor;
    private com.toedter.calendar.JDateChooser fechaGasesH;
    private com.toedter.calendar.JDateChooser fechaHidrante;
    private com.toedter.calendar.JDateChooser fechaIncidente;
    private javax.swing.JTextField fechaProExt;
    private com.toedter.calendar.JDateChooser fechaProxH;
    private com.toedter.calendar.JDateChooser fechaPruebaH;
    private com.toedter.calendar.JDateChooser fechaServInt;
    private com.toedter.calendar.JDateChooser fechaSis;
    private com.toedter.calendar.JDateChooser fechaT;
    private com.toedter.calendar.JDateChooser fechaTanqueG;
    private javax.swing.JTextField fechaUltExt;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jFechaSum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
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
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel147;
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
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
    private javax.swing.JTable jTable11;
    private javax.swing.JTable tableCisterna;
    private javax.swing.JTable tableExtintor;
    private javax.swing.JTable tableExtintores;
    private javax.swing.JTable tableGasM;
    private javax.swing.JTable tableGasValoracion;
    private javax.swing.JTable tableHidrante;
    private javax.swing.JTable tableInc;
    private javax.swing.JTable tableLp;
    private javax.swing.JTable tableSerInt;
    private javax.swing.JTable tableSisCon;
    private javax.swing.JTable tableTanque;
    private javax.swing.JTable tableTera;
    private javax.swing.JComboBox<String> tipoGasH;
    private javax.swing.JTextField txtActividadInc;
    private javax.swing.JTextField txtAlcaT;
    private javax.swing.JTextField txtBromaminasInc;
    private javax.swing.JTextField txtBromoT;
    private javax.swing.JTextField txtCancelacionInc;
    private javax.swing.JTextField txtCloroC;
    private javax.swing.JTextField txtCostoSum;
    private javax.swing.JTextField txtDescSerInt;
    private javax.swing.JTextField txtDurezaC;
    private javax.swing.JTextField txtDurezaT;
    private javax.swing.JTextField txtElaboradoExt;
    private javax.swing.JTextField txtElaboradoSis;
    private javax.swing.JTextField txtElaboradoTan;
    private javax.swing.JTextField txtElaboroH;
    private javax.swing.JTextField txtElaboroT;
    private javax.swing.JTextField txtEquipoSerInt;
    private javax.swing.JTextField txtEquipoServicio;
    private javax.swing.JTextField txtFiltracionInc;
    private javax.swing.JTextField txtFirmaChoferSum;
    private javax.swing.JTextField txtFirmaEncargadoSum;
    private javax.swing.JTextField txtHoraAG;
    private javax.swing.JTextField txtHoraApagado;
    private javax.swing.JTextField txtHoraCis;
    private javax.swing.JTextField txtHoraET;
    private javax.swing.JTextField txtHoraEncendido;
    private javax.swing.JTextField txtHoraEntradaSum;
    private javax.swing.JTextField txtHoraIn;
    private javax.swing.JTextField txtHoraSalidaSum;
    private javax.swing.JTextField txtLitroSum;
    private javax.swing.JTextField txtMarcaServInt;
    private javax.swing.JTextField txtMateriaInc;
    private javax.swing.JTextField txtModeloSerInt;
    private javax.swing.JTextField txtNameAoagaT;
    private javax.swing.JTextField txtNameApagaCal;
    private javax.swing.JTextField txtNameInv;
    private javax.swing.JTextField txtNamePrendeT;
    private javax.swing.JTextField txtNameRealizoGV;
    private javax.swing.JTextField txtNivelC;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombrePrendeCal;
    private javax.swing.JTextField txtObCa;
    private javax.swing.JTextField txtObCisterna;
    private javax.swing.JTextField txtObExt;
    private javax.swing.JTextField txtObG;
    private javax.swing.JTextField txtObGenGa;
    private javax.swing.JTextField txtObLp;
    private javax.swing.JTextField txtObTan;
    private javax.swing.JTextField txtObs;
    private javax.swing.JTextField txtObsT;
    private javax.swing.JTextField txtObserGenGaV;
    private javax.swing.JTextField txtObserSerInt;
    private javax.swing.JTextField txtObservacionInc;
    private javax.swing.JTextField txtPersonalIn;
    private javax.swing.JTextField txtPhC;
    private javax.swing.JTextField txtPhT;
    private javax.swing.JTextField txtPorceT;
    private javax.swing.JTextField txtPorcentajeCal;
    private javax.swing.JTextField txtPresionT;
    private javax.swing.JTextField txtPresionTanV;
    private javax.swing.JTextField txtPresionTera;
    private javax.swing.JTextField txtQuimicoInc;
    private javax.swing.JTextField txtReservaGasV;
    private javax.swing.JTextField txtReservaT;
    private javax.swing.JTextField txtSAreaerInt;
    private javax.swing.JTextField txtSerieSerInt;
    private javax.swing.JTextField txtSoliSerInt;
    private javax.swing.JTextField txtSubtotalSum;
    private javax.swing.JTextField txtTempT;
    private javax.swing.JTextField txtTipoSerInt;
    // End of variables declaration//GEN-END:variables
}
