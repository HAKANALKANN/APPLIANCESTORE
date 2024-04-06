package com.finalProject.applianceStore.applianceStore.dtos.responses.product;

import com.finalProject.applianceStore.applianceStore.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse {
    private Integer id;
    private Integer categoriesId;
    private String name;
    private Integer quantity;
    private String description;
    private long price;
    private String state;
    private List<Product> products;
}
