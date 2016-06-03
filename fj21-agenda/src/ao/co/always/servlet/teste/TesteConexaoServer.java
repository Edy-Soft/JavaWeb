package ao.co.always.servlet.teste;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ao.co.always.jdbc.ConnectionFactory;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/teste")
public class TesteConexaoServer extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest request,
						HttpServletResponse response)
					throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
	
	Connection connection = new ConnectionFactory().getConnection();
	out.println("Conexao a partir do Servidor aberta");
	try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
