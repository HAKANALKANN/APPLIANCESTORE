package com.finalProject.applianceStore.applianceStore.dtos.requests.Cart;

import com.finalProject.applianceStore.applianceStore.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductToCartRequest {
    private Integer userId;
    private Integer productId;
    private Integer quantity;

}
