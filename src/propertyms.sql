DROP DATABASE IF EXISTS PROPERTYMS;
CREATE DATABASE PROPERTYMS; 
USE PROPERTYMS;

CREATE TABLE Property(
    pid int,
    status varchar(255),
    type varchar(255),
    address varchar(255),
    quadrant varchar(2),
    bedrooms int,
    bathrooms int,
    isFurnished int
);


INSERT INTO Property(pid, status, type, address, quadrant, bedrooms, bathrooms, isFurnished)
VALUES (1, "Active", "Apartment", "centre street", "NE", 2, 2, 1);