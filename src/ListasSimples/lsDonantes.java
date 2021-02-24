/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasSimples;

import donantes.Donantes;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hernandez
 */
public class lsDonantes {
    Nodo lista;

    public lsDonantes() {
        lista = null;
    }

    public boolean isEmpty() {
        return lista == null;
    }

    public void insertar(Donantes dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;

        } else {
            if (dato.getNombre().compareToIgnoreCase(((Donantes)lista.getA()).getNombre()) < 0) {
                nuevo.setSiguiente(lista);
                lista = nuevo;

            } else {
                Nodo anterior = ubicar(dato);
                nuevo.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(nuevo);
            }
        }
    }

    public Nodo ubicar(Donantes dato) {
        Nodo aux = lista;
        Nodo anterior = lista;
        while (aux.getSiguiente() != null && dato.getNombre().compareToIgnoreCase(((Donantes)aux.getA()).getNombre()) > 0) {
            anterior = aux;
            aux = aux.getSiguiente();
        }
        if (dato.getNombre().compareToIgnoreCase(((Donantes)aux.getA()).getNombre()) > 0) {
            anterior = aux;
        }
        return anterior;
    }

    public void insertarantesde(Donantes dato, Donantes antes) {
        Nodo nuevo = new Nodo(dato);
//        if (isEmpty()) {
//            JOptionPane.showMessageDialog(null, "NO HAY DATOS REGISTRADOS","ERROR",JOptionPane.ERROR_MESSAGE);
//        } else {
//            if (antes.compareToIgnoreCase(lista.getA().getNombre())==0) {
//                nuevo.setSiguiente(lista);
//                lista=nuevo;
//            } else {
//                Nodo aux=reubicar(antes);
//                nuevo.setSiguiente(lista.getSiguiente());
//                aux.setSiguiente(nuevo);
//            }
//        }

        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY DATOS REGISTRADOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (antes.getNombre().compareToIgnoreCase(((Donantes)lista.getA()).getNombre()) == 0) {
                nuevo.setSiguiente(lista);
                lista = nuevo;
            } else {
                Nodo aux = ubicar(antes);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
    }

    public void insertardespuesde(Donantes dato, Donantes despues) {
        Nodo nuevo = new Nodo(dato);
//        if (isEmpty()) {
////            lista=nuevo;
//            JOptionPane.showMessageDialog(null, "NO HAY DATOS REGISTRADOS","ERROR",JOptionPane.ERROR_MESSAGE);
//        }else{
//            if (despues.compareToIgnoreCase(lista.getA().getNombre())==0) {
//                lista.setSiguiente(nuevo);
//                lista=nuevo;
//            }else{
//            Nodo aux=reubicar(despues);
//            nuevo.setSiguiente(lista.getSiguiente());
//            lista.setSiguiente(nuevo);
//            }
//        }
        if (isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY DATOS REGISTRADOS", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            if (despues.getNombre().compareToIgnoreCase(((Donantes)lista.getA()).getNombre()) == 0) {
                lista.setSiguiente(nuevo);
                lista = nuevo;
            } else {
                Nodo aux = buscar(despues);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }

        }
    }

//    public Nodo reubicar(Alumno dato) {
//        Nodo aux = lista;
//        Nodo ant = lista;
//        while (aux.getSiguiente() != lista && (dato.getNombre().compareToIgnoreCase(aux.getA().getNombre()) != 0)) {
//            ant = aux;
//            aux = aux.getSiguiente();
//        }
//        if (dato.getNombre().compareToIgnoreCase(aux.getA().getNombre()) != 0) {
//            ant = aux;
//        }
//        return ant;
//    }

    public void insertarinicio(Donantes dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else {
            nuevo.setSiguiente(lista);
            lista = nuevo;
        }
    }

    public void insertaralfinal(Donantes dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else {
            Nodo aux = lista;
            Nodo fin = lista;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
                fin = aux;
            }
            nuevo.setSiguiente(fin.getSiguiente());
            fin.setSiguiente(nuevo);
        }
    }

    public Nodo buscar(Donantes dato) {
        Nodo aux = lista;
        while (aux != null) {
            if (dato.getNombre().compareToIgnoreCase(((Donantes)aux.getA()).getNombre()) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;

    }

    public Nodo eliminar(Donantes dato) {
        Nodo eliminar = buscar(dato);
        if (eliminar != null) {
            Nodo anterior = ubicar(dato);
            if (eliminar == lista) {
                lista = lista.getSiguiente();
            } else {
                anterior.setSiguiente(eliminar.getSiguiente());

            }
        }
        return eliminar;

    }

    public ArrayList<Donantes> toArray() {
        ArrayList a = new ArrayList();
        Nodo aux = lista;
        while (aux != null) {
            a.add(aux.getA());
            aux = aux.getSiguiente();
        }
        return a;

    }
}
