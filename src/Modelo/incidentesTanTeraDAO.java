
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class incidentesTanTeraDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarIncidente(incidentesTanTera inc){
        String sql = "INSERT INTO incidentestanqueterapeutico (persona, fecha, hora, tipoMateriaOrganica, bromaminas, tiempoCancelacion, quimicoAplicado, inicioActividad, equipoFiltrcion, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, inc.getPersonaResponsable());
            ps.setDate(2, (Date) inc.getFecha());
            ps.setString(3, inc.getHora());
            ps.setString(4, inc.getTipoMateriaOrganica());
            ps.setString(5, inc.getBromaminas());
            ps.setString(6, inc.getTiempoCancelacion());
            ps.setString(7, inc.getQuimicoAplicado());
            ps.setString(8, inc.getInicioActividades());
            ps.setString(9, inc.getEquipoFiltracion());
            ps.setString(10, inc.getObservacion());
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
     
    public List ListarIncidente(){
        List<incidentesTanTera> ListaInc = new ArrayList();
        String sql = "SELECT * FROM incidentestanqueterapeutico";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                incidentesTanTera inc = new incidentesTanTera();
                inc.setPersonaResponsable(rs.getString("persona"));//2
                inc.setFecha(rs.getDate("fecha"));//3
                inc.setHora(rs.getString("hora"));//4
                inc.setTipoMateriaOrganica(rs.getString("tipoMateriaOrganica"));//5
                inc.setBromaminas(rs.getString("bromaminas"));//6
                inc.setTiempoCancelacion(rs.getString("tiempoCancelacion"));//7
                inc.setQuimicoAplicado(rs.getString("quimicoAplicado"));//8
                inc.setInicioActividades(rs.getString("inicioActividad"));//9
                inc.setEquipoFiltracion(rs.getString("equipoFiltrcion"));//10
                inc.setObservacion(rs.getString("observacion"));//11
                inc.setId(rs.getInt("id"));//17
                ListaInc.add(inc);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaInc;
    }

    public Boolean eliminarInc(String id){
        String sql = "DELETE FROM incidentestanqueterapeutico WHERE id="+ id +"";
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
   public boolean modificarIncid(String PersonaResponsable, String Fecha, String Hora, String TipoMateriaOrganica, String Bromaminas, String TiempoCancelacion, String QuimicoAplicado, String InicioActividades, String EquipoFiltracion, String Observacion, String id){
       String sql = "UPDATE  incidentestanqueterapeutico SET persona='"+ PersonaResponsable +"',fecha='"+ Fecha +"', hora='"+ Hora +"', tipoMateriaOrganica='"+TipoMateriaOrganica+"', bromaminas='"+ Bromaminas +"', tiempoCancelacion='"+TiempoCancelacion+"', quimicoAplicado='"+QuimicoAplicado+"', inicioActividad='"+InicioActividades+"', equipoFiltrcion='"+EquipoFiltracion+"', observacion='"+Observacion+"'WHERE id="+ id +"";
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

