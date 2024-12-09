
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;

public class extintorDao {
    
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    
     public boolean RegistrarExtintor(extintor ext){
        String sql = "INSERT INTO extintor (materialext, fecha, marca, agentExtintor, capacidad, fechaUltimaRecarga, fechaProxRecarga, lugarAccesible, letrero, etiquetasLegibles, horquilla, corrocion, escapePresion, deformacion, exposicion, roturas, desprendimiento, protuberacion, perforacion, obstruccion, manometro, observacion, elaborado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, ext.getNoExtintor());
            ps.setDate(2, (Date)ext.getFechaExtintor());
            ps.setString(3, ext.getMarca());
            ps.setString(4, ext.getAgente());
            ps.setString(5, ext.getCapacidad());
            ps.setString(6, ext.getUltimaRecarga());
            ps.setString(7, ext.getProximaRecarga());
            ps.setString(8, ext.getLugarAccesible());
            ps.setString(9, ext.getLetreroSenalizacion());
            ps.setString(10, ext.getEtiquetasLegibles());
            ps.setString(11, ext.getHorquillaYcincho());
            ps.setString(12, ext.getCorrosion());
            ps.setString(13, ext.getEscapePresion());
            ps.setString(14, ext.getGolpesDeformaciones());
            ps.setString(15, ext.getExpoFuego());
            ps.setString(16, ext.getRoturas());
            ps.setString(17, ext.getDesprendimientoS());
            ps.setString(18, ext.getProtuberancias());
            ps.setString(19, ext.getPerforaciones());
            ps.setString(20, ext.getObstrucciones());
            ps.setString(21, ext.getManometro());
            ps.setString(22, ext.getObservacionesEx());
            ps.setString(23, ext.getElaboradoExt());
            ps.execute();
            return true;
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
        public List ListarExtintor(){
        List<extintor> ListaExtintor = new ArrayList();
        String sql = "SELECT * FROM extintor";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                extintor ext = new extintor();
                ext.setNoExtintor(rs.getString("materialext"));//2
                ext.setFechaExtintor(rs.getDate("fecha"));//3
                ext.setMarca(rs.getString("marca"));//4
                ext.setAgente(rs.getString("agentExtintor"));//5
                ext.setCapacidad(rs.getString("capacidad"));//6
                ext.setUltimaRecarga(rs.getString("fechaUltimaRecarga"));//7
                ext.setProximaRecarga(rs.getString("fechaProxRecarga"));//8
                ext.setLugarAccesible(rs.getString("lugarAccesible"));//18
                ext.setLetreroSenalizacion(rs.getString("letrero"));
                ext.setEtiquetasLegibles(rs.getString("etiquetasLegibles"));
                ext.setHorquillaYcincho(rs.getString("horquilla"));
                ext.setCorrosion(rs.getString("corrocion"));//9
                ext.setEscapePresion(rs.getString("escapePresion"));//10
                ext.setGolpesDeformaciones(rs.getString("deformacion"));//11
                ext.setExpoFuego(rs.getString("exposicion"));//12
                ext.setRoturas(rs.getString("roturas"));//13
                ext.setDesprendimientoS(rs.getString("desprendimiento"));//14
                ext.setProtuberancias(rs.getString("protuberacion"));//15
                ext.setPerforaciones(rs.getString("perforacion"));//16
                ext.setObstrucciones(rs.getString("obstruccion"));//17
       
                ext.setManometro(rs.getString("manometro"));
                ext.setObservacionesEx(rs.getString("observacion"));
                ext.setElaboradoExt(rs.getString("elaborado"));
                ext.setId(rs.getInt("id"));//18
                ListaExtintor.add(ext);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaExtintor;
    }

    public Boolean eliminarExtintor(String id){
        String sql = "DELETE FROM extintor WHERE id="+ id +"";
        try{
            ps = cn.prepareStatement(sql);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
   public boolean modificarExtintor(String noExtintor, String fechaExtintor, String Marca, String Agente, String Capacidad, String UltimaRecarga, String ProximaRecarga, String Corrosion, String EscapePresion, String GolpesDeformaciones, String ExpoFuego, String Roturas, String DesprendimientoS, String Protuberancias, String Perforaciones, String Obstrucciones, String lugarAccesible, String LetreroSenalizacion, String EtiquetasLegibles, String Manometro, String HorquillaYcincho, String ObservacionesEx, String ElaboradoExt, String id){
       String sql = "UPDATE extintor SET materialext='"+ noExtintor +"',fecha='"+ fechaExtintor +"', marca='"+Marca+"', agentExtintor='"+Agente+"', capacidad='"+Capacidad+"', fechaUltimaRecarga='"+UltimaRecarga+"', fechaProxRecarga='"+ProximaRecarga+"', corrocion='"+Corrosion+"', escapePresion='"+EscapePresion+"', deformacion='"+GolpesDeformaciones+"', exposicion='"+ExpoFuego+"', roturas='"+Roturas+"', desprendimiento='"+DesprendimientoS+"', protuberacion='"+Protuberancias+"', perforacion='"+Perforaciones+"', obstruccion='"+Obstrucciones+"', lugarAccesible='"+lugarAccesible+"', letrero='"+LetreroSenalizacion+"', etiquetasLegibles='"+EtiquetasLegibles+"', manometro='"+Manometro+"', horquilla='"+HorquillaYcincho+"', observacion='"+ObservacionesEx+"', elaborado='"+ElaboradoExt+"' WHERE id="+ id +"";
       try{
           cn = con.getConnection();
           ps = cn.prepareStatement(sql);
           ps.execute();
           return true;
       }catch(SQLException e){
           System.out.println(e);
           return false;
       }finally{
           try{
               cn.close();
           }catch(SQLException e){
               System.out.println(e.toString());
           }
       }
   }


}


