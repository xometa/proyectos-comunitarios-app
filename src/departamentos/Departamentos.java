/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package departamentos;

import Conexion.conexion;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import zonas.zonas;

/**
 *
 * @author Sony
 */
public class Departamentos implements Serializable{
    int iddepartamento;
    String nombre;
    String codigo;
    int idzona;
    zonas zonas;

    public Departamentos() {
    }

    public Departamentos(String nombre) {
        this.nombre = nombre;
    }

    public Departamentos(int iddepartamento, String nombre, String codigo) {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Departamentos(int iddepartamento, String nombre) {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
    }

    public Departamentos(zonas zonas) {
        this.zonas = zonas;
    }

    public Departamentos(int iddepartamento, String nombre, String codigo, zonas zonas) {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
        this.codigo = codigo;
        this.zonas = zonas;
    }

    public Departamentos(int iddepartamento, String nombre, String codigo, int idzona) {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idzona = idzona;
    }

    public zonas getZonas() {
        return zonas;
    }

    public void setZonas(zonas zonas) {
        this.zonas = zonas;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

}
