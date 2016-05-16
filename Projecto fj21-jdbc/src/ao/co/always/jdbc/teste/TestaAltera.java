package ao.co.always.jdbc.teste;
import java.util.Calendar;
import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

public class TestaAltera {

	public static void main(String[] args) {
		
		// create the object Contacto
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

}
