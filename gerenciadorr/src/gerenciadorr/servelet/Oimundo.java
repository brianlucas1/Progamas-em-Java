 package gerenciadorr.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


// NA HORA QUE CHAMAR O LINK LOCALHOST:8080/GERENCIADORR/TESTE
//VAI ABRIR OQUE TIVER NO RESP = RESPONSE DA URL
@WebServlet (urlPatterns = "/teste")

// EXTENDENDO UM SERVLET HTTP
public class Oimundo  extends HttpServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws IOException{
		
		 PrintWriter out = resp.getWriter();
	        out.println("<html>");
	        out.println("<body>");
	        out.println("oi mundo, parabens vc escreveu o primeiro servlets.");
	        out.println("</body>");
	        out.println("</html>");
	}


}
