package com.finalProject.applianceStore.applianceStore.dtos.requests.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCartRequest {
    private Integer cartId;
    private String email;

}
