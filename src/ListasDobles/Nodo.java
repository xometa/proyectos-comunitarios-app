/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDobles;


/**
 *
 * @author Hernandez
 */
public class Nodo<E> {
    private E dato;
    private Nodo ant;
    private Nodo sig;

    public Nodo(E dato) {
        this.dato = dato;
        this.ant = null;
        this.sig = null;
    }

    public Nodo(E dato, Nodo ant, Nodo sig) {
        this.dato = dato;
        this.ant = ant;
        this.sig = sig;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }
    
}
