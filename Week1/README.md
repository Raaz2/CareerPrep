# 📚 Student Management Console App

A simple **Java console application** to manage student records using **Object-Oriented Programming** concepts like classes, objects, methods, and the `this` keyword. This project allows users to **add**, **search**, **update**, and **display** student data interactively through the console.

---

## 🚀 Features

### ✅ Core Features
- **Add Student**: Input name, roll number, course, and marks.
- **Search Student by Roll Number**: Retrieve and display student details.
- **Update Student Marks**: Modify marks of a specific student.
- **Display All Students**: Print details of all students in a colorful, formatted way.

### 🧠 Object-Oriented Concepts Demonstrated
- Use of `this` keyword in constructors and methods
- Class interactions: `Main` → `StudentManager` → `Student`
- Separation of concerns across `Main`, `Student`, and `StudentManager` classes

---

## 🛠 Tech Stack & Tools
- **Language**: Java (JDK 17+ recommended)
- **IDE**: IntelliJ IDEA / Eclipse / VS Code
- **Tools**: Java Collections (`ArrayList`), `Scanner` for user input
- **Console**: ANSI colors for better UX in supported terminals

---

## 📁 Project Structure

```

com/
└── masai/
├── Main.java             # Handles menu and user interaction
├── Student.java          # Represents student data and behaviors
└── StudentManager.java   # Handles student storage and business logic

````

---

## 🧪 How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Raaz2/CareerPrep.git-app.git
   cd Week1/StudentManagementConsoleApp/

2. **Compile the project**:

   ```bash
   javac com/masai/*.java
   ```

3. **Run the application**:

   ```bash
   java com.masai.Main
   ```

---

## 🖥 Sample Menu

```
1. Add Student
2. Search Student by roll number
3. Update student marks
4. Display all students
5. Exit
```

---

## 🌟 Code Highlights

* ✅ Use of `Optional` to avoid `null`
* ✅ ANSI colors in `displayDetails()` for clarity
* ✅ Validation to handle invalid inputs gracefully
* ✅ Clean modular design with separation of UI and logic

---

## 📌 Example Output (Colorized Terminal)

```
Student Details:
=============================================
Name     : Rajeev
Roll No. : 101
Course   : Java
Marks    : 85
=============================================
```

---

## 🙌 Author

* 💻 **Rajeev Ranjan Mishra**
* 📧 [rajeevranjanmishra4339@gmail.com](mailto:rajeevranjanmishra4339@gmail.com)
* 🌐 [LinkedIn](https://www.linkedin.com/in/rajeev-ranjan-mishra/)

---

## 📜 License

This project is open-source and free to use for educational purposes.

