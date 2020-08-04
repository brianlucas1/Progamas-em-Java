package gerenciadorr.servelet;

import gerenciadorr.modelo.Banco;
import gerenciadorr.modelo.Empresa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

//http://localhost:8080/gerenciadorr/jsonLista

@WebServlet("/jsonLista")
public class JsonServlet extends HttpServlet {

 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String valor = request.getHeader("Accept");
			
		
		if(valor.contains("xml")){
			//XML
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas); 			
			response.setContentType("application/xml");
			response.getWriter().print(xml);					
			
		}else if (valor.contains("json")){			
			//JSON			
			Gson gson = new Gson();		
			String json = gson.toJson(empresas); 
			response.getWriter().print(json);	
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		}else{
			response.setContentType("application/json");
			response.getWriter().print("sem dados");
		
		}
		
	
		
	}

}
