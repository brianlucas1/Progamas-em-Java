/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author internet
 */
public class FuncionarioDAO {
    private final String URL="jdbc:mysql://localhost:3306/empresa";
    private final String USER="root";
    private final String SENHA="";
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;
    
    public void conectar(){
        
        try{
            con=DriverManager.getConnection(URL,USER,SENHA);
            System.out.println("Conexão realizada com sucesso Galerinha! ");
        }catch (SQLException problema){
            System.out.println("Não foi possivel conectar galerinha, tente novamente!\n "+problema);
        }
            
        }
       public void fechar(){
            try{
                con.close();
                System.out.println("Conexão encerrada");
            }catch(SQLException problema){
                System.out.println("Falha ao fechar ");
            }
       }
       public String listar(){
           try {
              String comando="SELECT * FROM Funcionario ORDER BY nome";
              st=con.prepareStatement(comando);
              rs=st.executeQuery();
              String r="";
              while(rs.next()){
                  r+=rs.getInt("id")
                  +" - "+rs.getString("nome")
                  +" - "+rs.getString("cargo")
                  +" - "+rs.getFloat("salario")
                  +"\n";
                  
              }
              return r;
           } catch(SQLException problema){
               System.out.println("Falha ao listar \n"+problema);
               return "";
               
           }
       }
        public void inserir (Funcionario f ){
                      
           try {
               
            String comando = "INSERT INTO funcionario(nome, cargo, salario ) VALUES(?,?,?)";
               
            st=con.prepareStatement(comando);
               
            st.setString(1, f.getNome());
            st.setString(2, f.getCargo());
            st.setFloat(3, f.getSalario());
             
            //st.setString(1, "Rafael");      
            // st.setString(2, "Estagiario");
            // st.setFloat(3, 1800);
                    
               st.execute();
           } catch (SQLException e) {
             
               //Aprimorar o projeto construído em aula, escrevendo os métodos atualizar salário por id e remover registro por id.
               }
           } 
           
       public void delete (Funcionario d){
            try {     
                
            String comando = "DELETE *FROM funcionario WHERE id =(?)";
            
            st=con.prepareStatement(comando);
            st.setInt(1, d.getId());
            st.executeUpdate();
            } catch (SQLException e) {
                
            }
            
        }
       
       
        
        
    }








               
        
       
        


