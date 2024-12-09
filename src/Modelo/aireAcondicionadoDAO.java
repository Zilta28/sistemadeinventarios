
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
public class aireAcondicionadoDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarAire(aireAcondicionado aa){
        String sql = "INSERT INTO aireacondicionado (materiala, fecha, limpiezaSerpetines, limpiezaFiltroAire, revisionFugas, medicionPresion, medicionAmp, aprieteTornilleria, pintura, limpiezaPanelControl, lubricacion, verificarVentilador, destaparDrenes, limpiezaEvaporador, observaciones, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, aa.getMaterialAire());
            ps.setDate(2, (Date) aa.getFechaAire());
            ps.setString(3, aa.getLimpiezaSerAire());
            ps.setString(4, aa.getLimpiezaFiltroAire());
            ps.setString(5, aa.getRevisionFugaAire());
            ps.setString(6, aa.getMedicionPresionAire());
            ps.setString(7, aa.getMedicionAmpAire());
            ps.setString(8, aa.getTornilleriaAire());
            ps.setString(9, aa.getPinturaAire());
            ps.setString(10, aa.getLimpiezaPanelControl());
            ps.setString(11, aa.getLubricacionAire());
            ps.setString(12, aa.getVerificarAire());
            ps.setString(13, aa.getDestaparDrenesAire());
            ps.setString(14, aa.getLimpiezaEvaporadorAire());
            ps.setString(15, aa.getObservacionesAire());
            ps.setString(16, aa.getElaboradoAire());
            ps.setString(17, aa.getRevisadoAire());
            ps.setString(18, aa.getAprobadoAire());
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
        public List ListarAireAcondicionado(){
        List<aireAcondicionado> ListaAire = new ArrayList();
        String sql = "SELECT * FROM aireacondicionado";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                aireAcondicionado aa = new aireAcondicionado();
                aa.setMaterialAire(rs.getString("materiala"));//2
                aa.setFechaAire(rs.getDate("fecha"));//3
                aa.setLimpiezaSerAire(rs.getString("limpiezaSerpetines"));//4
                aa.setLimpiezaFiltroAire(rs.getString("limpiezaFiltroAire"));//5
                aa.setRevisionFugaAire(rs.getString("revisionFugas"));//6
                aa.setMedicionPresionAire(rs.getString("medicionPresion"));//7
                aa.setMedicionAmpAire(rs.getString("medicionAmp"));//8
                aa.setTornilleriaAire(rs.getString("aprieteTornilleria"));//9
                aa.setPinturaAire(rs.getString("Pintura"));//10
                aa.setLimpiezaPanelControl(rs.getString("limpiezaPanelControl"));
                aa.setLubricacionAire(rs.getString("lubricacion"));//11
                aa.setVerificarAire(rs.getString("verificarVentilador"));//12
                aa.setDestaparDrenesAire(rs.getString("destaparDrenes"));//13
                aa.setLimpiezaSerAire(rs.getString("limpiezaEvaporador"));//14
                aa.setObservacionesAire(rs.getString("observaciones"));//15
                aa.setElaboradoAire(rs.getString("elaborado"));//16
                aa.setRevisadoAire(rs.getString("revisado"));//17
                aa.setAprobadoAire(rs.getString("aprobado"));//18
                aa.setId(rs.getInt("id"));//1
                ListaAire.add(aa);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaAire;
    }

    public Boolean eliminarAcondicionado(String id){
        String sql = "DELETE FROM aireacondicionado WHERE id="+ id +"";
        try{
            ps = cn.prepareStatement(sql);
            ps.execute();
            System.out.println(sql);
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

    public boolean modficarAire(String materialAire, String fechaAire, String limpiezaSerAire, String limpiezaFiltroAire, String revisionFugaAire, String medicionPresionAire, String medicionAmpAire, String tornilleriaAire, String pinturaAire, String limpiezaPanelControl, String lubricacionAire, String verificarAire, String destaparDrenesAire, String limpiezaEvaporadorAire, String observacionesAire, String elaboradoAire, String revisadoAire, String aprobadoAire, String id){
        String sql = "UPDATE aireacondicionado SET materiala='"+ materialAire +"', fecha='"+ fechaAire +"', limpiezaSerpetines='"+ limpiezaSerAire +"', limpiezaFiltroAire='"+ limpiezaFiltroAire +"', revisionFugas='"+ revisionFugaAire +"', medicionPresion='"+ medicionPresionAire +"', medicionAmp='"+ medicionAmpAire +"', aprieteTornilleria='"+ tornilleriaAire +"', pintura='"+ pinturaAire +"', limpiezaPanelControl='"+ limpiezaPanelControl +"', lubricacion='"+ lubricacionAire +"', verificarVentilador='"+ verificarAire +"', destaparDrenes='"+ destaparDrenesAire +"', limpiezaEvaporador='"+ limpiezaEvaporadorAire +"', observaciones='"+ observacionesAire +"', elaborado='"+ elaboradoAire +"', revisado='"+ revisadoAire +"', aprobado='"+ aprobadoAire +"' WHERE id="+ id +"";
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
