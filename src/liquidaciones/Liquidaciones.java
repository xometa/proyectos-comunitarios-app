/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liquidaciones;

import java.io.Serializable;

/**
 *
 * @author Hernandez
 */
public class Liquidaciones implements Serializable{
    private String capitulo;
    private double montoproy;
    private double montopre;
    private double diferencia;
    private int idproyecto;

    public Liquidaciones() {
    }

    public Liquidaciones(String capitulo, double montoproy, double montopre, double diferencia, int idproyecto) {
        this.capitulo = capitulo;
        this.montoproy = montoproy;
        this.montopre = montopre;
        this.diferencia = diferencia;
        this.idproyecto = idproyecto;
    }

    public Liquidaciones(String capitulo, double montoproy, double montopre, double diferencia) {
        this.capitulo = capitulo;
        this.montoproy = montoproy;
        this.montopre = montopre;
        this.diferencia = diferencia;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public double getMontoproy() {
        return montoproy;
    }

    public void setMontoproy(double montoproy) {
        this.montoproy = montoproy;
    }

    public double getMontopre() {
        return montopre;
    }

    public void setMontopre(double montopre) {
        this.montopre = montopre;
    }
    
}
