DROP DATABASE IF EXISTS PROPERTYMS;
CREATE DATABASE PROPERTYMS; 
USE PROPERTYMS;

CREATE TABLE Property(
    pid int AUTO_INCREMENT,
    status varchar(255),
    type varchar(255),
    address varchar(255),
    quadrant varchar(2),
    bedrooms int,
    bathrooms int,
    isFurnished bit,
    ownerId int,

    PRIMARY KEY (pid)
);


INSERT INTO Property(status, type, address, quadrant, bedrooms, bathrooms, isFurnished, ownerId)
VALUES ("Active", "Apartment", "centre street", "NE", 2, 2, 1, 1);