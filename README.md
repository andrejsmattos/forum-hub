# Fórum Hub API  

![Java](https://img.shields.io/badge/Java-21-blue?style=flat&logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-green?style=flat&logo=spring)  
![MySQL](https://img.shields.io/badge/MySQL-8.0.40-orange?style=flat&logo=mysql)  
![JWT](https://img.shields.io/badge/JWT-Security-red?style=flat&logo=jsonwebtokens)  
![Flyway](https://img.shields.io/badge/Flyway-DB%20Migrations-yellow?style=flat&logo=flywaydb)  
![Maven](https://img.shields.io/badge/Maven-Dependency%20Management-red?style=flat&logo=apache-maven) 

---

## 📑 Índice  

1. [🧵 Sobre o Projeto](#-sobre-o-projeto)  
2. [🚦 Status do Projeto](#-status-do-projeto)  
3. [✨ Funcionalidades e Demonstração da Aplicação](#-funcionalidades-e-demonstração-da-aplicação)  
4. [🚀 Tecnologias Utilizadas](#-tecnologias-utilizadas)  
5. [⚙️ Configuração](#-configuração)
5. [📂 Acesso ao Projeto](#-acesso-ao-projeto)  
6. [🔒 Autenticação](#-autenticação)  
7. [📌 Endpoints](#-endpoints)  
8. [🔍 Documentação API](#-documentação-api)  


---

## 🧵 Sobre o Projeto  

Fórum Hub é uma plataforma de apoio entre alunos e professores, onde estudantes podem criar tópicos para discutir dúvidas sobre cursos de programação. O projeto foca na criação de uma API RESTful segura e robusta para gerenciar fóruns.  

---

## 🚦 Status do Projeto  

🚧 Projeto em desenvolvimento  

**Próximos passos:**  
Implementação de: 
* *Testes automatizados*  
* *Perfis de acesso*
* *Novas funcionalidades de interação entre usuários*
* *Gerenciamento de usuários, cursos e perfis*
* *Listagem de tópicos por critérios como data ou curso*

---

## ✨ Funcionalidades e Demonstração da Aplicação  

* *CRUD completo de tópicos*
* *Autenticação segura com JWT*  
* *Rotas protegidas por autenticação*
* *Migrations com Flyway*

Acesse a documentação da API para explorar todas as funcionalidades:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  

---

## 🚀 Tecnologias Utilizadas  

- **Java 21**  
- **Spring Boot 3.3.5**  
- **MySQL 8.0.40**  
- **Flyway** para gerenciamento de migrações de banco de dados  
- **JWT (Java Web Token)** para autenticação e segurança  
- **Maven** como gerenciador de dependências  
- **Springdoc OpenAPI** para documentação interativa  

---
## ⚙️ Configuração

### Variáveis de Ambiente

O projeto requer as seguintes variáveis de ambiente:

```properties
DB_HOST=seu_host_mysql
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```

### Banco de Dados

O projeto utiliza as seguintes tabelas:

* `cursos` - Armazena informações dos cursos
* `perfis` - Perfis de acesso do sistema
* `respostas` - Respostas aos tópicos
* `topicos` - Tópicos de discussão
* `usuario_perfil` - Relacionamento entre usuários e perfis
* `usuarios` - Dados dos usuários

---

## 📂 Acesso ao Projeto  

### Pré-requisitos  

- **Java JDK 21**  
- **MySQL 8.0.40**  
- **Maven**  
- IDE de sua preferência (IntelliJ IDEA, Eclipse, etc.)  

### Passos  

1. Clone o repositório:  
   ```bash
   git clone https://github.com/andrejsmattos/forum-hub
   cd forum-hub
   ```
   
2. Configure o banco de dados no arquivo application.properties:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   spring.jpa.hibernate.ddl-auto=update
   api.security.token.secret=sua-senha-jwt
   ```

3. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   
4. Acesse a documentação da API em:
   [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---
## 🔒 Autenticação
O projeto utiliza Spring Security com JWT para autenticação.

### Como acessar endpoints protegidos:
1. Faça login para receber o token JWT:
   * `POST /login` - Realizar login e obter token JWT
2. Inclua o token no header das requisições:
   * `Authorization: Bearer <seu_token_aqui>`

---
## 📌 Endpoints

### Tópicos

* `POST /topicos` - Criar novo tópico
* `GET /topicos` - Listar tópicos
* `PUT /topicos/{id}` - Atualizar tópico
* `GET /topicos/{id}` - Detalhar tópico
* `DELETE /topicos/{id}` - Excluir tópico
* `POST /login` - Realizar login e obter token JWT

---

## 🔍 Documentação API

A documentação completa da API está disponível via Swagger/OpenAPI:

   ```bash
    http://localhost:8080/swagger-ui.html
   ```
 
