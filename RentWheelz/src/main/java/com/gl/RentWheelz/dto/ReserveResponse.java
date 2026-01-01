package com.gl.RentWheelz.dto;

/* create a ReserveResponse with the following fields:
{
 status:"success",
 message:"Reservation successful",
 data:{
 bookingId:"B103",
 userEmail:"krishna@abc.com
}
 */
import lombok.Data;

@Data
public class ReserveResponse {
    private String status;
    private String message;
    private ReserveData data;

    @Data
    public static class ReserveData {
        private String bookingId;
        private String userEmail;
    }
}
