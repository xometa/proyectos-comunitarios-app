/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import alcaldes.Alcalde;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*ARBOL BINARIO DE BUSQUEDA*/
/**
 *
 * @author Hernandez
 */
public class ArbolBB<T> extends ArbolBinario {

    public ArbolBB() {
        super();
    }

    public void insertar(T dato) {
        super.setRaiz(insertar(dato, super.getRaiz()));
    }

    private NodoArbol insertar(T dato, NodoArbol r) {
        if (r == null) {
            r = new NodoArbol(dato);
        } else if (super.compare(dato, r) < 0) {
            NodoArbol izq;
            izq = insertar(dato, r.getIzdo());
            r.setIzdo(izq);
        } else if (super.compare(dato, r) > 0) {
            NodoArbol der;
            der = insertar(dato, r.getDcho());
            r.setDcho(der);
        } else {
            JOptionPane.showMessageDialog(null, "Duplicado");
        }
        return r;
    }

    public NodoArbol buscar(int dato) {
        return buscar(dato, super.getRaiz());
    }

    public NodoArbol buscar(int dato, NodoArbol r) {
        if (r == null) {
            return null;
        } else if (dato == ((Alcalde) r.getDato()).getIdpersona()) {
            return r;
        } else {
            if (dato < ((Alcalde) r.getDato()).getIdpersona()) {
                NodoArbol izq;
                izq = buscar(dato, r.getIzdo());
                return izq;
            } else if (dato > ((Alcalde) r.getDato()).getIdpersona()) {
                NodoArbol der;
                der = buscar(dato, r.getDcho());
                return der;
            }
        }
        return r;
    }

    public void eliminar(int dato) {
        super.setRaiz(eliminar(super.getRaiz(), dato));
    }

    public NodoArbol eliminar(NodoArbol r, int dato) {
        if (r == null) {
            JOptionPane.showMessageDialog(null, "No hay datos");
        } else if (dato < ((Alcalde) r.getDato()).getIdpersona()) {/*comparamos la cadena que le enviamos para eliminar*/
            NodoArbol izq;
            izq = eliminar(r.getIzdo(), dato);
            r.setIzdo(izq);
        } else if (dato > ((Alcalde) r.getDato()).getIdpersona()) {/*comparamos la cadena que le enviamos para eliminar*/
            NodoArbol drcha;
            drcha = eliminar(r.getDcho(), dato);
            r.setDcho(drcha);
        } else {//nodo a quitar
            NodoArbol q;
            q = r;
            if (q.getIzdo() == null) {/*si el dato a eliminar no tiene hijos**/
                r = q.getDcho();/*si a la izquiera es null se sustituye por la deerecha*/
            } else if (q.getDcho() == null) {/*si el dato a eliminar no tiene hijos**/
                r = q.getIzdo();/*si a la derecha es null se sustituye por la izquierda*/
            } else {/*si hay dos hijos es decir el dato tiene dos datos a sus lados*/
                q = reemplazar(q);
            }
            q = null;
        }
        return r;
    }

    /*metodo reemplazar en caso de que el dato tenga dos hijos*/
    private NodoArbol reemplazar(NodoArbol actual) {
        NodoArbol a, p;
        /*
        *entro a la izquierda y me boy mas a laderecha de las rama
        *
        *
         */
        p = actual;
        a = actual.getIzdo();/*contemdra la rama izquierda y se busca mas a la derecha*/
        while (a.getDcho() != null) {/*ahora de la rama izquierda me dirijo a la derecha*/
            p = a;/*trasladamos p al valor de la rama que llevamos*/
            a = a.getDcho();
        }
        actual.setDato(a.getDato());/*elimine el 100 y subo 81 en caso de que 81 no tuviera hijos a la izquierda*/

 /*if para validar si 81 tenia un hijo a la izquierda ya que se estaban buscando solo los de la derecha*/
        if (p == actual) {/*si es igual al que boy a eliminar*/
            p.setIzdo(a.getIzdo());/*agarro mi dato de la izquierda para que no quede perdido*/
        } else {
            p.setDcho(a.getIzdo());/*cuando subimos el 81 (como eliminamos 100) y tiene un hijo a la izquierda que es 80.5 este pasa a sustituir al dato que eliminamos**/
        }
        return a;
    }

    String niveles[]; // niveles
    int cant;// se  ocupa en varios metodos
    int altura;
    int alturaDato = 0;

    public int cantidadNodos() {
        cant = 0;
        cantidad(raiz);
        return cant;
    }

