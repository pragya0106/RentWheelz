package com.gl.RentWheelz.dto;
/* create a MyBookingResponse with the following fields:
{
 "status": "success",
 "data": {
 "bookings": [
 {
 bookingId: "B103",
 userEmail: "krishna@abc.com",
 carId: "C101",
 reservationDate: "2023-11-10",
 pickupDate: "2023-11-30",
 returnDate: "2023-12-01",
 numOfTravellers: 4,
 status: "CONFIRMED",
 car: "Mercedes E220",
 img: "/car-3.jpg",
 total: 1000
 },. . .
 ]
 }
}
 */

import com.gl.RentWheelz.model.Car;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class MyBookingResponse {
    private String status;
    private MyBookingData data;

    @Data
    public static class MyBookingData {
        private List<MyBooking> bookings;
    }

    @Data
    public static class MyBooking {
        private Long bookingId;
        private String userEmail;
        private Long carId;
        private String reservationDate;
        private Instant pickupDate;
        private Instant returnDate;
        private int numOfTravellers;
        private String status;
        private Car car;
        private String img;
        private Long total;
    }
}

