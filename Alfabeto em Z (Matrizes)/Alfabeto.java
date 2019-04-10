package ABCEDARIO;


import java.util.Scanner;

public class Alfabeto {

public static void main(String[] args) {
	
	
    Scanner scan = new Scanner(System.in); 
 
	//  STRING ALFABETO RECEBE O ABECEDARIO,
    String alfabeto = "abcdefghijklmnopqrstuxwyz";
	// ATRIBUINDO CADA LETRA DO ALFABETO EM UMA MATRIZ
    char vletra[] = alfabeto.toCharArray(); 
    System.out.println("LINHAS  ");
    int mLinha = scan.nextInt();
    System.out.println("COLUNAS   ");
    int mColuna = scan.nextInt();
	// CONTADOR DAS LETRAS DO ALFABETO PARA QUE NÃO ULTRAPASSEM 26, POIS O ALFABETO TEM 26 LETRAS.
    int contAlfabeto=0,
    	contMaLinha=1,
	// FAZ A FORMA DO "Z" 
    	contMaColuna=mColuna-2;

    

// Contato os espaços
    char[][] matriz = new char[mLinha][mColuna];
    for(int i=0;i<mLinha;i++){
        for(int j=0;j<mLinha;j++){
        	matriz[i][j]=' ';
        }
    }
    //   Atribuindo a coluna uma letra do alfabeto 
    for(int i=0;i<mColuna;i++){
    	matriz[0][i]=vletra[contAlfabeto];
        contAlfabeto++;
        if(contAlfabeto==26){
            contAlfabeto=0;
        }
    }
    
    //// 
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
    
        if(contAlfabeto==26){
            contAlfabeto=0;
        }
    }
    for(int i=0;i<mLinha;i++){
        for(int j=0;j<mColuna;j++){
            System.out.print(matriz[i][j]+"   ");
        }
        System.out.println();
        
    }
    
}
}
