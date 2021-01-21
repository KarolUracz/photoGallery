PhotoGallery recruitment task

Main goal of this project is to create Back-end for photo gallery that allows to create account for customers and let them to upload/downolad photographies.

Setup & Installation

Clone repository grom GitHub, create project in IntelliJ from existing sources.

Create new MySQL database and configure application.properties file accordingly:

spring.jpa.hibernate.ddl-auto=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

spring.servlet.multipart.enabled=true
spring.servlet.multipart.file-size-threshold=2KB
spring.servlet.multipart.max-file-size=200MB
spring.servlet.multipart.max-request-size=200MB

Run project in IntelliJ.

Technologies used:

Java 8
Spring Boot 
Spring Security
Spring Data JPA
MySql
Hibernate
Thymleaf
