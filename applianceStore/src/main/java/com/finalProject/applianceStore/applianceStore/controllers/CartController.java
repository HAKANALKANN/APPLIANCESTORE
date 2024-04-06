package com.finalProject.applianceStore.applianceStore.controllers;

import com.finalProject.applianceStore.applianceStore.business.abstracts.CartService;
import com.finalProject.applianceStore.applianceStore.dtos.requests.Cart.*;
import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.AddProductToCartResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.DeleteProductFromCartResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.GetCartResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.UpdateProductInCartResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
@AllArgsConstructor
public class CartController {
    CartService cartService;
    @PostMapping
    public ResponseEntity<AddProductToCartResponse> addProductToCart(@RequestBody   @Valid AddProductToCartRequest request) throws Exception {
        AddProductToCartResponse addProductToCartResponse = cartService.addProductToCart(request);
return ResponseEntity.ok(addProductToCartResponse);
    }
    @GetMapping
    public ResponseEntity<GetCartResponse> getCart(@RequestBody @Valid GetCartRequest request) throws Exception {
        GetCartResponse getCartResponse = cartService.getCarts(request);
        return ResponseEntity.ok(getCartResponse);
    }
    @DeleteMapping
    public ResponseEntity<DeleteProductFromCartResponse> deleteProductFromCart(@RequestBody @Valid DeleteProductFromCartRequest request) throws Exception {
        DeleteProductFromCartResponse deleteProductFromCartResponse = cartService.deleteProductFromCart(request);
        return ResponseEntity.ok(deleteProductFromCartResponse);
    }
    @PostMapping("/public")
    public ResponseEntity<UpdateProductInCartResponse> updateProductInCart(@RequestBody @Valid UpdateProductInCartRequest request) throws Exception {
           UpdateProductInCartResponse updateProductInCartResponse = cartService.updateProductInCart(request);
        return ResponseEntity.ok(updateProductInCartResponse);
    }

}
