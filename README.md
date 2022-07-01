# tasks-manager-java-mysql-connector

## Scope
- Console application that allows to perform CRUD actions over a database containing a table for tasks.
- SQL statements to create it and table along with CRUD queries are provided.

## Technology
- JDK 11.0.12
- MySQL
- [MySQL connector: JDBC Driver for MySQL (Connector/J)](https://www.mysql.com/products/connector/)

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|model for objects (attributes, constructors, getters, setters & .toString())|
|dao|methods to communicate with data source and perform the tasks demanded by the business logic|
|form|methods to ask the user for data to instantiate objects|
|services|interfaces with business-logic-oriented methods along with the classes implementing them|
|control|the flow of the application and the execution class|
|gui|Graphic User Interface|
|utilities|methods for frequently needs|

## Testing
- Unit tests are made with JUnit 5
- Only model classes are tested