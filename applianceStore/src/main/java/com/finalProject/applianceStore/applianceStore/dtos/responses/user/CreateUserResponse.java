package com.finalProject.applianceStore.applianceStore.dtos.responses.user;

import com.finalProject.applianceStore.applianceStore.dtos.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private Integer userId;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private AddressDTO addressDTO;


}
