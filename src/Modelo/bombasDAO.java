
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
public class bombasDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarBombas(bombas bom){
        String sql = "INSERT INTO bombas (materialb, fecha, chequeoRondamiento, selloMecanico, amp, temperatura, aprieteTC, accionamiento, pintura, revisionManometro, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, bom.getMaterialBom());
            ps.setDate(2, (Date) bom.getFechaBom());
            ps.setString(3, bom.getRodamientoBom());
            ps.setString(5, bom.getSelloBom());
            ps.setString(6, bom.getAmpBom());
            ps.setString(7, bom.getTempBom());
            ps.setString(8, bom.getTerminalesBom());
            ps.setString(9, bom.getAccionamientoBom());
            ps.setString(10, bom.getPinturaBom());
            ps.setString(11, bom.getManometroBom());
            ps.setString(12, bom.getElaboradoBom());
            ps.setString(13, bom.getRevisadoBom());
            ps.setString(14, bom.getAprobadoBom());
            ps.setString(15, bom.getObservacionesBom());
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
        public List ListarBom(){
        List<bombas> ListaBom = new ArrayList();
        String sql = "SELECT * FROM bombas";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                bombas bom = new bombas();
                bom.setMaterialBom(rs.getString("materialb"));//2
                bom.setFechaBom(rs.getDate("fecha"));//3
                bom.setRodamientoBom(rs.getString("chequeoRondamiento"));//4
                bom.setSelloBom(rs.getString("selloMecanico"));//5
                bom.setAmpBom(rs.getString("amp"));//6
                bom.setTempBom(rs.getString("temperatura"));//7
                bom.setTerminalesBom(rs.getString("aprieteTC"));//8
                bom.setAccionamientoBom(rs.getString("accionamiento"));//9
                bom.setPinturaBom(rs.getString("pintura"));//10
                bom.setManometroBom(rs.getString("revisionManometro"));//11
                bom.setObservacionesBom(rs.getString("observacion"));//15
                bom.setElaboradoBom(rs.getString("elaborado"));//13
                bom.setRevisadoBom(rs.getString("revisado"));//14
                bom.setAprobadoBom(rs.getString("aprobado"));//15
                bom.setId(rs.getInt("id"));//18
                ListaBom.add(bom);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaBom;
    }

    public Boolean eliminarBom(String id){
        String sql = "DELETE FROM bombas WHERE id="+ id +"";
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

    public boolean modificarBombas(String materialBom, String fechaBom, String rodamientoBom, String selloBom, String ampBom, String tempBom, String terminalesBom, String accionamientoBom, String pinturaBom, String manometroBom, String elaboradoBom, String revisadoBom, String aprobadoBom, String observacionesBom, String id){
        String sql = "UPDATE bombas SET materialb='"+ materialBom +"', fecha='"+ fechaBom +"', chequeoRondamiento='"+ rodamientoBom +"', selloMecanico='"+ selloBom +"', amp='"+ ampBom +"', temperatura='"+ tempBom +"', aprieteTC='"+ terminalesBom +"', accionamiento='"+ accionamientoBom +"', pintura='"+ pinturaBom +"', revisionManometro='"+ manometroBom +"', observacion='"+ observacionesBom +"', elaborado='"+ elaboradoBom +"', revisado='"+ revisadoBom +"', aprobado='"+ aprobadoBom +"' WHERE id="+ id +"";
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
