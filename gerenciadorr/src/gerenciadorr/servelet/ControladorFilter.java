package gerenciadorr.servelet;

import gerenciadorr.acoes.Acao;
import gerenciadorr.acoes.CadastraEmpresa;
import gerenciadorr.acoes.EditaEmpresa;
import gerenciadorr.acoes.ListaEmpresas;
import gerenciadorr.acoes.MostraEmpresa;
import gerenciadorr.acoes.NovaEmpresa;
import gerenciadorr.acoes.RemoveEmpresa;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EntradaServlet
 */

public class ControladorFilter implements Filter {
	
       
   
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

		
		String paramAcao = request.getParameter("acao");
		String executaClasse = "gerenciadorr.acoes." + paramAcao;
		
//		  //METODO PARA VERIFICAR SE O USUARIO PASSOU PELA TELA DE LOGIN
//	    // A SESSÃO GUARDA OS DADOS DO LOGIN, ASSIM FAZEMSO A VALIDAÇÃO
//	    HttpSession sessao = request.getSession();	   
//	    boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
//	    //SE FOR UMA ACAO DE LOGIN ELE PERMITE CHAMAR A PAGINA
//	    //CASO NÃO SEJA E O USUARIO NÃO FOI LOGADO ELE NÃO DEIXA ACESSAR A PAGINA
//	    boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//        if(ehUmaAcaoProtegida & usuarioNaoEstaLogado) {
//	        response.sendRedirect("entrada?acao=LoginForm");
//	        	return;
//	    }	
//	    
		
		String nome = null;
		//USANDO API Reflection
		// INSTANCIANDO A CLASSE DE UMA MANEIRA DIFERENTE E DEIXANDO O CODIGO CLEAN		
		try {
			Class  classe = Class.forName(executaClasse);
			//TODA CLASSE A SER EXECUTADA É UMA AÇÃO FOI UTILIZADO O INTERFACE 
			Acao acao = (Acao) classe.newInstance();
			nome =acao.executa(request,response);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}	

		
		String[] tipoEEndereco = nome.split(":");
	    if(tipoEEndereco[0].equals("forward")) {
	        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
	        rd.forward(request, response);
	    } else {
	        response.sendRedirect(tipoEEndereco[1]);

	    }
		
		
		
		//ALTERADO O MODO DE PEGAR A AÇÃO DO SERVLET
		// O CODIGO ABAIXO É UM EXEMPLO DE CODIGO RUIM RS
//		
//		
//		if (paramAcao.equals("listaEmpresa")){					
//			ListaEmpresas acao = new ListaEmpresas();
//			 nome = acao.executa(request, response);		
//		}
//		
//		else if (paramAcao.equals("removeEmpresa")){					
//			RemoveEmpresa acao = new RemoveEmpresa();
//		    nome = acao.executa(request, response);			
//		}
//		
//		else if (paramAcao.equals("editaEmpresa")){		
//			
//			EditaEmpresa acao = new EditaEmpresa();
//		    nome = acao.executa(request, response);			
//		}
//		else if (paramAcao.equals("mostraEmpresa")){				
//			MostraEmpresa acao = new MostraEmpresa();
//		    nome = acao.executa(request, response);			
//		}
//		else if (paramAcao.equals("novaEmpresa")){					
//			NovaEmpresa acao = new NovaEmpresa();
//		    nome = acao.executa(request, response);			
//		}
//		
//	else if (paramAcao.equals("cadastraEmpresa")){				
//		CadastraEmpresa acao = new CadastraEmpresa();
//		    nome = acao.executa(request, response);			
//		}
//		
		
		
		
	}

	@Override
	public void destroy() {
	
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

		
	}


}