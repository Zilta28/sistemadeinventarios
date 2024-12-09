
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
 * @author Lizbeth Ventura Talón
 */
public class calderaElectroDAO {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    conexionBD con = new conexionBD();
    public boolean RegistrarCalderaE(calderaElectro ce){
        String sql = "INSERT INTO calderaelectromecanico (materialc, fecha, capacidad, unidad, marca, modelo, serie, limpiezaChimenea, limpiezaCenicero, revisionQuemador, limpiezaPiloto, revisionFlama, revisionManometro, revisionValvulas, revisionSistema, medicionAmp, observaciones, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, ce.getMaterialC());
            ps.setDate(2, (Date) ce.getFechaC());
            ps.setString(3, ce.getCapacidadC());
            ps.setString(4, ce.getUnidadC());
            ps.setString(5, ce.getMarcaC());
            ps.setString(6, ce.getModeloC());
            ps.setString(7, ce.getNoSerieC());
            ps.setString(8, ce.getLimpiezaChimeneaC());
            ps.setString(9, ce.getLimpiezaCeniceroC());
            ps.setString(10, ce.getLimpiezaQuemadorC());
            ps.setString(11, ce.getLimpiezaPilotoC());
            ps.setString(12, ce.getRevisionFlamaC());
            ps.setString(13, ce.getRevisionManometroC());
            ps.setString(14, ce.getRevisionValvulasC());
            ps.setString(15, ce.getRevisionSistemaC());
            ps.setString(16, ce.getMedicionAmpC());
            ps.setString(17, ce.getObservacionesC());
            ps.setString(18, ce.getElaboradoC());
            ps.setString(19, ce.getRevisadoC());
            ps.setString(20, ce.getAprobadoC());
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
        public List ListarCalderaE(){
        List<calderaElectro> ListaCalderaE = new ArrayList();
        String sql = "SELECT * FROM calderaelectromecanico";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                calderaElectro ce = new calderaElectro();
                ce.setMaterialC(rs.getString("materialc"));//2
                ce.setFechaC(rs.getDate("fecha"));//3
                ce.setCapacidadC(rs.getString("capacidad"));//4
                ce.setUnidadC(rs.getString("unidad"));//5
                ce.setMarcaC(rs.getString("marca"));//6
                ce.setModeloC(rs.getString("modelo"));//7
                ce.setNoSerieC(rs.getString("serie"));//8
                ce.setLimpiezaChimeneaC(rs.getString("limpiezaChimenea"));//9
                ce.setLimpiezaCeniceroC(rs.getString("limpiezaCenicero"));//10
                ce.setLimpiezaQuemadorC(rs.getString("revisionQuemador"));//11
                ce.setRevisionFlamaC(rs.getString("revisionFlama"));//12
                ce.setLimpiezaPilotoC(rs.getString("limpiezaPiloto"));//13
                ce.setRevisionManometroC(rs.getString("revisionManometro"));//14
                ce.setRevisionValvulasC(rs.getString("revisionValvulas"));//15
                ce.setRevisionSistemaC(rs.getString("revisionSistema"));//16
                ce.setMedicionAmpC(rs.getString("medicionAmp"));//17
                ce.setObservacionesC(rs.getString("observaciones"));//18
                ce.setElaboradoC(rs.getString("elaborado"));//19
                ce.setRevisadoC(rs.getString("revisado"));//20
                ce.setAprobadoC(rs.getString("aprobado"));//21
                ce.setId(rs.getInt("id"));//18
                ListaCalderaE.add(ce);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCalderaE;
    }

    public Boolean eliminarCalderaE(String id){
        String sql = "DELETE FROM calderaelectromecanico WHERE id="+ id +"";
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

    public boolean modificarCalderaE(String materialc ,String fecha ,String capacidad, String unidad, String marca,String modelo, String serie, String limpiezaChimenea, String limpiezaCenicero, String revisionQuemador, String limpiezaPiloto, String revisionFlama ,String revisionManometro, String revisionValvulas, String revisionSistema, String medicionAmp, String observaciones, String elaborado, String revisado, String aprobado, String id){
        String sql = "UPDATE calderaelectromecanico SET materialc='"+ materialc +"', fecha='"+ fecha +"', capacidad='"+ capacidad +"', unidad='"+ unidad +"', marca='"+ marca +"', modelo='"+ modelo +"', serie='"+ serie +"', limpiezaChimenea='"+ limpiezaChimenea +"', limpiezaCenicero='"+ limpiezaCenicero +"', revisionQuemador='"+ revisionQuemador +"', limpiezaPiloto='"+ limpiezaPiloto +"', revisionFlama='"+ revisionFlama +"', revisionManometro='"+ revisionManometro +"', revisionValvulas='"+ revisionValvulas +"', revisionSistema='"+ revisionSistema +"', medicionAmp='"+ medicionAmp +"', observaciones='"+ observaciones +"', elaborado='"+ elaborado +"', revisado='"+ revisado +"', aprobado='"+ aprobado +"' WHERE id="+ id +"";
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
