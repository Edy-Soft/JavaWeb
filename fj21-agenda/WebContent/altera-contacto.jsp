<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="alwyas" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:import url="cabecalho.jsp"></c:import>

<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Contacto</title>
    </head>
	<body>
		FORMULÁRIO PARA ALTERAÇÃO DE CONTACTOS<br><br/>
		
		<form action="mvc" method="post">
		Id<br>
		<input name="id" type="text" value="${param.id}"><br>
		Nome<br>
		<input name="nome" type="text" value="${param.nome}"><br>
		Email<br>
		<input name="email" type="text" value="${param.email}"><br>
		Endereço<br>
		<input name="endereco" type="text" value="${param.endereco}"><br>
		Data Nascimento<br>
			<input name="dataNascimento" type="text" value="${param.dataNascimento}">
			<!--<alwyas:campoData id="dataNascimento"></alwyas:campoData> -->
		<input name="logica" type="hidden" value="AlteraContactoLogica"><br>
		<input type="submit" value="Alterar">
		<input type="button" id="id_button" value="Cancelar" onclick="parent.location.href='Lista-Contactos-Elegante.jsp'">
		</form>
	</body>
	<c:import url="rodape.jsp"></c:import>
</html>