
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
 * @author lizbeth Ventura Talón
 * Licenciatura en Ciencias Computacionales
 */
public class electricidadDAO {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    conexionBD con = new conexionBD();
    public boolean RegistrarElectricidad(electricidad el){
        String sql = "INSERT INTO electricidade (material,fecha, capacidadEl, unidadEl,	marcaEl, noSerieEl, cambioAceite, cambioRefrigerante, cambioFiltroAire,	cambioFiltroDiesel, cambioFiltroAceite, cambioFiltroRefrigerante, limpiezaGral,	observaciones, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, el.getMatElectricidad());
            ps.setDate(2, (Date) el.getFechaElec());
            ps.setString(3, el.getCapacidadElec());
            ps.setString(4, el.getUnidadElec());
            ps.setString(5, el.getMarcaElec());
            ps.setString(6, el.getNoSerieElec());
            ps.setString(7, el.getCambioAceiteElec());
            ps.setString(8, el.getCambioRefrigeranteElec());
            ps.setString(9, el.getCambioFiltroDElec());
            ps.setString(10, el.getCambioFiltroAElec());
            ps.setString(11, el.getCambioFiltroAceite());
            ps.setString(12, el.getCambioFiltroRefri());
            ps.setString(13, el.getLimpiezaGElec());
            ps.setString(14, el.getObservacionesElec());
            ps.setString(15, el.getElaboradoElec());
            ps.setString(16, el.getRevisadoElec());
            ps.setString(17, el.getAprobadoElec());
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
        public List ListarElectricidad(){
        List<electricidad> ListaElec = new ArrayList();
        String sql = "SELECT * FROM electricidade";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                electricidad el = new electricidad();
                el.setMatElectricidad(rs.getString("material"));//2
                el.setFechaElec(rs.getDate("fecha"));//3
                el.setCapacidadElec(rs.getString("capacidadEl"));//4
                el.setUnidadElec(rs.getString("unidadEl"));//5
                el.setMarcaElec(rs.getString("marcaEl"));//6
                el.setNoSerieElec(rs.getString("noSerieEl"));//7
                el.setCambioAceiteElec(rs.getString("cambioAceite"));//8
                el.setCambioRefrigeranteElec(rs.getString("cambioRefrigerante"));//9
                el.setCambioFiltroAElec(rs.getString("cambioFiltroAire"));//10
                el.setCambioFiltroDElec(rs.getString("cambioFiltroDiesel"));//11
                el.setCambioFiltroAceite(rs.getString("cambioFiltroAceite"));//12
                el.setCambioFiltroRefri(rs.getString("cambioFiltroRefrigerante"));//13
                el.setLimpiezaGElec(rs.getString("limpiezaGral"));//14
                el.setObservacionesElec(rs.getString("observaciones"));//15
                el.setElaboradoElec(rs.getString("elaborado"));//16
                el.setRevisadoElec(rs.getString("revisado"));//17
                el.setAprobadoElec(rs.getString("aprobado"));//18
                el.setId(rs.getInt("id"));//18
                ListaElec.add(el);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaElec;
    }

    public Boolean eliminarElectricidad(String id){
        String sql = "DELETE FROM electricidade WHERE id="+ id +"";
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

   public boolean modificarElectricidad(String matElect, String fecha, String capacidad, String unidad, String MarcaElec, String NoSerieElec, String CambioAceiteElec, String CambioRefrigeranteElec, String CambioFiltroDElec, String CambioFiltroAElec, String CambioFiltroAceite, String CambioFiltroRefri, String LimpiezaGElec, String ObservacionesElec, String ElaboradoElec, String RevisadoElec, String AprobadoElec, String id){
       String sql = "UPDATE electricidade SET material='"+ matElect +"',fecha='"+ fecha +"', capacidadEl='"+capacidad+"', unidadEl='"+unidad+"', marcaEl='"+MarcaElec+"', noSerieEl='"+NoSerieElec+"', cambioAceite='"+CambioAceiteElec+"', cambioRefrigerante='"+CambioRefrigeranteElec+"', cambioFiltroAire='"+CambioFiltroAElec+"', cambioFiltroDiesel='"+CambioFiltroDElec+"', cambioFiltroAceite='"+CambioFiltroAElec+"', cambioFiltroRefrigerante='"+CambioFiltroRefri+"', limpiezaGral='"+LimpiezaGElec+"', observaciones='"+ObservacionesElec+"', elaborado='"+ElaboradoElec+"', revisado='"+RevisadoElec+"', aprobado='"+AprobadoElec+"' WHERE id="+ id +"";
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
