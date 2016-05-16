package ao.co.always.mvc.logica;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

public class AdicionaContactoLogica implements Logica{
	public void executa(HttpServletRequest request,
			 HttpServletResponse response) throws Exception{
		
		Contacto contacto = new Contacto();
	
		contacto.setNome(request.getParameter("nome"));
		contacto.setEmail(request.getParameter("email"));
		contacto.setEndereco(request.getParameter("endereco"));
		
		//Formata a data de Nascimento
		String dataTexto = request.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/mm/yyyy").parse(dataTexto);
		Calendar dataNascimetno = Calendar.getInstance();
		dataNascimetno.setTime(date);
				
		//Atribui a data de Nascimento ao método setdataNascimento
		contacto.setDataNascimento(dataNascimetno);
		
		// SALVA O CONTACTO
		Connection connection = (Connection) request
				.getAttribute("conexao");
		ContactoDAO dao = new ContactoDAO(connection);
		dao.adiciona(contacto);
		
		// IMPRIME O NOME DO CONTACTO GRAVADO
		RequestDispatcher rd = request.getRequestDispatcher("/Lista-Contactos-Elegante.jsp");
		rd.forward(request, response);
	}
}