    private void cantidad(NodoArbol reco) {
        if (reco != null) {
            cant++;
            cantidad(reco.getIzdo());
            cantidad(reco.getDcho());
        }
    }

    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return cant;
    }

    private void cantidadNodosHoja(NodoArbol reco) {
        if (reco != null) {
            if (reco.getIzdo() == null && reco.getDcho() == null) {
                cant++;
            }
            cantidadNodosHoja(reco.getIzdo());
            cantidadNodosHoja(reco.getDcho());
        }
    }

    /*mostrando solo las que son hojas en una tabla*/
    ArrayList<Alcalde> lista = new ArrayList();

    public ArrayList<Alcalde> eshoja() {
        return ishoja(super.getRaiz());
    }

    private ArrayList<Alcalde> ishoja(NodoArbol r) {
        if (r != null) {
            if (r.getDcho() == null && r.getIzdo() == null) {
                lista.add((Alcalde) r.getDato());
            }
            ishoja(r.getIzdo());
            ishoja(r.getDcho());
        }
        return lista;
    }

    /*fin mostrando solo las que son hojas en una tabla*/
    public int retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

    private void retornarAltura(NodoArbol reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.getIzdo(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDcho(), nivel + 1);
        }
    }

    public void menorValor() {
        if (raiz != null) {
            NodoArbol reco = raiz;
            while (reco.getIzdo() != null) {
                reco = reco.getIzdo();
            }
            Alcalde aux = (Alcalde) reco.getDato();
            JOptionPane.showMessageDialog(null, "Menor valor del árbol:" + aux.getNombre());
        }
    }

    public void mayorValor() {
        if (raiz != null) {
            NodoArbol reco = raiz;
            while (reco.getDcho() != null) {
                reco = reco.getDcho();
            }
            Alcalde aux = (Alcalde) reco.getDato();
            JOptionPane.showMessageDialog(null, "Menor valor del árbol:" + aux.getNombre());
        }
    }

    public void imprimirNivel() {
        niveles = new String[altura + 1];
        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + " En nivel: " + i);
        }
    }

    private void imprimirNivel(NodoArbol pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = ((Alcalde) pivote.getDato()).getNombre() + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.getDcho(), nivel2 + 1);
            imprimirNivel(pivote.getIzdo(), nivel2 + 1);
        }
    }

    public void imprimirAlturaDeCadaNodo() {
        imprimirAlturaDeCadaNodo(raiz, 1);
    }

    private void imprimirAlturaDeCadaNodo(NodoArbol reco, int nivel) {
        if (reco != null) {
            System.out.println("Nodo contiene: " + ((Alcalde) reco.getDato()).getNombre() + " y su altura es: " + nivel);
            imprimirAlturaDeCadaNodo(reco.getIzdo(), nivel + 1);
            imprimirAlturaDeCadaNodo(reco.getDcho(), nivel + 1);
        }
    }

    //-------------COMPLETO----------------------
    public void Completo() {
        Completo(raiz, 0);
        System.out.println("\n");
        System.out.println("-------------");
    }

    private void Completo(NodoArbol reco, int nivel) {
        if (reco != null) {
            Alcalde aux = (Alcalde) reco.getDato();
            if (retornarAltura() - 2 == nivel) {
                if (reco.getDcho() != null && reco.getIzdo() != null) {

                }
            }
            if (reco.getDcho() == null && reco.getIzdo() == null) {
                System.out.println("Nodo contiene: " + aux.getNombre() + " y su altura es: 0");
            }
            Completo(reco.getIzdo(), nivel + 1);
            Completo(reco.getDcho(), nivel + 1);
        }
    }

    //---------ALTURA NODO---------
    public int retornarAlturaNodo(NodoArbol a) {
        altura = 0;
        retornarAltura(a, 1);
        return altura;
    }

    private void retornarAlturaNodo(NodoArbol reco, int nivel) {
        if (reco != null) {
            retornarAlturaNodo(reco.getIzdo(), nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.getDcho(), nivel + 1);
        }
    }

    /*HACERLO*/
 /*SACAR PROFUNDIDAD,CUANTAS HOJAS TIENE, SACAR ALTURA,SI UN ARBOL ESTA COMPLETO,PESO DEL ARBOL(CANTIDAD DE NODOS QUE TIENE)*/
    public ArrayList NID() {
        ArrayList x = new ArrayList();
        super.setArbolito(x);
        return super.preOrdenNID(super.getRaiz());
    }

    public ArrayList IND() {
        ArrayList x = new ArrayList();
        super.setArbolito(x);
        return super.inOrdenIND(super.getRaiz());
    }

    public ArrayList IDN() {
        ArrayList x = new ArrayList();
        super.setArbolito(x);
        return super.postOrdenIDN(super.getRaiz());
    }
}
