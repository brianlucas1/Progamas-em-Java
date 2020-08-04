<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value = "entrada" var = "loginCadastro"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:import url= "LogoutParcial.jsp" />
<!-- POSTANDO DADOS PARA A NOVAEMPRESA.JAVA CAPTURAR -->
 <!--  http://localhost:8080/gerenciadorr/ifrmNovaEmpresa.jsp -->
 
<form action="${loginCadastro}" method="post">

      Login: <input type="text" name="login" />        
       Senha: <input type="text" value" name="senha" /> 
       
       <input type="hidden" name="acao" value="Login">
        
              <input type="submit" />

</body>
</html>