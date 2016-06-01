<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
	<head>
		<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
	</head>
<body>

<table>
	<tr>
		<td>${tarefa.id}</td>
		<td>${tarefa.descricao}</td>
		<td>Finalizada</td>
		<td>
			<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
				pattern="dd/mm/yyyy"/> </td>
		<td> <a href="removeTarefa?id=${tarefa.id}">Remover</a> </td>
		<td> <a href="mostraTarefa?id=${tarefa.id}">Alterar</a> </td>
	</tr>
</table>

</body>
</html>