# Arithmetic Practice Application

This Java application is designed for practicing and managing basic arithmetic problems (addition, subtraction, multiplication, division) with database support via JPA (Jakarta Persistence API). The app provides functionality to add, update, delete, practice, and test arithmetic questions.

## Features

1. **Menu Options:**
   - Add new arithmetic problems.
   - View the number of problems in the database.
   - Update or delete existing problems.
   - Practice arithmetic problems interactively.
   - Take a test with randomized problems.

2. **Supported Operations:**
   - Addition
   - Subtraction
   - Multiplication
   - Division

3. **Database Integration:**
   - Uses JPA for persisting problems and answers.
   - Each operation has its own entity (`AdditionEntity`, `SubtractionEntity`, etc.).

4. **Test and Practice Modes:**
   - Practice: Users can repeatedly attempt problems until they decide to exit.
   - Test: A timed session with a fixed number of random questions to evaluate performance.

## Requirements

- **Java 17** or higher.
- **Jakarta Persistence API (JPA)** for database interaction.
- A database configured with JPA (e.g., MySQL, PostgreSQL, or H2).
- `persistence.xml` configured with appropriate database connection details.

## How to Run

1. Clone the repository and navigate to the project directory.
2. Ensure the database is running and the `persistence.xml` file is correctly configured.
3. Compile and run the application:
   ```bash
   javac Main.java
   java Main
