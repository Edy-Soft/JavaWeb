package ao.co.always.agenda.filtro;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FiltroTempoExecucao implements Filter{
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain) throws IOException, ServletException{
		
		long tempoInicial = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest)request).getRequestURI();
		System.out.println("Tempo da requisição de "+
					uri + " demorou (ms): " + (tempoFinal - tempoInicial));
		
			}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
