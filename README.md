# 🛍️ Product Category Service

A Spring Boot microservice for managing products and categories with support for advanced search, filtering, pagination, and Redis caching.

---

## 📌 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Getting Started](#-getting-started)
  - [Prerequisites](#-prerequisites)
  - [Build & Run](#️-build--run)
- [Configuration](#️-configuration)
- [Running Tests](#-running-tests)
- [API Endpoints](#-api-endpoints)
- [Project Structure](#️-project-structure)
- [Author](#-author)
- [Show Your Support](#-show-your-support)

---

## ✅ Features

- CRUD operations for products and categories
- Advanced search with multi-field filtering and sorting
- Pagination support for large data sets
- Redis caching for performance-optimized search results
- Global exception handling and input validation

---

## 🧰 Tech Stack

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Data Redis
- Hibernate Validator
- JUnit 5 + Mockito
- Maven

---

## 🚀 Getting Started

### ✅ Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven 3.8+
- Redis server (local or remote)

---

### ▶️ Build & Run

```bash
# Clone the repository
git clone https://github.com/your-username/product-category-service.git
cd product-category-service

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
