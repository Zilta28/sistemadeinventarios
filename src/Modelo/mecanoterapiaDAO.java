
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
public class mecanoterapiaDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarMeca(mecanoterapia meca){
        String sql = "INSERT INTO mecanoterapia (materialm, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, meca.getMaterialMeca());
            ps.setDate(2, (Date) meca.getFechaMeca());
            ps.setString(3, meca.getBuenEstadoMeca());
            ps.setString(4, meca.getObservacionesMeca());
            ps.setString(5, meca.getElaboradoMeca());
            ps.setString(6, meca.getRevisadoMeca());
            ps.setString(7, meca.getAprobadoMeca());
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
        public List ListarMeca(){
        List<mecanoterapia> ListaMeca = new ArrayList();
        String sql = "SELECT * FROM mecanoterapia";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                mecanoterapia meca = new mecanoterapia();
                meca.setMaterialMeca(rs.getString("materialm"));
                meca.setFechaMeca(rs.getDate("fecha"));
                meca.setBuenEstadoMeca(rs.getString("chequeoGral"));
                meca.setObservacionesMeca(rs.getString("observacion"));
                meca.setElaboradoMeca(rs.getString("elaborado"));
                meca.setRevisadoMeca(rs.getString("revisado"));
                meca.setAprobadoMeca(rs.getString("aprobado"));
                meca.setId(rs.getInt("id"));//18
                ListaMeca.add(meca);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaMeca;
    }

    public Boolean eliminarMeca(String id){
        String sql = "DELETE FROM mecanoterapia WHERE id="+ id +"";
        System.out.println(sql);
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

    public boolean modificarMeca(String materialMeca, String fechaMeca, String buenEstadoMeca, String observacionesMeca, String elaboradoMeca, String revisadoMeca, String aprobadoMeca, String id){
        String sql = "UPDATE mecanoterapia SET materialm='"+ materialMeca +"', fecha='"+ fechaMeca +"', chequeoGral='"+ buenEstadoMeca +"', observacion='"+ observacionesMeca +"', elaborado='"+ elaboradoMeca +"', revisado='"+ revisadoMeca +"', aprobado='"+ aprobadoMeca +"' WHERE id="+ id +"";
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
