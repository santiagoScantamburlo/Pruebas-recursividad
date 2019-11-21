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
public class buscarCaracter {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int pos;
        char buscado;
        char[] arreglo = {'a', 'f', 'k', 'h', 'g' , 'j'};        
        System.out.println("Ingrese el caracter a buscar");
        buscado = pufu.next().charAt(0);
        
        pos = buscar(arreglo, arreglo.length - 1, 0, buscado);
        System.out.println(pos);
    }
    
    public static int buscar(char[] arreglo, int longitud, int n, char buscado) {
        int pos = -1;
        
        if(n == longitud) {
            if(arreglo[n] == buscado) {
                pos = n;
            }
        } else {
            if(arreglo[n] == buscado) {
                pos = n;
            } else {
                pos = buscar(arreglo, longitud, n + 1, buscado);
            }
        }
        return pos;
    }
}
