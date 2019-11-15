/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;

/**
 *
 * @author Cefai
 */
public class JavaApplication1 {

    public static int func(int n) //Precondición: n siempre es un entero positivo.
    {
        int aux=0;
        while(n>0){
            aux=n+aux;
            n--;
        }
        return aux;
    }

    public static boolean esCreciente(int[] a) {
        int i = 0;
        boolean v = false;
        while (v == false || i < a.length - 1) {
            if (a[i] < a[i + 1]) {
                v = true;
            }
            i = i + 1;
        }
        return v;
    }

    public static int asd(int[] a, int n) {
        boolean v = false;
        int pos = -1, i = 0, longitud = a.length;
        while (v == false && i < longitud) {
            if (a[i] == n) {
                v = true;
                pos = i;

            } else {
                i = i + 1;
            }
        }
        return pos;
    }

    public static int asdBinaria(int[] a, int n) {
        int inicio = 0, fin = a.length - 1, resul = -1, medio;
        while (inicio <= fin) {
            medio = (int) (inicio + fin) / 2;
            if (n == a[medio]) {
                resul = medio;
                inicio = fin + 1;

            } else {
                if (n < a[medio]) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }

            }
        }
        return resul;
    }

    public static void burbuja(int[] x) {
        int i, fin = x.length - 1, j, temp = 0;
        for (i = 0; i < fin; i++) {
            for (j = 0; j < fin - i; j++) {
                if (x[j + 1] < x[j]) {
                    temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }
    }

    public static void insercion(int[] a) {
        int i, j, temp, longitud = a.length;
        for (i = 1; i < longitud; i++) {
            temp = a[i];
            j = i;
            while (j > 0 && temp < a[j - 1]) {
                a[j] = a[j - 1];
                j = j - 1;
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int[] a = {2, 3, 4, 5, 6};
        int[] x = {6, 65, 10, 1, 7};
        burbuja(x);
        System.out.println(Arrays.toString(x));
        System.out.println(esCreciente(a));
        System.out.println(asd(a, 8));
        System.out.println(asdBinaria(a, 2));
        insercion(x);
        System.out.println(Arrays.toString(x));

    }

}
