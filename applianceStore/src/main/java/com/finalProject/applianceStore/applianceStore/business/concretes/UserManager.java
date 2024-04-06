package com.finalProject.applianceStore.applianceStore.business.concretes;

import com.finalProject.applianceStore.applianceStore.business.abstracts.UserService;
import com.finalProject.applianceStore.applianceStore.core.utilities.mapping.ModelMapperService;
import com.finalProject.applianceStore.applianceStore.dataaccess.AddressRepository;
import com.finalProject.applianceStore.applianceStore.dataaccess.UserRepository;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.CreateUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.DeleteUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.GetUserByIdRequest;
import com.finalProject.applianceStore.applianceStore.dtos.requests.user.UpdateUserRequest;
import com.finalProject.applianceStore.applianceStore.dtos.responses.user.*;
import com.finalProject.applianceStore.applianceStore.entities.Address;
import com.finalProject.applianceStore.applianceStore.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
  private   UserRepository userRepository;
   private ModelMapperService modelMapperService;
    private AddressRepository addressRepository ;

   @Override
    public CreateUserResponse registerUser(CreateUserRequest request) {
        User user = modelMapperService.forRequest().map(request,User.class);
        User createUser = userRepository.save(user);

        CreateUserResponse createUserResponse =
                modelMapperService.forResponse().map(createUser,CreateUserResponse.class);
        return createUserResponse;
    }



    @Override
    public DeleteUserResponse delete(DeleteUserRequest request) {
        User userToDelete = modelMapperService.forRequest().map(request,User.class);
        userRepository.delete(userToDelete);

        DeleteUserResponse response = modelMapperService.forResponse().map(userToDelete,DeleteUserResponse.class);
        return response;
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> result = users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<GetUserByIdResponse> getUserById(GetUserByIdRequest request) {
        Optional<User> users = userRepository.findById(request.getUserId());
       List<GetUserByIdResponse> result = users.stream().map(user -> this.modelMapperService.forResponse().map(user, GetUserByIdResponse.class)).collect(Collectors.toList());
        return result;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest request) throws Exception {
      User user = userRepository.findById(request.getUserId()).orElseThrow(()->new Exception("User not found"));
      user.setFirstName(request.getFirstName());
      user.setLastName(request.getLastName());
      user.setEmail(request.getEmail());
      user.setPassword(request.getPassword());
      user.setRoles(request.getUserRole());

        Address address = new Address();
        address.setState(request.getState());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setPincode(request.getPincode());
        address.setBuildingName(request.getBuildingName());
        address.setCountry(request.getCountry());
        addressRepository.save(address);
        user.setAddress(address);
        userRepository.save(user);

        UpdateUserResponse updateUserResponse = modelMapperService.forResponse().map(user, UpdateUserResponse.class);

        return updateUserResponse;
    }
}
