package ABCEDARIO;


import java.util.Scanner;

public class Alfabeto {

public static void main(String[] args) {
	
	  /// Declarando as variaveis
    Scanner scan = new Scanner(System.in); //Metodo Scanner, onde o codigo lê os valores digitados.
 
    String alfabeto = "abcdefghijklmnopqrstuxwyz";
    char vletra[] = alfabeto.toCharArray(); //Declarando onde o vetor recebe as letras
    System.out.println("LINHAS  ");
    int mLinha = scan.nextInt();
    System.out.println("COLUNAS   ");
    int mColuna = scan.nextInt();
    int contAlfabeto=0,
    	contMaLinha=1,
    	contMaColuna=mColuna-2;

    

// atribuindo as posições da matriz
    char[][] matriz = new char[mLinha][mColuna];
    for(int i=0;i<mLinha;i++){
        for(int j=0;j<mLinha;j++){
        	matriz[i][j]=' ';
        }
    }
    //  duas primeiras linhas são inteiras são sempre preenchidas e add uma letra 	por linha
    for(int i=0;i<mColuna;i++){
    	matriz[0][i]=vletra[contAlfabeto];
        contAlfabeto++;
        if(contAlfabeto==26){
            contAlfabeto=0;
        }
    }
    
    //// contador onde a ultima letra da linha diminui o da coluna formando o z
    for(;(contMaLinha+1)<mLinha;contMaLinha++,contMaColuna--){
    	matriz[contMaLinha][contMaColuna]=vletra[contAlfabeto];
        contAlfabeto++;
        if(contAlfabeto==26){
            contAlfabeto=0;
        }
    }
    
   
    contMaLinha=mLinha-1;
    for(int i=0;i<mLinha;i++){
    	matriz[contMaLinha][i]=vletra[contAlfabeto];
        contAlfabeto++;
        // // se chegar na ultima letra do alfabeto volta para o A
        if(contAlfabeto==26){
            contAlfabeto=0;
        }
    }//saida da matriz
    for(int i=0;i<mLinha;i++){
        for(int j=0;j<mColuna;j++){
            System.out.print(matriz[i][j]+"   ");
        }
        System.out.println();
        
    }
    
}
}