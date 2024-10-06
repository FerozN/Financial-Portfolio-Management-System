# Project: Financial Portfolio Management System

>### *Note for the following: anything noted below is subject to change*

## Concept Under Development:

This project is currently under development, with updates expected in the future. The anticipated completion date is unknown.

## Overview:

The Financial Portfolio Management System is a web application aimed at allowing users to manage investments efficiently. In this version, the system provides basic portfolio management and user authentication, with microservices architecture in place for future expansion. While many advanced features are planned, this release focuses on core functionalities like user authentication and basic transaction management for crypto and stock portfolios.

## Technologies Used
- **Frontend:** HTML, Java, JSP.
- **Backend:** Java (Servlets and JSP).
- **Database:** MySQL.
- **Microservices:** Java (Servlets and JSP).
- **Containerization and Orchestration:** Planned for future development (Docker, Google Kubernetes Engine).

---

### **Version 1 (Current Release)**:
- **User Authentication and Profile Management**  
  Users can securely register, log in, and manage their profiles. The frontend microservice handles JWT authentication.

- **Portfolio Management**  
  Users can create, view, and manage their portfolios, with the ability to buy, sell, and track transactions.

---

## Software Architecture:

The system is designed using microservices for scalability and modularity. Here’s an overview of the key services:

1. **FrontEnd Microservice**  
   Responsible for the main UI, gathering information from backend services, handling JWT authentication, and managing user logins.  
   Uses the Account table from the `Account_LBS` database.

2. **SignUp Microservice**  
   Manages user registration, keeping it separate from the frontend for potential future SSO authentication.  
   Uses the `SingUp_LBS` database with the Accounts table.

3. **CryptoTransactions Microservice**  
   Handles all crypto-related transactions, allowing users to manage their crypto accounts, add funds, and buy/sell cryptocurrencies.  
   Uses the `CryptoFunds_LBS` database with the `Personal_Account`, `watchlist`, `transactions`, and `Financial_Data` tables.

4. **StockTransactions Microservice**  
   Manages stock-related transactions where users can add funds and buy/sell stocks.  
   Uses the `StockFunds_LBS` database with the `Personal_Account`, `watchlist`, `transactions`, and `Financial_Data` tables.

5. **JWT Authentication Microservice**  
   This microservice is dedicated to managing user authentication via JSON Web Tokens (JWT). Upon successful login, users receive a JWT that they can use for subsequent requests to access 
   protected resources. This service ensures secure communication and validates user sessions effectively.

---

### **Layered Architecture**:
- **Persistence, Business, and Helper Packages**  
  Each microservice contains distinct packages for data handling, logic processing, and utility functions, following a layered design for maintainability and scalability.

- **Endpoint Package**  
  Responsible for handling REST API calls for communication between frontend and backend services.

- **Business Layer**  
  Contains business logic and data conversion, especially focused on XML syntax for this version.

---

### **Future Updates**:
While the current version provides core functionality, several updates are planned in future releases:

1. **Financial APIs**  
   Integration of real-time financial data and market news to keep users informed and improve portfolio management.

2. **Transaction History**  
   Detailed logs of all buy/sell transactions for both crypto and stock portfolios.

3. **Responsive Design**  
   Implementation of responsive design for a seamless user experience across devices.

4. **Security Enhancements**  
   Stronger security protocols with a Single Sign-On (SSO) feature.

5. **Containerization and Cloud Deployment**  
   Future use of Docker for containerization and deployment on Google Kubernetes Engine (GKE).

6. **Microservices Expansion**  
   Further development of microservices to include additional functionality, such as financial data retrieval and portfolio analytics.

---

## Contact:

For inquiries or feedback, please contact [@FerozN](https://github.com/FerozN/).

>**Thank you for your interest in the Financial Portfolio Management System!**
