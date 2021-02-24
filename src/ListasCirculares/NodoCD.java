/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasCirculares;

/**
 *
 * @author Hernandez
 */
public class NodoCD<E> {
    private E dato;
   private NodoCD sig;
   private NodoCD ant;

    public NodoCD(E dato, NodoCD sig, NodoCD ant) {
        this.dato = dato;
        this.sig = sig;
        this.ant = ant;
    }

    public NodoCD(E dato) {
        this.dato = dato;
        this.sig = null;
        this.ant = null;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoCD getSig() {
        return sig;
    }

    public void setSig(NodoCD sig) {
        this.sig = sig;
    }

    public NodoCD getAnt() {
        return ant;
    }

    public void setAnt(NodoCD ant) {
        this.ant = ant;
    }
}
