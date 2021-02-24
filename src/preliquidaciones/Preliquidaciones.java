/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preliquidaciones;

import java.io.Serializable;
import proyectos.Proyectos;

/**
 *
 * @author Hernandez
 */
public class Preliquidaciones implements Serializable{
    private int idpreliquidacion;
    private String clasedeobra;
    private String capitulo;
    private double precioproyecto;
    private double unidadesproyecto;
    private double importeproyecto;
    private double unidadespreliquidaciones;
    private double importepreliquidaciones;
    private double diferencia;
    private int idproyecto;
    private Proyectos proyectos;

    public Preliquidaciones() {
    }

    public Preliquidaciones(int idpreliquidacion, String clasedeobra, String capitulo, double precioproyecto, double unidadesproyecto, double importeproyecto, double unidadespreliquidaciones, double importepreliquidaciones, double diferencia, int idproyecto, Proyectos proyectos) {
        this.idpreliquidacion = idpreliquidacion;
        this.clasedeobra = clasedeobra;
        this.capitulo = capitulo;
        this.precioproyecto = precioproyecto;
        this.unidadesproyecto = unidadesproyecto;
        this.importeproyecto = importeproyecto;
        this.unidadespreliquidaciones = unidadespreliquidaciones;
        this.importepreliquidaciones = importepreliquidaciones;
        this.diferencia = diferencia;
        this.idproyecto = idproyecto;
        this.proyectos = proyectos;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public int getIdpreliquidacion() {
        return idpreliquidacion;
    }

    public void setIdpreliquidacion(int idpreliquidacion) {
        this.idpreliquidacion = idpreliquidacion;
    }

    public String getClasedeobra() {
        return clasedeobra;
    }

    public void setClasedeobra(String clasedeobra) {
        this.clasedeobra = clasedeobra;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public double getPrecioproyecto() {
        return precioproyecto;
    }

    public void setPrecioproyecto(double precioproyecto) {
        this.precioproyecto = precioproyecto;
    }

    public double getUnidadesproyecto() {
        return unidadesproyecto;
    }

    public void setUnidadesproyecto(double unidadesproyecto) {
        this.unidadesproyecto = unidadesproyecto;
    }

    public double getImporteproyecto() {
        return importeproyecto;
    }

    public void setImporteproyecto(double importeproyecto) {
        this.importeproyecto = importeproyecto;
    }

    public double getUnidadespreliquidaciones() {
        return unidadespreliquidaciones;
    }

    public void setUnidadespreliquidaciones(double unidadespreliquidaciones) {
        this.unidadespreliquidaciones = unidadespreliquidaciones;
    }

    public double getImportepreliquidaciones() {
        return importepreliquidaciones;
    }

    public void setImportepreliquidaciones(double importepreliquidaciones) {
        this.importepreliquidaciones = importepreliquidaciones;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }
    
}
