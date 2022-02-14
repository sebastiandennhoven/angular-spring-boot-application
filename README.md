# angular-spring-boot-application

## Angular Front-end
    For detailed descriptions for installation please view **Read.me** in angular-frontend folder
    Inital info:
    - `npm i` to install all packages
    > `npm start` to run frontend

## Spring Boot Backend
    I have setup 2 different Backends.
    - MySQL Database Backend (spring-boot-mysql-db)
    - Object Database Backend (spring-boot-object-db)

    Why?
    If you don't have a MySQL Database &|| don't want to set it up, use the Object Database Backend.
    It stores the request in an object which is used for request responses.
    Penalty, if you initially start the backend, there is no data.

    If you have a MySQL Database you can use the **spring-boot-mysql-db** and follow the instructions in **HELP.md**.

    > In any case if you like to start the Backend use `./gradlew bootRun` to start the Backend.