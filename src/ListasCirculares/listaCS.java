/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasCirculares;

import departamentos.Departamentos;
import java.util.ArrayList;

/**
 *
 * @author Hernandez
 */
public class listaCS {
    private NodoCS lista;

    public listaCS() {
        lista = null;
    }

    public boolean isEmpty() {/*verifica si la lista esta vacia*/
        return lista == null;
    }

    /*metodo para insertar los nodos y mostrarlos ordenados*/
    public void insertar(Departamentos dato) {
        NodoCS nuevo = new NodoCS(dato);
        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            lista = nuevo;
        } else if (dato.getNombre().compareToIgnoreCase(((Departamentos)lista.getDato()).getNombre()) < 0) {
            nuevo.setSiguiente(lista);
            NodoCS aux = lista;
            while (aux.getSiguiente() != lista) {/*while para posicionar el nodo, se ejecutara mientras sea diferente del 
                inicio para poder posicionar el nodo*/
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            lista = nuevo;
        } else {
            NodoCS aux = ubicar(dato.getNombre());
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }
    
     public void insertaralinicio(Departamentos dato) {/*metodo que permite ingresar un nodo al inicio de la lista*/
        NodoCS nuevo = new NodoCS(dato);
        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            lista = nuevo;
        } else {
            nuevo.setSiguiente(lista);
            NodoCS aux = lista;
            while (aux.getSiguiente() != lista) {/*while para posicionar el nodo, se ejecutara mientras sea diferente del 
                inicio para poder posicionar el nodo*/
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            lista = nuevo;
        }
    }

    public void insertaralfinal(Departamentos dato) {/*metodo para insertar un nodo al final de los que ya existen o posicionarlo
        como primero en caso de que este vacia la lista*/
        NodoCS nuevo = new NodoCS(dato);
        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            lista = nuevo;
        } else {
            NodoCS aux = lista;
            while (aux.getSiguiente() != lista) {/*while para posicionar el nodo, se ejecutara mientras sea diferente del 
                inicio para poder posicionar el nodo*/
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public void insertarantesde(Departamentos dato, String antes) {/*metodo para insertar un nodo antes de un parametro que se 
        recibe, con el fin de agregar el nuevo registro antes de cualquier nodo ya registrado*/
        NodoCS nuevo = new NodoCS(dato);
        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            lista = nuevo;
        } else if (antes.compareToIgnoreCase(((Departamentos)lista.getDato()).getNombre()) == 0) {
            NodoCS aux = lista;
            while (aux.getSiguiente() != lista) {/*while para posicionar el nodo, se ejecutara mientras sea diferente del 
                inicio para poder posicionar el nodo*/
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(lista);
            aux.setSiguiente(nuevo);
            lista = nuevo;
        } else {
            NodoCS aux = ubicar(antes);
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public void insertardespuesde(Departamentos dato, String despues) {/*metodo para insertar un nodo despues de cualquier nodo 
        que ya existe, que se manda como parametro y se comprueba que exista en la lista*/
        NodoCS nuevo = new NodoCS(dato);
        if (isEmpty()) {
            nuevo.setSiguiente(nuevo);
            lista = nuevo;
        } else if (despues.compareToIgnoreCase(((Departamentos)lista.getDato()).getNombre()) == 0) {
            NodoCS aux = lista;
            do {
                aux = aux.getSiguiente();
            } while (aux != lista);/*do while para posicionar el nodo, se ejecutara mientras sea diferente del 
                inicio para poder posicionar el nodo*/
            nuevo.setSiguiente(lista);
            aux.setSiguiente(nuevo);
            lista = nuevo;
        } else {
            NodoCS aux = reubicardespuesde(despues);
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    /*metodo para ubicar los datos segun se vallan insertando*/
    public NodoCS ubicar(String dato) {
        NodoCS aux = lista;
        NodoCS ant = lista;
        while (aux.getSiguiente() != lista && dato.compareToIgnoreCase(((Departamentos)aux.getDato()).getNombre()) > 0) {
            ant = aux;
            aux = aux.getSiguiente();
        }
        if (dato.compareToIgnoreCase(((Departamentos)aux.getDato()).getNombre()) > 0) {
            ant = aux;
        }
        return ant;
    }

    /*Metodo para ubicar el nodo despues del nodo que se ha especificado*/
    public NodoCS reubicardespuesde(String dato) {
        NodoCS aux = lista;
        NodoCS ant = lista;
        /*mientras sea diferente del inicio y las cadenas no sean iguales se ejecutara esta instruccion para poder
        ubicar el nodo despues del nodo especificados*/
        while (aux.getSiguiente() != lista && (dato.compareToIgnoreCase(((Departamentos)aux.getDato()).getNombre()) != 0)) {
            ant = aux;
            aux = aux.getSiguiente();
        }
        if (dato.compareToIgnoreCase(((Departamentos)aux.getDato()).getNombre()) == 0) {
            ant = aux;
        }
        return ant;
    }

    /*Metodo para buscar datos existentes en nuestra lista*/
    public NodoCS buscar(String dato) {
        NodoCS aux = lista;
        do {
            if (dato.compareToIgnoreCase(((Departamentos)aux.getDato()).getNombre()) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        } while (aux != lista);/*do while para buscar el nodo, se ejecutara mientras sea diferente del inicio*/
        return null;
    }

    /*Metodo para eliminar los nodos, recibiendo como parametro el nombre del alumno a eliminar de la lista*/
    public NodoCS eliminar(String dato) {
        NodoCS eliminar = buscar(dato);
        if (eliminar != null) {
            if (eliminar == lista) {
                if (eliminar.getSiguiente() == lista && eliminar == lista) {
                    lista = null;
                } else {
                    NodoCS aux = lista;
                    while (aux.getSiguiente() != lista) {/*se ejecutara hasta que auxiliar sea diferente del inicio de la lista*/
                        aux = aux.getSiguiente();
                    }
                    lista = eliminar.getSiguiente();
                    aux.setSiguiente(lista);
                }
            } else {
                NodoCS anterior = ubicar(dato);
                anterior.setSiguiente(eliminar.getSiguiente());
            }
        }
        return eliminar;
    }

    /*metodo para mostrar los datos en un arreglo*/
    public ArrayList<Departamentos> mostrarDatos() {
        ArrayList a = new ArrayList<>();
        if (!isEmpty()) {
            NodoCS aux = lista;
            do {
                a.add(aux.getDato());
                aux = aux.getSiguiente();
            } while (aux != lista);/*mientras sea diferente de inicio se agregaran los datos al arreglo*/
        }
        return a;
    }
}
