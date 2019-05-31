/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class GeraSenha {
    
    private String senha;
    private String ConfirmaSenha;

    public GeraSenha(String senha, String ConfirmaSenha) {
        this.senha = senha;
        this.ConfirmaSenha = ConfirmaSenha;
    }
    public GeraSenha(){
        
    }

    public String getConfirmaSenha() {
        return ConfirmaSenha;
    }

    public void setConfirmaSenha(String ConfirmaSenha) {
        this.ConfirmaSenha = ConfirmaSenha;
    }
    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
 
}
