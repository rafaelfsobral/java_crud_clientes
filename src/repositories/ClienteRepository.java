package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// Ela vai pedir ajuda para a Factory. Para gravar cliente, precisa estar conectado no banco de dados
	// � uma classe que estamos criando para programar o cadastro do cliente no banco de dados
	// Vamos criar um m�todo para receber e cadastrar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception{
		// esse m�todo � o m�todo que pode dar erro, gerar uma exce��o, por isso o uso do throws Exception
		
		// abrindo conex�o com o banco de dados
		// A Factory conecta no PostGre
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		// escrevendo um comando em linguagem SQL para inserir um cliente no banco de dados
		// vai fazer um insert na tabela cliente
		PreparedStatement statement = connection.prepareStatement("insert into cliente (nome, email, telefone, cpf) values (?,?,?,?)"); 
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.execute(); // executar o comando
		
		statement.close(); // fechar a conex�o, liberar a conex�o
		
		
	}
	
	
}
