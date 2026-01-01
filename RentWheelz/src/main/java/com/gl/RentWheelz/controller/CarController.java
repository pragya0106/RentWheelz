package com.gl.RentWheelz.controller;

import com.gl.RentWheelz.model.Car;
import com.gl.RentWheelz.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    // auto-wire the car service
    @Autowired
    private CarService carService;

    // create a method @PostMapping to save a car
    @PostMapping("/saveCar")
    public Car saveCar(@RequestBody Car car) {
       return carService.saveCar(car);
    }

    // create a method @GetMapping to find all cars
    @GetMapping("/findAllCars")
    public Iterable<Car> findAllCars() {
        return carService.findAllCars();
    }

}
