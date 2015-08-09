# SQL Cheat Sheet #

- CRUD: Create, Read, Update, Delete
- In SQL: Create/Insert, Select, Update, Delete

- Difference between some database implementations:
  - DDL: Data Definition Language: Deals with create/modify tables and databases, basically dealing with schema, like create and insert.
  - DML: Data Manipulation Language: Deals with CRUD for data.

- Types of Keys
  - Primary, like id: Used to uniquely define each row in a table, can't be null, can't be duplicated.
  - Unique, like email_address or ssn: Similar to primary key, except can be null, unless otherwise specified.
  - Foreign, like id_pointer: Special keys that describe the relationship between data in two tables. Foreign keys also known as reference keys. Can be null, can be duplicated.



## DML Operations ##

### INSERT

    INSERT INTO Movies VALUES("Avatar", 2009); # Order and string quotes matter.
    INSERT INTO Movies(title, year) VALUES("Avatar", 2009); # Same as above.
    INSERT INTO Movies SET title = "Avatar", year = 2009; # Same as above.
    
    INSERT INTO Movies(title, year) VALUES("Avatar", 2009),("Avatar 2", NULL); # Multiple rows at once.

### UPDATE

    UPDATE Movies SET year = 2015; # Updates ALL movies to 2015.
    UPDATE Movies SET year = 2015 WHERE tile = "Avatar 2";
    UPDATE Movies SET year = 2016, title = "Avatar Reloaded" WHERE tile = "Avatar 2";

### [SELECT](http://dev.mysql.com/doc/refman/5.6/en/select.html)

Normalization: Describes the process of setting up a table that contains repeated and redundant data from one column of a table and putting that information ointo another table.

    SELECT * FROM Movies;
    SELECT Movies.title, Movies.year FROM Movies;
    SELECT title, year FROM Movies;
    SELECT title FROM Movies;
    SELECT title as movie_title FROM Movies; # Renames the column for the returned results.
    
    SELECT * FROM Movies WHERE year = 1999; # Other operators: !=, <, <=, >, >=
    
    SELECT * FROM Movies WHERE year != 1999 AND title = "The Matrix";
    SELECT * FROM Movies WHERE year = 1998 OR year = 1999 OR year = 2000;
    
    SELECT * FROM Movies WHERE year BEWTEEN 1998 AND 2000;
    SELECT * FROM Movies WHERE title LIKE "godfather"; # case-insensitive.
    SELECT * FROM Movies WHERE title LIKE "%godfather%"; # The percent sign is the wildcard.
    
    SELECT * FROM Movies ORDER BY year; # Default is ascending.
    SELECT * FROM Movies ORDER BY year ASC; # Same as above.
    SELECT * FROM Movies ORDER BY year DESC; # In descending order.
    SELECT * FROM Movies ORDER BY year ASC, title DESC; # When chaining, order matters.
    
    SELECT * FROM Movies LIMIT 10;
    SELECT * FROM Movies LIMIT 10 OFFSET 0; # Same as above
    SELECT * FROM Movies LIMIT 0, 10; # Same as above
    
    # Dealing with NULL.
    SELECT * FROM Movies WHERE year IS NULL;
    SELECT * FROM Movies WHERE year IS NOT NULL;
    
    # Selecting multiple tables at once.
    SELECT * FROM Movies [INNER] JOIN Genres ON Movies.genre_id = Genres.id; # Returns the intesection of two tables.
    SELECT * FROM Movies [LEFT | RIGHT] OUTER JOIN Genres ON Movies.genre_id = Genres.id; # Returns the left or right table.
    
#### Doing operations on SELECT results

    SELECT COUNT(*) FROM Reviews WHERE movie_id = 1; # Returns the number of rows with movie_id == 1.
    SELECT COUNT(*) as review_count FROM Reviews WHERE movie_id = 1; # Rename returned results.
    SELECT MIN(score), MAX(score) FROM Reviews WHERE movie_id = 1; # Returns one row with two columns, one for min and one for max.
    
    SELECT SUM(score) FROM Reviews; # Returns one row with one column "SUM(score)".
    SELECT SUM(score) + 1 FROM Reviews; # You can do arithmetic on values.
    SELECT SUM(score) / COUNT(score) FROM Reviews; # Returns average of score.
    SELECT AVG(score) FROM Reviews; # Same as above.
    
    SELECT AVG(score) FROM Reviews GROUP BY movie_id; # Returns average score for all movies.
    SELECT IFNULL(AVG(score), 0) FROM Reviews GROUP BY movie_id; # Changes NULL to 0.
    SELECT IFNULL(AVG(score), 0) FROM Reviews GROUP BY movie_id HAVING average > 3; # Returns scores above 3. HAVING is done after grouping and aggregating.
    
    SELECT * FROM Users;
    SELECT first_name, email FROM Users;
    SELECT UPPER(first_name), LOWER(email) FROM Users; # Uppercase all first names and lowercase all emails.
    SELECT CONCAT(first_name, " ", UPPER(last_name)) FROM Users; # Concatenates multiple strings together.
    SELECT SUBSTRING(email, 1, 10) AS partial_email FROM Users; # Returns the first (1-based index).
    SELECT CONCAT(SUBSTRING(email, 1, 10), "...") AS partial_email FROM Users; # Returns the first ten characters of email (SQL has 1-based index).
    
    SELECT username, LENGTH(username) AS username_length FROM users; # Returns the length of each username for each row.

### DELETE

    DELETE FROM Movies; # Removes all rows from table.
    DELETE FROM Movies WHERE title = "Avatar 2" AND year = 2016;



