package com.gl.RentWheelz.service;

import com.gl.RentWheelz.model.Car;
import com.gl.RentWheelz.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    // auto-wire the car repository
    @Autowired
    private CarRepository carRepository;

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Optional<Car> findId(Long carId) {
        return carRepository.findById(carId);
    }
}
