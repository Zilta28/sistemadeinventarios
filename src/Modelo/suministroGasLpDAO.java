
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class suministroGasLpDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarSuministroLp(suministroGasLp sumLp){
        String sql = "INSERT INTO suministrogaslp (fecha, noMat, litro, costo, subtotal, entrada, salida, seg, encargado, chofer, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1, (Date) sumLp.getFecha());
            ps.setString(2, sumLp.getMateriaLp());
            ps.setString(3, sumLp.getLitro());
            ps.setString(4, sumLp.getCosto());
            ps.setString(5, sumLp.getSubtotal());
            ps.setString(6, sumLp.getHoraEntrada());
            ps.setString(7, sumLp.getHoraSalida());
            ps.setString(8, sumLp.getSeguridad());
            ps.setString(9, sumLp.getEncargado());
            ps.setString(10,sumLp.getChofer());
            ps.setString(11, sumLp.getObservacionesG());
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
 
   public List ListarLpo(){
        List<suministroGasLp> ListaLp = new ArrayList();
        String sql = "SELECT * FROM suministrogaslp ";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                suministroGasLp sumLp = new suministroGasLp();
                sumLp.setFecha(rs.getDate("fecha"));//2
                sumLp.setMateriaLp(rs.getString("noMat"));//3
                sumLp.setLitro(rs.getString("litro"));//4
                sumLp.setCosto(rs.getString("costo"));//5
                sumLp.setSubtotal(rs.getString("subtotal"));//6
                sumLp.setHoraEntrada(rs.getString("entrada"));//7
                sumLp.setHoraSalida(rs.getString("salida"));//8
                sumLp.setSeguridad(rs.getString("seg"));//9
                sumLp.setEncargado(rs.getString("encargado"));//10
                sumLp.setChofer(rs.getString("chofer"));//11
                sumLp.setObservacionesG(rs.getString("observacion"));//12
                sumLp.setId(rs.getInt("id"));//13
                ListaLp.add(sumLp);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaLp;
    }

    public Boolean eliminarLp(String id){
        String sql = "DELETE FROM suministrogaslp WHERE id="+ id +"";
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

    public boolean modificarLp(String Fecha, String MateriaLp, String Litro, String Costo, String Subtotal, String HoraEntrada, String HoraSalida, String Seguridad, String Encargado, String Chofer, String ObservacionG, String id){
        String sql = "UPDATE suministrogaslp SET fecha='"+ Fecha +"', noMat='"+ MateriaLp +"', litro='"+ Litro +"', costo='"+ Costo +"', subtotal='"+ Subtotal +"', entrada='"+ HoraEntrada +"', salida='"+ HoraSalida +"', seg='"+ Seguridad +"', encargado='"+ Encargado +"', chofer='"+ Chofer +"', observacion='"+ ObservacionG +"' WHERE id="+ id +"";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
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

    


}
