<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="always"%>

<html>
	<head>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		
		<form action="mvc" method="POST">
			Nome<br> 
			<input type="text" name="nome" /><br/>
			Email<br>
			 <input type="text" name="email" /><br/> 
			endereco<br>
			<input type="text" name="endereco" /><br/>
			Data Nascimento<br> 
			<always:campoData id="dataNascimento"/><br/>
			
			<input name="logica" type="hidden" value="AdicionaContactoLogica">
			<input type="submit" value="Gravar" />
			<input type="button" id="id_button" value="Cancelar" onclick="parent.location.href='Lista-Contactos-Elegante.jsp'">
		</form>
		<c:import url="rodape.jsp"/>
	</body>
</html>