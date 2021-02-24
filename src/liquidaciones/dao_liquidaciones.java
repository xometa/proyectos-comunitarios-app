/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidaciones;

import Colas_y_Pilas.Pila;
import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernandez
 */
public class dao_liquidaciones {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    public Pila pilita = new Pila();

    public ArrayList<Liquidaciones> mostrarliquidaciones(String id) {
        ArrayList<Liquidaciones> lista = new ArrayList<>();
        try {
            pst = cn.prepareStatement("select p.idproyecto,"
                    + "pre.capitulo,\n"
                    + "sum(pre.importeproyecto)as importproy,\n"
                    + "sum(pre.importepreliquidaciones)as importpre,\n"
                    + "sum(pre.diferencia)as diferen \n"
                    + "from preliquidaciones as pre \n"
                    + "inner join proyectos as p on p.idproyecto=pre.idproyecto \n"
                    + "where p.idproyecto like'%" + id + "%' GROUP BY pre.capitulo");
            rs = pst.executeQuery();
            while (rs.next()) {
                Liquidaciones l = new Liquidaciones(rs.getString("capitulo"), rs.getDouble("importproy"),
                        rs.getDouble("importpre"), rs.getDouble("diferen"), rs.getInt("idproyecto"));
                lista.add(l);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Liquidaciones> mostrartodos() {
        ArrayList<Liquidaciones> lista = new ArrayList<>();
        try {
            pst = cn.prepareStatement("select p.idproyecto, \n"
                    + "pre.capitulo,\n"
                    + "sum(pre.importeproyecto)as importproy,\n"
                    + "sum(pre.importepreliquidaciones)as importpre,\n"
                    + "sum(pre.diferencia)as diferen \n"
                    + "from preliquidaciones as pre \n"
                    + "inner join proyectos as p on p.idproyecto=pre.idproyecto \n"
                    + "GROUP BY pre.capitulo");
            rs = pst.executeQuery();
            while (rs.next()) {
                Liquidaciones l = new Liquidaciones(rs.getString("capitulo"), rs.getDouble("importproy"),
                        rs.getDouble("importpre"), rs.getDouble("diferen"), rs.getInt("idproyecto"));
                lista.add(l);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Liquidaciones> llenarpila(ArrayList<Liquidaciones> d) {
        for (int i = 0; i < d.size(); i++) {
            pilita.push(d.get(i));
        }
        return pilita.toArrayList();
    }
}
