package com.example.parkingmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private CarRepository carRepository;

    @PostMapping("/create")
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @PostMapping("/add")
    public Car addCar(@RequestBody Car car) {
        return carRepository.save(car);
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
