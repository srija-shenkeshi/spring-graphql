# Student Microservice using GraphQL

## Overview
This project is a **Spring Boot** application that provides a GraphQL API for managing student records. It supports creating, retrieving, updating, and deleting student information with robust exception handling and logging using **Spring AOP**.

## Features
- **GraphQL Endpoints**:
    - **Create a Student**: Add a new student to the database.
    - **Get Student by Roll Number**: Retrieve a student's details by their roll number.
    - **Get All Students**: Fetch details of all students.
    - **Edit a Student by ID**: Update an existing student's information using their ID.
    - **Delete a Student by ID**: Remove a student from the database using their ID.
- **Exception Handling**: Custom exceptions are handled to ensure smooth API operations.
- **Logging with Spring AOP**: Logs method entry and exit points, including method name, signature, and arguments, to help with debugging and monitoring.

## Technologies Used
- **Java**
- **Spring Boot**
- **GraphQL**
- **MongoDB**
- **Gradle**
- **Spring AOP**
- **Spring Boot Starter**

## Setup Instructions
1. **Clone the repository**:
    ```bash
    git clone https://github.com/srija-shenkeshi/spring-graphql.git
    cd project-directory
    ```

2. **Configure MongoDB**:
   Run below command to start local dependencies like MongoDB. Update the `application.properties` file with the correct MongoDB connection details.
    ```bash
    docker compose up
    ```
    mongo-express will be available at <http://localhost:8081> <br />


3. **Build the project**:
    ```bash
    ./gradlew build
    ```

4. **Run the application**:
    ```bash
    ./gradlew bootRun
    ```

5. **Access the GraphQL Playground**:
   Navigate to `http://localhost:8080/graphql` in postman to interact with the API.

## Contributing
If you'd like to contribute to this project, feel free to create a pull request or submit issues.

## Contributors ✨

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://github.com/srija-shenkeshi"><img src="https://avatars.githubusercontent.com/u/98575238?s=400&u=3997d67f470a632951b9dfbbac34301e991e6539&v=4" width="100px;" alt=""/><br /><sub><b>SrijaShenkeshi</b></sub></a><br /></td>
  </tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

    That's all folks! 

---
