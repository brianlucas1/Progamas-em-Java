package gerenciadorr.acoes;

import gerenciadorr.modelo.Banco;
import gerenciadorr.modelo.Empresa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListaEmpresas implements Acao {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    System.out.println("LISTA EMPRESA");
	    
		Banco banco = new Banco();
	    List<Empresa> lista = banco.getEmpresas();
	  
	    
	    request.setAttribute("empresas", lista);

	  //  http://localhost:8080/gerenciadorr/entrada?acao=listaEmpresa
	   
		
	    return "forward:listaEmpresa.jsp";
	    
	}

}
