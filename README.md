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

- Java 25
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT
- JUnit 5
- Mockito
- JaCoCo

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
└── java/com/Assignment/Day/_7/service
├── AuthServiceTest.java
└── ProductServiceImplTest.java
```

---

## ✅ Unit Testing

Unit test difokuskan pada layer **service**:

### AuthServiceTest
- Register success
- Login success
- Login gagal (password salah)

### ProductServiceImplTest
- Create product
- Get all products
- Sell product (stock cukup)
- Sell product (stock tidak cukup)
- Delete product

Mocking dependency menggunakan Mockito.

---

## 📊 Code Coverage (JaCoCo)

JaCoCo digunakan untuk mengukur coverage hasil unit test.

Coverage service layer mencapai ±92%.

Generate report:

```bash
mvn clean test
target/site/jacoco/index.html
```
---
## ▶️ Cara Menjalankan Project
1. Pastikan MySQL aktif
2. Buat Database:
   CREATE DATABASE assignment_day_27;
  
3. Atur application.properties:
     spring.datasource.url=jdbc:mysql://localhost:3306/assignment_day_27
    spring.datasource.username=root
    spring.datasource.password=your_password

4. Jalankan aplikasi
   mvn spring-boot:run

---
## 🧪 Menjalankan Unit Test
mvn test
---
## 🙌 Author

Muhammad Arsyad Giri
Back End Web Development Bootcamp



