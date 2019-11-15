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
public class OrdenamientoRecursivo {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo;
        int opcion;
        arreglo = cargarArreglo();
        menu();
        opcion = pufu.nextInt();

        System.out.print("Vector Original: ");
        System.out.println(Arrays.toString(arreglo));
        System.out.print("Vector Ordenado: ");
        switch (opcion) {
            case 1:
                ordenacionMergeSort(arreglo);
                break;
            case 2:
                monticulosHeapSort(arreglo);
                break;
            case 3:
                ordenacionRapida(arreglo);
        }
        System.out.println(Arrays.toString(arreglo));
    }

    public static void menu() {
        System.out.println("Ingrese un metodo de ordenacion");
        System.out.println("1: Merge Sort");
        System.out.println("2: Heap Sort");
        System.out.println("3: Quick Sort");
    }

    public static int[] cargarArreglo() {
        Scanner pufu = new Scanner(System.in);
        int num, longitud;
        int[] a;
        System.out.println("Ingrese la longitud del arreglo");
        longitud = pufu.nextInt();
        a = new int[longitud];
        for (int i = 0; i < a.length; i++) {
            System.out.println("Ingrese un numero");
            num = pufu.nextInt();
            a[i] = num;
        }
        return a;
    }

    //Empieza el Merge Sort
    public static void ordenacionMergeSort(int[] a) {
        int mitad;
        int[] izq;
        int[] der;
        if (a.length <= 1) {
        } else {
            mitad = a.length / 2;
            izq = copiar(a, 0, mitad);
            der = copiar(a, mitad, a.length);
            ordenacionMergeSort(izq);
            ordenacionMergeSort(der);
            combinarArreglo(a, izq, der);
        }
    }

    public static int[] copiar(int[] a, int inicio, int fin) {
        int[] retorno;
        retorno = new int[fin - inicio];

        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = a[inicio];
            inicio++;
        }
        return retorno;
    }

    public static void combinarArreglo(int[] a, int[] izq, int[] der) {
        int i = 0;
        int j = 0;
        for (int k = 0; k < a.length; k++) {
            if (i >= izq.length) {
                a[k] = der[j];
                j++;
                continue;
            }
            if (j >= der.length) {
                a[k] = izq[i];
                i++;
                continue;
            }
            if (izq[i] < der[j]) {
                a[k] = izq[i];
                i++;
            } else {
                a[k] = der[j];
                j++;
            }
        }
    } //Hasta aca llega el Merge Sort

    //Empieza el Heap Sort
    public static void monticulosHeapSort(int[] a) {
        int n = a.length;
        int temp;
        for (int i = n / 2; i >= 0; i--) {
            hacerMonticulo(a, i, n - 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            hacerMonticulo(a, 0, i - 1);
        }
    }

    public static void hacerMonticulo(int[] a, int i, int fin) {
        int izq = 2 * i + 1;
        int der = izq + 1;
        int may;
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            may = izq;
        } else {
            may = a[izq] > a[der] ? izq : der;
        }
        if (a[i] < a[may]) {
            int tmp = a[i];
            a[i] = a[may];
            a[may] = tmp;
            hacerMonticulo(a, may, fin);
        }
    } //Hasta aca llega el Heap Sort
    
    //Empieza el Quick Sort
    public static void ordenacionRapida(int[] a) {
        int n = a.length;
        quickSort(a, 0, n - 1);
    }
    
    public static void quickSort(int[] a, int inicio, int fin) {
        if(inicio >= fin) {
            return;
        }
        int pivote = a[inicio];
        int elemIzq = inicio + 1;
        int elemDer = fin;
        
        while(elemIzq <= elemDer) {
            while(elemIzq <= fin && a[elemIzq] < pivote) {
                elemIzq++;
            }
            while(elemDer > inicio && a[elemDer] >= pivote) {
                elemDer--;
            }
            if(elemDer > inicio) {
                int temp = a[inicio];
                a[inicio] = a[elemDer];
                a[elemDer] = temp;
            }
            quickSort(a, inicio, elemDer - 1);
            quickSort(a, elemDer + 1, fin);
        }
    }
} //Hasta aca llega el Quick Sort
