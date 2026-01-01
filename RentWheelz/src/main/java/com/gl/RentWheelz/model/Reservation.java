package com.gl.RentWheelz.model;
/* create a spring data jpa entity class Reservation with the following fields:
  Long bookingId:
  String userEmail
  Long carID
  Date reservationDate
  Date pickupDate
  Date returnDate
  Number numOfTravellers
  String status
  Car car
  String img
  Number total
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long bookingId;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = false, unique = true)
    private Long carID;

    @Column(nullable = false)
    private Instant reservationDate;

    @Column(nullable = false)
    private Instant pickupDate;

    @Column(nullable = false)
    private Instant returnDate;

    @Column(nullable = false)
    private Integer numOfTravellers;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "carID", insertable = false, updatable = false)
    private Car car;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private Long total;
}
