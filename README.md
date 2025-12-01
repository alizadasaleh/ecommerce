# Ecommerce

![Build Status](https://github.com/alizadasaleh/ecommerce/actions/workflows/ci.yml/badge.svg)
![Maven Central](https://img.shields.io/badge/build-gradle-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

**Ecommerce** is a lightweight sample Spring Boot application that demonstrates a simple e-commerce backend. It uses Spring Boot, MyBatis for persistence, Elasticsearch for product search, and PostgreSQL as the primary datastore. The project includes REST controllers for customers, products and orders and is intended as a starter template or learning reference.

**Why this project is useful**
- **Simple, practical stack**: Spring Boot + MyBatis + PostgreSQL + Elasticsearch.
- **Search examples**: Shows both exact and fuzzy search endpoints for products.
- **Clean layering**: Controller, service, mapper, repository structure suitable for extension.
- **Docker-ready**: Includes `docker-compose.yml` to start required services locally.

**Quick Links**
- Source code: `src/main/java`
- SQL schema: `src/main/resources/schema.sql`
- MyBatis config: `src/main/resources/mybatis-config.xml`
- Build: `build.gradle`
- Docker compose: `docker-compose.yml`

## Getting Started

These instructions help developers get a local dev environment running quickly.

### Prerequisites
- Java 17
- Git
- Docker & Docker Compose (optional, recommended for Postgres/Elasticsearch)
- Internet access to download Gradle dependencies

### Clone

```bash
git clone https://github.com/alizadasaleh/ecommerce.git
cd ecommerce
```

### Run with Gradle (fast iteration)

Build and run the application using the Gradle wrapper:

```bash
./gradlew build
./gradlew bootRun
```

The application runs on the configured port (check `src/main/resources/application.properties` or environment variables). If you are using embedded/default settings and need a database, use the Docker Compose setup below.

### Run with Docker Compose (Postgres + Elasticsearch)

If you want to run the required infrastructure locally, use the provided `docker-compose.yml`:

```bash
docker-compose up -d
# wait for services to be ready, then start the app
./gradlew bootRun
```

### Tests

Run unit/integration tests with:

```bash
./gradlew test
```

## API Overview (examples)

The project exposes REST endpoints under `/api`.

- Customers: `/api/customers`
  - `GET /api/customers` — list customers
  - `GET /api/customers/{id}` — get customer
  - `POST /api/customers` — create customer
  - `PUT /api/customers/{id}` — update customer
  - `DELETE /api/customers/{id}` — delete customer

- Products: `/api/products`
  - `GET /api/products` — list products
  - `GET /api/products/{id}` — get product
  - `POST /api/products` — create product
  - `PUT /api/products/{id}` — update product
  - `DELETE /api/products/{id}` — delete product
  - `GET /api/products/search/{name}` — exact search by name
  - `GET /api/products/fuzzy-search/{name}` — fuzzy search

- Orders: `/api/orders` and helper routes
  - `GET /api/orders` — list orders
  - `GET /api/orders/{id}` — get order
  - `POST /api/orders` — create order
  - `PUT /api/orders/{id}` — update order
  - `DELETE /api/orders/{id}` — delete order
  - `GET /api/customers/{customerId}/orders` — orders for customer
  - `GET /api/products/{productId}/orders` — orders for product

### Example requests

Create a customer:

```bash
curl -X POST http://localhost:8080/api/customers \
  -H "Content-Type: application/json" \
  -d '{"name":"Alice Smith","email":"alice@example.com","address":"123 Main St"}'
```

Create a product:

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Widget","Price":9.99}'
```

Create an order (customerId and productIds):

```bash
curl -X POST http://localhost:8080/api/orders \
  -H "Content-Type: application/json" \
  -d '{"customerId":1,"productIds":[1,2]}'
```

Note: Example request fields are based on DTOs in `src/main/java/com/ailab/ecommerce/*RequestDto.java`.

## Project Structure

- `src/main/java/com/ailab/ecommerce` — application code (controllers, services, mappers, repositories)
- `src/main/resources` — MyBatis config, schema and mapping files
- `build.gradle` — Gradle build
- `docker-compose.yml` — local services for Postgres/Elasticsearch (if present)

## Configuration

Check `src/main/resources` and environment variables for database and Elasticsearch connection properties. The app uses Java 17 and Spring Boot 3.x (see `build.gradle`).

## Contributing & Support

- **Report issues**: Open an issue in this repository.
- **Contributing**: See `CONTRIBUTING.md` for guidelines (add one if missing).
- **Maintainers**: Repository owner `alizadasaleh` (see Git history for committers).

If you need help reproducing a problem locally, include the `./gradlew build` output and any logs from the app or `docker-compose` services.

## License

See the `LICENSE` file in this repository for license details.

---

If you'd like, I can also add a minimal `CONTRIBUTING.md`, a GitHub Actions CI workflow, or example Postgres/Elasticsearch seed data. Would you like me to add any of those now?
