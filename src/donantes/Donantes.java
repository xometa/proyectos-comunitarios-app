/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donantes;

import java.io.Serializable;

/**
 *
 * @author Sony
 */
public class Donantes implements Serializable{
    private int iddonantes;
    private String nombre;
    private String empresa;
    private String email;
    private String direccion;
    private String codigopostal;
    private String ciudad;
    private String telefono;
    private String tipo;
    private String pais;

    public Donantes() {
    }

    public Donantes(String nombre) {
        this.nombre = nombre;
    }
/*para la clase donaciones*/
    public Donantes(int iddonantes, String nombre, String empresa, String email, String direccion) {
        this.iddonantes = iddonantes;
        this.nombre = nombre;
        this.empresa = empresa;
        this.email = email;
        this.direccion = direccion;
    }

    public Donantes(int iddonantes, String nombre, String empresa, String email, String direccion, String codigopostal, String ciudad, String telefono) {
        this.iddonantes = iddonantes;
        this.nombre = nombre;
        this.empresa = empresa;
        this.email = email;
        this.direccion = direccion;
        this.codigopostal = codigopostal;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public Donantes(int iddonantes, String nombre, String empresa, String email, String direccion, String codigopostal, String ciudad, String telefono, String tipo, String pais) {
        this.iddonantes = iddonantes;
        this.nombre = nombre;
        this.empresa = empresa;
        this.email = email;
        this.direccion = direccion;
        this.codigopostal = codigopostal;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.tipo = tipo;
        this.pais = pais;
    }

    public Donantes(String nombre, String empresa, String email, String direccion, String codigopostal, String ciudad, String telefono, String tipo, String pais) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.email = email;
        this.direccion = direccion;
        this.codigopostal = codigopostal;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.tipo = tipo;
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIddonantes() {
        return iddonantes;
    }

    public void setIddonantes(int iddonantes) {
        this.iddonantes = iddonantes;
    }
    
    
}
