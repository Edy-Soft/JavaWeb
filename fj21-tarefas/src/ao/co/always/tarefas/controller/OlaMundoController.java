package ao.co.always.tarefas.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {
	
	@RequestMapping("/olaSpring")
	public String execute(){
		System.out.println("Execunto logica com spring");
		return "ok";
	}

}
