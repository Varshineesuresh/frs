# Food Redistribution and Donation Management System

A web-based platform designed to facilitate the redistribution of surplus food from **Donors** to **Non-Governmental Organizations (NGOs)**. The system provides a centralized platform where donors can create and manage food donations, NGOs can discover and request available donations, and administrators can manage users, donors, NGOs, donations, and requests.

---

## 📌 Project Overview

Food wastage is a significant social and environmental problem, while many people and communities continue to face food insecurity.

The **Food Redistribution and Donation Management System** aims to bridge this gap by providing a digital platform for managing the redistribution of surplus food.

The system allows:

* **Donors** to register their organizations and publish surplus food donations.
* **NGOs** to register their organizations and request available food donations.
* **Administrators** to manage donors, NGOs, donations, and requests.
* The system to maintain the status and lifecycle of donations and NGO requests.
* Users to authenticate through a centralized `USER` entity.

The system focuses on making the donation process more organized, transparent, and manageable.

---

## 🎯 Objectives

The main objectives of the project are:

1. To provide a centralized platform for surplus food donation management.
2. To connect food donors with NGOs that require food resources.
3. To reduce food wastage by facilitating redistribution.
4. To simplify the process of creating and requesting food donations.
5. To provide administrators with centralized management capabilities.
6. To maintain the status of donations and NGO requests.
7. To provide a structured database for storing donation and request information.
8. To improve transparency in the food redistribution process.

---

## 👥 User Roles

The system contains three major roles:

### 1. Donor

Donors are organizations or individuals who have surplus food available for redistribution.

Donors can:

* Register and authenticate.
* Maintain their organization profile.
* Create food donations.
* Specify food type and quantity.
* Specify pickup location.
* Set donation availability and expiry times.
* View their donations.
* Monitor donation status.
* View requests associated with their donations.

---

### 2. NGO

NGOs are organizations that receive redistributed food.

NGOs can:

* Register and authenticate.
* Maintain their organization profile.
* View available donations.
* Create requests for donations.
* Specify the required quantity.
* Track request status.
* View accepted or rejected requests.

---

### 3. Admin

Administrators provide centralized management of the platform.

Admins can:

* Manage donors.
* Manage NGOs.
* Manage donations.
* Manage NGO requests.
* Monitor the overall system.
* Manage user-related information.

---

# 🏗️ System Architecture

The application follows a layered backend architecture.

```text
                    ┌─────────────────────┐
                    │      Web Browser     │
                    │   HTML / CSS / JS    │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Spring Boot App   │
                    └──────────┬──────────┘
                               │
              ┌────────────────┼────────────────┐
              │                │                │
              ▼                ▼                ▼
       ┌────────────┐   ┌────────────┐   ┌────────────┐
       │ Controller │   │  Security  │   │    DTO     │
       └─────┬──────┘   └────────────┘   └────────────┘
             │
             ▼
       ┌────────────┐
       │   Service  │
       └─────┬──────┘
             │
             ▼
       ┌────────────┐
       │ Repository │
       └─────┬──────┘
             │
             ▼
       ┌────────────┐
       │   MySQL    │
       │  Database  │
       └────────────┘
```

---

# 🛠️ Technologies Used

## Frontend

* HTML5
* CSS3
* JavaScript
* Responsive Web Design

## Backend

* Java
* Spring Boot
* Spring MVC
* Spring Data JPA
* Spring Security
* REST APIs

## Database

* MySQL
* MySQL Workbench

## Development Tools

* Visual Studio Code
* Git
* GitHub
* Postman / Thunder Client

---

# 📂 Project Structure

```text
frs/
│
├── demo/
│   │
│   ├── src/
│   │   ├── main/
│   │   │   │
│   │   │   ├── java/
│   │   │   │   └── com/example/demo/
│   │   │   │       │
│   │   │   │       ├── controller/
│   │   │   │       ├── dto/
│   │   │   │       ├── entity/
│   │   │   │       ├── exception/
│   │   │   │       ├── repository/
│   │   │   │       ├── security/
│   │   │   │       ├── service/
│   │   │   │       ├── util/
│   │   │   │       │
│   │   │   │       └── DemoApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       │
│   │   │       ├── static/
│   │   │       │   ├── assets/
│   │   │       │   │   ├── app.js
│   │   │       │   │   └── style.css
│   │   │       │   │
│   │   │       │   ├── index.html
│   │   │       │   ├── donor.html
│   │   │       │   ├── ngo.html
│   │   │       │   └── admin.html
│   │   │       │
│   │   │       ├── templates/
│   │   │       │
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   │       └── java/
│   │           └── com/example/demo/
│   │               └── DemoApplicationTests.java
│   │
│   └── pom.xml
│
└── README.md
```

