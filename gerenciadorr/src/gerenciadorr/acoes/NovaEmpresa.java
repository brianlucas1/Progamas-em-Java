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

public class NovaEmpresa implements Acao {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
			System.out.println("Cadastrando nova empresa");
		 
		 // responsável por pegar o parametro da requisição localhost:/gerenciador/novaEmpresa?nome=alura
	        String nomeEmpresa = request.getParameter("nome");
	        String parmDataAbertura = request.getParameter("data");
	        
	        Date dataAbertura = null;
	        try {
	        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 dataAbertura =   sdf.parse(parmDataAbertura);
			} catch (ParseException e) {
			  System.out.println("ERRO NA FORMATAR A DATA DE CADASTRO DA EMPRESA");
				e.printStackTrace();
			}
	        
	        Empresa empresa = new Empresa();
	        empresa.setNome(nomeEmpresa);
	        empresa.setDataAbertura(dataAbertura);
	    
	        Banco banco = new Banco();
	        banco.adiciona(empresa);
	        
	        request.setAttribute("empresa", empresa.getNome());
	      	        
	        return "redirect:entrada?acao=ListaEmpresas";
	        
	        //NÃO USARR  O getRequestDispatcher POIS O MESMO GUARDA OS DADOS DA ANTIGA REQUISIÇÃO
	        // CASO DER F5 NA PAGINA, É ENVIADO NOVAMENTE OS DADOS NA REQUISIÇÃO, GERANDO DUPLICIDADE
//	        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//	        request.setAttribute("empresa", empresa.getNome());
//	        rd.forward(request, response);
//	       
		
	}

}



