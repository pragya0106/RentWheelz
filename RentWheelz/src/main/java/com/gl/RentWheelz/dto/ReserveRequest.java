package com.gl.RentWheelz.dto;
/* create a ReserveResponse with the following fields:
{
 pickupDate: "2023-11-30",
 returnDate: "2023-12-01",
 numOfTravellers: 4,
 carId: "103"
}
 */

import lombok.Data;

import java.time.Instant;

@Data
public class ReserveRequest {
    private Instant pickupDate;
    private Instant returnDate;
    private int numOfTravellers;
    private Long carId;
    private Long userId;
}
