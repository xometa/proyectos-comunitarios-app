/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persona;

import java.sql.Date;

/**
 *
 * @author Hernandez
 */
public class Persona {
    private int idpersona;
    private String nombre;
    private String apellidos;
    private Date fechanacimiento;
    private String dui;
    private String nit;
    private String profesion;
    private String sexo;

    public Persona() {
    }

    public Persona(int idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Persona(int idpersona, String nombre, String apellidos, Date fechanacimiento, String dui, String nit, String profesion, String sexo) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.dui = dui;
        this.nit = nit;
        this.profesion = profesion;
        this.sexo = sexo;
    }

    public Persona(String nombre, String apellidos, Date fechanacimiento, String dui, String nit, String profesion, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.dui = dui;
        this.nit = nit;
        this.profesion = profesion;
        this.sexo = sexo;
    }

    public Persona(int idpersona, String nombre, String apellidos) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public String nombrecompleto(){
    return this.nombre+" "+this.apellidos;
    }
}
