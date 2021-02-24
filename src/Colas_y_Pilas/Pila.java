/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas_y_Pilas;

import java.util.ArrayList;

/**
 *
 * @author Sony
 */
public class Pila<E> {

    Nodo pila;

    public Pila() {
        pila = null;
    }

    public boolean isEmpty() {
        return pila == null;
    }

    public void push(E dato) {
        Nodo nodito=new Nodo(dato);
        nodito.setNext(pila);
        pila=nodito;

//        Nodo nodito = new Nodo(dato, pila);
//
//        pila = nodito;

    }

    public E pop() {
        E aux = null;
        if (!isEmpty()) {
            aux = (E) pila.getDato();
            pila = pila.getNext();
        }
        return aux;
    }

    public E peek() {
        if(!isEmpty()){
        return (E) pila.getDato();
        }else{
            return null;
        }
    }
    
    public ArrayList<E> toArrayList(){
        ArrayList<E> a= new ArrayList();
        Nodo aux=pila;
        while(aux!=null){
            a.add((E)aux.getDato());
            aux=aux.getNext();
        }
       return a;
    }
}
