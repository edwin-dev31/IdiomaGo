# 🌐 IdiomaGo - Backend

**IdiomaGo** is the backend for a language learning platform built using **Spring Boot** and **Java**.  
It provides secure user authentication (with OAuth), word translation management, AI-powered vocabulary generation, and multi-language support.

This backend exposes a RESTful API consumed by the [IdiomaGo frontend](https://delightful-field-0bf6cfa0f.2.azurestaticapps.net), and relies on a robust PostgreSQL database for persistence.

---

## 🧱 Architecture Overview

- **Spring Boot**: Core framework for building RESTful services
- **Spring Security**: Handles authentication, registration, and OAuth2 with Google, GitHub, and Facebook
- **PostgreSQL**: Primary relational database
- **JPA/Hibernate**: ORM for managing entities and relationships
- **Docker + Docker Compose**: To containerize database and facilitate local setup
- **Email Service**: Sends verification emails on registration
- **OpenAI integration**: Powers intelligent word suggestions (limited to 4 languages per request)

---

## ⚙️ Technologies Used

| Tech             | Purpose                                 |
|------------------|------------------------------------------|
| Java 17          | Core language                            |
| Spring Boot      | Framework for REST API                   |
| Spring Security  | Authentication + OAuth                   |
| PostgreSQL       | Database                    |
| JPA / Hibernate  | ORM for persistence                      |
| Maven            | Project build and dependency management  |
| Docker           | Containerization                         |
| OpenAI API       | Vocabulary generation support            |

---

## 🐳 Setting Up the PostgreSQL Database with Docker

Ensure you have Docker installed, then follow these steps:

### 1️⃣ Build the JAR

```bash
./mvnw clean package
```

### 2️⃣ Start the Database Container
```bash
docker-compose up -d
```
This will start a container named idioma_go_db with a PostgreSQL instance using the configured port (typically 5432).

### 3️⃣ Access the PostgreSQL CLI (Optional)
```bash
docker exec -it idioma_go_db psql -U edwin -d idiomago_db
```

## ▶️ Running the Backend

Once the JAR is built, you can run the application:
```bash
java -jar target/idiomago-0.0.1-SNAPSHOT.jar
```

By default, it runs on:

```bash
http://localhost:1731/idiomago
```

You can configure this in `.env` file or `application.properties`