
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ordenSerIntDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarOrden(ordenSerInt ord){
    String sql = "INSERT INTO ordenservicio (fecha, equipo, areaAtencion, nombreSolicitante, equipoo, marca, modelo, serie, tipoMantenimiento, descripcionServicio, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1, (Date) ord.getFecha());
            ps.setString(2, ord.getEquipo());
            ps.setString(3, ord.getOficina());
            ps.setString(4, ord.getNameSolicito());
            ps.setString(5, ord.getEquipo2());
            ps.setString(6, ord.getMarca());
            ps.setString(7, ord.getModelo());
            ps.setString(8, ord.getSerie());
            ps.setString(9, ord.getTipoMantenimiento());
            ps.setString(10, ord.getDesMantenimiento());
            ps.setString(11, ord.getObservacion());
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
    public List ListarOrdenSI(){
        List<ordenSerInt> ListaOrden = new ArrayList();
        String sql = "SELECT * FROM ordenservicio";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                ordenSerInt ord = new ordenSerInt();
                ord.setFecha(rs.getDate("fecha"));//2
                ord.setEquipo(rs.getString("equipo"));//3
                ord.setOficina(rs.getString("areaAtencion"));//4
                ord.setNameSolicito(rs.getString("nombreSolicitante"));//5
                ord.setEquipo2(rs.getString("equipoo"));//6
                ord.setMarca(rs.getString("marca"));//7
                ord.setModelo(rs.getString("modelo"));//8
                ord.setSerie(rs.getString("serie"));//9
                ord.setTipoMantenimiento(rs.getString("tipoMantenimiento"));//10
                ord.setDesMantenimiento(rs.getString("descripcionServicio"));//11
                ord.setObservacion(rs.getString("observacion"));
                ord.setId(rs.getInt("id"));//17
                ListaOrden.add(ord);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaOrden;
    }

    public Boolean eliminarOrden(String id){
        String sql = "DELETE FROM ordenservicio WHERE id="+ id +"";
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
   public boolean modificarOrden(String Fecha, String Equipo, String Oficina, String NameSolicito, String Equipo2, String Marca, String Modelo, String Serie, String TipoMantenimiento, String DesMantenimiento, String Observacion, String id){
       String sql = "UPDATE ordenservicio SET fecha='"+ Fecha +"',equipo='"+ Equipo +"', areaAtencion='"+ Oficina +"', nombreSolicitante='"+NameSolicito+"', equipoo='"+ Equipo2 +"', marca='"+Marca+"', modelo='"+Modelo+"', serie='"+Serie+"', tipoMantenimiento='"+TipoMantenimiento+"', descripcionServicio='"+DesMantenimiento+"', observacion='"+Observacion+"' WHERE id="+ id +"";
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

