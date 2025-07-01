# User Management API

Este projeto é uma API RESTful simples para gerenciamento de usuários, onde você pode realizar operações CRUD (Criar, Ler, Atualizar, Deletar) utilizando Spring Boot com Kotlin. A API utiliza o PostgreSQL como banco de dados para armazenar os dados dos usuários.

## Tecnologias Utilizadas

- Kotlin
- Spring Boot
- Spring Data JPA
- PostgreSQL
- RESTful API

## Funcionalidades

- **Criar um usuário** (POST /user)
- **Obter todos os usuários** (GET /user)
- **Obter um usuário por ID** (GET /user/{id})
- **Atualizar um usuário** (PUT /user/{id}) - Atualização total
- **Atualizar um usuário parcialmente** (PATCH /user/{id}) - Atualização parcial
- **Deletar um usuário** (DELETE /user/{id})

## Estrutura de Diretórios

- **`com.gustavo.farias.model`**: Contém a definição da entidade `User`.
- **`com.gustavo.farias.repository`**: Contém o repositório que se comunica com o banco de dados.
- **`com.gustavo.farias.service`**: Contém a lógica de negócios para manipulação de usuários.
- **`com.gustavo.farias.resource`**: Contém os endpoints REST que expõem a API para o cliente.

## Endpoints

### 1. Criar um Usuário

**Método:** `POST`

**URL:** `http://localhost:8085/user`

**Corpo da requisição:**
```json
{
  "name": "Nome do Usuário"
}