## DDL Operations ##

### Database-level Operations

Don't use `RENAME DATABASE` because it was found to be "dangerous" (could lose data). Instead, back up data and put it into a new database. See MySQL documentation for more info.

#### (CREATE DATABASE)[http://dev.mysql.com/doc/refman/5.6/en/create-database.html]
    CREATE SCHEMA movie_db_1; # Produces error if database already exists.
    CREATE SCHEMA IF NOT EXISTS movie_db_1; # Produces warning if database already exists.
    
    CREATE SCHEMA MoviesDb CHARACTER SET utf8;
    CREATE SCHEMA MoviesDb DEFAULT CHARACTER SET = utf8; # Same as above.
    
    SHOW ENGINES; # Returns a list of engines that can be used for a table.
    CREATE TABLE Actors(name VARCHAR(50)) ENGINE InnoDB;

#### Removing Database

    DROP DATABASE [IF EXISTS] Movies;
    DROP SCHEMA [IF EXISTS] Movies; # Same as above.

### Table-level Operations

#### (CREATE TABLE)[http://dev.mysql.com/doc/refman/5.6/en/create-table.html]

    CREATE TABLE Actors(name VARCHAR(50));
    CREATE TABLE Movies(title VARCHAR(200), year INTEGER);
    
    CREATE TABLE Actors(name VARCHAR(50) NOT NULL); # Requires names in table.
    
    CREATE TABLE Movies(id INTEGER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200) NOT NULL UNIQUE [KEY]);

#### RENAME TABLE

    RENAME TABLE Movies TO Films;
    RENAME TABLE Movies TO Films, Actors TO People;

#### Remove data from table

    DROP TABLE Movies; # Throws error if table doesn't exist.
    DROP TABLE IF EXISTS Movies; # Throws warning if table doesn't exist.
    
    TRANCATE TABLE Movies; # Deletes entire table, then creates a new empty one.
    TRANCATE Movies; # Same as above.

#### Altering columns in table

    ALTER TABLE Movies ADD COLUMN genre VARCHAR(100);
    ALTER TABLE Movies ADD genre VARCHAR(100); # Same as above.
    ALTER TABLE Actors ADD (pob VARCHAR(100), dob DATE); # Add multiple columns at once.
    
    ALTER TABLE Actors CHANGE [COLUMN] pob place_of_birth VARCHAR(100); # Can't have multiple columns.
    ALTER TABLE Actors CHANGE [COLUMN] year year YEAR; # Just alter data type.
    
    ALTER TABLE Actors DROP [COLUMN} dob; # Delete column.
    
    ALTER TABLE Actors ADD id INTEGER AUTO_INCREMENT PRIMARY KEY FIRST; # Insert column as first.
    
    ALTER TABLE Movies ADD genre_id INTEGER NULL, ADD CONSRAINT FOREIGN KEY(genre_id) REFERENCES Genres(id); # Create foreign key pointing to primary key.



## Data Types ##

### String

#### VARCHAR
For short string of characters

#### TEXT
For long names

### Numeric

#### INTEGER
Whole numbers: 1, 42, 2015

#### DECIMAL
Fixed point number, decimal is in only location, like for currency.

#### FLOAT
Floating point, decimal can be anywhere.

### Date and Time

#### DATE

#### TIME

#### DATETIME



## Securing and Maintaining a MySQL Database ##

### How to make queries faster
Create index. It improves performance when reading or searching queries over a certain column.

When writing with index, inserting data also has to update the index. So write time will be a little slower.

    SELECT * FROM Users WHERE last_name = "Goodwin";
    EXPLAIN SELECT * FROM Users WHERE last_name = "Goodwin"; # Returns more info about the query.
    
    CREATE INDEX last_name_idx ON users(last_name); # Adds index.
    EXPLAIN CREATE INDEX last_name_idx ON users(last_name); # Adds index and explains what it did in more detail.
    
    EXPLAIN SELECT * FROM Users WHERE last_name = "Goodwin"; # Returns more info about the query.

### How to make and restore backups

    # Via MySQL Workbench, PhpMyAdmin, 
    1. Find the import/export features
    2. Export interested databases.

    # Via MySQL Workbench, PhpMyAdmin, 
    1. Find the import/export features
    2. Import interested databases.

### Security considerations

#### Setting up multiple users

Only provide the minimum priviledges to users/programs as needed.

    # Read only permission.
    GRANT SELECT ON users_db.* ID user1@'%' IDENTIFIED BY 'password'; # Creates a new user called "user1" that can connect from anywhere, with a password of "password". This user can only read using SELECT.
    FLUSH PRIVILEDGES; # Resets and reloads all priviledges for this database.

    # Read-write permissions.
    GRANT SELECT, INSERT, UPDATE, DELETE ON users_db.* ID user2@'%' IDENTIFIED BY 'password'; # Creates a new user called "user2" that can connect from anywhere, with a password of "password". This user can SELECT, INSERT, UPDATE, and DELETE.
    FLUSH PRIVILEDGES; # Resets and reloads all priviledges for this database.
    
    # DDL permissions.
    GRANT ALTER, CREATE, DROP ON users_db.* ID user3@'%' IDENTIFIED BY 'password'; # Creates a new user called "user3" that can connect from anywhere, with a password of "password". This user can ALTER, CREATE, DROP.
    FLUSH PRIVILEDGES; # Resets and reloads all priviledges for this database.



## Tools

### MySQL Server

### Workbench

### PhpMyAdmin



## Further Resources ##
- teamtreehouse.com
