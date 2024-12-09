
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
 * @author yanni
 */
public class medicoDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarMedico(medico med){
        String sql = "INSERT INTO equipomedico (materialm, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, med.getMaterialMed());
            ps.setDate(2, (Date) med.getFechaMed());
            ps.setString(3, med.getBuenEstadoMed());
            ps.setString(4, med.getObservacionesMed());
            ps.setString(5, med.getElaboradoMed());
            ps.setString(6, med.getRevisadoMed());
            ps.setString(7, med.getAprobadoMed());
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
        public List ListarMed(){
        List<medico> ListaMed = new ArrayList();
        String sql = "SELECT * FROM equipomedico";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                medico med = new medico();
                med.setMaterialMed(rs.getString("materialm"));//2
                med.setFechaMed(rs.getDate("fecha"));//3
                med.setBuenEstadoMed(rs.getString("chequeoGral"));//4
                med.setObservacionesMed(rs.getString("observacion"));//5
                med.setElaboradoMed(rs.getString("elaborado"));//6
                med.setRevisadoMed(rs.getString("revisado"));//7
                med.setAprobadoMed(rs.getString("aprobado"));//8
                med.setId(rs.getInt("id"));//18
                ListaMed.add(med);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaMed;
    }

    public Boolean eliminarMed(String id){
        String sql = "DELETE FROM equipomedico WHERE id="+ id +"";
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

    public boolean modificarMedico(String materialMed, String fechaMed, String buenEstadoMed, String observacionesMed, String elaboradoMed, String revisadoMed, String aprobadoMed, String id){
        String sql = "UPDATE equipomedico SET materialm='"+ materialMed +"', fecha='"+ fechaMed +"', chequeoGral='"+ buenEstadoMed +"', observacion='"+ observacionesMed +"', elaborado='"+ elaboradoMed +"', revisado='"+ revisadoMed +"', aprobado='"+ aprobadoMed +"' WHERE id="+ id +"";
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
