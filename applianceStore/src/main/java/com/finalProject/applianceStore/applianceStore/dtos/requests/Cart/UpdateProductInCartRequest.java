package com.finalProject.applianceStore.applianceStore.dtos.requests.Cart;

import com.finalProject.applianceStore.applianceStore.dtos.responses.cart.GetCartResponse;
import com.finalProject.applianceStore.applianceStore.entities.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductInCartRequest {
    private GetCartResponse getCartResponse;
    private Integer productId;
    private String productName;
    private String image;
    private String description;
    private Integer quantity;
    private double price;
    private double discount;
    private double specialPrice;
}
