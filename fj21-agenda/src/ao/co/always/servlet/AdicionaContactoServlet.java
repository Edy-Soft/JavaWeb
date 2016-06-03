package ao.co.always.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

//@WebServlet(urlPatterns = "/adicionaContactos")

@SuppressWarnings("serial")
public class AdicionaContactoServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request,
				HttpServletResponse response)
				throws ServletException, IOException {
		
		// BUSCA O WRITER
		PrintWriter out = response.getWriter();
		
		// BUSCA OS PARAMÊTROS NA REQUEST
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		// FAZENDO A CONVERSÃO DA DATA
		try{
			Date date = new SimpleDateFormat("dd/MM/yyyy")
					.parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e){
			out.println("Erro de Conversão da data");
			return;
		}
		
		// MONTA UM OBJECTO CONTACTO
		Contacto contacto = new Contacto();
		contacto.setNome(nome);
		contacto.setEmail(email);
		contacto.setEndereco(endereco);
		contacto.setDataNascimento(dataNascimento);
		
		// SALVA O CONTACTO
		ContactoDAO DAO = new ContactoDAO();
		DAO.adiciona(contacto);
		
		// IMPRIME O NOME DO CONTACTO GRAVADO
		RequestDispatcher rd = request.getRequestDispatcher("/contacto-adicionado.jsp");
		rd.forward(request, response);
		
	}

}
