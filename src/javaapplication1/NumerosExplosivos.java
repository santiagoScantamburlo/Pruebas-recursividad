/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/* Dados dos números N y B, tales que B < N, se puede hacer que N "explote" usando a B
como bomba. Cuando N explota se parte en dos números N1 = (N / B) y N2 = N - (N / B). Pero
B produce una reaccion en cadena: si N1 (y/o N2) es mayor que B, tambien explota y se parte
nuevamente en dos pedazos, segun el criterio anterior. Esto se repite hasta que todos
los pedazos resultantes a partir de N sean menores o iguales a B.
 */
public class NumerosExplosivos {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int bomba = 0, numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println("Ingrese un numero");
            numero = pufu.nextInt();
            System.out.println("Ingrese un numero bomba");
            bomba = pufu.nextInt();
            if(bomba < numero) {
                valido = true;
            }
        }

        explotar(numero, bomba);
    }

    public static void explotar(int n, int b) {
        int n1, n2;

        if (n < b) {
        } else if (n > b) {
            n1 = n / b;
            n2 = n - (n / b);
            if (n1 <= b) {
                System.out.print(n1);
                System.out.print(", ");
            }
            if (n2 <= b) {
                System.out.print(n2);
                System.out.print(", ");
            }
            explotar(n1, b);
            explotar(n2, b);
        }
    }
}
