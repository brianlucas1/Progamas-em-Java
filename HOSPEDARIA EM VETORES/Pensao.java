/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntidadesPensao;


public class Pensao {
   
    String nome;
    String email;
    int quarto;

     public Pensao(String nome, String email, int quarto) {
        this.nome = nome;
        this.email = email;
        this.quarto = quarto;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
    return  
            "\n"
            +" Hospede: "
            +nome
            +"\n"
            +" Quarto: "
            +quarto
            +"\n"
            +" E-mail: "
            +email 
            +"\n";
            
}
    
}

    




