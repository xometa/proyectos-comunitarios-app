/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

import alcaldes.Alcalde;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import usuarios.Usuario;

/**
 *
 * @author Hernandez
 */
public class AVL<T> extends ArbolBinario {

    private int fe;

    public AVL() {
        super();/*aqui pusimos ya la raiz igual a null*/
    }

    public void insertar(T dato) {
        super.setRaiz(insertar(dato, super.getRaiz()));
    }

    /*fe=HSAD -HSAI*/
 /*el factor de equilibrio sirve para ver si vamos hacer rotacion*/
 /*rotaciones II,ID,DI*/
    private NodoArbol insertar(T dato, NodoArbol r) {
        if (r == null) {
            r = new NodoArbol(dato);
        } else if (super.comparecadenas(dato, r) < 0) {
            NodoArbol izq;/*IZQUIERDO*/
            izq = insertar(dato, r.getIzdo());
            r.setIzdo(izq);
        } else {
            if (super.comparecadenas(dato, r) > 0) {
                NodoArbol der;/*DERECHO*/
                der = insertar(dato, r.getDcho());
                r.setDcho(der);
            }
        }
        return balance(dato, r);
    }

    /*Metodo para buscar un registro*/
    public NodoArbol buscar(T dato) {
        return buscar(dato, super.getRaiz());
    }

    public NodoArbol buscar(T dato, NodoArbol r) {
        if (r == null) {
            return null;
        } else if (((String)dato).compareToIgnoreCase(((Usuario) r.getDato()).nombrecompleto())==0) {
            return r;
        } else {
            if (((String)dato).compareToIgnoreCase(((Usuario) r.getDato()).nombrecompleto())<0) {
                NodoArbol izq;
                izq = buscar(dato, r.getIzdo());
                return izq;
            } else if (((String)dato).compareToIgnoreCase(((Usuario) r.getDato()).nombrecompleto())>0) {
                NodoArbol der;
                der = buscar(dato, r.getDcho());
                return der;
            }
        }
        return r;
    }
    
    public void eliminar(T dato) {
        super.setRaiz(eliminar(super.getRaiz(), dato));
    }


    public NodoArbol eliminar(NodoArbol r, T dato) {
        if (r == null) {
            JOptionPane.showMessageDialog(null, "No hay datos");
        } else if (((Usuario) dato).nombrecompleto().compareToIgnoreCase(((Usuario) r.getDato()).nombrecompleto()) < 0) {/*comparamos la cadena que le enviamos para eliminar*/
            NodoArbol izq;
            izq = eliminar(r.getIzdo(), dato);
            r.setIzdo(izq);
        } else if (((Usuario) dato).nombrecompleto().compareToIgnoreCase(((Usuario) r.getDato()).nombrecompleto()) > 0) {/*comparamos la cadena que le enviamos para eliminar*/
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
        return balance(dato, r);
    }
//    public NodoArbol eliminar(NodoArbol r, T dato) {
//        if (r == null) {
//            JOptionPane.showMessageDialog(null, "No hay datos");
//        } else if (((String) dato).compareToIgnoreCase(((Alcalde) r.getDato()).getNombre()) < 0) {/*comparamos la cadena que le enviamos para eliminar*/
//            NodoArbol izq;
//            izq = eliminar(r.getIzdo(), dato);
//            r.setIzdo(izq);
//        } else if (((String) dato).compareToIgnoreCase(((Alcalde) r.getDato()).getNombre()) > 0) {/*comparamos la cadena que le enviamos para eliminar*/
//            NodoArbol drcha;
//            drcha = eliminar(r.getDcho(), dato);
//            r.setDcho(drcha);
//        } else {//nodo a quitar
//            NodoArbol q;
//            q = r;
//            if (q.getIzdo() == null) {/*si el dato a eliminar no tiene hijos**/
//                r = q.getDcho();/*si a la izquiera es null se sustituye por la deerecha*/
//            } else if (q.getDcho() == null) {/*si el dato a eliminar no tiene hijos**/
//                r = q.getIzdo();/*si a la derecha es null se sustituye por la izquierda*/
//            } else {/*si hay dos hijos es decir el dato tiene dos datos a sus lados*/
//                q = reemplazar(q);
//            }
//            q = null;
//        }
//        return balance(dato, r);
//    }

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

    public NodoArbol balance(T dato, NodoArbol r) {
        if (r != null) {
            if (super.comparecadenas(dato, r) > 0) {
                balance(dato, r.getDcho());
            } else if (super.comparecadenas(dato, r) < 0) {
                balance(dato, r.getIzdo());
                fe = altura(r.getDcho()) - altura(r.getIzdo());/*restamos las ramas*/
                switch (fe) {
                    case -2:/*izquierda*/
                        if (altura(r.getIzdo().getIzdo()) > altura(r.getIzdo().getDcho())) {
                            r = RII(r, r.getIzdo());
                        } else {
                            r = RID(r, r.getIzdo());
                        }
                        break;
                    case 2:/*derecha*/
                        if (altura(r.getDcho().getDcho()) > altura(r.getDcho().getIzdo())) {
                            r = RDD(r, r.getDcho());
                        } else {
                            r = RDI(r, r.getDcho());
                        }
                        break;

                    default:
                        /*HALTURA DEL MAXIMO HIJO*/
                        r.setAlt(maximo(altura(r.getIzdo()), altura(r.getDcho())) + 1);/*sacamos la altura de su dos maximos hijos*/
                }
            }
        }
        return r;
    }

    private int altura(NodoArbol r) {
        if (r != null) {
            return r.getAlt();
        } else {
            return -1;

        }
    }

    private int maximo(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private NodoArbol RII(NodoArbol r, NodoArbol n) {
        r.setIzdo(n.getDcho());
        n.setDcho(r);
        if (r.getAlt() == -1) {
            r.setAlt(0);
            n.setAlt(0);
        } else {
            r.setAlt(-1);
            n.setAlt(1);
        }

        return n;
    }

    private NodoArbol RDD(NodoArbol r, NodoArbol n) {
        r.setDcho(n.getIzdo());
        n.setIzdo(r);
        if (r.getAlt() == 1) {
            r.setAlt(0);
            n.setAlt(0);
        } else {
            r.setAlt(1);
            n.setAlt(-1);
        }

        return n;
    }

    private NodoArbol RID(NodoArbol r, NodoArbol n) {
        NodoArbol n2 = n.getDcho();
        r.setIzdo(n2.getDcho());
        n2.setDcho(r);
        n.setDcho(n2.getIzdo());
        n2.setIzdo(n);

        if (n2.getAlt() == 1) {
            r.setAlt(-1);
        } else {
            r.setAlt(0);
        }

        if (n2.getAlt() == -1) {
            n.setAlt(1);
        } else {
            n.setAlt(0);
            n2.setAlt(0);
        }
        return n2;
    }

    private NodoArbol RDI(NodoArbol r, NodoArbol n) {
        NodoArbol n2 = n.getIzdo();
        r.setDcho(n2.getIzdo());
        n2.setIzdo(r);
        n.setIzdo(n2.getDcho());
        n2.setDcho(n);

        if (n2.getAlt() == 1) {
            r.setAlt(-1);
        } else {
            r.setAlt(0);
        }

        if (n2.getAlt() == -1) {
            n.setAlt(1);
        } else {
            n.setAlt(0);
            n2.setAlt(0);
        }
        return n2;
    }

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
