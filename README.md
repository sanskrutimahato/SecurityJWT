# SecurityJWT

A Spring Boot application demonstrating JWT-based authentication and authorization with secure REST endpoints.

## Features

- User registration and login
- JSON Web Token (JWT) authentication
- Spring Security integration for protected routes
- Role-based access control with admin endpoints
- MySQL persistence via Spring Data JPA
- Validation for incoming authentication requests

## Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- JWT (`io.jsonwebtoken:jjwt`)
- MySQL Connector/J
- Lombok
- Maven

## Project Structure

- `src/main/java`: application source code
  - `config`: security and application configuration
  - `controller`: REST controllers for auth and admin endpoints
  - `dto`: request/response data transfer objects
  - `entity`: JPA entity definitions
  - `repository`: Spring Data JPA repositories
  - `security`: JWT utilities and security helpers
  - `service`: business logic and user management
- `src/main/resources`: application properties and static resources

## Getting Started

### Prerequisites

- Java 21 JDK
- Maven
- MySQL database

### Setup

1. Configure `src/main/resources/application.properties` with your MySQL connection properties.
2. Build the application:

```bash
./mvnw clean package
```

3. Run the application:

```bash
./mvnw spring-boot:run
```

### Notes

- Ensure the `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` values are set correctly.
- Update JWT secret and expiration values if needed.

## License

This project is provided as-is for educational and reference purposes.
