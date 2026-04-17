# Nome do Projeto: Sistema de Autenticação e Cadastro
## Descrição
Projeto final desenvolvido para a disciplina de **Programação Orientada a Objetos (POO)**, integrando as atividades das Apostilas 7 e 8. A aplicação consiste em um sistema de gestão de usuários com controle de acesso e visualização de dados.

## Funcionalidades
* **Autenticação:** Tela de login (`FormLogin`) validando credenciais contra o banco de dados.
* **Cadastro (Create):** Inclusão de novos usuários com persistência via `UsuarioDAO`.
* **Listagem (Read):** Visualização de usuários cadastrados em uma tabela (`FormListagem`).
* **Edição e Exclusão (Update/Delete):** Gestão completa dos registros de usuários.
* **Arquitetura MVC:** Separação clara entre Modelo (`model`), Visão (`view`) e Controle/DAO (`dao`).

## Tecnologias Utilizadas
* Linguagem: **Java (Swing)**
* Banco de Dados: **MySQL**
* Padrão de Projeto: **DAO (Data Access Object)** e **MVC**

## Como executar o projeto
1. Clone o repositório:
`git clone https://github.com/Dirt2939/SwingMysqlProject.git`
2. Importe o banco de dados utilizando o script `database.sql` incluso na raiz do projeto.
3. Configure a conexão no arquivo:
   `src/br/ulbra/dao/ConnectionFactory.java` (ajuste a porta, usuário e senha se necessário).
4. Execute a classe principal:
   Inicie o projeto através da tela de login em `src/br/ulbra/view/FormLogin.java`.

## Autor
* **Nome:** [Rafael H. Pinnheiro]
* **Turma:** [3A INFO]
