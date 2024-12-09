
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class calderaDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarCaldera(caldera cal){
        String sql = "INSERT INTO calderas (noCaldera, dia, fecha, horaEncendido, horaApagado, nombrePrende, nombreApaga, calderatrabajando, porcentaje, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cal.getNoCaldera());
            ps.setString(2, cal.getDia());
            ps.setDate(3, (Date) cal.getFecha());
            ps.setString(4, cal.getHoraEncendido());
            ps.setString(5, cal.getHoraApagado());
            ps.setString(6, cal.getNombrePrende());
            ps.setString(7, cal.getNombreApaga());
            ps.setString(8, cal.getCalderaTrabajando());
            ps.setString(9, cal.getPorcentajeCa());
            ps.setString(10, cal.getObservacionesCa());
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
        public List ListarCaldera(){
        List<caldera> ListaCalder = new ArrayList();
        String sql = "SELECT * FROM calderas";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                caldera cal = new caldera();
                cal.setNoCaldera(rs.getInt("noCaldera"));//2
                cal.setDia(rs.getString("dia"));//3
                cal.setFecha(rs.getDate("fecha"));//4
                cal.setHoraEncendido(rs.getString("horaEncendido"));//5
                cal.setHoraApagado(rs.getString("horaApagado"));//6
                cal.setNombrePrende(rs.getString("nombrePrende"));//7
                cal.setNombreApaga(rs.getString("nombreApaga"));
                cal.setCalderaTrabajando(rs.getString("calderatrabajando"));//8
                cal.setPorcentajeCa(rs.getString("porcentaje"));//9
                cal.setObservacionesCa(rs.getString("observaciones"));//10
                cal.setId(rs.getInt("id"));//11
                ListaCalder.add(cal);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCalder;
    }

    public Boolean eliminarCaldera(String id){
        String sql = "DELETE FROM calderas WHERE id="+ id +"";
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

   public boolean modificarCaldera(String NoCaldera, String Dia, String Fecha, String HoraEncendido, String HoraApagado, String NombrePrende, String NombreApaga, String CalderaTrabajando, String PorcentajeCa, String ObservacionesCa, String id){
       String sql = "UPDATE calderas SET noCaldera='"+ NoCaldera +"',dia='"+ Dia +"', fecha='"+Fecha+"', horaEncendido='"+HoraEncendido+"', horaApagado='"+HoraApagado+"', nombrePrende='"+NombrePrende+"',  nombreApaga='"+NombreApaga+"', calderatrabajando='"+CalderaTrabajando+"', porcentaje='"+PorcentajeCa+"', observaciones='"+ObservacionesCa+"' WHERE id="+ id +"";
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
