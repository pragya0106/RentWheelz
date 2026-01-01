package com.gl.RentWheelz.util;
// create a class LoadInitialData using command line runner

import com.gl.RentWheelz.model.Car;
import com.gl.RentWheelz.model.Users;
import com.gl.RentWheelz.service.CarService;
import com.gl.RentWheelz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadInitialData implements CommandLineRunner {
    @Autowired
    private UserService userService;

    // auto wire the CarService class
    @Autowired
    private CarService carService;

    @Override
    public void run(String... args) throws Exception {
        Users user1 = new Users();
        user1.setUserName("John");
        user1.setUserEmail("John@gmail.com");
        user1.setUserPassword("John123");
        user1.setProofId("Aadhar1");
        userService.saveUser(user1);

        Users user2 = new Users();
        user2.setUserName("Smith");
        user2.setUserEmail("Smith@gmail.com");
        user2.setUserPassword("Smith123");
        user2.setProofId("Aadhar2");
        userService.saveUser(user2);

        Users user3 = new Users();
        user3.setUserName("Raj");
        user3.setUserEmail("Raj@gmail.com");
        user3.setUserPassword("Raj123");
        user3.setProofId("Aadhar3");
        userService.saveUser(user3);

        // add more users
        Users user4 = new Users();
        user4.setUserName("Rahul");
        user4.setUserEmail("Rahul@gmail.com");
        user4.setUserPassword("Rahul123");
        user4.setProofId("Aadhar4");
        userService.saveUser(user4);

        Users user5 = new Users();
        user5.setUserName("Ravi");
        user5.setUserEmail("Ravi@gmail.com");
        user5.setUserPassword("Ravi123");
        user5.setProofId("Aadhar5");
        userService.saveUser(user5);

        System.out.println("Users saved successfully...");

        // get all users
        Iterable<Users> users = userService.findAllUsers();
        for (Users user : users) {
            System.out.println(user);
        }

        // create a car object
        Car car1 = new Car();
        car1.setCarModel("Audi");
        car1.setBrand("Audi");
        car1.setRegistrationNumber("KA-01-1234");
        car1.setPricePerHour(1000);
        car1.setCarAvailability(true);
        car1.setThumbnail("audi.jpg");
        carService.saveCar(car1);

        Car car2 = new Car();
        car2.setCarModel("BMW");
        car2.setBrand("BMW");
        car2.setRegistrationNumber("KA-01-1235");
        car2.setPricePerHour(2000);
        car2.setCarAvailability(true);
        car2.setThumbnail("bmw.jpg");
        carService.saveCar(car2);

        Car car3 = new Car();
        car3.setCarModel("Benz");
        car3.setBrand("Benz");
        car3.setRegistrationNumber("KA-01-1236");
        car3.setPricePerHour(3000);
        car3.setCarAvailability(true);
        car3.setThumbnail("benz.jpg");
        carService.saveCar(car3);

        // add more cars
        Car car4 = new Car();
        car4.setCarModel("Ferrari");
        car4.setBrand("Ferrari");
        car4.setRegistrationNumber("KA-01-1237");
        car4.setPricePerHour(4000);
        car4.setCarAvailability(true);
        car4.setThumbnail("ferrari.jpg");
        carService.saveCar(car4);

        Car car5 = new Car();
        car5.setCarModel("Lamborghini");
        car5.setBrand("Lamborghini");
        car5.setRegistrationNumber("KA-01-1238");
        car5.setPricePerHour(5000);
        car5.setCarAvailability(true);
        car5.setThumbnail("lamborghini.jpg");
        carService.saveCar(car5);

        // add more cars
        Car car6 = new Car();
        car6.setCarModel("Rolls Royce");
        car6.setBrand("Rolls Royce");
        car6.setRegistrationNumber("KA-01-1239");
        car6.setPricePerHour(6000);
        car6.setCarAvailability(true);
        car6.setThumbnail("rollsroyce.jpg");
        carService.saveCar(car6);

        Car car7 = new Car();
        car7.setCarModel("Jaguar");
        car7.setBrand("Jaguar");
        car7.setRegistrationNumber("KA-01-1240");
        car7.setPricePerHour(7000);
        car7.setCarAvailability(true);
        car7.setThumbnail("jaguar.jpg");
        carService.saveCar(car7);

        System.out.println("Cars saved successfully...");
        // get all cars
        Iterable<Car> cars = carService.findAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }

    }
}