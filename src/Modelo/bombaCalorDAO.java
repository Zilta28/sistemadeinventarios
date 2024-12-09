
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
 * @author Lizbeth Ventura
 */
public class bombaCalorDAO {
    Connection cn;
    PreparedStatement ps;
    ResultSet rs;
    conexionBD con = new conexionBD();
    public boolean RegistrarBombaCalor(bombaCalor bc){

        String sql = "INSERT INTO bombacalor (materialb, fecha, capacidad, unidad, marca, modelo, serie, lavadoAguaPresion, lavadoCondensador, revisionMotor, revisionCompresor, medicionAmp, cambioTerminales, pintura, revisionValvulasAgua, revisionFugas, revisionSisRefrigerante, medicionPresion, revisionControl, observaciones, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, bc.getMaterialBC());
            ps.setDate(2, (Date) bc.getFechaBC());
            ps.setString(3, bc.getCapacidadBC());
            ps.setString(4, bc.getUnidadBC());
            ps.setString(5, bc.getMarcaBC());
            ps.setString(6, bc.getModeloBC());
            ps.setString(7, bc.getNoSerieBC());
            ps.setString(8, bc.getLavadoPresionBC());
            ps.setString(9, bc.getLavadoCondensadorBC());
            ps.setString(10, bc.getRevisionMotorBC());
            ps.setString(11, bc.getRevisionCompresorBC());
            ps.setString(12, bc.getMedicionAmpBC());
            ps.setString(13, bc.getCambioTerminalesBC());
            ps.setString(14, bc.getPinturaBC());
            ps.setString(15, bc.getRevisionValvulas());
            ps.setString(16, bc.getRevisionFugas());
            ps.setString(17, bc.getRevisionRefrigeranteBC());
            ps.setString(18, bc.getMedicionPresionBC());
            ps.setString(19, bc.getRevisionControlBC());
            ps.setString(20, bc.getObservacionesBC());
            ps.setString(21, bc.getElaboradoBC());
            ps.setString(22, bc.getRevisadoBC());
            ps.setString(23, bc.getAprobadoBC());
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
        public List ListarBombaCalor(){
        List<bombaCalor> ListaBombaCalor = new ArrayList();
        String sql = "SELECT * FROM bombacalor";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                bombaCalor bc = new bombaCalor();
                bc.setMaterialBC(rs.getString("materialb"));
                bc.setFechaBC(rs.getDate("fecha"));
                bc.setCapacidadBC(rs.getString("capacidad"));
                bc.setUnidadBC(rs.getString("unidad"));
                bc.setMarcaBC(rs.getString("marca"));
                bc.setModeloBC(rs.getString("modelo"));
                bc.setNoSerieBC(rs.getString("serie"));
                bc.setLavadoPresionBC(rs.getString("lavadoAguaPresion"));
                bc.setLavadoCondensadorBC(rs.getString("lavadoCondensador"));
                bc.setRevisionMotorBC(rs.getString("revisionMotor"));
                bc.setRevisionCompresorBC(rs.getString("revisionCompresor"));
                bc.setMedicionAmpBC(rs.getString("medicionAmp"));
                bc.setCambioTerminalesBC(rs.getString("cambioTerminales"));
                bc.setPinturaBC(rs.getString("pintura"));
                bc.setRevisionValvulas(rs.getString("revisionValvulasAgua"));
                bc.setRevisionFugas(rs.getString("revisionFugas"));
                bc.setRevisionRefrigeranteBC(rs.getString("revisionSisRefrigerante"));
                bc.setMedicionPresionBC(rs.getString("medicionPresion"));
                bc.setRevisionControlBC(rs.getString("revisionControl"));
                bc.setObservacionesBC(rs.getString("observaciones"));
                bc.setElaboradoBC(rs.getString("elaborado"));
                bc.setRevisadoBC(rs.getString("revisado"));
                bc.setAprobadoBC(rs.getString("aprobado"));
                bc.setId(rs.getInt("id"));//18
                ListaBombaCalor.add(bc);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaBombaCalor;
    }

    public Boolean eliminarBombaCalor(String id){
        String sql = "DELETE FROM bombacalor WHERE id="+ id +"";
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

    public boolean modificarBombaCalor(String materialb, String fecha, String capacidad, String unidad, String marca, String modelo, String serie, String lavadoAguaPresion, String lavadoCondensador, String revisionMotor, String revisionCompresor, String medicionAmp, String cambioTerminales, String pintura, String revisionValvulasAgua, String revisionFugas, String revisionSisRefrigerante, String medicionPresion, String revisionControl, String observaciones, String elaborado, String revisado, String aprobado, String id){

        String sql = "UPDATE  bombacalor  SET  materialb ='"+materialb+"', fecha ='"+fecha+"', capacidad ='"+capacidad+"', unidad ='"+unidad+"', marca ='"+marca+"', modelo ='"+modelo+"', serie ='"+serie+"', lavadoAguaPresion ='"+lavadoAguaPresion+"', lavadoCondensador ='"+lavadoCondensador+"', revisionMotor ='"+revisionMotor+"', revisionCompresor ='"+revisionCompresor+"', medicionAmp ='"+medicionAmp+"', cambioTerminales ='"+cambioTerminales+"', pintura ='"+pintura+"', revisionValvulasAgua ='"+revisionValvulasAgua+"', revisionFugas ='"+revisionFugas+"', revisionSisRefrigerante ='"+revisionSisRefrigerante+"', medicionPresion ='"+medicionPresion+"', revisionControl ='"+revisionControl+"', observaciones ='"+observaciones+"', elaborado ='"+elaborado+"', revisado ='"+revisado+"', aprobado ='"+aprobado+"' WHERE id="+ id +"";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            System.out.println(sql);
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
