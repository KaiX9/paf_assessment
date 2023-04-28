-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files

-- Using command line, navigate to assessment_template directory, followed by database:
-- For localhost >> mysql -u Fred -p northwind < create.sql

CREATE DATABASE IF NOT EXISTS brewery;
USE brewery
-- Run the commands below one by one in command line
mysql -u Fred -p brewery < beers.sql
mysql -u Fred -p brewery < breweries.sql
mysql -u Fred -p brewery < categories.sql
mysql -u Fred -p brewery < geocodes.sql
mysql -u Fred -p brewery < styles.sql

SHOW tables; -- should see 5 tables in database brewery
