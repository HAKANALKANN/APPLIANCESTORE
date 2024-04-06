package com.finalProject.applianceStore.applianceStore.dtos;

import lombok.Data;

@Data
public class AddressDTO {
    private String street;
    private String buildingName;
    private String city;
    private String state;
    private String country;
    private String pincode;
}
