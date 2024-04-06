package com.finalProject.applianceStore.applianceStore.dtos.requests.cartItem;

import com.finalProject.applianceStore.applianceStore.entities.Cart;
import com.finalProject.applianceStore.applianceStore.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemRequest {
    private Integer cartItemId;
    private Cart cart;
    private Product product;
    private Integer quantity;
    private double discount;
    private double productPrice;
}
