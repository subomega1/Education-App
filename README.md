# United: Educational Application

Welcome to **United**, an educational application built with Java Maven, Swing, and MySQL. This application allows students and teachers to interact with courses in an efficient and secure manner.

## Features 🌟

### Student Features 👨‍🎓
- 📄 **View all available courses**
- 🛍️ **Purchase desired courses**
- 🔠 **View purchased courses**

### Teacher Features 👩‍🏫
- 🔄 **Add new courses**
- 📈 **View added courses**

### General Features 🛡️
- 🔐 **Secure login and signup with salted password hashing**
- 🔎 **User session management with a custom context**
- ⏹ **Logout functionality**
- 🚚 **Client-side and server-side request handling**

## Prerequisites 📊

Ensure the following software is installed:
- **Java 8+**
- **MySQL Server**
- **Maven**

## Database Setup 🔧

Create a new database in MySQL.
Run the following SQL commands to create the required tables:

```sql
CREATE TABLE user_table (
    email VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255),
    password TEXT,
    role VARCHAR(50)
);

CREATE TABLE teacher_course (
    title VARCHAR(255) PRIMARY KEY,
    description TEXT,
    teacher_id VARCHAR(255),
    FOREIGN KEY (teacher_id) REFERENCES user_table(email)
);

CREATE TABLE student_course (
    student_id VARCHAR(255),
    course_id VARCHAR(255),
    FOREIGN KEY (student_id) REFERENCES user_table(email),
    FOREIGN KEY (course_id) REFERENCES teacher_course(title)
);
```

## Installation and Setup 💻

1. **Clone this repository:**

   ```bash
   git clone <repository_url>
   cd united
   ```

2. **Configure database connection:**

   Open `src/main/java/org/formationApp/DB/ConnectToDB.java` and provide your MySQL username and password:

   ```properties
   db.username=your_username
   db.password=your_password
   db.url=jdbc:mysql://localhost:3306/your_database_name
   ```

   Open `src/main/java/org/formationApp/utils/HashFunction.java` and set the salt value for password hashing:

   ```properties
   salt=your_salt_value
   ```

3. **Build the project with Maven:**

   ```bash
   mvn clean install
   ```

   Maven is used to handle dependencies, build processes, and project management tasks efficiently.

4. **Run the application:**

   ```bash
   java -jar target/united-1.0.jar
   ```

## How It Works 🔄

- **Authentication:** Users log in or sign up securely with salted password hashing.
- **Session Management:** User session information is restored using a custom context.
- **Data Flow:** All requests from the user are handled on both the client side and the server side.

## Technologies Used 🛠️

- **Java Maven**: For dependency and build management.
- **Java Swing**: For creating the graphical user interface.
- **MySQL**: As the relational database.

## Contribution Guidelines ✍️

Feel free to fork this repository, create a new branch, and make your changes. Submit a pull request when you're ready to share your improvements.


---

Enjoy using **United**! 🌐
