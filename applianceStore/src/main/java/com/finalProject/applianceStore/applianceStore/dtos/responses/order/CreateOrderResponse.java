package com.finalProject.applianceStore.applianceStore.dtos.responses.order;

import com.finalProject.applianceStore.applianceStore.dtos.responses.orderItem.OrderItemResponse;
import com.finalProject.applianceStore.applianceStore.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {
        private Integer cartId;
        private String email;
        private String paymentMethod;
        private List<OrderItemResponse> orderItems;

}
