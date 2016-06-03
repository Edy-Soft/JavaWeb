package ao.co.always.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;

public class ConnectionFactoryTest {
	
	@Test
	public void testeConexao() throws SQLException {
		
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao Aberta");
		connection.close();

	}

}
