/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabuada;

import java.util.Scanner;

/**
 *
 * @author bcamargo
 */
public class Tabu {
    
    public static void main(String[] args){
        
        int cont = 0;
        
        Scanner sc = new Scanner(System.in);
        
    System.out.println("Digite a tabuada desejada");
     int n = sc.nextInt();

     for ( int i=0;i<9;i++){
         cont = n * i;
  System.out.print(n + " X " + i +" = "+ cont + "\n");
     }
    
     
    
}
}
