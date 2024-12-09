/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialDAO extends Historial{
   PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();
    
    public List ListarBitacoraByTable(String tabla){
        List<Historial> ListaHistorial = new ArrayList();
        String sql = "SELECT * FROM t_bitacora WHERE tabla='"+ tabla +"'";
        try{
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Historial hist = new Historial();
                hist.setId(rs.getString("id"));
                hist.setHost(rs.getString("host"));
                hist.setUsusario(rs.getString("ususario"));
                hist.setAccion(rs.getString("accion"));
                ListaHistorial.add(hist);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaHistorial;
    }
    
    public List ListarBitacoraByDate(String fecha){
        List<Historial> ListaHistorial = new ArrayList();
        String sql = "SELECT * FROM t_bitacora WHERE fecha='"+ fecha +"'";
        try{
            System.out.println(sql);
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Historial hist = new Historial();
                hist.setId(rs.getString("id"));
                hist.setHost(rs.getString("host"));
                hist.setUsusario(rs.getString("ususario"));
                hist.setAccion(rs.getString("accion"));
                ListaHistorial.add(hist);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaHistorial;
    }
}
