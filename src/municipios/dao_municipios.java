/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipios;

import Conexion.conexion;
import ListasSimples.lsMunicipios;
import departamentos.Departamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Xometa
 */
public class dao_municipios {
    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    ResultSet rs;
    private String sSQL = "";
    private String sSQL2 = "";
    public lsMunicipios lsm=new lsMunicipios();

    public boolean insertar(Municipio dts) {
        sSQL = "insert into municipios (nombre,codigo,iddepartamento)"
                + "values (?,?,?)";
        try {
            pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIddepartamento());

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

    public boolean editar(Municipio dts) {
        sSQL = "update municipios set nombre=?,codigo=?,iddepartamento=?"
                + " where idmunicipio=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getCodigo());
            pst.setInt(3, dts.getIddepartamento());
            pst.setInt(4, dts.getIdmunicipio());

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

    public boolean eliminar(Municipio dts) {

        sSQL = "delete from municipios where idmunicipio=?";
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

    public ArrayList<Municipio> consultamunicipios() {
        ArrayList<Municipio> lista = new ArrayList<>();
        try {
            sSQL="select m.idmunicipio,m.nombre,m.codigo,d.iddepartamento,(d.nombre) as nombredepar from municipios as m inner join departamentos as d on d.iddepartamento=m.iddepartamento";
//            where (nombre LIKE'" + c + "%' OR "
//                    + "codigo LIKE'" + c + "%' OR "
//                            + "idzona LIKE'" + c + "%')
            pst= cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Municipio de = new Municipio(rs.getInt("idmunicipio"), rs.getString("nombre"),
                        rs.getString("codigo"), new Departamentos(rs.getInt("iddepartamento"),rs.getString("nombredepar")));
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
    public ArrayList<Municipio> llenarlista(ArrayList<Municipio> d){
        for (int i =0; i<d.size(); i++) {
            lsm.insertar(d.get(i));
        }
        return lsm.toArray();
    }
}
