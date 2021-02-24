/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import Arboles.AVL;
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
public class dao_usuarios {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    private String sSQL = "";
    private String sSQL2 = "";
    AVL avl;

    public boolean insertar(Usuario dts) {
        sSQL = "insert into persona (idpersona,nombre,apellidos,fechanacimiento,dui,nit,profesion,sexo)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into usuarios(idpersonauser,codigo,usuario,contrasena,tipouser) "
                + "values((select idpersona from persona order by idpersona desc limit 1),?,?,?,?)";//(select idpersona from persona order by idpersona desc limit 1)
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
            pst2.setString(1, dts.getCodigo());
            pst2.setString(2, dts.getUsuario());
            pst2.setString(3, dts.getContraseña());
            pst2.setString(4, dts.getTipouser());
            
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

    public boolean editar(Usuario dts) {
        sSQL = "update persona  set nombre=?,apellidos=?,fechanacimiento=?,dui=?,nit=?,profesion=?,sexo=?"
                + " where idpersona=?";
        sSQL2 = "update usuarios  set codigo=?,usuario=?,contrasena=?,tipouser=? where idpersonauser=?";
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
            pst2.setString(1, dts.getCodigo());
            pst2.setString(2, dts.getUsuario());
            pst2.setString(3, dts.getContraseña());
            pst2.setString(4, dts.getTipouser());
            pst2.setInt(5, dts.getIdpersona());

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
    
    public boolean editarsinpass(Usuario dts) {
        sSQL = "update persona  set nombre=?,apellidos=?,fechanacimiento=?,dui=?,nit=?,profesion=?,sexo=?"
                + " where idpersona=?";
        sSQL2 = "update usuarios  set codigo=?,usuario=?,tipouser=? where idpersonauser=?";
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
            pst2.setString(1, dts.getCodigo());
            pst2.setString(2, dts.getUsuario());
            pst2.setString(3, dts.getTipouser());
            pst2.setInt(4, dts.getIdpersona());

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
    
    public boolean eliminar(Usuario dts) {

        sSQL = "delete from usuarios where idpersonauser=?";
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
    
    public ArrayList<Usuario> datosusuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            sSQL = "select pe.idpersona,\n"
                    + "us.codigo,\n"
                    + "pe.nombre,\n"
                    + "pe.apellidos,\n"
                    + "pe.fechanacimiento,\n"
                    + "pe.dui,\n"
                    + "pe.nit,\n"
                    + "pe.profesion,\n"
                    + "pe.sexo,\n"
                    + "us.usuario,\n"
                    + "us.contrasena,\n"
                    + "us.tipouser\n"
                    + "from usuarios as us \n"
                    + "inner join persona as pe \n"
                    + "on pe.idpersona=us.idpersonauser";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdpersona(rs.getInt("idpersona"));
                u.setCodigo(rs.getString("codigo"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setFechanacimiento(rs.getDate("fechanacimiento"));
                u.setDui(rs.getString("dui"));
                u.setNit(rs.getString("nit"));
                u.setProfesion(rs.getString("profesion"));
                u.setSexo(rs.getString("sexo"));
                u.setUsuario(rs.getString("usuario"));
                u.setContraseña(rs.getString("contrasena"));
                u.setTipouser(rs.getString("tipouser"));
                lista.add(u);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Hay Datos");
        }
        return lista;
    }

    public ArrayList<Usuario> llenaravl(ArrayList<Usuario> d) {
        avl = new AVL();
        for (int i = 0; i < d.size(); i++) {
            avl.insertar(d.get(i));
        }
        return avl.IND();
    }
}
