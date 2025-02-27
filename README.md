# Employee CRUD 

Пример проекта на Spring Boot с использованием базы данных MySQL, развернутый с помощью Docker Compose.  



## Установка и запуск

1. **Сборка приложения**

   Соберите проект с помощью Maven:
   ```bash
   mvn clean 
   mvn package -DskipTests
2. **Сборка image**

    Соберите image с помощью docker:
    ```bash
    docker build -t employee_crud .
    ```
3. **Запуск контейнеров**

   Запустите приложение с помощью docker-compose:
    ```bash
    docker-compose up
    ```
4. **Откройте <localhost:8080>**
