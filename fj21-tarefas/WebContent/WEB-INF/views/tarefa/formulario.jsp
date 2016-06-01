<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
		<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
	</head>
	<body>
		<h3>Adicionar Tarefas</h3>
		<form:errors path="tarefa.descricao" cssStyle="color:red"/>
		<form action="adicionaTarefa" method="post">
			Descri��o<br />
			<textarea name="descricao" rows="5" cols="100"></textarea><br />
			<input type="submit" value="Adicionar">
		</form>
		
	</body>
</html>