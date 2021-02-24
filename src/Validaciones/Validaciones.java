package Validaciones;

import alcaldia.Alcaldia;
import alcaldia.dao_alcaldia;
import comunidades.Comunidades;
import comunidades.dao_comunidades;
import departamentos.Departamentos;
import departamentos.dao_departamentos;
import donaciones.Donaciones;
import donaciones.dao_donaciones;
import municipios.Municipio;
import municipios.dao_municipios;
import preliquidaciones.Preliquidaciones;
import preliquidaciones.dao_preliquidaciones;
import proyectos.Proyectos;
import proyectos.dao_proyectos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hernandez
 */
public class Validaciones {

    dao_departamentos dp = new dao_departamentos();
    dao_municipios dm = new dao_municipios();
    dao_comunidades dc = new dao_comunidades();
    dao_alcaldia da = new dao_alcaldia();
    dao_donaciones dd = new dao_donaciones();
    dao_preliquidaciones dpr = new dao_preliquidaciones();
    dao_proyectos dpro = new dao_proyectos();

    public Validaciones() {
    }

    /*Metodos de busqueda de los id en las listas o arboles*/
    public Departamentos buscaridzona(int id) {

        for (Departamentos d : dp.llenarlistacircularsimple(dp.consultadepartamentos())) {
            if (d.getZonas().getId() == id) {
                return d;
            }
        }
        return null;
    }

    public Municipio buscariddepartamento(int id) {

        for (Municipio m : dm.llenarlista(dm.consultamunicipios())) {
            if (m.getDepartamentos().getIddepartamento() == id) {
                return m;
            }
        }
        return null;
    }

    public Comunidades buscaridmunicipio(int id) {

        for (Comunidades c : dc.llenarlista(dc.consultacomunidades())) {
            if (c.getMunicipios().getIdmunicipio() == id) {
                return c;
            }
        }
        return null;
    }

    public Alcaldia buscaridmuni(int id) {

        for (Alcaldia a : da.llenarlista(da.mostraralcaldias())) {
            if (a.getMunicipio().getIdmunicipio() == id) {
                return a;
            }
        }
        return null;
    }

    public Alcaldia buscaridalcalde(int id) {

        for (Alcaldia a : da.llenarlista(da.mostraralcaldias())) {
            if (a.getIdpersona() == id) {
                return a;
            }
        }
        return null;
    }

    public Donaciones buscardonaciones(int iddonante, int idproyecto) {
        for (Donaciones d : dd.llenarlistadonaciones(dd.mostrardonaciones(""))) {
            if (d.getProyectos().getIdproyecto() == idproyecto || d.getDonantes().getIddonantes() == iddonante) {
                return d;
            }
        }
        return null;
    }

    public Preliquidaciones buscarproyec(int id) {
        for (Preliquidaciones p : dpr.noeliminacion()) {
            if (p.getProyectos().getIdproyecto() == id) {
                return p;
            }
        }
        return null;
    }

    public Proyectos buscaruser(int id,int idcomuni,int idalcaldia) {
        for (Proyectos p : dpro.mostrartodosproyectos()) {
            if (p.getIduser() == id || p.getIdcomunidad()==idcomuni || p.getIdalcaldia()==idalcaldia) {
                return p;
            }
        }
        return null;
    }
}
