package com.gl.RentWheelz.dto;
/* create a BookingCancelResponse with the following fields:
{
 "status": "success",
 "message": "Booking cancelled successfully"
}
 */
import lombok.Data;

@Data
public class BookingCancelResponse {
    private String status;
    private String message;
}
