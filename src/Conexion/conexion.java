/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Sony
 */
public class conexion {

     private static Connection conexion = null;
    private static final ResultSet rs = null;
    private static Statement sentencia = null;
    private static final PreparedStatement ps = null;
    private static final String url = "jdbc:mysql://localhost/estructura";
    private static final String usuario = "root";
    private static final String password = "";

    public Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            // Obtener la conexion
            con = (Connection) DriverManager.getConnection(url, usuario, password);
            System.out.println("conectando a la DB");
        } catch (SQLException ex) {
        } catch (Exception e) {
        }
        return con;
    }

    public void cerrarConexiones() {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar el Statement" + e);
            }
        }
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion a la bd" + e);
            }
        }
    }
}
