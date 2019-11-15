/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author usuario
 */

/*
 Dada una secuencia S de números enteros positivos (finalizada en 0, que no se considera parte de la secuencia)
ingresados por teclado, escribir planteos recursivos, sus correspondientes métodos, y realizar la traza para
la secuencia  2 5 3 6 12 3 0 en los siguientes incisos:
a) Calcular cuántos enteros múltiplos de 4 hay en la secuencia.
b) Determinar el máximo entero perteneciente a la secuencia.
 */
public class Ej5 {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int min, n;
        System.out.println("Ingrese un numero");
        n = pufu.nextInt();
        min = secuenciaDeMierda(n);

        System.out.println(min);

    }

    public static int secuenciaDeMierda(int numero) {
        Scanner pufu = new Scanner(System.in);
        int minimo, nuevoElemento, devuelto;
        
        //caso base el numero es 0 corta
        if (numero == 0) {
            minimo = 0;
        } else {
            //caso base pide un numero entero
            System.out.println("Ingrese un numero");
            nuevoElemento = pufu.nextInt();
            devuelto = secuenciaDeMierda(nuevoElemento);
            /*  en caso de ser cero se corta la secuencia
            *   y el minimo en la secuencia
            *   y es retornado
            */
            if (devuelto == 0) {
                minimo = numero;
            } else {
                /*  evaluamos que el actual numero ingresado *numero
                *   sea menor que el vevuelto en la pila *devuelto
                *   y se devuelve el menor de ambos
                */  
                if (devuelto <= numero) {
                    minimo = devuelto;
                } else {
                    minimo = numero;
                }
            }
        }
        System.out.println("el numero que sale es: "+minimo);
        return minimo;
    }

}
