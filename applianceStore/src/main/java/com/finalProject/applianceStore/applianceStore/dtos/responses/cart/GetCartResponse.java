package com.finalProject.applianceStore.applianceStore.dtos.responses.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartResponse {
    private Integer cartId;
    private Integer productId;
    private Integer quantity;
}
