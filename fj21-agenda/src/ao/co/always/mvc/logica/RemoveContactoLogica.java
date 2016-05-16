package ao.co.always.mvc.logica;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

public class RemoveContactoLogica implements Logica{

	public void executa(HttpServletRequest request,
			 HttpServletResponse response) throws Exception{
		
	Contacto contacto = new Contacto();
		
		String id = request.getParameter("id");
		contacto.setId(Long.parseLong(id));
		
		Connection connection = (Connection) request
				.getAttribute("conexao");
		ContactoDAO dao = new ContactoDAO(connection);
		dao.remover(contacto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Lista-Contactos-Elegante.jsp");
		rd.forward(request, response);
		
		System.out.println("Removendo contacto..." +contacto.getNome());
	}
}
