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
public class Cola<E> {

    Nodo frente;//para ir quitando
    Nodo fin;//para ir agregando mas

    public Cola() {
        frente = null;
        fin = null;
    }

    public boolean isEmpty() {
        return frente == null;//si el frente es nulo quiere decir esta vacia y el fin es null igual
    }

    public void offer(E dato) {
        Nodo nodito = new Nodo(dato);
        if (isEmpty()) {
            frente = nodito;
        } else {
            fin.setNext(nodito);//guardo el siguiente nodo creado
        }
        fin = nodito;//guarda el nodo contodo y null,em¡ntoces final apunta al ultimo dato ingresado
    }

    public E poll() {
        if (isEmpty()) return null;//Si esta vacia frente y final apuntan a null
        E aux = (E) frente.getDato();//Guardando el dato en un aux

        if (frente == fin) {//Si solo hay un dato ingresado en la cola frente y final apuntando a null
            frente = fin = null;
        } else {
            frente = frente.getNext();//Al sacar un dato de la cola aqui apuntamos al siguiente dato almacenandolo al frente
        }
        return aux;
    }

    //METODOS PARA UNA BICOLA
    //OffertFirst
    public void offertFirts(E dato) {//Inserta al inicio
        Nodo nodito = new Nodo(dato, frente);
        frente = nodito;//apuntan al dato ingresado, frente toma al dato ingresado, y nodito apunta a lo que tenia frente
    }

    public void offerLast(E dato) {//Insert al final
        offer(dato);
    }

    public E pollFirts() {//quita el primero
        return poll();
    }

    public E pollLast() {//quita el final, el ultimo elemento
        if (isEmpty()) return null;
        if (frente == fin) {//SI SOLO HAY UN DATO LLAMAR EL OTRO METODO, SE IGUALAN PORQUE SOLO HAY UN DATO ENTONCES AMBOS DEBEN APUNTAR AL MISMO
            return poll();
        } else {
            E dato = (E) fin.getDato();//SALVANDO EL DATO FINAL YA QUE EL ULTIMO VAMOS A SACAR
            Nodo aux = frente;//Variable auxiliar para tomar el valor del frente
            while (aux.getNext()!= fin) {//Si aux es diferente del final tomara el valor antes del fin
                aux = aux.getNext();//tomamos el valor antes de fin 
            }
            fin = aux;//fin lo igualamos ahora a aux que era el dato anterior como quitamos el dato final que poseia fin primero
            fin.setNext(null);
            return dato;
        }
    }

    //RETORNA EL METODO QUE POSEE LOS DATOS
    public ArrayList<E> mostrar(){
        ArrayList<E> m = new ArrayList();
        Nodo aux = frente;
        while (aux!=null) {
            m.add((E) aux.getDato());
            aux=aux.getNext();
        }
        return m;
    }
}
