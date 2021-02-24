/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import java.sql.Date;
import persona.Persona;

/**
 *
 * @author Hernandez
 */
public class Usuario extends Persona{
    private int idpersonauser;
    private String codigo;
    private String usuario;
    private String contraseña;
    private String cargo;
    private String tipouser;

    public Usuario() {
    }

    public Usuario(int idpersona) {
        super(idpersona);
    }

    public Usuario(int idpersonauser, String codigo, String usuario, String contraseña, String tipouser) {
        this.idpersonauser = idpersonauser;
        this.codigo = codigo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipouser = tipouser;
    }

    public Usuario(int idpersonauser, String codigo, String usuario, String contraseña, String tipouser, String nombre, String apellidos, Date fechanacimiento, String dui, String nit, String profesion, String sexo) {
        super(nombre, apellidos, fechanacimiento, dui, nit, profesion, sexo);
        this.idpersonauser = idpersonauser;
        this.codigo = codigo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipouser = tipouser;
    }

    public Usuario(int idpersonauser, String codigo, String usuario, String contraseña, String tipouser, int idpersona, String nombre, String apellidos, Date fechanacimiento, String dui, String nit, String profesion, String sexo) {
        super(idpersona, nombre, apellidos, fechanacimiento, dui, nit, profesion, sexo);
        this.idpersonauser = idpersonauser;
        this.codigo = codigo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipouser = tipouser;
    }

    public Usuario(int idpersonauser, int idpersona, String nombre, String apellidos) {
        super(idpersona, nombre, apellidos);
        this.idpersonauser = idpersonauser;
    }


    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdpersonauser() {
        return idpersonauser;
    }

    public void setIdpersonauser(int idpersonauser) {
        this.idpersonauser = idpersonauser;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
