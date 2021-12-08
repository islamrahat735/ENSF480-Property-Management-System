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

CREATE TABLE Landlord(
    lid int AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (username)
);

CREATE TABLE Manager(
    mid int AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (username)
);

CREATE TABLE Registered_Renter(
    rid int AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (username)
);

Create Table Search_Criteria(
    rid int,
    type varchar(255),
    quadrant varchar(2),
    bedrooms int,
    bathrooms int,
    isFurnished varchar(1),

    FOREIGN KEY (rid) REFERENCES Registered_Renter(rid)
)

Create Table Fee(
    fee int,
    durationInDays int
)


INSERT INTO Property(status, type, address, quadrant, bedrooms, bathrooms, isFurnished, ownerId)
VALUES ("Active", "Apartment", "centre street", "NE", 2, 2, 1, 1);