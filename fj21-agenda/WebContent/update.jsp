<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<body>
	<c:import url="cabecalho.jsp"/>
	
 	                  <!-- INTANCIA A CLASSE DAO -->
 	<jsp:useBean id="contactos" class="ao.co.always.jdbc.modelo.Contacto"/>
 		<form>
 				Id:<br>
 				<input type="text" value="${contactos.id}"/><br>
 				Nome:<br>
 				<input type="text" value="${contactos.nome}"/><br>
 				Email:<br>
 				<input type="text" value="${contactos.email}"/><br>
 				Endereço:<br>
 				<input type="text" value="${contactos.endereco}"/><br>
 				<input type="submit" value="Alterar"/><br>
 		</form>
 <c:import url="rodape.jsp"/>
</body>
</html>