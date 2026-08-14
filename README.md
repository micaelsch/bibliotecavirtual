# Biblioteca Virtual

Sistema pessoal de gerenciamento de livros — uma "estante virtual" onde cada usuário cadastra, organiza e filtra seus próprios livros por categoria. Projeto de estudo com foco em backend Java/Spring Boot, construído do zero como forma de aprender a estrutura de uma aplicação web real antes de partir para um projeto maior.

## Funcionalidades

- Cadastro e autenticação de usuários, com senha armazenada como hash (BCrypt)
- Cadastro, listagem, edição e remoção de livros
- Cada livro pertence a um usuário — um usuário não consegue acessar ou apagar livros de outra pessoa
- Categorias de livros com relacionamento real no banco de dados
- Filtro de livros por categoria
- Frontend simples consumindo a API (login, estante de livros, cadastro de livro)

## Tecnologias

- **Backend:** Java, Spring Boot, Spring Web, Spring Data JPA, Spring Security
- **Banco de dados:** PostgreSQL
- **Frontend:** HTML, CSS e JavaScript puro (sem framework)
- **Build:** Maven
- **Testes de API:** Postman
- **Versionamento:** Git e GitHub
- **Comunicação:** API REST, dados trocados em formato JSON

## Estrutura do backend

model/ → entidades (Usuario, Livro, Categoria)
repository/ → acesso ao banco (Spring Data JPA)
service/ → regras de negócio
controller/ → endpoints REST
config/ → configuração de segurança (autenticação, CORS)

## Endpoints principais
Todos os endpoints recebem e retornam dados em JSON.

| Método | Rota | Descrição | Autenticação |
|---|---|---|---|
| POST | `/usuarios` | Cadastra um novo usuário | Não |
| POST | `/categorias` | Cria uma categoria | Sim |
| GET | `/categorias` | Lista categorias | Sim |
| GET | `/livros` | Lista os livros do usuário logado (aceita `?categoriaId=`) | Sim |
| POST | `/livros` | Cadastra um livro para o usuário logado | Sim |
| GET / DELETE | `/livros/{id}` | Busca ou remove um livro (só se for do dono) | Sim |

## Como rodar localmente

01. Clone o repositório.
02. Crie um banco PostgreSQL chamado `bibliotecavirtual`.
03. Configure `src/main/resources/application.properties` com suas credenciais do PostgreSQL.
04. Rode o backend:./mvnw spring-boot:run
05. Como ainda não existe uma tela de cadastro no frontend, crie o primeiro usuário direto pela API (Postman ou similar): POST http://localhost:8080/usuarios
Body: { "nome": "Seu Nome", "email": "seu@email.com", "senha": "sua-senha" }
06. Abra `frontend/login.html` com o Live Server do VS Code (necessário por causa de CORS) e faça login com o usuário criado.

## Sobre o desenvolvimento

O backend foi desenvolvido do zero, entendendo cada camada da aplicação — desde a modelagem das entidades até a configuração de autenticação e autorização com Spring Security. Foi neste projeto que aprendi, na prática, conceitos como injeção de dependência, relacionamento entre entidades, hash de senha, e debug de problemas reais (CSRF, CORS, autorização por dono do recurso).

O frontend foi construído com apoio de IA, já que o foco de aprendizado deste projeto é backend — a prioridade foi ter uma interface funcional para testar a API de ponta a ponta, não aprofundar em frontend.

