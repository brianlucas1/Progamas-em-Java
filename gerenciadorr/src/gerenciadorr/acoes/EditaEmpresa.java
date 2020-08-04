package gerenciadorr.acoes;

import gerenciadorr.modelo.Banco;
import gerenciadorr.modelo.Empresa;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaEmpresa implements Acao {
	
	
	public String executa (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
			String nomeEmpresa = request.getParameter("nome");
	        String parmDataAbertura = request.getParameter("data");
	        String paramId = request.getParameter("id");
	        
	        Integer id = Integer.valueOf(paramId);
	        
	        System.out.println(" ACAO ALTERANDO");
	        
	        Date dataAbertura = null;
	        try {
	        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 dataAbertura =   sdf.parse(parmDataAbertura);
			} catch (ParseException e) {
			  System.out.println("ERRO NA FORMATAR A DATA DE CADASTRO DA EMPRESA");
				e.printStackTrace();
			}	        
	        
	        //UPDATE
	        Banco banco = new Banco();
	        Empresa empre = banco.buscaEmpresa(id);
	        empre.setNome(nomeEmpresa);	 
	        empre.setDataAbertura(dataAbertura);	        
	   	        
	        return "redirect:entrada?acao=ListaEmpresas";
		
	}

}



