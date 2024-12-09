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
public class compresionElectroDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarCompresion(compresionElectro com){
        String sql = "INSERT INTO compresoraire (materialcom, fecha, capacidad, unidad, marca, modelo, serie, medicionAmp, medicionPresion, medicionSistema, limpiezaGral, revisionAceite, pintura, revisionPurgado, revisionTerminales, observaciones, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, com.getMaterialCom());
            ps.setDate(2, (Date) com.getFechaCom());
            ps.setString(3, com.getCapacidadCom());
            ps.setString(4, com.getUnidadCom());
            ps.setString(5, com.getMarcaCom());
            ps.setString(6, com.getModeloCom());
            ps.setString(7, com.getNoSerieCom());
            ps.setString(8, com.getMedicionAmpCom());
            ps.setString(9, com.getMedicionPresionCom());
            ps.setString(10, com.getMedicionSistemaCom());
            ps.setString(11, com.getLimpiezaGralCom());
            ps.setString(12, com.getRevisionAceiteCom());
            ps.setString(13, com.getPinturaCom());
            ps.setString(14, com.getRevisionPurgadoCom());
            ps.setString(15, com.getRevisionTerminalCom());
            ps.setString(16, com.getObservacionesCom());
            ps.setString(17, com.getElaboradoCom());
            ps.setString(18, com.getRevisadoCom());
            ps.setString(19, com.getAprobadoCom());
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
        public List ListarCompresion(){
        List<compresionElectro> ListaCom = new ArrayList();
        String sql = "SELECT * FROM compresoraire";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                compresionElectro com = new compresionElectro();
                com.setMaterialCom(rs.getString("materialcom"));//2
                com.setFechaCom(rs.getDate("fecha"));//3
                com.setCapacidadCom(rs.getString("capacidad"));//4
                com.setUnidadCom(rs.getString("unidad"));//5
                com.setMarcaCom(rs.getString("marca"));//6
                com.setModeloCom(rs.getString("modelo"));//7
                com.setNoSerieCom(rs.getString("serie"));//8
                com.setMedicionAmpCom(rs.getString("medicionAmp"));//9
                com.setMedicionPresionCom(rs.getString("medicionPresion"));//10
                com.setMedicionSistemaCom(rs.getString("medicionSistema"));//11
                com.setLimpiezaGralCom(rs.getString("limpiezaGral"));//12
                com.setRevisionAceiteCom(rs.getString("revisionAceite"));//13
                com.setPinturaCom(rs.getString("pintura"));//14
                com.setRevisionPurgadoCom(rs.getString("revisionPurgado"));//15
                com.setRevisionTerminalCom(rs.getString("revisionTerminales"));//16
                com.setObservacionesCom(rs.getString("observaciones"));//17
                com.setElaboradoCom(rs.getString("Elaborado"));//19
                com.setRevisadoCom(rs.getString("revisado"));//19
                com.setAprobadoCom(rs.getString("aprobado"));//20
                com.setId(rs.getInt("id"));//18
                ListaCom.add(com);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaCom;
    }

    public Boolean eliminarCompresion(String id){
        String sql = "DELETE FROM compresoraire WHERE id="+ id +"";
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

    public boolean modificarCompresion(String materialcom,String fecha,String capacidad,String unidad,String marca,String modelo,String serie,String medicionAmp,String medicionPresion,String medicionSistema,String limpiezaGral,String revisionAceite,String pintura,String revisionPurgado,String revisionTerminales,String observaciones,String elaborado,String revisado,String aprobado, String id){
        String sql = "UPDATE compresoraire SET materialcom='"+ materialcom +"', fecha='"+ fecha +"', capacidad='"+ capacidad +"', unidad='"+ unidad +"', marca='"+ marca +"', modelo='"+ modelo +"', serie='"+ serie +"', medicionAmp='"+ medicionAmp +"', medicionPresion='"+ medicionPresion +"', medicionSistema='"+ medicionSistema +"', limpiezaGral='"+ limpiezaGral +"', revisionAceite='"+ revisionAceite +"', pintura='"+ pintura +"', revisionPurgado='"+ revisionPurgado +"', revisionTerminales='"+ revisionTerminales +"', observaciones='"+ observaciones +"', elaborado='"+ elaborado +"', revisado='"+ revisado +"', aprobado='"+ aprobado +"' WHERE id="+ id +"";
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
