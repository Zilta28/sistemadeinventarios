
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
public class dosificadorDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarDosi(dosificador dosi){
        String sql = "INSERT INTO dosificadoragua(materiald, fecha, chequeoSellado, chequeoFuga, chequeoCableado, limpiezaExterior, limpiezaInterior, limpiezaEvaporador, medicionAmp, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, dosi.getMaterialDosi());
            ps.setDate(2, (Date) dosi.getFechaDosi());
            ps.setString(3, dosi.getSelladoDosi());
            ps.setString(4, dosi.getFugasDosi());
            ps.setString(5, dosi.getCableadoDosi());
            ps.setString(6, dosi.getLimpiezaExtDosi());
            ps.setString(7, dosi.getLimpiezaIntDosi());
            ps.setString(8, dosi.getLimpiezaEvaDosi());
            ps.setString(9, dosi.getMedicionAmpDosi());
            ps.setString(10, dosi.getObservacionesDosi());
            ps.setString(11, dosi.getElaboradoDosi());
            ps.setString(12, dosi.getRevisadoDosi());
            ps.setString(13, dosi.getAprobadoDosi());
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
        public List ListarDosif(){
        List<dosificador> ListaDosi = new ArrayList();
        String sql = "SELECT * FROM dosificadoragua";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                dosificador dosi = new dosificador();
                dosi.setMaterialDosi(rs.getString("materiald"));//2
                dosi.setFechaDosi(rs.getDate("fecha"));//3
                dosi.setSelladoDosi(rs.getString("chequeoSellado"));//4
                dosi.setFugasDosi(rs.getString("chequeoFuga"));//5
                dosi.setCableadoDosi(rs.getString("chequeoCableado"));//6
                dosi.setLimpiezaExtDosi(rs.getString("limpiezaExterior"));//7
                dosi.setLimpiezaIntDosi(rs.getString("limpiezaInterior"));//8
                dosi.setLimpiezaEvaDosi(rs.getString("limpiezaEvaporador"));//9
                dosi.setMedicionAmpDosi(rs.getString("medicionAmp"));//10
                dosi.setObservacionesDosi(rs.getString("observacion"));//11
                dosi.setElaboradoDosi(rs.getString("elaborado"));//12
                dosi.setRevisadoDosi(rs.getString("revisado"));//13
                dosi.setAprobadoDosi(rs.getString("aprobado"));//14
                dosi.setId(rs.getInt("id"));//18
                ListaDosi.add(dosi);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaDosi;
    }

    public Boolean eliminarDosif(String id){
        String sql = "DELETE FROM dosificadoragua WHERE id="+ id +"";
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

    public boolean modificarDosi(String materialDosi, String fechaDosi, String selladoDosi, String fugasDosi, String cableadoDosi, String limpiezaExtDosi, String limpiezaIntDosi, String limpiezaEvaDosi, String medicionAmpDosi, String observacionesDosi, String elaboradoDosi, String revisadoDosi, String aprobadoDosi, String id){
        String sql = "UPDATE dosificadoragua SET materiald='"+ materialDosi +"', fecha='"+ fechaDosi +"', chequeoSellado='"+ selladoDosi +"', chequeoFuga='"+ fugasDosi +"', chequeoCableado='"+ limpiezaExtDosi +"', limpiezaExterior='"+ limpiezaIntDosi +"', limpiezaInterior='"+ limpiezaEvaDosi +"', limpiezaEvaporador='"+ limpiezaEvaDosi +"', medicionAmp='"+ medicionAmpDosi +"', observacion='"+ observacionesDosi +"', elaborado='"+ elaboradoDosi +"', revisado='"+ revisadoDosi +"', aprobado='"+ aprobadoDosi +"' WHERE id="+ id +"";
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
