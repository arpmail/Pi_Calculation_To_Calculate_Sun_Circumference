# ---------------- Stage 1: Build React frontend ----------------
FROM node:20 AS frontend-build

WORKDIR /app/naluri-frontend

COPY naluri-frontend/package*.json ./
RUN npm install

COPY naluri-frontend/ ./
RUN npm run build  

# ---------------- Stage 2: Build Spring Boot backend ----------------
FROM maven:3.9-eclipse-temurin-21 AS backend-build

WORKDIR /app/naluri-backend

COPY naluri-backend/pom.xml ./
COPY naluri-backend/src ./src
COPY --from=frontend-build /app/naluri-frontend/dist ./src/main/resources/static

RUN mvn clean package -DskipTests

# ---------------- Stage 3: Runtime image ----------------
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy built jar
COPY --from=backend-build /app/naluri-backend/target/*.jar app.jar

EXPOSE 8080

# Java memory flags for container
ENTRYPOINT ["java", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]
