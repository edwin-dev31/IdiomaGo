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

### 1️⃣ Pull the MySQL Docker Image

```bash
docker pull mysql:latest
```

2️⃣ Run the MySQL Container

```bash
docker run -d --name idiomago -e MYSQL_ROOT_PASSWORD=idiomago -e MYSQL_USER=edwin -e MYSQL_PASSWORD=edwin123 -e MYSQL_DATABASE=idiomagodb -p 3307:3306 mysql
```

3️⃣ Access the MySQL CLI
```bash
docker exec -it idiomago mysql -u root -p
```
ó
```bash
docker exec -it idiomago mysql -u edwin -p
```

▶️ Running the Project

```bash
mvn spring-boot:run
```
