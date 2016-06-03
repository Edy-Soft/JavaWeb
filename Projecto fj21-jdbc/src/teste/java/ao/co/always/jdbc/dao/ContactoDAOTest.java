package ao.co.always.jdbc.dao;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import ao.co.always.jdbc.modelo.Contacto;

public class ContactoDAOTest {

	@Test
	public void altera() {
		
		//create the object Contacto
			Contacto contacto = new Contacto();
				
			contacto.setId(8);
			contacto.setNome("Helder da Costa");
			contacto.setEmail("sidinho@yahoo.com");
			contacto.setEndereco("Eka");
			contacto.setDataNascimento(Calendar.getInstance());
				
			// alter in this connection
			ContactoDAO DAO = new ContactoDAO();
				
			// Call the method to alter the contact
			DAO.altera(contacto);
				
			System.out.println("Contact altered successful");
	}
	
	@Test
	public void iinsere(){
		
		// create the object Contacto
		Contacto contacto = new Contacto();
		
		contacto.setNome("Jesus de Sousa");
		contacto.setEmail("jesus@gmail.com");
		contacto.setEndereco("Alto Dondo");
		contacto.setDataNascimento(Calendar.getInstance());
		
		// record in this connection
		ContactoDAO DAO = new ContactoDAO();
		
		// Call the method to record the contacts
		DAO.adiciona(contacto);
		
		System.out.println("Contact inserted successful");
	}
	
	@Test
	public void lista() {
		
		ContactoDAO DAO = new ContactoDAO();
		List<Contacto> listaContactos = DAO.getLista();
		
		for (Contacto contacto:listaContactos){
			System.out.println("Nome: " + contacto.getNome());
			System.out.println("Email: " + contacto.getEmail());
			System.out.println("Endereco: " + contacto.getEndereco());
			System.out.println("Data de Nascimento: " + 
							contacto.getDataNascimento().getTime() + "\n");
		}
	}
	
	@Test
	public void remove() {

		Contacto contacto = new Contacto();
		
		contacto.setId(8);
		// remove in this connection
		ContactoDAO DAO = new ContactoDAO();
		// Call the method to remove the contact
		DAO.remover(contacto);
		
		System.out.println("Contact removed successful");
	}
}
