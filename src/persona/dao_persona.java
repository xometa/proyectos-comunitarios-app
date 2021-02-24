/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

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
public class dao_persona {
    private conexion mysql = new conexion();
    private Connection cn = mysql.getConexion();
    PreparedStatement pst;
    PreparedStatement pst2;
    ResultSet rs;
    private String sSQL = "";
    
    /*Metodo para generar los id de los usuarios para que no halla problemas al ingresar un nuevo usuario con respecto a las primary jey de los alcaldes*/
    public ArrayList<Persona> datospersona() {
        ArrayList<Persona> lista = new ArrayList<>();
        try {
            sSQL = "select p.idpersona,p.nombre,p.apellidos,p.fechanacimiento,p.dui,p.nit,p.profesion,p.sexo from persona as p";

            pst = cn.prepareStatement(sSQL);
            rs = pst.executeQuery();
            while (rs.next()) {
                Persona u = new Persona();
                u.setIdpersona(rs.getInt("idpersona"));
                u.setNombre(rs.getString("nombre"));
                u.setApellidos(rs.getString("apellidos"));
                u.setFechanacimiento(rs.getDate("fechanacimiento"));
                u.setDui(rs.getString("dui"));
                u.setNit(rs.getString("nit"));
                u.setProfesion(rs.getString("profesion"));
                u.setSexo(rs.getString("sexo"));
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
}
