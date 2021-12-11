# ENSF_480_Final_Project
Property Management System

Go to the directory with propertyms-1.0-SNAPSHOT.jar and run the following command

## Run the Program:
```
java -cp propertyms-1.0-SNAPSHOT.jar ensf480.view.MainFrame
```


Using the Database: You will need to install MySQL on your system and create a new user

Enter the following command to make the appropriate user in MySQL command line client:

```
CREATE USER 'propertyms'@'localhost'
  IDENTIFIED BY 'ensf480';
GRANT ALL
  ON *.*
  TO 'propertyms'@'localhost'
  WITH GRANT OPTION;
```
Next you can download the schema onto your system using the following command on the MySQL command line client

```
source <full path to propertyms.sql>
```
This project was built using maven
