
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
public class refrigeradoresDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarRefri(refrigeradores ref){
        String sql = "INSERT INTO refrigerador (materialref, fecha, chequeoSellado, chequeoFuga, chequeoCableado, limpiezaExterior, limpiezaInterior, limpiezaEvaporador, medicionAmp, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, ref.getMaterialRefri());
            ps.setDate(2, (Date) ref.getFechaRefri());
            ps.setString(3, ref.getSelladoRefri());
            ps.setString(4, ref.getFugasRefri());
            ps.setString(5, ref.getCableadoRefri());
            ps.setString(6, ref.getLimpiezaExtRefri());
            ps.setString(7, ref.getLimpiezaIntRefri());
            ps.setString(8, ref.getLimpiezaEvaRefri());
            ps.setString(9, ref.getMedicionAmpRefri());
            ps.setString(10, ref.getObservacionesRefri());
            ps.setString(11, ref.getElaboradoRefri());
            ps.setString(12, ref.getRevisadoRefri());
            ps.setString(13, ref.getAprobadoRefri());
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
        public List ListarRefri(){
        List<refrigeradores> ListaRefris = new ArrayList();
        String sql = "SELECT * FROM refrigerador";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                refrigeradores ref = new refrigeradores();
                ref.setMaterialRefri(rs.getString("materialref"));//2
                ref.setFechaRefri(rs.getDate("fecha"));//3
                ref.setSelladoRefri(rs.getString("chequeoSellado"));//4
                ref.setFugasRefri(rs.getString("chequeoFuga"));//5
                ref.setCableadoRefri(rs.getString("chequeoCableado"));//6
                ref.setLimpiezaExtRefri(rs.getString("limpiezaExterior"));//7
                ref.setLimpiezaIntRefri(rs.getString("limpiezaInterior"));//8
                ref.setLimpiezaEvaRefri(rs.getString("limpiezaEvaporador"));//9
                ref.setMedicionAmpRefri(rs.getString("medicionAmp"));//10
                ref.setObservacionesRefri(rs.getString("observacion"));//14
                ref.setElaboradoRefri(rs.getString("elaborado"));//11
                ref.setRevisadoRefri(rs.getString("revisado"));//12
                ref.setAprobadoRefri(rs.getString("aprobado"));//13
                ref.setId(rs.getInt("id"));//18
                ListaRefris.add(ref);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaRefris;
    }

    public Boolean eliminarRefri(String id){
        String sql = "DELETE FROM refrigerador WHERE id="+ id +"";
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

    public boolean modificarRefri(String materialRefri, String fechaRefri, String selladoRefri, String fugasRefri, String cableadoRefri, String limpiezaExtRefri, String limpiezaIntRefri, String limpiezaEvaRefri, String medicionAmpRefri, String observacionesRefri, String elaboradoRefri, String revisadoRefri, String aprobadoRefri, String id){
        String sql = "UPDATE refrigerador SET materialref='"+ materialRefri +"', fecha='"+ fechaRefri +"', chequeoSellado='"+ selladoRefri +"', chequeoFuga='"+ fugasRefri +"', chequeoCableado='"+ cableadoRefri +"', limpiezaExterior='"+ limpiezaExtRefri +"', limpiezaInterior='"+ limpiezaIntRefri +"', limpiezaEvaporador='"+ limpiezaIntRefri +"', medicionAmp='"+ medicionAmpRefri +"', observacion='"+ observacionesRefri +"', elaborado='"+ elaboradoRefri +"', revisado='"+ revisadoRefri +"', aprobado='"+ aprobadoRefri +"' WHERE id="+ id +"";
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
