package com.finalProject.applianceStore.applianceStore.dtos.responses.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse {
        private String email;
        private Integer orderId;
}