---

# 🗄️ Database Design

The database is designed around a centralized `USER` entity for authentication and separate entities for the three major user roles.

### Main Entities

```text
USER
DONOR
NGO
ADMIN
DONATION
NGO_REQUEST
```

---

## USER

The `USER` entity is the central authentication entity.

| Attribute         | Description             |
| ----------------- | ----------------------- |
| `user_id`         | Primary Key             |
| `name`            | User name               |
| `phone`           | Unique phone number     |
| `password`        | Authentication password |
| `role`            | Donor / NGO / Admin     |
| `address`         | User address            |
| `date_registered` | Registration date       |
| `status`          | Active / Inactive       |

---

## DONOR

Stores information about food donors.

| Attribute           | Description                  |
| ------------------- | ---------------------------- |
| `donor_id`          | Primary Key                  |
| `user_id`           | Foreign Key referencing USER |
| `organization_name` | Donor organization name      |
| `fssai_license_no`  | FSSAI license number         |
| `address`           | Organization address         |
| `city`              | City                         |
| `state`             | State                        |
| `pincode`           | Postal code                  |

---

## NGO

Stores information about registered NGOs.

| Attribute           | Description                    |
| ------------------- | ------------------------------ |
| `ngo_id`            | Primary Key                    |
| `user_id`           | Foreign Key referencing USER   |
| `organization_name` | NGO organization name          |
| `registration_no`   | Unique NGO registration number |
| `founded_year`      | Year of establishment          |
| `address`           | NGO address                    |
| `city`              | City                           |
| `state`             | State                          |
| `pincode`           | Postal code                    |
| `about_us`          | Organization description       |

---

## ADMIN

Stores administrator information.

| Attribute  | Description                  |
| ---------- | ---------------------------- |
| `admin_id` | Primary Key                  |
| `user_id`  | Foreign Key referencing USER |
| `name`     | Administrator name           |
| `phone`    | Unique phone number          |
| `address`  | Administrator address        |

---

## DONATION

Stores food donations created by donors.

| Attribute            | Description                                 |
| -------------------- | ------------------------------------------- |
| `donation_id`        | Primary Key                                 |
| `donor_id`           | Foreign Key referencing DONOR               |
| `food_type`          | Type of food                                |
| `quantity`           | Quantity of food                            |
| `unit`               | Plates / Kg / Packets / etc.                |
| `description`        | Description of the food                     |
| `pickup_location`    | Food pickup location                        |
| `latitude`           | Optional geographic latitude                |
| `longitude`          | Optional geographic longitude               |
| `availability_start` | Start of availability                       |
| `expiry_datetime`    | Donation expiry time                        |
| `created_at`         | Creation timestamp                          |
| `status`             | Available / Claimed / Completed / Cancelled |

---

## NGO_REQUEST

Stores requests made by NGOs for donations.

| Attribute            | Description                               |
| -------------------- | ----------------------------------------- |
| `request_id`         | Primary Key                               |
| `ngo_id`             | Foreign Key referencing NGO               |
| `donation_id`        | Foreign Key referencing DONATION          |
| `request_message`    | Optional request message                  |
| `quantity_requested` | Requested quantity                        |
| `requested_at`       | Request timestamp                         |
| `status`             | Pending / Accepted / Rejected / Cancelled |
| `responded_at`       | Optional response timestamp               |

---

# 🔗 Entity Relationships

The major relationships in the system are:

### USER — DONOR

A user can be associated with a donor profile through the `user_id` foreign key.

```text
USER 1 ───── 1 DONOR
```

### USER — NGO

A user can be associated with an NGO profile.

```text
USER 1 ───── 1 NGO
```

### USER — ADMIN

An administrator is associated with a user account.

```text
USER 1 ───── 1 ADMIN
```

### DONOR — DONATION

A donor can create multiple donations.

```text
DONOR 1 ───── N DONATION
```

### NGO — NGO_REQUEST

An NGO can create multiple requests.

```text
NGO 1 ───── N NGO_REQUEST
```

### DONATION — NGO_REQUEST

