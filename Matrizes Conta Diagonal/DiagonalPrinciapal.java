/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrizes;

import java.util.Scanner;

/**
 *
 * @author bcamargo
 */
public class DiagonalPrinciapal {
    
    public static void main (String [] args){
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Digiete o tamanho da Matriz");
    int n = sc.nextInt();
    
    int [][] matriz = new int[n][n];
    
    // CRIANDO A MATRIZ NA MEMORIA
    for ( int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            matriz[i][j] = sc.nextInt();
        }
    }
    // VERIFICA QUAL É A DIAGONAL PRINCIPAL
     System.out.println("Diagonal principal");
     for ( int i =0;i<n;i++){
         System.out.print(matriz[i][i] + " ");
     }
     
     // CONTADOR QUE PERCORRE A MATRIZ ONDE ELE TEM NUMERO NEGATIVO ATRIBUIU A VARIAVEL CONT.
     int cont = 0;
     for ( int i=0;i<n;i++){
        for (int j=0;j<n;j++){
            
           if ( matriz[i][j] < 0 ){
               cont++;
           }
        }
         
     }
     
     System.out.print("Numero negativos na matriz" + cont);
     
    }
    
}
