<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista Contactos com Elegancia</title>
	</head>
<body>
	<c:import url="cabecalho.jsp"/>
	
 	                  <!-- INTANCIA A CLASSE DAO -->
 	<jsp:useBean id="dao" class="ao.co.always.jdbc.dao.ContactoDAO"/>
 	
 <form method="post">	
 	<table border="1">
 			<tr>
 				<th>CÓDIGO</th>
 				<th>NOME</th>
 				<th>EMAIL</th>
 				<th>ENDERECO</th>
 				<th>DATA NASCIMENTO</th>
 				<th>ACÇÕES</th>
 			</tr>	
 		<c:forEach var="contacto" items="${dao.lista}">
 			<tr>
 				<td>${contacto.id}</td>
 				<td>${contacto.nome}</td>
 				<td>
 					<c:choose>
 						<c:when test="${not empty contacto.email}">
 							<a href="mailto:${contacto.email}">${contacto.email}</a>
 						</c:when>
 						<c:otherwise>
 							E-mail não cadastrado
 						</c:otherwise>
 					</c:choose>
 				</td>
 				<td>${contacto.endereco}</td>
 				<td align="center">
 					<fmt:formatDate value="${contacto.dataNascimento.time}" pattern="dd/MM/yyyy"/> 
 				</td>
 				<td> <a href="altera-contacto.jsp?id=${contacto.id}&nome=${contacto.nome}
 				&email=${contacto.email}&endereco=${contacto.endereco}
 				&dataNascimento=<fmt:formatDate value="${contacto.dataNascimento.time}" pattern="dd/MM/yyyy"/>
 				">Alterar</a> 
 				</td>
 				<td><a href="mvc?logica=RemoveContactoLogica&id=${contacto.id}">Deletar</a></td>
 			</tr>
 		</c:forEach>
 	</table>
 				<input type="button" size="20" id="id_button" value="Novo" onclick="parent.location.href='adiciona-contactos.jsp'">
 </form>				
 <c:import url="rodape.jsp"/>
</body>
</html>