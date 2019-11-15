/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Cefai
 */
public class arregloDinamico {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo, arr;
        int longitud, celdas;
        
        System.out.println("Ingrese la longitud del arreglo");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];
        
        cargar(arreglo);
        imprimir(arreglo);

        System.out.println("Ingrese cuantas celdas va a agregar");
        celdas = pufu.nextInt();
        arr = new int[arreglo.length + celdas];
        //Copio las referencias del primer arreglo cargado en el que voy a agregar celdas
        for (int i = 0; i < arreglo.length; i++) {
            arr[i] = arreglo[i];
        }
        imprimir(arr);
        for (int j = 0; j < celdas; j++) {
            arr = agregarCeldas(arr, longitud);
            longitud++;
        }

        imprimir(arr);
        
        Arrays.sort(arr);
        imprimir(arr);
    }

    public static void cargar(int[] a) {
        Scanner pufu = new Scanner(System.in);
        int num;
        for (int i = 0; i < a.length; i++) {
            System.out.println("Ingrese un numero");
            num = pufu.nextInt();
            a[i] = num;
        }
    }

    public static void imprimir(int[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }

    public static int[] agregarCeldas(int[] a, int indice) {
        Scanner pufu = new Scanner(System.in);
        int num;
        int [] arr;
        
        arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        
        System.out.println("Ingrese un numero");
        num = pufu.nextInt();
        arr[indice] = num;
        
        return arr;
    }
}
