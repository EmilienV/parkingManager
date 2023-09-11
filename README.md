# Parking Manager
Parking Manager is a simple RESTful API for managing a parking lot of cars. It allows you to create a parking lot, add cars to it, remove cars from it, and list the cars currently parked.

## Usage

### Adding a Car
To add a car to the parking lot, make a POST request to /parking/add with a JSON body containing the car's details:


curl -X POST -H "Content-Type: application/json" -d '{"licensePlate": "ABC123", "model": "Model X", "brand": "Tesla"}' http://localhost:8080/parking/add

### Removing a Car

To remove a car from the parking lot, make a DELETE request to /parking/remove/{id} where {id} is the ID of the car you want to remove.


curl -X DELETE http://localhost:8080/parking/remove/1

### Listing Cars

To list all the cars currently parked in the lot, make a GET request to /parking/list.


curl http://localhost:8080/parking/list

## Configuration

You can configure the application by modifying the application.properties file. Here are some of the available configurations:

spring.datasource.url: Database URL

spring.datasource.driverClassName: Database driver class name

spring.datasource.username: Database username

spring.datasource.password: Database password

spring.jpa.database-platform: Database platform

spring.jpa.show-sql: Enable SQL query logging
