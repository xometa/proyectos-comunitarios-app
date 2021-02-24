/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunidades;

import municipios.Municipio;


/**
 *
 * @author Hernandez
 */
public class Comunidades {
    private int idcomunidades;
    private String nombre;
    private String codigo;
    private int idmunicipio;
    private Municipio municipios;

    public Comunidades() {
    }

    public Comunidades(String nombre) {
        this.nombre = nombre;
    }

    public Comunidades(int idmunicipio, String nombre, String codigo, Municipio municipios) {
        this.idmunicipio = idmunicipio;
        this.nombre = nombre;
        this.codigo = codigo;
        this.municipios = municipios;
    }

    public Comunidades(String nombre, String codigo, int idmunicipio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.idmunicipio = idmunicipio;
    }

    public Comunidades(int idcomunidades, String nombre, String codigo, int idmunicipio) {
        this.idcomunidades = idcomunidades;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idmunicipio = idmunicipio;
    }

    public Comunidades(int idcomunidades, String nombre, String codigo, int idmunicipio, Municipio municipios) {
        this.idcomunidades = idcomunidades;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idmunicipio = idmunicipio;
        this.municipios = municipios;
    }

    public Comunidades(int idcomunidades, String nombre) {
        this.idcomunidades = idcomunidades;
        this.nombre = nombre;
    }

    public int getIdcomunidades() {
        return idcomunidades;
    }

    public void setIdcomunidades(int idcomunidades) {
        this.idcomunidades = idcomunidades;
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

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipio getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipio municipios) {
        this.municipios = municipios;
    }

    
}
