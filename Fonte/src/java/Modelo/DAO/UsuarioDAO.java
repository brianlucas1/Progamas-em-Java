/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import Modelo.CadastroUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.jms.ConnectionFactory;

/**
 *
 * @author bcamargo
 */
public class UsuarioDAO {
    
    private final Connection conexao;
    PreparedStatement ps = null;
    
    
     public UsuarioDAO() throws SQLException {
        this.conexao = ConnectionFactory.getInstance().getConnection();
    }
     
      public String Inserir(CadastroUsuario cad) throws SQLException {
            String sql = "INSERT INTO CadastroUsuario "
                + "(Nome, Sobrenome, CPF, Telefone, Celular, Endereco, Complemento, Cidade, Estado, Cep, Email, dataNascimento) "
                + "VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement psI = conexao.prepareStatement(sql);
            psI.setString(1, cad.getNome());
            psI.setString(2, cad.getSobrenome());
            psI.setString(3, cad.getCPF());
            psI.setLong(4, cad.getTelefone());
            psI.setLong(5, cad.getCelular());
            psI.setString(6, cad.getEndereco());
            psI.setString(7, cad.getComplemento());
            psI.setString(8, cad.getCidade());
            psI.setString(9, cad.getEstado());
            psI.setString(10, cad.getCep());
            psI.setString(11, cad.getEmail());
            psI.setString(12, cad.getDataNascimento());

            psI.execute();
            conexao.close();
            return "Registro incluído com sucesso!";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    
    
}
