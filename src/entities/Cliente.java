package entities;

public class Cliente {

	// Importante fazer o encapsulamento sempre dos atributos da classe.
	// Se os atributos são privados, é pq não queremos que eles possam ser acessados por outras classes.
	// O private faz com que a classe possa proteger seus atributos do acesso externo. Fazemos isso encapsulando esses atributos.
	// Para cada um deles, vamos criar métodos de entrada e de saída, que chamamos de setters e getters.
	// Sempre que criar classes em Java com esse tipo de anatomia, classes voltadas para parte de modelagem de dados, vamos fazer as classes 
	// trabalhando com os conceitos de set e get, entrada e saída.
	
	private Integer idCliente;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	// Encapsulando os atributos
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
