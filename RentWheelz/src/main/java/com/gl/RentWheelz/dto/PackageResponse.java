package com.gl.RentWheelz.dto;
/* create a PackageRespone with the following fields:
{
 "status": "success",
 "results": 4,
 "data": {
 "cars": [
 {
 id: "C101",
 model: "E220",
 brand: "Mercedes",
 status: "AVAILABLE",
 registrationNumber: "MH-01-AB-1234",
 pricePerHour: 200,
 thumbnail: "/car-3.jpg",
 },
 . . .
 ]
 }
}
 */
import lombok.Data;

import java.util.List;

@Data
public class PackageResponse {
    private String status;
    private int results;
    private PackageData data;

    @Data
    public static class PackageData {
        private List<Car> cars;
    }

    @Data
    public static class Car {
        private Long id;
        private String model;
        private String brand;
        private String status;
        private String registrationNumber;
        private int pricePerHour;
        private String thumbnail;
    }
}
