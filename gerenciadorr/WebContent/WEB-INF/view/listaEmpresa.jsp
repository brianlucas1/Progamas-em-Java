<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, gerenciadorr.modelo.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FDP</title>
</head>
<body>
			<c:import url= "LogoutParcial.jsp" />
			

			 Usuario Logado: ${usuarioLogado.login }

    <br>
    <br>
    <br>

 <c:if test="${not empty empresa }">
     	Empresa ${ empresa } cadastrada com sucesso
     </c:if>
     
  

<!--   EXEMPLO DE FOR EACH COM EXPRESSION LENGUAGE, IMPORTADO A LIB JSTL, USANDO O $PARA PEGAR A REQUISIÇÃO EMPRESAS
					http://localhost:8080/gerenciadorr/listaEmpresas
 -->
<ul>

	<c:forEach items="${empresas}" var="empresa" >
		
		<li>
		${empresa.nome}  - <fmt:formatDate  value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />
		<a href="/gerenciadorr/entrada?acao=RemoveEmpresa&id=${empresa.id }"> Remove -  </a> 
		<a href="/gerenciadorr/entrada?acao=MostraEmpresa&id=${empresa.id }"> Editar </a> 
		
		 </li>	
			
	</c:forEach> 

</ul>


</body>
</html>