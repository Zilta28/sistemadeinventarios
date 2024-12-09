
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author lizbeth Ventura Talón
 * Licenciatura en Ciencias Computacionales
 */

public class loginDAO {
    Connection cn;
    PreparedStatement ps; 
    ResultSet rs;
    conexionBD con = new conexionBD(); 
    public login log(String nombre, String pass){
        login l = new login();
        String sql = "SELECT * FROM usuarios WHERE nombre =? AND pass =?";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
            }
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    return l;
    }
}
