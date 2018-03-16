
CREATE TABLE UserDemo (
  id   INTEGER PRIMARY KEY,
  name VARCHAR(50)  NOT NULL
);

/*
80.3 Initialize a Database
Spring Boot can automatically create the schema (DDL scripts) of your DataSource and initialize it (DML scripts). 
It loads SQL from the standard root classpath locations: schema.sql and data.sql, respectively.
*/