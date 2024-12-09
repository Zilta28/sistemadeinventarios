
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class sistemaContraincendioDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarSistemaContraInc(sistemaContraincendio sisCon){
        String sql = "INSERT INTO siscontraincendio (fecha, material, pruebaS, obs, name) VALUES (?, ?, ?, ?, ?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1, (Date) sisCon.getFecha());
            ps.setString(2, sisCon.getMaterial());
            ps.setString(3, sisCon.getPrueba());
            ps.setString(4, sisCon.getObservacion());
            ps.setString(5, sisCon.getElaborado());
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
    public List ListarContraincendio(){
        List<sistemaContraincendio> ListaContra = new ArrayList();
        String sql = "SELECT * FROM siscontraincendio";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                sistemaContraincendio sisCon = new sistemaContraincendio();
                sisCon.setFecha(rs.getDate("fecha"));//2
                sisCon.setMaterial(rs.getString("material"));//3
                sisCon.setPrueba(rs.getString("pruebaS"));//4
                sisCon.setObservacion(rs.getString("obs"));//5
                sisCon.setElaborado(rs.getString("name"));//6
                sisCon.setId(rs.getInt("id"));//18
                ListaContra.add(sisCon);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaContra;
    }

    public Boolean eliminarContra(String id){
        String sql = "DELETE FROM siscontraincendio WHERE id="+ id +"";
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

    public boolean modificarContra(String Fecha, String Material, String Prueba, String observacion, String elaborado, String id){
        String sql = "UPDATE siscontraincendio SET fecha='"+ Fecha +"', material='"+ Material +"', pruebaS='"+ Prueba +"', obs='"+ observacion +"', name='"+ elaborado +"' WHERE id="+ id +"";
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

