/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcaldes;

import Arboles.ArbolBB;
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
public class dao_alcaldes {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    private String sSQL = "";
    private String sSQL2 = "";
    ArbolBB bb;

    public boolean insertar(Alcalde dts) {
        sSQL = "insert into persona (idpersona,nombre,apellidos,fechanacimiento,dui,nit,profesion,sexo)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into alcaldes(idpersona,tipo) "
                + "values(?,?)";//(select idpersona from persona order by idpersona desc limit 1)
        try {
            pst = cn.prepareStatement(sSQL);
            pst2 = cn.prepareStatement(sSQL2);

            /*insertando en la tabla persona*/
            pst.setInt(1, dts.getIdpersona());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellidos());
            pst.setDate(4, dts.getFechanacimiento());
            pst.setString(5, dts.getDui());
            pst.setString(6, dts.getNit());
            pst.setString(7, dts.getProfesion());
            pst.setString(8, dts.getSexo());

            /*insertando en la tabla alcaldes*/
            pst2.setInt(1, dts.getIdpersona());
            pst2.setString(2, dts.getTipo());

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(Alcalde dts) {
        sSQL = "update persona  set nombre=?,apellidos=?,fechanacimiento=?,dui=?,nit=?,profesion=?,sexo=?"
                + " where idpersona=?";
        sSQL2 = "update alcaldes  set tipo=? where idpersona=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst2 = cn.prepareStatement(sSQL2);

            /*insertando en la tabla persona*/
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setDate(3, dts.getFechanacimiento());
            pst.setString(4, dts.getDui());
            pst.setString(5, dts.getNit());
            pst.setString(6, dts.getProfesion());
            pst.setString(7, dts.getSexo());
            pst.setInt(8, dts.getIdpersona());

            /*insertando en la tabla alcaldes*/
            pst2.setString(1, dts.getTipo());
            pst2.setInt(2, dts.getIdpersona());

            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(Alcalde dts) {

        sSQL = "delete from alcaldes where idpersona=?";
        sSQL2 = "delete from persona where idpersona=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst2 = cn.prepareStatement(sSQL2);

            pst.setInt(1, dts.getIdpersona());
            pst2.setInt(1, dts.getIdpersona());
            int n = pst.executeUpdate();
            if (n != 0) {
                int n2 = pst2.executeUpdate();
                if (n2 != 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public ArrayList<Alcalde> consultaalcaldes(String c) {
        ArrayList<Alcalde> lista = new ArrayList<>();
        try {
            sSQL = "select p.idpersona,\n"
                    + "p.nombre,\n"
                    + "p.apellidos,\n"
                    + "p.fechanacimiento,\n"
                    + "p.dui,\n"
                    + "p.nit,\n"
                    + "p.profesion,\n"
                    + "p.sexo,\n"
                    + "al.tipo \n"
                    + "from alcaldes as al \n"
                    + "inner join persona as p \n"
                    + "on p.idpersona=al.idpersona"
                    + " where p.dui like '%" + c + "%'";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Alcalde a = new Alcalde();
                a.setIdpersona(rs.getInt("idpersona"));
                a.setNombre(rs.getString("nombre"));
                a.setApellidos(rs.getString("apellidos"));
                a.setFechanacimiento(rs.getDate("fechanacimiento"));
                a.setDui(rs.getString("dui"));
                a.setNit(rs.getString("nit"));
                a.setProfesion(rs.getString("profesion"));
                a.setSexo(rs.getString("sexo"));
                a.setTipo(rs.getString("tipo"));
                lista.add(a);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Alcalde> llenarbinario(ArrayList<Alcalde> d) {
        bb = new ArbolBB();
        for (int i = 0; i < d.size(); i++) {
            bb.insertar(d.get(i));
        }
        return bb.NID();
    }
}
