package ao.co.always.jdbc.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import ao.co.always.jdbc.ConnectionFactory;
import ao.co.always.jdbc.modelo.Contacto;

public class ContactoDAO {
	private Connection connection;
	
	public ContactoDAO(Connection connection){
		this.connection = connection;
	}
	
	// CREATE THE CONSTRUCTOR OF CONTACTODAO
	public ContactoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	// CREATE THE METHOD ADICIONA
	public void adiciona(Contacto contacto){
		String sql = "insert into contactos "
				+ "(nome, email, endereco, dataNascimento) "
				+ "values (?,?,?,?)";
		
	// Create the prepared statement for insert
	try {
		PreparedStatement stmt = connection.prepareStatement(sql);
	
	// Set the values
	stmt.setString(1, contacto.getNome());
	stmt.setString(2, contacto.getEmail());
	stmt.setString(3, contacto.getEndereco());
	stmt.setDate(4, new Date(
			contacto.getDataNascimento().getTimeInMillis()));
	
	// Execute
	stmt.execute();
	stmt.close();
	
	} catch (SQLException e){
		throw new RuntimeException(e);
		}
	}
	
	// CREATE METHOD getLista TO SHOW THE CONTACTS RECORDED IN BD
	public List<Contacto> getLista(){
		
		
		try{
			List<Contacto> listaContactos = new ArrayList<Contacto>();
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from contactos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				
				// Creating the contacto object
				Contacto contacto = new Contacto();
				contacto.setId(rs.getLong("id"));
				contacto.setNome(rs.getString("nome"));
				contacto.setEmail(rs.getString("email"));
				contacto.setEndereco(rs.getString("endereco"));
				
				// Show the date with Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contacto.setDataNascimento(data);
				
				// Add the object in List
				listaContactos.add(contacto);
			}
			rs.close();
			stmt.close();
			return listaContactos;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	// CREATE METHOD altera TO ALTER THE REGISTER RECORDED IN BD~
	public void altera (Contacto contacto){
		
		String sql = "update contactos set nome=?, email=?, " +
					"endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contacto.getNome());
			stmt.setString(2, contacto.getEmail());
			stmt.setString(3, contacto.getEndereco());
			stmt.setDate(4, new Date(contacto.getDataNascimento()
					.getTimeInMillis()));
			stmt.setLong(5, contacto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	// CREATE METHOD remover TO REMOVE THE CONTACTS
	public void remover (Contacto contacto){
		
		String sql = "delete from contactos where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contacto.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
