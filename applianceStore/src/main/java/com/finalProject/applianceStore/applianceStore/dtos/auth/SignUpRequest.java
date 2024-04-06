package com.finalProject.applianceStore.applianceStore.dtos.auth;




import com.finalProject.applianceStore.applianceStore.dtos.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

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
}