package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController { // Vamos montar as intera��es com o usu�rio do sistema

	// vai interagir mais com o usu�rio atrav�s do Scanner, do Console
	// O nosso controller quando chamar o m�todo cadastrarCliente, vai imprimir cadastro de clientes, vai pegar os dados que o usu�rio fornecer, 
	// quando preencher os dados, vai acessar o ClienteRepository e vai passar para o Repository o objeto e vai gravar ele
	public void cadastrarCliente() {
		System.out.println("\n*** CADASTRO DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in); // ler os dados que o usu�rio vai preencher e vamos guardar no objeto
		Cliente cliente = new Cliente();
		
		System.out.print("NOME DO CLIENTE ..........: ");
		cliente.setNome(scanner.nextLine());
		
		System.out.print("E-MAIL ...................: ");
		cliente.setEmail(scanner.nextLine());
		
		System.out.print("TELEFONE .................: ");
		cliente.setTelefone(scanner.nextLine());
		
		System.out.print("CPF ......................: ");
		cliente.setCpf(scanner.nextLine());
	
		ClienteRepository clienteRepository = new ClienteRepository(); // vamos acessar o reposit�rio
		
		try {
			clienteRepository.create(cliente);
			System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR CLIENTE!");
			e.printStackTrace(); // imprimir log de erro	
		}
	}
	
	public void atualizarCliente() { // adtualizar dados do cliente
	
		System.out.println("\n*** ATUALIZA��O DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in); // ler os dados que o usu�rio vai preencher e vamos guardar no objeto
		Cliente cliente = new Cliente();
		
		System.out.print("ID DO CLIENTE ............: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));

		System.out.print("NOME DO CLIENTE ..........: ");
		cliente.setNome(scanner.nextLine());
		
		System.out.print("E-MAIL ...................: ");
		cliente.setEmail(scanner.nextLine());
		
		System.out.print("TELEFONE .................: ");
		cliente.setTelefone(scanner.nextLine());
		
		System.out.print("CPF ......................: ");
		cliente.setCpf(scanner.nextLine());
	
		ClienteRepository clienteRepository = new ClienteRepository(); // vamos acessar o reposit�rio
		
		try {
			clienteRepository.update(cliente);
			System.out.println("\nCLIENTE ATUALIZADO COM SUCESSO!\n");
		}catch(Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR CLIENTE!\n");
			e.printStackTrace(); // imprimir log de erro
		}
		
	}
	
	public void excluirCliente() {

		System.out.println("\n*** EXCLUS�O DE CLIENTES ***\n");
		Scanner scanner = new Scanner(System.in); // ler os dados que o usu�rio vai preencher e vamos guardar no objeto
		Cliente cliente = new Cliente();
		
		System.out.print("ID DO CLIENTE ............: ");
		cliente.setIdCliente(Integer.parseInt(scanner.nextLine()));
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		try {
			clienteRepository.delete(cliente);
			System.out.println("\nCLIENTE EXCLU�DO COM SUCESSO!\n");
		}catch(Exception e) {
			System.out.println("\nFALHA AO EXCLUIR CLIENTE!\n");
			e.printStackTrace(); // imprimir log de erro
		}
		
	}
	
	public void consultarClientes() {
		
		System.out.println("\n*** CONSULTA DE CLIENTES ***\n");
		
		ClienteRepository clienteRepository = new ClienteRepository(); 
		
		try {
		
			List<Cliente> lista = clienteRepository.findAll(); // consulta os dados de clientes e joga na lista. Essa lista recebe todos os clientes do reposit�rio
			
			for(Cliente cliente : lista) { // foreach -> para cada cliente que ele l� da lista, ele imprime os dados
				// vou imprimir os dados dos clientes
				System.out.println("ID DO CLIENTE .........: " + cliente.getIdCliente());
				System.out.println("NOME ..................: " + cliente.getNome());
				System.out.println("E-MAIL ................: " + cliente.getEmail());
				System.out.println("TELEFONE ..............: " + cliente.getTelefone());
				System.out.println("CPF ...................: " + cliente.getCpf());
				System.out.println("...");
			}
			
		}catch(Exception e) {
			System.out.println("\nFALHA AO CONSULTAR CLIENTES!\n");
			e.printStackTrace();
		}
	}
}
