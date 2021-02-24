/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonas;

import Conexion.conexion;
import ListasCirculares.listaCD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class dao_Zonas {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    public listaCD lcd=new listaCD();

    public boolean insertar(zonas dts) {
        sSQL = "insert into zonas (nombre,codigo)"
                + "values (?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(zonas dts) {
        sSQL = "update zonas set nombre=?,codigo=?"
                + " where idzona=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getId());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(zonas dts) {

        sSQL = "delete from zonas where idzona=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getId());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    /*METODO PARA EL MUESTREO DE TODOS LOS DATOS QUE ESTAN REGISTRADOS*/
    public ArrayList<zonas> consultazonas() {
        ArrayList<zonas> lista = new ArrayList<>();
        try {
            pst = mysql.getConexion().prepareStatement("SELECT *FROM zonas");
            rs = pst.executeQuery();
            while (rs.next()) {
                zonas de = new zonas(rs.getInt("idzona"),
                        rs.getString("nombre"),
                        rs.getString("codigo"));
                lista.add(de);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    /*METODO PARA RETORNAR LA ZONA QUE LE PERTENECE A UN DETERMINADO DEPARTAMENTO RECIBIENDO COMO PARAMETRO EL ID DE LA ZONA*/
    public String getzona(int id) {
        sSQL = "select nombre from zonas where idzona=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre");
            }
            rs.close();
            pst.close();
            cn.close();
            return "---";
        } catch (SQLException ex) {
            return "---";
        }
    }
    
    public ArrayList<zonas> llenarlistacirculardoble(ArrayList<zonas> d) {
        for (int i = 0; i < d.size(); i++) {
            lcd.insertar(d.get(i));
        }
        return lcd.mostrarAsc();
    }
}
