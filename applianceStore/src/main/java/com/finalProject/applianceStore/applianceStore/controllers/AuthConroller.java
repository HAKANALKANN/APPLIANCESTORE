package com.finalProject.applianceStore.applianceStore.controllers;

import com.finalProject.applianceStore.applianceStore.business.concretes.auth.AuthenticationService;
import com.finalProject.applianceStore.applianceStore.dtos.auth.LoginDTO;
import com.finalProject.applianceStore.applianceStore.dtos.auth.SignUpRequest;
import com.finalProject.applianceStore.applianceStore.dtos.auth.SigninRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
public class AuthConroller {

    private final AuthenticationService authenticationService;

    public AuthConroller(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginDTO> signup(@RequestBody @Valid SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> signin(@RequestBody @Valid SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));

    }


}
