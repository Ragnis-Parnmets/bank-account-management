# Bank Account Management API  
*A simple banking API built with Java and Spring Boot*  

## Overview  
This project is a simple RESTful API for managing bank accounts. It allows users to create, retrieve, update, and delete accounts. The project follows a layered architecture. The project is built using **Java**, **Spring Boot**, and **JUnit for testing**.  

## Features  
- Create, read, update, and delete bank accounts
- Retrieve account balance by ID
- Repository-based data storage (currently in-memory)
- Unit tests for service and repository layers

## Technologies Used  
- **Java 21**  
- **Spring Boot**    
- **JUnit & Mockito**  
- **Gradle**  

## The API will be available at: 
   http://localhost:8081

## API Endpoints  
| Method | Endpoint                     | Description                        |
|--------|------------------------------|------------------------------------|
| GET    | `/accounts`                   | Get all accounts                  |
| GET    | `/accounts/{id}`               | Get account by ID                 |
| GET    | `/accounts/{id}/balance`       | Get account balance by ID         |
| POST   | `/accounts`                    | Create a new account              |
| PUT    | `/accounts/{id}`               | Update an existing account        |
| DELETE | `/accounts/{id}`               | Delete an account by ID           |

## Author  
**Ragnis Pärnmets**  
