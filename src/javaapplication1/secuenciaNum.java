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
public class secuenciaNum {
    public static void main(String[] args) {
        int menor;
        menor = buscarMenor();
        System.out.println(menor);
    }
    
    public static int buscarMenor() {
        Scanner pufu = new Scanner(System.in);
        int menor, retorno, num;
        
        System.out.println("Ingrese un numero");
        num = pufu.nextInt();
        
        if(num == 0) {
            menor = 0;
        } else {
            retorno = buscarMenor(); //1 , 2, 3, -1, 0
            if(retorno == 0) {
                menor = num;
            } else {
                if(retorno <= num) {
                    menor = retorno;
                } else {
                    menor = num;
                }
            }
        }
        return menor;
    }
}
