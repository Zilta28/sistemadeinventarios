
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class gasesMedicinalesDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarGasMedicinal(gasesMedicinales gasM){
        String sql = "INSERT INTO suministro (fecha, tipoGas, presionTanque, reserva, limpieza, name, observacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1, (Date)gasM.getFechaMed());
            ps.setString(2, gasM.getTipoGas());
            ps.setString(3, gasM.getPresionTanque());
            ps.setString(4, gasM.getReserva());
            ps.setString(5, gasM.getLimpieza());
            ps.setString(6, gasM.getNombreRealizoInventario());
            ps.setString(7, gasM.getObservacion());
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
public List ListarGasMed(){
        List<gasesMedicinales> ListaMed = new ArrayList();
        String sql = "SELECT * FROM suministro";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                gasesMedicinales gasM = new gasesMedicinales();
                gasM.setFechaMed(rs.getDate("fecha"));//2
                gasM.setTipoGas(rs.getString("tipoGas"));//3
                gasM.setPresionTanque(rs.getString("presionTanque"));//4
                gasM.setReserva(rs.getString("reserva"));//5
                gasM.setLimpieza(rs.getString("limpieza"));//6
                gasM.setNombreRealizoInventario(rs.getString("name"));//7
                gasM.setObservacion(rs.getString("observacion"));
                gasM.setId(rs.getInt("id"));//18
                ListaMed.add(gasM);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaMed;
}
        public List ListargMed(){
        List<medico> ListaMed = new ArrayList();
        String sql = "SELECT * FROM equipomedico";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                medico med = new medico();
                med.setMaterialMed(rs.getString("materialm"));//2
                med.setFechaMed(rs.getDate("fecha"));//3
                med.setBuenEstadoMed(rs.getString("chequeoGral"));//4
                med.setObservacionesMed(rs.getString("observacion"));//5
                med.setElaboradoMed(rs.getString("elaborado"));//6
                med.setRevisadoMed(rs.getString("revisado"));//7
                med.setAprobadoMed(rs.getString("aprobado"));//8
                med.setId(rs.getInt("id"));//18
                ListaMed.add(med);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaMed;
    }

    public Boolean eliminarGasMed(String id){
        String sql = "DELETE FROM suministro WHERE id="+ id +"";
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

    public boolean modificarGasMed(String FechaMed, String TipoGas, String PresionTanque, String Reserva, String Limpieza, String NombreRealizoInventario, String Observacion, String id){
        String sql = "UPDATE equipomedico SET fecha='"+ FechaMed +"', tipoGas='"+ TipoGas +"', presionTanque='"+ PresionTanque +"', reserva='"+ Reserva +"', limpieza='"+ Limpieza +"', name='"+ NombreRealizoInventario +"', observacion='"+ Observacion +"' WHERE id="+ id +"";
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


