/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasSimples;


/**
 *
 * @author Hernandez
 */
public class Nodo<E> {
   private E a;
    private Nodo siguiente;

    public Nodo() {
    }

    public Nodo(E a) {
        this.a = a;
        this.siguiente = null;
    }

    public Nodo(E a, Nodo siguiente) {
        this.a = a;
        this.siguiente = siguiente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public E getA() {
        return a;
    }

    public void setA(E a) {
        this.a = a;
    } 
}
