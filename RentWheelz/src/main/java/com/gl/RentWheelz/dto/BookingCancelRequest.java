package com.gl.RentWheelz.dto;
/* create a BookingCancelRequest with the following fields:
{
 "bookingId": 103
}
 */
import lombok.Data;

@Data
public class BookingCancelRequest {
    private Long bookingId;
}
