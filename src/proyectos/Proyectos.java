/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;

import alcaldia.Alcaldia;
import comunidades.Comunidades;
import java.io.Serializable;
import java.sql.Date;
import usuarios.Usuario;

/**
 *
 * @author Hernandez
 */
public class Proyectos implements Serializable{
    private int idproyecto;
    private String codigoproyecto;
    private String descripción;
    private double monto;
    private Date fechainicia;
    private Date fechafinaliza;
    private String estado;
    private int idalcaldia;
    private Alcaldia alcaldia;
    private int idcomunidad;
    private Comunidades comunidades;
    private int iduser;
    private Usuario usuario;

    public Proyectos() {
    }

    public Proyectos(String codigoproyecto) {
        this.codigoproyecto = codigoproyecto;
    }

    /*para la clase donaciones*/
    public Proyectos(int idproyecto, String codigoproyecto, String descripción, double monto, Date fechainicia, Date fechafinaliza, String estado) {
        this.idproyecto = idproyecto;
        this.codigoproyecto = codigoproyecto;
        this.descripción = descripción;
        this.monto = monto;
        this.fechainicia = fechainicia;
        this.fechafinaliza = fechafinaliza;
        this.estado = estado;
    }

    public Proyectos(int idproyecto, String codigoproyecto, String descripción, double monto, Date fechainicia, Date fechafinaliza, String estado, int idalcaldia, Alcaldia alcaldia, int idcomunidad, Comunidades comunidades, int iduser, Usuario usuario) {
        this.idproyecto = idproyecto;
        this.codigoproyecto = codigoproyecto;
        this.descripción = descripción;
        this.monto = monto;
        this.fechainicia = fechainicia;
        this.fechafinaliza = fechafinaliza;
        this.estado = estado;
        this.idalcaldia = idalcaldia;
        this.alcaldia = alcaldia;
        this.idcomunidad = idcomunidad;
        this.comunidades = comunidades;
        this.iduser = iduser;
        this.usuario = usuario;
    }

    public Proyectos(int idproyecto, String codigoproyecto, String descripción, double monto, Date fechainicia, Date fechafinaliza, String estado, Alcaldia alcaldia, Comunidades comunidades, Usuario usuario) {
        this.idproyecto = idproyecto;
        this.codigoproyecto = codigoproyecto;
        this.descripción = descripción;
        this.monto = monto;
        this.fechainicia = fechainicia;
        this.fechafinaliza = fechafinaliza;
        this.estado = estado;
        this.alcaldia = alcaldia;
        this.comunidades = comunidades;
        this.usuario = usuario;
    }

    public int getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(int idproyecto) {
        this.idproyecto = idproyecto;
    }

    public String getCodigoproyecto() {
        return codigoproyecto;
    }

    public void setCodigoproyecto(String codigoproyecto) {
        this.codigoproyecto = codigoproyecto;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechainicia() {
        return fechainicia;
    }

    public void setFechainicia(Date fechainicia) {
        this.fechainicia = fechainicia;
    }

    public Date getFechafinaliza() {
        return fechafinaliza;
    }

    public void setFechafinaliza(Date fechafinaliza) {
        this.fechafinaliza = fechafinaliza;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdalcaldia() {
        return idalcaldia;
    }

    public void setIdalcaldia(int idalcaldia) {
        this.idalcaldia = idalcaldia;
    }

    public Alcaldia getAlcaldia() {
        return alcaldia;
    }

    public void setAlcaldia(Alcaldia alcaldia) {
        this.alcaldia = alcaldia;
    }

    public int getIdcomunidad() {
        return idcomunidad;
    }

    public void setIdcomunidad(int idcomunidad) {
        this.idcomunidad = idcomunidad;
    }

    public Comunidades getComunidades() {
        return comunidades;
    }

    public void setComunidades(Comunidades comunidades) {
        this.comunidades = comunidades;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
