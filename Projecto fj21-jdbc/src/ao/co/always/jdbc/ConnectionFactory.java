package ao.co.always.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost/CursoJava";
		try{
		return DriverManager.getConnection(url, "root", "2016");
		}catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
	}