package com.finalProject.applianceStore.applianceStore.dtos.requests.user;

import com.finalProject.applianceStore.applianceStore.dtos.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private AddressDTO address;

}
