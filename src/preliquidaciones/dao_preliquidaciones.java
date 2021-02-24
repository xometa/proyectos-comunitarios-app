/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preliquidaciones;

import Conexion.conexion;
import ListasCirculares.listaCSP;
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
public class dao_preliquidaciones {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    public listaCSP lcsp;

    public boolean insertar(Preliquidaciones dts) {
        sSQL = "insert into preliquidaciones (clasedeobra,capitulo,precioproyecto,unidadesproyecto,importeproyecto,unidadespreliquidaciones,importepreliquidaciones,diferencia,idproyecto)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getClasedeobra());
            pst.setString(2, dts.getCapitulo());
            pst.setDouble(3, dts.getPrecioproyecto());
            pst.setDouble(4, dts.getUnidadesproyecto());
            pst.setDouble(5, dts.getImporteproyecto());
            pst.setDouble(6, dts.getUnidadespreliquidaciones());
            pst.setDouble(7, dts.getImportepreliquidaciones());
            pst.setDouble(8, dts.getDiferencia());
            pst.setInt(9, dts.getIdproyecto());

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

    public boolean editar(Preliquidaciones dts) {
        sSQL = "update preliquidaciones "
                + "set clasedeobra=?,"
                + "capitulo=?,"
                + "precioproyecto=?,"
                + "unidadesproyecto=?,"
                + "importeproyecto=?,"
                + "unidadespreliquidaciones=?,"
                + "importepreliquidaciones=?,"
                + "diferencia=?,"
                + "idproyecto=?"
                + " where idpreliquidacion=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getClasedeobra());
            pst.setString(2, dts.getCapitulo());
            pst.setDouble(3, dts.getPrecioproyecto());
            pst.setDouble(4, dts.getUnidadesproyecto());
            pst.setDouble(5, dts.getImporteproyecto());
            pst.setDouble(6, dts.getUnidadespreliquidaciones());
            pst.setDouble(7, dts.getImportepreliquidaciones());
            pst.setDouble(8, dts.getDiferencia());
            pst.setInt(9, dts.getIdproyecto());
            pst.setInt(10, dts.getIdpreliquidacion());

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

    public boolean eliminar(Preliquidaciones dts) {

        sSQL = "delete from preliquidaciones where idpreliquidacion=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdpreliquidacion());

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

    public ArrayList<Preliquidaciones> mostrarpreliquidaciones(String id, String cap) {
        ArrayList<Preliquidaciones> lista = new ArrayList<>();
        try {
            pst = mysql.getConexion().prepareStatement("select pre.idpreliquidacion,\n"
                    + "pre.clasedeobra,\n"
                    + "pre.capitulo,\n"
                    + "pre.precioproyecto,\n"
                    + "pre.unidadesproyecto,\n"
                    + "pre.importeproyecto,\n"
                    + "pre.unidadespreliquidaciones,\n"
                    + "pre.importepreliquidaciones,\n"
                    + "pre.diferencia,\n"
                    + "p.idproyecto,\n"
                    + "p.codigoproyecto,\n"
                    + "p.descripcion,\n"
                    + "p.monto,\n"
                    + "p.fechainicia,\n"
                    + "p.fechafinaliza,\n"
                    + "p.estado\n"
                    + "from preliquidaciones as pre \n"
                    + "inner join proyectos as p on p.idproyecto=pre.idproyecto\n"
                    + "where p.idproyecto like'%" + id + "%' and pre.capitulo like'%" + cap + "%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                Preliquidaciones pre = new Preliquidaciones(rs.getInt("idpreliquidacion"),
                        rs.getString("clasedeobra"),
                        rs.getString("capitulo"),
                        rs.getDouble("precioproyecto"),
                        rs.getDouble("unidadesproyecto"),
                        rs.getDouble("importeproyecto"),
                        rs.getDouble("unidadespreliquidaciones"),
                        rs.getDouble("importepreliquidaciones"),
                        rs.getDouble("diferencia"),
                        rs.getInt("idproyecto"),
                        new Proyectos(rs.getInt("idproyecto"),
                                rs.getString("codigoproyecto"),
                                rs.getString("descripcion"),
                                rs.getDouble("monto"),
                                rs.getDate("fechainicia"),
                                rs.getDate("fechafinaliza"),
                                rs.getString("estado")));
                lista.add(pre);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Preliquidaciones> llenarlistacircular(ArrayList<Preliquidaciones> d) {
        lcsp = new listaCSP();
        for (int i = 0; i < d.size(); i++) {
            lcsp.insertar(d.get(i));
        }
        return lcsp.mostrarDatos();
    }

    public ArrayList<Preliquidaciones> mostrarcola(String id) {
        ArrayList<Preliquidaciones> lista = new ArrayList<>();
        try {
            pst = mysql.getConexion().prepareStatement("select pre.idpreliquidacion,\n"
                    + "pre.clasedeobra,\n"
                    + "pre.capitulo,\n"
                    + "pre.precioproyecto,\n"
                    + "pre.unidadesproyecto,\n"
                    + "pre.importeproyecto,\n"
                    + "pre.unidadespreliquidaciones,\n"
                    + "pre.importepreliquidaciones,\n"
                    + "pre.diferencia,\n"
                    + "p.idproyecto,\n"
                    + "p.codigoproyecto,\n"
                    + "p.descripcion,\n"
                    + "p.monto,\n"
                    + "p.fechainicia,\n"
                    + "p.fechafinaliza,\n"
                    + "p.estado\n"
                    + "from preliquidaciones as pre \n"
                    + "inner join proyectos as p on p.idproyecto=pre.idproyecto "
                    + "where p.idproyecto like'%"+id+"%'");
            rs = pst.executeQuery();
            while (rs.next()) {
                Preliquidaciones pre = new Preliquidaciones(rs.getInt("idpreliquidacion"),
                        rs.getString("clasedeobra"),
                        rs.getString("capitulo"),
                        rs.getDouble("precioproyecto"),
                        rs.getDouble("unidadesproyecto"),
                        rs.getDouble("importeproyecto"),
                        rs.getDouble("unidadespreliquidaciones"),
                        rs.getDouble("importepreliquidaciones"),
                        rs.getDouble("diferencia"),
                        rs.getInt("idproyecto"),
                        new Proyectos(rs.getInt("idproyecto"),
                                rs.getString("codigoproyecto"),
                                rs.getString("descripcion"),
                                rs.getDouble("monto"),
                                rs.getDate("fechainicia"),
                                rs.getDate("fechafinaliza"),
                                rs.getString("estado")));
                lista.add(pre);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }
    
    public ArrayList<Preliquidaciones> noeliminacion() {
        ArrayList<Preliquidaciones> lista = new ArrayList<>();
        try {
            pst = mysql.getConexion().prepareStatement("select pre.idpreliquidacion,\n"
                    + "pre.clasedeobra,\n"
                    + "pre.capitulo,\n"
                    + "pre.precioproyecto,\n"
                    + "pre.unidadesproyecto,\n"
                    + "pre.importeproyecto,\n"
                    + "pre.unidadespreliquidaciones,\n"
                    + "pre.importepreliquidaciones,\n"
                    + "pre.diferencia,\n"
                    + "p.idproyecto,\n"
                    + "p.codigoproyecto,\n"
                    + "p.descripcion,\n"
                    + "p.monto,\n"
                    + "p.fechainicia,\n"
                    + "p.fechafinaliza,\n"
                    + "p.estado\n"
                    + "from preliquidaciones as pre \n"
                    + "inner join proyectos as p on p.idproyecto=pre.idproyecto");
            rs = pst.executeQuery();
            while (rs.next()) {
                Preliquidaciones pre = new Preliquidaciones(rs.getInt("idpreliquidacion"),
                        rs.getString("clasedeobra"),
                        rs.getString("capitulo"),
                        rs.getDouble("precioproyecto"),
                        rs.getDouble("unidadesproyecto"),
                        rs.getDouble("importeproyecto"),
                        rs.getDouble("unidadespreliquidaciones"),
                        rs.getDouble("importepreliquidaciones"),
                        rs.getDouble("diferencia"),
                        rs.getInt("idproyecto"),
                        new Proyectos(rs.getInt("idproyecto"),
                                rs.getString("codigoproyecto"),
                                rs.getString("descripcion"),
                                rs.getDouble("monto"),
                                rs.getDate("fechainicia"),
                                rs.getDate("fechafinaliza"),
                                rs.getString("estado")));
                lista.add(pre);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }
}
