/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zonas;

import java.io.Serializable;

/**
 *
 * @author Sony
 */
public class zonas implements Serializable{
    private int id;
    private String nombre;
    private String codigo;

    public zonas() {
    }

    public zonas(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public zonas(String nombre) {
        this.nombre = nombre;
    }

    public zonas(int id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
