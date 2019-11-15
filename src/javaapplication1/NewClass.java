/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Cefai
 */
public class NewClass {

    public static int rec(int n) {
        int cont = 0;
        if (n < 10) {
            cont = 1;
        } else {
            cont = 1 + cont + rec(n / 10);
        }
        return cont;
    }

    public static int buscar(int n, int buscado) {
        int cont = 0;
        if (n < 10) {
            if (n == buscado) {
                cont = 1;
            }
        } else {
            if (n % 10 == buscado) {
                cont = 1+ buscar(n/10, buscado);
            }
            else
                cont=buscar(n/10, buscado);

        }
        return cont;
    }

    public static void main(String[] args) {
        int n = 1212225;
        System.out.println(rec(n));
        int a = 5;
        System.out.println(buscar(n, a));
    }
}
