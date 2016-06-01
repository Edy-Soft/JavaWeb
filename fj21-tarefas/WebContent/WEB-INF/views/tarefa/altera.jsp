<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="always"%>

<html>
	<head>
		<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
		<script src="http://code.jquery.com/jquery-1.8.2.js"></script>
		<script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
	</head>
<body>
	<h3>Altere a tarefa selecionada </h3>
	<form action="alteraTarefa" method="post">
		<input type="text" name="id" value="${tarefa.id}"> <br />
		Descrição<br/>
		<textarea name="descricao" rows="5" cols="100">
			${tarefa.descricao}
		</textarea> <br />
		Finalizado? <input type="checkbox" name="finalizado"
		     value="true" ${tarefa.finalizado? 'checked' : ''}/> <br />
		Data de finalização <br />
		<!-- <input type="text" name="dataFinalizacao"
			value='<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
			pattern="dd/mm/yyyy" />'/>     -->
			<always:campoData id="dataFinalizacao"></always:campoData>
			<br />
		<input type="submit" value="Alterar">  
	</form>
</body>
</html>