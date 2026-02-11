# Assignment Extra Class Day 11 – Spring Boot + Unit Test + JaCoCo

Mini project backend menggunakan Spring Boot dengan fitur Authentication, Product Service, Unit Testing (Mockito + JUnit), dan Code Coverage menggunakan JaCoCo.

Project ini dibuat sebagai bagian dari assignment Back End Web Development Bootcamp.

---

## ✨ Fitur Utama

- Authentication (Register & Login)
- JWT Token
- Product CRUD + Sell Product
- Password hashing (BCrypt)
- Unit Testing menggunakan JUnit + Mockito
- Code Coverage menggunakan JaCoCo

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT
- JUnit 5
- Mockito
- JaCoCo

---

## ⚙️ Requirements

- Java 21
- Maven
- MySQL

---

## 🏗 Architecture

Project menggunakan layered architecture:

Controller → Service → Repository → Database

- Controller: handle HTTP request & response  
- Service: business logic  
- Repository: komunikasi dengan database  

---

## 📌 API Endpoints

### 🔐 Authentication
POST /auth/register  
POST /auth/login  
POST /auth/logout  

Example Register:

```json
{
  "username": "arsyad",
  "password": "123456"
}
```
---
## 📦 Product

GET /products
POST /products
DELETE /products/{id}
POST /products/{id}/sell

Example Create Product:
```json
{
  "name": "Laptop",
  "price": 10000000,
  "stock": 10
}
```
---

## 🔒 Security

- Authentication menggunakan JWT
- Password di-hash menggunakan BCrypt
- Endpoint tertentu diproteksi menggunakan Spring Security

---
## 📁 Struktur Project

```
src
├── main
│ └── java/com/Assignment/Day/_7
│ ├── controller
│ ├── dto
│ ├── entity
│ ├── repository
│ ├── security
│ └── service
│
└── test
└── java/com/Assignment/Day/_7
   ├── service
   │   ├── AuthServiceTest.java
   │   └── ProductServiceImplTest.java
   └── controller
       └── ProductControllerTest.java
```
---

## ✅ Unit Testing
Unit test difokuskan pada layer service dan controller:

# AuthServiceTest

- Register success
- Login success
- Login gagal (password salah)

# ProductServiceImplTest

- Create product
- Get all products
- Sell product (stock cukup)
- Sell product (stock tidak cukup)
- Delete product
  
# ProductControllerTest
- Create product
- Get all products
Mocking dependency menggunakan Mockito.

--- 
## 📊 Code Coverage (JaCoCo)
JaCoCo digunakan untuk mengukur coverage hasil unit test.
Coverage service layer mencapai ±92%.
Generate report:
```
mvn clean test
target/site/jacoco/index.html
```
---
## ▶️ Cara Menjalankan Project
1. Pastikan MySQL aktif
2. Buat database:
```
CREATE DATABASE assignment_day_27;
```
3. Atur application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/assignment_day_27
spring.datasource.username=root
spring.datasource.password=your_password
```
4. Jalankan aplikasi:
```
mvn spring-boot:run
```
---
## 🧪 Menjalankan Unit Test
```
mvn test
```
---
## 🙌 Author

Muhammad Arsyad Giri
Back End Web Development Bootcamp

