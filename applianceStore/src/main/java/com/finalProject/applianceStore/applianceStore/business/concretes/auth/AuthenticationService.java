package com.finalProject.applianceStore.applianceStore.business.concretes.auth;


import com.finalProject.applianceStore.applianceStore.dataaccess.AddressRepository;
import com.finalProject.applianceStore.applianceStore.dataaccess.UserRepository;
import com.finalProject.applianceStore.applianceStore.dtos.auth.LoginDTO;
import com.finalProject.applianceStore.applianceStore.dtos.auth.SignUpRequest;
import com.finalProject.applianceStore.applianceStore.dtos.auth.SigninRequest;
import com.finalProject.applianceStore.applianceStore.entities.Address;
import com.finalProject.applianceStore.applianceStore.entities.Cart;
import com.finalProject.applianceStore.applianceStore.entities.User;
import com.finalProject.applianceStore.applianceStore.enums.Role;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthenticationService {
    private final UserRepository userRepository ;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtManager jwtManager ;
    private final AuthenticationManager authenticationManager;


    public AuthenticationService(UserRepository userRepository, AddressRepository addressRepository, PasswordEncoder passwordEncoder, JwtManager jwtManager, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtManager = jwtManager;
        this.authenticationManager = authenticationManager;
    }

    public LoginDTO signup( SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .roles(Role.ROLE_ADMIN.name()).build();
        var address = Address.builder()
                .street(request.getStreet()).city(request.getCity()).buildingName(request.getBuildingName())
                .state(request.getState()).country(request.getCountry()).pincode(request.getPincode())
                .build();
        address = addressRepository.save(address);
        user.setAddress(address);
        user.setCart(new Cart());
        userRepository.save(user);
        var jwt = jwtManager.generateToken(user);
        return LoginDTO.builder().fullName(user.getFullName()).token(jwt).build();
    }

    public LoginDTO signin(SigninRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), request.getPassword()));

        var jwt = jwtManager.generateToken(user);
        return LoginDTO.builder().fullName(user.getFullName()).token(jwt).build();
    }

}
