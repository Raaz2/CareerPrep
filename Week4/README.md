# 🎓 Student Course Management System

A Spring Boot web application that allows you to manage students and the courses they are enrolled in. The project demonstrates clean layered architecture, Spring Core concepts (IOC, DI), and JPA (with JPQL queries) for persistence.

---

## 📌 Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [JPQL Queries](#jpql-queries)
- [Stretch Features](#stretch-features)
- [Project Structure](#project-structure)
- [Screenshots](#screenshots-optional)
- [License](#license)

---

## ✅ Features

- Add new **students** and **courses**
- Enroll students in multiple courses (Many-to-Many)
- View all students and courses
- Find students enrolled in a particular course using JPQL
- Delete students or courses
- Clean 3-layer architecture: Controller → Service → Repository

---

## 🧱 Architecture

```

┌────────────┐
│ Controller │  -> Handles REST API requests
└────┬───────┘
↓
┌────────────┐
│  Service   │  -> Business logic layer (e.g., enroll, delete)
└────┬───────┘
↓
┌────────────┐
│ Repository │  -> JPA interfaces and JPQL queries
└────────────┘

````

---

## 💻 Tech Stack

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Swagger (API testing)
- Lombok (Optional)

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/raaz2/student-course-management-system.git
cd student-course-management-system
````

### 2. Build & Run the Project

```bash
mvn clean install
mvn spring-boot:run
```

### 3. Access API

```http
http://localhost:8088/api/
```

You can test with **Postman** or browser extensions like **REST Client**.

---

## 📡 API Endpoints

### 🧑 Student

| Method | Endpoint                    | Description            |
| ------ | --------------------------- | ---------------------- |
| POST   | `/api/students`             | Add a new student      |
| GET    | `/api/students`             | Get all students       |
| DELETE | `/api/students/{studentId}` | Delete a student by ID |

### 📘 Course

| Method | Endpoint                  | Description           |
| ------ | ------------------------- | --------------------- |
| POST   | `/api/courses`            | Add a new course      |
| GET    | `/api/courses`            | Get all courses       |
| DELETE | `/api/courses/{courseId}` | Delete a course by ID |

### 🔗 Enrollment

| Method | Endpoint                                       | Description                  |
| ------ | ---------------------------------------------- | ---------------------------- |
| PUT    | `/api/students/{studentId}/courses/{courseId}` | Enroll a student in a course |

### 🔍 JPQL Queries

| Method | Endpoint                           | Description                         |
| ------ | ---------------------------------- | ----------------------------------- |
| GET    | `/api/students/enrolled-in/{name}` | List students by course name (JPQL) |

---

## 📊 JPQL Queries in Repository

### Find students by course name:

```java
@Query("SELECT s FROM Student s JOIN s.courses c WHERE c.name = :courseName")
List<Student> findStudentsByCourseName(@Param("courseName") String courseName);
```

### (Optional) List courses with more than X students:

```java
@Query("SELECT c FROM Course c WHERE SIZE(c.students) > :minCount")
List<Course> findCoursesWithMinStudents(@Param("minCount") int minCount);
```

## 📂 Project Structure

```
src/
├── main/
│   ├── java/com/cms/
│   │   ├── controller/          -> REST API controllers
│   │   ├── model/               -> JPA entities (Student, Course)
│   │   ├── repository/          -> JPA Repositories
│   │   ├── service/             -> Business logic
│   │   └── StudentCourseManagementSystemApplication.java
│   └── resources/
│       ├── application.properties
│       └── data.sql (optional for seed data)
```

## 🧾 License

This project is for educational use. Feel free to modify and use for learning or portfolio purposes.

---

## 🙋‍♂️ Author

Developed by **Rajeev**
📧 [rajeevranjanmishra4339@gmail.com](mailto:your.email@example.com)
