package com.gl.RentWheelz.model;
/* create a spring data jps class Car with the following fields:
{
 carID: 1,
 carModel: "Honda City",
 registrationNumber: "KA-01-1234",
 carAvailability: "true",
 brand: "Sedan",
 pricePerHour: 500
 thumbnail:"https://www.google.com"
}
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long carId;

    // add colmun constraints as required
    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @Column(nullable = false)
    private Boolean carAvailability;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int pricePerHour;

    @Column(nullable = false)
    private String thumbnail;
}
