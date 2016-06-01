package ao.co.always.tarefas.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ao.co.always.tarefas.modelo.Tarefa;

public class CarregarTarefa {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		Tarefa encontrada = manager.find(Tarefa.class, 1L);
		System.out.println(encontrada.getDescricao());
		manager.close();
		
	}

}
