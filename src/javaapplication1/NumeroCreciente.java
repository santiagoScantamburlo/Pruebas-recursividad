/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;

public class NumeroCreciente {
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int numero;
        boolean creciente;
        
        System.out.println("Ingrese un numero");
        numero = pufu.nextInt();
        
        creciente = verificarCreciente(numero);
        System.out.println(creciente);
    }
    
    public static boolean verificarCreciente(int num) {
        boolean retorno;
        
        if((num % 10) == 0) {
            retorno = true;
        } else {
            if((num % 10) < num) {
            retorno = false;
            } else {
                retorno = true && verificarCreciente(num / 10);
            }
        }
        return retorno;
    }
}
