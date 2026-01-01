package com.gl.RentWheelz.controller;

import com.gl.RentWheelz.dto.MyBookingRequest;
import com.gl.RentWheelz.dto.MyBookingResponse;
import com.gl.RentWheelz.dto.BookingCancelRequest;
import com.gl.RentWheelz.dto.BookingCancelResponse;

import com.gl.RentWheelz.dto.PackageResponse;
import com.gl.RentWheelz.dto.ReserveRequest;
import com.gl.RentWheelz.dto.ReserveResponse;
import com.gl.RentWheelz.model.Car;
import com.gl.RentWheelz.model.Reservation;
import com.gl.RentWheelz.model.Users;
import com.gl.RentWheelz.service.CarService;
import com.gl.RentWheelz.service.ReservationService;
import com.gl.RentWheelz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ReservationController {
    // auto-wire the reservation service
    @Autowired
    private ReservationService reservationService;

    // auto-wire the car service
    @Autowired
    private CarService carService;

    // auto-wire the user service
    @Autowired
    private UserService userService;

    // create a method @GetMapping to get all reservations
    @GetMapping("/findAllReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.findAllReservations();
    }

    // create a method @GetMapping to get all PackageResponse
    @GetMapping("/findAllPackageResponse")
    public PackageResponse getAllPackages() {
        // fetch all the cars from the database
        List<Car> allCars = carService.findAllCars();

        // create a new PackageResponse
        PackageResponse packageResponse = new PackageResponse();
        packageResponse.setStatus("success");
        packageResponse.setResults(allCars.size());
        PackageResponse.PackageData packageData = new PackageResponse.PackageData();

        // convert the list of cars to a list of package data
        List<PackageResponse.Car> packageCars = allCars.stream().map(car -> {
            PackageResponse.Car packageCar = new PackageResponse.Car();
            packageCar.setId(car.getCarId());
            packageCar.setModel(car.getCarModel());
            packageCar.setBrand(car.getBrand());
            if (car.getCarAvailability()) {
                packageCar.setStatus("AVAILABLE");
            } else {
                packageCar.setStatus("UNAVAILABLE");
            }
            packageCar.setRegistrationNumber(car.getRegistrationNumber());
            packageCar.setPricePerHour(car.getPricePerHour());
            packageCar.setThumbnail(car.getThumbnail());
            return packageCar;
        }).collect(Collectors.toList());

        // set the package data
        packageData.setCars(packageCars);

        packageResponse.setData(packageData);
        return packageResponse;
    }

    // create a method @PostMapping to reserve a car
    @PostMapping("/reserve")
    public ReserveResponse reserveCar(@RequestBody ReserveRequest reserveRequest) {

        // fetch the user by id
        Users user = userService.findId(reserveRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("found user = " + user);

        // fetch the car by id
        Car car = carService.findId(reserveRequest.getCarId()).orElseThrow(() -> new RuntimeException("Car not found"));
        System.out.println("found car = " + car);


        // create a new reservation
        Reservation reservation = new Reservation();
        reservation.setUserEmail(user.getUserEmail());
        reservation.setCarID(car.getCarId());
        reservation.setReservationDate(Instant.now());
        reservation.setPickupDate(reserveRequest.getPickupDate());
        reservation.setReturnDate(reserveRequest.getReturnDate());
        reservation.setNumOfTravellers(reserveRequest.getNumOfTravellers());
        reservation.setStatus("PENDING");
        reservation.setCar(car);
        reservation.setImg(car.getThumbnail());
        // calculate the total using the Java 8 Date and Time API class -Instant
        long hours = (reserveRequest.getReturnDate().toEpochMilli() - reserveRequest.getPickupDate().toEpochMilli()) / 3600000;
        reservation.setTotal(hours * car.getPricePerHour());
        System.out.println("created reservation = " + reservation);

        // save the reservation
        Reservation savedReservation = reservationService.saveReservation(reservation);
        System.out.println("savedReservation = " + savedReservation);

        // set the car as unavailable
        car.setCarAvailability(false);
        carService.saveCar(car);

        // create a new ReserveResponse
        ReserveResponse reserveResponse = new ReserveResponse();
        reserveResponse.setStatus("success");
        reserveResponse.setMessage("Reservation successful");
        ReserveResponse.ReserveData reserveData = new ReserveResponse.ReserveData();
        reserveData.setBookingId(savedReservation.getBookingId().toString());
        reserveData.setUserEmail(savedReservation.getUserEmail());
        reserveResponse.setData(reserveData);
        return reserveResponse;
    }

    // create a method @PostMapping to book my car with input as MyBookingRequest and output as MyBookingResponse
    @PostMapping("/myBookings")
    public MyBookingResponse myBookings(@RequestBody MyBookingRequest myBookingRequest) {
        // fetch the user by userEmail
        Users user = userService.findByUserEmail(myBookingRequest.getUserEmail());

        System.out.println("found user = " + user);

        // fetch all the reservations by user email
        List<Reservation> reservations = reservationService.findByUserEmail(user.getUserEmail());
        System.out.println("reservations = " + reservations);

        // create a new MyBookingResponse
        MyBookingResponse myBookingResponse = new MyBookingResponse();
        myBookingResponse.setStatus("success");
        MyBookingResponse.MyBookingData myBookingData = new MyBookingResponse.MyBookingData();

        // convert the list of reservations to a list of my booking
        List<MyBookingResponse.MyBooking> myBookings = reservations.stream().map(reservation -> {
            MyBookingResponse.MyBooking myBooking = new MyBookingResponse.MyBooking();
            myBooking.setBookingId(reservation.getBookingId());
            myBooking.setUserEmail(reservation.getUserEmail());
            myBooking.setCarId(reservation.getCarID());
            myBooking.setReservationDate(reservation.getReservationDate().toString());
            myBooking.setPickupDate(reservation.getPickupDate());
            myBooking.setReturnDate(reservation.getReturnDate());
            myBooking.setNumOfTravellers(reservation.getNumOfTravellers());
            myBooking.setStatus(reservation.getStatus());
            myBooking.setCar(reservation.getCar());
            myBooking.setImg(reservation.getImg());
            myBooking.setTotal(reservation.getTotal());
            return myBooking;
        }).collect(Collectors.toList());

        // set my booking data
        myBookingData.setBookings(myBookings);
        myBookingResponse.setData(myBookingData);
        return myBookingResponse;
    }

    // create a method @PostMapping to cancel a reservation with input as BookingCancelRequest and output as BookingCancelResponse
    @PostMapping("/cancelBooking")
    public BookingCancelResponse cancelBooking(@RequestBody BookingCancelRequest bookingCancelRequest) {
        // fetch the reservation by bookingId
        Reservation reservation = reservationService.findById(bookingCancelRequest.getBookingId()).orElseThrow(() -> new RuntimeException("Reservation not found"));
        System.out.println("found reservation = " + reservation);

        // fetch the car by carId
        Car car = carService.findId(reservation.getCarID()).orElseThrow(() -> new RuntimeException("Car not found"));
        System.out.println("found car = " + car);

        // set the car as available
        car.setCarAvailability(true);
        carService.saveCar(car);

        // delete the reservation
        reservationService.updateStatus(bookingCancelRequest.getBookingId(), "CANCELLED");
        Reservation updatedReservation = reservationService.findById(bookingCancelRequest.getBookingId()).orElseThrow(() -> new RuntimeException("Reservation not found"));
        System.out.println("updatedReservation = " + updatedReservation);


        // create a new BookingCancelResponse
        BookingCancelResponse bookingCancelResponse = new BookingCancelResponse();
        bookingCancelResponse.setStatus("success");
        bookingCancelResponse.setMessage("Reservation cancelled");
        return bookingCancelResponse;

    }
}
