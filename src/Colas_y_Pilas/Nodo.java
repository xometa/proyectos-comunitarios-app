/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas_y_Pilas;

/**
 *
 * @author Sony
 */
public class Nodo<E> {
    E dato;
    Nodo next;

    public Nodo(E dato, Nodo next) {
        this.dato = dato;
        this.next = next;
    }

    public Nodo(E dato) {
        this.dato = dato;
        next = null;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
 
}
