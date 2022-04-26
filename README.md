# tasks-manager-java-mysql-connector

## Scope
- Console application that allows to perform CRUD actions with tasks.
- There is a database for data persistence: SQL statements to create it and table along with CRUD queries are provided.

## Technology
- JDK 11.0.12
- MySQL
- [MySQL connector: JDBC Driver for MySQL (Connector/J)](https://www.mysql.com/products/connector/)

## Architecture
|package|purpose|
|----------------|-------------------------------|
|model|offers a model for objects (attributes, constructors, getters, setters & .toString())|
|dao|communicates with the database|
|services|interfaces with business-logic-oriented methods along with the classes implementing them. Communicates with dao package|
|control|the flow of the application and the execution class|
|gui|the graphics|
|tools|static methods for frequently needs, such as asking for a String to the user|