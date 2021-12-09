DROP DATABASE IF EXISTS PROPERTYMS;
CREATE DATABASE PROPERTYMS; 
USE PROPERTYMS;

CREATE TABLE Landlord(
    lid int AUTO_INCREMENT,
    username varchar(255) UNIQUE,
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
    listDate varchar(255),
    rentDate varchar(255), 

    PRIMARY KEY (pid),
    FOREIGN KEY (ownerId) REFERENCES Landlord (lid)

);


CREATE TABLE Manager(
    mid int AUTO_INCREMENT,
    username varchar(255) UNIQUE,
    password varchar(255),
    fname varchar(255),
    lname varchar(255),

    PRIMARY KEY (mid)
);

CREATE TABLE Registered_Renter(
    rid int AUTO_INCREMENT,
    username varchar(255)  UNIQUE,
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


INSERT INTO Property(status, type, address, quadrant, bedrooms, bathrooms, isFurnished, ownerId, listDate, rentDate)
VALUES ("Active", "Apartment", "centre street", "NE", 2, 2, 1, 1, "2021-12-08", NULL),
        ("Active", "Attached_house", "University dr.", "NW", 2, 2, 1, 2, "2021-12-08", NULL ),
        ("Rented", "Attached_house", "Bowness dr.", "SW", 2, 2, 1, 3, NULL, "2021-12-08"),
        ("Active", "Attached_house", "Panorama Hills dr.", "NW", 2, 2, 1, 2, "2021-12-08", NULL),
        ("Active", "Attached_house", "Charleswood dr.", "NW", 2, 2, 1, 2, "2021-12-08", NULL),
        ("Active", "Attached_house", "Brentwood dr.", "NW", 2, 2, 1, 2, "2021-12-08", NULL);

INSERT INTO Registered_Renter(username, password, fname, lname)
VALUES ('coolio123', 'hi', 'Michael', 'Hans');

INSERT INTO Search_Criteria(rid, type, quadrant, bedrooms, bathrooms, isFurnished)
VALUES (1, NULL, "NW", -1, -1, NULL);

INSERT INTO Manager(username, password, fname, lname)
VALUES ('manager', 'pass', 'Bob', 'Moore');