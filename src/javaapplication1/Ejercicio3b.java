/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author Cefai
 */
public class Ejercicio3b {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int cantCeros, n;
        int num, buscado;
        String cadena;
        System.out.println("Ingrese una cadena");
        cadena = pufu.next();
        n = cadena.length()-1;
        
        cantCeros = contarCeros(cadena, n);
        System.out.println(cantCeros);
        
        System.out.println(contarDigitos(123325, 3));
    }
    
    public static int contarCeros(String cadena, int n){
        int cont = 0;
        
        if(n == 0) {
            if(cadena.charAt(n) == '0') {
                cont = 1;
            }
        } else {
            if(cadena.charAt(n) == '0') {
                cont = 1 + contarCeros(cadena, n - 1);
            } else {
                cont = contarCeros(cadena, n - 1);
            }
        }
        return cont;
    }
    
    public static int contarDigitos (int n, int buscado) {
        int cont = 0;
        
        if (n / 10 == 0) {
            if (n == buscado) {
                cont = 1;
            }
        } else {
            if (n%10 == buscado) {
                cont = 1 + contarDigitos(n/10, buscado);
            } else {
                cont = contarDigitos(n/10, buscado);
            }
        }
        return cont;
    }
}
