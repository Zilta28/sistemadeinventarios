
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class tanqueTerapeuticoDAO {
    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public boolean RegistrarTanqueTerapeutico(tanqueTerapeutico tan){
        String sql = "INSERT INTO tanqueterapeutico (fechaT, name, semana, hora, bromo, ph, alca, dureza, temp, cloro, "
                   + "shock, acido, clarifi, aspirado, cepillado, contornado, moto1, moto2, filtro, presion, retrolavado, "
                   + "obs) VALUES (?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
        try{ 
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setDate(1, (Date) tan.getFecha());
            ps.setString(2, tan.getNombreLectura());
            ps.setString(3, tan.getDiaSemana());
            ps.setString(4, tan.getHora());
            ps.setString(5, tan.getBromo());
            ps.setString(6, tan.getPh());
            ps.setString(7, tan.getAlcalinidad());
            ps.setString(8, tan.getDureza());
            ps.setString(9, tan.getTemperatura());
            ps.setString(10, tan.getCloroBromado());
            ps.setString(11, tan.getShockPreventivo());
            ps.setString(12, tan.getAcido());
            ps.setString(13, tan.getClarificador());
            ps.setString(14, tan.getAspirado());
            ps.setString(15, tan.getCepillado());
            ps.setString(16, tan.getContornado());
            ps.setString(17, tan.getMotobomba1());
            ps.setString(18, tan.getMotobomba2());
            ps.setString(19, tan.getFiltro1());
            ps.setString(20, tan.getPresion1());
            ps.setString(21, tan.getRetrolavado1());
            ps.setString(22, tan.getObservacion());
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

     public List ListarTera(){
        List<tanqueTerapeutico> ListaTe = new ArrayList();
        String sql = "SELECT * FROM tanqueterapeutico ";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                tanqueTerapeutico tan = new tanqueTerapeutico();
                tan.setFecha(rs.getDate("fechaT"));//2
                tan.setNombreLectura(rs.getString("name"));//3
                tan.setDiaSemana(rs.getString("semana"));//4
                tan.setHora(rs.getString("hora"));//5
                tan.setBromo(rs.getString("bromo"));//6
                tan.setPh(rs.getString("ph"));//7
                tan.setAlcalinidad(rs.getString("alca"));//8
                tan.setDureza(rs.getString("dureza"));//9
                tan.setTemperatura(rs.getString("temp"));//10
                tan.setCloroBromado(rs.getString("cloro"));//11
                tan.setShockPreventivo(rs.getString("shock"));//12
                tan.setAcido(rs.getString("acido"));//13
                tan.setClarificador(rs.getString("clarifi"));//14
                tan.setAspirado(rs.getString("aspirado"));//15
                tan.setCepillado(rs.getString("cepillado"));//16
                tan.setContornado(rs.getString("contornado"));//17
                tan.setMotobomba1(rs.getString("moto1"));//18
                tan.setMotobomba2(rs.getString("moto2"));//19
                tan.setFiltro1(rs.getString("filtro"));//20
                tan.setPresion1(rs.getString("presion"));//21
                tan.setRetrolavado1(rs.getString("retrolavado"));//22
                tan.setObservacion(rs.getString("obs"));
                tan.setId(rs.getInt("id"));//13
                ListaTe.add(tan);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaTe;
    }

    public Boolean eliminarTe(String id){
        String sql = "DELETE FROM tanqueterapeutico WHERE id="+ id +"";
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

    public boolean modificarTera(String Fecha, String NombreLectura, String DiaSemana, String Hora, String Bromo, String Ph, String Alcalinidad, String Dureza, String Temperatura, String CloroBromado, String ShockPreventivo, String Acido, String Clarificador, String Aspirado, String Cepillado, String Contornado, String Motobomba1, String Motobomba2, String Filtro1, String Presion1, String Retrolavado1, String Observacion, String id){
        String sql = "UPDATE tanqueterapeutico SET fechaT='"+ Fecha +"', name='"+ NombreLectura +"', semana='"+ DiaSemana +"', hora='"+ Hora +"', bromo='"+ Bromo +"', ph='"+ Ph +"', alca='"+ Alcalinidad +"', dureza='"+ Dureza +"', temp='"+ Temperatura +"', cloro='"+ CloroBromado +"', shock='"+ ShockPreventivo +"',acido='"+ Acido +"',clarifi='"+ Clarificador +"', aspirado='"+ Aspirado +"',cepillado='"+ Cepillado +"', contornado='"+ Contornado +"',moto1'"+ Motobomba1 +"', moto2='"+ Motobomba2 +"', filtro='"+ Filtro1 +"', presion='"+ Presion1 +"', retrolavado='"+ Retrolavado1 +"',obs='"+ Observacion +"' WHERE id="+ id +"";
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

