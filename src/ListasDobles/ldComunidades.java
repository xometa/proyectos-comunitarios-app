/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasDobles;

import comunidades.Comunidades;
import java.util.ArrayList;

/**
 *
 * @author Hernandez
 */
public class ldComunidades {

    private Nodo lista;

    public ldComunidades() {
        this.lista = null;
    }

    public boolean isEmpty() {
        return lista == null;
    }

    public void insertar(Comunidades dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else if (dato.getNombre().compareToIgnoreCase(((Comunidades) lista.getDato()).getNombre()) < 0) {
            nuevo.setSig(lista);
            lista.setAnt(nuevo);
            lista = nuevo;
        } else {
            Nodo aux = ubicar(dato);
            nuevo.setSig(aux.getSig());
            nuevo.setAnt(aux);
            if (aux.getSig() != null) {
                nuevo.getSig().setAnt(nuevo);//primera forma
                //aux.getSig().setAnt(nuevo);//segunda forma
            }
            aux.setSig(nuevo);
        }
    }

    public Nodo ubicar(Comunidades dato) {
        Nodo aux = lista;
        Nodo ant = lista;
        while (aux.getSig() != null && (dato.getNombre().compareToIgnoreCase(((Comunidades) aux.getDato()).getNombre()) > 0)) {
            ant = aux;
            aux = aux.getSig();
        }
        if (dato.getNombre().compareToIgnoreCase(((Comunidades) aux.getDato()).getNombre()) > 0) {
            ant = aux;
        }
        return ant;
    }

    public Nodo ubicarotro(Comunidades dato) {
        Nodo aux = lista;
        Nodo ant = lista;
        while (aux.getSig() != null && (dato.getNombre().compareToIgnoreCase(((Comunidades) aux.getDato()).getNombre()) != 0)) {
            ant = aux;
            aux = aux.getSig();
        }
        if (dato.getNombre().compareToIgnoreCase(((Comunidades) aux.getDato()).getNombre()) != 0) {
            ant = aux;
        }
        return ant;
    }

    public Nodo buscar(Comunidades dato) {
        Nodo aux = lista;
        while (aux != null) {
            if (dato.getNombre().compareToIgnoreCase(((Comunidades) aux.getDato()).getNombre()) == 0) {
                return aux;
            }
            aux = aux.getSig();
        }
        return null;
    }

    public Nodo Eliminar(Comunidades dato) {
        Nodo eliminar = buscar(dato);
        if (eliminar != null) {
            if (eliminar == lista) {//que se el primer numero. la lista pasara al siguiente 
                lista = eliminar.getSig();
                //lista.setAnt(null); // no es necesario ya que eliminar el igual a null
            } else {
                Nodo aux = ubicar(dato);
                aux.setSig(eliminar.getSig());
                if (eliminar.getSig() != null) {
                    eliminar.getSig().setAnt(aux);
                }

            }
        }
        return eliminar;
    }

    public ArrayList toArrayAsc() {
        ArrayList list = new ArrayList<>();
        Nodo aux = lista;
        while (aux != null) {
            list.add(aux.getDato());
            aux = aux.getSig();
        }
        return list;
    }

    public ArrayList toArrayDsc() {
        ArrayList list = new ArrayList<>();
        Nodo aux = lista;
        while (aux.getSig() != null) {
            aux = aux.getSig();
        }
        while (aux != null) {
            list.add(aux.getDato());
            aux = aux.getAnt();
        }
        return list;
    }

    public void InsertarInicio(Comunidades dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else {
            nuevo.setSig(lista);
            lista.setAnt(nuevo);
            lista = nuevo;
        }
    }

    public void insertarFinal(Comunidades dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else {
            Nodo aux = lista;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            nuevo.setAnt(aux);

        }
    }

    public void InsertarAntesDe(Comunidades dato, Comunidades antes) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else if (antes.getNombre().compareToIgnoreCase(((Comunidades) lista.getDato()).getNombre()) == 0) {
            nuevo.setSig(lista);
            lista.setAnt(nuevo);
            lista = nuevo;
        } else {
            Nodo aux = ubicarotro(antes);
            nuevo.setSig(aux.getSig());
            nuevo.setAnt(aux);
            if (aux.getSig() != null) {
                nuevo.getSig().setAnt(nuevo);//primera forma
                //aux.getSig().setAnt(nuevo);//segunda forma
            }
            aux.setSig(nuevo);
        }
    }

    public void InsertarDespuesDe(Comunidades dato, Comunidades despues) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else if (despues.getNombre().compareToIgnoreCase(((Comunidades) lista.getDato()).getNombre()) == 0) {
            nuevo.setSig(lista.getSig());
            lista.setSig(nuevo);
            nuevo.getSig().setAnt(nuevo);
            nuevo.setAnt(lista);
        } else {
            Nodo aux = ubicarotro(despues);
            nuevo.setAnt(aux.getSig());
            if (aux.getSig() != null) {
                nuevo.setSig(nuevo.getAnt().getSig());
            }
            nuevo.getAnt().setSig(nuevo);
            nuevo.getSig().setAnt(nuevo);
        }
    }
}
