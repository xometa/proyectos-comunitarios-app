/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ColasdePrioridad;

import java.util.ArrayList;

/**
 *
 * @author Hernandez
 */
public class ColaPrioridad<E> {

    ArrayList<Nodo> cola;

    public ColaPrioridad() {
        cola = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cola.add(null);
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < 3; i++) {
            if (cola.get(i) != null) {
                return false;
            }
        }
        return true;
    }

    public void offer(E dato, int i) {
        Nodo n = new Nodo(dato);
        Nodo frente = cola.get(i);
        Nodo finall = cola.get(i);
        if (cola.get(i) == null) {
            cola.set(i, n);
        } else {

            while (frente.getSig() != null) {
                finall = finall.getSig();
            }
            finall.setSig(n);
        }
    }

    public E poll() {
        E dato = null;
        int p = prioridad();
        if (p >= 0) {
            Nodo fr = cola.get(p);
            dato = (E) fr.getDato();//Para guardar el dato y no perderlo al sacarlo

            fr = fr.getSig();
            cola.set(p, fr);//Para guardar lo queda de la cola siu el nodo que quitamos
        }
        return dato;
    }

    public int prioridad() {
        for (int i = 0; i < 3; i++) {
            if (cola.get(i) != null) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<E> mostrarDatos() {
        ArrayList a = new ArrayList();
        int p = prioridad();
        if (p >= 0) {
            Nodo fr = cola.get(p);
            while (fr != null) {
                a.add(fr.getDato());
                fr.getSig();
            }
            cola.set(p, null);
        }
        return a;
    }

}
