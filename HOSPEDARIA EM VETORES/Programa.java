
package Exercicios;

import EntidadesPensao.Pensao;
import java.util.Locale;
import java.util.Scanner;


public class Programa {
    
    @SuppressWarnings("null")
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        
        System.out.printf("Quantos quartos serão alugados ? : ");
        int n  = sc.nextInt();
        
        Pensao[] vet = new Pensao[10];
        
        for (int i=0;i<n;i++){
            
        System.out.printf("Pedido: "+ (i+1) + "\n");
        System.out.printf("NOME do Hospede : ");
        String nome = sc.next();
        sc.nextLine();
        System.out.printf("e-mail do Hospede : ");
        String email = sc.next();
        sc.nextLine();
        System.out.printf("Quarto desejado : ");
        Integer  quarto = sc.nextInt();
        
        vet[i]  = new Pensao(nome, email, quarto);

        }
           for ( int i=0;i<n;i++){
             System.out.printf(vet[i]+ "");

        }    
          
    }
}
    

        
 
