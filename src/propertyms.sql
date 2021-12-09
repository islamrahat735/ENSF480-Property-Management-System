DROP DATABASE IF EXISTS PROPERTYMS;
CREATE DATABASE PROPERTYMS; 
USE PROPERTYMS;

CREATE TABLE Landlord(
    lid int AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (lid)
);


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

    PRIMARY KEY (pid),
    FOREIGN KEY (ownerId) REFERENCES Landlord (lid)

);


CREATE TABLE Manager(
    mid int AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (mid)
);

CREATE TABLE Registered_Renter(
    rid int AUTO_INCREMENT,
    username varchar(255),
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (rid)
);

Create Table Search_Criteria(
    rid int,
    type varchar(255),
    quadrant varchar(2),
    bedrooms int,
    bathrooms int,
    isFurnished varchar(1),

    FOREIGN KEY (rid) REFERENCES Registered_Renter(rid)
);

Create Table Fee(
    fee int,
    durationInDays int
);


INSERT INTO Fee(fee, durationInDays)
VALUES (50, 60);

INSERT INTO Landlord(username, password, fname, lname)
VALUES ("landlord@gmail.com", "password", "Bob", "Jones"),
        ("landlord1@gmail.com", "pass", "Chris", "Walker"),
        ("landlord2@gmail.com", "idk", "John", "Doe");


INSERT INTO Property(status, type, address, quadrant, bedrooms, bathrooms, isFurnished, ownerId)
VALUES ("Active", "Apartment", "centre street", "NE", 2, 2, 1, 1),
        ("Active", "Attached_house", "University dr.", "NW", 2, 2, 1, 2),
        ("Rented", "Attached_house", "Bowness dr.", "SW", 2, 2, 1, 3);

-- INSERT INTO Registered_Renter()