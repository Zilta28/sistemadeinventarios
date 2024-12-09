
package Modelo;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class conexionBD {
    Connection cn;
    
    public Connection getConnection(){
        
        try{
                     //Class.forName("com.mysql.jdbc.Driver");
            cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sistemainventario", "root", "");
            System.out.println("conexion establecida");       
             }catch(SQLException e){
            System.out.println("Error de conexion de la base de datos"+e);
        }
        return cn;
    }
}

