# Naluri Sun Circumference Application

## Description
Naluri Sun Circumference is a full-stack web application that demonstrates incremental calculation of π (Pi) and applies it to compute the circumference of the Sun.

The frontend is built with **React + Vite + TailwindCSS**, and the backend is built with **Spring Boot (Java 21)**.  
The application can run in a **single Docker container** for convenience.

---

## Features
The application is designed with real-world service behavior in mind:
  - Pi is calculated continuously in the background
  - State is persisted and survives restarts
  - Precision is handled correctly using BigDecimal
  - Results are exposed via a clean REST API and consumed by a modern frontend

---

## Prerequisites
- **Docker Desktop** installed and running (for Docker method).  
- **Optional for manual run:**  
  - Node.js 20+ (for frontend)  
  - Java 21+ and Maven 4+ (for backend)  

---

## [1] How to Run (Docker)

1. Open terminal in the project root (where `Dockerfile` is located).

2. Build the Docker image through the docker-compose:

```bash
docker-compose up --build
```

## [2] How to Run Manually In Separate Application

## FRONTEND - naluri-frontend
1. cd naluri-frontend
2. nvm ls (make sure node version is 20+)
3. npm install
4. npm run dev

## BACKEND - naluri-backend
1. Open Intellij
2. At the top left, click Open > find naluri-backend and choose it > Click Ok > Trust Project 
3. Run the application 


## Future Work
I try to make the UI more polished and user-friendly.
Will add some network or security checking and learn how actual production application connecting to each other in secured network.

I would love to learn Kubernetes so that can i try to implement in this project.
