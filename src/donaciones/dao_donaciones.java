/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donaciones;

import Colas_y_Pilas.Pila;
import Conexion.conexion;
import ListasSimples.lsDonaciones;
import donantes.Donantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectos.Proyectos;

/**
 *
 * @author Hernandez
 */
public class dao_donaciones {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    private String sSQL = "";
    public lsDonaciones ld;
    public Pila piladonaciones=new Pila();

    public boolean insertar(Donaciones dts) {
        sSQL = "insert into donaciones (iddonante,idproyecto,montodonar,fecha)"
                + "values (?,?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIddonantes());
            pst.setInt(2, dts.getIdproyecto());
            pst.setDouble(3, dts.getMontodonar());
            pst.setDate(4, dts.getFecha());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Donaciones dts) {
        sSQL = "update donaciones set iddonante=?,idproyecto=?,montodonar=?,fecha=?"
                + " where idonaciones=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIddonantes());
            pst.setInt(2, dts.getIdproyecto());
            pst.setDouble(3, dts.getMontodonar());
            pst.setDate(4, dts.getFecha());
            pst.setInt(5, dts.getIddonaciones());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Donaciones dts) {

        sSQL = "delete from donaciones where idonaciones=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIddonaciones());

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public ArrayList<Donaciones> mostrardonaciones(String id) {
        ArrayList<Donaciones> lista = new ArrayList<>();
        try {
            sSQL = "select d.idonaciones,\n"
                    + "don.iddonantes,\n"
                    + "don.nombre,\n"
                    + "don.empresa,\n"
                    + "don.email,\n"
                    + "don.direccion,\n"
                    + "don.codigopostal,\n"
                    + "don.ciudad,\n"
                    + "don.telefono,\n"
                    + "proy.idproyecto,\n"
                    + "proy.codigoproyecto,\n"
                    + "proy.descripcion,\n"
                    + "proy.monto,\n"
                    + "proy.fechainicia,\n"
                    + "proy.fechafinaliza,\n"
                    + "proy.estado,\n"
                    + "d.montodonar,\n"
                    + "d.fecha \n"
                    + "from donaciones as d \n"
                    + "inner join donantes as don on don.iddonantes=d.iddonante \n"
                    + "inner join proyectos as proy on proy.idproyecto=d.idproyecto where proy.idproyecto like '%" + id + "%'";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Donaciones d = new Donaciones(rs.getInt("idonaciones"),
                        rs.getInt("iddonantes"), new Donantes(rs.getInt("iddonantes"), rs.getString("nombre"), rs.getString("empresa"), rs.getString("email"), rs.getString("direccion"), rs.getString("codigopostal"), rs.getString("ciudad"), rs.getString("telefono")),
                        rs.getInt("idproyecto"), new Proyectos(rs.getInt("idproyecto"), rs.getString("codigoproyecto"), rs.getString("descripcion"), rs.getDouble("monto"), rs.getDate("fechainicia"), rs.getDate("fechafinaliza"), rs.getString("estado")),
                        rs.getDouble("montodonar"), rs.getDate("fecha"));
                lista.add(d);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public Double montodonado(String id) {
        double sum = 0;
        try {

            sSQL = "select sum(d.montodonar) as montodonado "
                    + "from donaciones as d "
                    + "inner join proyectos as p on p.idproyecto=d.idproyecto "
                    + "where p.idproyecto='" + id + "'";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();

            while (rs.next()) {
                sum = rs.getDouble("montodonado");
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return sum;
    }

    /*Metodo para llenar la lista simple*/
    public ArrayList<Donaciones> llenarlistadonaciones(ArrayList<Donaciones> d) {
        ld = new lsDonaciones();
        for (int i = 0; i < d.size(); i++) {
            ld.insertar(d.get(i));
        }
        return ld.toArray();
    }

    public ArrayList<Donaciones> llenarpila(ArrayList<Donaciones> d) {
//        piladonaciones = new Pila();
        for (int i = 0; i < d.size(); i++) {
            piladonaciones.push(d.get(i));
        }
        return piladonaciones.toArrayList();
    }
}
