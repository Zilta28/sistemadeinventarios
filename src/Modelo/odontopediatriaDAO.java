
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
 * @author Lizbeth
 */
public class odontopediatriaDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarOdon(odontopediatria odo){
        String sql = "INSERT INTO odontopediatria (materialo, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, odo.getMaterialOdo());
            ps.setDate(2, (Date) odo.getFechaOdo());
            ps.setString(3, odo.getBuenEstadoOdo());
            ps.setString(4, odo.getObservacionesOdo());
            ps.setString(5, odo.getElaboradoOdo());
            ps.setString(6, odo.getRevisadoOdo());
            ps.setString(7, odo.getAprobadoOdo());
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
        public List ListarOdo(){
        List<odontopediatria> ListaOdo = new ArrayList();
        String sql = "SELECT * FROM odontopediatria";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                odontopediatria odo = new odontopediatria();
                odo.setMaterialOdo(rs.getString("materialo"));//2
                odo.setFechaOdo(rs.getDate("fecha"));//3
                odo.setBuenEstadoOdo(rs.getString("chequeoGral"));//4
                odo.setObservacionesOdo(rs.getString("observacion"));//5
                odo.setElaboradoOdo(rs.getString("elaborado"));//6
                odo.setRevisadoOdo(rs.getString("revisado"));//7
                odo.setAprobadoOdo(rs.getString("aprobado"));//8
                odo.setId(rs.getInt("id"));//18
                ListaOdo.add(odo);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaOdo;
    }

    public Boolean eliminarOdo(String id){
        String sql = "DELETE FROM odontopediatria WHERE id="+ id +"";
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

    public boolean modificarOdon(String materialOdo, String fechaOdo, String buenEstadoOd, String observacionesOdo, String elaboradoOdo, String revisadoOdo, String aprobadoOdo, String id){
        String sql = "UPDATE odontopediatria SET materialo='"+ materialOdo +"', fecha='"+ fechaOdo +"', chequeoGral='"+ buenEstadoOd +"', observacion='"+ observacionesOdo +"', elaborado='"+ elaboradoOdo +"', revisado='"+ revisadoOdo +"', aprobado='"+ aprobadoOdo +"' WHERE id="+ id +"";
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
