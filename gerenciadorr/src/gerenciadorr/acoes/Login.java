package gerenciadorr.acoes;

import gerenciadorr.modelo.Banco;
import gerenciadorr.modelo.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Acao {
	@Override
	 public String executa (HttpServletRequest request,HttpServletResponse response)
	 throws ServletException,IOException{
		 
		 String login = request.getParameter("login");
		 String senha = request.getParameter("senha");
		 
		 System.out.println("senha: " +senha +"login:" +login);
		 
		 Banco banco = new Banco();
		 Usuario user = banco.validaUsuario(login, senha);	 
		 
		 if (user != null){			 
			 	System.out.println("Usuario Validado");		
			 	HttpSession sessao = request.getSession();
			    sessao.setAttribute("usuarioLogado", user);
			    return "redirect:entrada?acao=ListaEmpresas";
			 
		 }else {
			 System.out.println("Usuario não validado");
			 return "redirect:entrada?acao=LoginForm";
		 }
			 
		 
	 }

}
