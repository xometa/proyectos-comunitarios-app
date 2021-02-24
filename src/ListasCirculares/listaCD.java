/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasCirculares;

import java.util.ArrayList;
import zonas.zonas;

/**
 *
 * @author Hernandez
 */
public class listaCD {

    private NodoCD inicio;
    private NodoCD ultimo;

    public listaCD() {
        this.inicio = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void insertar(zonas dato) {
        NodoCD nuevo = new NodoCD(dato);
        if (isEmpty()) {
            inicio = nuevo;
        } else if (dato.getNombre().compareToIgnoreCase(((zonas) inicio.getDato()).getNombre()) < 0) {
            nuevo.setSig(inicio);
            inicio.setAnt(nuevo);
            inicio = nuevo;
        } else {
            NodoCD aux = ubicar(dato.getNombre());
            nuevo.setSig(aux.getSig());
            nuevo.setAnt(aux);
            if (aux.getSig() != null) {
                aux.getSig().setAnt(nuevo);
            }
            aux.setSig(nuevo);

        }
    }

    public void insertarAlFinal(zonas dato) {
        NodoCD nuevo = new NodoCD(dato);
        NodoCD ini = inicio;
        NodoCD fin = ultimo;
        if (isEmpty()) {
            inicio = nuevo;
        } else {
            while (ini.getSig() != null) {
                ini = ini.getSig();
                fin = ini;
            }
            nuevo.setSig(fin.getSig());
            fin.setSig(nuevo);
        }
    }

    public void insertarAlInicio(zonas dato) {
        NodoCD nuevo = new NodoCD(dato);
        NodoCD ini = inicio;
        NodoCD fin = ultimo;
        if (isEmpty()) {
            inicio = nuevo;
        } else {
            fin = ini;
            nuevo.setSig(fin);
            inicio = nuevo;
        }
    }

    public void insertarantesde(zonas dato, String antes) {
        NodoCD nuevo = new NodoCD(dato);
        NodoCD aux = ubicar(antes);
        nuevo.setSig(aux.getSig());
        aux.setSig(nuevo);
    }

    public void insertardespuesde(zonas dato, String despues) {
        NodoCD nuevo = new NodoCD(dato);
        NodoCD aux = buscar(despues);
        nuevo.setSig(aux.getSig());
        aux.setSig(nuevo);
    }

    /*metodo para ubicar los nodos */
    public NodoCD ubicar(String dato) {
        NodoCD aux = inicio;
        NodoCD ant = inicio;
        while (aux.getSig() != null && (dato.compareToIgnoreCase(((zonas) aux.getDato()).getNombre()) > 0)) {
            ant = aux;
            aux = aux.getSig();
        }
        if (dato.compareToIgnoreCase(((zonas) aux.getDato()).getNombre()) > 0) {
            ant = aux;
        }
        return ant;
    }

    /*metodo para buscar nodos*/
    public NodoCD buscar(String dato) {
        NodoCD aux = inicio;
        while (aux != null) {
            if (dato.compareToIgnoreCase(((zonas) aux.getDato()).getNombre()) == 0) {
                return aux;
            }
            aux = aux.getSig();
        }

        return null;
    }

    /*metodo para eliminar nodos que han sido insertados*/
    public NodoCD eliminar(String dato) {
        NodoCD quitar = buscar(dato);
        if (quitar != null) {
            if (quitar == inicio) {
                inicio = quitar.getSig();
            } else {
                NodoCD aux = ubicar(dato);
                aux.setSig(quitar.getSig());
                if (quitar.getSig() != null) {
                    aux.getSig().setAnt(aux);
                }
            }
        }
//        quitar = null;
        return quitar;
    }

    /*Arreglos para mostrar los datos ascendentemente*/
    public ArrayList<zonas> mostrarAsc() {
        ArrayList<zonas> array = new ArrayList();
        NodoCD aux = inicio;
        while (aux != null) {
            array.add((zonas) aux.getDato());
            aux = aux.getSig();
        }

        return array;
    }

    /*para mostrar los datos desendentemente*/
    public ArrayList<zonas> mostrarDsc() {
        ArrayList<zonas> array = new ArrayList();
        NodoCD aux = inicio;
        while (aux.getSig() != null) {
            aux = aux.getSig();
        }
        while (aux != null) {
            array.add((zonas) aux.getDato());
            aux = aux.getAnt();
        }

        return array;
    }
}
