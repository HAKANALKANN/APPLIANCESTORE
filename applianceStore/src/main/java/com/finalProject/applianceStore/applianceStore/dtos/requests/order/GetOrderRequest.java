package com.finalProject.applianceStore.applianceStore.dtos.requests.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderRequest {
    private String email;
    private Integer orderId;
}
