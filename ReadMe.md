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

Here are some sample accounts to run our Program
### Landlord Accounts
```
U: landlord@gmail.com   P: password
U: landlord1@yahoo.com  P: pass
```


### Manager Accounts
```
U: manager@gmail.com    P: pass
U: manager2@example.com P: dog

```

### Registered Renter Accounts
```
U: coolio123@gmail.com  P: hi
U: epicgamer@shaw.ca    P: 123
```
Note: You can make your own renter accounts as well

This project was built using maven
