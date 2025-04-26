# 🌐 IdiomaGo

**IdiomaGo** is a web application built with **Spring Boot** and **Java**, designed to facilitate languageEntity learning in an interactive and dynamic way.  
It allows easy management of words, translations, and multiple languages—perfect for building strong vocabulary and comprehension skills.

---

## 🚀 Technologies Used

- Java 17
- Spring Boot
- Maven
- JPA / Hibernate
- MySQL (Docker)
- RESTful API

---

## 🐬 Setting Up the MySQL Database with Docker

Follow these steps to set up the MySQL database for **IdiomaGo** using Docker:

### 1️⃣ Create containers and Image
crear el `.jar`

```bash
./mvnw clean package
```


```bash
docker-compose up -d
```

2️⃣ Access the MySQL CLI
```bash
docker exec -it idiomago mysql -u root -p
```
ó
```bash
docker exec -it idioma_go_db mysql -u edwin -p
```

▶️ You can run the proyect excecute the `idioma_go_app` using the port `localhost:1731`
