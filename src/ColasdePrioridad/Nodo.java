/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColasdePrioridad;

/**
 *
 * @author Hernandez
 */
public class Nodo<E> {

    private E dato;
    private Nodo sig;

    public Nodo(E dato, Nodo sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public Nodo(E dato) {
        this.dato = dato;
        this.sig = null;
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

}
