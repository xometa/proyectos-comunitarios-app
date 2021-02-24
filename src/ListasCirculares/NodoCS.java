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
public class NodoCS<E> {
    E dato;
   NodoCS siguiente;

    public NodoCS(E dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoCS(E dato, NodoCS siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public NodoCS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCS siguiente) {
        this.siguiente = siguiente;
    }
}
