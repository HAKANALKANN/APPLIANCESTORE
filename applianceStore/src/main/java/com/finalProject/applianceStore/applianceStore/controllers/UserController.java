package com.finalProject.applianceStore.applianceStore.controllers;

import com.finalProject.applianceStore.applianceStore.business.abstracts.UserService;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.DeleteUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.UpdateUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.user.DeleteUserResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.user.GetAllUserResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.user.UpdateUserResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@SecurityRequirement(name = "applianceStore Application")
public class UserController {
    private UserService userService;


    @DeleteMapping()
    public DeleteUserResponse delete(@RequestBody @Valid DeleteUserRequest request){
        return userService.delete(request);
    }
    @GetMapping()
    public ResponseEntity<List<GetAllUserResponse>> getAll(){return ResponseEntity.ok(this.userService.getAll());}
    @PutMapping
    public UpdateUserResponse updateUser(@RequestBody @Valid UpdateUserRequest request) throws Exception {
        UpdateUserResponse updateUserResponse = userService.updateUser(request);
        return updateUserResponse;
    }
}
