package com.finalProject.applianceStore.applianceStore.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private String email;
    private Integer orderId;
    private String orderStatus;
}
