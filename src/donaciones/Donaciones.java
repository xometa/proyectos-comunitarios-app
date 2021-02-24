/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donaciones;

import donantes.Donantes;
import java.io.Serializable;
import java.sql.Date;
import proyectos.Proyectos;

/**
 *
 * @author Hernandez
 */
public class Donaciones implements Serializable {

    private int iddonaciones;
    private int iddonantes;
    private Donantes donantes;
    private int idproyecto;
    private Proyectos proyectos;
    private double montodonar;
    private Date fecha;

    public Donaciones() {
    }

    public Donaciones(Donantes donantes) {
        this.donantes = donantes;
    }

    public Donaciones(int iddonaciones, int iddonantes, Donantes donantes, int idproyecto, Proyectos proyectos, double montodonar, Date fecha) {
        this.iddonaciones = iddonaciones;
        this.iddonantes = iddonantes;
        this.donantes = donantes;
        this.idproyecto = idproyecto;
        this.proyectos = proyectos;
        this.montodonar = montodonar;
        this.fecha = fecha;
    }

    public Donaciones(int iddonaciones, Donantes donantes, Proyectos proyectos, double montodonar, Date fecha) {
        this.iddonaciones = iddonaciones;
        this.donantes = donantes;
        this.proyectos = proyectos;
        this.montodonar = montodonar;
        this.fecha = fecha;
    }

    public int getIddonaciones() {
        return iddonaciones;
    }

    public void setIddonaciones(int iddonaciones) {
        this.iddonaciones = iddonaciones;
    }

    public int getIddonantes() {
        return iddonantes;
    }

    public void setIddonantes(int iddonantes) {
        this.iddonantes = iddonantes;
    }

    public Donantes getDonantes() {
        return donantes;
    }

    public void setDonantes(Donantes donantes) {
        this.donantes = donantes;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public double getMontodonar() {
        return montodonar;
    }

    public void setMontodonar(double montodonar) {
        this.montodonar = montodonar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
