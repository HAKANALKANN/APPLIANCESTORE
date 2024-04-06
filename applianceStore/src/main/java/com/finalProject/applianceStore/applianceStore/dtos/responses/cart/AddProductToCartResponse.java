package com.finalProject.applianceStore.applianceStore.dtos.responses.cart;

import com.finalProject.applianceStore.applianceStore.dtos.responses.product.CreatedProductResponse;
import com.finalProject.applianceStore.applianceStore.dtos.responses.product.UpdateProductResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductToCartResponse {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private List<UpdateProductResponse> updateProductResponse;
}
