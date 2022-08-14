# tasks-manager-java-mysql-connector

## Scope
- Console application that allows to perform CRUD actions over a database containing a table for tasks.
- SQL statements to create the database and table along with CRUD queries are provided.

## Technology
- JDK 11.0.12
- MySQL
- [MySQL connector: JDBC Driver for MySQL (Connector/J)](https://www.mysql.com/products/connector/)

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|model for objects (attributes, constructors, getters, setters & .toString())|
|dao|methods to communicate with data source and perform the tasks demanded by the business logic|
|service|interfaces with business-logic-oriented methods along with the classes implementing them|
|controller|the flow of the application|
|view|information showed to the users and requested from them|
|utility|methods for frequently needs|

## Data Structure
|data|structure|
|----------------|-------------------------------|
|Task|int id, String title, String content, boolean isCompleted, LocalDateTime dateCreated|

## Data source
MySQL database.

## Testing
- Unit tests are made with JUnit 5
- Only model classes are tested

## Libs
 - Log4j-api-2.7.jar
 - Log4j-core-2.7.jar