//Mepr0 m0ci0nas¿
//Me gusta la recursibida
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Cefai
 */
public class ArregloDinamicoRecursibo {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo = {1, 2, 3, 4, 5};
        int[] a;
        int longitud = arreglo.length;
        int celdas;

        System.out.println("Ingrese la cantidad de celdas a agregar");
        celdas = pufu.nextInt();

        a = new int[longitud + celdas];
        agregarCeldas(arreglo, a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void agregarCeldas(int[] arreglo, int[] a, int longitud) {
        Scanner pufu = new Scanner(System.in);
        int num;
        if (longitud == 0) {
            a[longitud] = arreglo[longitud];
        } else {
            agregarCeldas(arreglo, a, longitud - 1);
            if (arreglo.length <= longitud) {
                System.out.println("Ingrese un numero");
                num = pufu.nextInt();
                a[longitud] = num;
            } else {
                a[longitud] = arreglo[longitud];
            }
        }
    }
}
