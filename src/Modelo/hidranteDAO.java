
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;

public class hidranteDAO {
    conexionBD con = new conexionBD();
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;


public boolean RegistrarHidrante(hidrante hi){
        String sql = "INSERT INTO hidrante (noHidrante, fechaH, manguera, fechaPrueba, fechaProx, puerta, cristal, pintura, valvula, chiflon, estadoManguera, llave, señaletica, elaborado, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, hi.getNoHidrante());
            ps.setDate(2, (Date) hi.getPeriodoMensual());
            ps.setString(3, hi.getManguera());
            ps.setDate(4, (Date) hi.getFechaPrueba());
            ps.setDate(5, (Date) hi.getFechaProxima());
            ps.setString(6, hi.getEdoPuerta());
            ps.setString(7, hi.getEdoCristal());
            ps.setString(8, hi.getEdoPuerta());
            ps.setString(9, hi.getEdoValvula());
            ps.setString(10, hi.getEdoChiflon());
            ps.setString(11, hi.getEdoManguera());
            ps.setString(12, hi.getEdoLlavePataGallo());
            ps.setString(13, hi.getEdoSeñaletica());
            ps.setString(14, hi.getElaborado());
            ps.setString(15, hi.getObservacion());
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
        public List ListarHidrante(){
        List<hidrante> ListaHidrante = new ArrayList();
        String sql = "SELECT * FROM hidrante";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                hidrante hi = new hidrante();
                hi.setNoHidrante(rs.getString("noHidrante"));//2
                hi.setPeriodoMensual(rs.getDate("fechaH"));//3
                hi.setManguera(rs.getString("manguera"));//4
                hi.setFechaPrueba(rs.getDate("fechaPrueba"));//5
                hi.setFechaProxima(rs.getDate("fechaProx"));//6
                hi.setEdoPuerta(rs.getString("puerta"));//7
                hi.setEdoCristal(rs.getString("cristal"));//8
                hi.setEdoPintura(rs.getString("pintura"));//9
                hi.setEdoValvula(rs.getString("valvula"));//10
                hi.setEdoChiflon(rs.getString("chiflon"));//11
                hi.setEdoManguera(rs.getString("estadoManguera"));//12
                hi.setEdoLlavePataGallo(rs.getString("llave"));//13
                hi.setEdoSeñaletica(rs.getString("señaletica"));//14
                hi.setElaborado(rs.getString("elaborado"));//15
                hi.setObservacion(rs.getString("observacion"));//16
                hi.setId(rs.getInt("id"));//17
                ListaHidrante.add(hi);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaHidrante;
    }

    public Boolean eliminarHidrante(String id){
        String sql = "DELETE FROM hidrante WHERE id="+ id +"";
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
   public boolean modificarHidrante(String NoHidrante, String PeriodoMensual, String Manguera, String FechaPrueba, String FechaProxima, String EdoPuerta, String EdoCristal, String EdoPintura, String EdoValvula, String EdoChiflon, String EdoManguera, String EdoLlavePataGallo, String EdoSeñaletica, String Elaborado, String Observacion, String id){
       String sql = "UPDATE hidrante SET noHidrante='"+ NoHidrante +"',fechaH='"+ PeriodoMensual +"', manguera='"+Manguera+"', fechaPrueba='"+FechaPrueba+"', fechaProx='"+FechaProxima+"', puerta='"+EdoPuerta+"', cristal='"+EdoCristal+"', pintura='"+EdoPintura+"', valvula='"+EdoValvula+"', chiflon='"+EdoChiflon+"', estadoManguera='"+EdoManguera+"', llave='"+EdoLlavePataGallo+"', señaletica='"+EdoSeñaletica+"', elaborado='"+Elaborado+"', observacion='"+Observacion+"' WHERE id="+ id +"";
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

        
    