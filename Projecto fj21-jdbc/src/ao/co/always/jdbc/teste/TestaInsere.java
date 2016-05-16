package ao.co.always.jdbc.teste;
import java.util.Calendar;
import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

public class TestaInsere {
	public static void main(String[] args) {
		
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

}
