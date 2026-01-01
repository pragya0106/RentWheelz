package com.gl.RentWheelz.dto;
/* create a LoginResponse with the following fields:
{
 status: 'success',
 message: "Login successful",
 data: {
 userName: "krishna",
 userEmail: "krishna@abc.com",
 proofId: "U101"
    }
}
 */

import lombok.Data;

@Data
public class LoginResponse {
    private String status;
    private String message;
    private UserData data;

    @Data
    public static class UserData {
        private String userName;
        private String userEmail;
        private String proofId;
    }
}