A donation can receive multiple requests over its lifecycle.

```text
DONATION 1 ───── N NGO_REQUEST
```

The system controls the request and donation status so that a donation can be accepted/claimed appropriately.

### ADMIN — Management

The administrator manages the platform's major records, including donors, NGOs, donations, and requests.

---

# 🔄 Donation Workflow

The general donation workflow is:

```text
Donor Registration
        │
        ▼
Donor Login
        │
        ▼
Create Donation
        │
        ▼
Donation Status = AVAILABLE
        │
        ▼
NGO Views Available Donation
        │
        ▼
NGO Creates Request
        │
        ▼
Request Status = PENDING
        │
        ▼
Donor/Admin Reviews Request
        │
        ├───────────────┐
        ▼               ▼
   ACCEPTED          REJECTED
        │
        ▼
Donation = CLAIMED
        │
        ▼
Donation Completed
        │
        ▼
Donation = COMPLETED
```

A donation can also be cancelled according to its status and lifecycle.

---

# 🔐 Authentication and Authorization

The system uses a centralized `USER` entity for authentication.

The user's role determines the type of access available to them.

```text
                    USER
                      │
          ┌───────────┼───────────┐
          │           │           │
          ▼           ▼           ▼
        DONOR         NGO        ADMIN
          │           │           │
          ▼           ▼           ▼
     Donor UI      NGO UI      Admin UI
```

### Role-Based Access

| Role  | Main Responsibilities                                      |
| ----- | ---------------------------------------------------------- |
| Donor | Manage profile, create donations, manage donation requests |
| NGO   | View donations, create requests, track requests            |
| Admin | Manage donors, NGOs, donations and requests                |

---

# 🖥️ Frontend Pages

The frontend currently contains separate interfaces for the major user roles.

### Home Page

`index.html`

Provides the entry point to the application.

### Donor Dashboard

`donor.html`

Provides the donor interface for:

* Dashboard overview
* Donation management
* Organization information
* Donation status
* Request-related information

### NGO Dashboard

`ngo.html`

Provides the NGO interface for:

* Viewing available donations
* Requesting food donations
* Monitoring requests
* Organization information

### Admin Interface

`admin.html`

Provides administrative functionality for managing the system.

---

# 🔌 Backend API

The backend follows a RESTful architecture.

The application is organized into separate layers:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller Layer

Handles incoming HTTP requests and exposes REST endpoints.

### Service Layer

Contains business logic and application rules.

### Repository Layer

Provides database access using Spring Data JPA.

### Entity Layer

Represents database tables as Java entities.

### DTO Layer

Handles structured data transfer between the frontend and backend.

### Exception Layer

Handles application-specific errors and exceptions.

### Security Layer

Handles authentication and authorization.

---

# 🗃️ Database Setup

## Prerequisites

Install the following:

* Java JDK 21
* Maven
* MySQL Server
* MySQL Workbench
* Git
* Visual Studio Code or another Java IDE

---

## Create the Database

Open MySQL Workbench and create the project database.

Example:

```sql
CREATE DATABASE food_redistribution;
```

Then configure the database connection in:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/food_redistribution
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9090
```

Replace:

```text
YOUR_MYSQL_USERNAME
YOUR_MYSQL_PASSWORD
```

with your local MySQL credentials.

> Do not commit real database passwords or other secrets to GitHub.

---

# ▶️ Running the Application

## 1. Clone the Repository

```bash
git clone <YOUR_REPOSITORY_URL>
```

Move into the project directory:

```bash
cd frs
```

Then enter the backend project:

```bash
cd demo
```

---

## 2. Start the Spring Boot Application

Using Maven:

```bash
mvn spring-boot:run
```

Or run:

```text
DemoApplication.java
```

from Visual Studio Code.

---

## 3. Open the Application

The application runs on port `9090`.

Open:

```text
http://localhost:9090/
```

The individual frontend pages can be accessed through:

```text
http://localhost:9090/index.html
http://localhost:9090/donor.html
http://localhost:9090/ngo.html
http://localhost:9090/admin.html
```

---

# 🧪 Testing

API endpoints can be tested using:

* Postman
* Thunder Client
* Browser Developer Tools

Testing should cover:

* User registration
* User authentication
* Donor creation
* NGO creation
* Donation creation
* Viewing available donations
* Creating NGO requests
* Accepting/rejecting requests
* Donation status changes
* Role-based access

---

# 📊 Donation Status

A donation can move through different stages:

```text
AVAILABLE
    │
    ▼
