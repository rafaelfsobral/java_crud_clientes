package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// vamos criar um m�todo para abrir conex�o com um banco de dados do PostGreSQL
	public Connection getConnection() throws Exception{
		
		// par�metros de conex�o
		String driver = "org.postgresql.Driver";
		String host = "jdbc:postgresql://localhost:5433/bd_java_projeto03";
		String user = "postgres";
		String password = "admin";
		
		Class.forName(driver); // nome da biblioteca
		return DriverManager.getConnection(host,user,password); // endere�o do banco de dados, usu�rio, senha
	}
	
}
