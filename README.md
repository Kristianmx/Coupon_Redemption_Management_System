# employability Assessment - Coupon Management and Redemption System

## 1. Generalities:

### Description

- Riwi is currently developing an ecommerce project to sell its products online, however, a development cell is needed to be responsible for the management and redemption of coupons, for this reason your cell is asked to develop a system that allows customers to Users manage and redeem discount coupons.

### Members, roles and responsibilities

- Santiago Andres Lara Zapata
    - Documentation and trello management.
- Kristopher Alexander Rivas Hernández 
    - Git flow and pull request management.
- Miguel Angel Toro Pérez
    - Developer
- Dayron Yeins Zapata Tabares 
    - Time management
- Sara Camila Ruiz Arismendi
    - Database model
### Project

The backend development is done in Spring Boot as the server-side technology. Additionally, it consumes data using REST APIs for the persistence of the respective project's data.

---

## 2. name the project:

Coupon Management and Redemption System

---

## 4. Functionality Proposals:

1. Registration of users
2. Coupon redemption
3. Coupon management
4. Product management

---
## Architecture
```
project/
└── src/
    └── main/
        ├── java/
        │   ├── api/
        │   │   ├── controller/
        │   │   ├── dto/
        │   │   └── error_handler/
        │   ├── config/
        │   ├── domain/
        │   │   ├── entities/
        │   │   └── repositories/
        │   ├── infrastructure/
        │   │   ├── abstract_service/
        │   │   └── service/
        │   └── utils/
        |   |   ├── enums/
        │   │   └── exceptions/
        └── resource/


```

## TRELLO
https://trello.com/b/WiljKA8y/employability-assessment

---
## Architecture diagram
```plaintext
+-------------------------------------+
|             Client                  |
|  (Browser, Mobile App, Postman, etc.) |
+-----------------+-------------------+
                  |
                  v
+-------------------------------------+
|        Controller Layer             |
| (Handles HTTP requests/responses)   |
|  +-------------------------------+  |
|  | @RestController               |  |
|  | - UserController              |  |
|  +-------------------------------+  |
+-----------------+-------------------+
                  |
                  v
+-------------------------------------+
|          Service Layer              |
| (Business logic and rules)          |
|  +-------------------------------+  |
|  | @Service                      |  |
|  | - UserService                 |  |
|  +-------------------------------+  |
+-----------------+-------------------+
                  |
                  v
+-------------------------------------+
|        Repository Layer             |
| (Data access layer)                 |
|  +-------------------------------+  |
|  | @Repository                   |  |
|  | - UserRepository              |  |
|  +-------------------------------+  |
+-----------------+-------------------+
                  |
                  v
+-------------------------------------+
|        Database                     |
| (Relational Database, e.g., MySQL)  |
+-------------------------------------+
```

## Requirements to run the program

1. The program uses Java version 17 in the code editor.
2. XAMPP must be installed.
3. MySQL Workbench must be installed.

## Program execution

1. If you are using a Windows operating system, open the XAMPP program.
2. Start MySQL.
3. Open MySQL Workbench on the local port.
4. Execute the command `CREATE DATABASE coupons;` to create the database.
5. Run the program from the code editor.
6. Open Swagger using the following link: http://localhost:8080/api/v1/swagger-ui/index.html
7. Select the query you wish to perform and enter data if necessary to test the program's functionality.


## Database diagram
![imagen](https://github.com/user-attachments/assets/621be9f1-68d8-41bb-b411-44bde6a2a669)


