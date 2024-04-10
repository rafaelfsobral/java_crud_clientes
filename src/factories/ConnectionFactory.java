package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// vamos criar um método para abrir conexão com um banco de dados do PostGreSQL
	public Connection getConnection() throws Exception{
		
		// parâmetros de conexão
		String driver = "org.postgresql.Driver";
		String host = "jdbc:postgresql://localhost:5433/bd_java_projeto03";
		String user = "postgres";
		String password = "admin";
		
		Class.forName(driver); // nome da biblioteca
		return DriverManager.getConnection(host,user,password); // endereço do banco de dados, usuário, senha
	}
	
}
