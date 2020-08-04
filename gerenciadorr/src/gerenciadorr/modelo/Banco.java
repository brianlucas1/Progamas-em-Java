package gerenciadorr.modelo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa>  lista = new ArrayList<>();
	private static List<Usuario> userList = new ArrayList<>();
	private static Integer chaveID = 1;
	
	
	static {
		 Usuario u1 = new Usuario();
		    u1.setLogin("b");
		    u1.setSenha("123");		
		    userList.add(u1);
	}
	
	
	   public void adiciona(Empresa empresa) {
		   empresa.setId(Banco.chaveID++);
		   Banco.lista.add(empresa);
			}	   
	   public List<Empresa> getEmpresas(){
		   return Banco.lista;
	   }

	   
	   public void remove (Integer id){
		   //usando o iterator para trabalhar com o objetos da lista de empresa
		   // ele sabe qual o ID de empresa remover sem danificar a lista
		   Iterator<Empresa> it = lista.iterator();
		   
		   while (it.hasNext()){
			   Empresa emp = it.next();
			   
			 if(emp.getId() == id){
				 it.remove();
			 }
		   }
		  		  
	   }
	public Empresa buscaEmpresa(Integer id) {
	
		for(Empresa emp : lista){
			if (emp.getId()== id){
				return emp;
			}
		}
		
		return null;
	}
	public Usuario validaUsuario(String login, String senha) {
	
			for (Usuario usuario : userList ){
				if (usuario.ehIgual(login, senha)){
					return usuario;			
									
				}
					
			}
			return null;
			
			
		
		
	}
}
