package com.finalProject.applianceStore.applianceStore.dtos.auth;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class LoginDTO {
    private String token;
    private String fullName;
}
