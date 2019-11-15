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
public class cargaArregloRecursivo {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] arreglo;
        int longitud, n;
        
        System.out.println("Ingrese la longitud del arreglo");
        longitud = pufu.nextInt();
        arreglo = new int[longitud];
        n = longitud - 1;
        
        carga(arreglo, n);
        System.out.println(Arrays.toString(arreglo));
    }
    
    public static void carga(int[] a, int n) {
        Scanner pufu = new Scanner(System.in);
        int num;
        
        if(n == 0) {
            System.out.println("Ingrese un numero");
            num = pufu.nextInt();
            a[n] = num;
        } else {
            carga(a, n - 1);
            System.out.println("Ingrese un numero");
            num = pufu.nextInt();
            a[n] = num;
        }
    }
}