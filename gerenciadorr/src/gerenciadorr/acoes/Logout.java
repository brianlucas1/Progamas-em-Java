package gerenciadorr.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		//RETIRA OS DADOS DA HTTPSESSION, ISSO FAZ SER OBRIGATORIO NOVAMENTE O LOGIN.
		//sessao.removeAttribute("usuarioLogado");
			sessao.invalidate();
			
		return "redirect:entrada?acao=LoginForm";
	}

}
