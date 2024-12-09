
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class gasesMedicinalesValoracionDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarGasMedicinalValoracion(gasesMedicinalesValoracion gasMV){
        String sql = "INSERT INTO suministrovaloracion (fecha, tipoGas, dia, presionTanque, reserva, limpieza, name, observacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1,(Date) gasMV.getFechaV());
            ps.setString(2, gasMV.getTipoGasV());
            ps.setString(3, gasMV.getDiaV());
            ps.setString(4, gasMV.getPresionTanqueV());
            ps.setString(5, gasMV.getReservaV());
            ps.setString(6, gasMV.getLimpiezaV());
            ps.setString(7, gasMV.getNombreRealizoInventarioV());
            ps.setString(8, gasMV.getObservacionV());
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
        public List ListarMedValo(){
        List<gasesMedicinalesValoracion> ListaMedV = new ArrayList();
        String sql = "SELECT * FROM suministrovaloracion";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                gasesMedicinalesValoracion gasMV = new gasesMedicinalesValoracion();
                gasMV.setFechaV(rs.getDate("fecha"));//2
                gasMV.setTipoGasV(rs.getString("tipoGas"));//3
                gasMV.setDiaV(rs.getString("dia"));//4
                gasMV.setPresionTanqueV(rs.getString("presionTanque"));//5
                gasMV.setReservaV(rs.getString("reserva"));//6
                gasMV.setLimpiezaV(rs.getString("limpieza"));//7
                gasMV.setNombreRealizoInventarioV(rs.getString("name"));//8
                gasMV.setObservacionV(rs.getString("observacion"));
                gasMV.setId(rs.getInt("id"));//18
                ListaMedV.add(gasMV);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaMedV;
    }

    public Boolean eliminarMedV(String id){
        String sql = "DELETE FROM suministrovaloracion WHERE id="+ id +"";
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

    public boolean modificarMedicoValoracion(String FechaV, String TipoGasV, String DiaV, String PresionTanqueV, String ReservaV, String LimpiezaV, String NombreRealizoInventarioV, String ObservacionV, String id){
        String sql = "UPDATE suministrovaloracion SET fecha='"+ FechaV +"', tipoGas='"+ TipoGasV +"', dia='"+ DiaV +"', presionTanque='"+ PresionTanqueV +"', reserva='"+ ReservaV +"', limpieza='"+ LimpiezaV +"', name='"+ NombreRealizoInventarioV +"', observacion='"+ ObservacionV +"' WHERE id="+ id +"";
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
