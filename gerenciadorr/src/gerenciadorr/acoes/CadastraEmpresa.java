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

public class CadastraEmpresa implements Acao {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
				return ("forward:ifrmNovaEmpresaa.jsp");
	      }

}



