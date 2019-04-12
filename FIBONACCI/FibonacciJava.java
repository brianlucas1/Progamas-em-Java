
package fibonacci.java;


public class FibonacciJava {

    public static void main(String[] args){
        int prox = 0;
        int ant = 1;
        
        System.out.println(prox);
        System.out.println(ant);
        
        for(int i = 0; i < 8; i++){
            prox = prox + ant;
            ant = prox - ant;
            System.out.println(prox);
        }
    }
    
}
       
                 
       
