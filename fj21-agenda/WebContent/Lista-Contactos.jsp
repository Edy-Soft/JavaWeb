
<%@page import="java.text.*" session="false"%>
<%@ page import="java.util.*, ao.co.always.jdbc.dao.*,
				ao.co.always.jdbc.modelo.*"%>
				
<html>
	<body>
	<h3 align="center">DADOS VINDO DO BANCO DE DADOS</h3>
		<table align="center" border="1">
			<% ContactoDAO dao = new ContactoDAO(); 
			
			List<Contacto> contactos = dao.getLista();
			%>
			<tr>
				<th align="left">CODIGO</th>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>ENDERECO</th>
				<th>DATA NASCIMENTO</th>
			</tr>
			<% 
			   for (Contacto contacto : contactos){
			%>
			<tr>
				<td align="center"><%=contacto.getId() %></td>
				<td><%=contacto.getNome()%></td>
				<td><%=contacto.getEmail()%></td>
				<td><%=contacto.getEndereco()%></td>
				<td><%=contacto.getDataNascimento().getTime() %></td>
			</tr>
			
			<%}%>
		</table>
	</body>
</html>