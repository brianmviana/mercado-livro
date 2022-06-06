CREATE TABLE customer (
  id int auto_increment PRIMARY KEY,
  name varchar(255) NOT NULL,
  email varchar(255) NOT NULL UNIQUE
);