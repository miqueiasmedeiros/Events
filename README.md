# 📘 Events API

API REST para gerenciamento de eventos, conferências e inscrições.  
Permite cadastro de conferências, sessões, usuários e inscrições em sessões.

---

# 📌 Sobre o projeto

O **Events API** é uma aplicação Spring Boot que fornece endpoints REST para gestão de eventos acadêmicos ou corporativos.

Funcionalidades principais:

- Cadastro de conferências
- Cadastro de sessões
- Cadastro de usuários
- Inscrição de usuários em sessões
- Consulta de inscrições

---

# 🚀 Tecnologias utilizadas

- Java 21+
- Spring Boot
- Spring Data JPA
- Maven
- Banco PostgreSQL
- Swagger / OpenAPI

---

# 🧱 Modelo de domínio

Entidades principais do sistema:

- Conference
- Session
- User
- Subscription

Relacionamentos:

- Uma Conference possui várias Sessions
- Um User pode se inscrever em várias Sessions
- Subscription representa a inscrição do usuário na sessão

---

# ▶️ Como executar o projeto

## 1. Clonar o repositório

```bash
git clone https://github.com/miqueiasmedeiros/Events.git
cd Events
```

## 2. Executar com Maven

Linux/Mac:
```bash
./mvnw spring-boot:run
```
## 3. Acessar a Documentação com Swagger

```bash
http://localhost:8080/swagger-ui.html
```

# 📡 Endpoints da API
## User
- Método POST
```bash
{
  "nome": "Javis",
  "email": "javis@email.com"
}
```
- Rotas
```bash
GET    /users
GET    /users/{id}
POST   /users
PUT    /users/{id}
DELETE /users/{id}
```
## Conference
- Método POST
```bash
{
  "nome": "Java Conference",
  "address": "Online"
}
```
- Rotas
```bash
GET    /conferences
GET    /conferences/{id}
POST   /conferences
PUT    /conferences/{id}
DELETE /conferences/{id}
```

## Session
- Método POST
```bash
{

  "title": "The Future of Java",
  "startDate": "2026-02-22",
  "startTime": "10:00:00",
  "conference": {
    "id": 1
  }
}
```
- Rotas
```bash
GET    /sessions
GET    /sessions/{id}
POST   /sessions
PUT    /sessions/{id}
DELETE /sessions/{id}
```