JDBC Student Records Project

📌 Project Overview

This project demonstrates how to connect a Java application to an Oracle 10g database using JDBC. The main task is to fetch and display all student records from a students table in a tabular format. It is designed as a beginner-friendly exercise to understand JDBC basics, ResultSet iteration, and exception handling.

🛠 Prerequisites

Oracle 10g Database installed and running (Express Edition recommended).

IntelliJ IDEA or any Java IDE.

Oracle JDBC Driver (ojdbc.jar) added to the project dependencies.

Basic knowledge of Java and SQL.

📂 Project Structure

JDBC-Student-Records/ ├── src/ │ └── DisplayStudents.java ├── README.md └── ojdbc.jar (added as dependency)

🗄️ Database Setup

Run the following SQL commands in Oracle SQL*Plus, SQL Developer, or IntelliJ Database Console:

CREATE TABLE students ( id NUMBER PRIMARY KEY, name VARCHAR2(100) NOT NULL, age NUMBER NOT NULL );

INSERT INTO students (id, name, age) VALUES (1, 'Aarav', 20); INSERT INTO students (id, name, age) VALUES (2, 'Isha', 21); INSERT INTO students (id, name, age) VALUES (3, 'Rohan', 19);

COMMIT;

💻 Java Code Example

import java.sql.Connection; import java.sql.DriverManager; import java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement;

public class DisplayStudents { public static void main(String[] args) { String url = "jdbc:oracle:thin:@localhost:1521:XE"; String user = "system"; String password = "your_password";

    try {
        Class.forName("oracle.jdbc.OracleDriver");
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM students");

        System.out.printf("%-5s | %-20s | %-3s%n", "ID", "NAME", "AGE");
        System.out.println("-------------------------------------------");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.printf("%-5d | %-20s | %-3d%n", id, name, age);
        }

        rs.close();
        stmt.close();
        conn.close();
    } catch (ClassNotFoundException e) {
        System.out.println("Oracle JDBC driver not found.");
    } catch (SQLException e) {
        System.out.println("Database error: " + e.getMessage());
    }
}
}

▶️ How to Run

Add ojdbc.jar to your project dependencies in IntelliJ.

Build the project (Ctrl+F9).

Run the DisplayStudents class (Shift+F10).

Output will display student records in tabular format.

📊 Sample Output

ID | NAME | AGE
1 | Aarav | 20 2 | Isha | 21 3 | Rohan | 19

📚 Learning Outcomes

Establish JDBC connection with Oracle.

Execute SQL queries from Java.

Use ResultSet and while(rs.next()) to iterate over rows.

Print results in a formatted table.

Handle exceptions gracefully.

🚀 Next Steps

Extend project to support CRUD operations (INSERT, UPDATE, DELETE).

Use PreparedStatement for parameterized queries.

Explore connection pooling with DataSource for efficiency.
