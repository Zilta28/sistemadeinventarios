
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
public class enfermeriaDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarEnf(enfermeria enf){
        String sql = "INSERT INTO enfermeria (materialenf, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, enf.getMaterialEnf());
            ps.setDate(2, (Date) enf.getFechaEnf());
            ps.setString(3, enf.getBuenEstadoEnf());
            ps.setString(4, enf.getObservacionesEnf());
            ps.setString(5, enf.getElaboradoEnf());
            ps.setString(6, enf.getRevisadoEnf());
            ps.setString(7, enf.getAprobadoEnf());
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
        public List ListarEnf(){
        List<enfermeria> ListaEnf = new ArrayList();
        String sql = "SELECT * FROM enfermeria";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                enfermeria enf = new enfermeria();
                enf.setMaterialEnf(rs.getString("materialenf"));//2
                enf.setFechaEnf(rs.getDate("fecha"));//3
                enf.setBuenEstadoEnf(rs.getString("chequeoGral"));//4
                enf.setObservacionesEnf(rs.getString("observacion"));//5
                enf.setElaboradoEnf(rs.getString("elaborado"));//6
                enf.setRevisadoEnf(rs.getString("revisado"));//7
                enf.setAprobadoEnf(rs.getString("aprobado"));//8
                enf.setId(rs.getInt("id"));//18
                ListaEnf.add(enf);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaEnf;
    }
    public Boolean eliminarEnf(String id){
        String sql = "DELETE FROM enfermeria WHERE id="+ id +"";
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

    public boolean modificararEnf(String materialEnf, String fechaEnf, String buenEstadoEnf, String observacionesEnf, String elaboradoEnf, String revisadoEnf, String aprobadoEnf, String id){
        String sql = "UPDATE enfermeria SET materialenf='"+ materialEnf +"', fecha='"+ fechaEnf +"', chequeoGral='"+ buenEstadoEnf +"', observacion='"+ observacionesEnf +"', elaborado='"+ elaboradoEnf +"', revisado='"+ revisadoEnf +"', aprobado='"+ aprobadoEnf +"' WHERE id="+ id +"";
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
