/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunidades;

import Conexion.conexion;
import ListasDobles.ldComunidades;
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
public class dao_comunidades {

    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    private String sSQL2 = "";
    public ldComunidades ldc = new ldComunidades();

    public boolean insertar(Comunidades dts) {
        sSQL = "insert into comunidades (nombre,codigo,idmunicipio)"
                + "values (?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIdmunicipio());

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

    public boolean editar(Comunidades dts) {
        sSQL = "update comunidades set nombre=?,codigo=?,idmunicipio=?"
                + " where idcomunidad=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIdmunicipio());
            pst.setInt(4, dts.getIdcomunidades());

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

    public boolean eliminar(Comunidades dts) {

        sSQL = "delete from comunidades where idcomunidad=?";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdmunicipio());

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

    public ArrayList<Comunidades> consultacomunidades() {
        ArrayList<Comunidades> lista = new ArrayList<>();
        try {
            sSQL = "select c.idcomunidad,"
                    + "c.nombre,"
                    + "c.codigo,"
                    + "m.idmunicipio,(m.nombre) as nombremuni "
                    + "from comunidades as c "
                    + "inner join municipios as m "
                    + "on m.idmunicipio=c.idmunicipio";
//            where (nombre LIKE'" + c + "%' OR "
//                    + "codigo LIKE'" + c + "%' OR "
//                            + "idzona LIKE'" + c + "%')
            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Comunidades de = new Comunidades(rs.getInt("idcomunidad"), rs.getString("nombre"),
                        rs.getString("codigo"), new Municipio(rs.getInt("idmunicipio"),
                        rs.getString("nombremuni")));
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

    /*metodo para llenar la lista con lo que posee la base de datos*/
    public ArrayList<Comunidades> llenarlista(ArrayList<Comunidades> d) {
        for (int i = 0; i < d.size(); i++) {
            ldc.insertar(d.get(i));
        }
        return ldc.toArrayAsc();
    }
}
