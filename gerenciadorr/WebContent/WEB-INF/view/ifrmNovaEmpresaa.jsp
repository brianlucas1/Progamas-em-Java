<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<c:url value = "entrada" var = "ServletNovaEmpresa"/>

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
 
<form action="${ServletNovaEmpresa}" method="post">

       	 Nome: <input type="text" name="nome" />        
         Data Abertura: <input type="text" name="data" />
         
         <input type="hidden" name="acao" value="NovaEmpresa" />

        <input type="submit" />
        

</body>
</html>