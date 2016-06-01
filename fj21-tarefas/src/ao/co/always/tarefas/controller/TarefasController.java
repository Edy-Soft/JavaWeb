package ao.co.always.tarefas.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import ao.co.always.tarefas.dao.TarefaDao;
import ao.co.always.tarefas.modelo.Tarefa;

@Transactional
@Controller
public class TarefasController {
	
	@Autowired
	TarefaDao dao;
	
	// MOSTRA O FORMULÁRIO PARA ADICIONAR NOVA TAREFA
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	//METODO PARA ADICIONAR UMA TAREFA
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result){
		if (result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		dao.adiciona(tarefa);
		return "redirect:listaTarefas";
	}
	
	// METODO PARA LISTAS AS TAREFAS
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}
	
	//METODO PARA REMOVER UMA TAREFA
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa){
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	// METODO PARA ENVIAR DADOS DE UMA TAREFA NA JSP VIA URL
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model){
		model.addAttribute("tarefa",dao.buscaPorId(id));
		return "tarefa/altera";
	}
	
	// METODO PARA ALTERAR UMA TAREFA
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa){
		dao.altera(tarefa);
		return "redirect:listaTarefas";
	}
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model){
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/finalizada";
	}
}
