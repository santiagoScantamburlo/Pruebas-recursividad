/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Cefai
 */
public class Recursibida {

    public static void main(String[] args) {
        String palabra, cambiada;
        int i = 0, n, j;
        palabra = "recursibida";
        n = palabra.length() - 1;
        j = n;

        cambiada = cambiar(palabra, n, i, j);
        System.out.println(cambiada);
        
        int[] secuencia = {23 ,2 ,14 , 4, 445};
        System.out.println("coso: "+ContarMultiploSecuancia(secuencia, secuencia.length - 1, 2));
        
        System.out.println("fibo en 6 "+fibonachi(6));
    }

    public static String cambiar(String palabra, int n, int i, int j) {
        String cambiada = "";
        char letra, let;
        let = palabra.charAt(j);

        if (i <= n) {
            letra = palabra.charAt(i);
            if (i == n) {
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    cambiada = cambiada + '*' + " - " + cambiar(palabra, n, i + 1, j);
                } else {
                    cambiada = letra + " - " + cambiar(palabra, n, i + 1, j);
                }
            } else {
                if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
                    cambiada = cambiada + '*' + cambiar(palabra, n, i + 1, j);
                } else {
                    cambiada = cambiada + letra + cambiar(palabra, n, i + 1, j);
                }
            }
        } else {
            if (j == 0) {
                if (let != 'a' && let != 'e' && let != 'i' && let != 'o' && let != 'u') {
                    cambiada = cambiada + '#';
                } else {
                    cambiada = cambiada + let;
                }
            } else {
                if (let != 'a' && let != 'e' && let != 'i' && let != 'o' && let != 'u') {
                    cambiada = cambiada + '#' + cambiar(palabra, n, i, j - 1);
                } else {
                    cambiada = cambiada + let + cambiar(palabra, n, i, j - 1);
                }
            }
        }
        return cambiada;
    }
    
    public static int ContarMultiploSecuancia(int[] arreglo, int longitud, int multiplo){
         int retorno = 0;
        //caso base el primer elemento
        if(longitud == 0){
            if(arreglo[longitud] % multiplo == 0){
                retorno = retorno + 1;
            }
        }else{
            //caso recursivo
            if(arreglo[longitud] % multiplo == 0){
                retorno = 1 + ContarMultiploSecuancia(arreglo, longitud-1, multiplo);
            }else{
                retorno = ContarMultiploSecuancia(arreglo, longitud - 1, multiplo);
            }
        }
        return retorno;
    }
    
    public static int fibonachi(int numero){
        int retorno;
        //caso base
        if( numero == 0 || numero == 1){
            retorno = 1;
        }else{
            //paso recursivo
            retorno = fibonachi(numero - 1) + fibonachi(numero - 2 );
        }
        
        return retorno;
    }
}
