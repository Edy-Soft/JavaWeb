package ao.co.always.mvc.logica;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{
	public void executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		System.out.println("Executnado a logica...");
		System.out.println("Redirecionando para a jsp");
		
		RequestDispatcher rd = request.getRequestDispatcher("/primeira-logica.jsp");
		rd.forward(request, response);
	}

}
