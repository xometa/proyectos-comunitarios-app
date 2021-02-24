/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

/**
 *
 * @author Hernandez
 */
public class Recursividad {

    public Recursividad() {
    }

    /*metodo solo para concatenar numeros aleatorios a los metodos recursivos*/
    public static int cuatrodigitos() {
        int numero = (int) (Math.random() * 10000);
        if (numero > 1000 && numero < 10000) {
            return numero;/*retornara el numero de cuatro digitos*/
        } else {
            return numero;/*si no retornara el numero que sea generado*/
        }
    }
    
    public static int tresdigitos() {
        int numero = (int) (Math.random() * 1000);
        if (numero > 100 && numero < 1000) {
            return numero;/*retornara el numero de cuatro digitos*/
        } else {
            return numero;/*si no retornara el numero que sea generado*/
        }
    }

    /*Metodo que obtiene la primera letra y la primera despues por espacios ejemplo Zona Central = ZC*/
    public static String primeraporespacios(String[] dato, int p) {
        if (dato.length - 1 == p) {//caso base
            return String.valueOf(dato[p].charAt(0));//retorna la inicial en caso de que solo sea una letra
        } else {
            return dato[p].charAt(0) + primeraporespacios(dato, p + 1);
        }
    }

    /*Metodo que genera las tres primeras letras de una cadena ejemplo HOLA=HOL*/
    public static String tresprimerasletras(String cadena, int inicio) {
        cadena.trim();
        if (cadena.length() == 1 || inicio== 2) {
            return String.valueOf(cadena.charAt(0));
        } else {
            return String.valueOf(cadena.charAt(0) + tresprimerasletras(cadena.substring(1), inicio + 1));
        }
    }

    /*Metodo que retorna la ultima y primera letra HOLA=HA*/
    public static String primeraultima(String cadena) {
        cadena.trim();
        if (cadena.length() == 1) {
            return String.valueOf(cadena.charAt(0));
        } else {
            return cadena.charAt(0) + primeraultima(cadena.substring(cadena.length() - 1));
        }
    }
    
    /*Metodo para tomar la primera y ultima letra de una cadena de tipo String*/
    public static String oneend(String cad,int p){
        if (p==cad.length()-1) {
            return String.valueOf("000"+cad.charAt(p))+cad.length();
        }else if(p==0){
            return cad.charAt(p)+oneend(cad, p+1);
        }else{
            return oneend(cad, p+1);
        }
    
    }
}
