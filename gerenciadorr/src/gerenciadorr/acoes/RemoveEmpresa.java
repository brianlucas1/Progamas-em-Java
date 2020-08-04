package gerenciadorr.acoes;

import gerenciadorr.modelo.Banco;
import gerenciadorr.modelo.Empresa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveEmpresa implements Acao{
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		
		String	paramID =  request.getParameter("id");
		 Integer Id = Integer.valueOf(paramID);
		 
		 Banco banco = new Banco();		 
		 banco.remove(Id);
		 System.out.println("acao removida");
		 
		 
		 return "redirect:entrada?acao=ListaEmpresas";
	 

	    //http://localhost:8080/gerenciadorr/entrada?acao=removeEmpresa

		
	}

}