CLAIMED
    │
    ▼
COMPLETED
```

A donation may also be:

```text
CANCELLED
```

depending on the application's business rules.

---

# 📋 NGO Request Status

NGO requests follow a controlled lifecycle:

```text
PENDING
   │
   ├──────► ACCEPTED
   │
   ├──────► REJECTED
   │
   └──────► CANCELLED
```

The request status allows the system to track the outcome of each NGO request.

---

# 📐 ER Diagram

The Entity Relationship Diagram represents the database structure and relationships between the major entities.

### Main entities represented

* USER
* DONOR
* NGO
* ADMIN
* DONATION
* NGO_REQUEST

The ER model establishes the relationships between users, donors, NGOs, donations, administrators, and NGO requests.

> Add the ER diagram image to the repository, for example:
>
> `docs/er-diagram.png`

Then display it in this README using:

```markdown
![Food Redistribution ER Diagram](docs/er-diagram.png)
```

---

# 📁 Recommended Repository Documentation

For a more professional GitHub repository, the following structure can be used:

```text
frs/
│
├── demo/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── docs/
│   ├── er-diagram.png
│   ├── system-architecture.png
│   ├── class-diagram.png
│   └── database-design.png
│
├── README.md
└── .gitignore
```

This keeps project documentation separate from the application source code.

---

# 🚀 Future Enhancements

Potential future improvements include:

* Real-time donation availability updates.
* Location-based donation discovery.
* Map integration using latitude and longitude.
* Email or in-application notifications.
* Advanced donation search and filtering.
* Dashboard analytics.
* Donation history and reporting.
* Improved request tracking.
* Mobile-friendly responsive interface.
* Deployment to a cloud platform.
* Automated testing and CI/CD integration.

---

# 🔒 Security Considerations

The application should follow secure development practices including:

* Password encryption/hashing.
* Role-based authorization.
* Input validation.
* Secure API endpoints.
* Protection against unauthorized access.
* Secure database credentials.
* Avoiding sensitive information in source code.
* Proper exception handling.

Sensitive configuration values such as database passwords should be stored outside the public repository.

---

# 🌱 Social Impact

The system aims to contribute to:

* Reduction of food wastage.
* Better utilization of surplus food.
* Improved coordination between food donors and NGOs.
* Faster identification of available food resources.
* More organized donation management.
* Support for communities experiencing food insecurity.

---

# 👨‍💻 Development Workflow

The project can be developed collaboratively using Git and GitHub.

```text
Create / Modify Feature
          │
          ▼
       Test
          │
          ▼
      Git Commit
          │
          ▼
      Git Push
          │
          ▼
       GitHub
          │
          ▼
   Review / Integration
```

For collaborative development, contributors can work on separate branches and merge completed features into the main branch.

---

# 🤝 Contributing

Contributions are welcome.

To contribute:

1. Fork the repository.
2. Clone the repository.
3. Create a feature branch.

```bash
git checkout -b feature/your-feature
```

4. Make your changes.
5. Test the application.
6. Commit your changes.

```bash
git add .
git commit -m "Add your feature"
```

7. Push the branch.

```bash
git push origin feature/your-feature
```

8. Create a Pull Request.

---

# 👥 Contributors

| Contributor     | Role                      |
| --------------- | ------------------------- |
| Harsheni S.     | Frontend / UI Development |
| `<Team Member>` | Backend Development       |
| `<Team Member>` | Database / Integration    |

> Replace the placeholder names and roles with the actual project team members.

---

# 📜 License

This project is developed for **academic and educational purposes**.

If a specific open-source license is required, an appropriate license such as the MIT License can be added to the repository.

---

# ⭐ Project Summary

The **Food Redistribution and Donation Management System** is a full-stack web application that provides a structured platform for managing surplus food donations and connecting donors with NGOs.

The system combines:

```text
Frontend
   +
Spring Boot Backend
   +
REST APIs
   +
Spring Data JPA
   +
MySQL
   +
Authentication & Authorization
```

to create a centralized solution for managing food donations, NGO requests, and the overall redistribution workflow.

---

## 📌 Project Status

**Status:** 🚧 Under Development

The frontend interface, backend architecture, database design, authentication, donation management, and NGO request management are being developed and integrated incrementally.
