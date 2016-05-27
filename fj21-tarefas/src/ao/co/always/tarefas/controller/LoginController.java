package ao.co.always.tarefas.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ao.co.always.tarefas.dao.JdbcUsuarioDao;
import ao.co.always.tarefas.modelo.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "formulario-login";
	}
	@RequestMapping("efectuaLogin")
	public String efectuaLogin(Usuario usuario, HttpSession session){
		if (new JdbcUsuarioDao().existeUsuario(usuario)){
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}
}
