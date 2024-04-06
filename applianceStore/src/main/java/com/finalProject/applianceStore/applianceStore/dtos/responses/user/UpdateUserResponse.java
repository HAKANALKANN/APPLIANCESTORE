package com.finalProject.applianceStore.applianceStore.dtos.responses.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String street;
    private String buildingName;
    private String city;
    private String state;
    private String country;
    private String pincode;
    private String userRole;
}
