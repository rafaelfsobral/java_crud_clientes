# Projeto Java JDBC - CRUD Clientes

## Descrição
Este é um projeto Java local que visa demonstrar a realização de conexão com banco de dados PostGreSQL e as operações de CRUD (cadastro, consulta, edição e exclusão) para uma tabela de clientes.

## Pré-requisitos
Antes de executar este projeto, é necessário ter os seguintes softwares instalados em seu sistema:

- Java Development Kit (JDK) 11
- Eclipse IDE

## Executando o Projeto
Siga estas etapas para executar o projeto:
1. Clone este repositório em sua máquina local.
2. Abra o projeto no Eclipse
3. Adicione a biblioteca .JAR contendo o driver do PostGreSQL
4. Crie um banco de dados no PostGreSQL com o nome 'bd_java_projeto03' e execute o script abaixo:

```sql
CREATE TABLE cliente (
    idcliente SERIAL PRIMARY KEY,
    nome VARCHAR(150),
    email VARCHAR(100),
    telefone VARCHAR(15),
    cpf VARCHAR(11)
);

