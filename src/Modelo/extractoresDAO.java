
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
public class extractoresDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarExtractor(extractores extra){
        String sql = "INSERT INTO extractoraire (materialex, fecha, marca, modelo, serie, medicionAmp, voltaje, revisionRondamiento, revisionBanda, revisionConexion, revisionTablero, eliminacionRuido, ajusteTornilleria, limpiezaGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, extra.getMaterialEx());
            ps.setDate(2, (Date) extra.getFechaEx());
            ps.setString(3, extra.getMarcaEx());
            ps.setString(4, extra.getModeloEx());
            ps.setString(5, extra.getNoSerieEx());
            ps.setString(6, extra.getAmpEx());
            ps.setString(7, extra.getVoltajeEx());
            ps.setString(8, extra.getRevisionRodaEx());
            ps.setString(9, extra.getRevisionBandaEx());
            ps.setString(10, extra.getRevisionElectricidadEx());
            ps.setString(11, extra.getRevisionTableroEx());
            ps.setString(12, extra.getEliminacionEx());
            ps.setString(13, extra.getAjusteEx());
            ps.setString(14, extra.getLimpiezaEx());
            ps.setString(15, extra.getObservacionesEx());
            ps.setString(17, extra.getElaboradoEx());
            ps.setString(18, extra.getRevisadoEx());
            ps.setString(19, extra.getAprobadoEx());
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
        public List ListarExtrac(){
        List<extractores> ListaEx = new ArrayList();
        String sql = "SELECT * FROM extractoraire";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                extractores extra = new extractores();
                extra.setMaterialEx(rs.getString("materialex"));//2
                extra.setFechaEx(rs.getDate("fecha"));//3
                extra.setMarcaEx(rs.getString("marca"));//4
                extra.setModeloEx(rs.getString("modelo"));//5
                extra.setNoSerieEx(rs.getString("serie"));//6
                extra.setAmpEx(rs.getString("medicionAmp"));//7
                extra.setVoltajeEx(rs.getString("voltaje"));//8
                extra.setRevisionRodaEx(rs.getString("revisionRondamiento"));//9
                extra.setRevisionBandaEx(rs.getString("revisionBanda"));//10
                extra.setRevisionElectricidadEx(rs.getString("revisionConexion"));//11
                extra.setRevisionTableroEx(rs.getString("revisionTablero"));//12
                extra.setEliminacionEx(rs.getString("eliminacionRuido"));//13
                extra.setAjusteEx(rs.getString("ajusteTornilleria"));//14
                extra.setLimpiezaEx(rs.getString("limpiezaGral"));//15
                extra.setObservacionesEx(rs.getString("observacion"));//16
                extra.setElaboradoEx(rs.getString("elaborado"));//17
                extra.setRevisadoEx(rs.getString("revisado"));//18
                extra.setAprobadoEx(rs.getString("aprobado"));//19
                extra.setId(rs.getInt("id"));//18
                ListaEx.add(extra);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaEx;
    }

    public Boolean eliminarExtrac(String id){
        String sql = "DELETE FROM extractoraire WHERE id="+ id +"";
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

    public boolean modificarExtractor(String materialEx, String fechaEx, String marcaEx, String modeloEx, String noSerieEx, String ampEx, String voltajeEx, String revisionRodaEx, String revisionBandaEx, String revisionElectricidadEx, String revisionTableroEx, String eliminacionEx, String ajusteEx, String limpiezaEx, String observacionesEx, String elaboradoEx, String revisadoEx, String aprobadoEx, String id){
        String sql = "UPDATE extractoraire SET materialex='"+ materialEx +"', fecha='"+ fechaEx +"', marca='"+ marcaEx +"', modelo='"+ modeloEx +"', serie='"+ noSerieEx +"', medicionAmp='"+ ampEx +"', voltaje='"+ voltajeEx +"', revisionRondamiento='"+ revisionRodaEx +"', revisionBanda='"+ revisionElectricidadEx +"', revisionConexion='"+ revisionElectricidadEx +"', revisionTablero='"+ revisionTableroEx +"', eliminacionRuido='"+ eliminacionEx +"', ajusteTornilleria='"+ ajusteEx +"', limpiezaGral='"+ limpiezaEx +"', observacion='"+ observacionesEx +"', elaborado='"+ elaboradoEx +"', revisado='"+ revisadoEx +"', aprobado='"+ aprobadoEx +"' WHERE id="+ id +"";
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
