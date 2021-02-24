/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;

import Conexion.conexion;
import ListasSimples.lsProyectos;
import alcaldia.Alcaldia;
import comunidades.Comunidades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import usuarios.Usuario;

/**
 *
 * @author Hernandez
 */
public class dao_proyectos {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    private String sSQL = "";
    lsProyectos lp = new lsProyectos();

    public boolean insertar(Proyectos dts) {
        sSQL = "insert into proyectos (codigoproyecto,descripcion,monto,fechainicia,fechafinaliza,estado,idalcaldia,idcomunidad,iduser)"
                + "values (?,?,?,?,?,?,?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigoproyecto());
            pst.setString(2, dts.getDescripción());
            pst.setDouble(3, dts.getMonto());
            pst.setDate(4, dts.getFechainicia());
            pst.setDate(5, dts.getFechafinaliza());
            pst.setString(6, dts.getEstado());
            pst.setInt(7, dts.getIdalcaldia());
            pst.setInt(8, dts.getIdcomunidad());
            pst.setInt(9, dts.getIduser());

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

    public boolean editar(Proyectos dts) {
        sSQL = "update proyectos set codigoproyecto=?,descripcion=?,monto=?,fechainicia=?,"
                + "fechafinaliza=?,estado=?,idalcaldia=?,idcomunidad=?"
                + " where idproyecto=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getCodigoproyecto());
            pst.setString(2, dts.getDescripción());
            pst.setDouble(3, dts.getMonto());
            pst.setDate(4, dts.getFechainicia());
            pst.setDate(5, dts.getFechafinaliza());
            pst.setString(6, dts.getEstado());
            pst.setInt(7, dts.getIdalcaldia());
            pst.setInt(8, dts.getIdcomunidad());
            pst.setInt(9, dts.getIdproyecto());

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

    public boolean eliminar(Proyectos dts) {

        sSQL = "delete from proyectos where idproyecto=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdproyecto());

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
    
    public ArrayList<Proyectos> mostrarproyectos(String id) {
        ArrayList<Proyectos> lista = new ArrayList<>();
        try {
            sSQL = "select p.idproyecto,\n"
                    + "p.codigoproyecto,\n"
                    + "p.descripcion,\n"
                    + "p.monto,\n"
                    + "p.fechainicia,\n"
                    + "p.fechafinaliza,\n"
                    + "p.estado,a.idalcaldia,\n"
                    + "a.nombrealcaldia,\n"
                    + "a.nit,\n"
                    + "c.idcomunidad,\n"
                    + "c.nombre,\n"
                    + "u.idpersonauser,\n"
                    + "per.idpersona,\n"
                    + "(per.nombre) as nombreuser,\n"
                    + "per.apellidos \n"
                    + "from proyectos as p \n"
                    + "inner join alcaldia as a on a.idalcaldia=p.idalcaldia \n"
                    + "inner join comunidades as c on c.idcomunidad=p.idcomunidad \n"
                    + "inner join usuarios as u on u.idpersonauser=p.iduser \n"
                    + "inner join persona as per on per.idpersona=u.idpersonauser\n"
                    + "where a.idalcaldia like '%" + id + "%'";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Proyectos p = new Proyectos(rs.getInt("idproyecto"), rs.getString("codigoproyecto"), rs.getString("descripcion"), rs.getDouble("monto"), rs.getDate("fechainicia"), rs.getDate("fechafinaliza"), rs.getString("estado"),
                        rs.getInt("idalcaldia"), new Alcaldia(rs.getInt("idalcaldia"), rs.getString("nombrealcaldia"), rs.getString("nit")),
                        rs.getInt("idcomunidad"), new Comunidades(rs.getInt("idcomunidad"), rs.getString("nombre")),
                        rs.getInt("idpersonauser"), new Usuario(rs.getInt("idpersonauser"), rs.getInt("idpersona"), rs.getString("nombreuser"), rs.getString("apellidos")));
                lista.add(p);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Proyectos> mostrarproyectosnocancelados() {
        ArrayList<Proyectos> lista = new ArrayList<>();
        try {
            sSQL = "select p.idproyecto,\n"
                    + "p.codigoproyecto,\n"
                    + "p.descripcion,\n"
                    + "p.monto,\n"
                    + "p.fechainicia,\n"
                    + "p.fechafinaliza,\n"
                    + "p.estado \n"
                    + "from proyectos as p \n"
                    + "WHERE p.estado='Ejecutandose' or p.estado='Ejecutado' or p.estado='No Ejecutado'";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Proyectos p = new Proyectos(rs.getInt("idproyecto"),
                        rs.getString("codigoproyecto"),
                        rs.getString("descripcion"),
                        rs.getDouble("monto"),
                        rs.getDate("fechainicia"),
                        rs.getDate("fechafinaliza"),
                        rs.getString("estado"));
                lista.add(p);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Proyectos> mostrartodosproyectos() {
        ArrayList<Proyectos> lista = new ArrayList<>();
        try {
            sSQL = "select p.idproyecto,\n"
                    + "p.codigoproyecto,\n"
                    + "p.descripcion,\n"
                    + "p.monto,\n"
                    + "p.fechainicia,\n"
                    + "p.fechafinaliza,\n"
                    + "p.estado,a.idalcaldia,\n"
                    + "a.nombrealcaldia,\n"
                    + "a.nit,\n"
                    + "c.idcomunidad,\n"
                    + "c.nombre,\n"
                    + "u.idpersonauser,\n"
                    + "per.idpersona,\n"
                    + "(per.nombre) as nombreuser,\n"
                    + "per.apellidos \n"
                    + "from proyectos as p \n"
                    + "inner join alcaldia as a on a.idalcaldia=p.idalcaldia \n"
                    + "inner join comunidades as c on c.idcomunidad=p.idcomunidad \n"
                    + "inner join usuarios as u on u.idpersonauser=p.iduser \n"
                    + "inner join persona as per on per.idpersona=u.idpersonauser";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Proyectos p = new Proyectos(rs.getInt("idproyecto"), rs.getString("codigoproyecto"), rs.getString("descripcion"), rs.getDouble("monto"), rs.getDate("fechainicia"), rs.getDate("fechafinaliza"), rs.getString("estado"),
                        rs.getInt("idalcaldia"), new Alcaldia(rs.getInt("idalcaldia"), rs.getString("nombrealcaldia"), rs.getString("nit")),
                        rs.getInt("idcomunidad"), new Comunidades(rs.getInt("idcomunidad"), rs.getString("nombre")),
                        rs.getInt("idpersonauser"), new Usuario(rs.getInt("idpersonauser"), rs.getInt("idpersona"), rs.getString("nombreuser"), rs.getString("apellidos")));
                lista.add(p);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Proyectos> llenarlista(ArrayList<Proyectos> d) {
        for (int i = 0; i < d.size(); i++) {
            lp.insertar(d.get(i));
        }
        return lp.toArray();
    }
}
