/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lizbe
 */
public class tanqueGasDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarTanque(tanqueGas gas){
        String sql = "INSERT INTO tanquegas (noMat, fecha, encendido, apagado, nameprende, nameapaga, porcentaje, elaborado, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, gas.getNoTanquegas());
            ps.setDate(2, (Date) gas.getFecha());
            ps.setString(3, gas.getHoraEncendido());
            ps.setString(4, gas.getHoraApagado());
            ps.setString(5, gas.getNombrePrende());
            ps.setString(6, gas.getNombreApaga());
            ps.setString(7, gas.getPorcentajeGas());
            ps.setString(8, gas.getElaboradoG());
            ps.setString(9, gas.getObservacionesG());

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
        public List ListarTanque(){
        List<tanqueGas> ListaTanque = new ArrayList();
        String sql = "SELECT * FROM tanquegas";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                tanqueGas gas = new tanqueGas();
                gas.setNoTanquegas(rs.getString("noMat"));//2
                gas.setFecha(rs.getDate("fecha"));//3
                gas.setHoraEncendido(rs.getString("encendido"));//4
                gas.setHoraApagado(rs.getString("apagado"));//5
                gas.setNombrePrende(rs.getString("nameprende"));//6
                gas.setNombreApaga(rs.getString("nameapaga"));//7
                gas.setPorcentajeGas(rs.getString("porcentaje"));//8
                gas.setElaboradoG(rs.getString("elaborado"));//9
                gas.setObservacionesG(rs.getString("observacion"));//10
                gas.setId(rs.getInt("id"));//11
                ListaTanque.add(gas);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaTanque;
    }

    public Boolean eliminarTanque(String id){
        String sql = "DELETE FROM tanquegas WHERE id="+ id +"";
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

   public boolean modificarTanque(String noTanqueGas, String Fecha, String HoraEncendido, String HoraApagado, String NombrePrende, String NombreApaga, String PorcentajeGas, String ElaboradoG, String ObservacionesG, String id){
       String sql = "UPDATE tanquegas SET noMat='"+ noTanqueGas +"',fecha='"+ Fecha +"',encendido='"+ HoraEncendido +"', apagado='"+HoraApagado+"', nameprende='"+NombrePrende+"', nameapaga='"+NombreApaga+"', porcentaje='"+PorcentajeGas+"', elaborado='"+ElaboradoG+"', observacion='"+ObservacionesG+"' WHERE id="+ id +"";
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
