<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<head>
		<script type="text/javascript" src="resources/js/jquery.js"></script>
	</head>
<body>

	<script type="text/javascript">
		function finalizaAgora(id) {
			$.post("finalizaTarefa", {'id' : id}, function (resposta){
				$("#tarefa_"+id).html(resposta);
			});
		}
	</script>

	<a href="novaTarefa">Criar nova tarefa</a> 
	<br /> <br/>
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalização</th>
			<th>Data de finalização</th>
		</tr>
		<c:forEach items = "${tarefas}" var="tarefa">
			<tr id="tarefa_${tarefa.id}">
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao}</td>
					<!-- Finalizar uma terefa -->
				<c:if test="${tarefa.finalizado eq false}">
					<td>
						<a href="#" onClick="finalizaAgora(${tarefa.id})">Finaliza Agora!</a>
					</td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizada</td>
				</c:if>
				
				<td>
					<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
									pattern="dd/mm/yyyy"/> 
				</td>
				<td> <a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
				<td> <a href="mostraTarefa?id=${tarefa.id}">Alterar</a> </td>
			</tr>
		</c:forEach>		
	</table>
	
</body>
</html>