/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class cemsDAO {

    PreparedStatement ps;
    Connection cn;
    ResultSet rs;
    conexionBD con = new conexionBD();

    public boolean RegistrarC(cems c) {
        String sql = "INSERT INTO cems (materialce, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, c.getMaterialC());
            ps.setDate(2, (Date) c.getFechaC());
            ps.setString(3, c.getBuenEstadoC());
            ps.setString(4, c.getObservacionesC());
            ps.setString(5, c.getElaboradoC());
            ps.setString(6, c.getRevisadoC());
            ps.setString(7, c.getAprobadoC());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarCems() {
        System.out.println("Hola mundo CEMSDAO");
        List<cems > ListaC = new ArrayList();
        String sql = "SELECT * FROM cems";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cems c = new cems();
                c.setMaterialC(rs.getString("materialce"));
                c.setFechaC(rs.getDate("fecha"));
                c.setBuenEstadoC(rs.getString("chequeoGral"));
                c.setObservacionesC(rs.getString("Observacion"));
                c.setElaboradoC(rs.getString("elaborado"));
                c.setRevisadoC(rs.getString("revisado"));
                c.setAprobadoC(rs.getString("aprobado"));
                c.setId(rs.getInt("id"));//18
                ListaC.add(c);
                System.out.println("Hola mundo CEMSDAO WHILE");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaC;
    }

    public boolean ActualizarCems(cems c) {
        String sql = "UPDATE cems (materialce, fecha, chequeoGral, observacion, elaborado, revisado, aprobado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, c.getMaterialC());
            ps.setDate(2, (Date) c.getFechaC());
            ps.setString(3, c.getBuenEstadoC());
            ps.setString(4, c.getObservacionesC());
            ps.setString(5, c.getElaboradoC());
            ps.setString(6, c.getRevisadoC());
            ps.setString(7, c.getAprobadoC());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean EliminarCems(String id) {
        String sql = "DELETE FROM cems WHERE id="+ id +"";
        try{
            ps = cn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
        return false;
    }

    public boolean modificarC(String materialC, String fechaC, String buenEstadoC, String observacionesC, String elaboradoC, String revisadoC, String aprobadoC, String id) {
        String sql = "UPDATE cems SET materialce='"+ materialC +"', fecha='"+ fechaC +"', chequeoGral='"+ buenEstadoC +"', observacion='"+ observacionesC +"', elaborado='"+ elaboradoC +"', revisado='"+ revisadoC +"', aprobado='"+ aprobadoC +"' WHERE id="+ id +"";
        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
