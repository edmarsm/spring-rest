# spring-rest
Spring REST is a study case around the uses of Spring Boot Application with the intent of showing some basics skills around the use of Spring Framework to write *RESTFULL* microservices applications.

## Getting started

To run this project you will need a database connection with PostgreSQL database.

You could achieve this goal by runing your own server and customizing the *application.yml* file info around your own database config or you can run it with [Docker](http://www.docker.com) so you can use our provided *docker-compose.yml* file.

## Technologies around the project

This project has been built with Spring Boot Framework.

Database is versioned and dynamicly created with [Liquibase](http://www.liquibase.org).

Unit Tests are created with [JUnit Framework](http://junit.org).

The project management and build is made with [Maven](http://maven.apache.org).