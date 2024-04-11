package repositories;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	// Ela vai pedir ajuda para a Factory. Para gravar cliente, precisa estar conectado no banco de dados
	// É uma classe que estamos criando para programar o cadastro do cliente no banco de dados
	// Vamos criar um método para receber e cadastrar um cliente no banco de dados
	public void create(Cliente cliente) throws Exception{
		// esse método é o método que pode dar erro, gerar uma exceção, por isso o uso do throws Exception
		
		// abrindo conexão com o banco de dados
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
		
		connection.close(); // fechar a conexão, liberar a conexão
		
	}
	
	// método para receber e atualizar um cliente no banco de dados
	public void update(Cliente cliente) throws Exception{
		
		// abrindo conexão com banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory(); // conecta no PostGre
		Connection connection = connectionFactory.getConnection(); // retorna a conexão
		
		// escrever um comando em linguagem SQL para atualizar quaisquer dados de um cliente no banco de dados
		PreparedStatement statement = connection.prepareStatement("update cliente set nome=?, email=?, telefone=?, cpf=? where idcliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getTelefone());
		statement.setString(4, cliente.getCpf());
		statement.setInt(5, cliente.getIdCliente());
		statement.execute();
		
		// fechando a conexão
		connection.close();
	}
	
	// método para receber e excluir um cliente no banco de dados
	public void delete(Cliente cliente) throws Exception{
		
		// abrindo conexão com banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		// escrevendo um comando em linguagem SQL para excluir um cliente no banco de dados
		PreparedStatement statement = connection.prepareStatement("delete from cliente where idcliente=?");
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
		
		// fechando a conexão
		connection.close();
			
	}
	
	// método para consultar todos os clientes cadastrados no banco de dados
	public List<Cliente> findAll() throws Exception{
		
		// abrindo conexão com banco de dados
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getConnection();
		
		// escrevendo um comando em linguagem SQL para consultar todos os clientes
		PreparedStatement statement = connection.prepareStatement("select * from cliente");
		// ResultSet é uma classe para poder capturar todos os clientes que estamos lendo no banco de dados
		// executeQuery() -> Esse comando está executando a query, está capturando todos os registros do banco de dados e armazenando no resultset
		ResultSet resultset = statement.executeQuery();
		
		// declarando uma lista de clientes
		List<Cliente> lista = new ArrayList<Cliente>();
		
		// percorrer cada registro obtido do banco de dados e armazenar na lista. Estou lendo cliente por cliente, registro a registro.
		while(resultset.next()) {  // next() é um cursor, é como se fosse um ponteiro que está lendo cada cliente que trouxemos do banco de dados
			// enquanto tiver registros, leia
			
			// criando objeto cliente
			Cliente cliente = new Cliente();
			
			// capturar os campos do banco de dados
			cliente.setIdCliente(resultset.getInt("idcliente"));
			cliente.setNome(resultset.getString("nome"));
			cliente.setEmail(resultset.getString("email"));
			cliente.setTelefone(resultset.getString("telefone"));
			cliente.setCpf(resultset.getString("cpf"));
			
			// adicionar cada objeto cliente dentro da lista
			lista.add(cliente);
		}
		
		// fechando conexão
		connection.close();
		
		return lista; // retornando a listagem de clientes
	}
	
}
