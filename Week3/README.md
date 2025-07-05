# 📚 Library Book Borrowing System

A **Java console-based mini project** simulating a library system where users can borrow and return books concurrently. The project uses **multithreading**, **JDBC**, and **Maven**, and is connected to a MySQL database.

---

## 🚀 Features (Core Only)

- ✅ **Add Book / Add User**
- ✅ **Borrow Book** (inserts borrow record, decrements stock)
- ✅ **Return Book** (sets return date, increases stock)
- ✅ **View books borrowed by a specific user**
- ✅ **Simulate multiple users borrowing books concurrently** using threads
- ✅ **Clean modular code** using interfaces and DAO pattern
- ✅ **MySQL + JDBC Integration**
- ✅ **Built using Maven**

---

## 🛠️ Tech Stack

| Layer         | Technology       |
|---------------|------------------|
| Language      | Java 8+          |
| Database      | MySQL            |
| Persistence   | JDBC             |
| Build Tool    | Maven            |
| Concurrency   | Multithreading   |

---

## 📁 Project Structure

```

src/
├── com.library
│   ├── Main.java
│   ├── dao/
│   │   ├── LibraryDao.java
│   │   ├── LibraryDaoImpl.java
│   │   ├── BorrowBooks.java
│   ├── model/
│   │   ├── Book.java
│   │   ├── User.java
│   ├── util/
│   │   └── DBUtil.java

````

---

## 🧰 Prerequisites

- Java 8+
- MySQL server running locally
- Maven installed
- MySQL Database named `library`

---

## 🧪 Database Schema

```sql
CREATE DATABASE library;

USE library;

CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    available_copies INT
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE borrowed_books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    book_id INT,
    borrow_date DATE,
    return_date DATE DEFAULT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
````

---

## 🏗️ Build & Run

### 🔨 Build with Maven

```bash
mvn clean install
```

### ▶️ Run the Application

```bash
java -cp target/your-jar-name.jar com.library.Main
```

> Or run it from your IDE (e.g., IntelliJ, Eclipse)

---

## 🖥️ Console Menu

```
===== Library Menu =====
1. Add Book
2. Add User
3. Borrow Book
4. Return Book
5. List Books Borrowed by User
6. Simulate Multithreaded Borrowing
0. Exit
```

---

## 🧵 Multithreaded Simulation

Option `6` in the menu will simulate **3 users trying to borrow the same book** concurrently using threads (via `BorrowBooks` class).

---

## 📌 Notes

* No admin login/authentication implemented (stretch goal skipped).
* No logging framework used (stretch goal skipped).
* Only core functionality is implemented as per assignment guidelines.

---

## 📇 Author

* 👨‍💻 Rajeev Ranjan Mishra
* 📧 rajeevranjanmishra4339@gmail.com

---

## 📜 License

This project is for educational purposes only.
