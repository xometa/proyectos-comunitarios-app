/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcaldes;

import java.sql.Date;
import persona.Persona;

/**
 *
 * @author Hernandez
 */
public class Alcalde extends Persona{
   private int idalcalde;
   private String tipo;

    public Alcalde() {
    }

    public Alcalde(int idpersona) {
        super(idpersona);
    }
/*constructor para amarrarlo con las alcaldias*/
    public Alcalde(int idalcalde, String nombre, String apellidos) {
        super(nombre, apellidos);
        this.idalcalde = idalcalde;
    }

    public Alcalde(int idalcalde, String tipo, int idpersona, String nombre, String apellidos, Date fechanacimiento, String dui, String nit, String profesion, String sexo) {
        super(idpersona, nombre, apellidos, fechanacimiento, dui, nit, profesion, sexo);
        this.idalcalde = idalcalde;
        this.tipo = tipo;
    }

    public Alcalde(int idalcalde, String tipo, String nombre, String apellidos, Date fechanacimiento, String dui, String nit, String profesion, String sexo) {
        super(nombre, apellidos, fechanacimiento, dui, nit, profesion, sexo);
        this.idalcalde = idalcalde;
        this.tipo = tipo;
    }

    public Alcalde(int idalcalde, String tipo) {
        this.idalcalde = idalcalde;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdalcalde() {
        return idalcalde;
    }

    public void setIdalcalde(int idalcalde) {
        this.idalcalde = idalcalde;
    }
   
}
