# Train Ticket Booking System

## Overview
The Train Ticket Booking System is a web-based application designed to streamline the process of booking train tickets. Users can select trains, view schedules, calculate prices, and book tickets efficiently. The application is built using Spring Boot for the backend and integrates with a relational database for data persistence.

---

## Features
- **User Management**: Register, login, and manage user profiles.
- **Train Management**: Add, update, and delete train details (admin functionality).
- **Ticket Booking**:
  - Book tickets by selecting available trains.
  - Automatically calculate total prices based on train fares.
- **Schedule Management**: View train schedules, departure, and arrival times.
- **Booking History**: View past bookings for each user.

---

## Technologies Used
- **Backend**:
  - Spring Boot (MVC, JPA)
  - Hibernate ORM
  - HikariCP (Connection Pooling)
- **Database**: MySQL
- **Build Tool**: Maven
- **Languages**: Java
- **Other Tools**:
  - Postman (API Testing)
  - Git (Version Control)

---

## ER Diagram
(Add an ER diagram image here if available. Example: Save your diagram as a `.png` file and link it in the README using markdown syntax.)
```
![ER Diagram](path/to/er-diagram.png)
```

---

## Setup and Installation
Follow these steps to set up and run the project locally:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/jayawickrma/Train-Ticket-Booking-System.git
   cd train-ticket-booking-system
   ```

2. **Configure the Database**:
   - Create a MySQL database, e.g., `train_booking`.
   - Update the database configuration in `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/trainBooking
     spring.datasource.username=your-username
     spring.datasource.password=your-password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the Project**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the Application**:
   - API Documentation: `http://localhost:8080/swagger-ui.html` (if Swagger is configured)
   - Test the API using Postman or your preferred tool.

---

## API Endpoints

### **User Endpoints**
| Method | Endpoint               | Description             |
|--------|------------------------|-------------------------|
| `POST` | `/api/users/register`  | Register a new user.    |
| `POST` | `/api/users/login`     | Login for users.        |

### **Train Endpoints**
| Method | Endpoint               | Description                |
|--------|------------------------|----------------------------|
| `GET`  | `/api/trains`          | Get all train details.     |
| `POST` | `/api/trains`          | Add a new train (admin).   |

### **Booking Endpoints**
| Method | Endpoint               | Description                |
|--------|------------------------|----------------------------|
| `POST` | `/api/bookings`        | Create a new booking.      |
| `GET`  | `/api/bookings/{id}`   | Retrieve booking by ID.    |

---

## Project Structure
```
src/main/java/com/example/trainticketbookingsystem/
├── Controller/       # REST controllers
├── DTO/              # Data transfer objects
├── Entity/           # Entity classes for JPA
├── Repository/       # Spring Data JPA repositories
├── Service/          # Business logic
└── Application.java  # Main Spring Boot application
```

---

## Future Enhancements
- Add support for real-time train tracking.
- Implement seat selection functionality.
- Integrate with payment gateways for ticket payments.
- Build a front-end interface using React or Angular.

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contributions
Contributions are welcome! Feel free to submit a pull request or open an issue for suggestions.

