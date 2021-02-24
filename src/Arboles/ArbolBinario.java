/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import alcaldes.Alcalde;
import java.util.ArrayList;
import usuarios.Usuario;

/**
 *
 * @author Informatica
 */
public class ArbolBinario<T> {

    NodoArbol raiz;
    ArrayList arbolito;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    protected ArrayList preOrdenNID(NodoArbol r) {
        if (r != null) {/*siempre que sea diferente de vacio*/

            arbolito.add(r.getDato());/*add el dato el arreglo*/

            preOrdenNID(r.getIzdo());/*llamando asi mismo el metodo ya que es recursivo para que se valla a la rama izquierda*/

            preOrdenNID(r.getDcho());/*llamando asi mismo el metodo ya que es recursivo para que se valla a la rama derecha*/

        }
        return arbolito;
    }

    protected ArrayList inOrdenIND(NodoArbol r) {
        if (r != null) {
            inOrdenIND(r.getIzdo());
            arbolito.add(r.getDato());
            inOrdenIND(r.getDcho());
        }
        return arbolito;
    }

    protected ArrayList postOrdenIDN(NodoArbol r) {

        if (r != null) {
            postOrdenIDN(r.getIzdo());
            postOrdenIDN(r.getDcho());
            arbolito.add(r.getDato());
        }
        return arbolito;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public ArrayList getArbolito() {
        return arbolito;
    }

    public void setArbolito(ArrayList arbolito) {
        this.arbolito = arbolito;
    }

    /*Metodos de comparacion*/
 /*Metodos de comparacion*/
    public int comparecadenas(T dato, NodoArbol n) {
        return ((Usuario) dato).getNombre().compareToIgnoreCase(((Usuario) n.getDato()).getNombre());
    }

    /*este para las primary key de el registro de los alcaldes*/
    public int compare(T dato, NodoArbol n) {
        if (((Alcalde) dato).getIdpersona() < ((Alcalde) n.getDato()).getIdpersona()) {
            return -1;
        } else if (((Alcalde) dato).getIdpersona() > ((Alcalde) n.getDato()).getIdpersona()) {
            return 1;
        } else {
            return 0;
        }

    }

    public int compare(int dato, NodoArbol n) {
        if (dato < ((int) n.getDato())) {
            return -1;
        } else if (dato > ((int) n.getDato())) {
            return 1;
        } else {
            return 0;
        }
    }

    /*regla para insertar izquierda menores y la derecha los mayores
      para eliminar se ve si es una hoja solo se elimina y si tiene solo un hijo el hijo sustitiye el padre
    y si tiene dos hijos el que esta mas a la izquierda de la rama derecha y la otra que esta mas a la izqierda se el que
    eysta mas a la derecha
    
     */
    public boolean isHoja(NodoArbol r) {
        return r.getIzdo() == null && r.getDcho() == null;
    }

}
