-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files

-- Using command line, navigate to assessment_template directory, followed by database:
-- For localhost >> mysql -u Fred -p northwind < create.sql

CREATE DATABASE IF NOT EXISTS brewery;
USE brewery
-- Run the commands below one by one in command line
source C:/Users/Hp/TFIP_Feb23/PAF/assessment_template/database/beers.sql
source C:/Users/Hp/TFIP_Feb23/PAF/assessment_template/database/breweries.sql
source C:/Users/Hp/TFIP_Feb23/PAF/assessment_template/database/categories.sql
source C:/Users/Hp/TFIP_Feb23/PAF/assessment_template/database/geocodes.sql
source C:/Users/Hp/TFIP_Feb23/PAF/assessment_template/database/styles.sql

SHOW tables; -- should see 5 tables in database brewery