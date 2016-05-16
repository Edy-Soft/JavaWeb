package ao.co.always.jdbc.teste;
import java.util.List;

import ao.co.always.jdbc.dao.ContactoDAO;
import ao.co.always.jdbc.modelo.Contacto;

public class TestaLista {

	public static void main(String[] args) {
		
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

}
