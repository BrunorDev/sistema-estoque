# 📦 Sistema de Controle de Estoque

Este projeto é uma API REST para gerenciar produtos e controlar o estoque de uma aplicação. Desenvolvido com **Java** e **Spring Boot**, utiliza **Spring Data JPA** para persistência de dados e **MySQL** como banco de dados relacional.

---

## 🚀 Tecnologias Utilizadas

- **Java 22+**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Springdoc OpenAPI (Swagger)**
- **ModelMapper** (para conversão de entidades para DTOs)
- **Loombock**
- **JUnit 5**
- **Mockito**

---
## 📁 Estrutura do Projeto
O projeto segue o padrão de camadas:

- **Config: Configuração do ModelMapper e Swagger**
- **Controller: Recebe e processa as requisições HTTP.**
- **dto: Objetos de transferência de dados (Data Transfer Objects)**
- **Entity: Entidades JPA representando as tabelas do banco**
- **Service: Contém a Regra de negócio da aplicação.**
- **Repository: Interface para comunicação com o banco de dados.**
- **Mapper: Conversão entre entidades e DTOs (ModelMapper, por exemplo)**
- **Exceptions: Tratamento de exceções personalizadas**
---
## 🔧 Configuração do Projeto

Clone o repositório:

```bash
git clone <URL do repositório>
```

Acesse a pasta do projeto:

```bash
cd Produtos-API
```

Configure as dependências com o Maven:

```bash
mvn clean install
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

---

## 📄 Documentação da API

Após iniciar o projeto, a documentação da API estará disponível em:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🛠️ Endpoints Principais

| Método | Endpoint                        | Descrição                          |
|--------|----------------------------------|--------------------------------------|
| GET    | `/produtos/findAll`              | Lista todos os produtos             |
| GET    | `/produtos/findById/{id}`        | Busca um produto por ID             |
| POST   | `/produtos`                      | Cadastra um novo produto            |
| PUT    | `/produtos/{id}`                 | Atualiza um produto existente       |
| POST   | `/produtos/{id}/increase-stock`  | Reposição de estoque                |
| POST   | `/produtos/{id}/decrease-stock`  | Baixa de estoque                    |

---

