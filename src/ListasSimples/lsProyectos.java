/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListasSimples;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectos.Proyectos;

/**
 *
 * @author Hernandez
 */
public class lsProyectos {

    Nodo lista;

    public lsProyectos() {
        lista = null;
    }

    public boolean isEmpty() {
        return lista == null;
    }

    public void insertar(Proyectos dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;

        } else {
            if (dato.getCodigoproyecto().compareToIgnoreCase(((Proyectos) lista.getA()).getCodigoproyecto()) < 0) {
                nuevo.setSiguiente(lista);
                lista = nuevo;

            } else {
                Nodo anterior = ubicar(dato);
                nuevo.setSiguiente(anterior.getSiguiente());
                anterior.setSiguiente(nuevo);
            }
        }
    }

    public Nodo ubicar(Proyectos dato) {
        Nodo aux = lista;
        Nodo anterior = lista;
        while (aux.getSiguiente() != null && dato.getCodigoproyecto().compareToIgnoreCase(((Proyectos) aux.getA()).getCodigoproyecto()) > 0) {
            anterior = aux;
            aux = aux.getSiguiente();
        }
        if (dato.getCodigoproyecto().compareToIgnoreCase(((Proyectos) aux.getA()).getCodigoproyecto()) > 0) {
            anterior = aux;
        }
        return anterior;
    }

    public void insertarantesde(Proyectos dato, Proyectos antes) {
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
            if (antes.getCodigoproyecto().compareToIgnoreCase(((Proyectos) lista.getA()).getCodigoproyecto()) == 0) {
                nuevo.setSiguiente(lista);
                lista = nuevo;
            } else {
                Nodo aux = ubicar(antes);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
    }

    public void insertardespuesde(Proyectos dato, Proyectos despues) {
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
            if (despues.getCodigoproyecto().compareToIgnoreCase(((Proyectos) lista.getA()).getCodigoproyecto()) == 0) {
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
    public void insertarinicio(Proyectos dato) {
        Nodo nuevo = new Nodo(dato);
        if (isEmpty()) {
            lista = nuevo;
        } else {
            nuevo.setSiguiente(lista);
            lista = nuevo;
        }
    }

    public void insertaralfinal(Proyectos dato) {
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

    public Nodo buscar(Proyectos dato) {
        Nodo aux = lista;
        while (aux != null) {
            if (dato.getCodigoproyecto().compareToIgnoreCase(((Proyectos) aux.getA()).getCodigoproyecto()) == 0) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;

    }

    public Nodo eliminar(Proyectos dato) {
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

    public ArrayList<Proyectos> toArray() {
        ArrayList a = new ArrayList();
        Nodo aux = lista;
        while (aux != null) {
            a.add(aux.getA());
            aux = aux.getSiguiente();
        }
        return a;

    }
}
