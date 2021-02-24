/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipios;

import departamentos.Departamentos;

/**
 *
 * @author Hernandez
 */
public class Municipio {
    private int idmunicipio;
    private String nombre;
    private String codigo;
    private int iddepartamento;
    private Departamentos departamentos;

    public Municipio() {
    }

    public Municipio(String nombre) {
        this.nombre = nombre;
    }

    public Municipio(int idmunicipio, String nombre, String codigo, Departamentos departamentos) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.departamentos = departamentos;
    }

    public Municipio(String nombre, String codigo, int iddepartamento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.iddepartamento = iddepartamento;
    }

    public Municipio(String nombre, String codigo, int iddepartamento, Departamentos departamentos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.iddepartamento = iddepartamento;
        this.departamentos = departamentos;
    }

    public Municipio(int idmunicipio, String nombre, String codigo, int iddepartamento) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.iddepartamento = iddepartamento;
    }

    public Municipio(int idmunicipio, String nombre, String codigo, int iddepartamento, Departamentos departamentos) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.iddepartamento = iddepartamento;
        this.departamentos = departamentos;
    }

    public Municipio(int idmunicipio, String nombre) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }
    
}
