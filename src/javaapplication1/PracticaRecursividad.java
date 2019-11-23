/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Santi
 */
public class PracticaRecursividad {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        Scanner pufu = new Scanner(System.in);
        int[] v = {-1, 0, 7, 8, 10, 12};
        int opcion, n, t, aux;
        char buscado;
        boolean continuar = true;
        aux = v.length - 1;
        while (continuar) {
            menu();
            opcion = pufu.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese un numero entero positivo");
                    n = pufu.nextInt();
                    System.out.println(contarDigitos(n));
                    break;
                case 2:
                    System.out.println("Ingrese un numero entero");
                    n = pufu.nextInt();
                    System.out.println("Ingrese el numero a buscar");
                    t = pufu.nextInt();
                    System.out.println(contarApariciones(n, t));
                    break;
                case 3:
                    System.out.println("Ingrese un numero para buscar en el arreglo");
                    n = pufu.nextInt();
                    System.out.println(buscarNumero(v, aux, n));
                    break;
                case 4:
                    System.out.println(creciente(v, aux));
                    break;
                case 5:
                    System.out.println(multiplos());
                    break;
                case 6:
                    System.out.println(mayor());
                    break;
                case 7:
                    System.out.println("Ingrese un caracter para buscar");
                    buscado = pufu.next().charAt(0);
                    caracteres(buscado);
                    break;
                case 8:
                    System.out.println("Ingrese un caracter");
                    buscado = pufu.next().charAt(0);
                    System.out.println(cantCaracter(buscado));
                    break;
                case 0:
                    continuar = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        }

    }

    public static void menu() {
        System.out.println("Ingrese una opción");
        System.out.println("----------------------");
        System.out.println("1: Contar la cantidad de dígitos de un número entero positivo n ");
        System.out.println("2:  contar la cantidad de veces que aparece el dígito t en el número n");
        System.out.println("3: Dado un número entero n, devolver verdadero si n se encuentra en v y falso en caso contrario");
        System.out.println("4: Devolver el valor de verdad si respetan un orden creciente o no");
        System.out.println("5: Calcular cuántos enteros múltiplos de 4 hay en la secuencia.");
        System.out.println("6: Determinar el máximo entero perteneciente a la secuencia.");
        System.out.println("7: Mostrar en orden inverso todos los caracteres de la secuencia distintos a un caracter dado.");
        System.out.println("8: Determinar la cantidad de veces que aparece un carácter dado en la secuencia.");
        System.out.println("0: para finalizar");
    }

    public static int contarDigitos(int n) {
        int cant = 0;

        if (n < 10) {
            cant = 1;
        } else {
            cant = 1 + contarDigitos(n / 10);
        }
        return cant;
    }

    public static int contarApariciones(int n, int t) {
        int cant = 0;

        if (n < 10) {
            if (n == t) {
                cant = 1;
            }
        } else {
            if (n % 10 == t) {
                cant = 1 + contarApariciones(n / 10, t);
            } else {
                cant = contarApariciones(n / 10, t);
            }
        }
        return cant;
    }

    public static boolean buscarNumero(int[] v, int aux, int n) {
        boolean existe = false;

        if (aux == 0) {
            if (v[aux] == n) {
                existe = true;
            }
        } else {
            if (v[aux] == n) {
                existe = true;
            } else {
                existe = buscarNumero(v, aux - 1, n);
            }
        }
        return existe;
    }

    public static boolean creciente(int[] v, int aux) {
        boolean retorno = false;

        if (aux == 1) {
            retorno = true;
        } else {
            if (v[aux] > v[aux - 1]) {
                retorno = true && creciente(v, aux - 1);
            }
        }
        return retorno;
    }

    public static int multiplos() {
        Scanner pufu = new Scanner(System.in);
        int num, cant;
        System.out.println("Ingrese un numero");
        num = pufu.nextInt();

        if (num == 0) {
            cant = 0;
        } else if (num % 4 == 0) {
            cant = 1 + multiplos();
        } else {
            cant = multiplos();
        }
        return cant;
    }

    public static int mayor() {

        Scanner pufu = new Scanner(System.in);
        int mayor, retorno, num;

        System.out.println("Ingrese un numero");
        num = pufu.nextInt();

        if (num == 0) {
            mayor = 0;
        } else {
            retorno = mayor();
            if (retorno == 0) {
                mayor = num;
            } else {
                if (retorno >= num) {
                    mayor = retorno;
                } else {
                    mayor = num;
                }
            }
        }
        return mayor;
    }

    public static void caracteres(char buscado) {
        Scanner pufu = new Scanner(System.in);
        char caracter;

        System.out.println("Ingrese un caracter");
        caracter = pufu.next().charAt(0);

        if (caracter == '.') {
            System.out.print(caracter);
        } else {
            caracteres(buscado);
            if (caracter == buscado) {
                System.out.print("");
            } else {
                System.out.print(caracter);
            }
        }
    }

    public static int cantCaracter(char buscado) {
        Scanner pufu = new Scanner(System.in);
        char caracter;
        int cant = 0;
        System.out.println("Ingrese un caracter");
        caracter = pufu.next().charAt(0);

        if (caracter == '.') {
            if (buscado == caracter) {
                cant = 1;
            }
        }else{
            if(caracter==buscado){
                cant=1+cantCaracter(buscado);
            }else{
                cant=cantCaracter(buscado);
            }
        }

        return cant;
    }
}
