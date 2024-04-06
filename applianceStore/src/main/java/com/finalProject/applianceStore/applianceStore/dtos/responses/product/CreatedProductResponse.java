package com.finalProject.applianceStore.applianceStore.dtos.responses.product;

import com.finalProject.applianceStore.applianceStore.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedProductResponse {
    private Integer productId;
    private Integer categoriesId;
    private String name;
    private Integer quantity;
    private String description;
    private long price;
    List<Product> products;
}
