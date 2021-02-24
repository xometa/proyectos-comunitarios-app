/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donantes;

import Conexion.conexion;
import ListasSimples.lsDonantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class dao_donantes {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    private String sSQL2 = "";
    public lsDonantes ls = new lsDonantes();

    public boolean insertar(Donantes dts) {

        try {
            sSQL = "insert into donantes (nombre,empresa,email,direccion,codigopostal,ciudad,telefono,tipo,pais) values (?,?,?,?,?,?,?,?,?)";
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getEmpresa());
            pst.setString(3, dts.getEmail());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getCodigopostal());
            pst.setString(6, dts.getCiudad());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getTipo());
            pst.setString(9, dts.getPais());
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

    public boolean editar(Donantes dts) {

        try {
            sSQL = "update donantes set nombre=?,empresa=?,email=?,direccion=?,codigopostal=?,ciudad=?,telefono=?,tipo=?,pais=? "
                    + "where iddonantes=?";
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getEmpresa());
            pst.setString(3, dts.getEmail());
            pst.setString(4, dts.getDireccion());
            pst.setString(5, dts.getCodigopostal());
            pst.setString(6, dts.getCiudad());
            pst.setString(7, dts.getTelefono());
            pst.setString(8, dts.getTipo());
            pst.setString(9, dts.getPais());
            pst.setInt(10, dts.getIddonantes());
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

    public boolean eliminar(Donantes dts) {
        try {
            sSQL = "delete from donantes where iddonantes=?";
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIddonantes());
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

    public ArrayList<Donantes> consultadonantes() {
        ArrayList<Donantes> listar = new ArrayList<>();
        try {
            sSQL = "select *from donantes";
            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Donantes d = new Donantes(rs.getInt("iddonantes"), rs.getString("nombre"), rs.getString("empresa"),
                        rs.getString("email"), rs.getString("direccion"), rs.getString("codigopostal"), rs.getString("ciudad"),
                        rs.getString("telefono"), rs.getString("tipo"), rs.getString("pais"));
                listar.add(d);
            }
            rs.close();
            pst.close();
            mysql.cerrarConexiones();
        } catch (SQLException ex) {
            Logger.getLogger(dao_donantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listar;
    }

    /*metodo para llenar la lista simple con lo que posee la base de datos*/
    public ArrayList<Donantes> llenarlista(ArrayList<Donantes> d) {
        for (int i = 0; i < d.size(); i++) {
            ls.insertar(d.get(i));
        }
        return ls.toArray();
    }
}
