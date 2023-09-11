package com.example.parkingmanager.controllers;

import com.example.parkingmanager.models.Car;
import com.example.parkingmanager.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private CarRepository carRepository;

    private static final int MAX_PARKING_SIZE = 5;

    @PostMapping("/add")
    public ResponseEntity<Object> addCar(@RequestBody Car car) {
        System.out.println("Received request to add car: " + car.toString());

        long currentParkingSize = carRepository.count();

        if (currentParkingSize >= MAX_PARKING_SIZE) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Parking is full. Cannot add more cars.");
        }

        Car savedCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @DeleteMapping("/remove/{id}")
    public void removeCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }

    @GetMapping("/list")
    public List<Car> listCars() {
        return carRepository.findAll();
    }
}
