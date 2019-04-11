/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhasMusicas;

import java.util.Scanner;

/**
 *
 * @author internet
 */
public class Principal {
    
    
     public static void main(String[] args) {
        
        Scanner teclado=new Scanner (System.in);     //(System.in) = Entrada);
        
        MusicaDAO funcDAO=new MusicaDAO();
        funcDAO.conectar();
        
        MusicaDAO funDAO = new MusicaDAO();
        funDAO.conectar();
        
        
        
        //Todas as atividades dos BD
        
        Musica f = new Musica();
        Musica d = new Musica();
          
        
        //inserir valor via teclado 
        
        System.out.println("Informe a Musica");
        f.setMusica(teclado.next());
        System.out.println("Informe o Cargo");
        f.setTempo(teclado.nextFloat());
        System.out.println("Informe o Genero");
        f.setGenero(teclado.next());
        System.out.println("Informe o Preço");
        f.setPreco(teclado.nextFloat());
      
        
        funcDAO.inserir(f);
        funDAO.delete(d);
        
        
        System.out.println("Qual id para deletar");
        f.setId(teclado.nextInt());
        funcDAO.delete(d);
        
        //saida
        System.out.println(funcDAO.listar());
        
        
        
        funcDAO.fechar();
    }
    
}
}
