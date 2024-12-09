

package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class cisternaAguaPotableDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarCisterna(cisternaAguaPotable cis){
        String sql = "INSERT INTO cisternaagua (noCisterna, dia, fecha, hora, cloro, ph, durezaTotal, nivelAgua, nombre, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, cis.getNoCisterna());
            ps.setString(2, cis.getDiaSemana());
            ps.setDate(3, (Date) cis.getFechaAP());
            ps.setString(4, cis.getHora());
            ps.setString(5, cis.getCloro());
            ps.setString(6, cis.getPh());
            ps.setString(7, cis.getDureza());
            ps.setString(8, cis.getNivelAgua());
            ps.setString(9, cis.getNombreRevisa());
            ps.setString(10, cis.getObservacionesCisterna());
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
        public List ListarCisterna(){
        List<cisternaAguaPotable> ListaCist = new ArrayList();
        String sql = "SELECT * FROM cisternaagua";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                cisternaAguaPotable cis = new cisternaAguaPotable();
                cis.setNoCisterna(rs.getString("noCisterna"));//2
                cis.setDiaSemana(rs.getString("dia"));//3
                cis.setFechaAP(rs.getDate("fecha"));//4
                cis.setHora(rs.getString("hora"));//5
                cis.setCloro(rs.getString("cloro"));//6
                cis.setPh(rs.getString("ph"));//7
                cis.setDureza(rs.getString("durezaTotal"));//8
                cis.setNivelAgua(rs.getString("nivelAgua"));//9
                cis.setNombreRevisa(rs.getString("nombre"));//10
                cis.setObservacionesCisterna(rs.getString("observaciones"));//11
                cis.setId(rs.getInt("id"));//12
                ListaCist.add(cis);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCist;
    }

    public Boolean eliminarCisterna(String id){
        String sql = "DELETE FROM cisternaagua WHERE id="+ id +"";
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

   public boolean modificarCisterna(String NoCisterna, String diaSemana, String FechaAP, String Hora, String Cloro, String Ph, String Dureza, String NivelAgua, String NombreRevisa, String ObservacionesCisterna, String id){
       String sql = "UPDATE cisternaagua SET noCisterna='"+ NoCisterna +"',dia='"+ diaSemana +"', fecha='"+FechaAP+"', hora='"+Hora+"', cloro='"+Cloro+"', ph='"+Ph+"', durezaTotal='"+Dureza+"', nivelAgua='"+NivelAgua+"', nombre='"+NombreRevisa+"', observaciones='"+ObservacionesCisterna+"' WHERE id="+ id +"";
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

