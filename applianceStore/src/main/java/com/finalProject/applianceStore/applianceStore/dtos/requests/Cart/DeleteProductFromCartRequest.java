package com.finalProject.applianceStore.applianceStore.dtos.requests.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProductFromCartRequest {
    private Integer cartId;
    private Integer productId;
}
