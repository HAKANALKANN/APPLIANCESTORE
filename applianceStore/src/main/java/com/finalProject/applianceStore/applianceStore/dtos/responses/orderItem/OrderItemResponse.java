package com.finalProject.applianceStore.applianceStore.dtos.responses.orderItem;

import com.finalProject.applianceStore.applianceStore.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {
        private Integer orderItemId;
        private Product product;
        private Integer quantity;
        private double discount;
        private double orderedProductPrice;
}
