/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcaldia;

import alcaldes.Alcalde;
import municipios.Municipio;

/**
 *
 * @author Hernandez
 */
public class Alcaldia {
    private int idalcaldia;
    private String nombrealcaldia;
    private String nit;
    private String telefono;
    private int idpersona;
    private Alcalde alcalde;
    private int idmunicipio;
    private Municipio municipio;

    public Alcaldia() {
    }

    public Alcaldia(String nombrealcaldia) {
        this.nombrealcaldia = nombrealcaldia;
    }

    public Alcaldia(int idalcaldia, String nombrealcaldia, String nit, String telefono, int idpersona, Alcalde alcalde, int idmunicipio, Municipio municipio) {
        this.idalcaldia = idalcaldia;
        this.nombrealcaldia = nombrealcaldia;
        this.nit = nit;
        this.telefono = telefono;
        this.idpersona = idpersona;
        this.alcalde = alcalde;
        this.idmunicipio = idmunicipio;
        this.municipio = municipio;
    }

    public Alcaldia(int idalcaldia, String nombrealcaldia, String nit, String telefono, Alcalde alcalde, Municipio municipio) {
        this.idalcaldia = idalcaldia;
        this.nombrealcaldia = nombrealcaldia;
        this.nit = nit;
        this.telefono = telefono;
        this.alcalde = alcalde;
        this.municipio = municipio;
    }

    public Alcaldia(int idalcaldia, String nombrealcaldia, String nit, String telefono) {
        this.idalcaldia = idalcaldia;
        this.nombrealcaldia = nombrealcaldia;
        this.nit = nit;
        this.telefono = telefono;
    }

    public Alcaldia(int idalcaldia, String nombrealcaldia, String nit) {
        this.idalcaldia = idalcaldia;
        this.nombrealcaldia = nombrealcaldia;
        this.nit = nit;
    }

    public int getIdalcaldia() {
        return idalcaldia;
    }

    public void setIdalcaldia(int idalcaldia) {
        this.idalcaldia = idalcaldia;
    }

    public String getNombrealcaldia() {
        return nombrealcaldia;
    }

    public void setNombrealcaldia(String nombrealcaldia) {
        this.nombrealcaldia = nombrealcaldia;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public Alcalde getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(Alcalde alcalde) {
        this.alcalde = alcalde;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

}
