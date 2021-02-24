/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentos;

import Conexion.conexion;
import ListasCirculares.listaCS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import zonas.zonas;

/**
 *
 * @author Sony
 */
public class dao_departamentos {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    private String sSQL2 = "";
    public listaCS lcs = new listaCS();

    public boolean insertar(Departamentos dts) {
        sSQL = "insert into departamentos (nombre,codigo,idzona)"
                + "values (?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIdzona());

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

    public boolean editar(Departamentos dts) {
        sSQL = "update departamentos set nombre=?,codigo=?,idzona=?"
                + " where iddepartamento=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIdzona());
            pst.setInt(4, dts.getIddepartamento());

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

    public boolean eliminar(Departamentos dts) {

        sSQL = "delete from departamentos where iddepartamento=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIddepartamento());

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

    public ArrayList<Departamentos> consultadepartamentos() {
        ArrayList<Departamentos> lista = new ArrayList<>();
        try {
            sSQL="select d.iddepartamento, d.nombre,d.codigo,z.idzona,(z.nombre)as nombrezona from departamentos as d inner join zonas as z on z.idzona=d.idzona";
//            where (nombre LIKE'" + c + "%' OR "
//                    + "codigo LIKE'" + c + "%' OR "
//                            + "idzona LIKE'" + c + "%')
            pst= cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Departamentos de = new Departamentos(rs.getInt("iddepartamento"), rs.getString("nombre"),
                        rs.getString("codigo"), new zonas(rs.getInt("idzona"),rs.getString("nombrezona")));
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

     /*metodo para llenar la lista circular simple con lo que posee la base de datos*/
    public ArrayList<Departamentos> llenarlistacircularsimple(ArrayList<Departamentos> d) {
        for (int i = 0; i < d.size(); i++) {
            lcs.insertar(d.get(i));
        }
        return lcs.mostrarDatos();
    }
}
