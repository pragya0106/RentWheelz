package com.gl.RentWheelz.dto;
/* create a LoginRequest with the following fields:
{
 userEmail: "krishna@abc.com",
 userPassword: "krishna@123",
}
 */

import lombok.Data;

@Data
public class LoginRequest {
    private String userEmail;
    private String userPassword;
}
