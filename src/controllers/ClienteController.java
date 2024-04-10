package controllers;

import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	// vai interagir mais com o usuário através do Scanner, do Console
	// O nosso controller quando chamar o método cadastrarCliente, vai imprimir cadastro de clientes, vai pegar os dados que o usuário fornecer, 
	// quando preencher os dados, vai acessar o ClienteRepository e vai passar para o Repository o objeto e vai gravar ele
	public void cadastrarCliente() {
		System.out.println("\n** CADASTRO DE CLIENTES **\n");
		Scanner scanner = new Scanner(System.in); // ler os dados que o usuário vai preencher e vamos guardar no objeto
		Cliente cliente = new Cliente();
		
		System.out.print("NOME DO CLIENTE ..........: ");
		cliente.setNome(scanner.nextLine());
		
		System.out.print("E-MAIL ...................: ");
		cliente.setEmail(scanner.nextLine());
		
		System.out.print("TELEFONE .................: ");
		cliente.setTelefone(scanner.nextLine());
		
		System.out.print("CPF ......................: ");
		cliente.setCpf(scanner.nextLine());
	
		ClienteRepository clienteRepository = new ClienteRepository(); // vamos acessar o repositório
		
		try {
			clienteRepository.create(cliente);
			System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");
		} catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR CLIENTE!");
			e.printStackTrace(); // imprimir log de erro	
		}
	}
	
}
