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
public class matrizRecursibida {

    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int matriz[][];
        int i, j, buscado;
        String pos;
        matriz = cargarMatriz();
        i = matriz.length;
        j = matriz[0].length;

        System.out.println("Ingrese el numero a buscar");
        buscado = pufu.nextInt();

        pos = buscarNum(matriz, i - 1, j - 1, buscado);

        System.out.println(pos + " posicion del numero buscado");
    }

    public static int[][] cargarMatriz() {
        Scanner pufu = new Scanner(System.in);
        int n, m, num;
        int[][] matriz;

        System.out.println("Ingrese la cantidad de filas");
        n = pufu.nextInt();
        System.out.println("Ingrese la cantidad de columnas");
        m = pufu.nextInt();

        matriz = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Ingrese un numero");
                num = pufu.nextInt();
                matriz[i][j] = num;
            }
        }
        return matriz;
    }

    public static String buscarNum(int[][] matriz, int i, int j, int buscado) {
        String pos = "!E";

        if (i == 0 && j == 0 || matriz[i][j] == buscado) {
            if (matriz[i][j] == buscado) {
                pos = i + "," + j;
            }
        } else {
            if (j == 0) {
                if (matriz[i][j] == buscado) {
                    pos = i + "," + j;
                } else {
                    j = matriz[0].length - 1;
                    pos = buscarNum(matriz, i - 1, j, buscado);
                }
            } else {
                pos = buscarNum(matriz, i , j-1, buscado);
            }
        }
        return pos;
    }
}
