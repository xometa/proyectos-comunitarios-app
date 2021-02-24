/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcaldia;

import Conexion.conexion;
import ListasDobles.ldAlcaldias;
import alcaldes.Alcalde;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import municipios.Municipio;

/**
 *
 * @author Hernandez
 */
public class dao_alcaldia {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    private String sSQL = "";
    ldAlcaldias la;

    public boolean insertar(Alcaldia dts) {
        sSQL = "insert into alcaldia (nombrealcaldia,nit,telefono,idmunicipio,idalcalde)"
                + "values (?,?,?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrealcaldia());
            pst.setString(2, dts.getNit());
            pst.setString(3, dts.getTelefono());
            pst.setInt(4, dts.getIdmunicipio());
            pst.setInt(5, dts.getIdpersona());

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

    public boolean editar(Alcaldia dts) {
        sSQL = "update alcaldia set nombrealcaldia=?,nit=?,telefono=?,idmunicipio=?,idalcalde=?"
                + " where idalcaldia=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombrealcaldia());
            pst.setString(2, dts.getNit());
            pst.setString(3, dts.getTelefono());
            pst.setInt(4, dts.getIdmunicipio());
            pst.setInt(5, dts.getIdpersona());
            pst.setInt(6, dts.getIdalcaldia());

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

    public boolean eliminar(Alcaldia dts) {

        sSQL = "delete from alcaldia where idalcaldia=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdalcaldia());

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

    public ArrayList<Alcaldia> mostraralcaldias() {
        ArrayList<Alcaldia> lista = new ArrayList<>();
        try {
            sSQL = "select al.idalcaldia,\n"
                    + "al.nombrealcaldia,\n"
                    + "al.nit,\n"
                    + "al.telefono,\n"
                    + "muni.idmunicipio,\n"
                    + "(muni.nombre) as nombremunicipio,\n"
                    + "alc.idpersona,\n"
                    + "(per.nombre) as nombrealcalde,\n"
                    + "per.apellidos \n"
                    + "from alcaldia as al \n"
                    + "inner join alcaldes as alc on alc.idpersona=al.idalcalde \n"
                    + "inner join persona as per on per.idpersona=alc.idpersona \n"
                    + "inner join municipios as muni on muni.idmunicipio=al.idmunicipio";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Alcaldia a = new Alcaldia(rs.getInt("idalcaldia"), rs.getString("nombrealcaldia"), rs.getString("nit"), rs.getString("telefono"),
                        rs.getInt("idpersona"),new Alcalde(rs.getInt("idpersona"), rs.getString("nombrealcalde"), rs.getString("apellidos")),
                        rs.getInt("idmunicipio"),new Municipio(rs.getInt("idmunicipio"), rs.getString("nombremunicipio")));
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

    /*metodo para llenar la lista con lo que posee la base de datos*/
    public ArrayList<Alcaldia> llenarlista(ArrayList<Alcaldia> d) {
        la = new ldAlcaldias();
        for (int i = 0; i < d.size(); i++) {
            la.insertar(d.get(i));
        }
        return la.toArrayAsc();
    }
}
