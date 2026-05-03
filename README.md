# 📝 TaskFlow - Task Manager App

## 🚀 Project Description
TaskFlow is a full-stack task management application where users can register, login, and manage their daily tasks efficiently. It includes authentication, CRUD operations, and a clean user interface.

---

## 🛠️ Tech Stack

### 🔹 Backend
- Java
- Spring Boot
- Spring Security (JWT Authentication)
- Spring Data JPA
- MySQL

### 🔹 Frontend
- React (Vite)
- TypeScript
- Axios
- React Router

---

## ✨ Features

### 🔐 Authentication
- User Registration
- User Login
- JWT Token-based Authentication

### ✅ Task Management
- Add Task
- View Tasks
- Delete Task
- Protected Routes (only logged-in users)

---

## 📂 Project Structure
taskflow/ │ ├── backend/ │   ├── controller/ │   ├── service/ │   ├── repository/ │   ├── entity/ │   └── security/ │ ├── frontend/ │   ├── pages/ │   ├── services/ │   ├── components/ │   └── App.tsx

---

## ⚙️ Setup Instructions

### 🔹 Backend Setup

1. Open backend folder
2. Configure MySQL in application.properties

~ properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.datasource.driver-class-name=org.postgresql.Driver
Run backend
Bash
` mvn spring-boot:run`
👉 Backend runs on:
` http://localhost:8080 `
🔹 Frontend Setup
Open frontend folder
Bash
`cd frontend
npm install
npm run dev`
👉 Frontend runs on:
`http://localhost:5173`
🔗 API Endpoints
Auth
`POST /api/auth/register
POST /api/auth/login
Tasks
GET /api/tasks
POST /api/tasks
DELETE /api/tasks/{id}`
🔐 Authentication Flow
User logs in
JWT token is generated
Token stored in localStorage
Token sent in headers for protected APIs
Http
`Authorization: Bearer <token>`

