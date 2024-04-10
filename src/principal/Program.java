package principal;

import controllers.ClienteController;

public class Program {

	public static void main(String[] args) {
		
		// Estou chamando o Controlador para através dele pedir para cadastrar clienteR
		ClienteController clienteController = new ClienteController();
		clienteController.cadastrarCliente();

	}

}
