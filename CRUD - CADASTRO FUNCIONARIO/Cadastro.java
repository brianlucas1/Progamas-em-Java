
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.util.Scanner;
        
public class Cadastro {

    public static void main(String[] args) {
        
        Scanner teclado=new Scanner (System.in);     //(System.in) = Entrada);
        
        FuncionarioDAO funcDAO=new FuncionarioDAO();
        funcDAO.conectar();
        
        FuncionarioDAO funDAO = new FuncionarioDAO();
        funDAO.conectar();
        
        
        
        //Todas as atividades dos BD
        
        Funcionario f = new Funcionario();
        Funcionario d = new Funcionario();
          
        
        //inserir valor via teclado 
        
        System.out.println("Informe o nome");
        f.setNome(teclado.next());
        System.out.println("Informe o Cargo");
        f.setCargo(teclado.next());
        System.out.println("Informe o Salario");
        f.setSalario(teclado.nextFloat());
        
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
