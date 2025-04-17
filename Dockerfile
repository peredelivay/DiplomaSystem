# Используем официальный образ JDK 17
FROM openjdk:17-jdk-slim

# Аргумент для сборки JAR файла
ARG JAR_FILE=build/libs/diploma-0.0.1-SNAPSHOT.jar

# Копируем JAR в контейнер
COPY ${JAR_FILE} app.jar

# Указываем порт, который слушает приложение (например, 8080)
EXPOSE 8080

# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "/app.jar"]
