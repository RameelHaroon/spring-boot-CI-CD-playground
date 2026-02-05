# spring-boot-CI-CD-playground

A simple Spring Boot CRUD application built to learn real-world CI practices using GitHub Actions.

This project focuses on:
- Clean Spring Boot setup
- Flyway database migrations
- PostgreSQL runtime
- H2-based testing
- CI pipelines with GitHub Actions

The goal is not features — the goal is understanding build, test, and delivery workflows used in production systems.

---

## 🚀 Tech Stack

- Java 25
- Spring Boot
- Spring Data JPA
- Flyway
- PostgreSQL (Docker Compose)
- H2 (test environment)
- Maven
- GitHub Actions (CI)

---

## 🧪 Testing Strategy

| Environment | Database |
|------------|----------|
| Local dev | PostgreSQL (Docker) |
| CI | H2 in-memory |
| Migrations | Flyway |

Tests run on H2 for:
- speed
- reliability
- CI simplicity

Flyway migrations run in dev environments.

---

## 🛠 Running Locally

### Start Postgres
```bash
docker compose up -d
