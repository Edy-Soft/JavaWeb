package ao.co.always.mvc.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ao.co.always.mvc.logica.Logica;

@SuppressWarnings("serial")
public class ControllerServlet extends HttpServlet{
	protected void service(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException{
		
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "ao.co.always.mvc.logica." + parametro;
		
		try{
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);
		}catch (Exception e){
			throw new ServletException("A logica de negocio deu erro", e);
		}
	}
}
