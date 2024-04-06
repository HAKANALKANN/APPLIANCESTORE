package com.finalProject.applianceStore.applianceStore.business.abstracts;


import com.finalProject.applianceStore.applianceStore.dtos.requests.user.CreateUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.DeleteUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.GetUserByIdRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.UpdateUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.user.*;

import java.util.List;

public interface UserService {
    CreateUserResponse registerUser(CreateUserRequest request) throws Exception;

    DeleteUserResponse delete(DeleteUserRequest request);
    List<GetAllUserResponse> getAll();

    List<GetUserByIdResponse> getUserById(GetUserByIdRequest request);

UpdateUserResponse updateUser(UpdateUserRequest request) throws Exception;
}
