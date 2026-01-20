# VeloCab 🚖

> A scalable, microservices-based backend for a Cab Booking System built with Java and Spring Boot.

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0%2B-brightgreen)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-green)
![PostgreSQL/MySQL](https://img.shields.io/badge/Database-PostgreSQL%2FMySQL-blue)

## 📖 Overview
**VeloCab** is a modular backend application designed to handle the core logic of a ride-hailing platform. It provides **15+ RESTful API endpoints** to manage the complete lifecycle of a booking, from customer registration to ride confirmation.

The system is architected with a focus on **clean code principles**, separating concerns into Controllers, Services, Repositories, and Transformers. It ensures data integrity through strict **DTO-Entity mapping** and features automated email notifications.

## ✨ Key Features
* **Scalable Architecture:** Designed with microservices principles, ensuring modularity and easy maintenance.
* **Comprehensive API Suite:** **15+ Endpoints** covering Customer Management, Fleet/Cab Registration, and Booking workflows.
* **Automated Notifications:** Integrated **JavaMail** to send real-time email confirmations upon booking success.
* **Secure Data Flow:** Implemented custom **DTOs and Transformers** to prevent direct entity exposure and enforce strict API contracts.
* **Live Documentation:** Fully integrated **Swagger/OpenAPI** UI for real-time API testing and documentation.
* **Optimized Performance:** Enhanced database querying using **Spring Data JPA**.

## 🛠️ Tech Stack
* **Language:** Java
* **Framework:** Spring Boot
* **Database:** MySQL 
* **ORM:** Spring Data JPA
* **Documentation:** Swagger UI / OpenAPI
* **Utilities:** JavaMail Sender, Lombok

## 📂 Project Structure
The application follows a layered architecture to ensure scalability:

```text
src/main/java/com/velocab
├── config       # Swagger & Email Configurations
├── controller   # REST Controllers (API Layer)
├── dto          # Data Transfer Objects
├── model        # JPA Entities
├── repository   # Database Access Layer
├── service      # Business Logic & Validation
└── transformer  # DTO-Entity Mappers

## 🔌 API Documentation
The application exposes **10 endpoints**. Below is a summary of the core APIs implemented.

### 👤 Customer Module
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/customer/add` | Register a new customer into the system. |
| `GET` | `/customer/get/customer-id/{id}` | Retrieve a customer's profile by their unique ID. |
| `GET` | `/customer/get/gender/{gender}` | List all customers matching a specific gender. |
| `GET` | `/customer/getByGA` | Filter customers by **Gender** and exact **Age**. |
| `GET` | `/customer/getByGTA` | Filter customers by **Gender** and **Age Greater Than** a specific value. |

### 🚖 Driver & Booking Module
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `POST` | `/driver/add` | Onboard a new driver to the fleet. |
| `POST` | `/booking/book/customer/{customer_id}` | Initiate a cab booking for a specific customer. |
| `POST` | `/cab/register/driver/{driver_id}` | Assign/Register a driver to a specific cab vehicle. |

*(Note: Launch the application and visit `http://localhost:8080/swagger-ui/index.html` for the full interactive documentation and request schemas.)*

## 🚀 Getting Started

### Prerequisites
* Java Development Kit (JDK) 17+
* Maven
* MySQL/PostgreSQL running locally

### Installation
1.  **Clone the repository**
    ```bash
    git clone [https://github.com/yourusername/rideflux.git](https://github.com/yourusername/rideflux.git)
    ```
2.  **Configure Database**
    Update `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/rideflux_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.mail.username=your-email@gmail.com
    spring.mail.password=your-app-password
    ```
3.  **Run the Application**
    ```bash
    mvn spring-boot:run
    ```
