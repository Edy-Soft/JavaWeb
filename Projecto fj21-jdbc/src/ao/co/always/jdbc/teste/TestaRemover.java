package ao.co.always.jdbc.teste;
import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

public class TestaRemover {

	public static void main(String[] args) {

		Contacto contacto = new Contacto();
		
		contacto.setId(8);
		
		// remove in this connection
		ContactoDAO DAO = new ContactoDAO();
		
		// Call the method to remove the contact
		DAO.remover(contacto);
		
		System.out.println("Contact removed successful");
	}

}
